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
import lab04.Utils.httpRequester;

public class Login_controller {
    private static final Login_controller ourInstance = new Login_controller();

    public static Login_controller getInstance() {
        return ourInstance;
    }

    private Login_controller() {



    }
 public void doLogin(){
     String apiUrl = "http://192.168.50.23:30503/Sys_Matricula_Server/doLogin?user=116360595&password=admin&action=carreras";

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
             List<Carrera> carreraList= new ArrayList<>();
             JSONObject jsonObject = new JSONObject(responseStrBuilder.toString());
             JSONArray jsonArray= jsonObject.getJSONArray("myArrayList");
             for(int i=0; i< jsonArray.length();i++){
                 JSONObject car= jsonArray.getJSONObject(i);
                 int codigo= car.getInt("codigo");
                 String nombre= car.getString("nombre");
                 String titulo= car.getString("titulo");
                 Carrera carrera= new Carrera(codigo,nombre,titulo);
                 carreraList.add(carrera);
             }

             carreraList.size();
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
