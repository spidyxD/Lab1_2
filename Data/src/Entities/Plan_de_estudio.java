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
    public int curso;
    public int carrera;
    public int anno;
    public int ciclo;

    public Plan_de_estudio() {
    }

    public Plan_de_estudio(int curso, int carrera, int anno, int ciclo) {
        this.curso = curso;
        this.carrera = carrera;
        this.anno = anno;
        this.ciclo = ciclo;
    }

    public int getCurso() {
        return curso;
    }

    public void setCurso(int curso) {
        this.curso = curso;
    }

    public int getCarrera() {
        return carrera;
    }

    public void setCarrera(int carrera) {
        this.carrera = carrera;
    }

    public int getAnno() {
        return anno;
    }

    public void setAnno(int anno) {
        this.anno = anno;
    }

    public int getCiclo() {
        return ciclo;
    }

    public void setCiclo(int ciclo) {
        this.ciclo = ciclo;
    }
    
}
