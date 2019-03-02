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
    public Ciclo ciclo;
    public Curso curso;
    public int nrc;
    public String horario;
    public Profesor porfesor;

    public Grupo() {
    }

   
    public void setNrc(int nrc) {
        this.nrc = nrc;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public Ciclo getCiclo() {
        return ciclo;
    }

    public void setCiclo(Ciclo ciclo) {
        this.ciclo = ciclo;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public Profesor getPorfesor() {
        return porfesor;
    }

    public void setPorfesor(Profesor porfesor) {
        this.porfesor = porfesor;
    }

   
    
}
