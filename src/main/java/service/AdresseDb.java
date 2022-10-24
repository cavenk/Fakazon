package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import modele.Adresse;

public class AdresseDb {

    private DataSource dataSource;

    public AdresseDb(DataSource dataSource){
        this.dataSource = dataSource;
    }

    public Adresse getAdresse(int idAdresse) throws SQLException{
        Connection connection = null;

        try{
            String query = "SELECT * FROM Adresse WHERE idAdresse=? LIMIT 1";

            connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, idAdresse);

            ResultSet result = statement.executeQuery();
            result.next();

            return convertToAdresse(result);

        } catch(Exception exception){
            if(connection != null)
                connection.close();

            throw exception;
        }

    }

    /* Function to be used with transactions.
     * It creates a statement and returns the id of the row
     */
    public static int createStatement(Connection connection, Adresse adresse) throws SQLException{
        String query = 
            "INSERT INTO adresse (adresse, ville, province, pays, codePostal)" +
            "VALUES (?,?,?,?,?)";

        PreparedStatement statement = connection.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);

        // Save adresse to database
        statement.setString(1, adresse.getAdresse());
        statement.setString(2, adresse.getVille());
        statement.setString(3, adresse.getProvince());
        statement.setString(4, adresse.getPays());
        statement.setString(5, adresse.getCodePostal());
        statement.executeUpdate();

        // Get adresse ID and return it
        ResultSet resultSet = statement.getGeneratedKeys();
        resultSet.next();

        return resultSet.getInt(1);
    }

    /* Function to be used with transactions.
    * It creates a statement for updating adresse
    */
    public static void updateStatement(Connection connection, Adresse adresse) throws SQLException{
        String query = "UPDATE Adresse SET adresse=?, ville=?, province=?, pays=?, codePostal=? WHERE idAdresse=?";

        PreparedStatement statement = connection.prepareStatement(query);

        // Save adresse to database
        statement.setString(1, adresse.getAdresse());
        statement.setString(2, adresse.getVille());
        statement.setString(3, adresse.getProvince());
        statement.setString(4, adresse.getPays());
        statement.setString(5, adresse.getCodePostal());
        statement.setInt(6, adresse.getIdAdresse());
        statement.executeUpdate();
      
    }

    private Adresse convertToAdresse(ResultSet result) throws SQLException{
        int idAdresse = result.getInt("idAdresse");
        String adresse = result.getString("adresse");
        String ville = result.getString("ville");
        String province = result.getString("province");
        String pays = result.getString("pays");
        String codePostal = result.getString("codePostal");

        return new Adresse(idAdresse, adresse, ville, province, pays, codePostal);
    }
    
}
