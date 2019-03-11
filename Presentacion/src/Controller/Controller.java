/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.AdministradorModel;
import View.AdministradorView;
import Model.AlumnoModel;
import View.AlumnoView;
import Model.LoginModel;
import View.LoginView;
import Model.MatriculaModel;
import View.MatriculaView;
import Model.ProfesorModel;
import View.ProfesorView;
/**
 *
 * @author dh173
 */
public class Controller {
    AdministradorView viewAdmin;
    AdministradorModel modelAdmin;
    AlumnoModel modelAlumno;
    AlumnoView viewAlumno;
    LoginModel modelLogin;
    LoginView viewLogin;
    MatriculaModel matriculaModel;
    MatriculaView mtriculaView;
    ProfesorModel modelProfesor;
    ProfesorView viewProfesor;
    
    public Controller() { 
        model.init();
        //this.domainModel= domainModel;
            viewAdmin= new AdministradorView ();
            modelAdmin= new AdministradorModel ();
            modelAlumno = new AlumnoModel();
            viewAlumno= new  AlumnoView();
            modelLogin= new LoginModel ();
            viewLogin= new LoginView ();
            matriculaModel= new MatriculaModel();
            mtriculaView= new MatriculaView ();
            modelProfesor=;
            ProfesorView viewProfesor;
        
        this.viewAdmin = view;
        this.modelAdmin = model;
        view.setController(this);
        view.setModel(model);
    }
    
    public void iniciarAdministrador(){}
    public void iniciarAlummno(){}
    public void iniciarLogin(){}
    public void iniciarMatricula(){}
    public void iniciarProfesor(){}
}
