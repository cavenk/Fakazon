package controleur;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import jakarta.annotation.Resource;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modele.Produit;
import service.ProduitsDbServices;

@WebServlet("/rechercheProduitControleur" )
public class RechercheProduitControleur extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ProduitsDbServices ProduitsDbServices;

	@Resource(name="jdbc/TPJava")
	private DataSource dataSource;


	@Override
	public void init() throws ServletException {
		super.init();

		try {
			ProduitsDbServices = new ProduitsDbServices(dataSource);
		}
		catch (Exception e) {
			throw new ServletException(e);
		}
	}//init()

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {

			String paramCategory = request.getParameter("category");
			String paramSearchInput = request.getParameter("searchInput");
			List<Produit> produits = null;

			if(paramCategory != null)
				produits = ProduitsDbServices.getProduitByCategory(Integer.parseInt(paramCategory));

			else if (paramSearchInput != null)
	        	produits = listeProduitsRechercher(request);

	        else
				produits = ProduitsDbServices.getProduits();


			request.setAttribute("PRODUITS_LIST", produits);

			RequestDispatcher dispatcher = request.getRequestDispatcher("/rechercheProduit.jsp");
			dispatcher.forward(request, response);

		}
		catch (Exception e) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/error.jsp");
			dispatcher.forward(request, response);

			e.printStackTrace();
		}

	}//doGet()



	private List<Produit> listeProduitsRechercher(HttpServletRequest request) throws Exception {

		String nomProductInput = request.getParameter("searchInput");

		List<Produit> produits = ProduitsDbServices.getProduits();

		List<Produit> resultSearchList = new ArrayList<>();


		for (Produit produit : produits) {

			String nomProduit = produit.getNom().toLowerCase();

			String nomProductInputLowerC = nomProductInput.toLowerCase();

			if (nomProduit.contains(nomProductInputLowerC)){

				resultSearchList.add(produit);
			}

		}

		return resultSearchList;

	}//listeProduitRechercher()


}//RechercheProduit()
