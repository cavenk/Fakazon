package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import modele.AdresseLivraison;

public class AdresseDb {

    
    public static int create(Connection connection, AdresseLivraison adresse) throws SQLException{
        String query = 
            "INSERT INTO adresseLivraison (adresse, ville, province, pays, codePostal)" +
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
    
}
