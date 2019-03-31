/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Entities.Curso;
import java.sql.CallableStatement;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Addiel
 */
public class ServicioCursos extends Service {
     private static final String CREARCURSO= "{call crearCurso(?,?,?,?)}";
     private static final String MODIFICARCURSO= "{call modificarCurso(?,?,?)}";
     private static final String ELIMINARCURSO= "{call eliminarCurso(?)}";
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
     
     public void eliminarCurso(int codigo) throws AccesoADatos.GlobalException, AccesoADatos.NoDataException, SQLException, InstantiationException, IllegalAccessException  	{
        try {
            conectar();
        } catch (ClassNotFoundException e) {
            throw new AccesoADatos.GlobalException("No se ha localizado el driver");
        } catch (SQLException e) {
            throw new AccesoADatos.NoDataException("La base de datos no se encuentra disponible");
        }
        CallableStatement pstmt=null;
        
        try {
            pstmt = conexion.prepareCall(ELIMINARCURSO);          
            pstmt.setInt(1,codigo);
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
            cursos = (ArrayList) conexion.prepareCall("SELECT * FROM Profesor;");
           
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
