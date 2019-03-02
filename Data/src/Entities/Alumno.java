/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.util.Date;

/**
 *
 * @author Addiel
 */
public class Alumno extends Persona{
  public  Date fecha_nacimiento;

    public Alumno() {
    }

    public Alumno(Date fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public Alumno(Date fecha_nacimiento, String nombre, String cedula, String email, int userN) {
        super(nombre, cedula, email, userN);
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public Date getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(Date fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
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
