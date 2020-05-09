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
public class ListeFact {
    
    private int idFact;
    //private Date dateFact;
    private String etatFact;
    private String refc;
    private float total;
    private int idcmd;

    public ListeFact(int idFact,/* Date dateFact , */ String etatFact, String nom, String prenom, 
            String refc, float total, int idclt, int idcmd) {
        this.idFact = idFact;
        //this.dateFact = dateFact;
        this.etatFact = etatFact;
        //this.nom = nom;
        //this.prenom = prenom;
        this.refc = refc;
        this.total = total;
        //this.idclt = idclt;
        this.idcmd = idcmd;
    }

    public ListeFact() {
    }
    
    

    public int getIdFact() {
        return idFact;
    }

    public void setIdFact(int idFact) {
        this.idFact = idFact;
    }

    /*public Date getDateFact() {
        return dateFact;
    }

    public void setDateFact(Date dateFact) {
        this.dateFact = dateFact;
    }*/

    public String getEtatFact() {
        return etatFact;
    }

    public void setEtatFact(String etatFact) {
        this.etatFact = etatFact;
    }

    public String getRefc() {
        return refc;
    }

    public void setRefc(String refc) {
        this.refc = refc;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public int getIdcmd() {
        return idcmd;
    }

    public void setIdcmd(int idcmd) {
        this.idcmd = idcmd;
    }

    @Override
    public String toString() {
        return "ListeFact{" + "idFact=" + idFact 
                + ", etatFact=" + etatFact 
                + ", refc=" + refc 
                + ", total=" + total 
                + ", idcmd=" + idcmd 
                + '}';
    }
    
    
   
    
    
    
}
