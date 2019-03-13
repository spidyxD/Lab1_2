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

/**
 *
 * @author Addiel
 */
public class ServicioBusquedas extends Service{
    private static final String BUSCARCURSOID= "{call buscar_curso_id(?)}";
    private static final String BUSCARCURSONOMBRE= "{call buscar_curso_nombre(?)}";
    private static final String BUSCARCARRERA= "{call buscar_curso_carrera(?)}";
    private static final String BUSCARPROFCEDULA= "{call buscar_Profesor_cedula(?)}";
    private static final String BUSCARALUMNOCEDULA= "{call buscar_Alumno_ced(?)}";
    private static final String BUSCARALUMNOMBRE= "{call buscar_Alumno_nombre(?)}";
    private static final String BUSCARCURSOXALUMNO= "{call buscar_cursoXAlumno(?)}";
    private static final String BUSCARALUMNOXCURWO= "{call buscar_AlumnoXCurso(?)}";
    private static final String BUSCARCURSOXPROFESOR= "{call buscar_cursoXProfesor(?)}";
    private static final String BUSCARALUMNOSXCARRERA= "{call buscar_inscritoCarrera(?)}";
    
    
    
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
            a.setNombre(BUSCARALUMNOMBRE);
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
            p.setNombre(BUSCARALUMNOMBRE);
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
        try {
            conectar();
        } catch (ClassNotFoundException e) {
            throw new AccesoADatos.GlobalException("No se ha localizado el driver");
        } catch (SQLException e) {
            throw new AccesoADatos.NoDataException("La base de datos no se encuentra disponible");
        }
        CallableStatement pstmt=null;
        
        try {
            pstmt = conexion.prepareCall(BUSCARCURSOID);          
            pstmt.setInt(1,xcodigo);
            boolean resultado = pstmt.execute();
            
            if (resultado == true) {
                throw new AccesoADatos.NoDataException("No se realizo la busqueda");
            }
            else {
                ResultSet rs = pstmt.executeQuery();
                ArrayList<Curso> cursos = new ArrayList();
                System.out.println(rs);
                while(rs.next()){
                    cursos.add(tipoCurso(rs));
                }
                return cursos.get(0);
            }
            
        } catch (SQLException e) {
            throw new AccesoADatos.GlobalException("Llave duplicada");
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
        }
        
        public Curso buscarCursoNombre(String xnombre) throws AccesoADatos.GlobalException, AccesoADatos.NoDataException, SQLException, InstantiationException, IllegalAccessException  	{
        try {
            conectar();
        } catch (ClassNotFoundException e) {
            throw new AccesoADatos.GlobalException("No se ha localizado el driver");
        } catch (SQLException e) {
            throw new AccesoADatos.NoDataException("La base de datos no se encuentra disponible");
        }
        CallableStatement pstmt=null;
        
        try {
            pstmt = conexion.prepareCall(BUSCARCURSONOMBRE);          
            pstmt.setString(1,xnombre);
            boolean resultado = pstmt.execute();
            if (resultado == true) {
                throw new AccesoADatos.NoDataException("No se realizo la busqueda");
            }
            else{
             ResultSet rs = pstmt.executeQuery();
                ArrayList<Curso> cursos = new ArrayList();
                System.out.println(rs);
                while(rs.next()){
                    cursos.add(tipoCurso(rs));
                }
                return cursos.get(0);
            }
            
        } catch (SQLException e) {
            throw new AccesoADatos.GlobalException("Llave duplicada");
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
        
    }
        
     public Carrera buscarCarreraId(int codigo) throws AccesoADatos.GlobalException, AccesoADatos.NoDataException, SQLException, InstantiationException, IllegalAccessException  	{
        try {
            conectar();
        } catch (ClassNotFoundException e) {
            throw new AccesoADatos.GlobalException("No se ha localizado el driver");
        } catch (SQLException e) {
            throw new AccesoADatos.NoDataException("La base de datos no se encuentra disponible");
        }
        CallableStatement pstmt=null;
        
        try {
            pstmt = conexion.prepareCall(BUSCARCARRERA);          
            pstmt.setInt(1,codigo);
            boolean resultado = pstmt.execute();
            if (resultado == true) {
                throw new AccesoADatos.NoDataException("No se realizo la busqueda");
            }
            else{
             ResultSet rs = pstmt.executeQuery();
                ArrayList<Carrera> carreras = new ArrayList();
                System.out.println(rs);
                while(rs.next()){
                    carreras.add(tipoCarrera(rs));
                }
                return carreras.get(0);
            }
        } catch (SQLException e) {
            throw new AccesoADatos.GlobalException("Llave duplicada");
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
        
    }    
     
    
    public Profesor buscarProfeId(int id) throws AccesoADatos.GlobalException, AccesoADatos.NoDataException, SQLException, InstantiationException, IllegalAccessException  	{
        try {
            conectar();
        } catch (ClassNotFoundException e) {
            throw new AccesoADatos.GlobalException("No se ha localizado el driver");
        } catch (SQLException e) {
            throw new AccesoADatos.NoDataException("La base de datos no se encuentra disponible");
        }
        CallableStatement pstmt=null;
        
        try {
            pstmt = conexion.prepareCall(BUSCARPROFCEDULA);          
            pstmt.setInt(1,id);
            boolean resultado = pstmt.execute();
            if (resultado == true) {
                throw new AccesoADatos.NoDataException("No se realizo la busqueda");
            }
            else{
             ResultSet rs = pstmt.executeQuery();
                ArrayList<Profesor> profesores = new ArrayList();
                System.out.println(rs);
                while(rs.next()){
                    profesores.add(tipoProfesor(rs));
                }
                return profesores.get(0);
            }
            
        } catch (SQLException e) {
            throw new AccesoADatos.GlobalException("Llave duplicada");
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
        
    }     
    
    public Alumno buscarAlumnoId(int id) throws AccesoADatos.GlobalException, AccesoADatos.NoDataException, SQLException, InstantiationException, IllegalAccessException  	{
        try {
            conectar();
        } catch (ClassNotFoundException e) {
            throw new AccesoADatos.GlobalException("No se ha localizado el driver");
        } catch (SQLException e) {
            throw new AccesoADatos.NoDataException("La base de datos no se encuentra disponible");
        }
        CallableStatement pstmt=null;
        
        try {
            pstmt = conexion.prepareCall(BUSCARALUMNOCEDULA);          
            pstmt.setInt(1,id);
            boolean resultado = pstmt.execute();
            if (resultado == true) {
                throw new AccesoADatos.NoDataException("No se realizo la busqueda");
            }
             else{
             ResultSet rs = pstmt.executeQuery();
                ArrayList<Alumno> alumnos = new ArrayList();
                System.out.println(rs);
                while(rs.next()){
                    alumnos.add(tipoAlumno(rs));
                }
                return alumnos.get(0);
            }
            
        } catch (SQLException e) {
            throw new AccesoADatos.GlobalException("Llave duplicada");
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
        
    }     
    
     public Alumno buscarAlumnoNombre(String nombre) throws AccesoADatos.GlobalException, AccesoADatos.NoDataException, SQLException, InstantiationException, IllegalAccessException  	{
        try {
            conectar();
        } catch (ClassNotFoundException e) {
            throw new AccesoADatos.GlobalException("No se ha localizado el driver");
        } catch (SQLException e) {
            throw new AccesoADatos.NoDataException("La base de datos no se encuentra disponible");
        }
        CallableStatement pstmt=null;
        
        try {
            pstmt = conexion.prepareCall(BUSCARALUMNOMBRE);          
            pstmt.setString(1,nombre);
            boolean resultado = pstmt.execute();
            if (resultado == true) {
                throw new AccesoADatos.NoDataException("No se realizo la busqueda");
            }
             else{
             ResultSet rs = pstmt.executeQuery();
                ArrayList<Alumno> alumnos = new ArrayList();
                System.out.println(rs);
                while(rs.next()){
                    alumnos.add(tipoAlumno(rs));
                }
                return alumnos.get(0);
            }
            
        } catch (SQLException e) {
            throw new AccesoADatos.GlobalException("Llave duplicada");
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
        
    }    
     public ArrayList<Curso> buscarCursosXAlumno(int id) throws AccesoADatos.GlobalException, AccesoADatos.NoDataException, SQLException, InstantiationException, IllegalAccessException  	{
        try {
            conectar();
        } catch (ClassNotFoundException e) {
            throw new AccesoADatos.GlobalException("No se ha localizado el driver");
        } catch (SQLException e) {
            throw new AccesoADatos.NoDataException("La base de datos no se encuentra disponible");
        }
        CallableStatement pstmt=null;
        
        try {
            pstmt = conexion.prepareCall(BUSCARCURSOXALUMNO);          
            pstmt.setInt(1,id);
            boolean resultado = pstmt.execute();
            if (resultado == true) {
                throw new AccesoADatos.NoDataException("No se realizo la busqueda");
            }
             else{
             ResultSet rs = pstmt.executeQuery();
                ArrayList<Curso> cursos = new ArrayList();
                System.out.println(rs);
                while(rs.next()){
                    cursos.add(tipoCurso(rs));
                }
                return cursos;
            }
        } catch (SQLException e) {
            throw new AccesoADatos.GlobalException("Llave duplicada");
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
        
    }     
     
     
     
    public ArrayList<Alumno> buscarAlumnoXCurso(int codigo) throws AccesoADatos.GlobalException, AccesoADatos.NoDataException, SQLException, InstantiationException, IllegalAccessException  	{
        try {
            conectar();
        } catch (ClassNotFoundException e) {
            throw new AccesoADatos.GlobalException("No se ha localizado el driver");
        } catch (SQLException e) {
            throw new AccesoADatos.NoDataException("La base de datos no se encuentra disponible");
        }
        CallableStatement pstmt=null;
        
        try {
            pstmt = conexion.prepareCall(BUSCARALUMNOXCURWO);          
            pstmt.setInt(1,codigo);
            boolean resultado = pstmt.execute();
            if (resultado == true) {
                throw new AccesoADatos.NoDataException("No se realizo la busqueda");
            }
             else{
             ResultSet rs = pstmt.executeQuery();
                ArrayList<Alumno> alumnos = new ArrayList();
                System.out.println(rs);
                while(rs.next()){
                    alumnos.add(tipoAlumno(rs));
                }
                return alumnos;
            }
            
        } catch (SQLException e) {
            throw new AccesoADatos.GlobalException("Llave duplicada");
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
        
    }      
    
    public ArrayList<Curso> buscarCursoXprofesor(int codigo) throws AccesoADatos.GlobalException, AccesoADatos.NoDataException, SQLException, InstantiationException, IllegalAccessException  	{
        try {
            conectar();
        } catch (ClassNotFoundException e) {
            throw new AccesoADatos.GlobalException("No se ha localizado el driver");
        } catch (SQLException e) {
            throw new AccesoADatos.NoDataException("La base de datos no se encuentra disponible");
        }
        CallableStatement pstmt=null;
        
        try {
            pstmt = conexion.prepareCall(BUSCARCURSOXPROFESOR);          
            pstmt.setInt(1,codigo);
            boolean resultado = pstmt.execute();
            if (resultado == true) {
                throw new AccesoADatos.NoDataException("No se realizo la busqueda");
            }
            else{
             ResultSet rs = pstmt.executeQuery();
                ArrayList<Curso> cursos = new ArrayList();
                System.out.println(rs);
                while(rs.next()){
                    cursos.add(tipoCurso(rs));
                }
                return cursos;
            }
            
        } catch (SQLException e) {
            throw new AccesoADatos.GlobalException("Llave duplicada");
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
        
    }      
    
    
    public ArrayList<Alumno> buscarAlumnoXCarrera(int codigo) throws AccesoADatos.GlobalException, AccesoADatos.NoDataException, SQLException, InstantiationException, IllegalAccessException  	{
        try {
            conectar();
        } catch (ClassNotFoundException e) {
            throw new AccesoADatos.GlobalException("No se ha localizado el driver");
        } catch (SQLException e) {
            throw new AccesoADatos.NoDataException("La base de datos no se encuentra disponible");
        }
        CallableStatement pstmt=null;
        
        try {
            pstmt = conexion.prepareCall(BUSCARALUMNOSXCARRERA);          
            pstmt.setInt(1,codigo);
            boolean resultado = pstmt.execute();
            if (resultado == true) {
                throw new AccesoADatos.NoDataException("No se realizo la busqueda");
            }
            else{
             ResultSet rs = pstmt.executeQuery();
                ArrayList<Alumno> alumnos = new ArrayList();
                System.out.println(rs);
                while(rs.next()){
                    alumnos.add(tipoAlumno(rs));
                }
                return alumnos;
            }
        } catch (SQLException e) {
            throw new AccesoADatos.GlobalException("Llave duplicada");
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
        
    }      
}
