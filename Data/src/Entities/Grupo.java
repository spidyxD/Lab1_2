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
public class Grupo {
    public int capacidad;
    public Ciclo ciclo = new Ciclo();
    public Curso curso = new Curso();
    public int nrc ;
    public String horario;
    public Profesor porfesor = new Profesor();

    public Grupo() {
    }

    public int getNrc() {
        return this.nrc;
    }

   
    public void setNrc(int nrc) {
        this.nrc = nrc;
    }

    public String getHorario() {
        return this.horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public int getCapacidad() {
        return this.capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public Ciclo getCiclo() {
        return this.ciclo;
    }

    public void setCiclo(Ciclo ciclo) {
        this.ciclo = ciclo;
    }

    public Curso getCurso() {
        return this.curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public Profesor getPorfesor() {
        return this.porfesor;
    }

    public void setPorfesor(Profesor porfesor) {
        this.porfesor = porfesor;
    }
    
    
 @Override
    public String toString() {
        return curso.getNombre() + " " + " " + curso.getCreditos() + " " + horario +" "+nrc;
    }
   
    
}
