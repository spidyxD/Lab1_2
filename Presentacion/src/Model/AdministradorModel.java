/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Entities.Administrador;
import java.util.HashMap;

/**
 *
 * @author dh173
 */
public class AdministradorModel extends java.util.Observable {
    Administrador current;
    HashMap<String,String> errores;
    String mensaje;
    int modo;    

    public AdministradorModel() {
    }

   public void init(){ //init(TipoInstrumento[] tiposIns)
        //setTiposIns(tipos);
        setCurrent(new Administrador());
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

    public void setCurrent(Administrador current) {
        this.current = current;
        setChanged();
        notifyObservers();        
    }
     public Administrador getCurrent() {
        return current;
    }

    @Override
    public void addObserver(java.util.Observer o) {
        super.addObserver(o);
        setChanged();
        notifyObservers();
    }
}

