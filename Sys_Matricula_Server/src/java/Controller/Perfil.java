/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import AccesoADatos.GlobalException;
import AccesoADatos.NoDataException;
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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Addiel
 */
@WebServlet(name = "Perfil", urlPatterns = {"/goPerfil","/EditarAlumno","/EditarProfesor"})
public class Perfil extends HttpServlet {

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
            throws ServletException, IOException, GlobalException, NoDataException, InstantiationException, IllegalAccessException {
          switch (request.getServletPath()) {          
              case "/goPerfil":
                this.loadProfile(request, response);
                break;
              case "/EditarAlumno":
                this.doUpdateStudent(request, response);
                break;
              case "/EditarProfesor":
                this.doUpdateProfessor(request, response);
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
         try {
             processRequest(request, response);
         } catch (GlobalException ex) {
             Logger.getLogger(Perfil.class.getName()).log(Level.SEVERE, null, ex);
         } catch (NoDataException ex) {
             Logger.getLogger(Perfil.class.getName()).log(Level.SEVERE, null, ex);
         } catch (InstantiationException ex) {
             Logger.getLogger(Perfil.class.getName()).log(Level.SEVERE, null, ex);
         } catch (IllegalAccessException ex) {
             Logger.getLogger(Perfil.class.getName()).log(Level.SEVERE, null, ex);
         }
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
         try {
             processRequest(request, response);
         } catch (GlobalException ex) {
             Logger.getLogger(Perfil.class.getName()).log(Level.SEVERE, null, ex);
         } catch (NoDataException ex) {
             Logger.getLogger(Perfil.class.getName()).log(Level.SEVERE, null, ex);
         } catch (InstantiationException ex) {
             Logger.getLogger(Perfil.class.getName()).log(Level.SEVERE, null, ex);
         } catch (IllegalAccessException ex) {
             Logger.getLogger(Perfil.class.getName()).log(Level.SEVERE, null, ex);
         }
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

   

     @SuppressWarnings("empty-statement")
    private void loadProfile(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       try
       { 
        Gson gson = new Gson(); 
        PrintWriter out = response.getWriter();       
        HttpSession http =  request.getSession(true);
        int id = Integer.valueOf(request.getParameter("idUser"));
         String type = request.getParameter("type");
        if(id>0 && !type.equals("undefined") ){           
            if(type.equals("Alumno")){
            
             Alumno a = Data.instance().getServiciobusquedas().buscarAlumnoId(id);
             //http.removeAttribute("alumn");
            out.write(gson.toJson(a));
            }
            else if(type.equals("Profesor")){
           
             Profesor p = Data.instance().getServiciobusquedas().buscarProfeId(id);
             //http.removeAttribute("prof");
             out.write(gson.toJson(p));
            }
        }
        ArrayList<Profesor> profes =  Servicio_Profesor.instance().verProfesores();
        ArrayList<Alumno> alumnos = Servicio_Estudiantes.instance().verAlumnos();
        ArrayList<Carrera> carreras = Servicio_Busquedas.instance().verCarreras();
        ArrayList<Curso> cursos = Servicio_Busquedas.instance().verCursos();
        while(alumnos.remove(null));
        while(profes.remove(null));
        while(cursos.remove(null));
        while(carreras.remove(null));
       out.write(gson.toJson(carreras));
       out.write(gson.toJson(cursos));
       out.write(gson.toJson(alumnos));
       out.write(gson.toJson(profes));
       
       }
       catch(Exception e){ String error = e.getMessage();
            request.setAttribute("error",error);
            request.getRequestDispatcher("Error.jsp").forward(request, response);
            
        }
    }
    
     private void doUpdateStudent(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, GlobalException, NoDataException, InstantiationException, IllegalAccessException {
            try{          
            response.setStatus(200); //update successfull
            }  catch (Exception e) {
            String error = e.getMessage();
            request.setAttribute("error", error);  
            response.setStatus(401); //si hay un error en el update
        }
    }
    private void doUpdateProfessor(HttpServletRequest request, HttpServletResponse response) throws GlobalException, NoDataException, InstantiationException, IllegalAccessException, IOException, ServletException {
            try {          
            response.setStatus(200); //update successfull
            }  catch (Exception e) {
            String error = e.getMessage();
            request.setAttribute("error", error);  
            response.setStatus(401); //si hay un error en el update
        }
    }

}
