/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import View.MatriculaView;
import Model.MatriculaModel;
/**
 *
 * @author dh173
 */
public class MatriculaController {
      MatriculaView view;
      MatriculaModel model;
    
    public MatriculaController(MatriculaView view, MatriculaModel model) { 
        model.init();
        //this.domainModel= domainModel;
        
        this.view = view;
        this.model = model;
        view.setController(this);
        view.setModel(model);
    }
}