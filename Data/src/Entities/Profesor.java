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
    public int telefono;

    public Profesor() {
    }

    public Profesor(int telefono, String nombre, String cedula, String email, int userN) {
        super(nombre, cedula, email, userN);
        this.telefono = telefono;
    }
    
}
