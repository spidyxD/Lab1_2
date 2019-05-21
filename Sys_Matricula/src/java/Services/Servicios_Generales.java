/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Dao.Data;
import Entities.Alumno;
import Entities.Carrera;
import Entities.Ciclo;
import Entities.Curso;
import Entities.Grupo;
import Entities.Rendimiento_grupo;

/**
 *
 * @author Addiel
 */
public class Servicios_Generales {
     private static Servicios_Generales uniqueInstance;
    public static Servicios_Generales instance(){
        if (uniqueInstance == null){
            uniqueInstance = new Servicios_Generales();
        }
        return uniqueInstance;
    } 
    void reportarNotas(Rendimiento_grupo rg){
        try{
            Data.instance().getServiciogenerales().reportarNotas(rg);
        }
        catch(Exception e){}
        
    }
    void matricularCurso(Alumno a, Carrera c ,Curso cu,Grupo g, Ciclo cl){
         try{
            Data.instance().getServiciogenerales().matricularCurso(a, c, cu, g, cl);
        }
        catch(Exception e){}
    }
    void eliminarMatricula(Alumno a, int  g){
         try{
            Data.instance().getServiciogenerales().eliminarMatricula(a, g);
        }
        catch(Exception e){}
    }
    void generarPlanEstudio(Carrera ca ,Curso cu, Ciclo cl){
         try{
            Data.instance().getServiciogenerales().generarPlanEstudio(ca, cu, cl);
        }
        catch(Exception e){}
    }
    boolean doLogin(int user, String password){
         try{
            return Data.instance().getServiciogenerales().doLogin(user, password);
        }
        catch(Exception e){}
         return false;
    }
    
     public void modificarCarrera(int xcodigo,String xnombre, String xtitulo){
     try{
           Data.instance().getServiciogenerales().modificarCarrera(xcodigo, xnombre, xtitulo);
      }
      catch(Exception e){}    
    }
    public void eliminarCarrera(int codigo){
     try{
         Data.instance().getServiciogenerales().eliminarCarrera(codigo);
     }
     catch(Exception e){}
 } 
    
    
}
