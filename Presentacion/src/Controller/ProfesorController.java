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
import Entities.Rendimiento_grupo;
import Model.AlumnosProfTableModel;
import View.ProfesorView;
import Model.ProfesorModel;
import java.sql.SQLException;
import java.util.List;
import javax.swing.DefaultListModel;
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
    
    public void registrarNota(int nota, int rowE, int rowG) throws GlobalException, NoDataException, SQLException, InstantiationException, IllegalAccessException{
        model.clearErrors();
        Alumno alumno = model.getAlumnos().getRowAt(rowE);
        Grupo grupo = model.getGrupos().getRowAt(rowG);
        Rendimiento_grupo notaFinal = new Rendimiento_grupo();
        notaFinal.setAlumno(alumno);
        notaFinal.setCurso(grupo.getCurso());
        notaFinal.setProfesor(model.getCurrent());
        notaFinal.setCalificacion(nota);
        data.getServiciogenerales().reportarNotas(notaFinal);
    }
    
    public Grupo busquedaEstudiante(int row) throws GlobalException, NoDataException, SQLException, InstantiationException, IllegalAccessException{
        model.clearErrors();
        Grupo seleccionado = model.getGrupos().getRowAt(row);
        List<Alumno> alumnos =data.getServiciobusquedas().buscarAlumnoXGrupo(seleccionado.getNrc());
        model.setAlumnos(alumnos);
        return seleccionado;
    }
    
}