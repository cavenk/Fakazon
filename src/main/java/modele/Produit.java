package modele;

import java.sql.Date;

public class Produit {
	
	private int idProduit;
	private String nom;
	private double prix;
	private String image;
	private int quantite;
	private int idCategorie;
	
	
	public int getIdProduit() {
		return idProduit;
	}
	public void setIdProduit(int idProduit) {
		this.idProduit = idProduit;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public int getQuantite() {
		return quantite;
	}
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	public int getIdCategorie() {
		return idCategorie;
	}
	public void setIdCategorie(int idCategorie) {
		this.idCategorie = idCategorie;
	}
	@Override
	public String toString() {
		return "Produit [idProduit=" + idProduit + ", nom=" + nom + ", prix=" + prix + ", image=" + image
				+ ", quantite=" + quantite + ", idCategorie=" + idCategorie + "]";
	}
	
	
	
}//Produit
