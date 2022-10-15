package modele;

import java.sql.Date;

public class Utilisateur {

	private int idUtilisateur;
	private String prenom;
	private String nom;
	private Date dateNaissance;
	private String telephone;
	private String courriel;
	private String motPass;
	private String adresse;
	private String ville;
	private String province;
	private String pays;
	private String codePostal;
	private int idRole;
	private int idAdresseLivraison;

	
	public Utilisateur(int idUtilisateur, String prenom, String nom, Date dateNaissance, String telephone,
			String courriel, String motPass, String adresse, String ville, String province, String pays,
			String codePostal, int idRole, int idAdresseLivraison) {
		
		this.idUtilisateur = idUtilisateur;
		this.prenom = prenom;
		this.nom = nom;
		this.dateNaissance = dateNaissance;
		this.telephone = telephone;
		this.courriel = courriel;
		this.motPass = motPass;
		this.adresse = adresse;
		this.ville = ville;
		this.province = province;
		this.pays = pays;
		this.codePostal = codePostal;
		this.idRole = idRole;
		this.idAdresseLivraison = idAdresseLivraison;
		
	}//Constructeur Utilisateur
	
	
	//Getters & Setters
	
	public int getIdUtilisateur() {
		return idUtilisateur;
	}
	public void setIdUtilisateur(int idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public Date getDateNaissance() {
		return dateNaissance;
	}
	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getCourriel() {
		return courriel;
	}
	public void setCourriel(String courriel) {
		this.courriel = courriel;
	}
	public String getMotPass() {
		return motPass;
	}
	public void setMotPass(String motPass) {
		this.motPass = motPass;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getPays() {
		return pays;
	}
	public void setPays(String pays) {
		this.pays = pays;
	}
	public String getCodePostal() {
		return codePostal;
	}
	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}
	public int getIdRole() {
		return idRole;
	}
	public void setIdRole(int idRole) {
		this.idRole = idRole;
	}
	public int getIdAdresseLivraison() {
		return idAdresseLivraison;
	}
	public void setIdAdresseLivraison(int idAdresseLivraison) {
		this.idAdresseLivraison = idAdresseLivraison;
	}

	@Override
	public String toString() {
		return "Utilisateur [idUtilisateur=" + idUtilisateur + ", prenom=" + prenom + ", nom=" + nom
				+ ", dateNaissance=" + dateNaissance + ", telephone=" + telephone + ", courriel=" + courriel
				+ ", motPass=" + motPass + ", adresse=" + adresse + ", ville=" + ville + ", province=" + province
				+ ", pays=" + pays + ", codePostal=" + codePostal + ", idRole=" + idRole + ", idAdresseLivraison="
				+ idAdresseLivraison + "]";
	}

}//Utilisateur
