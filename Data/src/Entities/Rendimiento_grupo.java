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
    public Curso curso = new Curso();
    public Alumno alumno = new Alumno();
    public int calificacion ;
    public Profesor profesor = new Profesor();
    public Rendimiento_grupo() {
    }

    public Rendimiento_grupo(Curso curso, Alumno alumno, int calificacion) {
        this.curso = curso;
        this.alumno = alumno;
        this.calificacion = calificacion;
    }

    public Rendimiento_grupo(Curso curso, Alumno alumno, int calificacion, String nombre, int cedula, String email, int userN) {
        super(nombre, cedula, email);
        this.curso = curso;
        this.alumno = alumno;
        this.calificacion = calificacion;
    }

    public Curso getCurso() {
        return this.curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public Alumno getAlumno() {
        return this.alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public int getCalificacion() {
        return this.calificacion;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCedula() {
        return this.cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Profesor getProfesor() {
        return this.profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    
}
