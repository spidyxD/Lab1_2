package Controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Dao.Data;
import Entities.Alumno;
import Entities.Profesor;
import Entities.Usuario;
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
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
@WebServlet(name = "Administrador", urlPatterns = {"/Register","/SaveChanges", "/RegistroEstudiante","/RegistroProfesor","/ModificarEstudiante","/ModificarProfesor","/EliminarEstudiante","/EliminarProfesor"})
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
            case"/RegistroProfesor":
                this.doRegisterProfessor(request, response);
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
            BufferedReader readerUser = new BufferedReader(new InputStreamReader(request.getPart("Usuario").getInputStream()));
            BufferedReader readerAlumn = new BufferedReader(new InputStreamReader(request.getPart("Alumno").getInputStream()));
            PrintWriter out = response.getWriter();
            Gson gson = new Gson();
            Usuario u = gson.fromJson(readerUser, Usuario.class);
            Alumno al = gson.fromJson(readerAlumn, Alumno.class);
            response.setContentType("application/json; charset=UTF-8");       
            out.write(gson.toJson(u));
            out.write(gson.toJson(al));
            Data.instance().getServicioestudiante().insertarEstudiante(al, u);             
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
            BufferedReader readerUser = new BufferedReader(new InputStreamReader(request.getPart("Usuario").getInputStream()));
            BufferedReader readerAlumn = new BufferedReader(new InputStreamReader(request.getPart("Profesor").getInputStream()));
            PrintWriter out = response.getWriter();
            Gson gson = new Gson();
            Usuario u = gson.fromJson(readerUser, Usuario.class);
            Profesor prof = gson.fromJson(readerAlumn, Profesor.class);
            response.setContentType("application/json; charset=UTF-8");       
            out.write(gson.toJson(u));
            out.write(gson.toJson(prof));
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
            response.setContentType("application/json; charset=UTF-8");       
            out.write(gson.toJson(u));
            out.write(gson.toJson(al));
            Data.instance().getServicioestudiante().modificarEstudiante(al, u);             
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
            out.write(gson.toJson(u));
            out.write(gson.toJson(prof));
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
            HttpSession http =  request.getSession(true);
            BufferedReader readerLog = request.getReader();
            PrintWriter out = response.getWriter();
            Gson gson = new Gson();           
            Alumno aux = gson.fromJson(readerLog, Alumno.class);                                 
            response.setContentType("application/json; charset=UTF-8");                 
            Data.instance().getServicioestudiante().eliminarEstudiante(aux.getCedula());             
            response.setStatus(200);                 
         }
          catch(Exception e){ String error = e.getMessage();                     
                     request.setAttribute("error",error);
                     response.setStatus(401);
                     request.getRequestDispatcher("Error.jsp").forward(request, response);

                 }
    }

    private void doDeleteProfessor(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
          try{
            HttpSession http =  request.getSession(true);
            BufferedReader readerLog = request.getReader();
            PrintWriter out = response.getWriter();
            Gson gson = new Gson();           
            Profesor aux = gson.fromJson(readerLog, Profesor.class);                                 
            response.setContentType("application/json; charset=UTF-8");                 
            Data.instance().getServicioProfesor().eliminarProfesor(aux.getCedula());             
            response.setStatus(200);                 
         }
          catch(Exception e){ String error = e.getMessage();                     
                     request.setAttribute("error",error);
                     response.setStatus(401);
                     request.getRequestDispatcher("Error.jsp").forward(request, response);

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

    

}
