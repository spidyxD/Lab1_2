package lab04.Activity;

import android.graphics.Canvas;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
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

import lab04.Controller.Datos_Controller;
import lab04.LogicaNegocio.Profesor;

public class busquedaProfesores extends Fragment implements SearchView.OnQueryTextListener {

    // Declarar Variables
    ListView list;
    ListViewAdapterPofesores adapter;
    SearchView editsearch;
    List<Profesor> profesores;
    ArrayList<Profesor> arraylist = new ArrayList<Profesor>();
    SwipeController swipeController = new SwipeController(new SwipeController.SwipeControllerActions(){
        @Override
        public void onRightClicked(int position){
            Profesor p= adapter.getProfesorAt(position);
            Datos_Controller.getInstance().getModel().getProfesores().remove(p);
            adapter.delete(p);
            adapter.notifyItemRemoved(position);
            adapter.notifyItemRangeChanged(position,adapter.getItemCount());
        }
        @Override
        public void onLeftClicked(int position){
            Profesor p= adapter.getProfesorAt(position);
            Datos_Controller.getInstance().getModel().setModo("Editar");
            Datos_Controller.getInstance().getModel().setCurrentProfesor(p);
            ((Principal)getContext()).setFragment(8);
        }
    });



   // SwipeController swipeController = new SwipeController();

    //ItemTouchHelper itemTouchHelper = new ItemTouchHelper(swipeController);

    public busquedaProfesores getBus(){
        return this;
    }

    @Override
    public View onCreateView(LayoutInflater inflater , ViewGroup container , Bundle savedInstanceState) {
        View root= inflater.inflate(R.layout.busqueda_generic,container,false);

        super.onCreate(savedInstanceState);
        setProfesoresAdapter();
        setupRecyclerView(root);
        editsearch = root.findViewById(R.id.busqueda);
        editsearch.setOnQueryTextListener(this);
        editsearch.setOnQueryTextListener(this);
        RecyclerView recyclerView = root.findViewById(R.id.listaDatos);
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(swipeController);
        itemTouchHelper.attachToRecyclerView(recyclerView);
        final FloatingActionButton  add= root.findViewById(R.id.addActionButton);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Datos_Controller.getInstance().getModel().setModo("Agregar");
                ((Principal)getContext()).setFragment(8);
            }
        });
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if(dy>0 && add.getVisibility()==View.VISIBLE){
                    add.hide();
                }else if(dy<0 && add.getVisibility()!=View.VISIBLE){
                    add.show();
                }
            }
        });

        return  root;
    }
    private void setProfesoresAdapter() {

        List<Profesor> profesores = new ArrayList<>();
        profesores=Datos_Controller.getInstance().getModel().getProfesores();
        adapter = new ListViewAdapterPofesores(profesores);
    }
    private void setupRecyclerView(View root) {
        RecyclerView recyclerView = root.findViewById(R.id.listaDatos);
        recyclerView.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void onDraw(@NonNull Canvas c, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
                swipeController.onDraw(c);
            }
        });
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
