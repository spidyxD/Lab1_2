/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package systest;


import AccesoADatos.GlobalException;
import AccesoADatos.NoDataException;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

/**
 *
 * @author Addiel
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws GlobalException, NoDataException, ParseException, InstantiationException, IllegalAccessException, SQLException, IOException, InterruptedException {
      
       /* ServicioEstudiante se = new ServicioEstudiante();
        ServicioBusquedas sb = new ServicioBusquedas();
        Alumno a =  new Alumno();
        Usuario u = new Usuario();
        a.setCedula(116360595);
        a.setEdad(22);
        a.setEmail("addielo.oamvi@gmail.com");
        Date d = Date.valueOf("1996-3-22");
        a.setFecha_nacimiento(d);
        a.setNombre("Roger Amador Villagra");
        u.setClave("12345");
        u.setUsername(a.getCedula());
        Alumno c = sb.buscarAlumnoNombre("Karol Hernandez Arce");
        ArrayList<Alumno> cs = new ArrayList();
        cs = sb.buscarAlumnoXCarrera(2);
        //se.modificarEstudiante(a, u);
       for(Alumno cur : cs){
            System.out.println(cur.getNombre());
        }
        //System.out.println(c.getNombre());
        //System.out.println();*/
       Controller c = new Controller();
       c.menu();
    }
    
    
}
