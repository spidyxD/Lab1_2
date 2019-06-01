/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entities.Carrera;
import Entities.Ciclo;
import Entities.Curso;
import Entities.Grupo;
import Services.Servicio_Busquedas;
import java.io.IOException;
import java.util.List;
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
@WebServlet(name = "Matricula", urlPatterns = {"/doMatricula,/goMatricula"})
public class Matricula extends HttpServlet {

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
            case "/goMatricula":
                this.goToMatricula(request, response);
                break;            
            case "/doMatricula":
                this.doMatricula(request, response);
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
    private void goToMatricula(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
        HttpSession s = request.getSession(true);           
        List<Ciclo> ciclos = Servicio_Busquedas.instance().verCiclos();      
        List<Carrera> carreras = Servicio_Busquedas.instance().verCarreras();
        List<Curso> cursos = Servicio_Busquedas.instance().verCursos();
        //List<Grupo> grupos = Servicio_Busquedas.instance().verGrupos();
        System.out.println(ciclos.size() + carreras.size());
        s.setAttribute("ciclos", ciclos);
        s.setAttribute("carreras", carreras);
        s.setAttribute("cursos",cursos);
        //request.setAttribute("grupos",grupos);
        request.getRequestDispatcher("Matricula.jsp").
                forward( request, response);
       }
       catch(Exception e){
           String error = e.getMessage();
            request.setAttribute("error",error);
            request.getRequestDispatcher("Error.jsp").forward(request, response);
            
        }
    }
    private void doMatricula(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      try{       
        request.getRequestDispatcher("Matricula.jsp").
                forward( request, response);
       }
       catch(Exception e){
           String error = e.getMessage();
            request.setAttribute("error",error);
            request.getRequestDispatcher("Error.jsp").forward(request, response);
            
        }
    }

}