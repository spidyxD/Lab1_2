package lab04.Activity;

import android.content.Context;
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

import lab04.LogicaNegocio.Alumno;
import lab04.LogicaNegocio.Profesor;


public class ListViewAdapterPofesores extends RecyclerView.Adapter<ListViewAdapterPofesores.ProfesorHolder>{
    Context mContext;
    LayoutInflater inflater;
    private List<Profesor> profesores=null;
    private ArrayList<Profesor> arrayList;

    public List<Profesor> getProfesores(){
        return profesores;
    }

    public class ProfesorHolder extends RecyclerView.ViewHolder {
        TextView nombre;

        public ProfesorHolder(View view){
            super(view);
            nombre = view.findViewById(R.id.nombreEditProf);
        }
    }
    public ListViewAdapterPofesores(List<Profesor> als){
        this.profesores=als;
        this.arrayList= new ArrayList<Profesor>();
        this.arrayList.addAll(als);


    }
    @Override
    public ProfesorHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_view_items_profesores, parent, false);

        return new ProfesorHolder(itemView);
    }
    @Override
    public void onBindViewHolder(ProfesorHolder holder, int position) {
        Profesor pr  = profesores.get(position);
        String pro= pr.getNombre() +" "+ pr.getCedula();
        holder.nombre.setText(pro);
    }
    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return profesores.size();
    }

    public Profesor getProfesorAt(int position){
       return  profesores.get(position);
    }
    public void delete(Profesor al){
        profesores.remove(al);
        notifyDataSetChanged();
    }
    public void add(Profesor al){
        profesores.add(al);
        notifyDataSetChanged();
    }
    // Función filtrar
    public void filter(String charText) {
        charText = charText.toLowerCase(Locale.getDefault());
        profesores.clear();
        if (charText.length() == 0) {
            profesores.addAll(arrayList);
        } else {
            for (Profesor wp : arrayList) {
                String ced= Integer.toString(wp.getCedula());
                if ((wp.getNombre().toLowerCase(Locale.getDefault()).contains(charText))||(ced.toLowerCase(Locale.getDefault()).contains(charText))) {
                    profesores.add(wp);
                }
            }
        }
        notifyDataSetChanged();
    }}