package service;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import modele.Facture;
import modele.Produit;

public class FacturesDbServices {
	
	private DataSource dataSource;

	public FacturesDbServices(DataSource theDataSource){

		dataSource = theDataSource;

	}//Constructeur
	

	public List<Facture> getFactures() throws Exception {

	List<Facture> facture = new ArrayList<>();

		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;

		try {
			connection = dataSource.getConnection();

			String sql = "select * from Facture order by idFacture";

			statement = connection.createStatement();

			resultSet = statement.executeQuery(sql);

			while (resultSet.next()) {

				int idFacture = resultSet.getInt("idFacture");
				Date dateFacture = resultSet.getDate("dateFacture");
				int idUtilisateur = resultSet.getInt("idUtilisateur");

				Facture factureTemp = new Facture(idFacture, dateFacture, idUtilisateur);

				facture.add(factureTemp);
			}

			return facture;
		}
		finally {
			close(connection, statement, resultSet);
		}
	}//getFactures()

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
	
	
	public void ajouterFacture(Facture facture) throws Exception {

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = dataSource.getConnection();
			
			String sql = "insert into Facture "
					   + "(idFacture, dateFacture, idUtilisateur) "
					   + "values (?, ?, ?)";
			
			preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setInt(1, facture.getIdFacture());
			preparedStatement.setDate(2, facture.getDateFacture());
			preparedStatement.setInt(3, facture.getIdUtilisateur());
			
			preparedStatement.execute();
		}
		finally {
			close(connection, preparedStatement, null);
		}
	}


}
