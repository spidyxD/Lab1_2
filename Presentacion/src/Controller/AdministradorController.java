/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entities.Alumno;
import View.AdministradorView;
import Model.AdministradorModel;
import Entities.Usuario;
import View.MatriculaView;
import Dao.Data;
/**
 *
 * @author dh173
 */
public class AdministradorController {
      AdministradorView viewAdmin;
      MatriculaView viewMat;
      AdministradorModel model;
      Data data;
    
    public AdministradorController(AdministradorView viewAdmin, MatriculaView viewMat, AdministradorModel model, Data data) { 
        model.init();
        this.data=data;
        
        this.viewMat= viewMat;
        this.viewAdmin = viewAdmin;
        this.model = model;
        viewAdmin.setController(this);
        viewMat.setController(this);
        viewAdmin.setModel(model);
        viewMat.setModel(model);
    }
    public Alumno SearchPorNombre(String nom){
    return new Alumno();
    }
    public Alumno SearchPorCed(String ced){
    return new Alumno();
    }
}
