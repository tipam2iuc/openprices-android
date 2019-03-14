package com.nguegangbeth.openprices.views;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.nguegangbeth.openprices.R;
import com.nguegangbeth.openprices.modeles.Produits;

import java.util.List;

public class Holder_tous_les_produitsAdapter extends RecyclerView.Adapter<Holder_tous_les_produitsAdapter.ViewHolder> {

    private List<Produits> produits;
    private Context context;

    public Holder_tous_les_produitsAdapter(List<Produits> produits, Context context) {
        this.produits = produits;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder( ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.holder_tous_produits, viewGroup, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        Produits produit = produits.get(i);

        viewHolder.textView_nomproduit.setText(produit.getNomProduit());
        viewHolder.textView_desc.setText(produit.getDescription());
        viewHolder.imageView_like.setImageResource(R.drawable.coeur_vide);
        viewHolder.imageView_holder_tousproduis.setImageResource(produit.getPhoto());
    }

    @Override
    public int getItemCount() {
        return produits.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public ImageView imageView_holder_tousproduis;
        public TextView textView_nomproduit;
        public  TextView textView_desc;
        public  ImageView imageView_like;

        public ViewHolder(  View itemView) {
            super(itemView);

            imageView_holder_tousproduis = (ImageView) itemView.findViewById(R.id.image_holder_tousProduits);
            textView_desc = (TextView)itemView.findViewById(R.id.textview_desc_holdertousProduits);
            textView_nomproduit = (TextView)itemView.findViewById(R.id.textview_nomProduit_holdertousProduits);
            imageView_like = (ImageView)itemView.findViewById(R.id.imageView_coeurvide_holderTousProduits);
        }
    }
}
