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

public class mantenimientoProfesores extends FragmentActivity {
    private static final String TAG = "mantenimientoProfesores";

    private SectionsPageAdapter mSectionsPageAdapter;
    TabLayout tabLayout;

    private ViewPager mViewPager;
    private SectionsPageAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.generic_tabs);
        DATOS.setModo("Agregar");
        Log.d(TAG, "onCreate: Starting");
        ((TextView) findViewById(R.id.textTittletab)).setText("Mantenimmiento de Profesores");
        findViewById(R.id.textTittletab).setBackgroundColor(Color.parseColor("#33BBA2"));
        mSectionsPageAdapter = new SectionsPageAdapter(getSupportFragmentManager());
        AppBarLayout barra = findViewById(R.id.barrTaps);
        barra.setBackgroundColor(Color.parseColor("#33BBA2"));
        all();

    }
    public void all(){
        mViewPager = findViewById(R.id.container);
        setupViewPage(mViewPager);
        tabLayout = findViewById(R.id.tabs);
        tabLayout.setBackgroundColor(Color.parseColor("#33BBA2"));
        findViewById(R.id.rowBarra).setBackgroundColor(Color.parseColor("#33BBA2"));
        tabLayout.setupWithViewPager(mViewPager);
    }

    public TabLayout getTabLayout() {
        return tabLayout;
    }

    public void setTabLayout(TabLayout tabLayout) {
        this.tabLayout = tabLayout;
    }

    public ViewPager getmViewPager() {
        return mViewPager;
    }

    public void setmViewPager(ViewPager mViewPager) {
        this.mViewPager = mViewPager;
    }

    public SectionsPageAdapter getAdapter() {
        return adapter;
    }

    public void setAdapter(SectionsPageAdapter adapter) {
        this.adapter = adapter;
    }

    private void setupViewPage(ViewPager viewPager) {
        adapter = new SectionsPageAdapter(getSupportFragmentManager());
        adapter.addFragment(new busquedaProfesores(), "Busqueda");
        adapter.addFragment(new AddProfesorFragment(), "Agregar");
        viewPager.setAdapter(adapter);
    }

}