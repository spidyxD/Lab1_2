/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

/**
 *
 * @author Addiel
 */
public class Usuario {
    public int username;
    public String clave;
    public String rol;

    public Usuario() {
    }

    public Usuario(int username, String clave, String rol) {
        this.username = username;
        this.clave = clave;
        this.rol = rol;
    }

    public int getUsername() {
        return this.username;
    }

    public void setUsername(int username) {
        this.username = username;
    }

    public String getClave() {
        return this.clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getRol() {
        return this.rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
    
    
}
