package service;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import modele.Adresse;
import modele.Utilisateur;

public class UtilisateurDb {

   	private DataSource dataSource;

    public UtilisateurDb(DataSource dataSource){
        this.dataSource  = dataSource;
    }
	
    public Utilisateur getUserByCourriel(String courriel) throws SQLException{
        Connection connection = null;

        try{
            PreparedStatement statement;
            ResultSet result;
            Utilisateur user;

            String query = "SELECT * FROM Utilisateur WHERE courriel=? LIMIT 1";

            connection = dataSource.getConnection();
            
            statement = connection.prepareStatement(query);
            statement.setString(1, courriel);
            
            result = statement.executeQuery();
            result.next();
            user = convertToUtilisateur(result);

            connection.close();
            
            return user;

        } catch(SQLException exception){
            if(connection != null)
                connection.close();

            throw exception;
        }

    }

    /* Function to be used with a transaction
     * Creates a statement and returns the id of the insert row
     */
    public static int createStatement(Connection connection, Utilisateur user, int idAdresse, int idAdresseLivraison) throws SQLException{
            String query = 
                "INSERT INTO Utilisateur (prenom, nom, dateNaissance, telephone, courriel, motPass, idRole, idAdresse, idAdresseLivraison)" +
                "VALUES(?,?,?,?,?,?,?,?,?)";

            // Insert Utilisateur and get the ID
            PreparedStatement statement = connection.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);

            statement.setString(1, user.getPrenom());
            statement.setString(2, user.getNom());
            statement.setDate(3, user.getDateNaissance());
            statement.setString(4, user.getTelephone());
            statement.setString(5, user.getCourriel());
            statement.setString(6, user.getMotPass());
            statement.setInt(7, user.getIdRole());
            statement.setInt(8, idAdresse);
            statement.setInt(9, idAdresseLivraison);
            statement.executeUpdate();

            ResultSet result = statement.getGeneratedKeys();
            result.next();

            int utilisateurID = result.getInt(1);
            
            return utilisateurID;
    }


    /* Function to be used with a transaction
    * Creates a statement for update
    */
    public static void updateStatement(Connection connection, Utilisateur user) throws SQLException{
        String query = "UPDATE utilisateur SET prenom=?, nom=?, dateNaissance=?, telephone=?, courriel=?, motPass=? WHERE idUtilisateur=?";

        PreparedStatement statement = connection.prepareStatement(query);

        statement.setString(1, user.getPrenom());
        statement.setString(2, user.getNom());
        statement.setDate(3, user.getDateNaissance());
        statement.setString(4, user.getTelephone());
        statement.setString(5, user.getCourriel());
        statement.setString(6, user.getMotPass());
        statement.setInt(7, user.getIdUtilisateur());
        statement.executeUpdate();
    }

    private Utilisateur convertToUtilisateur(ResultSet result) throws SQLException{
        int idUtilisateur = result.getInt("idUtilisateur");
        String prenom = result.getString("prenom");
        String nom = result.getString("nom");
        Date dateDeNaissance = result.getDate("dateNaissance");
        String telephone = result.getString("telephone");
        String courriel = result.getString("courriel");
        String motDePasse = result.getString("motPass");
        int idRole = result.getInt("idRole");
        Integer idAdresse = result.getInt("idAdresse");
        Integer idAdresseLivraison = result.getInt("idAdresseLivraison");
        

        return new Utilisateur(idUtilisateur, prenom, nom, dateDeNaissance, telephone, courriel, motDePasse, idRole, idAdresse, idAdresseLivraison);
       
    }
    
}
