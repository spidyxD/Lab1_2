package lab04.Activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;

import com.example.lab04.R;

import java.util.ArrayList;
import java.util.List;

import lab04.LogicaNegocio.Alumno;
import lab04.LogicaNegocio.Grupo;
import lab04.LogicaNegocio.Profesor;

import static lab04.Activity.LoginActivity.DATOS;
import static lab04.Activity.LoginActivity.usuario;

public class busquedaMatricula extends Fragment implements SearchView.OnQueryTextListener {

    // Declarar Variables
    ListView list;
    ListViewAdapterMatricula adapter;
    SearchView editsearch;
    List<Grupo> grupos;
    ArrayList<Grupo> arraylist = new ArrayList<Grupo>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.busqueda_generic_matricula, container, false);

        super.onCreate(savedInstanceState);
        // Generar datos de muestra
        grupos= DATOS.getGrupos();
        // Buscar los datos y presentarlos en el list_view_item.xml
        list = root.findViewById(R.id.listaDatosGrupos);

        for (int i = 0; i < grupos.size(); i++) {
            // Vincula todas las cadenas a una matriz
            arraylist.add(grupos.get(i));
        }

        // Pasar los resultados a la clase ListViewAdapter
        adapter = new ListViewAdapterMatricula(getContext(), arraylist);

        // Vincula el adaptador a ListView
        list.setAdapter(adapter);

        // Buscar los datos y presentarlos en el listview_main.xml
        editsearch = root.findViewById(R.id.busquedaGrupos);
        if(DATOS.getModo()=="matricular"){
            TextView matricula= root.findViewById(R.id.alumnoAmatricular);
            matricula.setVisibility(View.VISIBLE);
            matricula.setText("Estudiante :"+DATOS.getCurrentAlumno().getNombre());
        }
        editsearch.setOnQueryTextListener(this);
        editsearch.setOnQueryTextListener(this);
        return root;
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