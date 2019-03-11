/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import View.ProfesorView;
import Model.ProfesorModel;
/**
 *
 * @author dh173
 */
public class ProfesorController {
      ProfesorView view;
      ProfesorModel model;
    
    public ProfesorController(ProfesorView view, ProfesorModel model) { 
        model.init();
        //this.domainModel= domainModel;
        
        this.view = view;
        this.model = model;
        view.setController(this);
        view.setModel(model);
    }
}