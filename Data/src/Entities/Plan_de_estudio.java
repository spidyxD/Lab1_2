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
public class Plan_de_estudio {
    public Curso curso;
    public Carrera carrera;
    public int anno;
    public Ciclo ciclo;

    public Plan_de_estudio() {
    }

    public Plan_de_estudio(Curso curso, Carrera carrera, int anno, Ciclo ciclo) {
        this.curso = curso;
        this.carrera = carrera;
        this.anno = anno;
        this.ciclo = ciclo;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public Carrera getCarrera() {
        return carrera;
    }

    public void setCarrera(Carrera carrera) {
        this.carrera = carrera;
    }

    public int getAnno() {
        return anno;
    }

    public void setAnno(int anno) {
        this.anno = anno;
    }

    public Ciclo getCiclo() {
        return ciclo;
    }

    public void setCiclo(Ciclo ciclo) {
        this.ciclo = ciclo;
    }

   
}
