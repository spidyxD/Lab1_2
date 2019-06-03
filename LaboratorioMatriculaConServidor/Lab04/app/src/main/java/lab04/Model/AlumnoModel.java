package lab04.Model;

import java.util.ArrayList;
import java.util.List;

import lab04.Controller.Datos_Controller;
import lab04.LogicaNegocio.Alumno;
import lab04.LogicaNegocio.Grupo;
import lab04.LogicaNegocio.Matricula;

public class AlumnoModel {
    private Alumno alumno = new Alumno();
    private List<Matricula> matriculas = new ArrayList<>();

    public AlumnoModel(Alumno alumno, List<Matricula> matriculas) {
        this.alumno = alumno;
        this.matriculas = matriculas;
    }

    public AlumnoModel() {
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public List<Matricula> getMatriculados() {
        return matriculas;
    }

    public void setMatriculados(List<Matricula> gruposMatriculados) {
        this.matriculas = gruposMatriculados;
    }
    public List<Grupo> getGrruposMatriculados(){
        List<Grupo> grupos= new ArrayList<>();
        for(Matricula m : matriculas){
            grupos.add(Datos_Controller.getInstance().buscarGruppoXId(m.getCourse(),m.getGrupo()));
        }
        return grupos;
    }
}
