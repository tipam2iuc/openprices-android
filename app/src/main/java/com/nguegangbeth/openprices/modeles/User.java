package com.nguegangbeth.openprices.modeles;

import android.os.Build;
import android.support.annotation.RequiresApi;

import java.util.Objects;

public class User {
    private String NomPrenom;
    private String Email;
    private String MotPasse;
    private String ConfirmMotDePasse;

    /**
     * Constructeur
     * @param nomPrenom
     * @param EMAIL
     * @param motPasse
     * @param confirmMotDePasse
     */
    public User(String nomPrenom, String EMAIL, String motPasse, String confirmMotDePasse) {
        NomPrenom = nomPrenom;
        this.Email = EMAIL;
        MotPasse = motPasse;
        ConfirmMotDePasse = confirmMotDePasse;
    }

    public String getNomPrenom() {
        return NomPrenom;
    }

    public String getEMAIL() {
        return Email;
    }

    public String getMotPasse() {
        return MotPasse;
    }

    public String getConfirmMotDePasse() {
        return ConfirmMotDePasse;
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(Email, user.Email);
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public int hashCode() {
        return Objects.hash(Email);
    }

    @Override
    public String toString() {
        return "User{" +
                "NomPrenom='" + NomPrenom + '\'' +
                "\nEMAIL='" + Email + '\'' +
                "\nMotPasse='" + MotPasse + '\'' +
                '}';
    }
}
