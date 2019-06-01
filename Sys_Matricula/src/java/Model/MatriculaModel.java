/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Entities.Administrador;
import Entities.Alumno;
import Entities.Grupo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.swing.DefaultListModel;

/**
 *
 * @author dh173
 */
public class MatriculaModel extends java.util.Observable {
    Alumno current;
    MatriculaTable sistemaMat;
    DefaultListModel<String> cursosMatriculados = new DefaultListModel<>();
    Administrador matriculador;
    HashMap<String,String> errores;
    String mensaje;
    int modo;  

    public Administrador getMatriculador() {
        return matriculador;
    }

    public DefaultListModel<String> getCursosMatriculados() {
        return cursosMatriculados;
    }

    public void setCursosMatriculados(DefaultListModel<String> cursosMatriculados) {
        this.cursosMatriculados = cursosMatriculados;
        setChanged();
        notifyObservers();  
    }

    public void setMatriculador(Administrador matriculador) {
        this.matriculador = matriculador;
        setChanged();
        notifyObservers();  
    }

    
     public void init(){ 
        setCurrent(new Alumno());
        setMatriculador(new Administrador());
        List<Grupo> rowss= new ArrayList<Grupo>();
        this.setSistemaMat(rowss);
        clearErrors();
        setChanged();
        notifyObservers();  
    }
 public void setSistemaMat(List<Grupo> rend){
        int[] cols={MatriculaTable.CURSO,MatriculaTable.NRC,MatriculaTable.CREDITOS,MatriculaTable.HORARIO,MatriculaTable.PROFESOR};
        this.sistemaMat=new MatriculaTable(cols,rend);  
        setChanged();
        notifyObservers(); 
   }

    public MatriculaTable getSistemaMat() {
        return sistemaMat;
    }

    public void setSistemaMat(MatriculaTable sistemaMat) {
        this.sistemaMat = sistemaMat;
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

    public void setCurrent(Alumno current) {
        this.current = current;
        setChanged();
        notifyObservers();        
    }
     public Alumno getCurrent() {
        return current;
    }

    @Override
    public void addObserver(java.util.Observer o) {
        super.addObserver(o);
        setChanged();
        notifyObservers();
    }
}
