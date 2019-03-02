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
    public String username;
    public String clvae;
    public String rol;

    public Usuario() {
    }

    public Usuario(String username, String clvae, String rol) {
        this.username = username;
        this.clvae = clvae;
        this.rol = rol;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getClvae() {
        return clvae;
    }

    public void setClvae(String clvae) {
        this.clvae = clvae;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
    
    
}
