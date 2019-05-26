package lab04.LogicaNegocio;
import java.util.List;
import java.util.ArrayList;
public class Carrera {
    public int codigo;
    public String nombre;
    public String titulo;
    private List<Curso> cursos;
    public Carrera() {
    }

    public Carrera(int codigo, String nombre, String titulo, List<Curso> cursos) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.titulo = titulo;
        this.cursos=cursos;
    }
    public Carrera(int codigo, String nombre, String titulo) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.titulo = titulo;
        this.cursos=new ArrayList<>();
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCreditos() {
        return titulo;
    }

    public void setCreditos(String titulo) {
        this.titulo = titulo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public void setCursos(List<Curso> cursos){
        this.cursos=cursos;
    }
    public List<Curso> getCursos(){
        return this.cursos;
    }



}

