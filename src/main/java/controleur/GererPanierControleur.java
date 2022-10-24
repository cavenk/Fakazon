package controleur;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.sql.DataSource;

import jakarta.annotation.Resource;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import modele.Produit;
import service.ProduitsDbServices;

@WebServlet("/gererPanierControleur")
public class GererPanierControleur extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ProduitsDbServices ProduitsDbServices;
	private List<Produit> listePanier = new ArrayList<>();
	private List listeQuantiteParProd = new ArrayList<>();

	@Resource(name = "jdbc/TPJava")
	private DataSource dataSource;

	@Override
	public void init() throws ServletException {
		super.init();

		try {
			ProduitsDbServices = new ProduitsDbServices(dataSource);

		} catch (Exception e) {
			throw new ServletException(e);
		}
	}// init()

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {

			String action = request.getParameter("action");

			if (action == null) {
				action = "ajouterPanier";
			}

			switch (action) {

			case "ajouterPanier":

				ajouterPanier(request, response);

				break;

			case "decrementerQty":
				
				decrementeQty(request, response);

				System.out.println("--On decremente");

				break;

			// default:
			// listeEtudiants(request, response);
			}

		} catch (Exception ex) {
			throw new ServletException(ex);
		}

	}

	private Produit trouverItemPanier(int idProduit) {
		int pos = 0;
		for (Produit produit : listePanier) {

			if (idProduit == produit.getIdProduit()) {

				System.out.println("item in cart");
				return produit;
			}
			pos++;
		}
		return null;

	}// trouverItemPanier

	private void incrementQty(int idProduit, HttpServletRequest request) {

		int i = 0;
		for (Produit produit : listePanier) {

			if (idProduit == produit.getIdProduit()) {

				System.out.println("item in cart");

				int newQuantity = (int) listeQuantiteParProd.get(i) + 1;
				listeQuantiteParProd.set(i, newQuantity);

				System.out.println(listeQuantiteParProd);

				HttpSession session = request.getSession();
				session.setAttribute("listeQuantiteParProd", listeQuantiteParProd);
				break;
			}
			i++;
		}

	}// incrementQty

	private void decrementeQty( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int idProduit = Integer.parseInt(request.getParameter("idProduit"));
		
		int i = 0;
		for (Produit produit : listePanier) {

			if (idProduit == produit.getIdProduit()) {
				System.out.println("item in cart");

			if ((int) listeQuantiteParProd.get(i) == 1) {
				listeQuantiteParProd.remove(i);
				listePanier.remove(i);

				HttpSession session = request.getSession();
				session.setAttribute("listeQuantiteParProd", listeQuantiteParProd);
				session.setAttribute("listePanier", listePanier);
				
				break;
			}

			else {
				int newQuantite = (int) listeQuantiteParProd.get(i) - 1;
				listeQuantiteParProd.set(i, newQuantite);

				System.out.println(listeQuantiteParProd);

				HttpSession session = request.getSession();
				session.setAttribute("listeQuantiteParProd", listeQuantiteParProd);
				
				break;
			}
		}
		i++;
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/gererPanier.jsp");
		dispatcher.forward(request, response);
	
	}// decrementeQty

	private void ajouterPanier(HttpServletRequest request, HttpServletResponse response) throws Exception {

		int idProduit = Integer.parseInt(request.getParameter("idProduit"));

		List<Produit> produitsDBList = ProduitsDbServices.getProduits();

		// Since item productId starts at 1 and 1++ can use it as index
		Produit objProd = produitsDBList.get(idProduit - 1);

		Produit prodAjouter = trouverItemPanier(idProduit);

		if (listePanier.size() == 0) {

			listePanier.add(objProd);
			System.out.println(listePanier);

			listeQuantiteParProd.add(1);

			HttpSession session = request.getSession();
			session.setAttribute("listePanier", listePanier);

			session.setAttribute("listeQuantiteParProd", listeQuantiteParProd);

			System.out.println(listeQuantiteParProd);
		}

		else {

			if (prodAjouter == null) {
				listePanier.add(objProd);
				listeQuantiteParProd.add(1);

				System.out.println(listeQuantiteParProd);
				System.out.println(listePanier);

				HttpSession session = request.getSession();
				session.setAttribute("listePanier", listePanier);
				session.setAttribute("listeQuantiteParProd", listeQuantiteParProd);
			} else {
				System.out.println("Item deja dans panier");

				incrementQty(idProduit, request);

			}

		}

		RequestDispatcher dispatcher = request.getRequestDispatcher("/gererPanier.jsp");
		dispatcher.forward(request, response);
	}// ajouterPanier()

}// GererPanierControleur
