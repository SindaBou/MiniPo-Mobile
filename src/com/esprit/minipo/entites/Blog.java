/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.minipo.entites;

/**
 *
 * @author ASUS
 */
public class Blog {
    
    private int idA;
    private String titre;
    private User id;
    private String description;
    private String date;
    private String imagename;
    private String lastname;
    private String firstname;

    public Blog(int idA, String titre, User id, String description, String date, String imagename, String lastname, String firstname) {
        this.idA = idA;
        this.titre = titre;
        this.id = id;
        this.description = description;
        this.date = date;
        this.imagename = imagename;
        this.lastname = lastname;
        this.firstname = firstname;
    }

    public Blog() {
    }

    
    
    
    @Override
    public String toString() {
        return "Blog{" + "idA=" + idA + ", titre=" + titre + ", id=" + id + ", description=" + description + ", date=" + date + ", imagename=" + imagename + ", lastname=" + lastname + ", firstname=" + firstname + '}';
    }
    
    

    public int getIdA() {
        return idA;
    }

    public void setIdA(int idA) {
        this.idA = idA;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public User getId() {
        return id;
    }

    public void setId(User id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String image) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getImagename() {
        return imagename;
    }

    public void setImagename(String imagename) {
        this.imagename = imagename;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
    
    
    
}
