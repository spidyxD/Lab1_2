/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;

import Controller.AdministradorController;
import Controller.AlumnoController;
import Controller.MatriculaController;
import Controller.ProfesorController;
import Model.AdministradorModel;
import Model.AlumnoModel;
import Model.LoginModel;
import Model.MatriculaModel;
import Model.ProfesorModel;
import View.AdministradorView;
import View.AlumnoView;
import View.LoginView;
import View.MatriculaView;
import View.ProfesorView;

/**
 *
 * @author dh173
 */
public class Presentacion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Model domainModel = Model.instance();
        //Model1 domainModel1=Model1.instance();
        //Model2 domainModel2= Model2.instance();
        LoginView loginView= new LoginView();
        loginView.setVisible(true);
          
        AdministradorModel modelAdmin= new AdministradorModel();
        AlumnoModel modelAlum= new AlumnoModel();
        LoginModel modelLogin= new LoginModel();
        MatriculaModel modelMat= new MatriculaModel();
        ProfesorModel modelProf= new ProfesorModel();
        
        AdministradorView adminView= new AdministradorView();
        ADMINISTRADOR_VIEW = adminView;
        AdministradorController administradorController = new AdministradorController(adminView,modelAdmin,domainModel);

        AlumnoView alumnoView = new AlumnoView();
        ALUMNO_VIEW=alumnoView;
        AlumnoController alumnoController = new AlumnoController(alumnoView,modelAlum,domainModel);
        
       MatriculaView matriculaView=new MatriculaView();
       MATRICULA_VIEW=matriculaView;
       MatriculaController matriculaController=new MatriculaController(matriculaView,modelMat,domainModel1);
        
       ProfesorView profesorView= new ProfesorView();
        PROFESOR_VIEW=profesorView;
        ProfesorController profesorController=new ProfesorController(profesorView,modelProf,domainModel2);
    }
    public static AdministradorView ADMINISTRADOR_VIEW;
    public static AlumnoView ALUMNO_VIEW; 
    public static LoginView LOGIN_VIEW;
    public static MatriculaView MATRICULA_VIEW;
    public static ProfesorView PROFESOR_VIEW;
   // public static CalibracionesController CALIBRACIONES_CONTROLLER;
    
}
