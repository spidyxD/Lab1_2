package lab04.LogicaNegocio;

public class Rendimiento_grupo extends Persona{
    public Curso curso = new Curso();
    public Alumno alumno = new Alumno();
    public int calificacion ;
    public Profesor profesor = new Profesor();
    public Rendimiento_grupo() {
    }

    public Rendimiento_grupo(Curso curso, Alumno alumno, int calificacion) {
        this.curso = curso;
        this.alumno = alumno;
        this.calificacion = calificacion;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public int getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }


}

