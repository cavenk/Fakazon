package service;

import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import modele.Categorie;
import modele.Produit;

public class ProduitsDbServices {
	
	private DataSource dataSource;
	
	public ProduitsDbServices(DataSource theDataSource) {
		dataSource = theDataSource;
	}
	
	public List<Produit> getProduits() throws Exception {

	List<Produit> produit = new ArrayList<Produit>();

		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		
		try {
			connection = dataSource.getConnection();
			
			String sql = "select * from Produit";
			
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

	public List<Produit> getProduitByCategory(int categoryID) throws SQLException{
		Connection connection = null;

		try {
			connection = dataSource.getConnection();
			
			List<Produit> produit = new ArrayList<Produit>();

			String sql = "select * from Produit where idCategorie = " + categoryID;
			PreparedStatement statement = connection.prepareStatement(sql);

			// statement.setInt(1, categoryID);
			ResultSet resultSet = statement.executeQuery(sql);

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

		} catch(SQLException exception){
			if(!connection.isClosed())
				connection.close();

				throw exception;
		}
		

	}

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
		catch (Exception exc) {
			exc.printStackTrace();
		}
	}
	
	public void ajouterProduit(Produit produit) throws Exception {

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = dataSource.getConnection();
			
			String sql = "insert into produit "
					   + "(nom, prix, image, quantite, idCategorie) "
					   + "values (?, ?, ?, ?, ?)";
			
			preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setString(1, produit.getNom());
			preparedStatement.setDouble(2, produit.getPrix());
			preparedStatement.setString(3, produit.getImage());
			preparedStatement.setInt(4, produit.getQuantite());
			preparedStatement.setInt(5, produit.getIdCategorie());
			
			preparedStatement.execute();
		}
		finally {
			close(connection, preparedStatement, null);
		}
	}//ajouterProduit
	
	public Produit getProduit(int idProduit) throws Exception {
		
		Produit produit = null;
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = dataSource.getConnection();
			
			String sql = "select * from produit where idProduit=?";
			
			preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setInt(1, idProduit);
			
			resultSet = preparedStatement.executeQuery();
			
			if (resultSet.next()) {
				String nom = resultSet.getString("nom");
				double prix = resultSet.getDouble("prix");
				String image = resultSet.getString("image");
				int quantite = resultSet.getInt("quantite");
				int idCategorie = resultSet.getInt("idCategorie");
				
				produit = new Produit(idProduit, nom, prix, image, quantite, idCategorie);
			}
			else {
				throw new Exception("Le produit " + idProduit + " n'existe pas dans la BD");
			}
			return produit;
		}
		finally {
			close(connection, preparedStatement, resultSet);
		}
	}//getProduit
	
	public void modifierProduit(Produit produit) throws Exception {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = dataSource.getConnection();
			
			String sql = "update produit "
						+ "set nom=?, prix=?, image=?, quantite=?, idCategorie=? "
						+ "where idProduit=?";

			preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setString(1, produit.getNom());
			preparedStatement.setDouble(2, produit.getPrix());
			preparedStatement.setString(3, produit.getImage());
			preparedStatement.setInt(4, produit.getQuantite());
			preparedStatement.setInt(5, produit.getIdCategorie());
			preparedStatement.setInt(6, produit.getIdProduit());
			
			preparedStatement.execute();
		}
		finally {
			close(connection, preparedStatement, null);
		}
	}//modifierProduit
	
	public void supprimerProduit(int idProduit) throws Exception {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = dataSource.getConnection();
			
			String sql = "delete from produit where idProduit=?";
			
			preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setInt(1, idProduit);
			
			preparedStatement.execute();
		}
		finally {
			close(connection, preparedStatement, null);
		}
	}//supprimer
	
	public List<Categorie> getCategories() throws Exception {
		
		List<Categorie> categorie = new ArrayList<>();
		
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		
		try {
			connection = dataSource.getConnection();
			
			String sql = "select * from Categorie";
			
			statement = connection.createStatement();
			
			resultSet = statement.executeQuery(sql);
			
			while (resultSet.next()) {
				int idCategorie = resultSet.getInt("idCategorie");
				String nom = resultSet.getString("nom");
				String description = resultSet.getString("description");
				
				Categorie categorieTemp = new Categorie(idCategorie, nom, description);
				
				categorie.add(categorieTemp);
			}
			return categorie;
		}
		finally {
			close(connection, statement, resultSet);
		}
	}//getCategories()
	
	public Produit getNomCategorie(int idProduit) throws Exception {
		
		Produit produit = null;
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = dataSource.getConnection();
			
			String sql = "select Produit.idCategorie, Categorie.nom "
					+ "from Produit INNER JOIN Categorie ON Produit.idCategorie = Categorie.idCategorie "
					+ "where idProduit=?";
			
			preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setInt(1, idProduit);
			
			resultSet = preparedStatement.executeQuery();
			
			if (resultSet.next()) {
				int idCategorie = resultSet.getInt("idCategorie");
				String nom = resultSet.getString("nom");
				
				produit = new Produit(idCategorie, nom);
			}
			else {
				throw new Exception("Le produit " + idProduit + " n'existe pas dans la BD");
			}
			return produit;
		}
		finally {
			close(connection, preparedStatement, resultSet);
		}
		
	}//getNomCategorie()
}
