package com.nguegangbeth.openprices.modeles;

public class Connexion {

    public String email;
    public String motPasse;

    public Connexion(String email, String motPasse) {
        this.email = email;
        this.motPasse = motPasse;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMotPasse() {
        return motPasse;
    }

    public void setMotPasse(String motPasse) {
        this.motPasse = motPasse;
    }

    @Override
    public String toString() {
        return "Connexion{" +
                "email='" + email + '\'' +
                ", motPasse='" + motPasse + '\'' +
                '}';
    }
}
