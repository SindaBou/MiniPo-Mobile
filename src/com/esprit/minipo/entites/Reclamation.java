/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.minipo.entites;

//import java.sql.Date;
import java.util.Objects;
import javafx.scene.control.Button;

/**
 *
 * @author House
 */
public class Reclamation {
    private int idR;
    private int idcmd;
    private int id;
    private int idcatrec;
    private String objet;
    private String description;
    private String  etatr;
    private String nom;
    private String firstname;
    private String lastname;
    //private Date dateR;
    //private Button button;
    //private User client;

    public Reclamation(int idcatrec, String objet, String description) {
        this.idcatrec = idcatrec;
        this.objet = objet;
        this.description = description;
    }
 /*public Reclamation(int idR, int idcatrec, String objet, String description, String etatr, String nom, String prenom, Date dateR) {
        this.idR = idR;
        this.idcatrec = idcatrec;
        this.objet = objet;
        this.description = description;
        this.etatr = etatr;
        this.dateR = dateR;
        //this.button=new Button("traiter");
    }*/
   /* public Reclamation(int idR, int idcatrec, String objet, String description, String etatr, String nom, String prenom, Date dateR,Button button) {
        this.idR = idR;
        this.idcatrec = idcatrec;
        this.objet = objet;
        this.description = description;
        this.etatr = etatr;
        this.dateR = dateR;
        //this.button=new Button("traiter");
    }*/

   /* public Reclamation(int idcatrec, String objet, String description, String etatr, Date dateR) {
        this.idcatrec = idcatrec;
        this.objet = objet;
        this.description = description;
        this.etatr = etatr;
        this.dateR = dateR;
    }*/
    

    /*public User getClient() {
        return client;
    }

    public void setClient(User client) {
        this.client = client;
    }*/

  /*  public Reclamation(int idR, int idclt, int idcmd, int idcatrec, String objet, String description, String etatr, String nom, String prenom, Date dateR) {
        this.idR = idR;
        this.id = idclt;
        this.idcmd = idcmd;
        this.idcatrec =idcatrec;
        this.objet = objet;
        this.description = description;
        this.etatr = etatr;
        this.dateR = dateR;
        //this.client = client;
        //this.firstname=nom;
        //this.lastname=prenom;
        
        
    }*/

   /* public Reclamation(int idR, int idcatrec, String objet, String description, String etatr, Date dateR, User client) {
        this.idR = idR;
        this.idcatrec =idcatrec;
        this.objet = objet;
        this.description = description;
        this.etatr = etatr;
        this.dateR = dateR;
        //this.client = client;
    }*/

   
    

   /* public Reclamation(int idR, int idclt, int idcmd, String description, Date dateR, String etat) {
        this.idR = idR;
        //this.idclt = idclt;
        this.idcmd = idcmd;
        this.description = description;
        this.dateR = dateR;
        this.etatr = etat;
    }*/

   /* public Reclamation(int idclt, int idcmd, String description, Date dateR, String etat) {
        ///this.idclt = idclt;
        this.idcmd = idcmd;
        this.description = description;
        this.dateR = dateR;
        this.etatr = etat;
    }*/

    public Reclamation(int idR, int idclt, int idcmd, String description, String etatr) {
        this.idR = idR;
        //this.idclt = idclt;
        this.idcmd = idcmd;
        this.description = description;
        this.etatr = etatr;
    }
    

    public Reclamation() {
    }

   /* public Reclamation(int idr, String description, java.util.Date dater, String etatr, int idclt, int idcmd) {
        this.idR = idR;
        this.description = description;
        this.dateR = dateR;
        this.etatr = etatr;
        //this.idclt = idclt;
        this.idcmd = idcmd;
        
        
        
       
    }*/

    public Reclamation(int idcatrec, String text, String text0, int id) {
        this.idcatrec=idcatrec;
        this.objet=objet;
        this.description=description;
        this.id=id;
    }
//constructeur modifier 
    /*public Reclamation(int idr, String nom, String objet, String description, String etatr, String firstname, String lastname, Date dateR) {
        this.idR=idr;
        this.nom=nom;
        this.objet=objet;
        this.description=description;
        this.etatr=etatr;
        this.firstname=firstname;
        this.lastname=lastname;
        this.dateR=dateR;
        
    }*/

    public int getIdcatrec() {
        return idcatrec;
    }

    public void setIdcatrec(int idcatrec) {
        this.idcatrec = idcatrec;
    }

    

   

    public String getObjet() {
        return objet;
    }

    public void setObjet(String objet) {
        this.objet = objet;
    }
    

    public int getIdR() {
        return idR;
    }

   

    public int getIdcmd() {
        return idcmd;
    }

    public String getDescription() {
        return description;
    }

   /* public Date getDateR() {
        return dateR;
    }*/

    public String getEtatr() {
        return etatr;
    }

    public void setIdR(int idR) {
        this.idR = idR;
    }

   

    public void setIdcmd(int idcmd) {
        this.idcmd = idcmd;
    }

    public void setDescription(String description) {
        this.description = description;
    }

   /* public void setDateR(Date dateR) {
        this.dateR = dateR;
    }*/

    public void setEtat(String etat) {
        this.etatr = etat;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
    
    

    @Override
    public String toString() {
        return "Reclamation{" + "idR=" + idR + ", idcmd=" + idcmd + ", description=" + description +/* ", dateR=" + dateR +*/ ", etat=" + etatr + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Reclamation other = (Reclamation) obj;
        if (!Objects.equals(this.etatr, other.etatr)) {
            return false;
        }
        return true;
    }

    


    
}
