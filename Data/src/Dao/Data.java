/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

/**
 *
 * @author Addiel
 */
public class Data{
    private Service service;
    private ServicioBusquedas serviciobusquedas;
    private ServicioCursos servicioCursos;
    private ServicioEstudiante servicioestudiante;
    private ServicioGenerales serviciogenerales;
    private ServicioProfesor servicioProfesor;
    private static Data uniqueInstance;    
    public static Data instance(){
        if (uniqueInstance == null){
            uniqueInstance = new Data();
        }
        return uniqueInstance;
    }
    public Data() {
        service = new Service();
        serviciobusquedas = new ServicioBusquedas();
        servicioCursos = new ServicioCursos();
        servicioestudiante= new ServicioEstudiante();
        serviciogenerales = new ServicioGenerales();
        servicioProfesor = new ServicioProfesor();
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public ServicioBusquedas getServiciobusquedas() {
        return serviciobusquedas;
    }

    public void setServiciobusquedas(ServicioBusquedas serviciobusquedas) {
        this.serviciobusquedas = serviciobusquedas;
    }

    public ServicioCursos getServicioCursos() {
        return servicioCursos;
    }

    public void setServicioCursos(ServicioCursos servicioCursos) {
        this.servicioCursos = servicioCursos;
    }

    public ServicioEstudiante getServicioestudiante() {
        return servicioestudiante;
    }

    public void setServicioestudiante(ServicioEstudiante servicioestudiante) {
        this.servicioestudiante = servicioestudiante;
    }

    public ServicioGenerales getServiciogenerales() {
        return serviciogenerales;
    }

    public void setServiciogenerales(ServicioGenerales serviciogenerales) {
        this.serviciogenerales = serviciogenerales;
    }

    public ServicioProfesor getServicioProfesor() {
        return servicioProfesor;
    }

    public void setServicioProfesor(ServicioProfesor servicioProfesor) {
        this.servicioProfesor = servicioProfesor;
    }
    
    
}
