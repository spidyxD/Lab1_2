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
import lab04.LogicaNegocio.Curso;
import lab04.LogicaNegocio.Profesor;

public class ListViewAdapterCursos extends RecyclerView.Adapter<ListViewAdapterCursos.CursosHolder> {
    Context mContext;
    LayoutInflater inflater;
    private List<Curso>  cursos=null;
    private ArrayList<Curso> arrayList;

    public class CursosHolder extends RecyclerView.ViewHolder {
        TextView nombre;
        TextView codigo;

        public CursosHolder(View view){
            super(view);
            nombre = view.findViewById(R.id.nombreEditCurso);
            codigo = view.findViewById(R.id.codigoEditCurso);
        }
    }
    public ListViewAdapterCursos(List<Curso> cursos, Context context){
        mContext=context;
        this.cursos=cursos;
        inflater=LayoutInflater.from(mContext);
        this.arrayList= new ArrayList<Curso>();
        this.arrayList.addAll(cursos);
    }

    @Override
    public ListViewAdapterCursos.CursosHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_view_items_cursos, parent, false);

        return new ListViewAdapterCursos.CursosHolder(itemView);
    }

    @Override
    public void onBindViewHolder(CursosHolder holder, int position) {
        Curso c  = cursos.get(position);
        holder.nombre.setText(cursos.get(position).getNombre());
        holder.codigo.setText(Integer.toString(cursos.get(position).getCodigo()));
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
        return cursos.size();
    }
    public Curso getCursorAt(int position){
        return  cursos.get(position);
    }
    public void delete(Curso al){
        cursos.remove(al);
        notifyDataSetChanged();
    }
    public void add(Curso al){
        cursos.add(al);
        notifyDataSetChanged();
    }
    // Función filtrar
    public void filter(String charText) {
        charText = charText.toLowerCase(Locale.getDefault());
        cursos.clear();
        if (charText.length() == 0) {
            cursos.addAll(arrayList);
        } else {
            for (Curso wp : arrayList) {
                String ced= Integer.toString(wp.getCodigo());
                if ((wp.getNombre().toLowerCase(Locale.getDefault()).contains(charText))||(ced.toLowerCase(Locale.getDefault()).contains(charText))) {
                    cursos.add(wp);
                }
            }
        }
        notifyDataSetChanged();
    }
}
