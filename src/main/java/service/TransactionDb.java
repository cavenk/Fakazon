package service;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import modele.Adresse;
import modele.Utilisateur;

public class TransactionDb {

    private DataSource dataSource = null;


    public TransactionDb(DataSource dataSource){
        this.dataSource = dataSource;
    }


    // Transaction qui creer le compte avec les adresse et adresse de livraison
    public Utilisateur createCompte(Utilisateur user, Adresse adresse, Adresse adresseLiv) throws SQLException{
        Connection connection = null;

        try{
            connection = dataSource.getConnection();
            connection.setAutoCommit(false);

            int idAdresse = AdresseDb.createStatement(connection, adresse);
            int idAdresseLiv = AdresseDb.createStatement(connection, adresseLiv);
            int idUtilisateur = UtilisateurDb.createStatement(connection, user, idAdresse, idAdresseLiv);
           
            connection.commit();
            connection.close();

            Utilisateur newUser = new Utilisateur(
                idUtilisateur, 
                user.getPrenom(), 
                user.getNom(),
                user.getDateNaissance(), 
                user.getTelephone(),
                user.getCourriel(),
                user.getMotPass(), 
                user.getIdRole(), 
                idAdresse, 
                idAdresseLiv
            );

            return newUser;

        } catch (SQLException exception){
            if(connection != null)
                connection.close();

            throw exception;
        }

    }

    public void updateCompte(Utilisateur user, Adresse adresse, Adresse adresseLiv) throws SQLException{
        Connection connection = null;

        try{
            connection = dataSource.getConnection();
            connection.setAutoCommit(false);

            UtilisateurDb.updateStatement(connection, user);
            AdresseDb.updateStatement(connection, adresse);
            AdresseDb.updateStatement(connection, adresseLiv);
           
            connection.commit();
            connection.close();

        } catch (SQLException exception){
            if(connection != null)
                connection.rollback();

            throw exception;
        }

    }
    
}
