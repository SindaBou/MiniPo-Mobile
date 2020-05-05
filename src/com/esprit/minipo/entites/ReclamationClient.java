/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.minipo.entites;

//import java.sql.Date;

/**
 *
 * @author darra
 */
public class ReclamationClient {
     private int idR;
    //private int idcmd;
    private int id;
    private int idcatrec;
    private String nom;
    private String objet;
    private String description;
    private String  etatr;
    private String firstname;
    private String lastname;
    private String reponse;
    private String image;
   // private Date dateR;

    public ReclamationClient(int idR, int id, int idcatrec, String nom, String objet, String description, String etatr, String firstname, String lastname, String reponse/*, Date dateR*/) {
        this.idR = idR;
        this.id = id;
        this.idcatrec = idcatrec;
        this.nom = nom;
        this.objet = objet;
        this.description = description;
        this.etatr = etatr;
        this.firstname = firstname;
        this.lastname = lastname;
        this.reponse = reponse;
        //this.dateR = dateR;
    }

    public ReclamationClient(int idR,  int idcatrec, String objet, String description, String etatr, String firstname, String lastname/*, Date dateR*/) {
        this.idR = idR;
       // this.idcmd = idcmd;
        this.idcatrec = idcatrec;
        this.objet = objet;
        this.description = description;
        this.etatr = etatr;
        this.firstname = firstname;
        this.lastname = lastname;
        ///this.dateR = dateR;
    }

    public ReclamationClient(int idR, int idcatrec, String objet, String description, String etatr, String firstname, String lastname, String reponse/*,Date dateR*/) {
        this.idR = idR;
        this.idcatrec =idcatrec;
        this.objet = objet;
        this.description = description;
        this.etatr = etatr;
        this.firstname = firstname;
        this.lastname = lastname;
        this.reponse = reponse;
        //this.dateR = dateR;
    }

    public ReclamationClient() {
    }

 
//constructeuuuur ajouter
    
    

    public ReclamationClient(int idcatrec, String objet, String description, int id,String image) {
        this.idcatrec =idcatrec;
        this.objet = objet;
        this.description = description;
        this.id=id;
        this.image=image;
        
    }

    public ReclamationClient(int idr,String nom, String objet, String description, String etatr, String firstname, String lastname, /*Date dateR,*/ String reponse) {
                 this.idR=idr;
                 this.nom=nom;
                 this.objet=objet;
                 this.description=description;
                 this.etatr=etatr;
                 this.firstname=firstname;
                 this.lastname=lastname;
                 //this.dateR=dateR;
                 this.reponse=reponse;
    }

    public ReclamationClient(int idr, String nom, String objet, String description, String etatr, String firstname, String lastname /*Date dateR*/) {
    }

   /*public ReclamationClient(int idr, String nom, String objet, String description, String etatr/*Date dateR) {
        this.idR=idR;
        this.nom=nom;
        this.objet=objet;
        this.description=description;
        this.etatr=etatr;
        //this.dateR=dateR;
    }*/

   

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getReponse() {
        return reponse;
    }

    public void setReponse(String reponse) {
        this.reponse = reponse;
    }
     
    public int getIdR() {
        return idR;
    }

    public void setIdR(int idR) {
        this.idR = idR;
    }

    public int getIdcatrec() {
        return idcatrec;
    }

    public void setIdcatrec(int idcatrec) {
        this.idcatrec = idcatrec;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

   

   

    public String getObjet() {
        return objet;
    }

    public void setObjet(String objet) {
        this.objet = objet;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEtatr() {
        return etatr;
    }

    public void setEtatr(String etatr) {
        this.etatr = etatr;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
    

   /*/* public Date getDateR() {
        return dateR;
    }

    public void setDateR(Date dateR) {
        this.dateR = dateR;
    }*/

    @Override
    public String toString() {
        return "ReclamationClient{" + "idR=" + idR +  ", idcatrec=" + idcatrec + ", objet =" + objet + ", description =" + description + ", etatr=" + etatr 
        +",nom: "+nom+",id : "+id+"image="+image       //+ ", dateR=" + dateR
                + '}';
    }
   
    
    
}
