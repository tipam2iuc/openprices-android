package com.nguegangbeth.openprices.views;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.nguegangbeth.openprices.R;

//LPR : les plus recommandes
public class HorizontalAdapter extends RecyclerView.Adapter<HorizontalAdapter.HorizontalViewHolder>{

    private int[] L_image;
    private String[] L_product_name;

    public HorizontalAdapter(int[] l_image, String[] l_product_name) {
        L_image = l_image;
        L_product_name = l_product_name;
    }



    @Override
    public HorizontalViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view = inflater.inflate(R.layout.holder_lesplusrecommandes, viewGroup, false);
        return new HorizontalViewHolder(view);
    }

    @Override
    public void onBindViewHolder(HorizontalViewHolder horizontalViewHolder, int i) {

        horizontalViewHolder.LPR_textView_nomProduit.setText(L_product_name[i]);
        horizontalViewHolder.LPR_image.setImageResource(L_image[i]);
    }

    @Override
    public int getItemCount() {
        return L_image.length;
    }

    public class HorizontalViewHolder extends RecyclerView.ViewHolder {

        ImageView LPR_image;
        TextView LPR_textView_nomProduit;
        TextView LPR_textView_prix;
        public HorizontalViewHolder(View itemView) {
            super(itemView);
            LPR_image = (ImageView)itemView.findViewById(R.id.LPR_imageview);
            LPR_textView_nomProduit = (TextView)itemView.findViewById(R.id.LPRtextview_product_name);
        }
    }
}
