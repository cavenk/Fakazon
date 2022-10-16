package modele;

import java.sql.Date;

public class Commande {

	private int nCommande;
	private Date date;
	private double prixTotal;
	private int idProduit;
	private int idUtilisateur;
	private int idPanier;

	public Commande(int nCommande, Date date, double prixTotal, int idProduit, int idUtilisateur, int idPanier) {

		this.nCommande = nCommande;
		this.date = date;
		this.prixTotal = prixTotal;
		this.idProduit = idProduit;
		this.idUtilisateur = idUtilisateur;
		this.idPanier = idPanier;
	}//Constructeur Commande


	//Getters & Setters

	public int getnCommande() {
		return nCommande;
	}
	public void setnCommande(int nCommande) {
		this.nCommande = nCommande;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public double getPrixTotal() {
		return prixTotal;
	}
	public void setPrixTotal(double prixTotal) {
		this.prixTotal = prixTotal;
	}
	public int getIdProduit() {
		return idProduit;
	}
	public void setIdProduit(int idProduit) {
		this.idProduit = idProduit;
	}
	public int getIdUtilisateur() {
		return idUtilisateur;
	}
	public void setIdUtilisateur(int idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}
	public int getIdPanier() {
		return idPanier;
	}
	public void setIdPanier(int idPanier) {
		this.idPanier = idPanier;
	}


	@Override
	public String toString() {
		return "Commande [nCommande=" + nCommande + ", date=" + date + ", prixTotal=" + prixTotal + ", idProduit="
				+ idProduit + ", idUtilisateur=" + idUtilisateur + ", idPanier=" + idPanier + "]";
	}



}
