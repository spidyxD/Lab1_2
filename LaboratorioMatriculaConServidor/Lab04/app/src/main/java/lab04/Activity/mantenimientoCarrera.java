package lab04.Activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.widget.TableRow;
import android.widget.TextView;

import com.example.lab04.R;

import static lab04.Activity.LoginActivity.DATOS;

public class mantenimientoCarrera extends FragmentActivity {
    private static final String TAG="mantenimientoAlumnos";

    private SectionsPageAdapter mSectionsPageAdapter;

    private ViewPager mViewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.generic_tabs);
        DATOS.setModo("Agregar");
        Log.d(TAG,"onCreate: Starting");
        ((TextView)findViewById(R.id.textTittletab)).setText("Mantenimmiento de Carreras");
        findViewById(R.id.textTittletab).setBackgroundColor(Color.parseColor("#33BBA2"));
        mSectionsPageAdapter= new SectionsPageAdapter(getSupportFragmentManager());
        AppBarLayout barra= findViewById(R.id.barrTaps);
        barra.setBackgroundColor(Color.parseColor("#33BBA2"));
        mViewPager= findViewById(R.id.container);
        setupViewPage(mViewPager);

        TabLayout tabLayout= findViewById(R.id.tabs);
        tabLayout.setBackgroundColor(Color.parseColor("#33BBA2"));
        findViewById(R.id.rowBarra).setBackgroundColor(Color.parseColor("#33BBA2"));
        tabLayout.setupWithViewPager(mViewPager);


    }

    private void setupViewPage(ViewPager viewPager){
        SectionsPageAdapter adapter= new SectionsPageAdapter(getSupportFragmentManager());
        adapter.addFragment(new busquedaCarreras(), "Busqueda");
        adapter.addFragment(new AddCarreraFragment(), "Agregar");
        viewPager.setAdapter(adapter);
    }

}