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

enum EtatCommande {Validée, NonValidée} ;  
    


public class Commande {
    
    private int idcmd;
    private String datec ;
    private float total;
    private String etatc;
    private User client;
    private String refC;
    private int id;
    private String nom;
    private String prenom;  

    
    public Commande(int idcmd, float total, String etatc, User client, String refC,String datec ) {
        this.idcmd = idcmd;
        this.total = total;
        this.etatc = etatc;
        this.client = client;
        this.refC = refC;
        this.datec=datec;
    }
    
    

   /* public Commande(int idcmd, Date datec, float total, String etatc, User client, String refC) {
        this.idcmd = idcmd;
        this.datec = datec;
        this.total = total;
        this.etatc = etatc;
        this.client = client;
        this.refC = refC;
    }
    
    public Commande(Date datec, float total, String etatc, User client, String refC) {
        
        this.datec = datec;
        this.total = total;
        this.etatc = etatc;
        this.client = client;
        this.refC = refC;
    }

    public Commande(int idcmd, Date datec, float total, String etatc, User client) {
        this.idcmd = idcmd;
        this.datec = datec;
        this.total = total;
        this.etatc = etatc;
        this.client = client;
    }
    
     public Commande(Integer idcmd, String refC) {
        this.idcmd = idcmd;
        this.refC = refC;
    }

  
    public Commande(Date datec, float total, String etatc, User client) {
        this.datec = datec;
        this.total = total;
        this.etatc = etatc;
        this.client = client;
    }

    public Commande(Date datec, float total, User client) {
        this.datec = datec;
        this.total = total;
        this.client = client;
    }

    public Commande(int idcmd, String etatc) {
        this.idcmd = idcmd;
        this.etatc = etatc;
    }
    
    public Commande(int idcmd) {
        this.idcmd = idcmd;
    }
    */
    public Commande() {
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
        final Commande other = (Commande) obj;
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
                +"}\n";
    }
    

   
                
    }

  


    
    
    
    

 