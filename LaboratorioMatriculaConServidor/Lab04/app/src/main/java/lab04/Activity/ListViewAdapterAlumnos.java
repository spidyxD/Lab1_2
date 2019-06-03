package lab04.Activity;

import android.app.Activity;
import android.content.Context;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lab04.R;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import lab04.LogicaNegocio.Alumno;
import lab04.LogicaNegocio.Profesor;

public class ListViewAdapterAlumnos extends RecyclerView.Adapter<ListViewAdapterAlumnos.AlumnosHolder> {
    Context mContext;
    LayoutInflater inflater;
    private List<Alumno> alumnos=null;
    private ArrayList<Alumno> arrayList;

    public class AlumnosHolder extends RecyclerView.ViewHolder {
        TextView nombre;
        TextView cedula;

        public AlumnosHolder(View view){
            super(view);
            nombre = view.findViewById(R.id.nombreEditAlum);
            cedula = view.findViewById(R.id.cedulaEditAlum);
        }
    }
        public ListViewAdapterAlumnos(List<Alumno> als, Context context){
        mContext=context;
        this.alumnos=als;
        inflater=LayoutInflater.from(mContext);
        this.arrayList= new ArrayList<Alumno>();
        this.arrayList.addAll(als);
    }

    @Override
    public AlumnosHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_view_items_alumnos, parent, false);

        return new AlumnosHolder(itemView);
    }
    public Alumno getAlumnoAt(int position){
        return alumnos.get(position);
    }
    public void delete(Alumno al){
        alumnos.remove(al);
        notifyDataSetChanged();
    }
    public void add(Alumno al){
        alumnos.add(al);
        notifyDataSetChanged();
    }
    @Override
    public void onBindViewHolder(AlumnosHolder holder, int position) {
        Alumno al  = alumnos.get(position);
        holder.nombre.setText(alumnos.get(position).getNombre());
        holder.cedula.setText(Integer.toString(alumnos.get(position).getCedula()));
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
        return alumnos.size();
    }

    // Función filtrar
    public void filter(String charText) {
        charText = charText.toLowerCase(Locale.getDefault());
        alumnos.clear();
        if (charText.length() == 0) {
            alumnos.addAll(arrayList);
        } else {
            for (Alumno wp : arrayList) {
                String ced= Integer.toString(wp.getCedula());
                if ((wp.getNombre().toLowerCase(Locale.getDefault()).contains(charText))||(ced.toLowerCase(Locale.getDefault()).contains(charText))) {
                    alumnos.add(wp);
                }
            }
        }
        notifyDataSetChanged();
    }
}

