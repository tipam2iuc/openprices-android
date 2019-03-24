package com.nguegangbeth.openprices.views;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.nguegangbeth.openprices.R;
import com.nguegangbeth.openprices.modeles.Produits;
import com.nguegangbeth.openprices.modeles.users;

import java.util.List;

public class holderUser extends RecyclerView.Adapter<holderUser.ViewHolder>{

    private List<users> usersList;
    private Context context;

    public holderUser(List<users> listItems, Context context) {
        this.usersList = listItems;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder( ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.holder_user, viewGroup, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        users listItem = usersList.get(i);

        viewHolder.email.setText(listItem.getEmail());
        viewHolder.motdepasse.setText(listItem.getMotdepasse());
        viewHolder.username.setText(listItem.getUsername());
        viewHolder.role.setText("role");
    }

    @Override
    public int getItemCount() {
        return usersList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView email;
        public TextView username;
        public TextView motdepasse;
        public TextView role;
        public ViewHolder( View itemView) {
            super(itemView);

            email = (TextView)itemView.findViewById(R.id.email);
            username = (TextView)itemView.findViewById(R.id.username);
            motdepasse = (TextView)itemView.findViewById(R.id.password);
            role = (TextView)itemView.findViewById(R.id.role);
        }
    }
}
