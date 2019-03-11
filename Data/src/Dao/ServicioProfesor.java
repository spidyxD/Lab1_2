/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Entities.Profesor;
import Entities.Usuario;
import java.sql.CallableStatement;
import java.sql.SQLException;

/**
 *
 * @author Addiel
 */
public class ServicioProfesor extends Service{
    private static final String INSERTARPROFESOR= "{call crearProfesor(?,?,?,?,?,?)}";
    private static final String MODIFICARPROFESOR= "{call modificarProfesor(?,?,?,?,?,?)}";
    public void insertarProfesor(Profesor profesor, Usuario user) throws AccesoADatos.GlobalException, AccesoADatos.NoDataException  	{
        try {
            conectar();
        } catch (ClassNotFoundException e) {
            throw new AccesoADatos.GlobalException("No se ha localizado el driver");
        } catch (SQLException e) {
            throw new AccesoADatos.NoDataException("La base de datos no se encuentra disponible");
        }
        CallableStatement pstmt=null;
        
        try {
            pstmt = conexion.prepareCall(INSERTARPROFESOR);
            pstmt.setInt(1,profesor.getCedula());
            pstmt.setString(2,profesor.getNombre());
            pstmt.setInt(3,profesor.getEdad());
            pstmt.setString(4, profesor.getEmail());
            pstmt.setInt(5, profesor.getTelefono());
            pstmt.setInt(6,profesor.getCedula());
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
     
     
     
      public void modificarProfesor(Profesor profesor, Usuario user) throws AccesoADatos.GlobalException, AccesoADatos.NoDataException  	{
        try {
            conectar();
        } catch (ClassNotFoundException e) {
            throw new AccesoADatos.GlobalException("No se ha localizado el driver");
        } catch (SQLException e) {
            throw new AccesoADatos.NoDataException("La base de datos no se encuentra disponible");
        }
        CallableStatement pstmt=null;
        
        try {
            pstmt = conexion.prepareCall(MODIFICARPROFESOR);
            pstmt.setString(1,profesor.getNombre());
            pstmt.setInt(2,profesor.getEdad());
            pstmt.setString(3, profesor.getEmail());
            pstmt.setInt(4, profesor.getTelefono());
            pstmt.setInt(5,profesor.getCedula());
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
