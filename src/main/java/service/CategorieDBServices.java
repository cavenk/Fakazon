package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import modele.Categorie;

public class CategorieDBServices {

	private DataSource dataSource;
	
	public CategorieDBServices(DataSource theDataSource) {
		dataSource = theDataSource;
	}
	
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
	}//close()
	
	public void ajouterCategorie(Categorie categorie)throws Exception {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = dataSource.getConnection();
			
			String sql = "insert into Categorie "
					   + "(nom, description) "
					   + "values (?, ?)";
			
			preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setString(1, categorie.getNom());
			preparedStatement.setString(2, categorie.getDescription());
			
			preparedStatement.execute();
		}
		finally {
			close(connection, preparedStatement, null);
		}
	}//ajouterCategorie
	
	public Categorie getCategorie(int idCategorie) throws Exception {
		
		Categorie categorie = null;
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = dataSource.getConnection();
			
			String sql = "select * from categorie where idCategorie=?";
			
			preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setInt(1, idCategorie);
			
			resultSet = preparedStatement.executeQuery();
			
			if (resultSet.next()) {
				String nom = resultSet.getString("nom");
				String description = resultSet.getString("description");
				
				categorie = new Categorie(idCategorie, nom, description);
			}
			else {
				throw new Exception("La categorie " + idCategorie + " n'existe pas dans la BD");
			}
			return categorie;
		}
		finally {
			close(connection, preparedStatement, resultSet);
		}
	}//getCategorie()
	
	public void modifierCategorie(Categorie categorie) throws Exception {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = dataSource.getConnection();
			
			String sql = "update categorie "
						+ "set nom=?, description=? "
						+ "where idCategorie=?";

			preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setString(1, categorie.getNom());
			preparedStatement.setString(2, categorie.getDescription());
			preparedStatement.setInt(3, categorie.getIdCategorie());
			
			preparedStatement.execute();
		}
		finally {
			close(connection, preparedStatement, null);
		}
	}//modifierCategorie()
	
	public void supprimerCategorie(int idCategorie) throws Exception {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = dataSource.getConnection();
			
			String sql = "delete from categorie where idCategorie=?";
			
			preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setInt(1, idCategorie);
			
			preparedStatement.execute();
		}
		finally {
			close(connection, preparedStatement, null);
		}
	}//supprimerCategorie()
	
}
