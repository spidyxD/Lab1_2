package lab04.Activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.lab04.R;

import lab04.Controller.Administrador_Controller;
import lab04.Controller.Datos_Controller;
import lab04.LogicaNegocio.Administrador;

public class ChangeClave extends Fragment {
    private static final String TAG = "ChangeClave";
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View root = inflater.inflate(R.layout.change_password, container, false);
        super.onCreate(savedInstanceState);


        return root;
    }
}
