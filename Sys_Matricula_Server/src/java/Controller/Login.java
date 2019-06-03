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
import com.google.gson.Gson;
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
import org.json.JSONArray;

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
                request.getRequestDispatcher("Error.jsp").
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
        Gson gson = new Gson(); 
        PrintWriter out = response.getWriter();   
        try{          
            Usuario aux = new Usuario();
            aux.setUsername(Integer.valueOf(request.getParameter("user")));
            aux.setClave((String) request.getParameter("password"));                                          
            Service s = new Service();                     
             if(s.doLogin(aux.getUsername(), aux.getClave())){
             Usuario u = Servicio_Busquedas.instance().buscarUsuarioId(aux.getUsername());
             String user = gson.toJson(u);  
             HttpSession http =  request.getSession(true);
             http.setAttribute(user, "user");
             out.write(user); 
             switch(u.getRol()){
                 case "Administrador":
                    String action = (String) request.getParameter("action"); 
                    Administrador admin = new Administrador();
                    admin = Data.instance().getServiciobusquedas().buscarAdministradorId(u.getUsername());  
                    //String administrador = gson.toJson(admin);
                    //out.write(administrador); 
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
                        default:  break;        
                    }                                 
                 break;                               
                 case "Profesor":
                     String data = (String) request.getParameter("data");
                     Profesor prof = new Profesor();
                     prof = Data.instance().getServiciobusquedas().buscarProfeId(u.getUsername());
                     switch(data){
                         case "perfil":                                                           
                              String teacher = gson.toJson(prof);
                              out.println(teacher);
                              response.setStatus(200); // successfull 
                               break;
                         case "cursosProf":                             
                              ArrayList<Curso> cursosProf = new ArrayList();                    
                              cursosProf = Servicio_Busquedas.instance().buscarCursoXprofesor(u.getUsername());  
                              JSONArray jsArray4 = new JSONArray();
                                for(Curso c: cursosProf){
                                   jsArray4.put(c);
                                }
                              String coursesTeach = gson.toJson(jsArray4);  
                              out.println(coursesTeach);    
                              response.setStatus(200); // successfull 
                              break;
                     }                                                                          
                 break; 
                 case "Alumno":                                               
                     String info = (String) request.getParameter("info");
                     switch(info){
                         case "perfil":
                             Alumno alumn = new Alumno();
                             alumn = Data.instance().getServiciobusquedas().buscarAlumnoId(u.getUsername()); 
                             String student = gson.toJson(alumn);
                             out.println(student);                                                         
                             response.setStatus(200); // successfull   
                             break;
                         case "cursosAlmuno":
                             ArrayList<Curso> cursosAlumn = new ArrayList();
                             cursosAlumn = Data.instance().getServiciobusquedas().buscarCursosXAlumno(u.getUsername());
                              JSONArray jsArray4 = new JSONArray();
                                for(Curso c: cursosAlumn){
                                   jsArray4.put(c);
                                }
                             String coursesAl = gson.toJson(jsArray4);
                             out.println(coursesAl);
                             response.setStatus(200); // successfull   
                             break;
                     }                                         
                 break; 
                 default:                    
                     response.setStatus(401); // no access                  
                     break;
                }
                response.setContentType("application/json; charset=UTF-8"); 
            }                                     
            else {
                throw new Exception("Usuario o contaseña invalidos");
                
            }
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

    protected void doLogout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();   
        Gson gson = new Gson();  
        try{
         request.getSession().invalidate();         
         out.write(gson.toJson("Sesion terminada"));       
       }
       catch(Exception e){ String error = e.getMessage();
            out.println("Datos invalidos");  
            response.setStatus(400); // faild
            request.getRequestDispatcher("Error.jsp").forward(request, response);
            
        }
    }

}
