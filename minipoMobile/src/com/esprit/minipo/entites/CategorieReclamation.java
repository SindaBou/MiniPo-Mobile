package com.esprit.minipo.entites;

public class CategorieReclamation {

	private int idcatrec;
	private String nom;

    public CategorieReclamation(int idcatrec, String nom) {
        this.idcatrec = idcatrec;
        this.nom = nom;
    }

    public CategorieReclamation(String nom) {
        this.nom = nom;
    }

    public CategorieReclamation() {
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

    @Override
    public String toString() {
        return "CategorieReclamation{" + "idcatrec=" + idcatrec + ", nom=" + nom + '}';
    }
	
	
	
	
	
	
	
}
