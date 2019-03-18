/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;

import AccesoADatos.GlobalException;
import AccesoADatos.NoDataException;
import Controller.AdministradorController;
import Controller.AlumnoController;
import Controller.LoginController;
import Controller.ProfesorController;
import Model.AdministradorModel;
import Model.AlumnoModel;
import Model.LoginModel;
import Model.ProfesorModel;
import View.AdministradorView;
import View.AlumnoView;
import View.LoginView;
import View.MatriculaView;
import View.ProfesorView;

import Dao.Data;
import Entities.Alumno;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dh173
 */
public class Presentacion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Data data= new Data();
        try {
             Alumno alumno= new Alumno();
             alumno = data.getServiciobusquedas().buscarAlumnoId(4678936);
             System.out.println(alumno.toString());
         } catch (NullPointerException |GlobalException | NoDataException | SQLException | InstantiationException | IllegalAccessException ex) {
             System.out.println(":/");
         }
          
        AdministradorModel modelAdmin= new AdministradorModel();
        AlumnoModel modelAlum= new AlumnoModel();
        LoginModel modelLogin= new LoginModel();
        ProfesorModel modelProf= new ProfesorModel();

        AlumnoView alumnoView = new AlumnoView();
        ALUMNO_VIEW=alumnoView;
        AlumnoController alumnoController = new AlumnoController(alumnoView,modelAlum,data);
        
       MatriculaView matriculaView=new MatriculaView();
       MATRICULA_VIEW=matriculaView;
       
       AdministradorView adminView= new AdministradorView();
       ADMINISTRADOR_VIEW = adminView;
       AdministradorController administradorController = new AdministradorController(adminView,matriculaView,modelAdmin,data);
        
       ProfesorView profesorView= new ProfesorView();
        PROFESOR_VIEW=profesorView;
        ProfesorController profesorController=new ProfesorController(profesorView,modelProf,data);
        
        LoginView loginView= new LoginView();
        LOGIN_VIEW = loginView;
        LoginController loginController= new LoginController(loginView,modelLogin,data);
        //LOGIN_VIEW.setVisible(true);
    }
    public static AdministradorView ADMINISTRADOR_VIEW;
    public static AlumnoView ALUMNO_VIEW; 
    public static LoginView LOGIN_VIEW;
    public static MatriculaView MATRICULA_VIEW;
    public static ProfesorView PROFESOR_VIEW;
   // public static CalibracionesController CALIBRACIONES_CONTROLLER;
    
}
