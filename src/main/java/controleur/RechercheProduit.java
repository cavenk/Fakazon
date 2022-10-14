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
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.sql.DataSource;

import modele.Produit;
import modele.Utilisateur;

@WebServlet("/test" )
public class RechercheProduit extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	//TEST CONNECTION À LA BD
	//Table Produit
	
	@Resource(name="jdbc/TPJava")
	private DataSource dataSource;
		
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		response.setContentType("text/plain");
		
		//Connexion à la BD MYSQL
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
				
				out.println(idProduit);
				out.println(nom);
				out.println(prix);
				out.println(image);
				out.println(quantite);
				out.println(idCategorie);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}//doGet()

}//RechercheProduit()
