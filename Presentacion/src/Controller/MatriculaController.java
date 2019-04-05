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
import javax.swing.DefaultListModel;

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
        data.getServiciogenerales().matricularCurso(model.getCurrent(), model.getCurrent().getCarrera(), seleccionado.getCurso(), seleccionado, seleccionado.getCiclo());
        model.getCurrent().setCreditos(model.getCurrent().getCreditos()+seleccionado.getCurso().getCreditos());
        String cred = Integer.toString(model.getCurrent().getCreditos());
        view.creditos.setText("Creditos : "+cred);
        DefaultListModel<String> gruposs = model.getCursosMatriculados();
        gruposs.addElement(seleccionado.toString());
        model.setCursosMatriculados(gruposs);
    }
    public void borrarCurso(String curso , int select) throws GlobalException, NoDataException, SQLException, InstantiationException, IllegalAccessException{
        int tamano = curso.length() -1;
        boolean condition = true;
        String numero = "";
        do{
                
                char numerito  = curso.charAt(tamano);
                if (Character.isDigit(numerito)){
                numero = numerito + numero;
                }else{
                condition = false;
                }
           
            tamano--;
        }while(condition && tamano>=0);
        int nrc = Integer.parseInt(numero);
        Grupo g = data.getServiciobusquedas().buscarGrupoId(nrc);
        data.getServiciogenerales().eliminarMatricula(model.getCurrent(), nrc);
        model.getCurrent().setCreditos(model.getCurrent().getCreditos()-g.getCurso().getCreditos());
        String cred = Integer.toString(model.getCurrent().getCreditos());
        view.creditos.setText("Creditos : "+cred);
        model.getCursosMatriculados().removeElementAt(select);
    }
}
