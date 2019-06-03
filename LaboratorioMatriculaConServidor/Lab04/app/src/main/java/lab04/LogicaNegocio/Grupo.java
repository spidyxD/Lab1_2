package lab04.LogicaNegocio;

public class Grupo {
    public int capacidad;
    public int ciclo ;
    public int curso ;
    public int nrc ;
    public String horario;
    public int porfesor;

    public Grupo() {
    }
    public Grupo(int nrc,int curso,int capacidad,String horario,int profesor,int ciclo){
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

    public int getCiclo() {
        return ciclo;
    }

    public void setCiclo(int ciclo) {
        this.ciclo = ciclo;
    }

    public int getCurso() {
        return curso;
    }

    public void setCurso(int curso) {
        this.curso = curso;
    }

    public int getPorfesor() {
        return porfesor;
    }

    public void setPorfesor(int porfesor) {
        this.porfesor = porfesor;
    }


    @Override
    public String toString() {
        return curso + " " + horario +" "+nrc;
    }


}

