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
            BufferedReader readerAlumn = new BufferedReader(new InputStreamReader(request.getPart("Alumno").getInputStream()));
            BufferedReader readerCarrera = new BufferedReader(new InputStreamReader(request.getPart("Carrera").getInputStream()));
            PrintWriter out = response.getWriter();
            Gson gson = new Gson();
            Alumno al = gson.fromJson(readerAlumn, Alumno.class);
            Usuario u = new Usuario(al.getCedula(),"1234","Alumno");            
            String carrera = gson.fromJson(readerCarrera, String.class);
            ArrayList<Carrera> carreras = Servicio_Busquedas.instance().verCarreras();
            int codigo = 0;
            for(Carrera c: carreras){
                if(c.getNombre().equals(carrera)){
                    codigo = c.getCodigo();
                }
            }
            response.setContentType("application/json; charset=UTF-8");                
            Data.instance().getServicioestudiante().insertarEstudiante(al, u, codigo);             
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
            BufferedReader readerAlumn = new BufferedReader(new InputStreamReader(request.getPart("Profesor").getInputStream()));
            PrintWriter out = response.getWriter();
            Gson gson = new Gson();
            Profesor prof = gson.fromJson(readerAlumn, Profesor.class);
            Usuario u = new Usuario(prof.getCedula(),"1234","Profesor");          
            response.setContentType("application/json; charset=UTF-8");       
            Data.instance().getServicioProfesor().insertarProfesor(prof, u);             
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
            BufferedReader readerUser = new BufferedReader(new InputStreamReader(request.getPart("Usuario").getInputStream()));
            BufferedReader readerAlumn = new BufferedReader(new InputStreamReader(request.getPart("Alumno").getInputStream()));
            PrintWriter out = response.getWriter();
            Gson gson = new Gson();
            Usuario u = gson.fromJson(readerUser, Usuario.class);
            Alumno al = gson.fromJson(readerAlumn, Alumno.class);                        
            Data.instance().getServicioestudiante().modificarEstudiante(al, u);
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
            BufferedReader readerUser = new BufferedReader(new InputStreamReader(request.getPart("Usuario").getInputStream()));
            BufferedReader readerAlumn = new BufferedReader(new InputStreamReader(request.getPart("Profesor").getInputStream()));
            PrintWriter out = response.getWriter();
            Gson gson = new Gson();
            Usuario u = gson.fromJson(readerUser, Usuario.class);
            Profesor prof = gson.fromJson(readerAlumn, Profesor.class);
            response.setContentType("application/json; charset=UTF-8");       
            Data.instance().getServicioProfesor().modificarProfesor(prof, u);             
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
            int id = Integer.valueOf(request.getParameter("id"));
            Data.instance().getServicioestudiante().eliminarEstudiante(id);
            response.setStatus(200); //update successfull
            request.getRequestDispatcher("Perfil.jsp").forward(request, response);
      }
      catch(Exception ex){
           response.setStatus(401); //update not successfull
      }
    }

    private void doDeleteProfessor(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
          try{
            int id = Integer.valueOf(request.getParameter("id"));
            Data.instance().getServicioProfesor().eliminarProfesor(id);
            response.setStatus(200); //update successfull
            request.getRequestDispatcher("Perfil.jsp").forward(request, response);
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

    private void doDeleteCarrera(HttpServletRequest request, HttpServletResponse response) {
      try{
            int codigo = Integer.valueOf(request.getParameter("codigo"));
            Data.instance().getServiciogenerales().eliminarCarrera(codigo);
            response.setStatus(200); //update successfull
            request.getRequestDispatcher("Perfil.jsp").forward(request, response);
      }
      catch(Exception ex){
           response.setStatus(401); //update not successfull
      }
    }

    private void doDeleteCurso(HttpServletRequest request, HttpServletResponse response) {
      try{
            int codigo = Integer.valueOf(request.getParameter("codigo"));
            Data.instance().getServicioCursos().eliminarCurso(codigo);
            response.setStatus(200); //update successfull
            request.getRequestDispatcher("Perfil.jsp").forward(request, response);
      }
      catch(Exception ex){
           response.setStatus(401); //update not successfull
      }
    }

    private void doUpdateCourse(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            HttpSession s = request.getSession(true);
            BufferedReader readerCurso = new BufferedReader(new InputStreamReader(request.getPart("Curso").getInputStream()));
            PrintWriter out = response.getWriter();
            Gson gson = new Gson();
            Curso c = gson.fromJson(readerCurso, Curso.class);
            response.setContentType("application/json; charset=UTF-8");       
            out.write(gson.toJson(c));
            Data.instance().getServicioCursos().modificarCurso(c.getCodigo(),c.getNombre(), c.getCreditos(), (int) c.getHoras_semanales());
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
            BufferedReader readerCarrera = new BufferedReader(new InputStreamReader(request.getPart("Carrera").getInputStream()));
            PrintWriter out = response.getWriter();
            Gson gson = new Gson();
            Carrera c = gson.fromJson(readerCarrera, Carrera.class);
            response.setContentType("application/json; charset=UTF-8");       
            Data.instance().getServiciogenerales().modificarCarrera(c.getCodigo(),c.getNombre(), c.getTitulo());
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
            BufferedReader readerUser = new BufferedReader(new InputStreamReader(request.getPart("Carrera").getInputStream()));
            BufferedReader readerAlumn = new BufferedReader(new InputStreamReader(request.getPart("Alumno").getInputStream()));
            PrintWriter out = response.getWriter();
            Gson gson = new Gson();
            String carrera = gson.fromJson(readerUser, String.class);
            ArrayList<Carrera> carreras = Servicio_Busquedas.instance().verCarreras();
            int codigo = 0;
            for(Carrera c: carreras){
                if(c.getNombre().equals(carrera)){
                    codigo = c.getCodigo();
                }
            }
            Alumno al = gson.fromJson(readerAlumn, Alumno.class);                        
            Data.instance().getServicioestudiante().modificarEstudianteAdmin(al, codigo);         
            response.setContentType("application/json; charset=UTF-8");     
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
            BufferedReader readerAlumn = new BufferedReader(new InputStreamReader(request.getPart("Profesor").getInputStream()));
            PrintWriter out = response.getWriter();
            Gson gson = new Gson();
            Profesor prof = gson.fromJson(readerAlumn, Profesor.class);
            response.setContentType("application/json; charset=UTF-8");       
            Data.instance().getServicioProfesor().modificarProfesorAdmin(prof);
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
            BufferedReader readerCarrera = new BufferedReader(new InputStreamReader(request.getPart("Carrera").getInputStream()));
            PrintWriter out = response.getWriter();
            Gson gson = new Gson();
            Carrera c = gson.fromJson(readerCarrera, Carrera.class);                
            response.setContentType("application/json; charset=UTF-8");                 
            Data.instance().getServiciogenerales().crearCarrera(c.getCodigo(), c.getNombre(), c.getTitulo());             
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
            BufferedReader readerCarrera = new BufferedReader(new InputStreamReader(request.getPart("Curso").getInputStream()));
            PrintWriter out = response.getWriter();
            Gson gson = new Gson();
            Curso c = gson.fromJson(readerCarrera, Curso.class);                
            response.setContentType("application/json; charset=UTF-8");                 
            Data.instance().getServicioCursos().crearCurso(c.getCodigo(), c.getNombre(), c.getCreditos(), (int) c.getHoras_semanales());             
            response.setStatus(200);                 
         }
          catch(Exception e){ String error = e.getMessage();                     
                     request.setAttribute("error",error);
                     response.setStatus(401);
                     request.getRequestDispatcher("Error.jsp").forward(request, response);

                 }
    }

   
    

}
