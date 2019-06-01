/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import AccesoADatos.GlobalException;
import AccesoADatos.NoDataException;
import Entities.Alumno;
import View.AdministradorView;
import Model.AdministradorModel;
import Entities.Usuario;
import View.MatriculaView;
import Dao.Data;
import Entities.Profesor;
import Model.AlumnoModel;
import Model.ProfesorModel;
import Principal.Presentacion;
import java.sql.SQLException;
import java.text.ParseException;
/**
 *
 * @author dh173
 */
public class AdministradorController {
      AdministradorView viewAdmin;
      AdministradorModel model;
      Data data;
    
    public AdministradorController(AdministradorView viewAdmin,  AdministradorModel model, Data data) { 
        model.init();
        this.data=data;
        
        this.viewAdmin = viewAdmin;
        this.model = model;
        viewAdmin.setController(this);
        viewAdmin.setModel(model);
    }

    public AdministradorController() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public void busquedaProfesores(String nombre) throws GlobalException, NoDataException, SQLException, InstantiationException, IllegalAccessException{
        model.clearErrors();
        Profesor nuevo = new Profesor();
        ProfesorModel profModel = Presentacion.PROFESOR_VIEW.getModel();
            if (model.getErrores().isEmpty()){
            try {
                int id = Integer.parseInt(nombre);
                nuevo = data.getServiciobusquedas().buscarProfeId(id);
                profModel.clearErrors();
                profModel.setCurrent(nuevo);
                viewAdmin.setVisible(false);
                Presentacion.PROFESOR_VIEW.cerraS.setText("Volver");
                Presentacion.PROFESOR_VIEW.setModel(profModel);
                Presentacion.PROFESOR_VIEW.setVisible(true);
            } catch (NumberFormatException nfe) {
                nuevo= data.getServiciobusquedas().buscarProfesorNombre(nombre);
                profModel.clearErrors();
                profModel.setCurrent(nuevo);
                viewAdmin.setVisible(false);
                Presentacion.PROFESOR_VIEW.setModel(profModel);
                Presentacion.PROFESOR_VIEW.setVisible(true);
                Presentacion.PROFESOR_VIEW.cerraS.setText("Volver");
            }
            }
            else{
                profModel.setMensaje("HAY ERRORES ...");
                profModel.setCurrent(nuevo);
            }
    }
    public void busquedaEstudiantes(String nombre) throws GlobalException, NoDataException, SQLException, InstantiationException, IllegalAccessException, IllegalAccessException{
    model.clearErrors();
    Alumno nuevo = new Alumno ();
    AlumnoModel alumnoModel= Presentacion.ALUMNO_VIEW.getModel();
    if(model.getErrores().isEmpty()){
        try{
            int id = Integer.parseInt(nombre);
            nuevo= data.getServiciobusquedas().buscarAlumnoId(id);
            alumnoModel.clearErrors();
            alumnoModel.setCurrent(nuevo);
            Presentacion.ALUMNO_VIEW.setModel(alumnoModel);
            Presentacion.ALUMNO_VIEW.setVisible(true);
            viewAdmin.setVisible(false);
            Presentacion.ALUMNO_VIEW.matricula.setVisible(true);
            Presentacion.ALUMNO_VIEW.cerraS.setText("Volver");
        }catch(NumberFormatException nfe){
            nuevo= data.getServiciobusquedas().buscarAlumnoNombre(nombre);
            alumnoModel.clearErrors();
            alumnoModel.setCurrent(nuevo);
            Presentacion.ALUMNO_VIEW.setModel(alumnoModel);
            Presentacion.ALUMNO_VIEW.setVisible(true);
            viewAdmin.setVisible(false);
            Presentacion.ALUMNO_VIEW.matricula.setVisible(true);
            Presentacion.ALUMNO_VIEW.cerraS.setText("Volver");
         }
    }else{
       alumnoModel.setMensaje("HAY ERRORES....");
       alumnoModel.setCurrent(nuevo);
    }
    
    }
}
