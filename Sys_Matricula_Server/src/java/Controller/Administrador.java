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
import Services.Servicio_Estudiantes;
import Services.Servicio_Profesor;
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
            case "/SaveChanges":
                this.SaveChanges(request,response);
                break;
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
            Gson gson = new Gson();
            Alumno al = new Alumno();
            
            al.setNombre((String)(request.getParameter("nombre")));
            al.setCedula(Integer.valueOf((String)request.getParameter("ced").trim()));
            al.setCreditos(Integer.valueOf(request.getParameter("cred")));
            al.setFecha_nacimiento((String)(request.getParameter("fechaN")));
            al.setEdad(Integer.valueOf(request.getParameter("edad")));
            al.setEmail((String)(request.getParameter("email")));
            al.setTelefono(Integer.valueOf(request.getParameter("cel")));
            
            Usuario u = new Usuario(al.getCedula(),"1234","Alumno");            
            String carrera = (String)(request.getParameter("carrera"));
            ArrayList<Carrera> carreras = Servicio_Busquedas.instance().verCarreras();
            int codigo = 0;
            for(Carrera c: carreras){
                if(c.getNombre().equals(carrera)){
                    codigo = c.getCodigo();
                    al.setCarrera(c);
                }
            }                             
            Data.instance().getServicioestudiante().insertarEstudiante(al, u, codigo);
            ArrayList<Alumno> alumnos = Servicio_Estudiantes.instance().verAlumnos();
            String students = gson.toJson(alumnos);
            out.write(students);   
            response.setContentType("application/json; charset=UTF-8");  
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
            Profesor prof = new Profesor();
            prof.setCedula(Integer.valueOf(request.getParameter("ced")));
            prof.setEdad(Integer.valueOf(request.getParameter("edad")));
            prof.setEmail((String)(request.getParameter("email")));
            prof.setNombre((String)(request.getParameter("nombre")));
            prof.setTelefono(Integer.valueOf(request.getParameter("cel")));
            Usuario u = new Usuario(prof.getCedula(),"1234","Profesor");                                
            Data.instance().getServicioProfesor().insertarProfesor(prof, u); 
             ArrayList<Profesor> profes =  Servicio_Profesor.instance().verProfesores();
            String teachers =  gson.toJson(profes);
            out.write(teachers);
            response.setContentType("application/json; charset=UTF-8");       
            response.setStatus(200);                 
         }
          catch(Exception e){ String error = e.getMessage();                     
                     request.setAttribute("error",error);
                     response.setStatus(401);
                     request.getRequestDispatcher("Error.jsp").forward(request, response);

                 }
    }

      @SuppressWarnings("empty-statement")
    private void doUpdateStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {         
         try{
            HttpSession s = request.getSession(true);
            PrintWriter out = response.getWriter();
            Gson gson = new Gson();
            Alumno al = new Alumno();
            al.setCarrera(new Carrera());
            al.setNombre((String)(request.getParameter("nombre")));
            al.setCedula(Integer.valueOf(request.getParameter("ced")));
            al.setCreditos(Integer.valueOf(request.getParameter("cred")));
            al.setFecha_nacimiento((String)(request.getParameter("fechaN")));
            al.setEdad(Integer.valueOf(request.getParameter("edad")));
            al.setEmail((String)(request.getParameter("email")));
            al.setTelefono(Integer.valueOf(request.getParameter("cel")));        
            Usuario u = new Usuario(al.getCedula(),(String)(request.getParameter("clave")),"Alumno");                            
            Data.instance().getServicioestudiante().modificarEstudiante(al, u);
            ArrayList<Alumno> alumnos = Servicio_Estudiantes.instance().verAlumnos();
            while(alumnos.remove(null));            
            String students = gson.toJson(alumnos);
            out.write(students);   
            response.setContentType("application/json; charset=UTF-8");     
            response.setStatus(200);                 
         }
          catch(Exception e){ String error = e.getMessage();                     
                     request.setAttribute("error",error);
                     response.setStatus(401);
                     request.getRequestDispatcher("Error.jsp").forward(request, response);
                 }
    }

      @SuppressWarnings("empty-statement")
    private void doUpdateProfessor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         try{
            HttpSession s = request.getSession(true);            
            PrintWriter out = response.getWriter();
            Gson gson = new Gson();
            Profesor prof = new Profesor();
            prof.setCedula(Integer.valueOf(request.getParameter("ced")));
            prof.setEdad(Integer.valueOf(request.getParameter("edad")));
            prof.setEmail((String)(request.getParameter("email")));
            prof.setNombre((String)(request.getParameter("nombre")));
            prof.setTelefono(Integer.valueOf(request.getParameter("cel")));
            Usuario u = new Usuario(prof.getCedula(),"1234","Profesor");                              
            Data.instance().getServicioProfesor().modificarProfesor(prof, u);         
            ArrayList<Profesor> profes =  Servicio_Profesor.instance().verProfesores();
            while(profes.remove(null));
            String teachers =  gson.toJson(profes);
            out.write(teachers);
            response.setContentType("application/json; charset=UTF-8");    
            response.setStatus(200);                 
         }
          catch(Exception e){ String error = e.getMessage();                     
                     request.setAttribute("error",error);
                     response.setStatus(401);
                     request.getRequestDispatcher("Error.jsp").forward(request, response);

                 }
    }

      @SuppressWarnings("empty-statement")
    private void doDeleteStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
           try{
            HttpSession s = request.getSession(true);
            Gson gson = new Gson();
            PrintWriter out = response.getWriter();         
            int id = Integer.valueOf(request.getParameter("id"));     
            Data.instance().getServicioestudiante().eliminarEstudiante(id);
            ArrayList<Alumno> alumnos = Servicio_Estudiantes.instance().verAlumnos();
            while(alumnos.remove(null));            
            String students = gson.toJson(alumnos);
            out.write(students);    
            response.setContentType("application/json; charset=UTF-8");   
            response.setStatus(200); //update successfull
           
      }
      catch(Exception ex){
           response.setStatus(401); //update not successfull
      }
    }

      @SuppressWarnings("empty-statement")
    private void doDeleteProfessor(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
          try{
              
            HttpSession s = request.getSession(true);
            Gson gson = new Gson();
            PrintWriter out = response.getWriter();         
            int id = Integer.valueOf(request.getParameter("id"));     
            Data.instance().getServicioProfesor().eliminarProfesor(id);
            ArrayList<Profesor> profes =  Servicio_Profesor.instance().verProfesores();
            while(profes.remove(null));
            String teachers =  gson.toJson(profes);
            out.write(teachers);
            response.setStatus(200); //update successfull
      }
      catch(Exception ex){
           response.setStatus(401); //update not successfull
      }
    }

    private void SaveChanges(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       try{ 
        HttpSession s = request.getSession(true);
       }
        catch(Exception e){ String error = e.getMessage();                     
                 request.setAttribute("error",error);
                 response.setStatus(401);
                 request.getRequestDispatcher("Error.jsp").forward(request, response);

             }
    }

      @SuppressWarnings("empty-statement")
    private void doDeleteCarrera(HttpServletRequest request, HttpServletResponse response) {
      try{
            HttpSession s = request.getSession(true);
            Gson gson = new Gson();
            PrintWriter out = response.getWriter();         
            int id = Integer.valueOf(request.getParameter("id"));             
            Data.instance().getServiciogenerales().eliminarCarrera(id);
            ArrayList<Carrera> carreras = Servicio_Busquedas.instance().verCarreras();
            while(carreras.remove(null));
            String majores = gson.toJson(carreras);
            out.write(majores);
            response.setStatus(200); //update successfull
      }
      catch(Exception ex){
           response.setStatus(401); //update not successfull
      }
    }

      @SuppressWarnings("empty-statement")
    private void doDeleteCurso(HttpServletRequest request, HttpServletResponse response) {
      try{
            HttpSession s = request.getSession(true);
            Gson gson = new Gson();
            PrintWriter out = response.getWriter();         
            int id = Integer.valueOf(request.getParameter("id"));        
            Data.instance().getServicioCursos().eliminarCurso(id);
            ArrayList<Curso> cursos = Servicio_Busquedas.instance().verCursos();
            while(cursos.remove(null));
            String majores = gson.toJson(cursos);
            out.write(majores);
            response.setStatus(200); //update successfull
      }
      catch(Exception ex){
           response.setStatus(401); //update not successfull
      }
    }

      @SuppressWarnings("empty-statement")
    private void doUpdateCourse(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            HttpSession s = request.getSession(true);
            BufferedReader readerCurso = new BufferedReader(new InputStreamReader(request.getPart("Curso").getInputStream()));
            PrintWriter out = response.getWriter();
            Gson gson = new Gson();
            Curso c = new Curso();
            c.setCodigo(Integer.valueOf(request.getParameter("codigo")));
            c.setCreditos(Integer.valueOf(request.getParameter("cred")));
            c.setHoras_semanales(Integer.valueOf(request.getParameter("horas")));
            c.setNombre((String)(request.getParameter("nombre")));
            Data.instance().getServicioCursos().modificarCurso(c.getCodigo(),c.getNombre(), c.getCreditos(), (int) c.getHoras_semanales());
            ArrayList<Curso> cursos = Servicio_Busquedas.instance().verCursos();
            while(cursos.remove(null));
            String courses = gson.toJson(cursos);
            out.write(courses);
            response.setContentType("application/json; charset=UTF-8"); 
            response.setStatus(200);                 
         }
          catch(Exception e){ String error = e.getMessage();                     
                     request.setAttribute("error",error);
                     response.setStatus(401);
                     request.getRequestDispatcher("Error.jsp").forward(request, response);

                 }
    }

      @SuppressWarnings("empty-statement")
    private void doUpdateCareer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       try{
            HttpSession s = request.getSession(true);
            BufferedReader readerCarrera = new BufferedReader(new InputStreamReader(request.getPart("Carrera").getInputStream()));
            PrintWriter out = response.getWriter();
            Gson gson = new Gson();
            Carrera c = new Carrera();
            c.setCodigo(Integer.valueOf(request.getParameter("codigo")));
            c.setCreditos((String)(request.getParameter("cred")));
            c.setNombre((String)(request.getParameter("nombre")));
            c.setTitulo((String)(request.getParameter("titulo")));        
            Data.instance().getServiciogenerales().modificarCarrera(c.getCodigo(),c.getNombre(), c.getTitulo());
            ArrayList<Carrera> carreras = Servicio_Busquedas.instance().verCarreras();
            while(carreras.remove(null));
            String majores = gson.toJson(carreras);
            out.write(majores);
            response.setContentType("application/json; charset=UTF-8");     
            response.setStatus(200);                 
         }
          catch(Exception e){ String error = e.getMessage();                     
                     request.setAttribute("error",error);
                     response.setStatus(401);
                     request.getRequestDispatcher("Error.jsp").forward(request, response);

                 }
    }

      @SuppressWarnings("empty-statement")
    private void doUpdateStudentAdmin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       try{
           HttpSession s = request.getSession(true);              
            PrintWriter out = response.getWriter();
            Gson gson = new Gson();
            Alumno al = new Alumno();
            al.setCarrera(new Carrera());
            al.setNombre((String)(request.getParameter("nombre")));
            al.setCedula(Integer.valueOf(request.getParameter("ced")));
            al.setCreditos(Integer.valueOf(request.getParameter("cred")));
            al.setFecha_nacimiento((String)(request.getParameter("fechaN")));
            al.setEdad(Integer.valueOf(request.getParameter("edad")));
            al.setEmail((String)(request.getParameter("email")));
            al.setTelefono(Integer.valueOf(request.getParameter("cel")));
            
            Usuario u = new Usuario(al.getCedula(),"1234","Alumno");            
            String carrera = (String)(request.getParameter("carrera"));
            ArrayList<Carrera> carreras = Servicio_Busquedas.instance().verCarreras();
            int codigo = 0;
            for(Carrera c: carreras){
                if(c.getNombre().equals(carrera)){
                    codigo = c.getCodigo();
                }
            }                             
            Data.instance().getServicioestudiante().modificarEstudianteAdmin(al, codigo);   
            ArrayList<Alumno> alumnos = Servicio_Estudiantes.instance().verAlumnos();
            while(alumnos.remove(null));
            String students = gson.toJson(alumnos);
            out.write(students);   
            response.setContentType("application/json; charset=UTF-8");  
            response.setStatus(200);                                                                                 
         }
          catch(Exception e){ String error = e.getMessage();                     
                     request.setAttribute("error",error);
                     response.setStatus(401);
                     request.getRequestDispatcher("Error.jsp").forward(request, response);
                 }
    }

      @SuppressWarnings("empty-statement")
    private void doUpdateProfessorAdmin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      try{
            HttpSession s = request.getSession(true);            
            PrintWriter out = response.getWriter();
            Gson gson = new Gson();
            Profesor prof = new Profesor();
            prof.setCedula(Integer.valueOf(request.getParameter("ced")));
            prof.setEdad(Integer.valueOf(request.getParameter("edad")));
            prof.setEmail((String)(request.getParameter("email")));
            prof.setNombre((String)(request.getParameter("nombre")));
            prof.setTelefono(Integer.valueOf(request.getParameter("cel")));
            Usuario u = new Usuario(prof.getCedula(),"1234","Profesor");                                
            Data.instance().getServicioProfesor().modificarProfesorAdmin(prof);
            ArrayList<Profesor> profes =  Servicio_Profesor.instance().verProfesores();
            while(profes.remove(null));
            String teachers =  gson.toJson(profes);
            out.write(teachers);
            response.setContentType("application/json; charset=UTF-8");       
            response.setStatus(200);                 
         }
          catch(Exception e){ String error = e.getMessage();                     
                     request.setAttribute("error",error);
                     response.setStatus(401);
                     request.getRequestDispatcher("Error.jsp").forward(request, response);

                 }
    }

      @SuppressWarnings("empty-statement")
    private void createCareer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            HttpSession s = request.getSession(true);
            BufferedReader readerCarrera = new BufferedReader(new InputStreamReader(request.getPart("Carrera").getInputStream()));
            PrintWriter out = response.getWriter();
            Gson gson = new Gson();
            Carrera c = new Carrera();
            c.setCodigo(Integer.valueOf(request.getParameter("codigo")));
            c.setCreditos((String)(request.getParameter("cred")));
            c.setNombre((String)(request.getParameter("nombre")));
            c.setTitulo((String)(request.getParameter("titulo")));        
            Data.instance().getServiciogenerales().crearCarrera(c.getCodigo(), c.getNombre(), c.getTitulo());   
            ArrayList<Profesor> profes =  Servicio_Profesor.instance().verProfesores();
            while(profes.remove(null));
            String teachers =  gson.toJson(profes);
            out.write(teachers);       
            response.setStatus(200);                 
         }
          catch(Exception e){ String error = e.getMessage();                     
                     request.setAttribute("error",error);
                     response.setStatus(401);
                     request.getRequestDispatcher("Error.jsp").forward(request, response);

                 }
    }

      @SuppressWarnings("empty-statement")
    private void createCourse(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         try{
              HttpSession s = request.getSession(true);
            BufferedReader readerCurso = new BufferedReader(new InputStreamReader(request.getPart("Curso").getInputStream()));
            PrintWriter out = response.getWriter();
            Gson gson = new Gson();
            Curso c = new Curso();
            c.setCodigo(Integer.valueOf(request.getParameter("codigo")));
            c.setCreditos(Integer.valueOf(request.getParameter("cred")));
            c.setHoras_semanales(Integer.valueOf(request.getParameter("horas")));
            c.setNombre((String)(request.getParameter("nombre")));
            Data.instance().getServicioCursos().crearCurso(c.getCodigo(), c.getNombre(), c.getCreditos(), (int) c.getHoras_semanales()); 
            ArrayList<Curso> cursos = Servicio_Busquedas.instance().verCursos();
            while(cursos.remove(null));
            String courses = gson.toJson(cursos);
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
