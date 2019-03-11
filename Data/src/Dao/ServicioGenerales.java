/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Entities.Alumno;
import Entities.Carrera;
import Entities.Ciclo;
import Entities.Curso;
import Entities.Grupo;
import Entities.Rendimiento_grupo;
import java.sql.CallableStatement;
import java.sql.SQLException;

/**
 *
 * @author Addiel
 */
public class ServicioGenerales extends Service {
    private static final String REPORTENOTAS= "{call reporteNotas(?,?,?,?)}";
    private static final String MATRICULARCURSO= "{call hacerMtricula(?,?,?,?,?)}";
    private static final String GENERARPLANESTUDIO= "{call generarPlanEstudio(?,?,?,?)}";
    
     public void reportarNotas(Rendimiento_grupo rg) throws AccesoADatos.GlobalException, AccesoADatos.NoDataException, SQLException  	{
        try {
            conectar();
        } catch (ClassNotFoundException e) {
            throw new AccesoADatos.GlobalException("No se ha localizado el driver");
        } catch (SQLException e) {
            throw new AccesoADatos.NoDataException("La base de datos no se encuentra disponible");
        }
        CallableStatement pstmt=null;
        
        try {
            pstmt = conexion.prepareCall(REPORTENOTAS);
            pstmt.setInt(1,rg.getCurso().getCodigo());            
            pstmt.setInt(2,rg.getAlumno().getCedula());
            pstmt.setInt(3,rg.getProfesor().getCedula());
            pstmt.setInt(4, rg.getCalificacion());
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
     
    public void matricularCurso(Alumno a, Carrera c ,Curso cu,Grupo g, Ciclo cl) throws AccesoADatos.GlobalException, AccesoADatos.NoDataException, SQLException  	{
        try {
            conectar();
        } catch (ClassNotFoundException e) {
            throw new AccesoADatos.GlobalException("No se ha localizado el driver");
        } catch (SQLException e) {
            throw new AccesoADatos.NoDataException("La base de datos no se encuentra disponible");
        }
        CallableStatement pstmt=null;
        
        try {
            pstmt = conexion.prepareCall(MATRICULARCURSO);          
            pstmt.setInt(1,a.getCedula());
            pstmt.setInt(2,c.getCodigo());
            pstmt.setInt(3,cu.getCodigo());  
            pstmt.setInt(4,g.getNrc());
            pstmt.setInt(5, c.getCodigo());
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
    
    public void generarPlanEstudio(Carrera ca ,Curso cu, Ciclo cl) throws AccesoADatos.GlobalException, AccesoADatos.NoDataException, SQLException  	{
        try {
            conectar();
        } catch (ClassNotFoundException e) {
            throw new AccesoADatos.GlobalException("No se ha localizado el driver");
        } catch (SQLException e) {
            throw new AccesoADatos.NoDataException("La base de datos no se encuentra disponible");
        }
        CallableStatement pstmt=null;
        
        try {
            pstmt = conexion.prepareCall(GENERARPLANESTUDIO);          
            pstmt.setInt(1,ca.getCodigo());
            pstmt.setInt(2,cu.getCodigo());
            pstmt.setInt(3,cl.getCodigo());  
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
