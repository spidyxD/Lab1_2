/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package systest;

import AccesoADatos.GlobalException;
import AccesoADatos.NoDataException;
import Dao.ServicioCursos;
import Dao.ServicioGenerales;
import Dao.ServicioProfesor;
import Entities.Profesor;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Addiel
 */
public class Controller {

    public Controller() {
    }
    
    public void menu() throws IOException, InterruptedException, GlobalException, NoDataException, InstantiationException, IllegalAccessException{
        boolean flag = true;
        String op = " "; 
        Scanner s = new Scanner(System.in);
        while(flag){
            System.out.print('\u000C');
            System.out.println("=============================================================");
            System.out.println("===================  Sistema de matricula  ==================");
            System.out.println("=============================================================");
            System.out.println("====== 1. Ver profesores                              =======");
            System.out.println("====== 2. Ver cursos                                  =======");
            System.out.println("====== 3. Buscar alumno                               =======");
            System.out.println("====== 4. Buscar Profesor                             =======");
            System.out.println("====== 5. Buscar curso                                =======");
            System.out.println("====== 6. Inscribirse en carrera                      =======");
            System.out.println("====== 7. Matricular curso                            =======");
            System.out.println("====== 8. Calificar curso                             =======");
            System.out.println("====== 9. Salir                                       =======");
            System.out.println("Digite una opción....                                 =======");                   
            
            op = s.nextLine();
            if(!isDigit(op)){
                    System.out.println("valor ingresado invalido....                      ======="); 
                    Thread.sleep(300);
                        flag = false;
            }
            switch(op){
                case "1": 
                    verProfesores();
                    break;
                case "2": 
                    verCursos();
                    break;
                case "3": 
                    String s1 = " ";
                    System.out.print('\u000C');
                    System.out.println("====== 1. Por nombre                              =======");
                    System.out.println("====== 2. Por id                                  =======");
                    System.out.println("====== 3. Por curso                               =======");
                    System.out.println("====== 4. Salir                                   =======");
                    System.out.println("Digite una opción....                             =======");                   
                    Scanner sb1 = new Scanner(System.in);
                    s1 = sb1.nextLine();
                    if(!isDigit(s1)){
                    System.out.println("valor ingresado invalido....                      ======="); 
                    Thread.sleep(300);
                        flag = false;
                    }  
                    if(s1.equals("4")){ flag = false;}
                    buscarAlumno(Integer.parseInt(op));
                    break;
                case "4": 
                    String s2 = " ";
                    System.out.print('\u000C');
                    System.out.println("====== 1. Por nombre                              =======");
                    System.out.println("====== 2. Por id                                  =======");
                    System.out.println("====== 3. Por curso                               =======");
                    System.out.println("====== 4. Salir                                   =======");
                    System.out.println("Digite una opción....                             =======");                   
                    Scanner sb2 = new Scanner(System.in);
                    s2 = sb2.nextLine();
                    if(!isDigit(s2)){
                    System.out.println("valor ingresado invalido....                      ======="); 
                    Thread.sleep(300);
                        flag = false;
                    }  
                    if(s2.equals("4")){ flag = false;}
                    buscarProfesor(Integer.parseInt(s2));
                    break;                   
                case "5": 
                    String s3 = " ";
                    System.out.print('\u000C');
                    System.out.println("====== 1. Por nombre                              =======");
                    System.out.println("====== 2. Por id                                  =======");                
                    System.out.println("====== 3. Salir                                   =======");
                    System.out.println("Digite una opción....                             =======");                   
                    Scanner sb3 = new Scanner(System.in);
                    s3 = sb3.nextLine();
                    if(!isDigit(s3)){
                    System.out.println("valor ingresado invalido....                      ======="); 
                    Thread.sleep(300);
                        flag = false;
                    }            
                    if(s3.equals("3")){ flag = false;}
                    buscarCurso(Integer.parseInt(s3));
                    break;        
                case "6": break;
                case "7": break; 
                case "8": break;
                case "9": 
                    flag = false;
                    break;
                default: break;                           
            }
            
        }
    }
    
    public void verProfesores() throws GlobalException, NoDataException, InstantiationException, IllegalAccessException{
       ServicioProfesor sp = new ServicioProfesor();
       for(Profesor p: sp.verProfesores()){
           System.out.println("==================      Perfil     ========================");
           System.out.println("Perfil profesor:");
           System.out.println("Nombre: " + p.getNombre());
           System.out.println("Cedula: " + p.getCedula());
           System.out.println("Email: " + p.getEmail());         
           System.out.println("============================================================");
            System.out.println("n/"); 
       }
    }
    public void verCursos(){
       
    }
    public void buscarAlumno(int o){}
    public void buscarProfesor(int o){}
    public void buscarCurso(int cod){}
    public void incribirCarrera(){}
    public void matricularCurso(){}
    public void calificarCurso(){}
    boolean isDigit(String a){
        return Integer.parseInt(a) > 0 & Integer.parseInt(a) <= 9;
    }
}
