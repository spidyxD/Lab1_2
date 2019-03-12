/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import java.sql.CallableStatement;
import java.sql.SQLException;

/**
 *
 * @author Addiel
 */
public class ServicioBusquedas extends Service{
    private static final String BUSCARCURSOID= "{call buscar_curso_id(?)}";
    private static final String BUSCARCURSONOMBRE= "{call buscar_curso_nombre(?)}";
    private static final String BUSCARCARRERA= "{call buscar_curso_carrera(?)}";
    private static final String BUSCARPROFCEDULA= "{call buscar_Profesor_cedula(?)}";
    private static final String BUSCARALUMCEDULA= "{call buscar_Alumno_ced(?)}";
    
    public void buscarCursoId(int xcodigo) throws AccesoADatos.GlobalException, AccesoADatos.NoDataException, SQLException  	{
        try {
            conectar();
        } catch (ClassNotFoundException e) {
            throw new AccesoADatos.GlobalException("No se ha localizado el driver");
        } catch (SQLException e) {
            throw new AccesoADatos.NoDataException("La base de datos no se encuentra disponible");
        }
        CallableStatement pstmt=null;
        
        try {
            pstmt = conexion.prepareCall(BUSCARCURSOID);          
            pstmt.setInt(1,xcodigo);
            boolean resultado = pstmt.execute();
            if (resultado == true) {
                throw new AccesoADatos.NoDataException("No se realizo la inserci�n");
            }
            
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
        
        public void buscarCursoNombre(String xnombre) throws AccesoADatos.GlobalException, AccesoADatos.NoDataException, SQLException  	{
        try {
            conectar();
        } catch (ClassNotFoundException e) {
            throw new AccesoADatos.GlobalException("No se ha localizado el driver");
        } catch (SQLException e) {
            throw new AccesoADatos.NoDataException("La base de datos no se encuentra disponible");
        }
        CallableStatement pstmt=null;
        
        try {
            pstmt = conexion.prepareCall(BUSCARCURSONOMBRE);          
            pstmt.setString(1,xnombre);
            boolean resultado = pstmt.execute();
            if (resultado == true) {
                throw new AccesoADatos.NoDataException("No se realizo la inserci�n");
            }
            
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
        
     public void buscarCarreraId(int codigo) throws AccesoADatos.GlobalException, AccesoADatos.NoDataException, SQLException  	{
        try {
            conectar();
        } catch (ClassNotFoundException e) {
            throw new AccesoADatos.GlobalException("No se ha localizado el driver");
        } catch (SQLException e) {
            throw new AccesoADatos.NoDataException("La base de datos no se encuentra disponible");
        }
        CallableStatement pstmt=null;
        
        try {
            pstmt = conexion.prepareCall(BUSCARCARRERA);          
            pstmt.setInt(1,codigo);
            boolean resultado = pstmt.execute();
            if (resultado == true) {
                throw new AccesoADatos.NoDataException("No se realizo la inserci�n");
            }
            
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
     
    
    public void buscarProfeId(int id) throws AccesoADatos.GlobalException, AccesoADatos.NoDataException, SQLException  	{
        try {
            conectar();
        } catch (ClassNotFoundException e) {
            throw new AccesoADatos.GlobalException("No se ha localizado el driver");
        } catch (SQLException e) {
            throw new AccesoADatos.NoDataException("La base de datos no se encuentra disponible");
        }
        CallableStatement pstmt=null;
        
        try {
            pstmt = conexion.prepareCall(BUSCARPROFCEDULA);          
            pstmt.setInt(1,id);
            boolean resultado = pstmt.execute();
            if (resultado == true) {
                throw new AccesoADatos.NoDataException("No se realizo la inserci�n");
            }
            
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
    
    public void buscarAlumnoId(int id) throws AccesoADatos.GlobalException, AccesoADatos.NoDataException, SQLException  	{
        try {
            conectar();
        } catch (ClassNotFoundException e) {
            throw new AccesoADatos.GlobalException("No se ha localizado el driver");
        } catch (SQLException e) {
            throw new AccesoADatos.NoDataException("La base de datos no se encuentra disponible");
        }
        CallableStatement pstmt=null;
        
        try {
            pstmt = conexion.prepareCall(BUSCARALUMCEDULA);          
            pstmt.setInt(1,id);
            boolean resultado = pstmt.execute();
            if (resultado == true) {
                throw new AccesoADatos.NoDataException("No se realizo la inserci�n");
            }
            
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
