/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import AccesoADatos.GlobalException;
import AccesoADatos.NoDataException;
import Dao.Data;
import Entities.Administrador;
import Entities.Alumno;
import Entities.Grupo;
import Entities.Profesor;
import Entities.Usuario;
import Model.AdministradorModel;
import Model.AlumnoModel;
import Model.LoginModel;
import Model.ProfesorModel;
import Principal.Presentacion;
import View.LoginView;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author dh173
 */
public class LoginController {
      LoginView view;
      LoginModel model;
      Data data;
    
    public LoginController(LoginView view, LoginModel model, Data data) { 
        model.init();
        this.data=data;
        
        this.view = view;
        this.model = model;
        view.setController(this);
        view.setModel(model);
    }
    
    public void loginAdministrador(int userr){
    model.clearErrors();
               AdministradorModel adModel = Presentacion.ADMINISTRADOR_VIEW.getModel();
                Administrador nuevo = new Administrador();
               if (model.getErrores().isEmpty()){
            try{
                
                nuevo = data.getServiciobusquedas().buscarAdministradorId(userr);
                adModel.clearErrors();
                adModel.setMensaje("Bienvenido");
                adModel.setCurrent(nuevo);
                Presentacion.ADMINISTRADOR_VIEW.setModel(adModel);
                view.setVisible(false);
                Presentacion.ADMINISTRADOR_VIEW.setVisible(true);
            }
            catch(Exception e){
                adModel.setCurrent(nuevo);
            }
        }
        else{
            adModel.setMensaje("HAY ERRORES ...");
            adModel.setCurrent(nuevo);
        }
    }
    public void loginAlumno(int userr){
    model.clearErrors();
                AlumnoModel alModel = Presentacion.ALUMNO_VIEW.getModel();
                Alumno nuevo = new Alumno();
               if (model.getErrores().isEmpty()){
            try{
                
                nuevo = data.getServiciobusquedas().buscarAlumnoId(userr);
                alModel.clearErrors();
                alModel.setMensaje("Bienvenido");
                alModel.setCurrent(nuevo);
                view.setVisible(false);
                Presentacion.ALUMNO_VIEW.setModel(alModel);
                Presentacion.ALUMNO_VIEW.setVisible(true);
            }
            catch(Exception e){
                alModel.setCurrent(nuevo);
            }
        }
        else{
            alModel.setMensaje("HAY ERRORES ...");
            alModel.setCurrent(nuevo);
        }
    }
    public void loginProfesor(int userr){
    model.clearErrors();
                ProfesorModel profModel = Presentacion.PROFESOR_VIEW.getModel();
                ProfesorController contrProf= Presentacion.PROFESOR_VIEW.getController();
                Profesor nuevo = new Profesor();
               if (model.getErrores().isEmpty()){
            try{
                
                nuevo = data.getServiciobusquedas().buscarProfeId(userr);
                profModel.clearErrors();
                profModel.setMensaje("Bienvenido");
                profModel.setCurrent(nuevo);
                List<Grupo> grupos= new ArrayList<Grupo>();
                grupos=data.getServiciobusquedas().buscarGrupoXprofesor(userr);
                List<Grupo> gr= data.getServiciobusquedas().buscarGrupoXprofesor(userr);
                profModel.setGrupos(grupos);
                view.setVisible(false);
                Presentacion.PROFESOR_VIEW.setModel(profModel);
                Presentacion.PROFESOR_VIEW.grupos.setModel(profModel.getGrupos());
                Presentacion.PROFESOR_VIEW.setVisible(true);
                
            }
            catch(Exception e){
                profModel.setCurrent(nuevo);
            }
        }
        else{
            profModel.setMensaje("HAY ERRORES ...");
            profModel.setCurrent(nuevo);
        }
    }
    
    public void doLogin(String user, String clave) throws SQLException, InstantiationException, IllegalAccessException, GlobalException, NoDataException{
            int userr = Integer.parseInt(user);
            Usuario usuario= new Usuario();
                    
       
             boolean existe=data.getService().doLogin(userr,clave);
             if(existe){
                 usuario=data.getServiciobusquedas().buscarUsuarioId(userr);
                if("Administrador".equals(usuario.getRol())){
                    this.loginAdministrador(userr);
                }
                if("Alumno".equals(usuario.getRol())){
                    this.loginAlumno(userr);
                }
                if("Profesor".equals(usuario.getRol())){
                    this.loginProfesor(userr);
                }
             }
    }
}
