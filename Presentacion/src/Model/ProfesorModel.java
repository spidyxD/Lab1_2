/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
import Entities.Alumno;
import Entities.Grupo;
import Entities.Profesor;
import Entities.Rendimiento_grupo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;
import javax.swing.DefaultListModel;

/**
 *
 * @author dh173
 */
public class ProfesorModel extends java.util.Observable {
    Profesor current;
    AlumnosProfTableModel alumnos;
    CalifFinalesTableModel calificaciones;
    GruposTableModel grupos ;
    HashMap<String,String> errores;
    String mensaje;
    int modo;    

    public ProfesorModel() {
    }

   public void init(){
        setCurrent(new Profesor());
        List<Alumno> rows = new ArrayList<Alumno>();
        List<Grupo> rowss= new ArrayList<Grupo>();
        List<Rendimiento_grupo> rowsss = new ArrayList<Rendimiento_grupo>();
        this.setGrupos(rowss);
        this.setAlumnos(rows);
        this.setCalificaciones(rowsss);
        clearErrors();
        setChanged();
        notifyObservers();  
    }

   public void setCalificaciones(List<Rendimiento_grupo> rend){
        int[] cols={CalifFinalesTableModel.NOTA};
        this.calificaciones =new CalifFinalesTableModel(cols,rend);  
        setChanged();
        notifyObservers(); 
   }
   public void setAlumnos(List<Alumno> alumnos){
        int[] cols={AlumnosProfTableModel.NOMBRE,AlumnosProfTableModel.CEDULA,AlumnosProfTableModel.EMAIL};
        this.alumnos =new AlumnosProfTableModel(cols,alumnos);  
        setChanged();
        notifyObservers();        
    }

    public AlumnosProfTableModel getAlumnos() {
        return alumnos;
    }
    public void setAlumnos(AlumnosProfTableModel alumnos){
        this.alumnos= alumnos;
        setChanged();
        notifyObservers(); 
    }
    
    public GruposTableModel getGrupos() {
        return grupos;
    }

    public CalifFinalesTableModel getCalificaciones() {
        return calificaciones;
    }

    public void setCalificaciones(CalifFinalesTableModel calificaciones) {
        this.calificaciones = calificaciones;
    }

    public void setGrupos(List<Grupo> grupos) {
        int[] cols={GruposTableModel.NRC,GruposTableModel.CURSO,GruposTableModel.CAPACIDAD,GruposTableModel.HORARIO};
        this.grupos =new GruposTableModel(cols,grupos);  
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

    public void setCurrent(Profesor current) {
        this.current = current;
        setChanged();
        notifyObservers();        
    }
     public Profesor getCurrent() {
        return current;
    }

    @Override
    public void addObserver(java.util.Observer o) {
        super.addObserver(o);
        setChanged();
        notifyObservers();
    }

}
