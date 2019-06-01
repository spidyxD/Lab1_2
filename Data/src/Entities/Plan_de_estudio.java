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
    public Curso curso = new Curso();
    public Carrera carrera = new Carrera();
    public int anno ;
    public Ciclo ciclo = new Ciclo();

    public Plan_de_estudio() {
    }

    public Plan_de_estudio(Curso curso, Carrera carrera, int anno, Ciclo ciclo) {
        this.curso = curso;
        this.carrera = carrera;
        this.anno = anno;
        this.ciclo = ciclo;
    }

    public Curso getCurso() {
        return this.curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public Carrera getCarrera() {
        return this.carrera;
    }

    public void setCarrera(Carrera carrera) {
        this.carrera = carrera;
    }

    public int getAnno() {
        return this.anno;
    }

    public void setAnno(int anno) {
        this.anno = anno;
    }

    public Ciclo getCiclo() {
        return this.ciclo;
    }

    public void setCiclo(Ciclo ciclo) {
        this.ciclo = ciclo;
    }

   
}
