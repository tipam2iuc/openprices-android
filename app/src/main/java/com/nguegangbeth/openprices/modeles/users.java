package com.nguegangbeth.openprices.modeles;

import android.os.Build;
import android.support.annotation.RequiresApi;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Date;
import java.util.Objects;

public class users {
    @SerializedName("idUser")
    @Expose
    private int idUser;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("username")
    @Expose
    private String username;
    @SerializedName("motdepasse")
    @Expose
    private String motdepasse;
    @SerializedName("photo")
    @Expose
    private String photo;
    @SerializedName("dateCreation")
    @Expose
    private String dateCreation;
    @SerializedName("idRole")
    @Expose
    private int idRole;

    public users() {
    }

    public users(String username, String email, String motdepasse, String photo, String dateCreation, int idRole) {
        this.username = username;
        this.email = email;
        this.motdepasse = motdepasse;
        this.photo = photo;
        this.dateCreation = dateCreation;
        this.idRole = idRole;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMotdepasse() {
        return motdepasse;
    }

    public void setMotdepasse(String motdepasse) {
        this.motdepasse = motdepasse;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(String dateCreation) {
        this.dateCreation = dateCreation;
    }

    public int getIdRole() {
        return idRole;
    }

    public void setIdRole(int idRole) {
        this.idRole = idRole;
    }

    public users AddUsers(){
        return null;
    }

    public users AddDelete(){
        return null;
    }

    public users AddUpdate(){
        return null;
    }

    public users AddInsert(){
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        users users = (users) o;
        return Objects.equals(email, users.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email);
    }

}
