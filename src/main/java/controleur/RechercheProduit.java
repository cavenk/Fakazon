package controleur;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import jakarta.annotation.Resource;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modele.Produit;

@WebServlet("/test" )
public class RechercheProduit extends HttpServlet {
	private static final long serialVersionUID = 1L;


	//TEST CONNECTION À LA BD
	//Table Produit

	@Resource(name="jdbc/TPJava")
	private DataSource dataSource;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		response.setContentType("text/plain");

		//Connexion à la BD MYSQL
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;

		// Creation Liste de produits pour afficher sur la page principale
			List<Produit> products = new ArrayList<>();

		try {
			connection = dataSource.getConnection();
			String sql = "select * from Produit";
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);

			while (resultSet.next()) {
				// Appele la Class Produit pour creer row
				Produit row = new Produit();

				int idProduit = resultSet.getInt("idProduit");
				String nom = resultSet.getString("nom");
				double prix = resultSet.getDouble("prix");
				String image = resultSet.getString("image");
				int quantite = resultSet.getInt("quantite");
				int idCategorie = resultSet.getInt("idCategorie");

				row.setIdProduit(resultSet.getInt(idProduit));
				row.setNom(resultSet.getString("nom"));
				row.setPrix(resultSet.getDouble("prix"));
				row.setImage(resultSet.getString("image"));
				row.setQuantite(resultSet.getInt("quantite"));
				row.setIdCategorie(resultSet.getInt("idCategorie"));

				products.add(row);

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
