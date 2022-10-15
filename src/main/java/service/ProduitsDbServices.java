package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;

import modele.Produit;

public class ProduitsDbServices {

	private DataSource dataSource;
	
	public ProduitsDbServices(DataSource theDataSource){
		
		dataSource = theDataSource;
		
	}//Constructeur
	
	
	public List<Produit> getProduits() throws Exception {
	
	List<Produit> produit = new ArrayList<>();
		
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		
		try {
			connection = dataSource.getConnection();
			
			String sql = "select * from Produit order by idProduit";
			
			statement = connection.createStatement();
			
			resultSet = statement.executeQuery(sql);
			
			while (resultSet.next()) {
				
				int idProduit = resultSet.getInt("idProduit");
				String nom = resultSet.getString("nom");
				double prix = resultSet.getDouble("prix");
				String image = resultSet.getString("image");
				int quantite = resultSet.getInt("quantite");
				int idCategorie = resultSet.getInt("idCategorie");
				
				Produit produitTemp = new Produit(idProduit, nom, prix, image, quantite, idCategorie);
				
				produit.add(produitTemp);				
			}
			
			return produit;		
		}
		finally {
			close(connection, statement, resultSet);
		}
	}//getProduits()
	
	private void close(Connection connection, Statement statement, ResultSet resultSet) {

		try {
			if (resultSet != null) {
				resultSet.close();
			}
			
			if (statement != null) {
				statement.close();
			}
			
			if (connection != null) {
				connection.close();
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}//close()
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}//ProduitsDbServices
