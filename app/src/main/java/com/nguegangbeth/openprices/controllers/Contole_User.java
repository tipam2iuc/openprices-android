package com.nguegangbeth.openprices.controllers;

import android.content.Context;

import com.nguegangbeth.openprices.modeles.User;
import com.nguegangbeth.openprices.modeles.accesLocal_User;
import com.nguegangbeth.openprices.tools.Serializer;

import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;

public class Contole_User {

    private static Contole_User instance = null;
    private static User user;
    private static accesLocal_User accesLocal;
    private static String  Monfic = "Save User";
    private ArrayList<User> lesUsers = new ArrayList<User>();

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
            accesLocal = new accesLocal_User(context);
            user = accesLocal.recupDernier();
        }
        return Contole_User.instance;
    }

    public ArrayList<User> getLesUsers() {
        return lesUsers;
    }

    public void setLesUsers(ArrayList<User> lesUsers) {
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
        user = new User(new Date(),email, nom_prenom, motPasse, motPasse);
        Serializer.Serialize(Monfic, user, contexte);
        lesUsers.add(user);
        accesLocal.Ajout(user);
    }

    /**
     * recupere l'email
     * @return
     */
    public String getEmail()
    {
        if(user == null){
            return null;
        }else{
            return lesUsers.get(lesUsers.size()+1).getEMAIL();
        }
    }

    public String getNomPrenom(){
        if(user == null){
            return null;
        }else {
            return lesUsers.get(lesUsers.size() + 1).getNomPrenom();
        }
    }

    public String getMotPasse(){
        if(user == null){
            return null;
        }else {
            return lesUsers.get(lesUsers.size() + 1).getMotPasse();
        }
    }



    private static void RecupSerialiaze(Context contexte){
        user = (User) Serializer.Deserialize(Monfic, contexte);
    }
}
