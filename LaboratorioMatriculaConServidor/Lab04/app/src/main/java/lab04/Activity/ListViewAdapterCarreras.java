package lab04.Activity;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.lab04.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import lab04.LogicaNegocio.Alumno;
import lab04.LogicaNegocio.Carrera;
import lab04.LogicaNegocio.Profesor;

public class ListViewAdapterCarreras extends RecyclerView.Adapter<ListViewAdapterCarreras.CarreraHolder> {
    Context mContext;
    LayoutInflater inflater;
    private List<Carrera> carreras=null;
    private ArrayList<Carrera> arrayList;

    public class CarreraHolder extends RecyclerView.ViewHolder {
        TextView nombre;
        TextView titulo;

        public CarreraHolder(View view){
            super(view);
            nombre = view.findViewById(R.id.nombreEditCarrera);
            titulo = view.findViewById(R.id.tituloEditCarrera);
        }
    }
    public ListViewAdapterCarreras(List<Carrera> crs, Context context){
        mContext=context;
        this.carreras=crs;
        inflater=LayoutInflater.from(mContext);
        this.arrayList= new ArrayList<Carrera>();
        this.arrayList.addAll(crs);
    }

    @Override
    public ListViewAdapterCarreras.CarreraHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_view_items_carreras, parent, false);

        return new ListViewAdapterCarreras.CarreraHolder(itemView);
    }
    public Carrera getCarreraAt(int position){
        return  carreras.get(position);
    }
    public void delete(Carrera al){
        carreras.remove(al);
        notifyDataSetChanged();
    }
    public void add(Carrera al){
        carreras.add(al);
        notifyDataSetChanged();
    }

    @Override
    public void onBindViewHolder(CarreraHolder holder, int position) {
        Carrera carrera = carreras.get(position);
        holder.nombre.setText(carreras.get(position).getNombre());
        holder.titulo.setText(carreras.get(position).getTitulo());
        /*if(modo=="matricular"){
            holder.nombre.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    FragmentManager fm1;
                    FragmentTransaction ft1;
                    fm1= (((FragmentActivity)mContext).getSupportFragmentManager());
                    ft1=fm1.beginTransaction();
                    ft1.replace(R.id.fragment_container, new busquedaMatricula());
                    ft1.addToBackStack(null).commit();
                }
            });
        }*/
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemCount(){
        return carreras.size();
    }

    // Función filtrar
    public void filter(String charText) {
        charText = charText.toLowerCase(Locale.getDefault());
        carreras.clear();
        if (charText.length() == 0) {
            carreras.addAll(arrayList);
        } else {
            for (Carrera wp : arrayList) {
                if ((wp.getNombre().toLowerCase(Locale.getDefault()).contains(charText))) {
                    carreras.add(wp);
                }
            }
        }
        notifyDataSetChanged();
    }
}
