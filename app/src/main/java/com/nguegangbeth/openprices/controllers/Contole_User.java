package com.nguegangbeth.openprices.controllers;

import android.content.Context;

import com.nguegangbeth.openprices.modeles.users;
import com.nguegangbeth.openprices.modeles.accesLocal_User;
import com.nguegangbeth.openprices.tools.Serializer;

import java.util.ArrayList;
import java.util.Date;

public class Contole_User {

    private static Contole_User instance = null;
    private static users users;
    private static accesLocal_User accesLocal;
    private static String  Monfic = "Save users";
    private ArrayList<users> lesUsers = new ArrayList<users>();

    /**
     * constructeur prive
     */
    private Contole_User(){
        super();
    }

    /**
     * creation de l'instance
     * @return instance
     */
    //genere une instance si elle ne l'a pas encore ete
    public static final Contole_User getInstance(Context context){
        if(Contole_User.instance == null){
            Contole_User.instance = new Contole_User();
            //RecupSerialiaze(context);
            accesLocal = new accesLocal_User(context);
            users = accesLocal.recupDernier();
        }
        return Contole_User.instance;
    }

    public ArrayList<users> getLesUsers() {
        return lesUsers;
    }

    public void setLesUsers(ArrayList<users> lesUsers) {
        this.lesUsers = lesUsers;
    }

    /**
     * creation du profil
     * @param email
     * @param nom_prenom cm
     * @param motPasse
     */
    //creer un profil
    public void CreerUser(String email, String nom_prenom, String motPasse, Context contexte){
        //users = new users(new Date(),email, nom_prenom, motPasse);
        //Serializer.Serialize(Monfic, users, contexte);
        lesUsers.add(users);
        accesLocal.Ajout(users);
    }

    /**
     * recupere l'email
     * @return
     */
    public String getEmail()
    {
        if(users == null){
            return null;
        }else{
            return lesUsers.get(lesUsers.size()+1).getEmail();
        }
    }

    public String getNomPrenom(){
        if(users == null){
            return null;
        }else {
            return lesUsers.get(lesUsers.size() + 1).getUsername();
        }
    }

    public String getMotPasse(){
        if(users == null){
            return null;
        }else {
            return lesUsers.get(lesUsers.size() + 1).getMotdepasse();
        }
    }



    private static void RecupSerialiaze(Context contexte){
        users = (users) Serializer.Deserialize(Monfic, contexte);
    }
}
