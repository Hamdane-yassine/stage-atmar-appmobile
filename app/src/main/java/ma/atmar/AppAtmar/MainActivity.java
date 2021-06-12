package ma.atmar.AppAtmar;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

import ma.atmar.AppAtmar.HelperClasses.DB_sqlite;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    DB_sqlite db = new DB_sqlite(this);
    ProductFragment pf;
    private DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        if (savedInstanceState == null) {
            pf = new ProductFragment();
            pf.setProducts(db.getProducts("outil_dis"));
            pf.setContext(this);
            pf.setCat("outil_dis");
            pf.setFramentManager(getSupportFragmentManager());
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,pf).commit();
            navigationView.setCheckedItem(R.id.nav_products_1);
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_products_1:
                pf = new ProductFragment();
                pf.setProducts(db.getProducts("outil_dis"));
                pf.setContext(this);
                pf.setCat("outil_dis");
                pf.setFramentManager(getSupportFragmentManager());
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,pf).commit();
                break;
            case  R.id.nav_products_2:
                pf = new ProductFragment();
                pf.setProducts(db.getProducts("outil_dan"));
                pf.setContext(this);
                pf.setCat("outil_dan");
                pf.setFramentManager(getSupportFragmentManager());
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,pf).commit();
                break;
            case R.id.nav_products_3:
                pf = new ProductFragment();
                pf.setProducts(db.getProducts("mat"));
                pf.setContext(this);
                pf.setCat("mat");
                pf.setFramentManager(getSupportFragmentManager());
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,pf).commit();
                break;
            case R.id.nav_products_4:
                pf = new ProductFragment();
                pf.setProducts(db.getProducts("div"));
                pf.setContext(this);
                pf.setCat("div");
                pf.setFramentManager(getSupportFragmentManager());
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,pf).commit();
                break;
            case R.id.nav_presentation:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new AboutFragment()).commit();
                break;
            case R.id.nav_contact:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new ContactFragment()).commit();
                break;
        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}