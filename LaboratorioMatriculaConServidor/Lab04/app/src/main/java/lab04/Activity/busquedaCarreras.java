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
import android.widget.Toast;

import com.example.lab04.R;

import java.util.ArrayList;
import java.util.List;

import lab04.Controller.Datos_Controller;
import lab04.LogicaNegocio.Alumno;
import lab04.LogicaNegocio.Carrera;
import lab04.LogicaNegocio.Profesor;


public class busquedaCarreras extends Fragment implements SearchView.OnQueryTextListener {

    // Declarar Variables
    ListView list;
    ListViewAdapterCarreras adapter;
    SearchView editsearch;
    List<Carrera> carreras;
    ArrayList<Carrera> arraylist = new ArrayList<Carrera>();
    SwipeController swipeController = new SwipeController(new SwipeController.SwipeControllerActions(){
        @Override
        public void onRightClicked(int position){
            Carrera p= adapter.getCarreraAt(position);
            if(Datos_Controller.getInstance().deleteCarrera(p.getCodigo())){
               adapter.setCarreras(Datos_Controller.getInstance().getModel().getCarreras());
                Toast.makeText(getContext(), "Carrera borrada!!", Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(getContext(), "Ocurrió un error!!", Toast.LENGTH_SHORT).show();
            }
        }
        @Override
        public void onLeftClicked(int position){
            Carrera p= adapter.getCarreraAt(position);
            Datos_Controller.getInstance().getModel().setModo("Editar");
            Datos_Controller.getInstance().getModel().setCurrentCarrera(p);
            ((Principal)getContext()).setFragment(11);
        }
    });




    @Override
    public View onCreateView(LayoutInflater inflater , ViewGroup container , Bundle savedInstanceState) {
        final View root= inflater.inflate(R.layout.busqueda_generic,container,false);

        super.onCreate(savedInstanceState);
        setCarrerasAdapter();
        setupRecyclerView(root);
        editsearch = root.findViewById(R.id.busqueda);
        editsearch.setOnQueryTextListener(this);
        RecyclerView recyclerView = root.findViewById(R.id.listaDatos);
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(swipeController);
        itemTouchHelper.attachToRecyclerView(recyclerView);
        final FloatingActionButton add= root.findViewById(R.id.addActionButton);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Datos_Controller.getInstance().getModel().setModo("Agregar");
                ((Principal)getContext()).setFragment(11);
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

        return root;
    }

    private void setCarrerasAdapter() {
        List<Carrera> carreras = new ArrayList<>();
        carreras=Datos_Controller.getInstance().getModel().getCarreras();
        adapter = new ListViewAdapterCarreras(carreras,getContext());
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
    }}
