package modele;

import java.sql.Date;

public class Utilisateur {

	private Integer idUtilisateur;
	private String prenom;
	private String nom;
	private Date dateNaissance;
	private String telephone;
	private String courriel;
	private String motPass;
	private Integer idRole;
	private Integer idAdresse;
	private Integer idAdresseLivraison;


	public Utilisateur(Integer idUtilisateur, String prenom, String nom, Date dateNaissance, String telephone,
			String courriel, String motPass, Integer idRole, Integer idAdresse, Integer idAdresseLivraison) {

		this.idUtilisateur = idUtilisateur;
		this.prenom = prenom;
		this.nom = nom;
		this.dateNaissance = dateNaissance;
		this.telephone = telephone;
		this.courriel = courriel;
		this.motPass = motPass;
		this.idRole = idRole;
		this.idAdresse = idAdresse;
		this.idAdresseLivraison = idAdresseLivraison;


	}//Constructeur Utilisateur

	public Utilisateur(String prenom, String nom, Date dateNaissance, String telephone,
			String courriel, String motPass) {

			this(null, prenom, nom, dateNaissance, telephone, courriel, motPass, 2, null, null);

	}


	//Getters & Setters
	public Integer getIdUtilisateur() {
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
	
	public Integer getIdRole() {
		return idRole;
	}
	public void setIdRole(int idRole) {
		this.idRole = idRole;
	}

	public Integer getIdAdresse(){
		return idAdresse;
	}
	public void setIdAdresse(int idAdresse){
		this.idAdresse = idAdresse;
	}
	public Integer getIdAdresseLivraison() {
		return idAdresseLivraison;
	}
	public void setIdAdresseLivraison(int idAdresseLivraison) {
		this.idAdresseLivraison = idAdresseLivraison;
	}

	@Override
	public String toString() {
		return "Utilisateur [idUtilisateur=" + idUtilisateur + ", prenom=" + prenom + ", nom=" + nom
				+ ", dateNaissance=" + dateNaissance + ", telephone=" + telephone + ", courriel=" + courriel
				+ ", motPass=" + motPass + ", idRole=" + idRole + ", idAdresse=" + idAdresse + ", idAdresseLivraison="
				+ idAdresseLivraison + "]";
	}

}//Utilisateur
