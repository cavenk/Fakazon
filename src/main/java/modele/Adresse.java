package modele;

public class Adresse {

	private Integer idAdresse;
	private String adresse;
	private String ville;
	private String province;
	private String pays;
	private String codePostal;

	public Adresse(Integer idAdresse, String adresse, String ville, String province, String pays, String codePostal) {
		this.idAdresse = idAdresse;
		this.adresse = adresse;
		this.ville = ville;
		this.province = province;
		this.pays = pays;
		this.codePostal = codePostal;

	}//Constructeur AdresseLivraison

	public Adresse(String adresse, String ville, String province, String pays, String codePostal){
		this(null, adresse, ville, province, pays, codePostal);
	}


	//Getters & Setters
	public Integer getIdAdresse() {
		return idAdresse;
	}
	public void setIdAdresse(int idAdresse) {
		this.idAdresse = idAdresse;
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
		return "AdresseLivraison [idAdresse=" + idAdresse + ", adresse=" + adresse + ", ville="
				+ ville + ", province=" + province + ", pays=" + pays + ", codePostal=" + codePostal + "]";
	}




}
