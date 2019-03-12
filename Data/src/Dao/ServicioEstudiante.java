/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Entities.Alumno;
import Entities.Usuario;
import java.sql.CallableStatement;
import java.sql.Date;
import java.sql.SQLException;

/**
 *
 * @author Addiel
 */
public class ServicioEstudiante extends Service{
    private static final String INSERTARESTUDIANTE= "{call crearAlumno(?,?,?,?,?,?,?)}";
    private static final String MODIFICARESTUDIANTE= "{call modificarAlumno(?,?,?,?,?,?)}";
     public void insertarEstudiante(Alumno alumno, Usuario user) throws AccesoADatos.GlobalException, AccesoADatos.NoDataException, InstantiationException, IllegalAccessException  	{
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
            pstmt.setString(4, alumno.getEmail());
            pstmt.setDate(5, (Date) alumno.getFecha_nacimiento());
            pstmt.setInt(6,alumno.getCedula());
            pstmt.setString(7,user.getClave() );
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
     
     
     
      public void modificarEstudiante(Alumno alumno, Usuario user) throws AccesoADatos.GlobalException, AccesoADatos.NoDataException, InstantiationException, IllegalAccessException  	{
        try {
            conectar();
        } catch (ClassNotFoundException e) {
            throw new AccesoADatos.GlobalException("No se ha localizado el driver");
        } catch (SQLException e) {
            throw new AccesoADatos.NoDataException("La base de datos no se encuentra disponible");
        }
        CallableStatement pstmt=null;
        
        try {
            pstmt = conexion.prepareCall(MODIFICARESTUDIANTE);
            pstmt.setString(1,alumno.getNombre());
            pstmt.setInt(2,alumno.getEdad());
            pstmt.setString(3, alumno.getEmail());
            pstmt.setDate(4, (Date) alumno.getFecha_nacimiento());
            pstmt.setInt(5,alumno.getCedula());
            pstmt.setString(6,user.getClave() );
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
