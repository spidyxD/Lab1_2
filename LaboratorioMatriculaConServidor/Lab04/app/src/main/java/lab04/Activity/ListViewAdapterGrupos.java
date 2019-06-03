package lab04.Activity;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lab04.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import lab04.Controller.Datos_Controller;
import lab04.LogicaNegocio.Curso;
import lab04.LogicaNegocio.Grupo;
import lab04.LogicaNegocio.Profesor;

public class ListViewAdapterGrupos extends RecyclerView.Adapter<ListViewAdapterGrupos.GrupoHolder>{
    Context mContext;
    LayoutInflater inflater;
    private List<Grupo> grupos=null;
    private ArrayList<Grupo> arrayList;

    public ListViewAdapterGrupos(List<Grupo> als){
        this.grupos=als;
        this.arrayList= new ArrayList<Grupo>();
        this.arrayList.addAll(als);


    }
    public class GrupoHolder extends RecyclerView.ViewHolder{
        TextView curso;
        TextView nrc ;
        TextView horario;
        TextView profesor;

        public GrupoHolder(View itemView) {
            super(itemView);
            curso= itemView.findViewById(R.id.nombreCursoGrupo);
            horario= itemView.findViewById(R.id.horarioGrupo);
            nrc= itemView.findViewById(R.id.nrcGrupo);
            profesor= itemView.findViewById(R.id.profesorGrupo);
        }
    }
    @Override
    public GrupoHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_view_items_grupos, parent, false);

        return new GrupoHolder(itemView);
    }
    @Override
    public void onBindViewHolder(GrupoHolder holder, int position) {
        Curso curso= Datos_Controller.getInstance().buscarCursoXId(grupos.get(position).getCurso());
        Profesor profe= Datos_Controller.getInstance().buscarProfesorXCedula(grupos.get(position).getPorfesor());
        holder.curso.setText(curso.getNombre());
        holder.profesor.setText(profe.getNombre());
        holder.nrc.setText(Integer.toString(grupos.get(position).getNrc()));
        holder.horario.setText(grupos.get(position).getHorario());
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return grupos.size();
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
                String curso= Datos_Controller.getInstance().buscarCursoXId(wp.getCurso()).getNombre();
                if ((curso.toLowerCase(Locale.getDefault()).contains(charText))||(ced.toLowerCase(Locale.getDefault()).contains(charText))) {
                    grupos.add(wp);
                }
            }
        }
        notifyDataSetChanged();
    }}