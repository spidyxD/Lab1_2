/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import AccesoADatos.GlobalException;
import AccesoADatos.NoDataException;
import Dao.Data;
import Entities.Usuario;
import Model.LoginModel;
import View.LoginView;
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
    
    public Usuario doLogin(int user, String clave){
        model.clearErrors();
        Usuario usuario = new Usuario();
          try {
             data.getService().doLogin(user,clave);
          } catch (InstantiationException | IllegalAccessException | GlobalException | NoDataException ex) {
              JOptionPane.showMessageDialog(null, "Ocurrió un error, asegurese de haber escrito correctamente su usuario y su contraseña ");
          }
          return usuario;
    }
    public Usuario buscarAdministrador(String user){
        return new Usuario();
    }
    public Usuario buscarEstudiante(String user){
        return new Usuario();
    }
    public Usuario buscarProfesor(String user){
        return new Usuario();
    }
}
