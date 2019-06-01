package lab04.LogicaNegocio;
import java.util.Date;

public class Ciclo {
    public int codigo;
    public String descripcion;
    public String fecha_inicio ;
    public String fecha_finalizacion ;

    public Ciclo() {
    }

    public Ciclo(int tipo, String descripcion, String fecha_inicio, String fecha_finalizacion) {
        this.codigo = tipo;
        this.descripcion = descripcion;
        this.fecha_inicio = fecha_inicio;
        this.fecha_finalizacion = fecha_finalizacion;
    }

    public Ciclo(int tipo, String fecha_inicio, String fecha_finalizacion) {
        this.codigo = tipo;
        this.fecha_inicio = fecha_inicio;
        this.fecha_finalizacion = fecha_finalizacion;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int tipo) {
        this.codigo = tipo;
    }

    public String getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(String fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public String getFecha_finalizacion() {
        return fecha_finalizacion;
    }

    public void setFecha_finalizacion(String fecha_finalizacion) {
        this.fecha_finalizacion = fecha_finalizacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }


}
