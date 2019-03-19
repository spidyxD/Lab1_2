/*
 * Serviciocontacto.java
 *
 * Created on 27 de abril de 2007, 10:41 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package AccesoDatos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.CallableStatement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Collection;
import logicaNegocio.contactos;
import oracle.jdbc.driver.OracleTypes;
/**
 *
 * @author Estudiante
 */
public class ServicioContacto extends Servicio {
     
     private static final String INSERTARcontactos = "{call insertarcontactos(?,?,?,?,?,?,?,?,?,?,?)}";
     private static final String BUSCARcontactos = "{?=call buscarcontactos(?)}";
     private static final String Eliminarcontactos = "{?=call eliminarcontactos(?)}";
     private static final String ACTUALIZARcontactos ="{call modificarcontactos(?,?,?,?,?,?,?,?,?,?,?)}";    
    /**
     * Creates a new instance of Serviciocontacto
     */
    public ServicioContacto() {
    }
    
   
    public boolean insertarcontactoss(contactos elcontacto) throws GlobalException, NoDataException  	{
        boolean resp=true;
        try {
            conectar();
        } catch (ClassNotFoundException e) {
            resp=false;
            throw new GlobalException("No se ha localizado el driver");
        } catch (SQLException e) {
            resp=false;
            throw new NoDataException("La base de datos no se encuentra disponible");
        }
         CallableStatement pstmt=null;  
                                
        try {
            pstmt = conexion.prepareCall(INSERTARcontactos);                                    
            pstmt.setString(1,elcontacto.getId());
            pstmt.setString(2,elcontacto.getCedula());
            pstmt.setString(3,elcontacto.getNombre());
            pstmt.setString(4,elcontacto.getOrganizacionPertenece());
            pstmt.setString(5,elcontacto.getDireccion());
            pstmt.setString(6,elcontacto.getCargo());
		pstmt.setString(7,elcontacto.getEmail());
		pstmt.setString(8,elcontacto.getTelefonoTrabajo());
		pstmt.setString(9,elcontacto.getTelefonoCasa());
		pstmt.setString(10,elcontacto.getTelefonoCelular());
		pstmt.setString(11,elcontacto.getFax());
            boolean resultado = pstmt.execute();
            if (resultado == true) {
                resp=false;
                throw new NoDataException ("No se realizo la inserción");
            } 
            
        } catch (SQLException e) {
            e.printStackTrace();
            resp=false;
            throw new GlobalException("Llave duplicada");
        } 
         finally {
            try {
                if (pstmt != null) {
                    pstmt.close();                    
                }
                desconectar();
            } catch (SQLException e) {
                resp=false;
                throw new GlobalException("Estatutos invalidos o nulos");
            }
        }
         return resp;
    }
    
    public void actualizarcontactoss(contactos elcontacto ) throws GlobalException, NoDataException  {
        try {
            conectar();
        } catch (ClassNotFoundException e) {
            throw new GlobalException("No se ha localizado el driver");
        } catch (SQLException e) {
            throw new NoDataException("La base de datos no se encuentra disponible");
        }
        PreparedStatement pstmt = null;
        try {
            pstmt = conexion.prepareStatement(ACTUALIZARcontactos);
            pstmt.setString(1,elcontacto.getId());
            pstmt.setString(2,elcontacto.getCedula());
            pstmt.setString(3,elcontacto.getNombre());
            pstmt.setString(4,elcontacto.getOrganizacionPertenece());
            pstmt.setString(5,elcontacto.getDireccion());
            pstmt.setString(6,elcontacto.getCargo());
		pstmt.setString(7,elcontacto.getEmail());
		pstmt.setString(8,elcontacto.getTelefonoTrabajo());
		pstmt.setString(9,elcontacto.getTelefonoCasa());
		pstmt.setString(10,elcontacto.getTelefonoCelular());
		pstmt.setString(11,elcontacto.getFax());

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
    
    public contactos buscarcontactos(String id ) throws GlobalException, NoDataException  {
     
    try {
            conectar();
        } catch (ClassNotFoundException e) {
            throw new GlobalException("No se ha localizado el driver");
        } catch (SQLException e) {
            throw new NoDataException("La base de datos no se encuentra disponible");
        }
        ResultSet rs = null;
        ArrayList coleccion = new ArrayList();
        contactos elcontacto = null;
        CallableStatement pstmt=null;  
        try {            
            pstmt = conexion.prepareCall(BUSCARcontactos);            
            pstmt.registerOutParameter(1, OracleTypes.CURSOR);            
            pstmt.setString(2,id);            
            pstmt.execute();
            rs = (ResultSet)pstmt.getObject(1); 
            while (rs.next()) {
                elcontacto = new contactos(rs.getString("id"),
                                       rs.getString("cedula"),
                                       rs.getString("nombre"),
                                       rs.getString("oraganizacion"),
                                       rs.getString("direccion"),
                                       rs.getString("cargo"),
                                       rs.getString("email"),
                                       rs.getString("telefonoTrabajo"),
						   rs.getString("telefonoCasa"),
						   rs.getString("telefonoCelular"),
						   rs.getString("fax")
						   );
                coleccion.add(elcontacto);
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
        return elcontacto;
 }
  public contactos eliminarcontactos(String id ) throws GlobalException, NoDataException  {
     
    try {
            conectar();
        } catch (ClassNotFoundException e) {
            throw new GlobalException("No se ha localizado el driver");
        } catch (SQLException e) {
            throw new NoDataException("La base de datos no se encuentra disponible");
        }
        ResultSet rs = null;     
        ArrayList coleccion = new ArrayList();
        contactos elcontacto = null;
        CallableStatement pstmt=null;  
        try {            
            pstmt = conexion.prepareCall(Eliminarcontactos);            
            pstmt.registerOutParameter(1, OracleTypes.CURSOR);            
            pstmt.setString(2,id);            
            pstmt.execute();
          
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
        return elcontacto;
 }

}
