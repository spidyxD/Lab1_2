package lab04.LogicaNegocio;

public class Matricula {
    public int student ;
    public int major ;
    public int course;
    public int cycle ;
    public int grupo ;

    public Matricula() {
    }

    public int getGrupo() {
        return grupo;
    }

    public void setGrupo(int grupo) {
        this.grupo = grupo;
    }

    public Matricula(int student, int major, int course, int cycle, int grupo) {
        this.student = student;
        this.major = major;
        this.course = course;
        this.grupo=grupo;
        this.cycle = cycle;
    }

    public int getStudent() {
        return student;
    }

    public void setStudent(int student) {
        this.student = student;
    }

    public int getMajor() {
        return major;
    }

    public void setMajor(int major) {
        this.major = major;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }


    public int getCycle() {
        return cycle;
    }

    public void setCycle(int cycle) {
        this.cycle = cycle;
    }

    @Override
    public String toString() {
        return course+ " " + grupo;
    }


}
