package ma.atmar.AppAtmar;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import ma.atmar.AppAtmar.HelperClasses.DB_sqlite;
import ma.atmar.AppAtmar.HelperClasses.Produits;
import ma.atmar.AppAtmar.HelperClasses.RecycleAdapter;


public class Productdetails extends AppCompatActivity {


    FragmentManager mf ;
    String cat;
    Context con;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_productdetails);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_detail);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        Intent i = getIntent();
        Produits ra = (Produits)i.getSerializableExtra("produit");
        TextView title = findViewById(R.id.product_title);
        title.setText(ra.getTitle());
        TextView desc = findViewById(R.id.product_desc);
        desc.setText(ra.getDescription());
        ImageView image = findViewById(R.id.product_img);
        String mDrawableName = "pro_"+ra.getId();
        int resID = getResources().getIdentifier(mDrawableName , "drawable", getPackageName());
        image.setImageResource(resID);

    }

    @Override
    public void onBackPressed() {
        finish();
    }
    public void setFragmentManager(FragmentManager mf) {
        this.mf = mf;
    }
    public void setCat(String cat) {
        this.cat = cat;
    }
    public void setContext(Context con) {
        this.con = con;
    }

}
