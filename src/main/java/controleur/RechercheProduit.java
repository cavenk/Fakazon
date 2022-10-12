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
		
		try {
			connection = dataSource.getConnection();
			String sql = "select * from produit";
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);
			
			while (resultSet.next()) {
				int idProduit = resultSet.getInt("idProduit");
				String nomCategorie = resultSet.getString("nomCategorie");
				String nomProduit = resultSet.getString("nomProduit");
				double prix = resultSet.getDouble("prix");
				String photoURL = resultSet.getString("photoURL");
				int quantiteDisponible = resultSet.getInt("quantiteDisponible");
				
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
