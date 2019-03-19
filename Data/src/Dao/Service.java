/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import AccesoADatos.GlobalException;
import AccesoADatos.NoDataException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import oracle.jdbc.OracleTypes;

/**
 *
 * @author Addiel
 */
public class Service {
     private static final String DOLOGIN= "{?= call login(?,?)}";
     private static final String login = "{?=call login(?,?)}";
     protected Connection conexion= null;
     public Service() {
        
    }
    
    protected void conectar() throws SQLException,ClassNotFoundException, InstantiationException, IllegalAccessException 
    {
            Class.forName("oracle.jdbc.OracleDriver").newInstance();
            conexion = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","hr");    
    }
    
    protected void desconectar() throws SQLException{
        if(!conexion.isClosed())
        {
            conexion.close();
        }
    }

    private Connection getJdbcMydbsource() throws NamingException {
        Context c = new InitialContext();
        try {
            return ((DataSource) c.lookup("jdbc/Mydbsource")).getConnection();
        } catch (NamingException | SQLException ex) {
        }
        return null;
    }
    
    public void doLogin(int user, String password) throws InstantiationException, IllegalAccessException, GlobalException, NoDataException{
                try {
            conectar();
        } catch (ClassNotFoundException e) {
            throw new AccesoADatos.GlobalException("No se ha localizado el driver");
        } catch (SQLException e) {
            throw new AccesoADatos.NoDataException("La base de datos no se encuentra disponible");
        }
        CallableStatement pstmt=null;
        
        try {
            pstmt = conexion.prepareCall("{?=call login(?,?)}");
            pstmt.setInt(2,user);
            pstmt.setString(3,password);
            pstmt.registerOutParameter(1, OracleTypes.CURSOR);
             boolean exec= pstmt.execute();    
             ResultSet rs = (ResultSet) pstmt.getObject(1);  
                while(rs.next()){
                    System.out.println(rs.getInt("exist"));
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
      public boolean loginCliente(int user, String password) throws NoDataException, GlobalException, InstantiationException, IllegalAccessException{
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
        ResultSet rs = null;
        CallableStatement pstmt=null;  
        int respuesta=0;
        try {            
            pstmt = conexion.prepareCall(login);            
            pstmt.registerOutParameter(1, OracleTypes.CURSOR);            
            pstmt.setInt(2,user);     
            pstmt.setString(3,password);            
            pstmt.execute();
            
            //********************************
            rs=(ResultSet) pstmt.getObject(1);
            while (rs.next()) {
             respuesta = rs.getInt("exist");
            }
             if(respuesta==0){
             resp=false;}
            //********************************
        } catch (SQLException e) {
          e.printStackTrace();
            resp=false;
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
                resp=false;
                throw new GlobalException("Estatutos invalidos o nulos");
            }
        }
        
        return resp;
        
    }
     
}
