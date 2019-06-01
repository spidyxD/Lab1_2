/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Entities.Profesor;
import Entities.Usuario;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Addiel
 */
public class ServicioProfesor extends Service{
    private static final String INSERTARPROFESOR= "{call crearProfesor(?,?,?,?,?,?,?)}";
    private static final String MODIFICARPROFESOR= "{call modificarProfesor(?,?,?,?,?,?)}";
     private static final String MODIFICARPROFESORADMIN= "{call modificarProfesorAdmin(?,?,?,?,?)}";
    private static final String ELMINARPROFESOR= "{call eliminarProfesor(?)}";
    private static ServicioProfesor uniqueInstance;
    public static ServicioProfesor instance(){
        if (uniqueInstance == null){
            uniqueInstance = new ServicioProfesor();
        }
        return uniqueInstance;
    }
     
    public void insertarProfesor(Profesor profesor, Usuario user) throws AccesoADatos.GlobalException, AccesoADatos.NoDataException, InstantiationException, IllegalAccessException  	{
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
            pstmt.setInt(6,user.getUsername());
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
    public void modificarProfesor(Profesor profesor, Usuario user) throws AccesoADatos.GlobalException, AccesoADatos.NoDataException, InstantiationException, IllegalAccessException  	{
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
            pstmt.setInt(5,user.getUsername());
            pstmt.setString(6,user.getClave() );
            pstmt.executeUpdate();
           /*if (count < 0){
               throw new AccesoADatos.GlobalException("Error al actualizar informacion del alumno");
           }*/            
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
    public void eliminarProfesor(int codigo) throws AccesoADatos.GlobalException, AccesoADatos.NoDataException, InstantiationException, IllegalAccessException  	{
        try {
            conectar();
        } catch (ClassNotFoundException e) {
            throw new AccesoADatos.GlobalException("No se ha localizado el driver");
        } catch (SQLException e) {
            throw new AccesoADatos.NoDataException("La base de datos no se encuentra disponible");
        }
        CallableStatement pstmt=null;
        
        try {
            pstmt = conexion.prepareCall(ELMINARPROFESOR);
            pstmt.setInt(1,codigo);
           
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
    public ArrayList<Profesor> verProfesores() throws AccesoADatos.GlobalException, AccesoADatos.NoDataException, InstantiationException, IllegalAccessException  	{
        try {
            conectar();
        } catch (ClassNotFoundException e) {
            throw new AccesoADatos.GlobalException("No se ha localizado el driver");
        } catch (SQLException e) {
            throw new AccesoADatos.NoDataException("La base de datos no se encuentra disponible");
        }
        CallableStatement pstmt=null;
        
        try {
            ArrayList<Profesor> profes = new ArrayList<>();     
            Statement stmt = conexion.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Profesor");
             ServicioBusquedas sb = new ServicioBusquedas();
          //  pstmt.setInt(2,codigo);      
                while(rs.next()){
                    profes.add(sb.tipoProfesor(rs));
                }
            return profes;
            
        } catch (SQLException e) {
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
    
      public void modificarProfesorAdmin(Profesor profesor) throws AccesoADatos.GlobalException, AccesoADatos.NoDataException, InstantiationException, IllegalAccessException  	{
        try {
            conectar();
        } catch (ClassNotFoundException e) {
            throw new AccesoADatos.GlobalException("No se ha localizado el driver");
        } catch (SQLException e) {
            throw new AccesoADatos.NoDataException("La base de datos no se encuentra disponible");
        }
        CallableStatement pstmt=null;
        
        try {
            pstmt = conexion.prepareCall(MODIFICARPROFESORADMIN);
            pstmt.setInt(1,profesor.getCedula()); 
            pstmt.setString(2,profesor.getNombre());
            pstmt.setInt(3,profesor.getEdad());
            pstmt.setString(4, profesor.getEmail());
            pstmt.setInt(5, profesor.getTelefono());
                
            pstmt.executeUpdate();
           /*if (count < 0){
               throw new AccesoADatos.GlobalException("Error al actualizar informacion del alumno");
           }*/            
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
