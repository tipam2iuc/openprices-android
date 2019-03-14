package com.nguegangbeth.openprices.modeles;

import java.util.Objects;

public class Market {

    private int Id_market;
    private String email;
    private String NomEntreprise;
    private String motPasse;

    public Market(int id_market, String email, String nomEntreprise, String motPasse) {
        Id_market = id_market;
        this.email = email;
        NomEntreprise = nomEntreprise;
        this.motPasse = motPasse;
    }

    public int getId_market() {
        return Id_market;
    }

    public void setId_market(int id_market) {
        Id_market = id_market;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNomEntreprise() {
        return NomEntreprise;
    }

    public void setNomEntreprise(String nomEntreprise) {
        NomEntreprise = nomEntreprise;
    }

    public String getMotPasse() {
        return motPasse;
    }

    public void setMotPasse(String motPasse) {
        this.motPasse = motPasse;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Market market = (Market) o;
        return Id_market == market.Id_market;
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id_market);
    }
}
