package controleur;

import jakarta.annotation.Resource;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import modele.Produit;
import modele.Utilisateur;

@WebServlet("/rechercherProduit" )
public class RechercheProduit extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
//	private Utilisateur utilisateur;
	
	@Resource(name="jdbc/fakazon_db")
	private DataSource dataSource;
		
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		response.setContentType("text/plain");
		
		//Connexion à la BD MYSQL
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		
		// Creation Liste de produits pour afficher sur la page principale
			List<Produit> products = new ArrayList<Produit>();
			
		
		
		try {
			connection = dataSource.getConnection();
			String sql = "select * from produit";
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);
			
			while (resultSet.next()) {
				// Appele la Class Produit pour creer row
				Produit row = new Produit();
				
				int idProduit = resultSet.getInt("idProduit");
				String nomCategorie = resultSet.getString("nomCategorie");
				String nomProduit = resultSet.getString("nomProduit");
				double prix = resultSet.getDouble("prix");
				String photoURL = resultSet.getString("photoURL");
				int quantiteDisponible = resultSet.getInt("quantiteDisponible");
				
				row.setIdProduit(resultSet.getInt(idProduit));
				row.setNomCategorie(resultSet.getString("nomCategorie"));
				row.setNomProduit(resultSet.getString("nomProduit"));
				row.setPrix(resultSet.getDouble("prix"));
				row.setPhotoURL(resultSet.getString("photoURL"));
				row.setQuantiteDisponible(resultSet.getInt("quantiteDisponible"));
				
				products.add(row);
				
				
				
				out.println(idProduit);
				out.println(nomCategorie);
				out.println(nomProduit);
				out.println(prix);
				out.println(photoURL);
				out.println(quantiteDisponible);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}//doGet()

}//RechercheProduit()
