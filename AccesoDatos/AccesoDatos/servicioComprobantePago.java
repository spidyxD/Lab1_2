/*
 * servicioComprobantePago.java
 *
 * Created on 21 de septiembre de 2007, 10:23 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package AccesoDatos;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import logicaNegocio.ComprobantePago;
import oracle.jdbc.driver.OracleTypes;

/**
 *
 * @author Administrador
 */


public class servicioComprobantePago extends Servicio {
    
    /** Creates a new instance of servicioComprobantePago */
    
     private static final String INSERTARCOMPROBANTEPAGO = "{call insertarComprobantePago(?,?,?,?,?,?,?,?,?,?,?,?)}";
     private static final String LISTARCOMPROBANTESPAGO = "{?=call listarComprobantePago()}";
     private static final String ACTUALIZARCOMPROBANTEPAGO ="{call modificaComprobantePago(?,?,?,?,?,?,?,?,?,?,?,?)}";
     private static final String ELIMINARCOMPROBANTEPAGO  = "{call eliminarComprobantePago(?)}";
     private static final String CONSULTARCOMPROBANTEPAGO  = "{?=call buscarComprobantePago(?)}";
     
    public servicioComprobantePago() {
    }
    
    public void insertarComprobantePago(ComprobantePago elComprobante) throws GlobalException, NoDataException
    {
        try {
            conectar();
        } catch (ClassNotFoundException e) {
            throw new GlobalException("No se ha localizado el driver");
        } catch (SQLException e) {
            throw new NoDataException("La base de datos no se encuentra disponible");
        }
         CallableStatement pstmt=null;
        
        try {
            
           pstmt = conexion.prepareCall(INSERTARCOMPROBANTEPAGO);;
           pstmt.setString(1,elComprobante.getId());
           pstmt.setString(2,elComprobante.getNombre());
           pstmt.setString(3,elComprobante.getCedula());
           String aux="";
           aux+=elComprobante.getPerfil();           
           pstmt.setString(4,aux);
           pstmt.setDouble(5,elComprobante.getSalarioBruto());
           pstmt.setDouble(6,elComprobante.getCcss());
           pstmt.setDouble(7,elComprobante.getBancoPopular());
           pstmt.setDouble(8,elComprobante.getIngresosAcumulados());
           pstmt.setString(9,elComprobante.getFechaIngreso());
           pstmt.setDouble(10,elComprobante.getVacDisfQuinc());
           pstmt.setDouble(11,elComprobante.getVacAcumAno());
           pstmt.setDouble(12,elComprobante.getVacDisfAno());
           
           
            boolean resultado = pstmt.execute();
            if (resultado == true) {
                throw new NoDataException ("No se realizo la inserción");
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
    
    public void actualizaClientes(ComprobantePago elComprobante) throws GlobalException, NoDataException  {
        try {
            conectar();
        } catch (ClassNotFoundException e) {
            throw new GlobalException("No se ha localizado el driver");
        } catch (SQLException e) {
            throw new NoDataException("La base de datos no se encuentra disponible");
        }
        PreparedStatement pstmt = null;
        try {
            
           pstmt = conexion.prepareStatement(ACTUALIZARCOMPROBANTEPAGO);
           pstmt.setString(1,elComprobante.getId());
           pstmt.setString(2,elComprobante.getNombre());
           pstmt.setString(3,elComprobante.getCedula());
           String aux="";
           aux+=elComprobante.getPerfil();           
           pstmt.setString(4,aux);
           pstmt.setDouble(5,elComprobante.getSalarioBruto());
           pstmt.setDouble(6,elComprobante.getCcss());
           pstmt.setDouble(7,elComprobante.getBancoPopular());
           pstmt.setDouble(8,elComprobante.getIngresosAcumulados());
           pstmt.setString(9,elComprobante.getFechaIngreso());
           pstmt.setDouble(10,elComprobante.getVacDisfQuinc());
           pstmt.setDouble(11,elComprobante.getVacAcumAno());
           pstmt.setDouble(12,elComprobante.getVacDisfAno());
            
            
            int resultado = pstmt.executeUpdate();
            
            //si es diferente de 0 es porq si afecto un registro o mas
            if (resultado == 0) {
                throw new NoDataException ("No se realizo la actualización");
            }
            //else{
            //   System.out.println("\nModificación Satisfactoria!");
            //}
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
    
    public Collection listarComprobantePago() throws GlobalException, NoDataException {
        try {
            conectar();
        }catch (ClassNotFoundException ex){
            throw new GlobalException("No se ha localizado el driver");
        }catch (SQLException ex){
            throw new NoDataException("La base de datos no se encuentra disponible");
        }
        ResultSet rs = null;
        ArrayList coleccionComprobantes = new ArrayList();
        //cliente elCliente = null;
        CallableStatement pstmt= null;
        try {
                pstmt = conexion.prepareCall(LISTARCOMPROBANTESPAGO);
                pstmt.registerOutParameter(1, OracleTypes.CURSOR);
                pstmt.execute();
                rs = (ResultSet)pstmt.getObject(1);
                while (rs.next()) {
                    
                    ComprobantePago elComprobante = new ComprobantePago(rs.getString("id"),rs.getString("nombre"),rs.getString("cedula"),rs.getString("perfil").charAt(0),rs.getDouble("salarioBruto"),rs.getDouble("ingresosAcumulados"),rs.getString("fechaIngreso"),rs.getDouble("vacDisfQuinc"),rs.getDouble("vacAcumAno"),rs.getDouble("vacDisfAno"));                
                    coleccionComprobantes.add(elComprobante);
                }
        }
        catch (SQLException ex) {
            throw new GlobalException("Sentencia no valida");
        }
        finally {
            try {
                if (rs!=null) {
                    rs.close();
                }
                if (pstmt != null) {
                    pstmt.close();
                }
                desconectar();
            }
            catch(SQLException e)
            {
                throw new GlobalException("Estatutos invalidos o nulos");
            }
        }
        
        if (coleccionComprobantes == null || coleccionComprobantes.size()==0) {
            throw new NoDataException("No hay datos relacionados con el Comprobante de pago");
        }
        return coleccionComprobantes;
    
    }
    
    public ComprobantePago buscarComprobantePago(String id) throws GlobalException, NoDataException {
        try {
            conectar();
        }catch (ClassNotFoundException ex){
            throw new GlobalException("No se ha localizado el driver");
        }catch (SQLException ex){
            throw new NoDataException("La base de datos no se encuentra disponible");
        }
        ResultSet rs = null;
        ComprobantePago elComprobante = new ComprobantePago(" "," "," ",' ',0,0," ",0,0,0);

        CallableStatement pstmt= null;
        try {
            
                pstmt = conexion.prepareCall(CONSULTARCOMPROBANTEPAGO);
                pstmt.registerOutParameter(1, OracleTypes.CURSOR);
                pstmt.setString(2,id);
                pstmt.execute();
                rs = (ResultSet)pstmt.getObject(1);
                while (rs.next()) {
                    
                    elComprobante = new ComprobantePago(rs.getString("id"),rs.getString("nombre"),rs.getString("cedula"),rs.getString("perfil").charAt(0),rs.getDouble("salarioBruto"),rs.getDouble("ingresosAcumulados"),rs.getString("fechaIngreso"),rs.getDouble("vacDisfQuinc"),rs.getDouble("vacAcumAno"),rs.getDouble("vacDisfAno"));
                }
        }
        catch (SQLException ex) {
            throw new GlobalException("Sentencia no valida");
        }
        finally {
            try {
                if (rs!=null) {
                    rs.close();
                }
                if (pstmt != null) {
                    pstmt.close();
                }
                desconectar();
            }
            catch(SQLException e)
            {
                throw new GlobalException("Estatutos invalidos o nulos");
            }
        }
        return elComprobante;
    
    }
    
    public void eliminarComprobantePago(String id) throws GlobalException, NoDataException
    {
        try {
            conectar();
        } catch (ClassNotFoundException e) {
            throw new GlobalException("No se ha localizado el driver");
        } catch (SQLException e) {
            throw new NoDataException("La base de datos no se encuentra disponible");
        }
        PreparedStatement pstmt = null;
        try {
            pstmt = conexion.prepareStatement(ELIMINARCOMPROBANTEPAGO);
            pstmt.setString(1,id);
            int resultado = pstmt.executeUpdate();
            
            //si es igual a 0 es porq no sirvio
            if (resultado == 0) {
                throw new NoDataException ("No se pudo eliminar el Comprobante de pago");
            }
            else
            {
                throw new NoDataException ("Eliminacion satisfactoria");
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
