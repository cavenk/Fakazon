package modele;

public class AdresseLivraison {

	private int idAdresseLivraison;
	private String adresse;
	private String ville;
	private String province;
	private String pays;
	private String codePostal;

	public AdresseLivraison(int idAdresseLivraison, String adresse, String ville, String province, String pays,
			String codePostal) {
		this.idAdresseLivraison = idAdresseLivraison;
		this.adresse = adresse;
		this.ville = ville;
		this.province = province;
		this.pays = pays;
		this.codePostal = codePostal;

	}//Constructeur AdresseLivraison


	//Getters & Setters

	public int getIdAdresseLivraison() {
		return idAdresseLivraison;
	}
	public void setIdAdresseLivraison(int idAdresseLivraison) {
		this.idAdresseLivraison = idAdresseLivraison;
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


	@Override
	public String toString() {
		return "AdresseLivraison [idAdresseLivraison=" + idAdresseLivraison + ", adresse=" + adresse + ", ville="
				+ ville + ", province=" + province + ", pays=" + pays + ", codePostal=" + codePostal + "]";
	}




}
