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
public class Rendimiento_grupo extends Persona{
    public int curso;
    public int alumno;
    public float calificacion;
    public Profesor profesor;
    public Rendimiento_grupo() {
    }

    public Rendimiento_grupo(int curso, int alumno, float calificacion) {
        this.curso = curso;
        this.alumno = alumno;
        this.calificacion = calificacion;
    }

    public Rendimiento_grupo(int curso, int alumno, float calificacion, String nombre, String cedula, String email, int userN) {
        super(nombre, cedula, email);
        this.curso = curso;
        this.alumno = alumno;
        this.calificacion = calificacion;
    }

    public int getCurso() {
        return curso;
    }

    public void setCurso(int curso) {
        this.curso = curso;
    }

    public int getAlumno() {
        return alumno;
    }

    public void setAlumno(int alumno) {
        this.alumno = alumno;
    }

    public float getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(float calificacion) {
        this.calificacion = calificacion;
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

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    
}
