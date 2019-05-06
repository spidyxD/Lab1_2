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
public class Alumno extends Persona{
  public  String fechaN;
  Carrera carrera = new Carrera();
  int creditos ;
    public Alumno() {
    }
  

    public Alumno(String fechaN) {
        this.fechaN = fechaN;
    }

    public int getCreditos() {
        return this.creditos;
    }

    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }

    public Alumno(String fechaN, String nombre, int cedula, String email) {
        super(nombre, cedula, email);
        this.fechaN = fechaN;
    }

    public String getFecha_nacimiento() {
        return this.fechaN;
    }

    public void setFecha_nacimiento(String fechaN) {
        this.fechaN = fechaN;
    }

    public Carrera getCarrera() {
        return this.carrera;
    }

    public void setCarrera(Carrera carrera) {
        this.carrera = carrera;
    }

  @Override
    public String getNombre() {
        return this.nombre;
    }

  @Override
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

  @Override
    public int getCedula() {
        return this.cedula;
    }

  @Override
    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

  @Override
    public String getEmail() {
        return this.email;
    }

  @Override
    public void setEmail(String email) {
        this.email = email;
    }
    @Override
    public int getTelefono() {
        return telefono;
    }
    @Override
    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }
    
}
