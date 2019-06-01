/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Dao.Data;
import Entities.Administrador;
import Entities.Alumno;
import Entities.Carrera;
import Entities.Ciclo;
import Entities.Curso;
import Entities.Grupo;
import Entities.Matricula;
import Entities.Profesor;
import Entities.Usuario;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Addiel
 */
public class Servicio_Busquedas {
     private static Servicio_Busquedas uniqueInstance;
    public static Servicio_Busquedas instance(){
        if (uniqueInstance == null){
            uniqueInstance = new Servicio_Busquedas();
        }
        return uniqueInstance;
    }    
    public int buscarCarreraXAlumno( int id ){
         try{
           return Data.instance().getServiciobusquedas().buscarCarreraXAlumno(id);
        }
        catch(Exception e){}
         return -1;
    }
    public Curso buscarCursoId(int xcodigo) throws Exception{
        try{
            return Data.instance().getServiciobusquedas().buscarCursoId(xcodigo);
        }
        catch(Exception e){}
          throw new Exception();
    }
    public Curso buscarCursoNombre(String xnombre) throws Exception{
         try{
           return  Data.instance().getServiciobusquedas().buscarCursoNombre(xnombre);
        }
        catch(Exception e){}
           throw new Exception();
    }
    public Carrera buscarCarreraId(int codigo) throws Exception{
         try{
            return Data.instance().getServiciobusquedas().buscarCarreraId(codigo);
        }
        catch(Exception e){}
           throw new Exception();
    }
    public List<Matricula> buscarMatriculaCiclo(int id) throws Exception {
        List<Matricula> aux = null;
         try{
            return Data.instance().getServiciobusquedas().buscarMatriculaCiclo(id);
        }
        catch(Exception e){}
          throw new Exception();
    }
    public Ciclo buscarCicloId(int id) throws Exception{
         try{
            return Data.instance().getServiciobusquedas().buscarCicloId(id);
        }
        catch(Exception e){}
          throw new Exception();
    }
    public Grupo buscarGrupoId(int id) throws Exception{
         try{
            return Data.instance().getServiciobusquedas().buscarGrupoId(id);
        }
        catch(Exception e){}
          throw new Exception();
    }
    public ArrayList<Curso> buscarCursoXCarrera(int codigo) throws Exception{
        ArrayList aux = null;
         try{
            return Data.instance().getServiciobusquedas().buscarCursoXCarrera(codigo);
        }
        catch(Exception e){}
          throw new Exception();
    }
    public ArrayList<Grupo> buscarGrupoCurso(int codigo) throws Exception{
        ArrayList aux = null;
         try{
            return Data.instance().getServiciobusquedas().buscarGrupoCurso(codigo);
        }
        catch(Exception e){}
          throw new Exception();
    }
     public Profesor buscarProfeId(int id) throws Exception{
         try{
          return  Data.instance().getServiciobusquedas().buscarProfeId(id);
        }
        catch(Exception e){}
           throw new Exception();
     }
    public Alumno buscarAlumnoId(int id) throws Exception {
       try{
         return  Data.instance().getServiciobusquedas().buscarAlumnoId(id);
        }
        catch(Exception e){}
         throw new Exception();
    }
    public Alumno buscarAlumnoNombre(String nombre) throws Exception{
       try{
         return   Data.instance().getServiciobusquedas().buscarAlumnoNombre(nombre);
        }
        catch(Exception e){}
        throw new Exception();
    }
    public Profesor buscarProfesorNombre(String nombre) throws Exception{
       try{
            Data.instance().getServiciobusquedas().buscarProfesorNombre(nombre);
        }
        catch(Exception e){}
        throw new Exception();
    }
    public ArrayList<Curso> buscarCursosXAlumno(int id) throws Exception{
        ArrayList aux = null;
       try{
            return Data.instance().getServiciobusquedas().buscarCursosXAlumno(id);
        }
        catch(Exception e){}
        throw new Exception();
    }
    public ArrayList<Alumno> buscarAlumnoXCurso(int codigo) throws Exception{
       ArrayList aux = null;
        try{
            return Data.instance().getServiciobusquedas().buscarAlumnoXCurso(codigo);
        }
        catch(Exception e){}
         throw new Exception();
    }
    public ArrayList<Alumno> buscarAlumnoXGrupo(int codigo) throws Exception{
       ArrayList aux = null;
        try{
           return Data.instance().getServiciobusquedas().buscarAlumnoXGrupo(codigo);
        }
        catch(Exception e){}
          throw new Exception();
    }
    public ArrayList<Curso> buscarCursoXprofesor(int codigo) throws Exception{
      ArrayList aux = null;
        try{
           return Data.instance().getServiciobusquedas().buscarCursoXprofesor(codigo);
        }
        catch(Exception e){}
         throw new Exception();
    }
    public ArrayList<Grupo> buscarGrupoXprofesor(int codigo) throws Exception{
        ArrayList aux = null;
     try{
          return  Data.instance().getServiciobusquedas().buscarGrupoXprofesor(codigo);
        }
        catch(Exception e){}
      throw new Exception();
    }
    public Usuario buscarUsuarioId(int id) throws Exception{
     try{
           return Data.instance().getServiciobusquedas().buscarUsuarioId(id);
        }
        catch(Exception e){}
       throw new Exception();
    }
    public Administrador buscarAdministradorId(int id) throws Exception{
     try{
           return Data.instance().getServiciobusquedas().buscarAdministradorId(id);
        }
        catch(Exception e){}
      throw new Exception();
    }
    public ArrayList<Ciclo> verCiclos() throws Exception{
        ArrayList aux = null;
     try{
            return Data.instance().getServiciobusquedas().verCiclos();
        }
        catch(Exception e){}
      throw new Exception();
    }
    public ArrayList<Curso> verCursos() throws Exception{
        ArrayList aux = null;
     try{
            return Data.instance().getServiciobusquedas().verCursos();
        }
        catch(Exception e){}
       throw new Exception();
    }
    public ArrayList<Carrera> verCarreras() throws Exception {
        ArrayList aux = null;
     try{
            return Data.instance().getServiciobusquedas().verCarreras();
        }
        catch(Exception e){}
      throw new Exception();
    }
    public ArrayList<Grupo> verGrupos() throws Exception {
        ArrayList aux = null;
     try{
            return Data.instance().getServiciobusquedas().verGrupos();
        }
        catch(Exception e){}
      throw new Exception();
    }
}
