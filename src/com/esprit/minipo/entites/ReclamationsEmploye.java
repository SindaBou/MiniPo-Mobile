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
public class ReclamationsEmploye {
    
     private int idRemp ;
    private int id;
   private int idcatrecemp;
    private String nom;
    private String objet;
    private String description;
   // private Date dateRemp;
    private String etatRemp;
    private String firstname;
    private String lastname ;
    private String reponse;
    private String image;

    /*public ReclamationsEmploye(int idRemp, int id, int idcatrecemp, String objet, String description, Date dateRemp, String etatRemp, String firstname, String lastname, String reponse) {
        this.idRemp = idRemp;
        this.id = id;
        this.idcatrecemp = idcatrecemp;
        this.objet = objet;
        this.description = description;
        this.dateRemp = dateRemp;
        this.etatRemp = etatRemp;
        this.firstname = firstname;
        this.lastname = lastname;
        this.reponse = reponse;
    }*/

   

    /*public ReclamationsEmploye(int idRemp, int id, String objet, String description, Date dateRemp, String etatRemp, String firstname, String lastname) {
        this.idRemp = idRemp;
        this.id = id;
        this.objet = objet;
        this.description = description;
        this.dateRemp = dateRemp;
        this.etatRemp = etatRemp;
        this.firstname = firstname;
        this.lastname = lastname;
    }*/

   /* public ReclamationsEmploye(String objet, String description,  String etatRemp, Date dateRemp,String reponse) {
        this.objet = objet;
        this.description = description;
        this.dateRemp = dateRemp;
        this.etatRemp = etatRemp;
        this.reponse = reponse;
    }*/

   /* public ReclamationsEmploye(int idRemp, String objet, String description, Date dateRemp, String etatRemp, String firstname, String lastname) {
        this.idRemp = idRemp;
        this.objet = objet;
        this.description = description;
        this.dateRemp = dateRemp;
        this.etatRemp = etatRemp;
        this.firstname = firstname;
        this.lastname = lastname;
    }*/

   /* public ReclamationsEmploye(int idRemp, String objet, String description, Date dateRemp, String firstname, String lastname) {
        this.idRemp = idRemp;
        this.objet = objet;
        this.description = description;
        this.dateRemp = dateRemp;
        this.firstname = firstname;
        this.lastname = lastname;
    }*/

    /*public ReclamationsEmploye(int idRemp, String objet, String description, String etatr, String firstname, String lastname, Date dateRemp) {
        this.idRemp = idRemp;
        this.objet = objet;
        this.description = description;
        this.etatRemp = etatRemp;
        this.firstname = firstname;
        this.lastname = lastname;
        this.dateRemp = dateRemp;
    }
*/
   /* public ReclamationsEmploye(int idRemp, String nom, String objet, String description, String etatr, String firstname, String lastname, Date dateRemp) {

            this.idRemp=idRemp;
            this.nom=nom;
            this.objet=objet;
            this.description=description;
            this.etatRemp=etatr;
            this.firstname=firstname;
            this.lastname=lastname;
            this.dateRemp=dateRemp;


    }*/
    

    public ReclamationsEmploye(int id, int idcatrecemp, String objet, String description) {
        this.id = id;
        this.idcatrecemp = idcatrecemp;
        this.objet = objet;
        this.description = description;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getIdcatrecemp() {
        return idcatrecemp;
    }

    public void setIdcatrecemp(int idcatrecemp) {
        this.idcatrecemp = idcatrecemp;
    }

    public ReclamationsEmploye() {
        
    }

    public String getReponse() {
        return reponse;
    }

    public void setReponse(String reponse) {
        this.reponse = reponse;
    }

    public int getIdRemp() {
        return idRemp;
    }

    public void setIdRemp(int idRemp) {
        this.idRemp = idRemp;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

   /* public Date getDateRemp() {
        return dateRemp;
    }

    public void setDateRemp(Date dateRemp) {
        this.dateRemp = dateRemp;
    }*/

    public String getEtatRemp() {
        return etatRemp;
    }

    public void setEtatRemp(String etatRemp) {
        this.etatRemp = etatRemp;
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

    @Override
    public String toString() {
        return "ReclamationsEmploye{" + "idRemp=" + idRemp + ", id=" + id + ", idcatrecemp=" + idcatrecemp + ", nom=" + nom + ", objet=" + objet + ", description=" + description + ", etatRemp=" + etatRemp + ", reponse=" + reponse + ", image=" + image + '}';
    }

    
    
    
    
    
    
}
