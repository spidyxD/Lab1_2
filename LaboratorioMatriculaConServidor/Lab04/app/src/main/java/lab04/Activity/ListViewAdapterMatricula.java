package lab04.Activity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.lab04.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import lab04.Controller.Datos_Controller;
import lab04.LogicaNegocio.Curso;
import lab04.LogicaNegocio.Grupo;
import lab04.LogicaNegocio.Profesor;

public class ListViewAdapterMatricula extends BaseAdapter {
    Context mContext;
    LayoutInflater inflater;
    private List<Grupo> grupos=null;
    private ArrayList<Grupo> arrayList;

    public ListViewAdapterMatricula(Context context, List<Grupo> als){
        mContext=context;
        this.grupos=als;
        inflater=LayoutInflater.from(mContext);
        this.arrayList= new ArrayList<Grupo>();
        this.arrayList.addAll(als);


    }
    public class ViewHolder {
        TextView curso;
        TextView nrc ;
        TextView horario;
        TextView profesor;
    }

    @Override
    public int getCount() {
        return grupos.size();
    }

    @Override
    public Grupo getItem(int position) {
        return grupos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public View getView(final int position, View view, ViewGroup parent) {
        final ListViewAdapterMatricula.ViewHolder holder;
        View resultado;
        if (view == null) {
            holder = new ListViewAdapterMatricula.ViewHolder();
            view = inflater.inflate(R.layout.list_view_items_cursos_a_matricular, null);
            final View root= view;
            // Buscar los datos y presentarlos en el listview_item.xml
            holder.curso= root.findViewById(R.id.nombreCursoGrupo);
            holder.horario= root.findViewById(R.id.horarioGrupo);
            holder.nrc= root.findViewById(R.id.nrcGrupo);
            holder.profesor= root.findViewById(R.id.profesorGrupo);
            view.setTag(holder);
            resultado=root;
        } else {
            holder = (ListViewAdapterMatricula.ViewHolder) view.getTag();
            resultado=view;
        }
        // Establecer resultados en el TextView
        Curso curso= Datos_Controller.getInstance().buscarCursoXId(grupos.get(position).getCurso());
        Profesor profe= Datos_Controller.getInstance().buscarProfesorXCedula(grupos.get(position).getPorfesor());
        holder.curso.setText(curso.getNombre());
        holder.profesor.setText(profe.getNombre());
        holder.nrc.setText(Integer.toString(grupos.get(position).getNrc()));
        holder.horario.setText(grupos.get(position).getHorario());

        return resultado;
    }

    // Función filtrar
    public void filter(String charText) {
        charText = charText.toLowerCase(Locale.getDefault());
        grupos.clear();
        if (charText.length() == 0) {
            grupos.addAll(arrayList);
        } else {
            for (Grupo wp : arrayList) {
                String ced= Integer.toString(wp.getNrc());
                String curso = Datos_Controller.getInstance().buscarCursoXId(wp.getCurso()).getNombre();
                if ((curso.toLowerCase(Locale.getDefault()).contains(charText))||(ced.toLowerCase(Locale.getDefault()).contains(charText))) {
                    grupos.add(wp);
                }
            }
        }
        notifyDataSetChanged();
    }}
