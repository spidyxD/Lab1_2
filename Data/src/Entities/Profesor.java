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
public class Profesor extends Persona
{

    public Profesor() {
    }

    public Profesor(int telefono, String nombre, int cedula, String email, int userN,String correo) {
        super(nombre, cedula, email);
        this.telefono = telefono;
    }
    @Override
    public int getTelefono() {
        return this.telefono;
    }
    @Override
    public void setTelefono(int telefono) {
        this.telefono = telefono;
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
    public int getEdad() {
        return this.edad;
    }
    @Override
    public void setEdad(int Edad) {
        this.edad = Edad;
    }
    
}
