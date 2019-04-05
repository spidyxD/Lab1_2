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
        return grupo;
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
        return student;
    }

    public void setStudent(Alumno student) {
        this.student = student;
    }

    public Carrera getMajor() {
        return major;
    }

    public void setMajor(Carrera major) {
        this.major = major;
    }

    public Curso getCourse() {
        return course;
    }

    public void setCourse(Curso course) {
        this.course = course;
    }

    public Profesor getTeacher() {
        return teacher;
    }

    public void setTeacher(Profesor teacher) {
        this.teacher = teacher;
    }

    public Ciclo getCycle() {
        return cycle;
    }

    public void setCycle(Ciclo cycle) {
        this.cycle = cycle;
    }

    @Override
    public String toString() {
        return course.getNombre() + " "  + " " + course.getCreditos() + " " + grupo.getHorario() + " "+grupo.getNrc() ;
    }
    
    
}
