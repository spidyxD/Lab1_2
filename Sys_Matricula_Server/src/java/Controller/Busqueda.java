/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import AccesoADatos.GlobalException;
import AccesoADatos.NoDataException;
import Dao.Data;
import Dao.Service;
import Dao.ServicioGenerales;
import Entities.Alumno;
import Entities.Carrera;
import Entities.Ciclo;
import Entities.Curso;
import Entities.Grupo;
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
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
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
@WebServlet(name = "Busqueda", urlPatterns = {"/BusquedaCurso","/BusquedaProfesor","/BusquedaAlumnos","/BusquedaCarrera","/BusquedaCiclos","/BusquedaGrupos","/BusquedaAlumnoXcurso","/BusquedaCursoXcarrera","/BusquedaDatos"})
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
            throws ServletException, IOException, GlobalException, NoDataException, SQLException, InstantiationException, IllegalAccessException {
        
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
           case "/BusquedaAdminXId"://al inicio de la busqueda
                this.doSearchStudentsXcourse(request, response);
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
            case "/BusquedaDatos"://al inicio de la busqueda
                this.doCargarDatos(request, response);
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
             Logger.getLogger(Busqueda.class.getName()).log(Level.SEVERE, null, ex);
         } catch (NoDataException ex) {
             Logger.getLogger(Busqueda.class.getName()).log(Level.SEVERE, null, ex);
         } catch (SQLException ex) {
             Logger.getLogger(Busqueda.class.getName()).log(Level.SEVERE, null, ex);
         } catch (InstantiationException ex) {
             Logger.getLogger(Busqueda.class.getName()).log(Level.SEVERE, null, ex);
         } catch (IllegalAccessException ex) {
             Logger.getLogger(Busqueda.class.getName()).log(Level.SEVERE, null, ex);
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
             Logger.getLogger(Busqueda.class.getName()).log(Level.SEVERE, null, ex);
         } catch (NoDataException ex) {
             Logger.getLogger(Busqueda.class.getName()).log(Level.SEVERE, null, ex);
         } catch (SQLException ex) {
             Logger.getLogger(Busqueda.class.getName()).log(Level.SEVERE, null, ex);
         } catch (InstantiationException ex) {
             Logger.getLogger(Busqueda.class.getName()).log(Level.SEVERE, null, ex);
         } catch (IllegalAccessException ex) {
             Logger.getLogger(Busqueda.class.getName()).log(Level.SEVERE, null, ex);
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

    private void doSearchStudents(HttpServletRequest request, HttpServletResponse response) {
        try{
            HttpSession http =  request.getSession(true);
            BufferedReader readerLog = request.getReader();
            PrintWriter out = response.getWriter();
            Gson gson = new Gson();       
       }
       catch(Exception e){}
    }
     private void doCargarDatos(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Gson gson = new Gson(); 
        PrintWriter out = response.getWriter();   
        try{                                                  
            Service s = new Service();    
             HttpSession http =  request.getSession(true);
             String action = (String) request.getParameter("action"); 
                    switch(action){
                        case "cursos":
                            ArrayList<Curso> cursos = Servicio_Busquedas.instance().verCursos();
                            while(cursos.remove(null));
                            JSONArray jsArray0 = new JSONArray();
                            for(Curso c: cursos){
                               jsArray0.put(c);
                            }
                            String courses = gson.toJson(jsArray0);
                            out.write(courses); 
                            response.setStatus(200); // successfull 
                            break;
                        case "carreras":
                            ArrayList<Carrera> carreras = Servicio_Busquedas.instance().verCarreras();
                            while(carreras.remove(null));
                            JSONArray jsArray = new JSONArray();
                            for(Carrera c: carreras){
                               jsArray.put(c);
                            }
                            String majores = gson.toJson(jsArray);
                            out.write(majores);
                            response.setStatus(200); // successfull 
                            break;
                        case "alumnos":
                             ArrayList<Alumno> alumnos = Servicio_Estudiantes.instance().verAlumnos();
                             while(alumnos.remove(null));
                             JSONArray jsArray2 = new JSONArray();
                                for(Alumno a: alumnos){
                                   jsArray2.put(a);
                                }
                             String students = gson.toJson(jsArray2);
                             out.write(students);
                             response.setStatus(200); // successfull 
                             break;
                        case "profesores":
                            ArrayList<Profesor> profes =  Servicio_Profesor.instance().verProfesores();
                            while(profes.remove(null));
                             JSONArray jsArray3 = new JSONArray();
                                for(Profesor p: profes){
                                   jsArray3.put(p);
                                }
                            String teachers = gson.toJson(jsArray3);
                            out.write(teachers); 
                            response.setStatus(200); // successfull 
                            break;
                          case "ciclos":
                            ArrayList<Ciclo> ciclos =  Servicio_Busquedas.instance().verCiclos();
                            while(ciclos.remove(null));
                             JSONArray jsArray5 = new JSONArray();
                                for(Ciclo c: ciclos){
                                   jsArray5.put(c);
                                }
                            String cicloss = gson.toJson(jsArray5);
                            out.write(cicloss); 
                            response.setStatus(200); // successfull 
                            break;
                          case "grupos":
                            ArrayList<Grupo> grupos =  Servicio_Busquedas.instance().verGrupos();
                            while(grupos.remove(null));
                             JSONArray jsArray6 = new JSONArray();
                                for(Grupo p: grupos){
                                   jsArray6.put(p);
                                }
                            String gruposs = gson.toJson(jsArray6);
                            out.write(gruposs); 
                            response.setStatus(200); // successfull 
                            break;    
                        default:  break;        
                    }       
                response.setContentType("application/json; charset=UTF-8"); 
            
       }
       catch(Exception e){ String error = e.getMessage();
            out.println("Usuario o contaseña invalidos");  
            response.setStatus(400); // faild
            request.getRequestDispatcher("Error.jsp").forward(request, response);           
        }
        finally {
            out.close();
        }
    }

    private void doSearchProfesors(HttpServletRequest request, HttpServletResponse response) {
        try{
            HttpSession http =  request.getSession(true);
            BufferedReader readerLog = request.getReader();
            PrintWriter out = response.getWriter();
            Gson gson = new Gson();       
       }
       catch(Exception e){}
    }

    private void doSearchCourses(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, GlobalException, NoDataException, SQLException, InstantiationException, IllegalAccessException {       
         try{
            HttpSession http = request.getSession(true);
            BufferedReader readerCurso = new BufferedReader(new InputStreamReader(request.getPart("curso").getInputStream()));
            List<Curso> cursos = Data.instance().getServicioCursos().verCursos();                
            PrintWriter out = response.getWriter();
            Gson gson = new Gson();
            String curso = gson.fromJson(readerCurso, String.class);   
       }
       catch(Exception e){}
    }

    private void doSearchCarrers(HttpServletRequest request, HttpServletResponse response) {
         try{
            HttpSession http =  request.getSession(true);
            BufferedReader readerLog = request.getReader();
            PrintWriter out = response.getWriter();
            Gson gson = new Gson();       
       }
       catch(Exception e){}
    }

    private void doSearchStudentsXcourse(HttpServletRequest request, HttpServletResponse response) {
         try{
            HttpSession http =  request.getSession(true);
            BufferedReader readerLog = request.getReader();
            PrintWriter out = response.getWriter();
            Gson gson = new Gson();       
       }
       catch(Exception e){}
    }

    private void doSearchCoursesXcarrer(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, GlobalException, NoDataException, SQLException, InstantiationException, IllegalAccessException {
        HttpSession http = request.getSession(true);       
        List<Curso> cursos = Data.instance().getServiciobusquedas().buscarCursoXCarrera(0);
        List<Carrera> carreras = (List<Carrera>) request.getAttribute("carreras");
        PrintWriter out = response.getWriter();
        Gson gson = new Gson();
        String carrera = (String) request.getAttribute("carrera");
        
    }
    

    private void doSearchCiclos(HttpServletRequest request, HttpServletResponse response) {
         try{
            HttpSession http =  request.getSession(true);
            BufferedReader readerLog = request.getReader();
            PrintWriter out = response.getWriter();
            Gson gson = new Gson();       
       }
       catch(Exception e){}
    }

    private void doSearchGrupos(HttpServletRequest request, HttpServletResponse response) {
       try{
            HttpSession http =  request.getSession(true);
            BufferedReader readerLog = request.getReader();
            PrintWriter out = response.getWriter();
            Gson gson = new Gson();
            String curso = "";
       }
       catch(Exception e){}
    }

}
