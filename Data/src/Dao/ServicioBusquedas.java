/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Entities.Alumno;
import Entities.Carrera;
import Entities.Ciclo;
import Entities.Curso;
import Entities.Grupo;
import Entities.Profesor;
import Entities.Rendimiento_grupo;
import Entities.Usuario;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
    
      private Grupo tipoGrupo(ResultSet rs){
        try{
            Grupo g = new Grupo();
            g.setCapacidad(rs.getInt("capacidad"));
            g.setCurso(tipoCurso(rs));
            g.setHorario(rs.getString("horario"));
            g.setNrc(0);
            g.setPorfesor(tipoProfesor(rs));
            return g;
        }
        catch (SQLException ex) {
            return null;
        }
    }
    
    private Ciclo tipoCiclo(ResultSet rs){
        try{
            Ciclo c = new Ciclo();
            c.setCodigo(rs.getInt("codigo"));
            c.setDescripcion(rs.getString("descripcion"));
            c.setFecha_finalizacion(rs.getDate("fecha_finalizacion"));
            c.setFecha_inicio(rs.getDate("fecha_inicio"));
            return c;
        }
        catch (SQLException ex) {
            return null;
        }
    }
      
    private Alumno tipoAlumno(ResultSet rs){
        try{
            Alumno a = new Alumno();
            a.setCedula(rs.getInt("cedula"));
            a.setEdad(rs.getInt("edad"));
            a.setEmail(rs.getString("email"));
            a.setFecha_nacimiento(rs.getDate("fecha_nacimiento"));
            a.setNombre(rs.getString(""));
            return a;
        }
        catch (SQLException ex) {
            return null;
        }
    }
    
     private Rendimiento_grupo tipoRendimiento(ResultSet rs){
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
            u.setRol(rs.getString("nombre"));
            u.setUsername(rs.getInt("id"));
            return u;
        }
        catch (SQLException ex) {
            return null;
        }
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
            System.out.println(rs);                
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
                    System.out.println(rs);
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
                pstmt = conexion.prepareCall("{? = call buscar_carrera_id(?)}");
                pstmt.registerOutParameter(1, OracleTypes.CURSOR);
                pstmt.setInt(2,codigo);
                pstmt.execute();               
                ResultSet rs = (ResultSet) pstmt.getObject(1);                  
                    System.out.println(rs);
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
                System.out.println(rs);
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
                System.out.println(rs);
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
            pstmt.executeUpdate();
            // pstmt.execute();              
             ResultSet rs = (ResultSet) pstmt.getObject(1);  
                System.out.println(rs);
                //while(rs.next()){
                rs.next();
                    alumnos.add(tipoAlumno(rs));
                //}
                                                  
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
                System.out.println(rs);
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
                System.out.println(rs);
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
                System.out.println(rs);
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
                
                System.out.println(rs);
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
                System.out.println(rs);
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
}
