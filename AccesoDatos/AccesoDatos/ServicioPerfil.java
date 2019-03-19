package AccesoDatos;

import logicaNegocio.perfil;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.CallableStatement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Collection;
import oracle.jdbc.driver.OracleTypes;
/**
 *
 * @author Estudiante
 */
public class ServicioPerfil extends Servicio {
     
     private static final String INSERTARPERFIL = "{call insertarPerfil (?,?,?,?,?)}";
     private static final String LISTAR = "{?=call listarPerfil()}";
     private static final String BUSCARPERFIL = "{?=call buscarPerfil(?)}";
     private static final String ACTUALIZARPERFIL ="{call modificarPerfil (?,?,?,?,?)}";
     private static final String ELIMINARPERFIL  = "{call eliminarPerfil(?)}";
    
    
    public ServicioPerfil() {
    }
    
    public Collection listar() throws GlobalException, NoDataException
    {      
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
        perfil elPerfil=null;
        CallableStatement pstmt=null;
        try{
            pstmt = conexion.prepareCall(LISTAR);          
            pstmt.registerOutParameter(1,OracleTypes.CURSOR);
            pstmt.execute();
            rs = (ResultSet)pstmt.getObject(1); 
             while (rs.next()) {
                elPerfil = new perfil(rs.getString("id"),
                                      rs.getString("descripcion"));      
                coleccion.add(elPerfil);
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
    
    public void insertarPerfil(perfil elPerfil) throws GlobalException, NoDataException  	{
        try {
            conectar();
        } catch (ClassNotFoundException e) {
            throw new GlobalException("No se ha localizado el driver");
        } catch (SQLException e) {
            throw new NoDataException("La base de datos no se encuentra disponible");
        }
         CallableStatement pstmt=null;  
                                
        try {
            pstmt = conexion.prepareCall(INSERTARPERFIL);                                    
            pstmt.setString(1,elPerfil.getId());
            pstmt.setString(2,elPerfil.getDescripcion());
            
            boolean resultado = pstmt.execute();
            if (resultado == true) {
                throw new NoDataException ("No se realizo la inserci�n");
            } 
            
        } catch (SQLException e) {
            e.printStackTrace();
            throw new GlobalException("Llave duplicada");
        } 
         finally {
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
    
    public void actualizarPerfil(perfil elPerfil) throws GlobalException, NoDataException  {
        try {
            conectar();
        } catch (ClassNotFoundException e) {
            throw new GlobalException("No se ha localizado el driver");
        } catch (SQLException e) {
            throw new NoDataException("La base de datos no se encuentra disponible");
        }
        PreparedStatement pstmt = null;
        try {
            pstmt = conexion.prepareCall(ACTUALIZARPERFIL);                                    
            pstmt.setString(1,elPerfil.getId());
            pstmt.setString(2,elPerfil.getDescripcion());
           
            int resultado = pstmt.executeUpdate();
            
            //si es diferente de 0 es porq si afecto un registro o mas
            if (resultado != 0) {
                throw new NoDataException ("No se realizo la actualizaci�n");
            }
            else{
               System.out.println("\nModificaci�n Satisfactoria!");
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
    
    public void eliminarPerfil(String id ) throws GlobalException, NoDataException  {
        try {
            conectar();
        } catch (ClassNotFoundException e) {
            throw new GlobalException("No se ha localizado el driver");
        } catch (SQLException e) {
            throw new NoDataException("La base de datos no se encuentra disponible");
        }
        PreparedStatement pstmt = null;
        try {
            pstmt = conexion.prepareStatement(ELIMINARPERFIL);
            pstmt.setString(1,"id");

            int resultado = pstmt.executeUpdate();
            
            if (resultado != 0) {
                throw new NoDataException ("No se realizo el borrado");
            }
            else{
               System.out.println("\nEliminaci�n Satisfactoria!");
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
    
    public perfil buscarPerfil(String id ) throws GlobalException, NoDataException  {
     
    try {
            conectar();
        } catch (ClassNotFoundException e) {
            throw new GlobalException("No se ha localizado el driver");
        } catch (SQLException e) {
            throw new NoDataException("La base de datos no se encuentra disponible");
        }
        ResultSet rs = null;
        ArrayList coleccion = new ArrayList();
        perfil elPerfil = null;
        CallableStatement pstmt=null;  
        try {            
            pstmt = conexion.prepareCall(BUSCARPERFIL);            
            pstmt.registerOutParameter(1, OracleTypes.CURSOR);            
            pstmt.setString(2,"id");            
            pstmt.execute();
            rs = (ResultSet)pstmt.getObject(1); 
            while (rs.next()) {
                elPerfil = new perfil(rs.getString("id"),
                                      rs.getString("descripcion"));
                coleccion.add(elPerfil);
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
        return elPerfil;
 }
    
}
