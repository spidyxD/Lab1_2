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
public class Persona {
    public String nombre;
    public String cedula;
    public String email;
    public int userN;

    public Persona() {
    }

    public Persona(String nombre, String cedula, String email, int userN) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.email = email;
        this.userN = userN;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getUserN() {
        return userN;
    }

    public void setUserN(int userN) {
        this.userN = userN;
    }
    
}
