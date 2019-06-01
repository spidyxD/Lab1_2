package lab04.AccesoDatos;
import lab04.LogicaNegocio.Administrador;
import lab04.LogicaNegocio.Alumno;
import lab04.LogicaNegocio.Carrera;
import lab04.LogicaNegocio.Ciclo;
import lab04.LogicaNegocio.Curso;
import lab04.LogicaNegocio.Grupo;
import lab04.LogicaNegocio.Matricula;
import lab04.LogicaNegocio.Profesor;
import lab04.LogicaNegocio.Usuario;


import java.security.SecureRandom;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class ModeloDeDatos {
    private List<Carrera> carreras;
    private List<Curso> cursos;
    private List<Alumno> alumnos;
    private List<Profesor> profesores;
    private List<Administrador> administradores;
    private List<Matricula> matriculas;
    private List<Ciclo> ciclos;
    private List<Grupo> grupos;
    private List<Usuario> usuarios;

    private Carrera currentCarrera;
    private Curso currentCurso;
    private Alumno currentAlumno;
    private Profesor currentProfesor;

    private String modo;

    public String getModo() {
        return modo;
    }

    public void setModo(String modo) {
        this.modo = modo;
    }

    public Alumno getCurrentAlumno() {
        return currentAlumno;
    }

    public void setCurrentAlumno(Alumno currentAlumno) {
        this.currentAlumno = currentAlumno;
    }

    public Profesor getCurrentProfesor() {
        return currentProfesor;
    }

    public void setCurrentProfesor(Profesor currentProfesor) {
        this.currentProfesor = currentProfesor;
    }

    public List<Matricula> getMatriculas() {
        return matriculas;
    }

    public void setMatriculas(List<Matricula> matriculas) {
        this.matriculas = matriculas;
    }

    public Carrera getCurrentCarrera() {
        return currentCarrera;
    }

    public void setCurrentCarrera(Carrera currentCarrera) {
        this.currentCarrera = currentCarrera;
    }

    public Curso getCurrentCurso() {
        return currentCurso;
    }

    public void setCurrentCurso(Curso currentCurso) {
        this.currentCurso = currentCurso;
    }

    public ModeloDeDatos(){
        carreras= new ArrayList<>();
        cursos= new ArrayList<>();
        alumnos= new ArrayList<>();
        profesores = new ArrayList<>();
        administradores= new ArrayList<>();
        matriculas= new ArrayList<>();
        ciclos= new ArrayList<>();
        grupos= new ArrayList<>();
        usuarios= new ArrayList<>();
        currentCarrera=new Carrera();
        currentCurso=new Curso();
        currentAlumno=new Alumno();
        currentProfesor= new Profesor();
        prepararCursos();
        prepararCarreras();
        preparAdministradores();
        prepararProfesores();
        prepararAlumnos();
        prepararCiclos();
        prepararCursos();
        prepararGrupos();
        asignarGruposAprofes();
        prepararMatriculas();
    }

    public List<Carrera> getCarreras() {
        return carreras;
    }

    public void setCarreras(List<Carrera> carreras) {
        this.carreras = carreras;
    }

    public List<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(List<Curso> cursos) {
        this.cursos = cursos;
    }

    public List<Alumno> getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(List<Alumno> alumnos) {
        this.alumnos = alumnos;
    }

    public List<Profesor> getProfesores() {
        return profesores;
    }

    public void setProfesores(List<Profesor> profesores) {
        this.profesores = profesores;
    }

    public List<Administrador> getAdministradores() {
        return administradores;
    }

    public void setAdministradores(List<Administrador> administradores) {
        this.administradores = administradores;
    }

    public List<Ciclo> getCiclos() {
        return ciclos;
    }

    public void setCiclos(List<Ciclo> ciclos) {
        this.ciclos = ciclos;
    }

    public List<Grupo> getGrupos() {
        return grupos;
    }

    public void setGrupos(List<Grupo> grupos) {
        this.grupos = grupos;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public void preparAdministradores(){
        Administrador admin1= new Administrador(207680641,"Estefany Hernandez Arce");
        Administrador admin2= new Administrador(345679864,"Addiel Amador ");
        administradores.add(admin1);
        administradores.add(admin2);
        crearUsuario(207680641,"Administrador");
        crearUsuario(345679864,"Administrador");
    }
    public void prepararAlumnos(){

        alumnos.add(new Alumno(8362398,"Mirella Martinez","15/04/1995",24,"mirellam@gmail.com",carreras.get(0),896755));
        crearUsuario(8362398,"Alumno");
        alumnos.add(new Alumno(9859859,"Lourdes Ramirez","04/04/1997",22,"lourdes@gmail.com",carreras.get(1),896755));
        crearUsuario(9859859,"Alumno");
        alumnos.add(new Alumno(4564665,"María Jose Soto","04/04/1997",22,"mariasoto@gmail.com",carreras.get(0),896755));
        crearUsuario(4564665,"Alumno");
        alumnos.add(new Alumno(4465656,"Kimberly Hernandez Arce","04/04/1997",22,"kimher@gmail.com",carreras.get(1),896755));
        crearUsuario(4465656,"Alumno");
        alumnos.add(new Alumno(5675656,"Jennifer Hernandez Arce","04/04/1997",22,"jenniher@gmail.com",carreras.get(2),896755));
        crearUsuario(5675656,"Alumno");
        alumnos.add(new Alumno(9879586,"Karol Hernandez Arce","04/04/1997",22,"karolher@gmail.com",carreras.get(2),896755));
        crearUsuario(9879586,"Alumno");
        alumnos.add(new Alumno(4343453,"Zoe Montero Hernandez","04/04/1997",22,"zoemontero@gmail.com",carreras.get(1),896755));
        crearUsuario(4343453,"Alumno");
    }
    public void prepararProfesores(){
        profesores.add(new Profesor (1763589,"Juan Perez",35,87656789,"juanp@gmail.com"));
        crearUsuario(1763589,"Profesor");
        profesores.add(new Profesor (6543789,"Margarita Gomez",31,76427896,"margaritag@gmail.com"));
        crearUsuario(6543789,"Profesor");
        profesores.add(new Profesor (7648903,"Lucresia Ramirez",45,86345678,"lucresiar@gmail.com"));
        crearUsuario(7648903,"Profesor");
        profesores.add(new Profesor (2789456,"Pablo Lopez",57,89345678,"pablol@gmail.com"));
        crearUsuario(2789456,"Profesor");
    }
    public void crearUsuario(int username,String rol){
        usuarios.add(new Usuario(username,"12345",rol));
    }
    public Curso getCursoXcOD(int c){
        Curso resultado=null;
        for (Curso cu: cursos){
            if(cu.getCodigo()==c){
                resultado=cu;
            }
        }
        return resultado;
    }
    public void prepararCarreras(){
        List<Curso> veterinaria = new ArrayList<>();
        veterinaria.add(getCursoXcOD(1));
        veterinaria.add(getCursoXcOD(2));
        veterinaria.add(getCursoXcOD(3));
        veterinaria.add(getCursoXcOD(4));
        veterinaria.add(getCursoXcOD(5));
        veterinaria.add(getCursoXcOD(6));

        List<Curso> sistemas = new ArrayList<>();
        sistemas.add(getCursoXcOD(59));
        sistemas.add(getCursoXcOD(60));
        sistemas.add(getCursoXcOD(61));
        sistemas.add(getCursoXcOD(62));
        sistemas.add(getCursoXcOD(63));

        List<Curso> administracion = new ArrayList<>();
        administracion.add(getCursoXcOD(99));
        administracion.add(getCursoXcOD(100));
        administracion.add(getCursoXcOD(101));
        administracion.add(getCursoXcOD(102));
        administracion.add(getCursoXcOD(103));
        administracion.add(getCursoXcOD(104));
        administracion.add(getCursoXcOD(105));
        administracion.add(getCursoXcOD(106));
        administracion.add(getCursoXcOD(107));
        administracion.add(getCursoXcOD(108));
        administracion.add(getCursoXcOD(109));
        administracion.add(getCursoXcOD(110));
        administracion.add(getCursoXcOD(111));
        carreras.add(new Carrera(1,"Medicina Veterinaria","Licenciatura",veterinaria));
        carreras.add(new Carrera(2,"Ingenieria en Sistemas","Bachillerato",sistemas));
        carreras.add(new Carrera(3,"Administracion","Bachillerato",administracion));
    }
    public Curso getCursoXCodigo(int codigo){
        Curso resultado = new Curso();
        for (int i =0; i< cursos.size();i++){
            if (cursos.get(i).getCodigo()== codigo){
                resultado= cursos.get(i);
            }
        }
        return resultado;
    }
    public Profesor getProfesorXCed(int ced){
        Profesor resultado = new Profesor();
        for (int i =0; i< profesores.size(); i++){
            if(profesores.get(i).getCedula() == ced){
                resultado= profesores.get(i);
            }
        }return resultado;
    }
    public void updateAdministrador(int ced, String nombre){
        for(Administrador admin : administradores){
            if(admin.getCedula()==ced){
                admin.setNombre(nombre);
            }
        }
    }
    public Alumno getAlumnoXCed(int ced){
        Alumno resultado = new Alumno();
        for (int i =0; i< alumnos.size(); i++){
            if(alumnos.get(i).getCedula() == ced){
                resultado= alumnos.get(i);
            }
        }return resultado;
    }
    public Administrador getAdministradorXCed(int ced){
        Administrador resultado = new Administrador();
        for (int i =0; i< administradores.size(); i++){
            if(administradores.get(i).getCedula() == ced){
                resultado= administradores.get(i);
            }
        }return resultado;
    }
    public Ciclo getCicloXCod(int ced){
        Ciclo resultado = new Ciclo();
        for (int i =0; i< ciclos.size(); i++){
            if(ciclos.get(i).getCodigo() == ced){
                resultado= ciclos.get(i);
            }
        }return resultado;
    }
    public Carrera getCarreraXNombre(String nombre){
        Carrera resultado = new Carrera();
        for (int i =0; i< carreras.size(); i++){
            if(carreras.get(i).getNombre().equals(nombre)){
                resultado= carreras.get(i);
            }
        }return resultado;
    }
    public void actualizarEstudiante(int cedula, Alumno alumno){
        for (int i =0; i< alumnos.size(); i++){
            if(alumnos.get(i).getCedula()==cedula){
                alumnos.set(i,alumno);
            }
        }
    }
    public void actualizarProfesor(int cedula, Profesor profesor){
        for (int i =0; i< profesores.size(); i++){
            if(profesores.get(i).getCedula()==cedula){
                profesores.set(i,profesor);
            }
        }
    }
    public void actualizarCarrera(int codigo,Carrera carrera){
        for (int i =0; i< carreras.size(); i++){
            if(carreras.get(i).getCodigo()==codigo){
                carreras.set(i,carrera);
            }
        }
    }
    public void actualizarCurso(int codigo,Curso c){
        for (int i =0; i< cursos.size(); i++){
            if(cursos.get(i).getCodigo()==codigo){
                cursos.set(i,c);
            }
        }
    }
    public void deleteAlumno(int ced){
        for (Alumno a : alumnos){
            if(a.getCedula()==ced){
                alumnos.remove(a);
                return;
            }
        }
    }
    public void deleteProf(int ced){
        for (Profesor a : profesores){
            if(a.getCedula()==ced){
                profesores.remove(a);
                return;
            }
        }
    }
    public void deleteCarrera(int ced){
        for (Carrera a : carreras){
            if(a.getCodigo()==ced){
                carreras.remove(a);
                return;
            }
        }
    }
    public void deleteCurso(int ced){
        for (Curso a : cursos){
            if(a.getCodigo()==ced){
                cursos.remove(a);
                return;
            }
        }
    }
    public void prepararCursos(){
        cursos.add(new Curso(1,"Estudios Generales 1",3,3));
        cursos.add(new Curso(2,"Estudios Generales 2",3,3));
        cursos.add(new Curso(3,"Introduccion a la Quimica General",4,4));
        cursos.add(new Curso(4,"Zoologia",3,3));
        cursos.add(new Curso(5,"Ingles Tecnico",3,3));
        cursos.add(new Curso(6,"Optativo",2,2));
        cursos.add(new Curso(59,"Fundamentos de Informatica",3,3));
        cursos.add(new Curso(60,"Matemática para Informatica I",4,4));
        cursos.add(new Curso(61,"Arte",3,3));
        cursos.add(new Curso(62,"Cambio Climatico",3,3));
        cursos.add(new Curso(63,"Ingles Integrado I",4,4));
        cursos.add(new Curso(99,"Finanza Empresariales",2,2));
        cursos.add(new Curso(100,"Desarrollo Socioeconomico de Costa Rica",2,2));
        cursos.add(new Curso(101,"Paradigmas Administrativos",4,4));
        cursos.add(new Curso(102,"Derecho Administrativo",2,2));
        cursos.add(new Curso(103,"Administracion de Recursos Humanos I",4,4));
        cursos.add(new Curso(104,"Derecho Laboral",2,2));
        cursos.add(new Curso(105,"Contabilidad Avanzada",4,4));
        cursos.add(new Curso(106,"Microeconomia",2,2));
        cursos.add(new Curso(107,"Analisis de Procesos Administrativos",4,4));
        cursos.add(new Curso(108,"Derecho Empresarial",2,2));
        cursos.add(new Curso(109,"Administracion Bursátil",2,2));
        cursos.add(new Curso(110,"Elaboracion y Evaluación de Proyectos",4,4));
        cursos.add(new Curso(111,"Investigacion de Mercados",2,2));
    }
    public void prepararCiclos(){
       /* Date date= new Date("2018/02/08");
        ciclos.add(new Ciclo(01,"CICLO I 2018","2018/02/08","2018/06/28"));
        ciclos.add(new Ciclo(02,"CICLO II 2018","2018/07/12","2018/11/26"));
        ciclos.add(new Ciclo(03,"CICLO I 2019","2019/02/08","2019/06/28"));
        ciclos.add(new Ciclo(04,"CICLO II 2019","2019/07/12","2019/11/26"));*/
    }
    public Grupo getGrupoXNRC(int nrc){
        Grupo res = null;
        for(Grupo g : grupos){
            if(g.getNrc()==nrc){
                res= g;
            }
        }
        return res;
    }
    public void asignarGruposAprofes(){
      /*  for(Grupo g : grupos){
            g.getPorfesor().getGrupos().add(g);
        }*/
    }
    public void prepararGrupos(){
        grupos.add(new Grupo(100,getCursoXCodigo(1),25,"L-V 8:00AM-10:40AM",getProfesorXCed(1763589),getCicloXCod(03)));
        grupos.add(new Grupo(101,getCursoXCodigo(2),25,"L-V 8:00AM-10:40AM",getProfesorXCed(1763589),getCicloXCod(03)));
        grupos.add(new Grupo(102,getCursoXCodigo(3),25,"L-V 8:00AM-10:40AM",getProfesorXCed(1763589),getCicloXCod(03)));
        grupos.add(new Grupo(103,getCursoXCodigo(4),25,"L-V 8:00AM-10:40AM",getProfesorXCed(1763589),getCicloXCod(03)));
        grupos.add(new Grupo(104,getCursoXCodigo(5),25,"L-V 8:00AM-10:40AM",getProfesorXCed(1763589),getCicloXCod(03)));
        grupos.add(new Grupo(105,getCursoXCodigo(6),25,"L-V 8:00AM-10:40AM",getProfesorXCed(1763589),getCicloXCod(03)));

        grupos.add(new Grupo(106,getCursoXCodigo(59),25,"L-V 8:00AM-10:40AM",getProfesorXCed(6543789),getCicloXCod(03)));
        grupos.add(new Grupo(107,getCursoXCodigo(60),25,"L-V 8:00AM-10:40AM",getProfesorXCed(6543789),getCicloXCod(03)));
        grupos.add(new Grupo(108,getCursoXCodigo(61),25,"L-V 8:00AM-10:40AM",getProfesorXCed(6543789),getCicloXCod(03)));
        grupos.add(new Grupo(109,getCursoXCodigo(62),25,"L-V 8:00AM-10:40AM",getProfesorXCed(6543789),getCicloXCod(03)));
        grupos.add(new Grupo(110,getCursoXCodigo(63),25,"L-V 8:00AM-10:40AM",getProfesorXCed(6543789),getCicloXCod(03)));

    }

    void prepararMatriculas(){
        Alumno al= getAlumnoXCed(4343453);
        Grupo g1= getGrupoXNRC(106);
        Grupo g2= getGrupoXNRC(107);
        g1.setCapacidad(g1.getCapacidad()-1);
        g2.setCapacidad(g2.getCapacidad()-1);
        matricular(al,g1);
        matricular(al,g2);
    }

    void matricular(Alumno student, Grupo grupo){
        grupo.setCapacidad(grupo.getCapacidad()-1);
        matriculas.add(new Matricula(student,student.getCarrera(),grupo.getCurso(),grupo.getPorfesor(),grupo.getCiclo(),grupo));
        //student.getGrupos().add(grupo);
    }
}

