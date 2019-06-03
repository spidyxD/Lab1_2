package lab04.Activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SearchView;

import com.example.lab04.R;

import java.util.ArrayList;
import java.util.List;

import lab04.Controller.Administrador_Controller;
import lab04.Controller.Alumno_Controller;
import lab04.Controller.Datos_Controller;
import lab04.Controller.Login_controller;
import lab04.Controller.Profesor_Controller;
import lab04.LogicaNegocio.Alumno;
import lab04.LogicaNegocio.Grupo;
import lab04.LogicaNegocio.Profesor;
import lab04.LogicaNegocio.Usuario;

import static lab04.Activity.LoginActivity.usuario;

public class busquedaGrupos extends Fragment implements SearchView.OnQueryTextListener {

    // Declarar Variables
    ListView list;
    ListViewAdapterGrupos adapter;
    SearchView editsearch;
    List<Grupo> grupos;
    ArrayList<Grupo> arraylist = new ArrayList<Grupo>();
    SwipeController swipeController = new SwipeController(new SwipeController.SwipeControllerActions(){
        @Override
        public void onRightClicked(int position){
            //Profesor p= adapter.getGAt(position);
            //DATOS.getProfesores().remove(p);
          //  adapter.delete(p);
            adapter.notifyItemRemoved(position);
            adapter.notifyItemRangeChanged(position,adapter.getItemCount());
        }
    });


    @Override
    public View onCreateView(LayoutInflater inflater , ViewGroup container , Bundle savedInstanceState) {
        View root= inflater.inflate(R.layout.busqueda_generic,container,false);

        super.onCreate(savedInstanceState);
        setGruposAdapter();
        setupRecyclerView(root);

        editsearch = root.findViewById(R.id.busqueda);
        editsearch.setOnQueryTextListener(this);
        editsearch.setOnQueryTextListener(this);
        RecyclerView recyclerView = root.findViewById(R.id.listaDatos);
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(swipeController);
        itemTouchHelper.attachToRecyclerView(recyclerView);
        return  root;
    }
    private void setGruposAdapter() {
        List<Grupo> grupos = new ArrayList<>();
        Usuario user = Login_controller.getInstance().getModel().getUser();
        if(user.getRol().equals("Alumno")) {
            Alumno al = Datos_Controller.getInstance().buscarAlumnoXCedula(user.getUsername());
            grupos = Alumno_Controller.instance().getModel().getGrruposMatriculados();
        }
        if(user.getRol().equals("Profesor")){
            Profesor profesor= Datos_Controller.getInstance().buscarProfesorXCedula(user.getUsername());
             grupos= Profesor_Controller.getInstance().getModel().getGruposImpartidos();
        }
        adapter = new ListViewAdapterGrupos(grupos);
    }
    private void setupRecyclerView(View root) {
        RecyclerView recyclerView = root.findViewById(R.id.listaDatos);

        recyclerView.setLayoutManager(new LinearLayoutManager(this.getActivity(), LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(adapter);
    }
    @Override
    public boolean onQueryTextSubmit(String query) {

        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        String text = newText;
        adapter.filter(text);
        return false;
    }

}