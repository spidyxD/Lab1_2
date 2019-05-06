/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Entities.Curso;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Addiel
 */
public class ServicioCursos extends Service {
     private static final String CREARCURSO= "{call crearCurso(?,?,?,?)}";
     private static final String MODIFICARCURSO= "{call modificarCurso(?,?,?)}";
     private static ServicioCursos uniqueInstance;
     public static ServicioCursos instance(){
        if (uniqueInstance == null){
            uniqueInstance = new ServicioCursos();
        }
        return uniqueInstance;
    }
     
     public void crearCurso(int xcodigo, String xnombre, int xcreditos, int xhoras) throws AccesoADatos.GlobalException, AccesoADatos.NoDataException, SQLException, InstantiationException, IllegalAccessException  	{
        try {
            conectar();
        } catch (ClassNotFoundException e) {
            throw new AccesoADatos.GlobalException("No se ha localizado el driver");
        } catch (SQLException e) {
            throw new AccesoADatos.NoDataException("La base de datos no se encuentra disponible");
        }
        CallableStatement pstmt=null;
        
        try {
            pstmt = conexion.prepareCall(CREARCURSO);          
            pstmt.setInt(1,xcodigo);
            pstmt.setString(2,xnombre);
            pstmt.setInt(3,xcreditos);  
            pstmt.setInt(4,xhoras);  
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
     public void modificarCurso(String xnombre, int xcreditos, int xhoras) throws AccesoADatos.GlobalException, AccesoADatos.NoDataException, SQLException, InstantiationException, IllegalAccessException  	{
        try {
            conectar();
        } catch (ClassNotFoundException e) {
            throw new AccesoADatos.GlobalException("No se ha localizado el driver");
        } catch (SQLException e) {
            throw new AccesoADatos.NoDataException("La base de datos no se encuentra disponible");
        }
        CallableStatement pstmt=null;
        
        try {
            pstmt = conexion.prepareCall(MODIFICARCURSO);          
            pstmt.setString(1,xnombre);
            pstmt.setInt(2,xcreditos);  
            pstmt.setInt(3,xhoras);  
            boolean resultado = pstmt.execute();
            if (resultado == true) {
                throw new AccesoADatos.NoDataException("No se realizo la actualizacion");
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
     public ArrayList<Curso> verCursos() throws AccesoADatos.GlobalException, AccesoADatos.NoDataException, InstantiationException, IllegalAccessException  	{
        try {
            conectar();
        } catch (ClassNotFoundException e) {
            throw new AccesoADatos.GlobalException("No se ha localizado el driver");
        } catch (SQLException e) {
            throw new AccesoADatos.NoDataException("La base de datos no se encuentra disponible");
        }
        CallableStatement pstmt=null;
        
        try {
            ArrayList<Curso> cursos = new ArrayList<>();     
            Statement stmt = conexion.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Curso"); 
            ServicioBusquedas sb = new ServicioBusquedas();
          //  pstmt.setInt(2,codigo);      
                while(rs.next()){
                    cursos.add(sb.tipoCurso(rs));
                }
            return cursos;
            
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
