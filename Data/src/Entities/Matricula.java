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
public class Matricula {
    public int student;
    public int major;
    public int course;
    public int cycle;
    public int grupo;

    public Matricula() {
    }

    public int getStudent() {
        return student;
    }

    public void setStudent(int student) {
        this.student = student;
    }

    public int getMajor() {
        return major;
    }

    public void setMajor(int major) {
        this.major = major;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public int getCycle() {
        return cycle;
    }

    public void setCycle(int cycle) {
        this.cycle = cycle;
    }

    public int getGrupo() {
        return grupo;
    }

    public void setGrupo(int grupo) {
        this.grupo = grupo;
    }

    public Matricula(int student, int major, int course, int cycle, int grupo) {
        this.student = student;
        this.major = major;
        this.course = course;
        this.cycle = cycle;
        this.grupo = grupo;
    }

  
    @Override
    public String toString() {
        return this.course + " " + this.grupo ;
    }
    
    
}
