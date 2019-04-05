/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;



/**
 *
 * @author Addiel
 */
public class Alumno extends Persona{
  public  Date fecha_nacimiento;
  Carrera carrera = new Carrera();
  int creditos ;
    public Alumno() {
    }
  

    public Alumno(Date fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public int getCreditos() {
        return creditos;
    }

    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }

    public Alumno(Date fecha_nacimiento, String nombre, int cedula, String email, int userN) {
        super(nombre, cedula, email);
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public Date getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(Date fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public Carrera getCarrera() {
        return carrera;
    }

    public void setCarrera(Carrera carrera) {
        this.carrera = carrera;
    }

  @Override
    public String getNombre() {
        return nombre;
    }

  @Override
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

  @Override
    public int getCedula() {
        return cedula;
    }

  @Override
    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

  @Override
    public String getEmail() {
        return email;
    }

  @Override
    public void setEmail(String email) {
        this.email = email;
    }
    
}
