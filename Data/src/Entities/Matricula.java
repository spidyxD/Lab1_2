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
    public Alumno student = new Alumno();
    public Carrera major = new Carrera();
    public Curso course = new Curso();
    public Profesor teacher = new Profesor();
    public Ciclo cycle = new Ciclo();
    public Grupo grupo = new Grupo();

    public Matricula() {
    }

    public Grupo getGrupo() {
        return this.grupo;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }

    public Matricula(Alumno student, Carrera major, Curso course, Profesor teacher, Ciclo cycle) {
        this.student = student;
        this.major = major;
        this.course = course;
        this.teacher = teacher;
        this.cycle = cycle;
    }

    public Alumno getStudent() {
        return this.student;
    }

    public void setStudent(Alumno student) {
        this.student = student;
    }

    public Carrera getMajor() {
        return this.major;
    }

    public void setMajor(Carrera major) {
        this.major = major;
    }

    public Curso getCourse() {
        return this.course;
    }

    public void setCourse(Curso course) {
        this.course = course;
    }

    public Profesor getTeacher() {
        return this.teacher;
    }

    public void setTeacher(Profesor teacher) {
        this.teacher = teacher;
    }

    public Ciclo getCycle() {
        return this.cycle;
    }

    public void setCycle(Ciclo cycle) {
        this.cycle = cycle;
    }

    @Override
    public String toString() {
        return this.course.getNombre() + " "  + " " + this.course.getCreditos() + " " + this.grupo.getHorario() + " "+ this.grupo.getNrc() ;
    }
    
    
}
