/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Addiel
 */
@WebServlet(name = "Busqueda", urlPatterns = {"/BusquedaCurso","/BusquedaProfesor","/BusquedaAlumnos","/BusquedaCarrera","/BusquedaCiclos","/BusquedaGrupos","/BusquedaAlumnoXcurso","/BusquedaCursoXcarrera"})
public class Busqueda extends HttpServlet {

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
            //Para Jobs
            case "/BusquedaAlumnos":
                System.out.print("AQUI ENTRE");
                this.doSearchStudents(request, response);
                break;
            case "/BusquedaProfesor"://al inicio de la busqueda
                this.doSearchProfesors(request, response);
                break;
            case "/BusquedaCurso"://al inicio de la busqueda
                this.doSearchCourses(request, response);
                break;
            case "/BusquedaCarrera"://al inicio de la busqueda
                this.doSearchCarrers(request, response);
                break;
            case "/BusquedaAlumnoXcurso"://al inicio de la busqueda
                this.doSearchStudentsXcourse(request, response);
                break;
            case "/BusquedaCursoXcarrera"://al inicio de la busqueda
                this.doSearchCoursesXcarrer(request, response);
                break;
            case "/BusquedaCiclos"://al inicio de la busqueda
                this.doSearchCiclos(request, response);
                break;    
            case "/BusquedaGrupos"://al inicio de la busqueda
                this.doSearchGrupos(request, response);
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

    private void doSearchStudents(HttpServletRequest request, HttpServletResponse response) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void doSearchProfesors(HttpServletRequest request, HttpServletResponse response) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void doSearchCourses(HttpServletRequest request, HttpServletResponse response) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void doSearchCarrers(HttpServletRequest request, HttpServletResponse response) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void doSearchStudentsXcourse(HttpServletRequest request, HttpServletResponse response) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void doSearchCoursesXcarrer(HttpServletRequest request, HttpServletResponse response) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void doSearchCiclos(HttpServletRequest request, HttpServletResponse response) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void doSearchGrupos(HttpServletRequest request, HttpServletResponse response) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
