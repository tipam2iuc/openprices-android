package com.nguegangbeth.openprices.modeles;

import java.util.Date;
import java.util.Objects;

public class Produits {

    private String Id_Produit;
    private String NomProduit;
    private int Prix;
    private double Poids;
    private int Photo;
    private Date dateAjout;
    private String Description;

    public Produits(String id_Produit, String nomProduit,
                    int prix, double poids, int photo, Date dateAjout, String description) {
        Id_Produit = id_Produit;
        NomProduit = nomProduit;
        Prix = prix;
        Poids = poids;
        Photo = photo;
        this.dateAjout = dateAjout;
        Description = description;
    }

    public Produits(String nomProduit, int prix, double poids, int photo, String description) {
        NomProduit = nomProduit;
        Prix = prix;
        Poids = poids;
        Photo = photo;
        Description = description;
    }


    public String getId_Produit() {
        return Id_Produit;
    }

    public void setId_Produit(String id_Produit) {
        Id_Produit = id_Produit;
    }

    public String getNomProduit() {
        return NomProduit;
    }

    public void setNomProduit(String nomProduit) {
        NomProduit = nomProduit;
    }

    public int getPrix() {
        return Prix;
    }

    public void setPrix(int prix) {
        Prix = prix;
    }

    public double getPoids() {
        return Poids;
    }

    public void setPoids(double poids) {
        Poids = poids;
    }

    public int getPhoto() {
        return Photo;
    }

    public void setPhoto(int photo) {
        Photo = photo;
    }

    public Date getDateAjout() {
        return dateAjout;
    }

    public void setDateAjout(Date dateAjout) {
        this.dateAjout = dateAjout;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Produits produits = (Produits) o;
        return Objects.equals(Id_Produit, produits.Id_Produit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id_Produit);
    }
}
