package lab04.LogicaNegocio;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class Alumno extends Persona{
    public  String fecha_nacimiento;
    public List<Grupo> grupos = new ArrayList<>();
    Carrera carrera = new Carrera();
    int creditos ;
    public Alumno() {
    }

    public List<Grupo> getGrupos() {
        return grupos;
    }

    public void setGrupos(List<Grupo> grupos) {
        this.grupos = grupos;
    }

    public Alumno(String fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public int getCreditos() {
        return creditos;
    }

    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }

    public Alumno(int cedula, String nombre , String fecha , int edad , String email, Carrera carrera ,int telefono) {
        super(nombre, cedula, email,edad,telefono);
        this.fecha_nacimiento = fecha;
        this.carrera= carrera;
    }

    public String getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(String fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public Carrera getCarrera() {
        return carrera;
    }

    public void setCarrera(Carrera carrera) {
        this.carrera = carrera;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public int getCedula() {
        return cedula;
    }

    @Override
    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public void setEmail(String email) {
        this.email = email;
    }

}

