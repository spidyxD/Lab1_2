/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Dao.Data;
import View.AlumnoView;
import Model.AlumnoModel;
/**
 *
 * @author dh173
 */
public class AlumnoController {
      AlumnoView view;
      AlumnoModel model;
      Data data;
    
    public AlumnoController(AlumnoView view, AlumnoModel model,Data data) { 
        model.init();
        this.data=data;
        
        this.view = view;
        this.model = model;
        view.setController(this);
        view.setModel(model);
    }
}
