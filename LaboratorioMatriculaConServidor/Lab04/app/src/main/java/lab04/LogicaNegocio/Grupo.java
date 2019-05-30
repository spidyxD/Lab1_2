package lab04.LogicaNegocio;

public class Grupo {
    public int capacidad;
    public Ciclo ciclo = new Ciclo();
    public Curso curso = new Curso();
    public int nrc ;
    public String horario;
    public Profesor porfesor = new Profesor();

    public Grupo() {
    }
    public Grupo(int nrc,Curso curso,int capacidad,String horario,Profesor profesor,Ciclo ciclo){
        this.curso=curso;
        this.nrc= nrc;
        this.capacidad=capacidad;
        this.horario=horario;
        this.porfesor=profesor;
        this.ciclo=ciclo;
    }

    public int getNrc() {
        return nrc;
    }


    public void setNrc(int nrc) {
        this.nrc = nrc;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public Ciclo getCiclo() {
        return ciclo;
    }

    public void setCiclo(Ciclo ciclo) {
        this.ciclo = ciclo;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public Profesor getPorfesor() {
        return porfesor;
    }

    public void setPorfesor(Profesor porfesor) {
        this.porfesor = porfesor;
    }


    @Override
    public String toString() {
        return curso.getNombre() + " " + " " + curso.getCreditos() + " " + horario +" "+nrc;
    }


}

