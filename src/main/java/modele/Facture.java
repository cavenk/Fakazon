package modele;

import java.sql.Date;

public class Facture {

	private int idFacture;
	private Date dateFacture;
	private int idUtilisateur;
	
	public Facture(int idFacture, Date dateFacture, int idUtilisateur) {
		this.idFacture = idFacture;
		this.dateFacture = dateFacture;
		this.idUtilisateur = idUtilisateur;
	}// Constructeur

	
	// Getters & Setters
	
	public int getIdFacture() {
		return idFacture;
	}

	public void setIdFacture(int idFacture) {
		this.idFacture = idFacture;
	}

	public Date getDateFacture() {
		return dateFacture;
	}

	public void setDateFacture(Date dateFacture) {
		this.dateFacture = dateFacture;
	}

	public int getIdUtilisateur() {
		return idUtilisateur;
	}

	public void setIdUtilisateur(int idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}

	@Override
	public String toString() {
		return "Facture [idFacture=" + idFacture + ", dateFacture=" + dateFacture + ", idUtilisateur=" + idUtilisateur
				+ "]";
	}
	
	
	
	

}
