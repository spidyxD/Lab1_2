/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author Addiel
 */
public class Service {
     protected Connection conexion= null;
     public Service() {
        
    }
    
    protected void conectar() throws SQLException,ClassNotFoundException, InstantiationException, IllegalAccessException 
    {
            Class.forName("oracle.jdbc.OracleDriver").newInstance();
            conexion = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","sys as sysdba","k1n9r4d2");    
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
    
    public boolean doLogin(int user, String password){
        return true;
    }
}
