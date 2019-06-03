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
import Entities.Grupo;
import Entities.Profesor;
import Entities.Usuario;
import Services.Servicio_Busquedas;
import Services.Servicio_Estudiantes;
import Services.Servicio_Profesor;
import com.google.gson.Gson;
import java.io.IOException;
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
                this.reloadProfile(request, response);
                break;
               
              default:
                   try{
                request.getRequestDispatcher("Error.jsp").forward(request, response);
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
    private void reloadProfile(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       try
       { 
        Gson gson = new Gson(); 
        PrintWriter out = response.getWriter();    
        HttpSession http =  request.getSession(true);
        Usuario u = new Usuario();      
        int id = Integer.valueOf(request.getParameter("idUser"));
        String type = request.getParameter("type");
        if(id>0 && !type.equals("undefined") ){           
            if(type.equals("Alumno")){            
              String info = (String) request.getParameter("info");
                     switch(info){
                         case "perfil":
                             Alumno alumn = new Alumno();
                             alumn = Data.instance().getServiciobusquedas().buscarAlumnoId(id); 
                             String student = gson.toJson(alumn);
                             out.println(student);                                                         
                             response.setStatus(200); // successfull   
                             break;
                         case "cursosAlmuno":
                             ArrayList<Curso> cursosAlumn = new ArrayList();
                             cursosAlumn = Data.instance().getServiciobusquedas().buscarCursosXAlumno(id);
                             String coursesAl = gson.toJson(cursosAlumn);
                             out.println(coursesAl);
                             response.setStatus(200); // successfull   
                             break;
                         default:  break;    
                     }          
            }
            else if(type.equals("Profesor")){           
                     String data = (String) request.getParameter("data");
                     Profesor prof = new Profesor();
                     prof = Data.instance().getServiciobusquedas().buscarProfeId(id);
                     switch(data){
                         case "perfil":                                                           
                              String teacher = gson.toJson(prof);
                              out.println(teacher);
                              response.setStatus(200); // successfull 
                               break;
                         case "cursosProf":                             
                              ArrayList<Grupo> cursosProf = new ArrayList();                    
                              cursosProf = Servicio_Busquedas.instance().buscarCursoXprofesor(id);                   
                              String coursesTeach = gson.toJson(cursosProf);  
                              out.println(coursesTeach);    
                              response.setStatus(200); // successfull 
                              break;
                         default:  break;     
                     }                                                                          
               
            }
            else if(type.equals("Admin")){
                String action = (String) request.getParameter("action"); 
                    Entities.Administrador admin = new Entities.Administrador();
                    admin = Data.instance().getServiciobusquedas().buscarAdministradorId(u.getUsername());  
                    String administrador = gson.toJson(admin);
                    out.write(administrador); 
                    switch(action){
                        case "cursos":
                            ArrayList<Curso> cursos = Servicio_Busquedas.instance().verCursos();
                            while(cursos.remove(null));
                            String courses = gson.toJson(cursos);
                            out.write(courses); 
                            response.setStatus(200); // successfull 
                            break;
                        case "carreras":
                            ArrayList<Carrera> carreras = Servicio_Busquedas.instance().verCarreras();
                            while(carreras.remove(null));
                            String majores = gson.toJson(carreras);
                            out.write(majores);
                            response.setStatus(200); // successfull 
                            break;
                        case "alumnos":
                             ArrayList<Alumno> alumnos = Servicio_Estudiantes.instance().verAlumnos();
                             while(alumnos.remove(null));
                             String students = gson.toJson(alumnos);
                             out.write(students);
                             response.setStatus(200); // successfull 
                             break;
                        case "profesores":
                            ArrayList<Profesor> profes =  Servicio_Profesor.instance().verProfesores();
                            while(profes.remove(null));
                            String teachers = gson.toJson(profes);
                            out.write(teachers); 
                            response.setStatus(200); // successfull 
                            break;
                        default:  break;        
                    }       
            }
            
        }
       }
       catch(Exception e){ String error = e.getMessage();
            request.setAttribute("error",error);
            request.getRequestDispatcher("Error.jsp").forward(request, response);
            
        }
    }

    
    

}
