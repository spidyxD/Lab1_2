/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entities.Usuario;
import Model.LoginModel;
import View.LoginView;

/**
 *
 * @author dh173
 */
public class LoginController {
      LoginView view;
      LoginModel model;
    
    public LoginController(LoginView view, LoginModel model) { 
        model.init();
        //this.domainModel= domainModel;
        
        this.view = view;
        this.model = model;
        view.setController(this);
        view.setModel(model);
    }
    
    public Usuario doLogin(String user, String clave){
        return new Usuario();
    }
}
