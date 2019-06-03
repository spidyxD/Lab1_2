package lab04.Model;

import java.util.ArrayList;
import java.util.List;

import lab04.LogicaNegocio.Alumno;
import lab04.LogicaNegocio.Carrera;
import lab04.LogicaNegocio.Ciclo;
import lab04.LogicaNegocio.Curso;
import lab04.LogicaNegocio.Grupo;
import lab04.LogicaNegocio.Profesor;

public class DatosModel {


    private List<Carrera> carreras= new ArrayList<>();
    private List<Curso> cursos = new ArrayList<>();
    private List<Alumno> alumnos = new ArrayList<>();
    private List<Profesor> profesores = new ArrayList<>();
    private List<Grupo> grupos= new ArrayList<>();
    private List<Ciclo> ciclos= new ArrayList<>();

    private Profesor currentProfesor= new Profesor();
    private Alumno currentAlumno = new Alumno();
    private Curso currentCurso = new Curso();
    private Carrera currentCarrera = new Carrera();

    public Profesor getCurrentProfesor() {
        return currentProfesor;
    }

    public void setCurrentProfesor(Profesor currentProfesor) {
        this.currentProfesor = currentProfesor;
    }

    public Alumno getCurrentAlumno() {
        return currentAlumno;
    }

    public void setCurrentAlumno(Alumno currentAlumno) {
        this.currentAlumno = currentAlumno;
    }

    public Curso getCurrentCurso() {
        return currentCurso;
    }

    public void setCurrentCurso(Curso currentCurso) {
        this.currentCurso = currentCurso;
    }

    public Carrera getCurrentCarrera() {
        return currentCarrera;
    }

    public void setCurrentCarrera(Carrera currentCarrera) {
        this.currentCarrera = currentCarrera;
    }

    private String modo="Editar";

    public String getModo() {
        return modo;
    }

    public void setModo(String modo) {
        this.modo = modo;
    }

    private boolean cargado=false;

    public List<Grupo> getGrupos() {
        return grupos;
    }

    public void setGrupos(List<Grupo> grupos) {
        this.grupos = grupos;
    }

    public List<Ciclo> getCiclos() {
        return ciclos;
    }

    public void setCiclos(List<Ciclo> ciclos) {
        this.ciclos = ciclos;
    }

    public DatosModel() {
    }

    public DatosModel(List<Carrera> carreras, List<Curso> cursos, List<Alumno> alumnos, List<Profesor> profesores) {
        this.carreras = carreras;
        this.cursos = cursos;
        this.alumnos = alumnos;
        this.profesores = profesores;
    }

    public boolean isCargado() {
        return cargado;
    }

    public void setCargado(boolean cargado) {
        this.cargado = cargado;
    }

    public List<Carrera> getCarreras() {
        return carreras;
    }

    public void setCarreras(List<Carrera> carreras) {
        this.carreras = carreras;
    }

    public List<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(List<Curso> cursos) {
        this.cursos = cursos;
    }

    public List<Alumno> getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(List<Alumno> alumnos) {
        this.alumnos = alumnos;
    }

    public List<Profesor> getProfesores() {
        return profesores;
    }

    public void setProfesores(List<Profesor> profesores) {
        this.profesores = profesores;
    }
}
