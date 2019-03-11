/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Testing;

import AccesoADatos.GlobalException;
import AccesoADatos.NoDataException;
import Dao.ServicioEstudiante;
import Entities.Alumno;
import Entities.Usuario;
import java.sql.Date;

/**
 *
 * @author Addiel
 */
public class Test {
    public static void main (String args[]) throws GlobalException, NoDataException {
        ServicioEstudiante se = new ServicioEstudiante();
        Alumno a =  new Alumno();
        Usuario u = new Usuario();
        a.setCedula(116360595);
        a.setEdad(22);
        a.setEmail("addielo.oamvi@gmail.com");
        a.setFecha_nacimiento(Date.valueOf("2019/03/22"));
        a.setNombre("Addiel Amador Villagra");
        u.setClave("12345");
        u.setUsername(a.getCedula());
        se.insertarEstudiante(a, u);
    }
}
