package Controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Dao.Data;
import Entities.Alumno;
import Entities.Carrera;
import Entities.Curso;
import Entities.Profesor;
import Entities.Usuario;
import Services.Servicio_Busquedas;
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.json.JSONArray;

/**
 *
 * @author Addiel
 */
@WebServlet(name = "Administrador", urlPatterns = {"/Register","/SaveChanges","/CrearCurso","/CrearCarrera", "/RegistroEstudiante","/RegistroProfesor","/ModificarAlumnoAdmin","/ModificarProfesorAdmin","/ModificarCurso","/ModificarCarrera","/ModificarEstudiante","/ModificarProfesor","/EliminarEstudiante","/EliminarProfesor","/EliminarCurso","/EliminarCarrera"})
@MultipartConfig
public class Administrador extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
      protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        switch (request.getServletPath()) {                
            case "/RegistroEstudiante":
                this.doRegisterStudent(request, response);
                break;
            case "/CrearCarrera":
                this.createCareer(request, response);
                break;    
            case "/CrearCurso":
                this.createCourse(request, response);
                break;    
            case"/RegistroProfesor":
                this.doRegisterProfessor(request, response);
                break;
            case"/ModificarCurso":
                this.doUpdateCourse(request, response);
                break;
            case"/ModificarCarrera":
                this.doUpdateCareer(request, response);
                break;
            case"/ModificarAlumnoAdmin":
                this.doUpdateStudentAdmin(request, response);
                break;
            case"/ModificarProfesorAdmin":
                this.doUpdateProfessorAdmin(request, response);
                break;                       
            case"/ModificarEstudiante":
                this.doUpdateStudent(request, response);
                break;
            case"/ModificarProfesor":
                this.doUpdateProfessor(request, response);
                break;
            case"/EliminarEstudiante":
                this.doDeleteStudent(request, response);
                break;
            case"/EliminarProfesor":
                this.doDeleteProfessor(request, response);
                break;
            case"/EliminarCarrera":
                this.doDeleteCarrera(request, response);
                break;
            case"/EliminarCurso":
                this.doDeleteCurso(request, response);
                break;    
            default:
                try{
                 request.getRequestDispatcher("Home.jsp").
                         forward( request, response);
                }
                catch(Exception e){ String error = e.getMessage();
                     request.setAttribute("error",error);
                     request.getRequestDispatcher("Error.jsp").forward(request, response);

                 }
                 break;
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

   private void doRegisterStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
           try{
            HttpSession s = request.getSession(true);                 
            PrintWriter out = response.getWriter();
            String nombre = (String)request.getParameter("nombre");
            String fechaN = (String)request.getParameter("fechaN");
            int cedula = Integer.valueOf((request.getParameter("cedula")));
            String email = (String)request.getParameter("email");
            int edad = Integer.valueOf((request.getParameter("edad")));
            int telefono = Integer.valueOf((request.getParameter("telefono")));
            Alumno al = new Alumno();            
            al.setCedula(cedula);
            al.setCreditos(cedula);
            al.setEdad(edad);
            al.setEmail(email);
            al.setFecha_nacimiento(fechaN);
            al.setNombre(nombre);
            al.setTelefono(telefono);
            al.setCreditos(14);
            String carrera = (String)request.getParameter("carrera");
            Gson gson = new Gson();        
            Usuario u = new Usuario(al.getCedula(),"1234","Alumno");            
           
            ArrayList<Carrera> carreras = Servicio_Busquedas.instance().verCarreras();
            int codigo = 0;
            for(Carrera c: carreras){
                if(c.getNombre().equals(carrera)){
                    codigo = c.getCodigo();
                }
            }             
            Data.instance().getServicioestudiante().insertarEstudiante(al, u, codigo); 
            ArrayList<Alumno> alumnos =  Data.instance().getServicioestudiante().verAlumnos();
            JSONArray jsArray = new JSONArray();
                for(Alumno a: alumnos){
                   jsArray.put(a);
                }
            String students = gson.toJson(jsArray);
            out.write(students);
            response.setStatus(200);                 
         }
          catch(Exception e){ String error = e.getMessage();                     
                     request.setAttribute("error",error);
                     response.setStatus(401);
                     request.getRequestDispatcher("Error.jsp").forward(request, response);

                 }
    
    }

    private void doRegisterProfessor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         try{
            HttpSession s = request.getSession(true);      
            PrintWriter out = response.getWriter();
            Gson gson = new Gson();
            String nombre = (String)request.getParameter("nombre");          
            int cedula = Integer.valueOf((request.getParameter("cedula")));
            String email = (String)request.getParameter("email");
            int edad = Integer.valueOf((request.getParameter("edad")));
            int telefono = Integer.valueOf((request.getParameter("telefono")));
            Profesor prof = new Profesor();
            prof.setCedula(cedula);
            prof.setEdad(edad);
            prof.setEmail(email);
            prof.setNombre(nombre);
            prof.setTelefono(telefono);
            Usuario u = new Usuario(prof.getCedula(),"1234","Profesor");           
            Data.instance().getServicioProfesor().insertarProfesor(prof, u);
            ArrayList<Profesor> profesores =  Data.instance().getServicioProfesor().verProfesores();
            JSONArray jsArray = new JSONArray();
                for(Profesor p: profesores){
                   jsArray.put(p);
                }
            String teachers = gson.toJson(profesores);
            out.write(teachers);
            response.setStatus(200);                 
         }
          catch(Exception e){ String error = e.getMessage();                     
                     request.setAttribute("error",error);
                     response.setStatus(401);
                     request.getRequestDispatcher("Error.jsp").forward(request, response);
                 }
    }

    private void doUpdateStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {         
         try{
            HttpSession s = request.getSession(true);
            PrintWriter out = response.getWriter();
             String nombre = (String)request.getParameter("nombre");
            String fechaN = (String)request.getParameter("fechaN");
            int cedula = Integer.valueOf((request.getParameter("cedula")));
            String email = (String)request.getParameter("email");
            int edad = Integer.valueOf((request.getParameter("edad")));
            int telefono = Integer.valueOf((request.getParameter("telefono")));
            Alumno al = new Alumno();            
            al.setCedula(cedula);
            al.setCreditos(cedula);
            al.setEdad(edad);
            al.setEmail(email);
            al.setFecha_nacimiento(fechaN);
            al.setNombre(nombre);
            al.setTelefono(telefono);
            al.setCreditos(14);
            String carrera = (String)request.getParameter("carrera");
            Gson gson = new Gson();        
            Usuario u = new Usuario(al.getCedula(),"1234","Alumno");                             
            Data.instance().getServicioestudiante().modificarEstudiante(al, u);
            out.write(gson.toJson(u));
            out.write(gson.toJson(al));
            response.setContentType("application/json; charset=UTF-8");     
            response.setStatus(200);                 
         }
          catch(Exception e){ String error = e.getMessage();                     
                     request.setAttribute("error",error);
                     response.setStatus(401);
                     request.getRequestDispatcher("Error.jsp").forward(request, response);
                 }
    }

    private void doUpdateProfessor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         try{
            HttpSession s = request.getSession(true);      
            PrintWriter out = response.getWriter();
            Gson gson = new Gson();
            String nombre = (String)request.getParameter("nombre");          
            int cedula = Integer.valueOf((request.getParameter("cedula")));
            String email = (String)request.getParameter("email");
            int edad = Integer.valueOf((request.getParameter("edad")));
            int telefono = Integer.valueOf((request.getParameter("telefono")));
            Profesor prof = new Profesor();
            prof.setCedula(cedula);
            prof.setEdad(edad);
            prof.setEmail(email);
            prof.setNombre(nombre);
            prof.setTelefono(telefono);
            Usuario u = new Usuario(prof.getCedula(),"1234","Profesor");  
            Data.instance().getServicioProfesor().modificarProfesor(prof, u);
            out.write(gson.toJson(u));
            out.write(gson.toJson(prof));
            response.setContentType("application/json; charset=UTF-8");  
            response.setStatus(200);                 
         }
          catch(Exception e){ String error = e.getMessage();                     
                     request.setAttribute("error",error);
                     response.setStatus(401);
                     request.getRequestDispatcher("Error.jsp").forward(request, response);

                 }
    }

    private void doDeleteStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
           try{
            HttpSession s = request.getSession(true);
            PrintWriter out = response.getWriter();
            Gson gson = new Gson();
            BufferedReader readerID = new BufferedReader(new InputStreamReader(request.getPart("ID").getInputStream()));  
            int id = gson.fromJson(readerID, Integer.class);     
            Data.instance().getServicioestudiante().eliminarEstudiante(id);
            ArrayList<Alumno> alumnos =  Data.instance().getServicioestudiante().verAlumnos();
             JSONArray jsArray = new JSONArray();
                for(Alumno a: alumnos){
                   jsArray.put(a);
                }
            String students = gson.toJson(jsArray);
            out.write(students);
            response.setStatus(200); //update successfull
      }
      catch(Exception ex){
           response.setStatus(401); //update not successfull
      }
    }

    private void doDeleteProfessor(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
          try{
              
            HttpSession s = request.getSession(true);
            PrintWriter out = response.getWriter();
            Gson gson = new Gson();
            BufferedReader readerID = new BufferedReader(new InputStreamReader(request.getPart("ID").getInputStream()));  
            int id = gson.fromJson(readerID, Integer.class);
            Data.instance().getServicioProfesor().eliminarProfesor(id);
            ArrayList<Profesor> profesores =  Data.instance().getServicioProfesor().verProfesores();
            JSONArray jsArray = new JSONArray();
                for(Profesor p: profesores){
                   jsArray.put(p);
                }
            String teachers = gson.toJson(profesores);
            out.write(teachers);
            response.setStatus(200); //update successfull     
      }
      catch(Exception ex){
           response.setStatus(401); //update not successfull
      }
    }

    private void doDeleteCarrera(HttpServletRequest request, HttpServletResponse response) {
      try{
            HttpSession s = request.getSession(true);
            PrintWriter out = response.getWriter();
            Gson gson = new Gson();
            BufferedReader readerID = new BufferedReader(new InputStreamReader(request.getPart("ID").getInputStream()));  
            int id = gson.fromJson(readerID, Integer.class);           
            Data.instance().getServiciogenerales().eliminarCarrera(id);
            ArrayList<Carrera> carreras =  Data.instance().getServiciobusquedas().verCarreras();
            JSONArray jsArray = new JSONArray();
                for(Carrera car: carreras){
                   jsArray.put(car);
                }         
            String majores = gson.toJson(jsArray);
            out.write(majores);
            response.setStatus(200); //update successfull        
      }
      catch(Exception ex){
           response.setStatus(401); //update not successfull
      }
    }

    private void doDeleteCurso(HttpServletRequest request, HttpServletResponse response) {
      try{
            HttpSession s = request.getSession(true);
            PrintWriter out = response.getWriter();
            Gson gson = new Gson();
            BufferedReader readerID = new BufferedReader(new InputStreamReader(request.getPart("ID").getInputStream()));  
            int id = gson.fromJson(readerID, Integer.class);     
            Data.instance().getServicioCursos().eliminarCurso(id);
            ArrayList<Curso> cursos =  Data.instance().getServicioCursos().verCursos();
            String courses = gson.toJson(cursos);
            out.write(courses);
            response.setStatus(200); //update successfull
      }
      catch(Exception ex){
           response.setStatus(401); //update not successfull
      }
    }

    private void doUpdateCourse(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            HttpSession s = request.getSession(true);                 
            PrintWriter out = response.getWriter();
            Gson gson = new Gson();
            Curso c = new Curso(); 
            int codigo = Integer.valueOf((request.getParameter("codigo")));
            String nombre = (String)request.getParameter("nombre");
            int creditos=Integer.valueOf((request.getParameter("codigo")));
            float horas_semanales=Integer.valueOf((request.getParameter("codigo")));
            c.setCodigo(codigo);
            c.setCreditos(creditos);
            c.setHoras_semanales(horas_semanales);
            c.setNombre(nombre);            
            Data.instance().getServicioCursos().modificarCurso(c.getCodigo(),c.getNombre(), c.getCreditos(), (int) c.getHoras_semanales());
            ArrayList<Curso> cursos =  Data.instance().getServicioCursos().verCursos();
              JSONArray jsArray = new JSONArray();
                for(Curso cur: cursos){
                   jsArray.put(cur);
                }         
            String courses = gson.toJson(jsArray);          
            out.write(courses);
            response.setStatus(200);                 
         }
          catch(Exception e){ String error = e.getMessage();                     
                     request.setAttribute("error",error);
                     response.setStatus(401);
                     request.getRequestDispatcher("Error.jsp").forward(request, response);

                 }
    }

    private void doUpdateCareer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       try{
            HttpSession s = request.getSession(true); 
            Gson gson = new Gson();                    
            PrintWriter out = response.getWriter();
            int codigo = Integer.valueOf((request.getParameter("codigo")));
            String creditos = (String)request.getParameter("creditos");
            String nombre = (String)request.getParameter("nombre");
            String titulo = (String)request.getParameter("titulo");
            Carrera c = new Carrera();  
            c.setCodigo(codigo);
            c.setCreditos(creditos);
            c.setNombre(nombre);
            c.setTitulo(titulo);              
            Data.instance().getServiciogenerales().modificarCarrera(c.getCodigo(),c.getNombre(), c.getTitulo());
            ArrayList<Carrera> carreras =  Data.instance().getServiciobusquedas().verCarreras();
            JSONArray jsArray = new JSONArray();
                for(Carrera car: carreras){
                   jsArray.put(car);
                }         
            String majores = gson.toJson(jsArray);      
            out.write(majores);
            response.setStatus(200);                 
         }
          catch(Exception e){ String error = e.getMessage();                     
                     request.setAttribute("error",error);
                     response.setStatus(401);
                     request.getRequestDispatcher("Error.jsp").forward(request, response);

                 }
    }

    private void doUpdateStudentAdmin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       try{
            HttpSession s = request.getSession(true);
            String nombre = (String)request.getParameter("nombre");
            String fechaN = (String)request.getParameter("fechaN");
            int cedula = Integer.valueOf((request.getParameter("cedula")));
            String email = (String)request.getParameter("email");
            int edad = Integer.valueOf((request.getParameter("edad")));
            int telefono = Integer.valueOf((request.getParameter("telefono")));
            Alumno al = new Alumno();            
            al.setCedula(cedula);
            al.setCreditos(cedula);
            al.setEdad(edad);
            al.setEmail(email);
            al.setFecha_nacimiento(fechaN);
            al.setNombre(nombre);
            al.setTelefono(telefono);
            al.setCreditos(14);
            String carrera = (String)request.getParameter("carrera");
            Gson gson = new Gson();                    
            PrintWriter out = response.getWriter();
            ArrayList<Carrera> carreras = Servicio_Busquedas.instance().verCarreras();
            int codigo = 0;
            for(Carrera c: carreras){
                if(c.getNombre().equals(carrera)){
                    codigo = c.getCodigo();
                }
            }                              
            Data.instance().getServicioestudiante().modificarEstudianteAdmin(al, codigo);
            ArrayList<Alumno> alumnos =  Data.instance().getServicioestudiante().verAlumnos();
             JSONArray jsArray = new JSONArray();
                for(Alumno a: alumnos){
                   jsArray.put(a);
                }
            String students = gson.toJson(jsArray);
            out.write(students);
            response.setStatus(200);                 
         }
          catch(Exception e){ String error = e.getMessage();                     
                     request.setAttribute("error",error);
                     response.setStatus(401);
                     request.getRequestDispatcher("Error.jsp").forward(request, response);
                 }
    }

    private void doUpdateProfessorAdmin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      try{
           HttpSession s = request.getSession(true);      
            PrintWriter out = response.getWriter();
            Gson gson = new Gson();
            String nombre = (String)request.getParameter("nombre");          
            int cedula = Integer.valueOf((request.getParameter("cedula")));
            String email = (String)request.getParameter("email");
            int edad = Integer.valueOf((request.getParameter("edad")));
            int telefono = Integer.valueOf((request.getParameter("telefono")));
            Profesor prof = new Profesor();
            prof.setCedula(cedula);
            prof.setEdad(edad);
            prof.setEmail(email);
            prof.setNombre(nombre);
            prof.setTelefono(telefono);           
            Data.instance().getServicioProfesor().modificarProfesorAdmin(prof);
            ArrayList<Profesor> profesores =  Data.instance().getServicioProfesor().verProfesores();
            JSONArray jsArray = new JSONArray();
                for(Profesor p: profesores){
                   jsArray.put(p);
                }
            String teachers = gson.toJson(jsArray);
            out.write(teachers);
            response.setStatus(200);                 
         }
          catch(Exception e){ String error = e.getMessage();                     
                     request.setAttribute("error",error);
                     response.setStatus(401);
                     request.getRequestDispatcher("Error.jsp").forward(request, response);

                 }
    }

    private void createCareer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            HttpSession s = request.getSession(true);                
            int codigo = Integer.valueOf((request.getParameter("codigo")));
            String creditos = (String)request.getParameter("creditos");
            String nombre = (String)request.getParameter("nombre");
            String titulo = (String)request.getParameter("titulo");
            Carrera c = new Carrera();  
            c.setCodigo(codigo);
            c.setCreditos(creditos);
            c.setNombre(nombre);
            c.setTitulo(titulo);
            PrintWriter out = response.getWriter();
            Gson gson = new Gson();
                                                
            Data.instance().getServiciogenerales().crearCarrera(c.getCodigo(), c.getNombre(), c.getTitulo());
            ArrayList<Carrera> carreras =  Data.instance().getServiciobusquedas().verCarreras();
             JSONArray jsArray = new JSONArray();
                for(Carrera car: carreras){
                   jsArray.put(car);
                }         
            String majores = gson.toJson(jsArray);
            out.write(majores);
            response.setStatus(200);                 
         }
          catch(Exception e){ String error = e.getMessage();                     
                     request.setAttribute("error",error);
                     response.setStatus(401);
                     request.getRequestDispatcher("Error.jsp").forward(request, response);

                 }
    }

    private void createCourse(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         try{
            HttpSession s = request.getSession(true);                 
            PrintWriter out = response.getWriter();
            Gson gson = new Gson();
            Curso c = new Curso(); 
            int codigo = Integer.valueOf((request.getParameter("codigo")));
            String nombre = (String)request.getParameter("nombre");
            int creditos=Integer.valueOf((request.getParameter("codigo")));
            float horas_semanales=Integer.valueOf((request.getParameter("codigo")));
            c.setCodigo(codigo);
            c.setCreditos(creditos);
            c.setHoras_semanales(horas_semanales);
            c.setNombre(nombre);
            Data.instance().getServicioCursos().crearCurso(c.getCodigo(), c.getNombre(), c.getCreditos(), (int) c.getHoras_semanales());             
            ArrayList<Curso> cursos =  Data.instance().getServicioCursos().verCursos();
             JSONArray jsArray = new JSONArray();
                for(Curso cur: cursos){
                   jsArray.put(cur);
                }         
            String courses = gson.toJson(jsArray);
            out.write(courses);
            response.setStatus(200);                 
         }
          catch(Exception e){ String error = e.getMessage();                     
                     request.setAttribute("error",error);
                     response.setStatus(401);
                     request.getRequestDispatcher("Error.jsp").forward(request, response);

                 }
    }

   
    

}
