package lab04.LogicaNegocio;

public class Plan_de_estudio {
    public Curso curso = new Curso();
    public Carrera carrera = new Carrera();
    public int anno ;
    public Ciclo ciclo = new Ciclo();

    public Plan_de_estudio() {
    }

    public Plan_de_estudio(Curso curso, Carrera carrera, int anno, Ciclo ciclo) {
        this.curso = curso;
        this.carrera = carrera;
        this.anno = anno;
        this.ciclo = ciclo;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public Carrera getCarrera() {
        return carrera;
    }

    public void setCarrera(Carrera carrera) {
        this.carrera = carrera;
    }

    public int getAnno() {
        return anno;
    }

    public void setAnno(int anno) {
        this.anno = anno;
    }

    public Ciclo getCiclo() {
        return ciclo;
    }

    public void setCiclo(Ciclo ciclo) {
        this.ciclo = ciclo;
    }


}

