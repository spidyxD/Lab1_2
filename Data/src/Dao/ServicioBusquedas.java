/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

/**
 *
 * @author Addiel
 */
public class ServicioBusquedas {
    private static final String BUSCARCURSOID= "{call buscar_curso_id(?)}";
    private static final String BUSCARCURSONOMBRE= "{call buscar_curso_nombre(?)}";
    private static final String BUSCARCARRERA= "{call buscar_curso_carrera(?)}";
    private static final String BUSCARPROFCEDULA= "{call buscar_Profesor_cedula(?)}";
    private static final String BUSCARALUMCEDULA= "{call buscar_Alumno_ced(?)}";
}
