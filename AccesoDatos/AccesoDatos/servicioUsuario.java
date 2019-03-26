/*
 * servicioUsuario.java
 *
 * Created on 8 de septiembre de 2007, 10:12
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package AccesoDatos;

import java.sql.CallableStatement;
import java.sql.SQLException;
import logicaNegocio.usuario;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import oracle.jdbc.internal.OracleTypes;


/**
 *
 * @author Estudiante
 */
public class servicioUsuario extends Servicio{
    
    private static final String INSERTARUSUARIO = "{call insertarUsuario(?,?,?,?,?)}";
    private static final String LISTARUSUARIO = "{?=call listarUsuarios()}";
    private static final String ACTUALIZARUSUARIO ="{call actualizaUsuario(?,?,?,?,?)}";
    private static final String ELIMINARUSUARIO  = "{call eliminarUsuario(?)}";
    private static final String CONSULTARUSUARIO  = "{?=call consultarUsuario(?)}";
    
    
    /** Creates a new instance of servicioUsuario */
    public servicioUsuario() {
        
    }
    public void insertarUsuario(usuario elUsuario) throws GlobalException, NoDataException  	{
        try {
            conectar();
        } catch (ClassNotFoundException e) {
            throw new GlobalException("No se ha localizado el driver");
        } catch (SQLException e) {
            throw new NoDataException("La base de datos no se encuentra disponible");
        }
        CallableStatement pstmt=null;
        
        try {
            pstmt = conexion.prepareCall(INSERTARUSUARIO);
            pstmt.setString(1,elUsuario.getCedula());
            pstmt.setString(2,elUsuario.getNombre());
            pstmt.setString(3,elUsuario.getNombreUsuario());
            pstmt.setString(4,elUsuario.getContraseña());
            pstmt.setString(5,elUsuario.getPerfil());
            boolean resultado = pstmt.execute();
            if (resultado == true) {
                throw new NoDataException("No se realizo la inserción");
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
            throw new GlobalException("Llave duplicada");
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
                desconectar();
            } catch (SQLException e) {
                throw new GlobalException("Estatutos invalidos o nulos");
            }
        }
    }
    public Collection listarUsuarios() throws GlobalException, NoDataException{      
        try {
            conectar();      
        }
        catch(ClassNotFoundException ex)
        {
            throw new GlobalException("No se ha localizado el Driver");
        }
        
        catch (SQLException e) {
            throw new NoDataException("La base de datos no se encuentra disponible");
        }      
        
        ResultSet rs=null;
        ArrayList coleccion= new ArrayList();
        usuario elUsuario=null;
        CallableStatement pstmt=null;
        try{
            pstmt = conexion.prepareCall(LISTARUSUARIO);          
            pstmt.registerOutParameter(1,OracleTypes.CURSOR);
            pstmt.execute();
            rs = (ResultSet)pstmt.getObject(1); 
             while (rs.next()) {
                elUsuario = new usuario(rs.getString("cedula"),
                                        rs.getString("nombre"),
                                        rs.getString("nombreUsuario"),
                                        rs.getString("contraseña"),
                                        rs.getString("perfil"));
                coleccion.add(elUsuario);
            }
        } catch (SQLException e) {
          e.printStackTrace();
          
       throw new GlobalException("Sentencia no valida");
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pstmt != null) {
                    pstmt.close();
                }
                desconectar();
            } catch (SQLException e) {
                throw new GlobalException("Estatutos invalidos o nulos");
            }
        }
        if (coleccion == null || coleccion.size() == 0) {
            throw new NoDataException("No hay datos");
        }
        return coleccion;
    }
    public usuario consultarUsuario(String cedula) throws GlobalException, NoDataException  {
      try {
            conectar();      
        }
        catch(ClassNotFoundException ex)
        {
            throw new GlobalException("No se ha localizado el Driver");
        }
        
        catch (SQLException e) {
            throw new NoDataException("La base de datos no se encuentra disponible");
        }      
        
        ResultSet rs=null;
        usuario elUsuario=null;
        CallableStatement pstmt=null;
        try{
            pstmt = conexion.prepareCall(CONSULTARUSUARIO);          
            pstmt.registerOutParameter(1,OracleTypes.CURSOR);
            pstmt.setString(2,cedula);
            pstmt.execute();
            rs = (ResultSet)pstmt.getObject(1); 
             while (rs.next()) {
                 elUsuario = new usuario(rs.getString("cedula"),
                                        rs.getString("nombre"),
                                        rs.getString("nombreUsuario"),
                                        rs.getString("contraseña"),
                                        rs.getString("perfil"));
            }
        } catch (SQLException e) {
          e.printStackTrace();
          
       throw new GlobalException("Sentencia no valida");
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pstmt != null) {
                    pstmt.close();
                }
                desconectar();
            } catch (SQLException e) {
                throw new GlobalException("Estatutos invalidos o nulos");
            }
        }
        if (elUsuario== null) {
            throw new NoDataException("No hay datos");
        }
        return elUsuario;
   }
    public void actualizarUsuario(usuario elUsuario) throws GlobalException, NoDataException  {
        try {
            conectar();
        } catch (ClassNotFoundException e) {
            throw new GlobalException("No se ha localizado el driver");
        } catch (SQLException e) {
            throw new NoDataException("La base de datos no se encuentra disponible");
        }
        PreparedStatement pstmt = null;
        try {
            pstmt = conexion.prepareStatement(ACTUALIZARUSUARIO);
             pstmt.setString(1,elUsuario.getCedula());
            pstmt.setString(2,elUsuario.getNombre());
            pstmt.setString(3,elUsuario.getNombreUsuario());
            pstmt.setString(4,elUsuario.getContraseña());
            pstmt.setString(5,elUsuario.getPerfil());
            int resultado = pstmt.executeUpdate();
            
            //si es diferente de 0 es porq si afecto un registro o mas
            if (resultado != 0) {
                throw new NoDataException ("No se realizo la actualización");
            }
            else{
               System.out.println("\nModificación Satisfactoria!");
            }
        } catch (SQLException e) {
            throw new GlobalException("Sentencia no valida");
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
                desconectar();
            } catch (SQLException e) {
                throw new GlobalException("Estatutos invalidos o nulos");
            }
        }
    }     
    public void eliminarUsuario(String cedula) throws GlobalException, NoDataException  {
        try {
            conectar();
        } catch (ClassNotFoundException e) {
            throw new GlobalException("No se ha localizado el driver");
        } catch (SQLException e) {
            throw new NoDataException("La base de datos no se encuentra disponible");
        }
        PreparedStatement pstmt = null;
        try {
            pstmt = conexion.prepareStatement(ELIMINARUSUARIO);
            pstmt.setString(1,cedula);

            int resultado = pstmt.executeUpdate();
            
            if (resultado != 0) {
                throw new NoDataException ("No se realizo el borrado");
            }
            else{
               System.out.println("\nEliminación Satisfactoria!");
            }
        } catch (SQLException e) {
            throw new GlobalException("Sentencia no valida");
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
                desconectar();
            } catch (SQLException e) {
                throw new GlobalException("Estatutos invalidos o nulos");
            }
        }
    }  
}
