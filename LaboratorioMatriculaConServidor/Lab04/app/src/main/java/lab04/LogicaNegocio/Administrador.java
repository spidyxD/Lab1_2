package lab04.LogicaNegocio;

public class Administrador extends Persona{
    @Override
    public String getNombre() {
        return nombre;
    }
    public Administrador(int id, String nombre){
        this.cedula=id;
        this.nombre=nombre;
    }
    public Administrador(){}
    @Override
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    @Override
    public String toString() {
        return "Administrador{ ID: "+this.cedula +" Nombre : "+ this.nombre+ '}';
    }

}