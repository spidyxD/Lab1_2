/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import View.AdministradorView;
import Model.AdministradorModel;
/**
 *
 * @author dh173
 */
public class AdministradorController {
      AdministradorView view;
      AdministradorModel model;
    
    public AdministradorController(AdministradorView view, AdministradorModel model) { 
        model.init();
        //this.domainModel= domainModel;
        
        this.view = view;
        this.model = model;
        view.setController(this);
        view.setModel(model);
    }
}
