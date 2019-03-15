/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Dao.Data;
import View.ProfesorView;
import Model.ProfesorModel;
/**
 *
 * @author dh173
 */
public class ProfesorController {
      ProfesorView view;
      ProfesorModel model;
      Data data;
    
    public ProfesorController(ProfesorView view, ProfesorModel model,Data data) { 
        model.init();
        this.data=data;
        
        this.view = view;
        this.model = model;
        view.setController(this);
        view.setModel(model);
    }
}