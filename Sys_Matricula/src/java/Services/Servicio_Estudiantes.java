/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Dao.Data;
import Entities.Alumno;
import Entities.Usuario;
import java.util.ArrayList;

/**
 *
 * @author Addiel
 */
public class Servicio_Estudiantes {
    private static Servicio_Estudiantes uniqueInstance;
    public static Servicio_Estudiantes instance(){
        if (uniqueInstance == null){
            uniqueInstance = new Servicio_Estudiantes();
        }
        return uniqueInstance;
    }  
    public void insertarEstudiante(Alumno alumno, Usuario user){           
     try{
            Data.instance().getServicioestudiante().insertarEstudiante(alumno, user);
        }
        catch(Exception e){}
    }
    public void modificarCorreoEstudiante(String email) {
    try{
            Data.instance().getServicioestudiante().modificarCorreoEstudiante(email);
        }
        catch(Exception e){}
    }
    public void modificarEstudiante(Alumno alumno, Usuario user) {
        try{
                Data.instance().getServicioestudiante().modificarEstudiante(alumno, user);
            }
            catch(Exception e){}
    }
     public void eliminarEstudiante(int codigo) {
         try{
            Data.instance().getServicioestudiante().eliminarEstudiante(codigo);
        }
        catch(Exception e){}
     }
     public ArrayList<Alumno> verAlumnos() throws Exception{
            ArrayList aux = null;
         try{
            return Data.instance().getServicioestudiante().verAlumnos();
        }
        catch(Exception e){}
           throw new Exception();
     }
}
