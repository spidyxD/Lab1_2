/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Dao.Data;
import Entities.Profesor;
import Entities.Usuario;
import java.util.ArrayList;

/**
 *
 * @author Addiel
 */
public class Servicio_Profesor {
    private static Servicio_Profesor uniqueInstance;
    public static Servicio_Profesor instance(){
        if (uniqueInstance == null){
            uniqueInstance = new Servicio_Profesor();
        }
        return uniqueInstance;
    } 
    public void insertarProfesor(Profesor profesor, Usuario user) {
        try{
            Data.instance().getServicioProfesor().insertarProfesor(profesor, user);
        }
        catch(Exception e){}
    }
    public void modificarProfesor(Profesor profesor, Usuario user){
         try{
            Data.instance().getServicioProfesor().modificarProfesor(profesor, user);
        }
        catch(Exception e){}
    }
    public void eliminarProfesor(int codigo){
         try{
            Data.instance().getServicioProfesor().eliminarProfesor(codigo);
        }
        catch(Exception e){}
    }
    public ArrayList<Profesor> verProfesores() throws Exception{
        ArrayList aux = null;
        
         try{
          return  Data.instance().getServicioProfesor().verProfesores();
        }
        catch(Exception e){}
        throw new Exception();
    } 

     public void modificarProfesorAdmin(Profesor profesor){
         try{
            Data.instance().getServicioProfesor().modificarProfesorAdmin(profesor);
        }
        catch(Exception e){}
    }
}
