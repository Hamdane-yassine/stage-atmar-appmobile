package ma.atmar.AppAtmar.HelperClasses;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

import java.io.InputStream;
import java.util.ArrayList;

import ma.atmar.AppAtmar.MainActivity;
import ma.atmar.AppAtmar.ProductFragment;
import ma.atmar.AppAtmar.Productdetails;
import ma.atmar.AppAtmar.R;

public class RecycleAdapter extends RecyclerView.Adapter<RecycleAdapter.FeaturedViewHolder>
{
    ArrayList<Produits> products;
    Context con;
    FragmentManager mf;
    String cat;
    public RecycleAdapter(ArrayList<Produits> products, Context con,FragmentManager mf,String cat) {
        this.mf=mf;
        this.products = products;
        this.con=con;
        this.cat=cat;
    }

    @NonNull
    @Override
    public FeaturedViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_product,parent,false);
        FeaturedViewHolder ft = new FeaturedViewHolder(view);
        return ft;
    }

    @Override
    public void onBindViewHolder(@NonNull FeaturedViewHolder holder, int position) {
            final Produits ra = products.get(position);
            String mDrawableName = "pro_"+ra.getId();
            int resID = this.con.getResources().getIdentifier(mDrawableName , "drawable", this.con.getPackageName());
            holder.image.setImageResource(resID);
            holder.title.setText(ra.getTitle());
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(con, Productdetails.class);
                    i.putExtra("produit", ra);
                    con.startActivity(i);
                }
            });

    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    public static class FeaturedViewHolder extends RecyclerView.ViewHolder
    {
        ImageView image;
        TextView title;
        public FeaturedViewHolder(@NonNull View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.featured_image);
            title = itemView.findViewById(R.id.featured_title);
        }
    }
}
