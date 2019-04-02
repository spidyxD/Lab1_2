/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import AccesoADatos.GlobalException;
import AccesoADatos.NoDataException;
import Dao.Data;
import Entities.Alumno;
import Entities.Grupo;
import Entities.Matricula;
import Model.MatriculaModel;
import View.MatriculaView;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author dh173
 */
public class MatriculaController {
    MatriculaView view ;
    MatriculaModel model ;
    Data data;
    
    public MatriculaController(MatriculaView view, MatriculaModel model,Data data) { 
        model.init();
        this.data=data;
        this.view = view;
        this.model = model;
        view.setController(this);
        view.setModel(model);
    }
    public void matricular(int row) throws GlobalException, NoDataException, SQLException, InstantiationException, IllegalAccessException{
        model.clearErrors();
        Grupo seleccionado = model.getSistemaMat().getRowAt(row);
        data.getServiciogenerales().matricularCurso(model.getCurrent(),model.getCarrera(), seleccionado.getCurso(), seleccionado, seleccionado.getCiclo());
        
    }
}
