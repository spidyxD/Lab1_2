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
import oracle.jdbc.OracleTypes;

/**
 *
 * @author Addiel
 */
public class ServicioProfesor extends Service{
    private static final String INSERTARPROFESOR= "{call crearProfesor(?,?,?,?,?,?)}";
    private static final String MODIFICARPROFESOR= "{call modificarProfesor(?,?,?,?,?,?)}";
    private static final String ELMINARPROFESOR= "{call eliminarProfesor(?)}";
    
      private Profesor tipoProfesor(ResultSet rs){
        try{
            Profesor p = new Profesor();
            p.setCedula(rs.getInt("cedula"));
            p.setEdad(rs.getInt("edad"));
            p.setEmail(rs.getString("email"));
            p.setTelefono(rs.getInt("telefono"));
            p.setNombre(rs.getString("nombre"));
            return p;
        }
        catch (SQLException ex) {
            return null;
        }
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
          //  pstmt.setInt(2,codigo);              
                System.out.println(rs);
                while(rs.next()){
                    profes.add(tipoProfesor(rs));
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
}
