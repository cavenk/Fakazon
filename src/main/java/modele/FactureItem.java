package modele;

public class FactureItem {
	
	private int idFactureItem;
	private int idProduit;
	private int idFacture;
	private int quantiteParItem;
		
	public FactureItem(int idFactureItem, int idProduit, int idFacture, int quantiteParItem) {
		this.idFactureItem = idFactureItem;
		this.idProduit = idProduit;
		this.idFacture = idFacture;
		this.quantiteParItem = quantiteParItem;
	}// Constructeur

	
	// Getters & Setters
	public int getIdFactureItem() {
		return idFactureItem;
	}

	public void setIdFactureItem(int idFactureItem) {
		this.idFactureItem = idFactureItem;
	}

	public int getIdProduit() {
		return idProduit;
	}

	public void setIdProduit(int idProduit) {
		this.idProduit = idProduit;
	}

	public int getIdFacture() {
		return idFacture;
	}

	public void setIdFacture(int idFacture) {
		this.idFacture = idFacture;
	}

	public int getQuantiteParItem() {
		return quantiteParItem;
	}

	public void setQuantiteParItem(int quantiteParItem) {
		this.quantiteParItem = quantiteParItem;
	}


	@Override
	public String toString() {
		return "FactureItem [idFactureItem=" + idFactureItem + ", idProduit=" + idProduit + ", idFacture=" + idFacture
				+ ", quantiteParItem=" + quantiteParItem + "]";
	}

}
