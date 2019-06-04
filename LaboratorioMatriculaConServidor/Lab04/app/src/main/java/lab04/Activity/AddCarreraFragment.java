package lab04.Activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.example.lab04.R;

import lab04.Controller.Datos_Controller;
import lab04.LogicaNegocio.Alumno;
import lab04.LogicaNegocio.Carrera;
import lab04.LogicaNegocio.Curso;
import static lab04.Activity.LoginActivity.usuario;

public class AddCarreraFragment extends Fragment {

    private static final String TAG = "AddCarreraFragment";


    @Override

    public View onCreateView(LayoutInflater inflater, ViewGroup container,

                             Bundle savedInstanceState) {
        final View root = inflater.inflate(R.layout.fragment_carrera, container, false);
        if(Datos_Controller.getInstance().getModel().getModo() =="Editar"){
            Carrera car =Datos_Controller.getInstance().getModel().getCurrentCarrera();
            EditText nombre= root.findViewById(R.id.nombreCarrera);
            EditText codigo= root.findViewById(R.id.codigoCarrera);
            EditText titulo= root.findViewById(R.id.tituloCarrera);
            nombre.setText(car.getNombre());
            codigo.setText(Integer.toString(car.getCodigo()));
            codigo.setEnabled(false);
            titulo.setText(car.getTitulo());
            FloatingActionButton editar = root.findViewById(R.id.saveCarrera);
            editar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    editar(root);
                }
            });
        }else {
        FloatingActionButton guardar = root.findViewById(R.id.saveCarrera);
        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                guardarDatos(root);
            }
        });}
        return root;
    }

    public void guardarDatos(View root) {
        EditText nombre = root.findViewById(R.id.nombreCarrera);
        EditText codigo = root.findViewById(R.id.codigoCarrera);
        EditText tituilo = root.findViewById(R.id.tituloCarrera);
        Carrera carrera = new Carrera(Integer.parseInt(codigo.getText().toString()),nombre.getText().toString(),tituilo.getText().toString());
        if(Datos_Controller.getInstance().addCarrera(carrera)){
            Toast.makeText(root.getContext(), "Carrera Agregada!!", Toast.LENGTH_SHORT).show();
            ((Principal)getActivity()).setFragment(7);
        }else{
            Toast.makeText(root.getContext(), "Ocurrió un error!!", Toast.LENGTH_SHORT).show();
        }
    }
   public void editar(View root){
       EditText nombre= root.findViewById(R.id.nombreCarrera);
       EditText codigo= root.findViewById(R.id.codigoCarrera);
       EditText titulo= root.findViewById(R.id.tituloCarrera);
       Carrera carrera = new Carrera(Integer.parseInt(codigo.getText().toString()),nombre.getText().toString(),titulo.getText().toString());
       if(Datos_Controller.getInstance().updateCarrera(carrera)){
           Toast.makeText(root.getContext(), "Carrera Actualizada!!", Toast.LENGTH_SHORT).show();
       }else{
           Toast.makeText(root.getContext(), "Ocurrió un error!!", Toast.LENGTH_SHORT).show();
       }
    }
}