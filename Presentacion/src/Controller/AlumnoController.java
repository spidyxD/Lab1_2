/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import View.AlumnoView;
import Model.AlumnoModel;
/**
 *
 * @author dh173
 */
public class AlumnoController {
      AlumnoView view;
      AlumnoModel model;
    
    public AlumnoController(AlumnoView view, AlumnoModel model) { 
        model.init();
        //this.domainModel= domainModel;
        
        this.view = view;
        this.model = model;
        view.setController(this);
        view.setModel(model);
    }
}
