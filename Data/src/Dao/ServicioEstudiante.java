/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Entities.Alumno;
import java.sql.CallableStatement;
import java.sql.SQLException;

/**
 *
 * @author Addiel
 */
public class ServicioEstudiante extends Service{
    private static final String INSERTARESTUDIANTE= "{call crearAlumno(?,?,?,?,?,?)}";
     public void insertarEstudiante(Alumno alumno) throws AccesoADatos.GlobalException, AccesoADatos.NoDataException  	{
        try {
            conectar();
        } catch (ClassNotFoundException e) {
            throw new AccesoADatos.GlobalException("No se ha localizado el driver");
        } catch (SQLException e) {
            throw new AccesoADatos.NoDataException("La base de datos no se encuentra disponible");
        }
        CallableStatement pstmt=null;
        
        try {
            pstmt = conexion.prepareCall(INSERTARESTUDIANTE);
            pstmt.setInt(1,alumno.getCedula());
            pstmt.setString(2,alumno.getNombre());
            pstmt.setInt(3,alumno.getEdad());
            boolean resultado = pstmt.execute();
            if (resultado == true) {
                throw new AccesoADatos.NoDataException("No se realizo la inserci�n");
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
            throw new AccesoADatos.GlobalException("Llave duplicada");
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
                desconectar();
            } catch (SQLException e) {
                throw new AccesoADatos.GlobalException("Estatutos invalidos o nulos");
            }
        }
    }
}
