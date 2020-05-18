/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.esprit.minipo.entites;
//import java.sql.Date;

/**
 *
 * @author Lenovo
 */

 
    


public class Commandes {
    
    private int idcmd;
    private String datec ;
    private float total;
    private String etatc;
    private User client;
    private String refC;
    private int id;
    private String nom;
    private String prenom;
    private String etatl;

    
    public Commandes(int idcmd, float total, String etatc, User client, String refC,String datec,String etatl ) {
        this.idcmd = idcmd;
        this.total = total;
        this.etatc = etatc;
        this.client = client;
        this.refC = refC;
        this.datec=datec;
        this.etatl=etatl;
    }
    
    

    public Commandes() {
    }


    public int getIdcmd() {
        return idcmd;
    }

    public void setIdcmd(int idc) {
        this.idcmd = idc;
    }

    public String getDatec() {
        return datec;
    }

    public void setDatec(String datec) {
        this.datec = datec;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public String getEtatc() {
        return etatc;
    }

    public void setEtatcmd(String etatcmd) {
        this.etatc = etatcmd;
    }

    public User getClient() {
        return client;
    }

    public void setClient(User client) {
        this.client = client;
    }

    public String getRefC() {
        return refC;
    }

    public void setRefC(String refC) {
        this.refC = refC;
    }
   
    
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Commandes other = (Commandes) obj;
        if (this.idcmd != other.idcmd) {
            return false;
        }
        return true;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEtatl() {
        return etatl;
    }

    public void setEtatl(String etatl) {
        this.etatl = etatl;
    }
    
    

    @Override
    public String toString() {
        return  "commande {"+"idcmd= " + idcmd 
                + ", total= " + total 
                + ", etatc= " + etatc 
                + ", datec= " + datec 
                + ", refC= " + refC 
                + ", id= " + id 
                + ", nom= " + nom 
                + ", prenom= " + prenom
                + ", etatl= " + etatl 
                +"}\n";
    }
    

   
                
    }

  


    
    
    
    

 