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
import service.CategorieDBServices;

import java.io.IOException;
import java.util.List;

import javax.sql.DataSource;

@WebServlet("/CategorieServletControleur" )
@ServletSecurity(
	value = @HttpConstraint(rolesAllowed ={"1"})
)
public class CategorieServletControleur extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private CategorieDBServices categorieDBServices;
	
	@Resource (name="jdbc/TPJava")
	private DataSource dataSource;
	
	@Override
	public void init() throws ServletException {
		super.init();
		
		try {
			categorieDBServices = new CategorieDBServices(dataSource);
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
				listeCategories(request, response);
				break;
				
			case "AJOUTER":
				ajouterCategorie(request, response);
				break;
				
			case "CHARGER":
				categorieParID(request, response);
				break;
				
			case "MODIFIER":
				modifierCategorie(request, response);
				break;
			
			case "SUPPRIMER":
				supprimerCategorie(request, response);
				break;
				
			default:
				listeCategories(request, response);
			}
				
		}
		catch (Exception ex) {
			throw new ServletException(ex);
		}
	}//doGet()
	
	private void modifierCategorie(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		int idCategorie = Integer.parseInt(request.getParameter("idCategorie"));
		String nom = request.getParameter("nom");
		String description = request.getParameter("description");
		
		Categorie categorie = new Categorie(idCategorie, nom, description);
		
		categorieDBServices.modifierCategorie(categorie);
		
		listeCategories(request, response);
	}//modifierCategorie()
	
	private void categorieParID(HttpServletRequest request, HttpServletResponse response) 
			throws Exception {
		
		int idCategorie = Integer.parseInt(request.getParameter("idCategorie"));
		
		Categorie categorie = categorieDBServices.getCategorie(idCategorie);
		
		request.setAttribute("CATEGORIE", categorie);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/modifierCategorie.jsp");
		dispatcher.forward(request, response);
	}//categorieParID()
	
	
	private void ajouterCategorie(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String nom = request.getParameter("nom");
		String description = request.getParameter("description");
		
		Categorie categorie = new Categorie(nom, description);
		
		categorieDBServices.ajouterCategorie(categorie);
		
		listeCategories(request,response);
	}//ajouterCategorie
	
	private void supprimerCategorie(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		int idCategorie = Integer.parseInt(request.getParameter("idCategorie"));
		
		categorieDBServices.supprimerCategorie(idCategorie);
		
		listeCategories(request, response);
	}//supprimerCategorie()
	
	private void listeCategories(HttpServletRequest request, HttpServletResponse response) 
			throws Exception {
		
		List<Categorie> categories = categorieDBServices.getCategories();
		
		request.setAttribute("CATEGORIE_LIST", categories);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/listeCategories.jsp");
		dispatcher.forward(request, response);
	}//listeCategories()

}
