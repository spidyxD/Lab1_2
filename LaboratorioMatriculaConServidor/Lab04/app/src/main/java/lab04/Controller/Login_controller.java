package lab04.Controller;

import org.apache.http.HttpRequest;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.concurrent.ExecutionException;

import lab04.Utils.httpRequester;

public class Login_controller {
    private static final Login_controller ourInstance = new Login_controller();

    public static Login_controller getInstance() {
        return ourInstance;
    }

    private Login_controller() {



    }
 public void doLogin(){
     JSONObject data = new JSONObject();
     try {
         data.put("url","http://http://192.168.50.23:30503/Sys_Matricula_Server/doLogin?user=116360595&password=admin&action=carreras:30503/Sys_Matricula_Server/doLogin?user=116360595&password=admin&action=carreras");
         data.put("tipoLlamado",2);
         httpRequester http = new httpRequester();
         try {
             Object example = http.execute(data).get();
             example.toString();
         } catch (ExecutionException e) {
             e.printStackTrace();
         } catch (InterruptedException e) {
             e.printStackTrace();
         }
     } catch (JSONException e) {
         e.printStackTrace();
     }

 }

}
