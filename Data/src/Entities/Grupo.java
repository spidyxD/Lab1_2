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
    public int ciclo ;
    public int curso ;
    public int nrc ;
    public String horario;
    public int porfesor;

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

    public int getCiclo() {
        return this.ciclo;
    }

    public void setCiclo(int ciclo) {
        this.ciclo = ciclo;
    }

    public int getCurso() {
        return this.curso;
    }

    public void setCurso(int curso) {
        this.curso = curso;
    }

    public int getPorfesor() {
        return this.porfesor;
    }

    public void setPorfesor(int porfesor) {
        this.porfesor = porfesor;
    }
    
    
 @Override
    public String toString() {
        return curso+ " " +  horario +" "+nrc;
    }
   
    
}
