package lab04.Activity;

import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.example.lab04.R;

import lab04.LogicaNegocio.Administrador;

import static lab04.Activity.LoginActivity.DATOS;
import static lab04.Activity.LoginActivity.usuario;

public class AdministradorActivity extends Fragment {
    private static final String TAG = "AdministradorActivity";
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View root = inflater.inflate(R.layout.activity_administrador, container, false);
        super.onCreate(savedInstanceState);
        if (DATOS.getModo()=="Editar"){
            Administrador admin= DATOS.getAdministradorXCed(usuario.getUsername());
            EditText nombre = root.findViewById(R.id.nombreAddUpdAdmin);
            EditText cedula= root.findViewById(R.id.cedulaAddUpdAdmin);
            EditText clave = root.findViewById(R.id.claveAddUpdAdmin);
            nombre.setText(admin.getNombre());
            cedula.setText(Integer.toString(admin.getCedula()));
            final FloatingActionButton editar = root.findViewById(R.id.addUpdAdminBtn);
            editar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    editar(root);
                }
            });
        }

        return root;
    }
    public void editar(View root){
        Administrador admin= DATOS.getAdministradorXCed(usuario.getUsername());
        EditText nombre = root.findViewById(R.id.nombreAddUpdAdmin);
        EditText cedula= root.findViewById(R.id.cedulaAddUpdAdmin);
        DATOS.updateAdministrador(Integer.parseInt(cedula.getText().toString()),nombre.getText().toString());
        Toast.makeText(root.getContext(), "Datos Actualizados!", Toast.LENGTH_SHORT).show();
    }
}
