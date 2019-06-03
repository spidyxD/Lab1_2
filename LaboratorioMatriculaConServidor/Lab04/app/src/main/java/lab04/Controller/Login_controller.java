package lab04.Controller;

import org.apache.http.HttpRequest;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import lab04.Activity.ListViewAdapterAlumnos;
import lab04.LogicaNegocio.Carrera;
import lab04.LogicaNegocio.Profesor;
import lab04.LogicaNegocio.Usuario;
import lab04.Model.LoginModel;
import lab04.Utils.httpRequester;

public class Login_controller {
    String host="192.168.1.7";
    String puerto="8080";
    private LoginModel model = new LoginModel();
    private static final Login_controller ourInstance = new Login_controller();

    public static Login_controller getInstance() {
        return ourInstance;
    }

    private Login_controller() {

    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getPuerto() {
        return puerto;
    }

    public void setPuerto(String puerto) {
        this.puerto = puerto;
    }

    public LoginModel getModel() {
        return model;
    }

    public void setModel(LoginModel model) {
        this.model = model;
    }

    public boolean doLogin(int user , String pass){
     boolean res= false;
     Datos_Controller.getInstance().cargarAplicacion();
     String apiUrl = "http://"+host+":"+puerto+"/Sys_Matricula_Server/doLogin?user="+user+"&password="+pass+"&action=";

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
             int username= jsonObject.getInt("username");
             String clave=jsonObject.getString("clave");
             String rol=jsonObject.getString("rol");
             Usuario usuario =  new Usuario(username,clave,rol);
             model.setUser(usuario);
             switch (model.getUser().getRol()){
                 case "Administrador":
                     Administrador_Controller.instance().cargar(model.getUser().getUsername(),model.getUser().getClave());
                     res= true;
                     break;
                 case "Alumno":
                     Alumno_Controller.instance().cargar(model.getUser().getUsername(),model.getUser().getClave());
                     res= true;
                     break;
                 case "Profesor":
                     Profesor_Controller.getInstance().cargar(model.getUser().getUsername(),model.getUser().getClave());
                     res= true;
                     break;
             }



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
     return true;
 }

}
