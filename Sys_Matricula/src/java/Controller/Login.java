package Controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import AccesoADatos.GlobalException;
import AccesoADatos.NoDataException;
import Dao.Data;
import Dao.Service;
import Entities.Administrador;
import Entities.Alumno;
import Entities.Carrera;
import Entities.Curso;
import Entities.Profesor;
import Entities.Usuario;
import Services.Servicio_Busquedas;
import Services.Servicio_Estudiantes;
import Services.Servicio_Profesor;
import Services.Servicios_Generales;
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
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
@WebServlet(name = "Login", urlPatterns = {"/doLogin", "/doLogout"})
@MultipartConfig
public class Login extends HttpServlet {

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
        switch(request.getServletPath()){
            case "/doLogin":
                this.doLogin(request,response);
                break;
            case "/doLogout":
                this.doLogout(request,response);
                break;
            default:
               try{
                request.getRequestDispatcher("Home.jsp").
                        forward( request, response);
                }
               catch(Exception e){ 
                    String error = e.getMessage();
                    request.setAttribute("error",e);
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
             Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
         } catch (NoDataException ex) {
             Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
         } catch (SQLException ex) {
             Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
         } catch (InstantiationException ex) {
             Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
         } catch (IllegalAccessException ex) {
             Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
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
             Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
         } catch (NoDataException ex) {
             Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
         } catch (SQLException ex) {
             Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
         } catch (InstantiationException ex) {
             Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
         } catch (IllegalAccessException ex) {
             Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
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
    protected void doLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, GlobalException, NoDataException, SQLException, InstantiationException, IllegalAccessException {
        try{
            HttpSession http =  request.getSession(true);
            BufferedReader readerLog = request.getReader();
            PrintWriter out = response.getWriter();
            Gson gson = new Gson();           
            Usuario aux = gson.fromJson(readerLog, Usuario.class);           
            Service s = new Service();          
            Administrador admin = new Administrador();
            Profesor prof = new Profesor();
            Alumno alumn = new Alumno();
            ArrayList<Profesor> profes =  Servicio_Profesor.instance().verProfesores();
            ArrayList<Alumno> alumnos = Servicio_Estudiantes.instance().verAlumnos();
            ArrayList<Carrera> carreras = Servicio_Busquedas.instance().verCarreras();
            ArrayList<Curso> cursos = Servicio_Busquedas.instance().verCursos();
            ArrayList<Curso> cursosProf = new ArrayList();
            ArrayList<Curso> cursosAlumn = new ArrayList();
            while(alumnos.remove(null));
            while(profes.remove(null));
            while(cursos.remove(null));
            while(carreras.remove(null));
            Carrera cAl = new Carrera();
             if(s.doLogin(aux.getUsername(), aux.getClave())){
             Usuario u = Servicio_Busquedas.instance().buscarUsuarioId(aux.getUsername());
             switch(u.getRol()){
                 case "Administrador":
                    admin = Data.instance().getServiciobusquedas().buscarAdministradorId(u.getUsername());                                               
                    out.write(gson.toJson(u));
                    http.setAttribute("user", u);            
                    http.setAttribute("admin", admin);
                    http.setAttribute("carreras", carreras);
                    http.setAttribute("cursos", cursos);
                    http.setAttribute("alumnos", alumnos);
                    http.setAttribute("profes", profes);
                    response.setStatus(200); // successfull                   
                 break;
                 case "Profesor":
                     prof = Data.instance().getServiciobusquedas().buscarProfeId(u.getUsername());   
                     cursosProf = Servicio_Busquedas.instance().buscarCursoXprofesor(prof.getCedula());                   
                     out.write(gson.toJson(u));
                     http.setAttribute("user", u);                        
                     http.setAttribute("prof", prof); 
                     http.setAttribute("cursosProf", cursosProf);
                     response.setStatus(200); // successfull                    
                 break; 
                 case "Alumno":
                     alumn = Data.instance().getServiciobusquedas().buscarAlumnoId(u.getUsername());
                     cursosAlumn = Data.instance().getServiciobusquedas().buscarCursosXAlumno(u.getUsername());
                     cAl = Data.instance().getServiciobusquedas().buscarCarreraId(Data.instance().getServiciobusquedas().buscarCarreraXAlumno(u.getUsername()));
                     out.write(gson.toJson(u));
                     http.setAttribute("user", u);                                    
                     http.setAttribute("alumn", alumn);
                     http.setAttribute("carrera", cAl);
                     http.setAttribute("cursosAlum", cursosAlumn);
                     response.setStatus(200); // successfull                   
                 break; 
                 default: 
                     http.setAttribute("user", u); 
                     response.setStatus(200); // faild
                     request.getRequestDispatcher("Home.jsp").
                        forward( request, response);
                     break;
                }
                //http.setAttribute("user", u); 
                http.setAttribute("carrera", cAl);
                http.setAttribute("cursosAlum", cursosAlumn);
                http.setAttribute("admin", admin);
                http.setAttribute("alumn", alumn);
                http.setAttribute("prof", prof);    
                http.setAttribute("carreras", carreras);
                http.setAttribute("cursos", cursos);
                http.setAttribute("alumnos", alumnos);
                http.setAttribute("profes", profes);
                http.setAttribute("cursosProf", cursosProf);
               request.getRequestDispatcher("Perfil.jsp").
                        forward( request, response);
            }                                     
            else {
                throw new Exception("Usuario o contaseña invalidos");
            }
       }
       catch(Exception e){ String error = e.getMessage();
            request.setAttribute("error",error);
            response.setStatus(400); // faild
            request.getRequestDispatcher("Error.jsp").forward(request, response);           
        }
    }

    protected void doLogout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         try{
         request.getSession().invalidate();
         request.removeAttribute("admin");
         request.removeAttribute("prof");
         request.removeAttribute("alumn");
        request.getRequestDispatcher("Home.jsp").
                forward( request, response);
       }
       catch(Exception e){ String error = e.getMessage();
            request.setAttribute("error",error);
            response.setStatus(400); // faild
            request.getRequestDispatcher("Error.jsp").forward(request, response);
            
        }
    }

}
