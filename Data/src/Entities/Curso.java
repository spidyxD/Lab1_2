/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

/**
 *
 * @author Addiel
 */
public class Curso {
    public int codigo;
    public String nombre;
    public int creditos;
    public float horas_semanales;

    public Curso() {
    }

    public Curso(int codigo, String nombre, int creditos, float horas_semanales) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.creditos = creditos;
        this.horas_semanales = horas_semanales;
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

    public int getCreditos() {
        return creditos;
    }

    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }

    public float getHoras_semanales() {
        return horas_semanales;
    }

    public void setHoras_semanales(float horas_semanales) {
        this.horas_semanales = horas_semanales;
    }
    
}
