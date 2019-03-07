/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.HashMap;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import Entities.Matricula;
import java.util.Observer;
/**
 *
 * @author dh173
 */
public class MatriculaModel extends java.util.Observable{
    Matricula current;
    HashMap<String,String> errores;
    String mensaje;
    int modo;    

    public MatriculaModel() {
    }

     public void init(){ //init(TipoInstrumento[] tiposIns)
        //setTiposIns(tipos);
        setCurrent(new Matricula());
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
    public Matricula getCurrent() {
        return current;
    }

    public void setCurrent(Matricula current) {
        this.current = current;
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
