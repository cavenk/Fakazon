package service;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import modele.Facture;
import modele.FactureItem;

public class FactureItemDbServices {
	
	private DataSource dataSource;

	public FactureItemDbServices(DataSource theDataSource){

		dataSource = theDataSource;

	}//Constructeur
	

	public List<FactureItem> getFactureItems() throws Exception {

	List<FactureItem> factureItem = new ArrayList<>();

		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;

		try {
			connection = dataSource.getConnection();

			String sql = "select * from FactureItem order by idFactureItem";

			statement = connection.createStatement();

			resultSet = statement.executeQuery(sql);

			while (resultSet.next()) {

				int idFactureItem = resultSet.getInt("idFactureItem");
				int idProduit = resultSet.getInt("idProduit");
				int idFacture = resultSet.getInt("idFacture");
				int quantiteParItem = resultSet.getInt("quantiteParItem");

				FactureItem factureItemTemp = new FactureItem(idFactureItem, idProduit, idFacture,quantiteParItem);

				factureItem.add(factureItemTemp);
			}

			return factureItem;
		}
		finally {
			close(connection, statement, resultSet);
		}
	}//getFactureItems()

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

}
