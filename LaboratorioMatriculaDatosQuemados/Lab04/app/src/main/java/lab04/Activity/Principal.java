package lab04.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.MenuInflater;
import android.view.View;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.MenuItem;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import com.example.lab04.R;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.widget.TextView;
import android.widget.Toast;

import lab04.LogicaNegocio.Administrador;
import lab04.LogicaNegocio.Alumno;
import lab04.LogicaNegocio.Profesor;

import static lab04.Activity.LoginActivity.DATOS;
import static lab04.Activity.LoginActivity.usuario;

public class Principal extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
        View header = navigationView.getHeaderView(0);
        TextView nombre = header.findViewById(R.id.perfilNombre);
        TextView nombre2 = header.findViewById(R.id.perfilSubNombre);
        switch (usuario.getRol()){
            case "Administrador":
                Administrador admin= DATOS.getAdministradorXCed(usuario.getUsername());
                nombre.setText(Integer.toString(admin.getCedula()));
                nombre2.setText("Administrador");
                break;
            case "Alumno":
                Alumno alumno= DATOS.getAlumnoXCed(usuario.getUsername());
                nombre.setText(alumno.getNombre());
                nombre2.setText(Integer.toString(alumno.getCedula()));
                break;
             case "Profesor":
                Profesor profe= DATOS.getProfesorXCed(usuario.getUsername());
                nombre.setText(profe.getNombre());
                nombre2.setText(Integer.toString(profe.getCedula()));
                break;
        }
        setFragment(1);
    }
    public void setFragment(int position){
        switch(position){
            case 1:
                DATOS.setModo("Editar");
                switch (usuario.getRol()){
                    case "Administrador":
                        FragmentManager fm1;
                        FragmentTransaction ft1;
                        fm1= getSupportFragmentManager();
                        ft1=fm1.beginTransaction();
                        ft1.replace(R.id.fragment_container, new AdministradorActivity());
                        ft1.addToBackStack(null).commit();
                        break;
                    case "Alumno":
                        FragmentManager fm2;
                        FragmentTransaction ft2;
                        fm2= getSupportFragmentManager();
                        ft2=fm2.beginTransaction();
                        ft2.replace(R.id.fragment_container, new AddAlumnoFragment());
                        ft2.addToBackStack(null).commit();
                        break;
                    case "Profesor":
                        FragmentManager fm3;
                        FragmentTransaction ft3;
                        fm3= getSupportFragmentManager();
                        ft3=fm3.beginTransaction();
                        ft3.replace(R.id.fragment_container, new AddProfesorFragment());
                        ft3.addToBackStack(null).commit();
                        break;
                }
                break;
            case 2:
                FragmentManager fm3;
                FragmentTransaction ft3;
                fm3= getSupportFragmentManager();
                ft3=fm3.beginTransaction();
                ft3.replace(R.id.fragment_container, new busquedaGrupos());
                ft3.addToBackStack(null).commit();
                break;
            case 3:
                FragmentManager fm4;
                FragmentTransaction ft4;
                fm4= getSupportFragmentManager();
                ft4=fm4.beginTransaction();
                ft4.replace(R.id.fragment_container, new busquedaAlumnos());
                ft4.addToBackStack(null).commit();
                break;
            case 4:
                FragmentManager fm5;
                FragmentTransaction ft5;
                fm5= getSupportFragmentManager();
                ft5=fm5.beginTransaction();
                ft5.replace(R.id.fragment_container, new busquedaProfesores());
                ft5.addToBackStack(null).commit();
                break;
            case 5:
                FragmentManager fm6;
                FragmentTransaction ft6;
                fm6= getSupportFragmentManager();
                ft6=fm6.beginTransaction();
                ft6.replace(R.id.fragment_container, new busquedaAlumnos());
                ft6.addToBackStack(null).commit();
                break;
            case 6:
                FragmentManager fm8;
                FragmentTransaction ft8;
                fm8= getSupportFragmentManager();
                ft8=fm8.beginTransaction();
                ft8.replace(R.id.fragment_container, new busquedaCursos());
                ft8.addToBackStack(null).commit();
                break;
            case 7:
                FragmentManager fm9;
                FragmentTransaction ft9;
                fm9= getSupportFragmentManager();
                ft9=fm9.beginTransaction();
                ft9.replace(R.id.fragment_container, new busquedaCarreras());
                ft9.addToBackStack(null).commit();
                break;
            case 8:
                FragmentManager fm10;
                FragmentTransaction ft10;
                fm10= getSupportFragmentManager();
                ft10=fm10.beginTransaction();
                ft10.replace(R.id.fragment_container, new AddProfesorFragment());
                ft10.addToBackStack(null).commit();
                break;
            case 9:
                FragmentManager fm11;
                FragmentTransaction ft11;
                fm11= getSupportFragmentManager();
                ft11=fm11.beginTransaction();
                ft11.replace(R.id.fragment_container, new AddAlumnoFragment());
                ft11.addToBackStack(null).commit();
                break;
            case 10:
                FragmentManager fm12;
                FragmentTransaction ft12;
                fm12= getSupportFragmentManager();
                ft12=fm12.beginTransaction();
                ft12.replace(R.id.fragment_container, new AddCursoFragment());
                ft12.addToBackStack(null).commit();
                break;
            case 11:
                FragmentManager fm13;
                FragmentTransaction ft13;
                fm13= getSupportFragmentManager();
                ft13=fm13.beginTransaction();
                ft13.replace(R.id.fragment_container, new AddCarreraFragment());
                ft13.addToBackStack(null).commit();
                break;
        }
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.principal, menu);
        return true;
    }

  /*  @Override
    public boolean onPrepareOptionsMenu (Menu menu){
        invalidateOptionsMenu();
        MenuItem logout =(MenuItem)menu.findItem(R.id.nav_principal_logout);
        MenuItem editar =(MenuItem)menu.findItem(R.id.nav_principal_editar_perfil);
        MenuItem estudiantes =(MenuItem)menu.findItem(R.id.nav_principal_estudiantes);
        MenuItem profes =(MenuItem)menu.findItem(R.id.nav_principal_profesore);
        switch (usuario.getRol()){
            case "Administrador":
                Administrador admin= DATOS.getAdministradorXCed(usuario.getUsername());
                logout.setVisible(true);
                editar.setVisible(true);
                estudiantes.setVisible(true);
                profes.setVisible(true);
                break;
            case "Alumno":
                logout.setVisible(true);
                editar.setVisible(true);
                estudiantes.setVisible(false);
                profes.setVisible(false);
                break;
            case "Profesor":
                Profesor profe= DATOS.getProfesorXCed(usuario.getUsername());
                logout.setVisible(true);
                editar.setVisible(true);
                estudiantes.setVisible(false);
                profes.setVisible(false);
                break;
        }return super.onPrepareOptionsMenu(menu);
    }*/
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        if (id == R.id.nav_principal_editar_perfil) {
            Toast.makeText(getApplicationContext(), "Editar Perfil", Toast.LENGTH_SHORT).show();
            setFragment(1);
        } else if (id == R.id.nav_principal_logout) {
            Toast.makeText(getApplicationContext(), "Log Out", Toast.LENGTH_SHORT).show();
            abrirLogin();
        } else if (id == R.id.nav_principal_profesore) {
            Toast.makeText(getApplicationContext(), "Mantenimiento de Profesores", Toast.LENGTH_SHORT).show();
            setFragment(4);
        }else if (id == R.id.nav_principal_estudiantes) {
            Toast.makeText(getApplicationContext(), "Mantenimiento de Estudiantes", Toast.LENGTH_SHORT).show();
            setFragment(5);
        }else if (id == R.id.nav_principal_carreras) {
            Toast.makeText(getApplicationContext(), "Mantenimiento de Carreras", Toast.LENGTH_SHORT).show();
            setFragment(7);
        }else if (id == R.id.nav_principal_cursos) {
            Toast.makeText(getApplicationContext(), "Mantenimiento de Cursos", Toast.LENGTH_SHORT).show();
            setFragment(6);
        }
        else if (id == R.id.nav_principal_grupos_impartidos) {
            Toast.makeText(getApplicationContext(), "Grupos Impartidos", Toast.LENGTH_SHORT).show();
            setFragment(2);
        }
        else if (id == R.id.nav_principal_grupos_matriculados) {
            Toast.makeText(getApplicationContext(), "Grupos Matriculados", Toast.LENGTH_SHORT).show();
            setFragment(2);
        }
        else if (id == R.id.nav_principal_matricula) {
            Toast.makeText(getApplicationContext(), "Seleccione un Alumno", Toast.LENGTH_LONG).show();
            DATOS.setModo("matricular");
            setFragment(3);
        }
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    public void abrirLogin() {
        finish();
        Intent a = new Intent(this, LoginActivity.class);
        startActivity(a);
    }

}
