package lab04.Activity;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.Toast;

import com.example.lab04.R;

import lab04.AccesoDatos.ModeloDeDatos;
import lab04.LogicaNegocio.Alumno;
import lab04.LogicaNegocio.Profesor;
import lab04.LogicaNegocio.Carrera;

import static lab04.Activity.LoginActivity.DATOS;
import static lab04.Activity.LoginActivity.usuario;

public class AddProfesorFragment extends Fragment {

    private static final String TAG="AddProfesorFragment";


    @Override

    public View onCreateView(LayoutInflater inflater, ViewGroup container,

                             Bundle savedInstanceState) {
       final View rot= inflater.inflate(R.layout.activity_profesor, container, false);
       if (DATOS.getModo()=="Editar"){
           EditText nombre= rot.findViewById(R.id.nombreAddUpdProf);
           EditText cedula= rot.findViewById(R.id.cedulaAddUpdProf);
           EditText telefono= rot.findViewById(R.id.telefonoAddUpdProf);
           EditText email= rot.findViewById(R.id.emailAddUpdProf);

           Profesor p= DATOS.getCurrentProfesor();
           nombre.setText(p.getNombre());
           cedula.setText(Integer.toString(p.getCedula()));
           cedula.setEnabled(false);
           telefono.setText(Integer.toString(p.getTelefono()));
           email.setText(p.getEmail());
           FloatingActionButton editar = rot.findViewById(R.id.saveProf);
           editar.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   editar(rot);
               }
           });
       }else {
        FloatingActionButton guardar = rot.findViewById(R.id.saveProf);
        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                guardar(rot);
            }
        });}
        return  rot;

    }

    public  void  guardar(View root){
        EditText nombre= root.findViewById(R.id.nombreAddUpdProf);
        EditText cedula= root.findViewById(R.id.cedulaAddUpdProf);
        EditText telefono= root.findViewById(R.id.telefonoAddUpdProf);
        EditText email= root.findViewById(R.id.emailAddUpdProf);
        Profesor p= new Profesor(Integer.parseInt(cedula.getText().toString()),nombre.getText().toString(),34,Integer.parseInt(telefono.getText().toString()),email.getText().toString());
        DATOS.getProfesores().add(p);
        Toast.makeText(root.getContext(), "Profesor Agregado!!", Toast.LENGTH_SHORT).show();
    }
    public  void  editar(View root){
        EditText nombre= root.findViewById(R.id.nombreAddUpdProf);
        EditText cedula= root.findViewById(R.id.cedulaAddUpdProf);
        EditText telefono= root.findViewById(R.id.telefonoAddUpdProf);
        EditText email= root.findViewById(R.id.emailAddUpdProf);
        Profesor p= new Profesor(Integer.parseInt(cedula.getText().toString()),nombre.getText().toString(),34,Integer.parseInt(telefono.getText().toString()),email.getText().toString());
        DATOS.actualizarProfesor(Integer.parseInt(cedula.getText().toString()),p);
        Toast.makeText(root.getContext(), "Profesor Actualizado!!", Toast.LENGTH_SHORT).show();
    }

}
