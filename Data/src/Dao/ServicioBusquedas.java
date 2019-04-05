/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import AccesoADatos.GlobalException;
import AccesoADatos.NoDataException;
import Entities.Administrador;
import Entities.Alumno;
import Entities.Carrera;
import Entities.Ciclo;
import Entities.Curso;
import Entities.Grupo;
import Entities.Matricula;
import Entities.Profesor;
import Entities.Rendimiento_grupo;
import Entities.Usuario;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Struct;
import java.util.ArrayList;
import java.util.List;
import oracle.jdbc.OracleTypes;

/**
 *
 * @author Addiel
 */
public class ServicioBusquedas extends Service{
    /*private static final String BUSCARCARRERA= "{call buscar_carrera_id(?)}";
    private static final String BUSCARCURSOID= "{call buscar_curso_id(?)}";
    private static final String BUSCARCURSONOMBRE= "{call buscar_curso_nombre(?)}";
    private static final String BUSCARCURSOXCARRERA= "{call buscar_curso_carrera(?)}";
    private static final String BUSCARPROFCEDULA= "{call buscar_Profesor_cedula(?)}";
    private static final String BUSCARALUMNOCEDULA= "{call buscar_Alumno_ced(?)}";
    private static final String BUSCARALUMNOMBRE= "{call buscar_Alumno_nombre(?)}";
    private static final String BUSCARCURSOXALUMNO= "{call buscar_cursoXAlumno(?)}";
    private static final String BUSCARALUMNOXCURWO= "{call buscar_AlumnoXCurso(?)}";
    private static final String BUSCARCURSOXPROFESOR= "{call buscar_cursoXProfesor(?)}";
    private static final String BUSCARALUMNOSXCARRERA= "{call buscar_inscritoCarrera(?)}";*/
    
    
    
    private Curso tipoCurso(ResultSet rs){
        try{
            Curso c = new Curso();
            c.setCodigo(rs.getInt("codigo"));
            c.setNombre(rs.getString("nombre"));
            c.setCreditos(rs.getInt("creditos"));
            c.setHoras_semanales(rs.getInt("horas_semanales"));
            return c;
        }
        catch (SQLException ex) {
            return null;
        }
    }
    
      private Grupo tipoGrupo(ResultSet rs) throws GlobalException, NoDataException, InstantiationException, IllegalAccessException{
        try{
            Grupo g = new Grupo();
            g.setCapacidad(rs.getInt("capacidad"));
            g.setCurso(tipoCurso(rs));
            g.setHorario(rs.getString("horario"));
            g.setNrc(rs.getInt("nrc"));
            int idProf = rs.getInt("profesor");
            int Ciclo = rs.getInt("ciclo");
            g.setCiclo(this.buscarCicloId(Ciclo));
            g.setPorfesor(this.buscarProfeId(idProf));
            g.setCurso(this.buscarCursoId(rs.getInt("curso")));
            return g;
        }
        catch (SQLException ex) {
            return null;
        }
    }
    
    private Ciclo tipoCiclo(ResultSet rs){
        try{
            Ciclo c = new Ciclo();
            c.setCodigo(rs.getInt("id"));
            c.setDescripcion(rs.getString("descripcion"));
            c.setFecha_finalizacion(rs.getDate("fecha_finalizacion"));
            c.setFecha_inicio(rs.getDate("fecha_inicio"));
            return c;
        }
        catch (SQLException ex) {
            return null;
        }
    }
    private Matricula tipoMatricula(ResultSet rs) throws GlobalException, NoDataException, InstantiationException, IllegalAccessException{
        try{
            Matricula m = new Matricula();
            int idAlumno= rs.getInt("alumno");
            int idCarrera=rs.getInt("carrera");
            int cursoId= rs.getInt("curso");
            int grupoId= rs.getInt("grupo");
            int cicloId= rs.getInt("ciclo");
            m.setStudent(this.buscarAlumnoId(idAlumno));
            m.setMajor(this.buscarCarreraId(idCarrera));
            m.setCourse(this.buscarCursoId(cursoId));
            m.setCycle(this.buscarCicloId(cicloId));
            m.setGrupo(this.buscarGrupoId(grupoId));
            return m;
        }
        catch (SQLException ex) {
            return null;
        }
    }  
    private Alumno tipoAlumno(ResultSet rs) throws GlobalException, NoDataException, InstantiationException, IllegalAccessException{
        try{
            Alumno a = new Alumno();
            a.setCedula(rs.getInt("cedula"));
            a.setEdad(rs.getInt("edad"));
            a.setEmail(rs.getString("email"));
            a.setFecha_nacimiento(rs.getDate("fecha_nacimiento"));
            a.setNombre(rs.getString("nombre"));
            int carrera= this.buscarCarreraXAlumno(a.getCedula());
            a.setCarrera(this.buscarCarreraId(carrera));
            return a;
        }
        catch (SQLException ex) {
            return null;
        }
    }
    private Administrador tipoAdministrador(ResultSet rs){
        try{
            Administrador a = new Administrador();
            a.setCedula(rs.getInt("id"));
            a.setNombre(rs.getString("nombre"));
            return a;
        }
        catch (SQLException ex) {
            return null;
        }
    }
    
     private Rendimiento_grupo tipoRendimiento(ResultSet rs) throws GlobalException, NoDataException, InstantiationException, IllegalAccessException{
        try{
            Rendimiento_grupo rg = new Rendimiento_grupo();
            rg.setAlumno(tipoAlumno(rs));
            rg.setCalificacion(rs.getInt("calificacion"));
            rg.setProfesor(tipoProfesor(rs));
            rg.setCurso(tipoCurso(rs));
            return rg;
        }
        catch (SQLException ex) {
            return null;
        }
    }
    
    
    private Profesor tipoProfesor(ResultSet rs){
        try{
            Profesor p = new Profesor();
            p.setCedula(rs.getInt("cedula"));
            p.setEdad(rs.getInt("edad"));
            p.setEmail(rs.getString("email"));
            p.setTelefono(rs.getInt("telefono"));
            p.setNombre(rs.getString("nombre"));
            return p;
        }
        catch (SQLException ex) {
            return null;
        }
    }
    
        
        private Carrera tipoCarrera(ResultSet rs){
        try{
            Carrera c = new Carrera();
            c.setCodigo(rs.getInt("codigo"));
            c.setNombre(rs.getString("nombre"));
            c.setTitulo(rs.getString("titulo"));
            return c;
        }
        catch (SQLException ex) {
            return null;
        }
    }
        
    private Usuario tipoUsuario(ResultSet rs){
        try{
            Usuario u = new Usuario();
            u.setClave(rs.getString("clave"));
            u.setRol(rs.getString("rol"));
            u.setUsername(rs.getInt("id"));
            return u;
        }
        catch (SQLException ex) {
            return null;
        }
    }
    
    public int buscarCarreraXAlumno( int id )throws AccesoADatos.GlobalException, AccesoADatos.NoDataException, SQLException, InstantiationException, IllegalAccessException  	{
        try {
            conectar();
        } catch (ClassNotFoundException e) {
            throw new AccesoADatos.GlobalException("No se ha localizado el driver");
        } catch (SQLException e) {
            throw new AccesoADatos.NoDataException("La base de datos no se encuentra disponible");
        }
        CallableStatement pstmt=null;
        int carrera=0;
        try {           
            pstmt = conexion.prepareCall("{? =call buscar_CarreraXAlumno(?)}");   
            pstmt.registerOutParameter(1, OracleTypes.CURSOR);
            pstmt.setInt(2,id);
            pstmt.execute();
            ResultSet rs = (ResultSet) pstmt.getObject(1);   
              while(rs.next()){
                   carrera= rs.getInt("carrera");
                }                 
        } catch (SQLException e) {
            throw new AccesoADatos.GlobalException(e.getMessage());
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
                desconectar();
            } catch (SQLException e) {
                throw new AccesoADatos.GlobalException("Estatutos invalidos o nulos");
                }
            }
             return carrera;
    } 
    public Curso buscarCursoId(int xcodigo) throws AccesoADatos.GlobalException, AccesoADatos.NoDataException, SQLException, InstantiationException, IllegalAccessException  	{
        Curso c = new Curso();
        try {
            conectar();
        } catch (ClassNotFoundException e) {
            throw new AccesoADatos.GlobalException("No se ha localizado el driver");
        } catch (SQLException e) {
            throw new AccesoADatos.NoDataException("La base de datos no se encuentra disponible");
        }
        CallableStatement pstmt=null;
        ArrayList<Curso> cursos = new ArrayList();
        try {           
            pstmt = conexion.prepareCall("{? = call buscar_curso_id(?)}");   
            pstmt.registerOutParameter(1, OracleTypes.CURSOR);
            pstmt.setInt(2,xcodigo);
            pstmt.execute();
            ResultSet rs = (ResultSet) pstmt.getObject(1);              
              while(rs.next()){
                    cursos.add(tipoCurso(rs));
                }                 
        } catch (SQLException e) {
            throw new AccesoADatos.GlobalException(e.getMessage());
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
                desconectar();
            } catch (SQLException e) {
                throw new AccesoADatos.GlobalException("Estatutos invalidos o nulos");
                }
            }
             return cursos.get(0);
        }
        
        public Curso buscarCursoNombre(String xnombre) throws AccesoADatos.GlobalException, AccesoADatos.NoDataException, SQLException, InstantiationException, IllegalAccessException  	{
            ArrayList<Curso> cursos = new ArrayList();
            try {
                conectar();
            } catch (ClassNotFoundException e) {
                throw new AccesoADatos.GlobalException("No se ha localizado el driver");
            } catch (SQLException e) {
                throw new AccesoADatos.NoDataException("La base de datos no se encuentra disponible");
            }
            CallableStatement pstmt=null;
            try {
                pstmt = conexion.prepareCall("{? = call buscar_curso_nombre(?)}");  
                pstmt.registerOutParameter(1, OracleTypes.CURSOR);
                pstmt.setString(2,xnombre);
                pstmt.execute();
                ResultSet rs = (ResultSet) pstmt.getObject(1);
                    while(rs.next()){
                        cursos.add(tipoCurso(rs));
                }
            } catch (SQLException e) {
                throw new AccesoADatos.GlobalException(e.getMessage());
            } finally {
                try {
                    if (pstmt != null) {
                        pstmt.close();
                    }
                    desconectar();
                } catch (SQLException e) {
                    throw new AccesoADatos.GlobalException("Estatutos invalidos o nulos");
                }
            }
             return cursos.get(0);
        }

         public Carrera buscarCarreraId(int codigo) throws AccesoADatos.GlobalException, AccesoADatos.NoDataException, SQLException, InstantiationException, IllegalAccessException  	{
             ArrayList<Carrera> carreras = new ArrayList();
             try {
                conectar();
            } catch (ClassNotFoundException e) {
                throw new AccesoADatos.GlobalException("No se ha localizado el driver");
            } catch (SQLException e) {
                throw new AccesoADatos.NoDataException("La base de datos no se encuentra disponible");
            }
            CallableStatement pstmt=null;

            try {
                pstmt = conexion.prepareCall("{? = call buscar_carrera_id (?)}");
                pstmt.registerOutParameter(1, OracleTypes.CURSOR);
                pstmt.setInt(2,codigo);
                pstmt.execute();               
                ResultSet rs = (ResultSet) pstmt.getObject(1); 
                    while(rs.next()){
                        carreras.add(tipoCarrera(rs));
                    }                         
            } catch (SQLException e) {
                throw new AccesoADatos.GlobalException(e.getMessage());
            } finally {
                try {
                    if (pstmt != null) {
                        pstmt.close();
                    }
                    desconectar();
                } catch (SQLException e) {
                    throw new AccesoADatos.GlobalException("Estatutos invalidos o nulos");
                }
        }
             return carreras.get(0);      
        
    }   
    public List<Matricula> buscarMatriculaCiclo(int id) throws AccesoADatos.GlobalException, AccesoADatos.NoDataException, SQLException, InstantiationException, IllegalAccessException  	{
             List<Matricula> matrs = new ArrayList();
             try {
                conectar();
            } catch (ClassNotFoundException e) {
                throw new AccesoADatos.GlobalException("No se ha localizado el driver");
            } catch (SQLException e) {
                throw new AccesoADatos.NoDataException("La base de datos no se encuentra disponible");
            }
            CallableStatement pstmt=null;

            try {
                pstmt = conexion.prepareCall("{? = call buscar_Matricula_Ciclo(?)}");
                pstmt.registerOutParameter(1, OracleTypes.CURSOR);
                pstmt.setInt(2,id);
                pstmt.execute();               
                ResultSet rs = (ResultSet) pstmt.getObject(1); 
                    while(rs.next()){
                        matrs.add(this.tipoMatricula(rs));
                    }                         
            } catch (SQLException e) {
                throw new AccesoADatos.GlobalException(e.getMessage());
            } finally {
                try {
                    if (pstmt != null) {
                        pstmt.close();
                    }
                    desconectar();
                } catch (SQLException e) {
                    throw new AccesoADatos.GlobalException("Estatutos invalidos o nulos");
                }
        }
             return matrs;      
        
    }
    
     public Ciclo buscarCicloId(int id) throws AccesoADatos.GlobalException, AccesoADatos.NoDataException, SQLException, InstantiationException, IllegalAccessException  	{
             ArrayList<Ciclo> ciclos = new ArrayList();
             try {
                conectar();
            } catch (ClassNotFoundException e) {
                throw new AccesoADatos.GlobalException("No se ha localizado el driver");
            } catch (SQLException e) {
                throw new AccesoADatos.NoDataException("La base de datos no se encuentra disponible");
            }
            CallableStatement pstmt=null;

            try {
                pstmt = conexion.prepareCall("{? = call buscar_Ciclo_id(?)}");
                pstmt.registerOutParameter(1, OracleTypes.CURSOR);
                pstmt.setInt(2,id);
                pstmt.execute();               
                ResultSet rs = (ResultSet) pstmt.getObject(1); 
                    while(rs.next()){
                        ciclos.add(this.tipoCiclo(rs));
                    }                         
            } catch (SQLException e) {
                throw new AccesoADatos.GlobalException(e.getMessage());
            } finally {
                try {
                    if (pstmt != null) {
                        pstmt.close();
                    }
                    desconectar();
                } catch (SQLException e) {
                    throw new AccesoADatos.GlobalException("Estatutos invalidos o nulos");
                }
        }
             return ciclos.get(0);      
        
    }
    public Grupo buscarGrupoId(int id) throws AccesoADatos.GlobalException, AccesoADatos.NoDataException, SQLException, InstantiationException, IllegalAccessException  	{
             ArrayList<Grupo> grupos = new ArrayList();
             try {
                conectar();
            } catch (ClassNotFoundException e) {
                throw new AccesoADatos.GlobalException("No se ha localizado el driver");
            } catch (SQLException e) {
                throw new AccesoADatos.NoDataException("La base de datos no se encuentra disponible");
            }
            CallableStatement pstmt=null;

            try {
                pstmt = conexion.prepareCall("{? = call buscar_Grupo_id(?)}");
                pstmt.registerOutParameter(1, OracleTypes.CURSOR);
                pstmt.setInt(2,id);
                pstmt.execute();               
                ResultSet rs = (ResultSet) pstmt.getObject(1); 
                    while(rs.next()){
                        grupos.add(tipoGrupo(rs));
                    }                         
            } catch (SQLException e) {
                throw new AccesoADatos.GlobalException(e.getMessage());
            } finally {
                try {
                    if (pstmt != null) {
                        pstmt.close();
                    }
                    desconectar();
                } catch (SQLException e) {
                    throw new AccesoADatos.GlobalException("Estatutos invalidos o nulos");
                }
        }
             return grupos.get(0);      
        
    }
     public  ArrayList<Curso> buscarCursoXCarrera(int codigo) throws AccesoADatos.GlobalException, AccesoADatos.NoDataException, SQLException, InstantiationException, IllegalAccessException  	{
         ArrayList<Curso> cursos = new ArrayList();
         try {
            conectar();
        } catch (ClassNotFoundException e) {
            throw new AccesoADatos.GlobalException("No se ha localizado el driver");
        } catch (SQLException e) {
            throw new AccesoADatos.NoDataException("La base de datos no se encuentra disponible");
        }
        CallableStatement pstmt=null;
        
        try {
            pstmt = conexion.prepareCall("{? = call buscar_curso_carrera(?)}");
            pstmt.registerOutParameter(1, OracleTypes.CURSOR);
            pstmt.setInt(2,codigo); 
            pstmt.execute();   
            ResultSet rs = (ResultSet) pstmt.getObject(1);   
                while(rs.next()){
                    cursos.add(tipoCurso(rs));
                }
                          
        } catch (SQLException e) {
            throw new AccesoADatos.GlobalException(e.getMessage());
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
                desconectar();
            } catch (SQLException e) {
                throw new AccesoADatos.GlobalException("Estatutos invalidos o nulos");
            }
        }
        return cursos;  
    }    
    public  ArrayList<Grupo> buscarGrupoCurso(int codigo) throws AccesoADatos.GlobalException, AccesoADatos.NoDataException, SQLException, InstantiationException, IllegalAccessException  	{
         ArrayList<Grupo> grupos = new ArrayList();
         try {
            conectar();
        } catch (ClassNotFoundException e) {
            throw new AccesoADatos.GlobalException("No se ha localizado el driver");
        } catch (SQLException e) {
            throw new AccesoADatos.NoDataException("La base de datos no se encuentra disponible");
        }
        CallableStatement pstmt=null;
        
        try {
            pstmt = conexion.prepareCall("{? = call buscar_grupo_curso(?)}");
            pstmt.registerOutParameter(1, OracleTypes.CURSOR);
            pstmt.setInt(2,codigo); 
            pstmt.execute();   
            ResultSet rs = (ResultSet) pstmt.getObject(1);   
                while(rs.next()){
                    grupos.add(tipoGrupo(rs));
                }
                          
        } catch (SQLException e) {
            throw new AccesoADatos.GlobalException(e.getMessage());
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
                desconectar();
            } catch (SQLException e) {
                throw new AccesoADatos.GlobalException("Estatutos invalidos o nulos");
            }
        }
        return grupos;  
    }    
     
    public Profesor buscarProfeId(int id) throws AccesoADatos.GlobalException, AccesoADatos.NoDataException, SQLException, InstantiationException, IllegalAccessException  	{
       ArrayList<Profesor> profesores = new ArrayList();
        try {
            conectar();
        } catch (ClassNotFoundException e) {
            throw new AccesoADatos.GlobalException("No se ha localizado el driver");
        } catch (SQLException e) {
            throw new AccesoADatos.NoDataException("La base de datos no se encuentra disponible");
        }
        CallableStatement pstmt=null;        
        try {
            pstmt = conexion.prepareCall("{? = call buscar_Profesor_cedula(?)}"); 
            pstmt.registerOutParameter(1, OracleTypes.CURSOR);
            pstmt.setInt(2,id);
            pstmt.execute();               
             ResultSet rs = (ResultSet) pstmt.getObject(1);  
                while(rs.next()){
                    profesores.add(tipoProfesor(rs));
                }                                
        } catch (SQLException e) {
            throw new AccesoADatos.GlobalException(e.getMessage());
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
                desconectar();
            } catch (SQLException e) {
                throw new AccesoADatos.GlobalException("Estatutos invalidos o nulos");
            }
        }        
         return profesores.get(0);      
    }     
    
    public Alumno buscarAlumnoId(int id) throws AccesoADatos.GlobalException, AccesoADatos.NoDataException, SQLException, InstantiationException, IllegalAccessException  	{
        ArrayList<Alumno> alumnos = new ArrayList();
        try {
            conectar();
        } catch (ClassNotFoundException e) {
            throw new AccesoADatos.GlobalException("No se ha localizado el driver");
        } catch (SQLException e) {
            throw new AccesoADatos.NoDataException("La base de datos no se encuentra disponible");
        }
        CallableStatement pstmt=null;
        
        try {
            pstmt = conexion.prepareCall("{? = call buscar_Alumno_ced(?)}");
            pstmt.registerOutParameter(1, OracleTypes.CURSOR);
            pstmt.setInt(2,id);
             pstmt.execute();              

             ResultSet rs = (ResultSet) pstmt.getObject(1);    
                while(rs.next()){
                    alumnos.add(tipoAlumno(rs));}
                int idC= this.buscarCarreraXAlumno(id);
                Carrera carrera = new Carrera();
                carrera= this.buscarCarreraId(idC);
                alumnos.get(0).setCarrera(carrera);
                                                  
        } catch (SQLException e) {
            throw new AccesoADatos.GlobalException(e.getMessage());
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
                desconectar();
            } catch (SQLException e) {
                throw new AccesoADatos.GlobalException("Estatutos invalidos o nulos");
            }
        }
        return alumnos.get(0);      
    }     
    
     public Alumno buscarAlumnoNombre(String nombre) throws AccesoADatos.GlobalException, AccesoADatos.NoDataException, SQLException, InstantiationException, IllegalAccessException  	{
          ArrayList<Alumno> alumnos = new ArrayList();
         try {
            conectar();
        } catch (ClassNotFoundException e) {
            throw new AccesoADatos.GlobalException("No se ha localizado el driver");
        } catch (SQLException e) {
            throw new AccesoADatos.NoDataException("La base de datos no se encuentra disponible");
        }
        CallableStatement pstmt=null;
        
        try {
            pstmt = conexion.prepareCall("{? = call buscar_Alumno_nombre(?)}");
            pstmt.registerOutParameter(1, OracleTypes.CURSOR);
            pstmt.setString(2,nombre);
             pstmt.execute();               
             ResultSet rs = (ResultSet) pstmt.getObject(1); 
                while(rs.next()){
                    alumnos.add(tipoAlumno(rs));
                }                       
        } catch (SQLException e) {
            throw new AccesoADatos.GlobalException(e.getMessage());
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
                desconectar();
            } catch (SQLException e) {
                throw new AccesoADatos.GlobalException("Estatutos invalidos o nulos");
            }
        }
         return alumnos.get(0);    
    }   
     public Profesor buscarProfesorNombre(String nombre) throws AccesoADatos.GlobalException, AccesoADatos.NoDataException, SQLException, InstantiationException, IllegalAccessException  	{
          ArrayList<Profesor> profes = new ArrayList();
         try {
            conectar();
        } catch (ClassNotFoundException e) {
            throw new AccesoADatos.GlobalException("No se ha localizado el driver");
        } catch (SQLException e) {
            throw new AccesoADatos.NoDataException("La base de datos no se encuentra disponible");
        }
        CallableStatement pstmt=null;
        
        try {
            pstmt = conexion.prepareCall("{? = call buscar_Profesor_nombre(?)}");
            pstmt.registerOutParameter(1, OracleTypes.CURSOR);
            pstmt.setString(2,nombre);
             pstmt.execute();               
             ResultSet rs = (ResultSet) pstmt.getObject(1); 
                while(rs.next()){
                    profes.add(tipoProfesor(rs));
                }                       
        } catch (SQLException e) {
            throw new AccesoADatos.GlobalException(e.getMessage());
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
                desconectar();
            } catch (SQLException e) {
                throw new AccesoADatos.GlobalException("Estatutos invalidos o nulos");
            }
        }
         return profes.get(0);    
    }   
     public ArrayList<Curso> buscarCursosXAlumno(int id) throws AccesoADatos.GlobalException, AccesoADatos.NoDataException, SQLException, InstantiationException, IllegalAccessException  	{
           ArrayList<Curso> cursos = new ArrayList();
         try {
            conectar();
        } catch (ClassNotFoundException e) {
            throw new AccesoADatos.GlobalException("No se ha localizado el driver");
        } catch (SQLException e) {
            throw new AccesoADatos.NoDataException("La base de datos no se encuentra disponible");
        }
        CallableStatement pstmt=null;
        
        try {
            pstmt = conexion.prepareCall("{? = call buscar_cursoXAlumno(?)}");
            pstmt.registerOutParameter(1, OracleTypes.CURSOR);
            pstmt.setInt(2,id);
             pstmt.execute();             
             ResultSet rs = (ResultSet) pstmt.getObject(1);  
                while(rs.next()){
                    cursos.add(tipoCurso(rs));
                }                        
        } catch (SQLException e) {
            throw new AccesoADatos.GlobalException(e.getMessage());
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
                desconectar();
            } catch (SQLException e) {
                throw new AccesoADatos.GlobalException("Estatutos invalidos o nulos");
            }
        }
          return cursos;  
    }     
     
     
     
    public ArrayList<Alumno> buscarAlumnoXCurso(int codigo) throws AccesoADatos.GlobalException, AccesoADatos.NoDataException, SQLException, InstantiationException, IllegalAccessException  	{
          ArrayList<Alumno> alumnos = new ArrayList();
        try {
            conectar();
        } catch (ClassNotFoundException e) {
            throw new AccesoADatos.GlobalException("No se ha localizado el driver");
        } catch (SQLException e) {
            throw new AccesoADatos.NoDataException("La base de datos no se encuentra disponible");
        }
        CallableStatement pstmt=null;        
        try {
            pstmt = conexion.prepareCall("{? = call buscar_AlumnoXCurso(?)}");
            pstmt.registerOutParameter(1, OracleTypes.CURSOR);
            pstmt.setInt(2,codigo);
             pstmt.execute();              
             ResultSet rs = (ResultSet) pstmt.getObject(1);   
                while(rs.next()){
                    alumnos.add(tipoAlumno(rs));
                }               
        } catch (SQLException e) {
            throw new AccesoADatos.GlobalException(e.getMessage());
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
                desconectar();
            } catch (SQLException e) {
                throw new AccesoADatos.GlobalException("Estatutos invalidos o nulos");
            }
        }
         return alumnos;
    }     
    public ArrayList<Alumno> buscarAlumnoXGrupo(int codigo) throws AccesoADatos.GlobalException, AccesoADatos.NoDataException, SQLException, InstantiationException, IllegalAccessException  	{
          ArrayList<Alumno> alumnos = new ArrayList();
        try {
            conectar();
        } catch (ClassNotFoundException e) {
            throw new AccesoADatos.GlobalException("No se ha localizado el driver");
        } catch (SQLException e) {
            throw new AccesoADatos.NoDataException("La base de datos no se encuentra disponible");
        }
        CallableStatement pstmt=null;        
        try {
            pstmt = conexion.prepareCall("{? = call buscar_AlumnoXGrupo(?)}");
            pstmt.registerOutParameter(1, OracleTypes.CURSOR);
            pstmt.setInt(2,codigo);
             pstmt.execute();              
             ResultSet rs = (ResultSet) pstmt.getObject(1); 
                while(rs.next()){
                    alumnos.add(tipoAlumno(rs));
                }               
        } catch (SQLException e) {
            throw new AccesoADatos.GlobalException(e.getMessage());
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
                desconectar();
            } catch (SQLException e) {
                throw new AccesoADatos.GlobalException("Estatutos invalidos o nulos");
            }
        }
         return alumnos;
    }     
    public ArrayList<Curso> buscarCursoXprofesor(int codigo) throws AccesoADatos.GlobalException, AccesoADatos.NoDataException, SQLException, InstantiationException, IllegalAccessException  	{
        ArrayList<Curso> cursos = new ArrayList();
        try {
            conectar();
        } catch (ClassNotFoundException e) {
            throw new AccesoADatos.GlobalException("No se ha localizado el driver");
        } catch (SQLException e) {
            throw new AccesoADatos.NoDataException("La base de datos no se encuentra disponible");
        }
        CallableStatement pstmt=null;        
        
        try {
            pstmt = conexion.prepareCall("{? = call buscar_cursoXProfesor(?)}");
            pstmt.registerOutParameter(1, OracleTypes.CURSOR);
            pstmt.setInt(2,codigo);
             pstmt.execute();               
             ResultSet rs = (ResultSet) pstmt.getObject(1); 
                while(rs.next()){
                    cursos.add(tipoCurso(rs));
                }               
        } catch (SQLException e) {
            throw new AccesoADatos.GlobalException(e.getMessage());
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
                desconectar();
            } catch (SQLException e) {
                throw new AccesoADatos.GlobalException("Estatutos invalidos o nulos");
            }
        }
         return cursos;
    } 
    public ArrayList<Grupo> buscarGrupoXprofesor(int codigo) throws AccesoADatos.GlobalException, AccesoADatos.NoDataException, SQLException, InstantiationException, IllegalAccessException  	{
        ArrayList<Grupo> grupos = new ArrayList();
        try {
            conectar();
        } catch (ClassNotFoundException e) {
            throw new AccesoADatos.GlobalException("No se ha localizado el driver");
        } catch (SQLException e) {
            throw new AccesoADatos.NoDataException("La base de datos no se encuentra disponible");
        }
        CallableStatement pstmt=null;        
        try {
            pstmt = conexion.prepareCall("{? = call buscar_grupoXProfesor(?)}");
            pstmt.registerOutParameter(1, OracleTypes.CURSOR);
            pstmt.setInt(2,codigo);
             pstmt.execute();               
             ResultSet rs = (ResultSet) pstmt.getObject(1); 
                while(rs.next()){
                    grupos.add(tipoGrupo(rs));
                }               
        } catch (SQLException e) {
            throw new AccesoADatos.GlobalException(e.getMessage());
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
                desconectar();
            } catch (SQLException e) {
                throw new AccesoADatos.GlobalException("Estatutos invalidos o nulos");
            }
        }
         return grupos;
    }      
    
    
    public ArrayList<Alumno> buscarAlumnoXCarrera(int codigo) throws AccesoADatos.GlobalException, AccesoADatos.NoDataException, SQLException, InstantiationException, IllegalAccessException  	{
         ArrayList<Alumno> alumnos = new ArrayList();
        try {
            conectar();
        } catch (ClassNotFoundException e) {
            throw new AccesoADatos.GlobalException("No se ha localizado el driver");
        } catch (SQLException e) {
            throw new AccesoADatos.NoDataException("La base de datos no se encuentra disponible");
        }
        CallableStatement pstmt=null;
        
        try {
            pstmt = conexion.prepareCall("{? = call buscar_inscritoCarrera(?)}"); 
            pstmt.registerOutParameter(1, OracleTypes.CURSOR);
            pstmt.setInt(2,codigo);
             pstmt.execute();   
             ResultSet rs = (ResultSet) pstmt.getObject(1);   
                while(rs.next()){
                    alumnos.add(tipoAlumno(rs));
                }          
        } catch (SQLException e) {
            throw new AccesoADatos.GlobalException(e.getMessage());
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
                desconectar();
            } catch (SQLException e) {
                throw new AccesoADatos.GlobalException("Estatutos invalidos o nulos");
            }
        }
        return alumnos;  
    }
    
    public Usuario buscarUsuarioId(int id) throws AccesoADatos.GlobalException, AccesoADatos.NoDataException, SQLException, InstantiationException, IllegalAccessException  	{
        ArrayList<Usuario> usuarios = new ArrayList();
        try {
            conectar();
        } catch (ClassNotFoundException e) {
            throw new AccesoADatos.GlobalException("No se ha localizado el driver");
        } catch (SQLException e) {
            throw new AccesoADatos.NoDataException("La base de datos no se encuentra disponible");
        }
        CallableStatement pstmt=null;
        
        try {
            pstmt = conexion.prepareCall("{? = call buscar_Usuario_id(?)}");
            pstmt.registerOutParameter(1, OracleTypes.CURSOR);
            pstmt.setInt(2,id);
             pstmt.execute();              

             ResultSet rs = (ResultSet) pstmt.getObject(1);    
                while(rs.next()){
                    usuarios.add(tipoUsuario(rs));}
                                                  
        } catch (SQLException e) {
            throw new AccesoADatos.GlobalException(e.getMessage());
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
                desconectar();
            } catch (SQLException e) {
                throw new AccesoADatos.GlobalException("Estatutos invalidos o nulos");
            }
        }
        return usuarios.get(0);      
    }
     public Administrador buscarAdministradorId(int id) throws AccesoADatos.GlobalException, AccesoADatos.NoDataException, SQLException, InstantiationException, IllegalAccessException  	{
        ArrayList<Administrador> administradores = new ArrayList();
        try {
            conectar();
        } catch (ClassNotFoundException e) {
            throw new AccesoADatos.GlobalException("No se ha localizado el driver");
        } catch (SQLException e) {
            throw new AccesoADatos.NoDataException("La base de datos no se encuentra disponible");
        }
        CallableStatement pstmt=null;
        
        try {
            pstmt = conexion.prepareCall("{? = call buscar_Administrador_id(?)}");
            pstmt.registerOutParameter(1, OracleTypes.CURSOR);
            pstmt.setInt(2,id);
             pstmt.execute();              

             ResultSet rs = (ResultSet) pstmt.getObject(1);    
                while(rs.next()){
                    administradores.add(tipoAdministrador(rs));}
                                                  
        } catch (SQLException e) {
            throw new AccesoADatos.GlobalException(e.getMessage());
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
                desconectar();
            } catch (SQLException e) {
                throw new AccesoADatos.GlobalException("Estatutos invalidos o nulos");
            }
        }
        return administradores.get(0);      
    }
}
