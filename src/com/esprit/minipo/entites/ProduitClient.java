/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.minipo.entites;

/**
 *
 * @author yacin
 */
public class ProduitClient {
    private int id, qtestock;
    private String designation, description, categorie, photo;
    private float prix;

    public ProduitClient(int id, int qtestock, String designation, String description, String categorie, String photo, float prix) {
        this.id = id;
        this.qtestock = qtestock;
        this.designation = designation;
        this.description = description;
        this.categorie = categorie;
        this.photo = photo;
        this.prix = prix;
    }

    public ProduitClient() {
    }

    public ProduitClient(int qtestock, String designation, String description, String categorie, String photo, float prix) {
        this.qtestock = qtestock;
        this.designation = designation;
        this.description = description;
        this.categorie = categorie;
        this.photo = photo;
        this.prix = prix;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQtestock() {
        return qtestock;
    }

    public void setQtestock(int qtestock) {
        this.qtestock = qtestock;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    @Override
    public String toString() {
        return "ProduitClient{" + "id=" + id + ", qtestock=" + qtestock + ", designation=" + designation + ", description=" + description + ", categorie=" + categorie + ", photo=" + photo + ", prix=" + prix + '}';
    }
    
    
    
    
    
}
