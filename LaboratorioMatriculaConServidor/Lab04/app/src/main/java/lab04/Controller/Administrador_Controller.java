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

import lab04.LogicaNegocio.Administrador;
import lab04.LogicaNegocio.Alumno;
import lab04.LogicaNegocio.Carrera;
import lab04.LogicaNegocio.Curso;
import lab04.LogicaNegocio.Grupo;
import lab04.LogicaNegocio.Profesor;
import lab04.LogicaNegocio.Usuario;
import lab04.Model.AdministradorModel;

public class Administrador_Controller {
    private AdministradorModel model = new AdministradorModel();
    private static final Administrador_Controller uniqueInstance = new Administrador_Controller();

    public Administrador_Controller(AdministradorModel model) {
        this.model = model;
    }

    public Administrador_Controller() {
        model= new AdministradorModel();
    }

    public AdministradorModel getModel() {
        return model;
    }

    public void setModel(AdministradorModel model) {
        this.model = model;
    }
    public static Administrador_Controller instance(){
       return  uniqueInstance;
    }

    public void cargarPerfil(int user , String pass){
        String apiUrl = "http://"+Login_controller.getInstance().host+":"+Login_controller.getInstance().puerto+"/Sys_Matricula_Server/doLogin?user="+user+"&password="+pass+"&action=perfilAdmin";
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
                int id= jsonObject.getInt("cedula");
                String nombre = jsonObject.getString("nombre");
                model.setAdministrador(new Administrador(id,nombre));

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

    public void cargar(int user , String pass) {
        cargarPerfil(user,pass);
    }
}
