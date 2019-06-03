package lab04.Controller;

import android.graphics.ColorSpace;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import lab04.LogicaNegocio.Administrador;
import lab04.LogicaNegocio.Alumno;
import lab04.LogicaNegocio.Carrera;
import lab04.LogicaNegocio.Curso;
import lab04.LogicaNegocio.Grupo;
import lab04.LogicaNegocio.Matricula;
import lab04.Model.AlumnoModel;

public class Alumno_Controller {
    private AlumnoModel model ;
    private static final Alumno_Controller uniqueInstance = new Alumno_Controller();

    public Alumno_Controller(AlumnoModel model) {
        this.model = model;
    }

    public AlumnoModel getModel() {
        return model;
    }

    public void setModel(AlumnoModel model) {
        this.model = model;
    }

    public static Alumno_Controller instance(){
        return uniqueInstance;
    }
    public Alumno_Controller() {
        this.model= new AlumnoModel();
    }
    public void cargarPerfil(){

    }
    public void cragarGruposMatriculados(int user , String pass){
        String apiUrl = "http://"+Login_controller.getInstance().host+":"+Login_controller.getInstance().puerto+"/Sys_Matricula_Server/doLogin?user="+user+"&password="+pass+"&action=gruposAlumno";
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
                List<Matricula> matriculas= new ArrayList<>();
                JSONObject jsonObject = new JSONObject(responseStrBuilder.toString());
                JSONArray jsonArray= jsonObject.getJSONArray("myArrayList");
                for(int i=0; i< jsonArray.length();i++){
                    JSONObject car= jsonArray.getJSONObject(i);
                    int student =car.getInt("student");
                    int major =car.getInt("major");
                    int course =car.getInt("course");
                    int cycle =car.getInt("cycle");
                    int grupo =car.getInt("grupo");
                    Matricula matricula= new Matricula(student,major,course,cycle,grupo);
                    matriculas.add(matricula);
                }
                model.setMatriculados(matriculas);

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
    public void cargarPerfil(int user , String pass){
        String apiUrl = "http://"+Login_controller.getInstance().host+":"+Login_controller.getInstance().puerto+"/Sys_Matricula_Server/doLogin?user="+user+"&password="+pass+"&action=perfil";
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

                JSONObject car = new JSONObject(responseStrBuilder.toString());
                String fechaN= car.getString("fechaN");
                int creditos= car.getInt("creditos");
                String nombre= car.getString("nombre");
                int cedula= car.getInt("cedula");
                String email= car.getString("email");
                int edad= car.getInt("edad");
                int telefono= car.getInt("telefono");
                JSONObject carrera= car.getJSONObject("carrera");
                int cod= carrera.getInt("codigo");
                Carrera carr= Datos_Controller.getInstance().buscarCarreraXId(cod);
                Alumno alumno= new Alumno(cedula,nombre,fechaN,edad,email,carr,telefono);
                model.setAlumno(alumno);
                Datos_Controller.getInstance().getModel().setCurrentAlumno(alumno);

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
    public void cargar(int user , String pass){
        cargarPerfil(user,pass);
        cragarGruposMatriculados(user,pass);
    }
}
