package service;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import modele.AdresseLivraison;
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

    public int createUser(Utilisateur user, AdresseLivraison adresseLivraison) throws SQLException{
        Connection connection = null;

        try{
            connection = dataSource.getConnection();
            connection.setAutoCommit(false);
        
            String query = 
                "INSERT INTO Utilisateur (prenom, nom, dateNaissance, telephone, courriel, motPass, adresse, ville, province, pays, codePostal, idRole, idAdresseLivraison)" +
                "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";

            // Insert adresse livraison and get the ID
            int adresseLivraisonID = AdresseDb.create(connection, adresseLivraison);

            // Insert Utilisateur and get the ID
            PreparedStatement statement = connection.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);

            statement.setString(1, user.getPrenom());
            statement.setString(2, user.getNom());
            statement.setDate(3, user.getDateNaissance());
            statement.setString(4, user.getTelephone());
            statement.setString(5, user.getCourriel());
            statement.setString(6, user.getMotPass());
            statement.setString(7, user.getAdresse());
            statement.setString(8, user.getVille());
            statement.setString(9, user.getProvince());
            statement.setString(10, user.getPays());
            statement.setString(11, user.getCodePostal());
            statement.setInt(12, user.getIdRole());
            statement.setInt(13, adresseLivraisonID);
            statement.executeUpdate();

            ResultSet result = statement.getGeneratedKeys();
            result.next();

            int utilisateurID = result.getInt(1);
            
            connection.commit();
            connection.close();

            return utilisateurID;

        } catch (SQLException exception){
            if(connection != null)
                connection.close();

            throw exception;

        }

    }

    private Utilisateur convertToUtilisateur(ResultSet result) throws SQLException{
        int idUtilisateur = result.getInt("idUtilisateur");
        String prenom = result.getString("prenom");
        String nom = result.getString("nom");
        Date dateDeNaissance = result.getDate("dateNaissance");
        String telephone = result.getString("telephone");
        String courriel = result.getString("courriel");
        String motDePasse = result.getString("motPass");
        String adresse = result.getString("adresse");
        String ville = result.getString("ville");
        String province = result.getString("province");
        String pays = result.getString("pays");
        String codePostal = result.getString("codePostal");
        int idRole = result.getInt("idRole");
        int idAdresseLivraison = result.getInt("idAdresseLivraison");

        return new Utilisateur(idUtilisateur, prenom, nom, dateDeNaissance, telephone, courriel, motDePasse, adresse, ville, province, pays, codePostal, idRole, idAdresseLivraison);
       
    }
    
}
