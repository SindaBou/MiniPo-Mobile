package com.esprit.minipo.entites;

public class CategorieReclamationEmp {

	private int idcatrecemp;
	private String nom;

    public CategorieReclamationEmp(int idcatrecemp, String nom) {
        this.idcatrecemp = idcatrecemp;
        this.nom = nom;
    }

    public CategorieReclamationEmp() {
    }

    public CategorieReclamationEmp(String nom) {
        this.nom = nom;
    }

    public int getIdcatrecemp() {
        return idcatrecemp;
    }

    public void setIdcatrecemp(int idcatrecemp) {
        this.idcatrecemp = idcatrecemp;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public String toString() {
        return "CategorieReclamationEmp{" + "idcatrecemp=" + idcatrecemp + ", nom=" + nom + '}';
    }

   
	
	
	
	
	
	
}
