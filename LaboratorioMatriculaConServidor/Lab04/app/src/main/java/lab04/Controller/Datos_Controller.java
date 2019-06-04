package lab04.Controller;

import android.os.StrictMode;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import lab04.LogicaNegocio.Alumno;
import lab04.LogicaNegocio.Carrera;
import lab04.LogicaNegocio.Ciclo;
import lab04.LogicaNegocio.Curso;
import lab04.LogicaNegocio.Grupo;
import lab04.LogicaNegocio.Matricula;
import lab04.LogicaNegocio.Profesor;
import lab04.LogicaNegocio.Usuario;
import lab04.Model.DatosModel;
import lab04.Model.LoginModel;

public class Datos_Controller {
    private DatosModel model = new DatosModel();
    private static final Datos_Controller ourInstance = new Datos_Controller();

    public Datos_Controller() {
        model= new DatosModel();
    }

    public DatosModel getModel() {
        return model;
    }

    public void setModel(DatosModel model) {
        this.model = model;
    }

    public static Datos_Controller getInstance() {
        return ourInstance;
    }

    public Carrera buscarCarreraXId(int id){
        Carrera resul=null;
        for(Carrera c : model.getCarreras()){
            if(c.getCodigo()==id){
                resul=c;
            }
        }
        return resul;
    }
    public Carrera buscarCarreraXNombre(String Nombre){
        Carrera resul=null;
        for(Carrera c : model.getCarreras()){
            if(c.getNombre().equals(Nombre)){
                resul=c;
            }
        }
        return resul;
    }
    public Alumno buscarAlumnoXCedula(int id){
        Alumno resul=null;
        for(Alumno c : model.getAlumnos()){
            if(c.getCedula()==id){
                resul=c;
            }
        }
        return resul;
    }
    public Profesor buscarProfesorXCedula(int id){
        Profesor resul=null;
        for(Profesor c : model.getProfesores()){
            if(c.getCedula()==id){
                resul=c;
            }
        }
        return resul;
    }
    public Curso buscarCursoXId(int id){
        Curso resul=null;
        for(Curso c : model.getCursos()){
            if(c.getCodigo()==id){
                resul=c;
            }
        }
        return resul;
    }
    public Grupo buscarGruppoXId(int id, int nrc ){
        Grupo resul=null;
        for(Grupo c : model.getGrupos()){
            if(c.getNrc()==nrc && c.getCurso()==id){
                resul=c;
            }
        }
        return resul;
    }
    public List<String> nombreCarreras(){
        List<String> nombres= new ArrayList<>();
        for(Carrera c : model.getCarreras()){
            nombres.add(c.getNombre());
        }
        return nombres;
    }
    public int posCarreras(String carrera){
        int pos=0;
        for(int i=0; i< model.getCarreras().size();i++){
            if(model.getCarreras().get(i).getNombre().equals(carrera)){
                pos=i;
            }
        }
        return pos;
    }

    public boolean deleteAlumno(int id ){
        StrictMode.ThreadPolicy policy= new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        String apiUrl = "http://"+Login_controller.getInstance().host+":"+Login_controller.getInstance().puerto+"/Sys_Matricula_Server/EliminarEstudiante?cedula="+id;
        String current = "";
        boolean res= false;
        try {
            URL url;
            HttpURLConnection urlConnection = null;
            try {
                url = new URL(apiUrl);

                urlConnection = (HttpURLConnection) url
                        .openConnection();

                InputStream in = urlConnection.getInputStream();
                BufferedReader streamReader= new BufferedReader(new InputStreamReader(in,"UTF-8"));
                StringBuilder responseStrBuilder= new StringBuilder();

                String inputStr;
                while((inputStr = streamReader.readLine())!=null){
                    responseStrBuilder.append(inputStr);
                }

                //JSONObject jsonObject = new JSONObject(responseStrBuilder.toString());
                boolean respuesta=Boolean.parseBoolean(responseStrBuilder.toString());
                cargarAlumnos();
                res= respuesta;

            } catch (Exception e) {
                e.printStackTrace();
                res=false;
            } finally {
                if (urlConnection != null) {
                    urlConnection.disconnect();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }
    public boolean deleteProfe(int id){
        StrictMode.ThreadPolicy policy= new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        String apiUrl = "http://"+Login_controller.getInstance().host+":"+Login_controller.getInstance().puerto+"/Sys_Matricula_Server/EliminarProfesor?cedula="+id;
        String current = "";
        boolean res= false;
        try {
            URL url;
            HttpURLConnection urlConnection = null;
            try {
                url = new URL(apiUrl);

                urlConnection = (HttpURLConnection) url
                        .openConnection();

                InputStream in = urlConnection.getInputStream();
                BufferedReader streamReader= new BufferedReader(new InputStreamReader(in,"UTF-8"));
                StringBuilder responseStrBuilder= new StringBuilder();

                String inputStr;
                while((inputStr = streamReader.readLine())!=null){
                    responseStrBuilder.append(inputStr);
                }
                boolean respuesta=Boolean.parseBoolean(responseStrBuilder.toString());
                cargarGrupos();
                cargarProfesores();
                res= respuesta;

            } catch (Exception e) {
                e.printStackTrace();
                res=false;
            } finally {
                if (urlConnection != null) {
                    urlConnection.disconnect();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }
    public boolean deleteCurso(int id ){
        StrictMode.ThreadPolicy policy= new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        String apiUrl = "http://"+Login_controller.getInstance().host+":"+Login_controller.getInstance().puerto+"/Sys_Matricula_Server/EliminarCurso?id="+id;
        String current = "";
        boolean res= false;
        try {
            URL url;
            HttpURLConnection urlConnection = null;
            try {
                url = new URL(apiUrl);

                urlConnection = (HttpURLConnection) url
                        .openConnection();

                InputStream in = urlConnection.getInputStream();
                BufferedReader streamReader= new BufferedReader(new InputStreamReader(in,"UTF-8"));
                StringBuilder responseStrBuilder= new StringBuilder();

                String inputStr;
                while((inputStr = streamReader.readLine())!=null){
                    responseStrBuilder.append(inputStr);
                }
                boolean respuesta=Boolean.parseBoolean(responseStrBuilder.toString());
                cargarCursos();
                cargarGrupos();
                res= respuesta;

            } catch (Exception e) {
                e.printStackTrace();
                res=false;
            } finally {
                if (urlConnection != null) {
                    urlConnection.disconnect();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }
    public boolean deleteCarrera(int id ){
        StrictMode.ThreadPolicy policy= new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        String apiUrl = "http://"+Login_controller.getInstance().host+":"+Login_controller.getInstance().puerto+"/Sys_Matricula_Server/EliminarCarrera?id="+id;
        String current = "";
        boolean res= false;
        try {
            URL url;
            HttpURLConnection urlConnection = null;
            try {
                url = new URL(apiUrl);

                urlConnection = (HttpURLConnection) url
                        .openConnection();

                InputStream in = urlConnection.getInputStream();
                BufferedReader streamReader= new BufferedReader(new InputStreamReader(in,"UTF-8"));
                StringBuilder responseStrBuilder= new StringBuilder();

                String inputStr;
                while((inputStr = streamReader.readLine())!=null){
                    responseStrBuilder.append(inputStr);
                }
                boolean respuesta=Boolean.parseBoolean(responseStrBuilder.toString());
                cargarCarreras();
                res= respuesta;

            } catch (Exception e) {
                e.printStackTrace();
                res=false;
            } finally {
                if (urlConnection != null) {
                    urlConnection.disconnect();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }

    public boolean addAlumno(Alumno al,String pass){
        StrictMode.ThreadPolicy policy= new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        String apiUrl = "http://"+Login_controller.getInstance().host+":"+Login_controller.getInstance().puerto+"/Sys_Matricula_Server/RegistroEstudiante?ced="+al.getCedula()+"&nombre="
                +al.getNombre()+"&fechaN="+al.getFecha_nacimiento()+"&edad="+al.getEdad()+"&email="+al.getEmail()+"&cel="+
                al.getTelefono()+"&carrera="+al.getCarrera().getCodigo()+"&password="+pass;
        String current = "";
        boolean res= false;
        try {
            URL url;
            HttpURLConnection urlConnection = null;
            try {
                url = new URL(apiUrl);

                urlConnection = (HttpURLConnection) url
                        .openConnection();

                InputStream in = urlConnection.getInputStream();
                BufferedReader streamReader= new BufferedReader(new InputStreamReader(in,"UTF-8"));
                StringBuilder responseStrBuilder= new StringBuilder();

                String inputStr;
                while((inputStr = streamReader.readLine())!=null){
                    responseStrBuilder.append(inputStr);
                }
                boolean respuesta=Boolean.parseBoolean(responseStrBuilder.toString());
                cargarAlumnos();
                res= respuesta;

            } catch (Exception e) {
                e.printStackTrace();
                res=false;
            } finally {
                if (urlConnection != null) {
                    urlConnection.disconnect();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }
    public boolean updateAlumno(Alumno al) throws UnsupportedEncodingException {
        StrictMode.ThreadPolicy policy= new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        String apiUrl = "http://"+Login_controller.getInstance().host+":"+Login_controller.getInstance().puerto+"/Sys_Matricula_Server/ModificarEstudiante?ced="+al.getCedula()+"&nombre="
                +al.getNombre()+"&fechaN="+al.getFecha_nacimiento()+"&edad="+al.getEdad()+"&email="+al.getEmail()+"&cel="+
                al.getTelefono()+"&carrera="+al.getCarrera().getCodigo();
        String mitad1="";
        String mitad2;
        for(int i=0; i< apiUrl.length();i++){
            if(apiUrl.charAt(i)==' '){
                mitad1=mitad1+"%20";

            }else{
                mitad1=mitad1+apiUrl.charAt(i);
            }
        }
        boolean res= false;
        try {
            URL url;
            HttpURLConnection urlConnection = null;
            try {
                url = new URL(mitad1);

                urlConnection = (HttpURLConnection) url
                        .openConnection();
                int status= urlConnection.getResponseCode();
                InputStream in=null;
                if(status >= 200 && status <400){
                    in = urlConnection.getInputStream();
                    BufferedReader streamReader= new BufferedReader(new InputStreamReader(in,"UTF-8"));
                    StringBuilder responseStrBuilder= new StringBuilder();

                    String inputStr;
                    while((inputStr = streamReader.readLine())!=null){
                        responseStrBuilder.append(inputStr);
                    }
                    boolean respuesta=Boolean.parseBoolean(responseStrBuilder.toString());
                    cargarAlumnos();
                    res= respuesta;
                }else{
                    in=urlConnection.getErrorStream();
                    BufferedReader streamReader= new BufferedReader(new InputStreamReader(in,"UTF-8"));
                    StringBuilder responseStrBuilder= new StringBuilder();

                    String inputStr;
                    while((inputStr = streamReader.readLine())!=null){
                        responseStrBuilder.append(inputStr);
                    }
                }


            } catch (Exception e) {
                e.printStackTrace();
                res=false;
            } finally {
                if (urlConnection != null) {
                    urlConnection.disconnect();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }
    public boolean addProfesor(Profesor p , String pass){
        StrictMode.ThreadPolicy policy= new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        String apiUrl = "http://"+Login_controller.getInstance().host+":"+Login_controller.getInstance().puerto+"/Sys_Matricula_Server/RegistroProfesor?ced="+p.getCedula()+"&nombre="
                +p.getNombre()+"&edad="+p.getEdad()+"&email="+p.getEmail()+"&cel="+
                p.getTelefono()+"&password="+pass;
        String current = "";
        boolean res= false;
        try {
            URL url;
            HttpURLConnection urlConnection = null;
            try {
                url = new URL(apiUrl);

                urlConnection = (HttpURLConnection) url
                        .openConnection();

                InputStream in = urlConnection.getInputStream();
                BufferedReader streamReader= new BufferedReader(new InputStreamReader(in,"UTF-8"));
                StringBuilder responseStrBuilder= new StringBuilder();

                String inputStr;
                while((inputStr = streamReader.readLine())!=null){
                    responseStrBuilder.append(inputStr);
                }
                boolean respuesta=Boolean.parseBoolean(responseStrBuilder.toString());
                cargarProfesores();
                res= respuesta;

            } catch (Exception e) {
                e.printStackTrace();
                res=false;
            } finally {
                if (urlConnection != null) {
                    urlConnection.disconnect();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }
    public boolean updateProfesor(Profesor p){
        StrictMode.ThreadPolicy policy= new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        String apiUrl = "http://"+Login_controller.getInstance().host+":"+Login_controller.getInstance().puerto+"/Sys_Matricula_Server/ModificarProfesor?ced="+p.getCedula()+"&nombre="
                +p.getNombre()+"&edad="+p.getEdad()+"&email="+p.getEmail()+"&cel="+
                p.getTelefono();
        String current = "";
        boolean res= false;
        try {
            URL url;
            HttpURLConnection urlConnection = null;
            try {
                url = new URL(apiUrl);

                urlConnection = (HttpURLConnection) url
                        .openConnection();

                InputStream in = urlConnection.getInputStream();
                BufferedReader streamReader= new BufferedReader(new InputStreamReader(in,"UTF-8"));
                StringBuilder responseStrBuilder= new StringBuilder();

                String inputStr;
                while((inputStr = streamReader.readLine())!=null){
                    responseStrBuilder.append(inputStr);
                }
                boolean respuesta=Boolean.parseBoolean(responseStrBuilder.toString());
                cargarProfesores();
                res= respuesta;

            } catch (Exception e) {
                e.printStackTrace();
                res=false;
            } finally {
                if (urlConnection != null) {
                    urlConnection.disconnect();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }
    public boolean addCurso(Curso c){
        StrictMode.ThreadPolicy policy= new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        String apiUrl = "http://"+Login_controller.getInstance().host+":"+Login_controller.getInstance().puerto+"/Sys_Matricula_Server/CrearCurso?codigo="+c.getCodigo()+
                "&nombre="+c.getNombre()+"&cred="+c.getCreditos()+"&horas="+(int)c.getHoras_semanales();
        String current = "";
        boolean res= false;
        try {
            URL url;
            HttpURLConnection urlConnection = null;
            try {
                url = new URL(apiUrl);

                urlConnection = (HttpURLConnection) url
                        .openConnection();

                InputStream in = urlConnection.getInputStream();
                BufferedReader streamReader= new BufferedReader(new InputStreamReader(in,"UTF-8"));
                StringBuilder responseStrBuilder= new StringBuilder();

                String inputStr;
                while((inputStr = streamReader.readLine())!=null){
                    responseStrBuilder.append(inputStr);
                }
                boolean respuesta=Boolean.parseBoolean(responseStrBuilder.toString());
                cargarCursos();
                res= respuesta;

            } catch (Exception e) {
                e.printStackTrace();
                res=false;
            } finally {
                if (urlConnection != null) {
                    urlConnection.disconnect();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }
    public boolean updateCurso(Curso c){
        StrictMode.ThreadPolicy policy= new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        String apiUrl = "http://"+Login_controller.getInstance().host+":"+Login_controller.getInstance().puerto+"/Sys_Matricula_Server/ModificarCurso?codigo="+c.getCodigo()+
                "&nombre="+c.getNombre()+"&cred="+c.getCreditos()+"&horas="+(int)c.getHoras_semanales();
        String current = "";
        boolean res= false;
        try {
            URL url;
            HttpURLConnection urlConnection = null;
            try {
                url = new URL(apiUrl);

                urlConnection = (HttpURLConnection) url
                        .openConnection();

                InputStream in = urlConnection.getInputStream();
                BufferedReader streamReader= new BufferedReader(new InputStreamReader(in,"UTF-8"));
                StringBuilder responseStrBuilder= new StringBuilder();

                String inputStr;
                while((inputStr = streamReader.readLine())!=null){
                    responseStrBuilder.append(inputStr);
                }
                boolean respuesta=Boolean.parseBoolean(responseStrBuilder.toString());
                cargarCursos();
                res= respuesta;

            } catch (Exception e) {
                e.printStackTrace();
                res=false;
            } finally {
                if (urlConnection != null) {
                    urlConnection.disconnect();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }
    public boolean addCarrera(Carrera c){
        StrictMode.ThreadPolicy policy= new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        String apiUrl = "http://"+Login_controller.getInstance().host+":"+Login_controller.getInstance().puerto+"/Sys_Matricula_Server/CrearCarrera?codigo="
                +c.getCodigo()+"&nombre="+c.getNombre()+"&titulo="+c.getTitulo();
        String current = "";
        boolean res= false;
        try {
            URL url;
            HttpURLConnection urlConnection = null;
            try {
                url = new URL(apiUrl);

                urlConnection = (HttpURLConnection) url
                        .openConnection();

                InputStream in = urlConnection.getInputStream();
                BufferedReader streamReader= new BufferedReader(new InputStreamReader(in,"UTF-8"));
                StringBuilder responseStrBuilder= new StringBuilder();

                String inputStr;
                while((inputStr = streamReader.readLine())!=null){
                    responseStrBuilder.append(inputStr);
                }
                boolean respuesta=Boolean.parseBoolean(responseStrBuilder.toString());
                cargarCarreras();
                res= respuesta;

            } catch (Exception e) {
                e.printStackTrace();
                res=false;
            } finally {
                if (urlConnection != null) {
                    urlConnection.disconnect();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }
    public boolean updateCarrera(Carrera c){
        StrictMode.ThreadPolicy policy= new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        String apiUrl = "http://"+Login_controller.getInstance().host+":"+Login_controller.getInstance().puerto+"/Sys_Matricula_Server/ModificarCarrera?codigo="
                +c.getCodigo()+"&nombre="+c.getNombre()+"&titulo="+c.getTitulo();
        String current = "";
        boolean res= false;
        try {
            URL url;
            HttpURLConnection urlConnection = null;
            try {
                url = new URL(apiUrl);

                urlConnection = (HttpURLConnection) url
                        .openConnection();

                InputStream in = urlConnection.getInputStream();
                BufferedReader streamReader= new BufferedReader(new InputStreamReader(in,"UTF-8"));
                StringBuilder responseStrBuilder= new StringBuilder();

                String inputStr;
                while((inputStr = streamReader.readLine())!=null){
                    responseStrBuilder.append(inputStr);
                }
                boolean respuesta=Boolean.parseBoolean(responseStrBuilder.toString());
                cargarCarreras();
                res= respuesta;

            } catch (Exception e) {
                e.printStackTrace();
                res=false;
            } finally {
                if (urlConnection != null) {
                    urlConnection.disconnect();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }
    public void serializarCarrera(JSONObject jsonObject) throws JSONException {
        List<Carrera> carreraList= new ArrayList<>();
        JSONArray jsonArray= jsonObject.getJSONArray("myArrayList");
        for(int i=0; i< jsonArray.length();i++){
            JSONObject car= jsonArray.getJSONObject(i);
            int codigo= car.getInt("codigo");
            String nombre= car.getString("nombre");
            String titulo= car.getString("titulo");
            Carrera carrera= new Carrera(codigo,nombre,titulo);
            carreraList.add(carrera);
        }
        model.setCarreras(carreraList);
    }
    public void serializarGrupo(JSONObject jsonObject) throws JSONException {
        List<Grupo> grupos= new ArrayList<>();
        JSONArray jsonArray= jsonObject.getJSONArray("myArrayList");
        for(int i=0; i< jsonArray.length();i++){
            JSONObject car= jsonArray.getJSONObject(i);
            int capacidad = car.getInt("capacidad");
            int ciclo = car.getInt("ciclo");
            int curso= car.getInt("curso");
            int nrc = car.getInt("nrc");
            String horario=car.getString("horario");
            int profe= car.getInt("porfesor");
            Grupo g= new Grupo(nrc,curso,capacidad,horario,profe,ciclo);
            grupos.add(g);
        }
        model.setGrupos(grupos);
    }
    public void serializarAlumno(JSONObject jsonObject) throws JSONException {
        List<Alumno> alumnos= new ArrayList<>();
        JSONArray jsonArray= jsonObject.getJSONArray("myArrayList");
        for(int i=0; i< jsonArray.length();i++){
            JSONObject car= jsonArray.getJSONObject(i);
            String fechaN= car.getString("fechaN");
            int creditos= car.getInt("creditos");
            String nombre= car.getString("nombre");
            int cedula= car.getInt("cedula");
            String email= car.getString("email");
            int edad= car.getInt("edad");
            int telefono= car.getInt("telefono");
            JSONObject carrera= car.getJSONObject("carrera");
            int cod= carrera.getInt("codigo");
            Carrera carr= buscarCarreraXId(cod);
            Alumno alumno= new Alumno(cedula,nombre,fechaN,edad,email,carr,telefono);
            alumnos.add(alumno);
        }
        model.setAlumnos(alumnos);
    }
    public void serializarProfesor(JSONObject jsonObject) throws JSONException {
        List<Profesor> profes= new ArrayList<>();
        JSONArray jsonArray= jsonObject.getJSONArray("myArrayList");
        for(int i=0; i< jsonArray.length();i++){
            JSONObject car= jsonArray.getJSONObject(i);
            int cedula= car.getInt("cedula");
            String nombre= car.getString("nombre");
            String email= car.getString("email");
            int edad= car.getInt("edad");
            int telefono= car.getInt("telefono");
            Profesor profesor= new Profesor(cedula,nombre,edad,telefono,email);
            profes.add(profesor);
        }
        model.setProfesores(profes);
    }
    public void serializarCiclo(JSONObject jsonObject) throws JSONException {
        List<Ciclo> ciclos= new ArrayList<>();
        JSONArray jsonArray= jsonObject.getJSONArray("myArrayList");
        for(int i=0; i< jsonArray.length();i++){
            JSONObject car= jsonArray.getJSONObject(i);
            int codigo = car.getInt("codigo");
            String descripcion= car.getString("descripcion");
            String fecha_inicio= car.getString("fecha_inicio");
            String fecha_finalizacion=car.getString("fecha_finalizacion");
            Ciclo c= new Ciclo(codigo,descripcion,fecha_inicio,fecha_finalizacion);
            ciclos.add(c);
        }
        model.setCiclos(ciclos);
    }
    public void serializarCurso(JSONObject jsonObject) throws JSONException {
        List<Curso> cursos= new ArrayList<>();
        JSONArray jsonArray= jsonObject.getJSONArray("myArrayList");
        for(int i=0; i< jsonArray.length();i++){
            JSONObject car= jsonArray.getJSONObject(i);
            int codigo= car.getInt("codigo");
            String nombre= car.getString("nombre");
            int creditos= car.getInt("creditos");
            int horas= car.getInt("horas_semanales");
            Curso curso= new Curso(codigo,nombre,creditos,horas);
            cursos.add(curso);
        }
        model.setCursos(cursos);
    }
    public void cargarCarreras(){
        String apiUrl = "http://"+Login_controller.getInstance().host+":"+Login_controller.getInstance().puerto+"/Sys_Matricula_Server/BusquedaDatos?action=carreras";
        String current = "";
        try {
            URL url;
            HttpURLConnection urlConnection = null;
            try {
                url = new URL(apiUrl);

                urlConnection = (HttpURLConnection) url
                        .openConnection();

                InputStream in = urlConnection.getInputStream();
                BufferedReader streamReader= new BufferedReader(new InputStreamReader(in,"UTF-8"));
                StringBuilder responseStrBuilder= new StringBuilder();

                String inputStr;
                while((inputStr = streamReader.readLine())!=null){
                    responseStrBuilder.append(inputStr);
                }
                JSONObject jsonObject = new JSONObject(responseStrBuilder.toString());
                serializarCarrera(jsonObject);

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (urlConnection != null) {
                    urlConnection.disconnect();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }}
    public void cargarCursos(){
        String apiUrl = "http://"+Login_controller.getInstance().host+":"+Login_controller.getInstance().puerto+"/Sys_Matricula_Server/BusquedaDatos?action=cursos";
        String current = "";
        try {
            URL url;
            HttpURLConnection urlConnection = null;
            try {
                url = new URL(apiUrl);

                urlConnection = (HttpURLConnection) url
                        .openConnection();

                InputStream in = urlConnection.getInputStream();
                BufferedReader streamReader= new BufferedReader(new InputStreamReader(in,"UTF-8"));
                StringBuilder responseStrBuilder= new StringBuilder();

                String inputStr;
                while((inputStr = streamReader.readLine())!=null){
                    responseStrBuilder.append(inputStr);
                }
                JSONObject jsonObject = new JSONObject(responseStrBuilder.toString());
                serializarCurso(jsonObject);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (urlConnection != null) {
                    urlConnection.disconnect();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void cargarProfesores(){
        String apiUrl = "http://"+Login_controller.getInstance().host+":"+Login_controller.getInstance().puerto+"/Sys_Matricula_Server/BusquedaDatos?action=profesores";
        String current = "";
        try {
            URL url;
            HttpURLConnection urlConnection = null;
            try {
                url = new URL(apiUrl);

                urlConnection = (HttpURLConnection) url
                        .openConnection();

                InputStream in = urlConnection.getInputStream();
                BufferedReader streamReader= new BufferedReader(new InputStreamReader(in,"UTF-8"));
                StringBuilder responseStrBuilder= new StringBuilder();

                String inputStr;
                while((inputStr = streamReader.readLine())!=null){
                    responseStrBuilder.append(inputStr);
                }
                JSONObject jsonObject = new JSONObject(responseStrBuilder.toString());
                serializarProfesor(jsonObject);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (urlConnection != null) {
                    urlConnection.disconnect();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void cargarGrupos(){
        String apiUrl = "http://"+Login_controller.getInstance().host+":"+Login_controller.getInstance().puerto+"/Sys_Matricula_Server/BusquedaDatos?action=grupos";
        String current = "";
        try {
            URL url;
            HttpURLConnection urlConnection = null;
            try {
                url = new URL(apiUrl);

                urlConnection = (HttpURLConnection) url
                        .openConnection();

                InputStream in = urlConnection.getInputStream();
                BufferedReader streamReader= new BufferedReader(new InputStreamReader(in,"UTF-8"));
                StringBuilder responseStrBuilder= new StringBuilder();

                String inputStr;
                while((inputStr = streamReader.readLine())!=null){
                    responseStrBuilder.append(inputStr);
                }
                JSONObject jsonObject = new JSONObject(responseStrBuilder.toString());
                serializarGrupo(jsonObject);


            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (urlConnection != null) {
                    urlConnection.disconnect();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void cargarCiclos(){
        String apiUrl = "http://"+Login_controller.getInstance().host+":"+Login_controller.getInstance().puerto+"/Sys_Matricula_Server/BusquedaDatos?action=ciclos";
        String current = "";
        try {
            URL url;
            HttpURLConnection urlConnection = null;
            try {
                url = new URL(apiUrl);

                urlConnection = (HttpURLConnection) url
                        .openConnection();

                InputStream in = urlConnection.getInputStream();
                BufferedReader streamReader= new BufferedReader(new InputStreamReader(in,"UTF-8"));
                StringBuilder responseStrBuilder= new StringBuilder();

                String inputStr;
                while((inputStr = streamReader.readLine())!=null){
                    responseStrBuilder.append(inputStr);
                }
                JSONObject jsonObject = new JSONObject(responseStrBuilder.toString());
                serializarCiclo(jsonObject);


            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (urlConnection != null) {
                    urlConnection.disconnect();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void cargarAlumnos(){
        String apiUrl = "http://"+Login_controller.getInstance().host+":"+Login_controller.getInstance().puerto+"/Sys_Matricula_Server/BusquedaDatos?action=alumnos";
        String current = "";
        try {
            URL url;
            HttpURLConnection urlConnection = null;
            try {
                url = new URL(apiUrl);

                urlConnection = (HttpURLConnection) url
                        .openConnection();

                InputStream in = urlConnection.getInputStream();
                BufferedReader streamReader= new BufferedReader(new InputStreamReader(in,"UTF-8"));
                StringBuilder responseStrBuilder= new StringBuilder();

                String inputStr;
                while((inputStr = streamReader.readLine())!=null){
                    responseStrBuilder.append(inputStr);
                }
                JSONObject jsonObject = new JSONObject(responseStrBuilder.toString());
                serializarAlumno(jsonObject);

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (urlConnection != null) {
                    urlConnection.disconnect();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void cargarAplicacion(){
        if(!model.isCargado()){
            cargarCarreras();
            cargarAlumnos();
            cargarCiclos();
            cargarProfesores();
            cargarCursos();
            cargarGrupos();
        }

    }



    public void actualizarEstudiante(int cedula, Alumno alumno){

    }
    public void actualizarProfesor(int cedula, Profesor profesor){

    }
    public void actualizarCarrera(int codigo,Carrera carrera){

    }
    public void actualizarCurso(int codigo,Curso c){

    }

}
