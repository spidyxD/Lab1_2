/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Dao.Data;
import Entities.Curso;
import java.util.ArrayList;

/**
 *
 * @author Addiel
 */
public class Servicio_Cursos {
    private static Servicio_Cursos uniqueInstance;
    public static Servicio_Cursos instance(){
        if (uniqueInstance == null){
            uniqueInstance = new Servicio_Cursos();
        }
        return uniqueInstance;
    }    
     public void crearCurso(int xcodigo, String xnombre, int xcreditos, int xhoras){
          try{
             Data.instance().getServicioCursos().crearCurso(xcodigo, xnombre, xcreditos, xhoras); ;
        }
        catch(Exception e){}        
     }
    public void modificarCurso(int xcodigo,String xnombre, int xcreditos, int xhoras){
     try{
           Data.instance().getServicioCursos().modificarCurso(xcodigo,xnombre, xcreditos, xhoras);
      }
      catch(Exception e){}    
    }
    public void eliminarCurso(int codigo){
     try{
         Data.instance().getServicioCursos().eliminarCurso(codigo);
     }
     catch(Exception e){}
 } 
      public ArrayList<Curso> verCursos() throws Exception{
          ArrayList aux =  null;
       try{
            return  Data.instance().getServicioCursos().verCursos();
        }
        catch(Exception e){}
         throw new Exception();
      } 
      
   
}
