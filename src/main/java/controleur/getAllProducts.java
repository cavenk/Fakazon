package controleur;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;
import modele.*;

public class getAllProducts {
	private Connection con;
	private String query;
	private PreparedStatement prepStmt;
	private ResultSet rs;
	
	public getAllProducts(Connection con) {
		super();
		this.con = con;
	}
	
	public List<Products> getProducts() {
		
	}

}
