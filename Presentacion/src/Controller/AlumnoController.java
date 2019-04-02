/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import AccesoADatos.GlobalException;
import AccesoADatos.NoDataException;
import Dao.Data;
import Entities.Administrador;
import Entities.Alumno;
import Entities.Carrera;
import Entities.Curso;
import Entities.Grupo;
import Entities.Matricula;
import View.AlumnoView;
import Model.AlumnoModel;
import Model.MatriculaModel;
import Principal.Presentacion;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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

    public AlumnoController() {}

    public void matricular() throws GlobalException, NoDataException, SQLException, InstantiationException, IllegalAccessException{
        Alumno alumno = new Alumno ();
        Administrador matriculador = new Administrador();
        matriculador= Presentacion.ADMINISTRADOR_VIEW.getModel().getCurrent();
        MatriculaModel matModel= Presentacion.MATRICULA_VIEW.getModel();
        alumno= model.getCurrent();
        matModel.clearErrors();
        matModel.setCurrent(alumno);
        List<Matricula> matriculados = data.getServiciobusquedas().buscarMatriculaCiclo(Presentacion.CICLO.getCodigo());
        for(int i =0 ; i< matriculados.size(); i++){
             matModel.getCursosMatriculados().addElement(matriculados.get(i).toString());
        }
        List<Curso> cursos = data.getServiciobusquedas().buscarCursoXCarrera(alumno.getCarrera().getCodigo());
        List<Grupo> grupos=  new ArrayList<>();
        for (int i =0; i < cursos.size(); i++){
            grupos.addAll(data.getServiciobusquedas().buscarGrupoCurso(cursos.get(i).getCodigo()));
        }
        matModel.setSistemaMat(grupos);
        Presentacion.MATRICULA_VIEW.setModel(matModel);
        Presentacion.MATRICULA_VIEW.setVisible(true);
        view.setVisible(false);
    }
    
    public void guardar(String email) throws GlobalException, NoDataException, InstantiationException, IllegalAccessException{
        Alumno al = model.getCurrent();
        data.getServicioestudiante().modificarCorreoEstudiante(email);
        al.setEmail(email);
        model.setCurrent(al);
    }
    
}
