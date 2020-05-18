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
public class AboutCmd {
    
    private int idLc;
    private String photo;
    private String designation;
    private float prix;
    private String nom;
    private int qte;
    private float total;
    private float subtotal;
    private int idcmd;
    private String refc;
    private String etatc;
    private String datec;
    


    
    public AboutCmd(int idLc, String designation, float prix, String nom, int qte, float total,float tot,String photo) {
        this.idLc = idLc;
        this.designation = designation;
        this.prix = prix;
        this.nom = nom;
        this.qte = qte;
        this.total = total;
        this.subtotal=tot;
        this.photo=photo;
    }

    public AboutCmd(int idLc, String photo, String designation, float prix, String nom, int qte, float total, float subtotal, int idcmd, String refc, String etatc, String datec) {
        this.idLc = idLc;
        this.photo = photo;
        this.designation = designation;
        this.prix = prix;
        this.nom = nom;
        this.qte = qte;
        this.total = total;
        this.subtotal = subtotal;
        this.idcmd = idcmd;
        this.refc = refc;
        this.etatc = etatc;
        this.datec = datec;
    }
    
    
    public AboutCmd() {
        
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

    public String getRefc() {
        return refc;
    }

    public void setRefc(String refc) {
        this.refc = refc;
    }

    public String getEtatc() {
        return etatc;
    }

    public void setEtatc(String etatc) {
        this.etatc = etatc;
    }

    public String getDatec() {
        return datec;
    }

    public void setDatec(String datec) {
        this.datec = datec;
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
        return "AboutCmd{" + "idLc=" + idLc + ", photo=" + photo + ", designation=" + designation + ", prix=" + prix + ", nom=" + nom + ", qte=" + qte + ", total=" + total + ", subtotal=" + subtotal + ", idcmd=" + idcmd + ", refc=" + refc + ", etatc=" + etatc + ", datec=" + datec + '}';
    }

    
    
    
   
    
    
    
    
}
