package lab04.Controller;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import lab04.LogicaNegocio.Alumno;
import lab04.LogicaNegocio.Carrera;
import lab04.LogicaNegocio.Grupo;
import lab04.LogicaNegocio.Profesor;
import lab04.Model.ProfesorModel;

public class Profesor_Controller {
    private ProfesorModel model;
    private static final Profesor_Controller ourInstance = new Profesor_Controller();

    public static Profesor_Controller getInstance() {
        return ourInstance;
    }

    public ProfesorModel getModel() {
        return model;
    }

    public void setModel(ProfesorModel model) {
        this.model = model;
    }

    public Profesor_Controller(){
        model= new ProfesorModel();
    }
    public void cargar(int user , String pass){
        cargarPerfil(user, pass);
        cargarGruposImpartidos(user,pass);
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
                int cedula= car.getInt("cedula");
                String nombre= car.getString("nombre");
                String email= car.getString("email");
                int edad= car.getInt("edad");
                int telefono= car.getInt("telefono");
                Profesor profesor= new Profesor(cedula,nombre,edad,telefono,email);
                model.setProfesor(profesor);
                Datos_Controller.getInstance().getModel().setCurrentProfesor(profesor);

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
    public void cargarGruposImpartidos(int user , String pass){
        String apiUrl = "http://"+Login_controller.getInstance().host+":"+Login_controller.getInstance().puerto+"/Sys_Matricula_Server/doLogin?user="+user+"&password="+pass+"&action=cursosProf";
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
                List<Grupo> grupos= new ArrayList<>();
                JSONObject jsonObject = new JSONObject(responseStrBuilder.toString());
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
                model.setGruposImpartidos(grupos);

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
}
