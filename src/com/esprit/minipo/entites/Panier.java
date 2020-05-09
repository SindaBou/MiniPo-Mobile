/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.minipo.entites;

/**
 *
 * @author Lenovo
 */
public class Panier {
    
    private int idLc;
    private String photo;
    private String designation;
    private float prix;
    private String nom;
    private int qte;
    private float total;
    private float subtotal;
    private int idcmd;


    
    public Panier(int idLc, String designation, float prix, String nom, int qte, float total,float tot,String photo,int idcmd) {
        this.idLc = idLc;
        this.designation = designation;
        this.prix = prix;
        this.nom = nom;
        this.qte = qte;
        this.total = total;
        this.subtotal=tot;
        this.photo=photo;
        this.idcmd=idcmd;
    }

    
    
    public Panier() {
        
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getIdcmd() {
        return idcmd;
    }

    public void setIdcmd(int idcmd) {
        this.idcmd = idcmd;
    }
    

    
    
    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }


    public int getQte() {
        return qte;
    }

    public void setQte(int qte) {
        this.qte = qte;
    }

    public int getIdLc() {
        return idLc;
    }

    public void setIdLc(int idLc) {
        this.idLc = idLc;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public float getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(float subtotal) {
        this.subtotal = subtotal;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    
    
    @Override
    public String toString() {
        return "Panier{" + "id=" + idLc 
                + ", photo="+ photo
                + ", designation=" + designation 
                + ", prix=" + prix 
                + ", qte=" + qte
                + ", Subtotal="+subtotal
                + ", total=" + total
                + ", idcmd=" + idcmd
                + ", nom=" +nom
                + "}\n";
    }

   
    
    
    
    
}
