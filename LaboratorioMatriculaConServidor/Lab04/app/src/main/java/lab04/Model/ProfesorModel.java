package lab04.Model;

import java.util.ArrayList;
import java.util.List;

import lab04.LogicaNegocio.Grupo;
import lab04.LogicaNegocio.Profesor;

public class ProfesorModel {
    private List<Grupo> gruposImpartidos = new ArrayList<>();
    private Profesor profesor= new Profesor();

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    public ProfesorModel(List<Grupo> gruposImpartidos) {
        this.gruposImpartidos = gruposImpartidos;
    }

    public ProfesorModel(){

    }
    public List<Grupo> getGruposImpartidos() {
        return gruposImpartidos;
    }

    public void setGruposImpartidos(List<Grupo> gruposImpartidos) {
        this.gruposImpartidos = gruposImpartidos;
    }
}
