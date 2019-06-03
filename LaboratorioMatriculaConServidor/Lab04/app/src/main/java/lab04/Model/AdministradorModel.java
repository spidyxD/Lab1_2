package lab04.Model;

import java.util.ArrayList;
import java.util.List;

import lab04.LogicaNegocio.Administrador;
import lab04.LogicaNegocio.Alumno;
import lab04.LogicaNegocio.Carrera;
import lab04.LogicaNegocio.Curso;
import lab04.LogicaNegocio.Profesor;

public class AdministradorModel {
    private Administrador administrador= new Administrador();


    public AdministradorModel(Administrador administrador) {
        this.administrador = administrador;
    }

    public AdministradorModel() {
        administrador= new Administrador();
    }

    public Administrador getAdministrador() {
        return administrador;
    }

    public void setAdministrador(Administrador administrador) {
        this.administrador = administrador;
    }


}
