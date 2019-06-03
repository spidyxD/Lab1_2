package lab04.Activity;

import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.example.lab04.R;

import lab04.Controller.Datos_Controller;
import lab04.LogicaNegocio.Profesor;

public class AddProfesorFragment extends Fragment {

    private static final String TAG="AddProfesorFragment";


    @Override

    public View onCreateView(LayoutInflater inflater, ViewGroup container,

                             Bundle savedInstanceState) {
       final View rot= inflater.inflate(R.layout.activity_profesor, container, false);
       if (Datos_Controller.getInstance().getModel().getModo()=="Editar"){
           EditText nombre= rot.findViewById(R.id.nombreAddUpdProf);
           EditText cedula= rot.findViewById(R.id.cedulaAddUpdProf);
           EditText telefono= rot.findViewById(R.id.telefonoAddUpdProf);
           EditText email= rot.findViewById(R.id.emailAddUpdProf);

           Profesor p= Datos_Controller.getInstance().getModel().getCurrentProfesor();
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
        Datos_Controller.getInstance().getModel().getProfesores().add(p);
        Toast.makeText(root.getContext(), "Profesor Agregado!!", Toast.LENGTH_SHORT).show();
    }
    public  void  editar(View root){
        EditText nombre= root.findViewById(R.id.nombreAddUpdProf);
        EditText cedula= root.findViewById(R.id.cedulaAddUpdProf);
        EditText telefono= root.findViewById(R.id.telefonoAddUpdProf);
        EditText email= root.findViewById(R.id.emailAddUpdProf);
        Profesor p= new Profesor(Integer.parseInt(cedula.getText().toString()),nombre.getText().toString(),34,Integer.parseInt(telefono.getText().toString()),email.getText().toString());
        Datos_Controller.getInstance().actualizarProfesor(Integer.parseInt(cedula.getText().toString()),p);
        Toast.makeText(root.getContext(), "Profesor Actualizado!!", Toast.LENGTH_SHORT).show();
    }

}
