/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Entities.Alumno;
import Entities.Profesor;
import Entities.Usuario;
import java.util.HashMap;

/**
 *
 * @author dh173
 */
public class Model extends java.util.Observable {
    Usuario usuario;
    Alumno alumno;
    Profesor profesor;
    HashMap<String,String> errores;
    String mensaje;
    int modo;    

    public Model() {
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

   public void init(){ //init(TipoInstrumento[] tiposIns)
        //setTiposIns(tipos);
        setUsuario(new Usuario());
        setAlumno(new Alumno());
        setProfesor(new Profesor());
        clearErrors();
        setChanged();
        notifyObservers();  
    }

    public int getModo() {
        return modo;
    }

    public void setModo(int modo) {
        this.modo = modo;
    }
    
    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public HashMap<String, String> getErrores() {
        return errores;
    }

    public void setErrores(HashMap<String, String> errores) {
        this.errores = errores;
    }
    
    public void clearErrors(){
        setErrores(new HashMap<String,String>());
        setMensaje("");
        
    }
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario current) {
        this.usuario = current;
        setChanged();
        notifyObservers();        
    }

    @Override
    public void addObserver(java.util.Observer o) {
        super.addObserver(o);
        setChanged();
        notifyObservers();
    }
}
