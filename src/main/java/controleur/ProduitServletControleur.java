package controleur;

import jakarta.annotation.Resource;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.HttpConstraint;
import jakarta.servlet.annotation.ServletSecurity;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modele.Categorie;
import modele.Produit;
import service.ProduitsDbServices;

import java.io.IOException;
import java.util.List;

import javax.sql.DataSource;

@WebServlet("/ProduitServletControleur" )
@ServletSecurity(
	value = @HttpConstraint(rolesAllowed ={"1"})
)
public class ProduitServletControleur extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ProduitsDbServices produitsDbServices;
	
	@Resource (name="jdbc/TPJava")
	private DataSource dataSource;
	
	@Override
	public void init() throws ServletException {
		super.init();
		
		try {
			produitsDbServices = new ProduitsDbServices(dataSource);
		}
		catch (Exception e) {
			throw new ServletException(e);
		}
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String action = request.getParameter("action");
			
			
			if (action == null) {
				action = "LISTE";
			}
			
			switch (action) {
			
			case "LISTE":
				listeProduits(request, response);
				break;
				
			case "AJOUTER":
				ajouterProduit(request, response);
				break;
				
			case "CHARGER":
				produitParID(request, response);
				break;
				
			case "MODIFIER":
				modifierProduit(request, response);
				break;
			
			case "SUPPRIMER":
				supprimerProduit(request, response);
				break;
				
			case "AJOUTERPRODUIT":
				listeCategories(request, response);
				break;
				
			default:
				listeProduits(request, response);
			}
				
		}
		catch (Exception ex) {
			throw new ServletException(ex);
		}
	}
	
	private void modifierProduit(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		int idProduit = Integer.parseInt(request.getParameter("idProduit"));
		String nom = request.getParameter("nom");
		double prix = Double.parseDouble(request.getParameter("prix"));
		String image = request.getParameter("image");
		int quantite = Integer.parseInt(request.getParameter("quantite"));
		int idCategorie = Integer.parseInt(request.getParameter("idCategorie"));
		
		Produit produit = new Produit(idProduit, nom, prix, image, quantite, idCategorie);
		
		produitsDbServices.modifierProduit(produit);
		
		listeProduits(request, response);
	}
	
	private void produitParID(HttpServletRequest request, HttpServletResponse response) 
			throws Exception {
		
		int idProduit = Integer.parseInt(request.getParameter("idProduit"));
		
		Produit produit = produitsDbServices.getProduit(idProduit);
		List<Categorie> categories = produitsDbServices.getCategories();
		Produit nomCategorie = produitsDbServices.getNomCategorie(idProduit);
		
		request.setAttribute("PRODUIT", produit);
		request.setAttribute("CATEGORIE_LIST", categories);
		request.setAttribute("NomCategorie", nomCategorie);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/modifierProduit.jsp");
		dispatcher.forward(request, response);
	}
	
	private void ajouterProduit(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String nom = request.getParameter("nom");
		double prix = Double.parseDouble(request.getParameter("prix"));
		String image = request.getParameter("image");
		int quantite = Integer.parseInt(request.getParameter("quantite"));
		int idCategorie = Integer.parseInt(request.getParameter("idCategorie"));
		
		Produit produit = new Produit(nom, prix, image, quantite, idCategorie);
		
		produitsDbServices.ajouterProduit(produit);
				
		listeProduits(request, response);
	}
	
	private void supprimerProduit (HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		int idProduit = Integer.parseInt(request.getParameter("idProduit"));
		
		produitsDbServices.supprimerProduit(idProduit);
		
		listeProduits(request, response);
	}
	
	private void listeProduits(HttpServletRequest request, HttpServletResponse response) 
			throws Exception {

			List<Produit> produits = produitsDbServices.getProduits();
			
			request.setAttribute("PRODUIT_LIST", produits);
					
			RequestDispatcher dispatcher = request.getRequestDispatcher("/listeProduits.jsp");
			dispatcher.forward(request, response);
		}
	
	private void listeCategories(HttpServletRequest request, HttpServletResponse response) 
			throws Exception {
		
		List<Categorie> categories = produitsDbServices.getCategories();
		
		request.setAttribute("CATEGORIE_LIST", categories);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/ajouterProduit.jsp");
		dispatcher.forward(request, response);
	}//listeCategories()

}
