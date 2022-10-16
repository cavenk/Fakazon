package modele;

public class Role {

	private int idRole;
	private String role;

	public Role(int idRole, String role) {
		this.idRole = idRole;
		this.role = role;

	}//Constructeur Role


	//Getters & Setters

	public int getIdRole() {
		return idRole;
	}

	public void setIdRole(int idRole) {
		this.idRole = idRole;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}


	@Override
	public String toString() {
		return "Role [idRole=" + idRole + ", role=" + role + "]";
	}



}
