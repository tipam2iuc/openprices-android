package com.nguegangbeth.openprices.modeles;

import java.util.Date;

public class Produits {

    private Integer Id;
    private String Id_Produit;
    private String NomProduit;
    private int Prix;
    private Float Poids;
    private int Photo;
    private Date dateAjout;
    private Market Id_market;
    private String Description;

    public Produits(Integer id, String id_Produit, String nomProduit,
                    int prix, Float poids, int photo, Date dateAjout, Market id_market, String description) {
        Id = id;
        Id_Produit = id_Produit;
        NomProduit = nomProduit;
        Prix = prix;
        Poids = poids;
        Photo = photo;
        this.dateAjout = dateAjout;
        Id_market = id_market;
        Description = description;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
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

    public Float getPoids() {
        return Poids;
    }

    public void setPoids(Float poids) {
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

    public Market getId_market() {
        return Id_market;
    }

    public void setId_market(Market id_market) {
        Id_market = id_market;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }
}
