package com.nguegangbeth.openprices.modeles;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.nguegangbeth.openprices.tools.SQLiteUser;

import java.util.Date;

public class accesLocal_User {

    //proprietes
    private String nomBase = "BDUser.sqlite";
    private Integer versionBase = 1;
    private SQLiteUser accesBD;
    private SQLiteDatabase bd;

    /**
     * Constructeur
     * @param context
     */
    public accesLocal_User(Context context){
        accesBD = new SQLiteUser(context, nomBase,null,versionBase);
    }

    /**
     * Ajout d'un profil dans la bd
     * @param users
     */

    public void Ajout(users users){
        bd = accesBD.getWritableDatabase();
        String req = "INSERT INTO User(dateEnregistrement, poids, taille, age, fullname, status, gender) "
                + "VALUES"+"("+"users"+","+"users"+","+"users"+ ","+"users"+
                ")";

        bd.execSQL(req);
    }

    /**
     * Recuperation du dernier element de la bd
     * @return
     */
    public users recupDernier(){
        bd = accesBD.getReadableDatabase();
        users users = null;
        String req = "SELECT * FROM User";
        Cursor curseur = bd.rawQuery(req, null);
        curseur.moveToLast();
        if(!curseur.isAfterLast()){
            Date date = new Date();
            String adresse_mail = curseur.getString(1);
            String nom_Prenom = curseur.getString(2);
            String motdepasse = curseur.getString(3);

           // users = new users(date, adresse_mail, nom_Prenom, motdepasse);
        }
        curseur.close();
        return users;
    }

}
