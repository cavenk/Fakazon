package modele;

public class Panier {

	private int idPanier;
	private int idUtilisateur;
	private int idProduit;
	
	public Panier(int idPanier, int idUtilisateur, int idProduit) {
		this.idPanier = idPanier;
		this.idUtilisateur = idUtilisateur;
		this.idProduit = idProduit;
		
	}//Constructeur Panier
	
	
	//Getters & Setters
	
	public int getIdPanier() {
		return idPanier;
	}
	public void setIdPanier(int idPanier) {
		this.idPanier = idPanier;
	}
	public int getIdUtilisateur() {
		return idUtilisateur;
	}
	public void setIdUtilisateur(int idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}
	public int getIdProduit() {
		return idProduit;
	}
	public void setIdProduit(int idProduit) {
		this.idProduit = idProduit;
	}
	@Override
	public String toString() {
		return "Panier [idPanier=" + idPanier + ", idUtilisateur=" + idUtilisateur + ", idProduit=" + idProduit + "]";
	}



}
