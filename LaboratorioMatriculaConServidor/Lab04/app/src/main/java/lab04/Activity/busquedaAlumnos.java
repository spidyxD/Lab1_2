package lab04.Activity;

import android.graphics.Canvas;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import lab04.LogicaNegocio.Alumno;
import lab04.LogicaNegocio.Profesor;

import com.example.lab04.R;
import static lab04.Activity.LoginActivity.DATOS;

import java.util.ArrayList;
import java.util.List;

public class busquedaAlumnos extends Fragment implements SearchView.OnQueryTextListener {

    // Declarar Variables
    ListView list;
    ListViewAdapterAlumnos adapter;
    SearchView editsearch;
    List<Alumno> alumnos;
    ArrayList<Alumno> arraylist = new ArrayList<Alumno>();
    SwipeController swipeController = new SwipeController(new SwipeController.SwipeControllerActions(){
        @Override
        public void onRightClicked(int position){
            Alumno p= adapter.getAlumnoAt(position);
            DATOS.getAlumnos().remove(p);
            adapter.delete(p);
            adapter.notifyItemRemoved(position);
            adapter.notifyItemRangeChanged(position,adapter.getItemCount());
        }
        @Override
        public void onLeftClicked(int position){
            Alumno p= adapter.getAlumnoAt(position);
            DATOS.setModo("Editar");
            DATOS.setCurrentAlumno(p);
            ((Principal)getContext()).setFragment(9);
        }
    });




    @Override
    public View onCreateView(LayoutInflater inflater , ViewGroup container , Bundle savedInstanceState) {
        final View root= inflater.inflate(R.layout.busqueda_generic,container,false);

        super.onCreate(savedInstanceState);
        setAlumnosAdapter();
        setupRecyclerView(root);
        editsearch = root.findViewById(R.id.busqueda);
        editsearch.setOnQueryTextListener(this);
        RecyclerView recyclerView = root.findViewById(R.id.listaDatos);
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(swipeController);
        itemTouchHelper.attachToRecyclerView(recyclerView);
        final FloatingActionButton  add= root.findViewById(R.id.addActionButton);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DATOS.setModo("Agregar");
                ((Principal)getContext()).setFragment(9);
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

    private void setAlumnosAdapter() {
        List<Alumno> alumnos = new ArrayList<>();
        alumnos=DATOS.getAlumnos();
        adapter = new ListViewAdapterAlumnos(alumnos,getContext());
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
