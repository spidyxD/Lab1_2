/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Entities.Alumno;
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
public class ServicioEstudiante extends Service{
    private static final String INSERTARESTUDIANTE= "{call crearAlumno(?,?,?,?,?,?,?,?,?)}";
    private static final String MODIFICARESTUDIANTE= "{call modificarAlumno(?,?,?,?,?,?,?)}";
    private static final String MODIFICARESTUDIANTEADMIN= "{call modificarAlumnoAdmin(?,?,?,?,?,?,?)}";
    private static final String MODIFICARCORREOESTUDIANTE= "{call modificarCorreoAlumno(?)}";
    private static final String ELIMINARESTUDIANTE= "{call eliminarAlumno(?)}";
    private static ServicioEstudiante uniqueInstance;
    public static ServicioEstudiante instance(){
        if (uniqueInstance == null){
            uniqueInstance = new ServicioEstudiante();
        }
        return uniqueInstance;
    }
    
    public void insertarEstudiante(Alumno alumno, Usuario user, int carrera) throws AccesoADatos.GlobalException, AccesoADatos.NoDataException, InstantiationException, IllegalAccessException  	{
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
           pstmt.setString(5,alumno.getFecha_nacimiento());
           pstmt.setInt(6,alumno.getTelefono());
           pstmt.setInt(7,alumno.getCedula());
           pstmt.setString(8,user.getClave());
           pstmt.setInt(9,carrera);
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
    public void modificarCorreoEstudiante(String email) throws AccesoADatos.GlobalException, AccesoADatos.NoDataException, InstantiationException, IllegalAccessException  	{
       try {
           conectar();
       } catch (ClassNotFoundException e) {
           throw new AccesoADatos.GlobalException("No se ha localizado el driver");
       } catch (SQLException e) {
           throw new AccesoADatos.NoDataException("La base de datos no se encuentra disponible");
       }
       CallableStatement pstmt=null;

       try {
           pstmt = conexion.prepareCall(MODIFICARCORREOESTUDIANTE);
           pstmt.setString(1,email);
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
    public void modificarEstudiante(Alumno alumno, Usuario user) throws AccesoADatos.GlobalException, AccesoADatos.NoDataException, InstantiationException, IllegalAccessException, Exception  	{
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
           pstmt.setString(3,alumno.getEmail());
           pstmt.setString(4,alumno.getFecha_nacimiento());
           pstmt.setInt(5,alumno.getTelefono());
           pstmt.setInt(6,user.getUsername());
           pstmt.setString(7,user.getClave());
           int count = pstmt.executeUpdate();
           if (count < 0){
               throw new AccesoADatos.GlobalException("Error al actualizar informacion del alumno");
           }
        
       } catch (SQLException e) {
           e.printStackTrace();
           throw new AccesoADatos.GlobalException(e.getMessage());
       } finally {
           try {
               if (pstmt != null) {
                   pstmt.close();
               }
               desconectar();
           } catch (SQLException e) {
               throw new AccesoADatos.GlobalException(e.getMessage());
           }
       }
   }      
    public void eliminarEstudiante(int codigo) throws AccesoADatos.GlobalException, AccesoADatos.NoDataException, InstantiationException, IllegalAccessException  	{
       try {
           conectar();
       } catch (ClassNotFoundException e) {
           throw new AccesoADatos.GlobalException("No se ha localizado el driver");
       } catch (SQLException e) {
           throw new AccesoADatos.NoDataException("La base de datos no se encuentra disponible");
       }
       CallableStatement pstmt=null;

       try {
           pstmt = conexion.prepareCall(ELIMINARESTUDIANTE);
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
    public ArrayList<Alumno> verAlumnos() throws AccesoADatos.GlobalException, AccesoADatos.NoDataException, InstantiationException, IllegalAccessException  	{
        try {
            conectar();
        } catch (ClassNotFoundException e) {
            throw new AccesoADatos.GlobalException("No se ha localizado el driver");
        } catch (SQLException e) {
            throw new AccesoADatos.NoDataException("La base de datos no se encuentra disponible");
        }
        CallableStatement pstmt=null;
        
        try {
            ArrayList<Alumno> alumnos = new ArrayList<>();     
            Statement stmt = conexion.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Alumno"); 
            ServicioBusquedas sb = new ServicioBusquedas();
          //  pstmt.setInt(2,codigo);      
                while(rs.next()){
                    alumnos.add(sb.tipoAlumno(rs));
                }
            return alumnos;
            
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
    
     public void modificarEstudianteAdmin(Alumno alumno, int carrera) throws AccesoADatos.GlobalException, AccesoADatos.NoDataException, InstantiationException, IllegalAccessException, Exception  	{
       try {
           conectar();
       } catch (ClassNotFoundException e) {
           throw new AccesoADatos.GlobalException("No se ha localizado el driver");
       } catch (SQLException e) {
           throw new AccesoADatos.NoDataException("La base de datos no se encuentra disponible");
       }
       CallableStatement pstmt=null;
       
       try {
           pstmt = conexion.prepareCall(MODIFICARESTUDIANTEADMIN);
            pstmt.setInt(1,alumno.getCedula());
           pstmt.setString(2,alumno.getNombre());
           pstmt.setInt(3,alumno.getEdad());
           pstmt.setString(4,alumno.getEmail());
           pstmt.setString(5,alumno.getFecha_nacimiento());
           pstmt.setInt(6,alumno.getTelefono());          
           pstmt.setInt(7,carrera);
           int count = pstmt.executeUpdate();
           if (count < 0){
               throw new AccesoADatos.GlobalException("Error al actualizar informacion del alumno");
           }
        
       } catch (SQLException e) {
           e.printStackTrace();
           throw new AccesoADatos.GlobalException(e.getMessage());
       } finally {
           try {
               if (pstmt != null) {
                   pstmt.close();
               }
               desconectar();
           } catch (SQLException e) {
               throw new AccesoADatos.GlobalException(e.getMessage());
           }
       }
   }      
    
}
