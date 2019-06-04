package lab04.Activity;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import com.example.lab04.R;

import android.support.design.widget.FloatingActionButton;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import lab04.Controller.Datos_Controller;
import lab04.Controller.Login_controller;
import lab04.LogicaNegocio.Alumno;
import lab04.LogicaNegocio.Carrera;

import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static lab04.Activity.LoginActivity.usuario;


public class AddAlumnoFragment extends Fragment {

    private static final String TAG="tipoCambio";


    @Override

    public View onCreateView(LayoutInflater inflater, ViewGroup container,

                             Bundle savedInstanceState) {
        final View root =inflater.inflate(R.layout.activity_alumno, container, false);
        final Spinner carreras= root.findViewById(R.id.carrerasAlumno);
        ArrayList<String> nombress= (ArrayList<String>) Datos_Controller.getInstance().nombreCarreras();
        String[] nom={};
        Collections.addAll(nombress,nom);
        carreras.setAdapter(new ArrayAdapter<String>(getContext(),R.layout.support_simple_spinner_dropdown_item,nombress));
        if(Datos_Controller.getInstance().getModel().getModo()=="Editar"){
            Alumno alumno= Datos_Controller.getInstance().getModel().getCurrentAlumno();
            EditText nombre= root.findViewById(R.id.nombreAddUpdAlum);
            EditText cedula= root.findViewById(R.id.cedulaAddUpdAlum);
            EditText telefono= root.findViewById(R.id.telefonoAddUpdAlum);
            EditText email= root.findViewById(R.id.emailAddUpdAlum);
            EditText fecha= root.findViewById(R.id.fechaAddUpdAlum);
            EditText pass=root.findViewById(R.id.passwordAlumno);
            pass.setVisibility(View.INVISIBLE);
            nombre.setText(alumno.getNombre());
            cedula.setText(Integer.toString(alumno.getCedula()));
            if(Login_controller.getInstance().getModel().getUser().getRol()=="Administrador"){
                cedula.setEnabled(true);
            }else{
                cedula.setEnabled(false);
            }
            telefono.setText(Integer.toString(alumno.getTelefono()));
            email.setText(alumno.getEmail());
            fecha.setText(alumno.getFecha_nacimiento());
            FloatingActionButton editar = root.findViewById(R.id.saveAlumno);
            carreras.setSelection(Datos_Controller.getInstance().posCarreras(alumno.getCarrera().getNombre()));
            editar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    editar(root);
                }
            });
        }else {
            EditText pass=root.findViewById(R.id.passwordAlumno);
            pass.setVisibility(View.VISIBLE);
        FloatingActionButton guardar = root.findViewById(R.id.saveAlumno);
        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                guardarDatos(root,carreras);
            }
        });}
        return root;
    }
    public  void  guardarDatos(View root, Spinner carreras){
        EditText nombre= root.findViewById(R.id.nombreAddUpdAlum);
        EditText cedula= root.findViewById(R.id.cedulaAddUpdAlum);
        EditText telefono= root.findViewById(R.id.telefonoAddUpdAlum);
        EditText email= root.findViewById(R.id.emailAddUpdAlum);
        EditText fecha= root.findViewById(R.id.fechaAddUpdAlum);
        //EditText carrera= root.findViewById(R.id.carreraAddUpdAlum);
        EditText pass=root.findViewById(R.id.passwordAlumno);
        String carrera1= (String)carreras.getSelectedItem();
        Carrera car= Datos_Controller.getInstance().buscarCarreraXNombre(carrera1);
        Alumno al= new Alumno(Integer.parseInt(cedula.getText().toString()),nombre.getText().toString(),fecha.getText().toString(),21,email.getText().toString(),car,Integer.parseInt(telefono.getText().toString()));

        if(Datos_Controller.getInstance().addAlumno(al,pass.getText().toString())){
        Toast.makeText(root.getContext(), "Alumno Agregado!!", Toast.LENGTH_SHORT).show();
            ((Principal)getActivity()).setFragment(5);
        }else{
            Toast.makeText(root.getContext(), "Ocurrió un error!!", Toast.LENGTH_SHORT).show();
        }
    }
    public void editar(View root){
        Alumno alumno= Datos_Controller.getInstance().buscarAlumnoXCedula(usuario.getUsername());
        EditText nombre= root.findViewById(R.id.nombreAddUpdAlum);
        EditText cedula= root.findViewById(R.id.cedulaAddUpdAlum);
        EditText telefono= root.findViewById(R.id.telefonoAddUpdAlum);
        EditText email= root.findViewById(R.id.emailAddUpdAlum);
        EditText fecha= root.findViewById(R.id.fechaAddUpdAlum);
       // EditText carrera= root.findViewById(R.id.carreraAddUpdAlum);
       // Carrera carrera1= Datos_Controller.getInstance().buscarCarreraXNombre(carrera.getText().toString());
       // Alumno al= new Alumno(Integer.parseInt(cedula.getText().toString()),nombre.getText().toString(),fecha.getText().toString(),21,email.getText().toString(),carrera1,Integer.parseInt(telefono.getText().toString()));

        //Datos_Controller.getInstance().actualizarEstudiante(Integer.parseInt(cedula.getText().toString()),al);
        Toast.makeText(root.getContext(), "Alumno Actualizado!!", Toast.LENGTH_SHORT).show();
    }

    /*@Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }*/
}