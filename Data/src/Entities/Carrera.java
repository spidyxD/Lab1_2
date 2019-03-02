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
public class Carrera {
    public int codigo;
    public String nombre;
    public String titulo;
    public int alumno;

    public Carrera() {
    }

    public Carrera(int codigo, String nombre, String titulo, int alumno) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.titulo = titulo;
        this.alumno = alumno;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCreditos() {
        return titulo;
    }

    public void setCreditos(String titulo) {
        this.titulo = titulo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getAlumno() {
        return alumno;
    }

    public void setAlumno(int alumno) {
        this.alumno = alumno;
    }

  
    
    
}
