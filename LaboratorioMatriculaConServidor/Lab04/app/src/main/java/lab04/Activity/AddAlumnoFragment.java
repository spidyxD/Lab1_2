package lab04.Activity;

import android.annotation.TargetApi;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Message;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.os.Bundle;
import com.example.lab04.R;
import android.content.Context;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import lab04.AccesoDatos.ModeloDeDatos;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import lab04.LogicaNegocio.Alumno;
import lab04.LogicaNegocio.Carrera;
import lab04.LogicaNegocio.Usuario;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static android.Manifest.permission.READ_CONTACTS;
import static lab04.Activity.LoginActivity.DATOS;
import static lab04.Activity.LoginActivity.usuario;


public class AddAlumnoFragment extends Fragment {

    private static final String TAG="tipoCambio";


    @Override

    public View onCreateView(LayoutInflater inflater, ViewGroup container,

                             Bundle savedInstanceState) {
        final View root =inflater.inflate(R.layout.activity_alumno, container, false);
        if(DATOS.getModo()=="Editar"){
            Alumno alumno= DATOS.getCurrentAlumno();
            EditText nombre= root.findViewById(R.id.nombreAddUpdAlum);
            EditText cedula= root.findViewById(R.id.cedulaAddUpdAlum);
            EditText telefono= root.findViewById(R.id.telefonoAddUpdAlum);
            EditText email= root.findViewById(R.id.emailAddUpdAlum);
            EditText fecha= root.findViewById(R.id.fechaAddUpdAlum);
            EditText carrera= root.findViewById(R.id.carreraAddUpdAlum);
            nombre.setText(alumno.getNombre());
            cedula.setText(Integer.toString(alumno.getCedula()));
            cedula.setEnabled(false);
            telefono.setText(Integer.toString(alumno.getTelefono()));
            email.setText(alumno.getEmail());
            fecha.setText(alumno.getFecha_nacimiento());
            carrera.setText(alumno.getCarrera().getNombre());
            FloatingActionButton editar = root.findViewById(R.id.saveAlumno);
            editar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    editar(root);
                }
            });
        }else {
        FloatingActionButton guardar = root.findViewById(R.id.saveAlumno);
        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                guardarDatos(root);
            }
        });}
        return root;
    }
    public  void  guardarDatos(View root){
        EditText nombre= root.findViewById(R.id.nombreAddUpdAlum);
        EditText cedula= root.findViewById(R.id.cedulaAddUpdAlum);
        EditText telefono= root.findViewById(R.id.telefonoAddUpdAlum);
        EditText email= root.findViewById(R.id.emailAddUpdAlum);
        EditText fecha= root.findViewById(R.id.fechaAddUpdAlum);
        EditText carrera= root.findViewById(R.id.carreraAddUpdAlum);
        Carrera carrera1= DATOS.getCarreraXNombre(carrera.getText().toString());
        Alumno al= new Alumno(Integer.parseInt(cedula.getText().toString()),nombre.getText().toString(),fecha.getText().toString(),21,email.getText().toString(),carrera1,Integer.parseInt(telefono.getText().toString()));
        DATOS.getAlumnos().add(al);
        Toast.makeText(root.getContext(), "Alumno Agregado!!", Toast.LENGTH_SHORT).show();
        getActivity().finish();
    }
    public void editar(View root){
        Alumno alumno= DATOS.getAlumnoXCed(usuario.getUsername());
        EditText nombre= root.findViewById(R.id.nombreAddUpdAlum);
        EditText cedula= root.findViewById(R.id.cedulaAddUpdAlum);
        EditText telefono= root.findViewById(R.id.telefonoAddUpdAlum);
        EditText email= root.findViewById(R.id.emailAddUpdAlum);
        EditText fecha= root.findViewById(R.id.fechaAddUpdAlum);
        EditText carrera= root.findViewById(R.id.carreraAddUpdAlum);
        Carrera carrera1= DATOS.getCarreraXNombre(carrera.getText().toString());
        Alumno al= new Alumno(Integer.parseInt(cedula.getText().toString()),nombre.getText().toString(),fecha.getText().toString(),21,email.getText().toString(),carrera1,Integer.parseInt(telefono.getText().toString()));
        DATOS.actualizarEstudiante(Integer.parseInt(cedula.getText().toString()),al);
        Toast.makeText(root.getContext(), "Alumno Actualizado!!", Toast.LENGTH_SHORT).show();
    }

}