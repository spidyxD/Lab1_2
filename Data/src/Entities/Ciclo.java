/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.util.Date;

/**
 *
 * @author Addiel
 */
public class Ciclo {
    public int codigo;
    public String descripcion;
    public Date fecha_inicio;
    public Date fecha_finalizacion;

    public Ciclo() {
    }

    public Ciclo(int tipo, String descripcion, Date fecha_inicio, Date fecha_finalizacion) {
        this.codigo = tipo;
        this.descripcion = descripcion;
        this.fecha_inicio = fecha_inicio;
        this.fecha_finalizacion = fecha_finalizacion;
    }

    public Ciclo(int tipo, Date fecha_inicio, Date fecha_finalizacion) {
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

    public Date getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(Date fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public Date getFecha_finalizacion() {
        return fecha_finalizacion;
    }

    public void setFecha_finalizacion(Date fecha_finalizacion) {
        this.fecha_finalizacion = fecha_finalizacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
}
