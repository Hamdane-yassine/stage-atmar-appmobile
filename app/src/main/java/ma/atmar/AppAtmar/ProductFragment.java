package ma.atmar.AppAtmar;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import ma.atmar.AppAtmar.HelperClasses.Produits;
import ma.atmar.AppAtmar.HelperClasses.RecycleAdapter;

public class ProductFragment extends Fragment {

    RecycleAdapter adapter;
    RecyclerView rv;
    ArrayList<Produits> arr;
    String cat;
    Context con;
    FragmentManager fm;

    public void setFramentManager(FragmentManager fm) {
        this.fm = fm;
    }
    public void setCat(String cat)
    {
        this.cat=cat;
    }
    public void setProducts(ArrayList<Produits> arr) {
        this.arr = arr;
    }
    public void setContext(Context con) {
        this.con = con;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_products, container, false);
        rv = (RecyclerView)view.findViewById(R.id.recycle_products);
        featuredRecycle();
        return view;
    }

    private void featuredRecycle() {
        rv.setHasFixedSize(true);
        rv.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        adapter = new RecycleAdapter(this.arr,this.con,this.fm,this.cat);
        rv.setAdapter(adapter);
    }
}

