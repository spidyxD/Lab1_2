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

public class AddCursoFragment extends Fragment {

    private static final String TAG="AddCursoFragment";


    @Override

    public View onCreateView(LayoutInflater inflater, ViewGroup container,

                             Bundle savedInstanceState) {
        final View root =inflater.inflate(R.layout.fragment_curso, container, false);
        if(Datos_Controller.getInstance().getModel().getModo()=="Editar"){
            Curso curso= Datos_Controller.getInstance().getModel().getCurrentCurso();
            EditText nombre= root.findViewById(R.id.cursoNombre);
            EditText codigo= root.findViewById(R.id.cursoCodigo);
            EditText creditos= root.findViewById(R.id.cursoCreditos);
            EditText horasSemanales= root.findViewById(R.id.cursoHoras);
            nombre.setText(curso.getNombre());
            codigo.setText(Integer.toString(curso.getCodigo()));
            codigo.setEnabled(false);
            creditos.setText(Integer.toString(curso.getCreditos()));
            horasSemanales.setText(Float.toString(curso.getHoras_semanales()));
            FloatingActionButton editar = root.findViewById(R.id.saveCurso);
            editar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    editar(root);
                }
            });
        }else {
            FloatingActionButton guardar = root.findViewById(R.id.saveCurso);
            guardar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    guardarDatos(root);
                }
            });}
        return root;
    }
    public  void  guardarDatos(View root){
        EditText nombre= root.findViewById(R.id.cursoNombre);
        EditText creditos= root.findViewById(R.id.cursoCreditos);
        EditText horas= root.findViewById(R.id.cursoHoras);
        EditText codigo= root.findViewById(R.id.cursoCodigo);
        Curso curso=new Curso(Integer.parseInt(codigo.getText().toString()),nombre.getText().toString(),Integer.parseInt(creditos.getText().toString()),Float.parseFloat(horas.getText().toString()));
        if(Datos_Controller.getInstance().addCurso(curso)){
        Toast.makeText(root.getContext(), "Curso Agregado!!", Toast.LENGTH_SHORT).show();
            ((Principal)getActivity()).setFragment(6);
        }else{
            Toast.makeText(root.getContext(), "Ocurrió un error!!", Toast.LENGTH_SHORT).show();
        }
    }
    public void editar(View root){
        EditText nombre= root.findViewById(R.id.cursoNombre);
        EditText codigo= root.findViewById(R.id.cursoCodigo);
        EditText creditos= root.findViewById(R.id.cursoCreditos);
        EditText horasSemanales= root.findViewById(R.id.cursoHoras);
        Curso al= new Curso(Integer.parseInt(codigo.getText().toString()),nombre.getText().toString(),Integer.parseInt(creditos.getText().toString()),Float.parseFloat(horasSemanales.getText().toString()));
        if(Datos_Controller.getInstance().updateCurso(al)){
            Toast.makeText(root.getContext(), "Curso Actualizado!!", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(root.getContext(), "Ocurrio un error!!", Toast.LENGTH_SHORT).show();
        }
        }
    }