package com.nguegangbeth.openprices.views;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.nguegangbeth.openprices.R;
import com.nguegangbeth.openprices.modeles.Produits;
import com.nguegangbeth.openprices.modeles.WebServices.GetUsersAT;
import com.nguegangbeth.openprices.modeles.users;

import java.util.ArrayList;
import java.util.List;

public class UserListActivity extends AppCompatActivity implements GetUsersAT.GetUserATResult {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private List<users> usersList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_list);

        recyclerView = (RecyclerView)findViewById(R.id.recycle_view_userlist);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        usersList = new ArrayList<>();

       new GetUsersAT(this).execute();
        /*for(int i = 0; i <= 10; i++){
            users listItem = new users(
                    "lise "+ (i+1),
                    "djomf",
                    "der",null,null,2
            );

            usersList.add(listItem);
        }*/

        adapter = new holderUser(usersList, this);
        recyclerView.setAdapter(adapter);

    }


    @Override
    public void UserChargee(ArrayList<users> user) {
        usersList.addAll(user);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void UserError(Exception exception) {

    }
}
