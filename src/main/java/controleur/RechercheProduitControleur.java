package controleur;

import java.io.IOException;
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

			default:
				listeProduits(request, response);
			}

			/*//Session
			HttpSession session = request.getSession();
			if(produits != null) {
				session.setAttribute("sessionProduits", produits);
			}
			response.getWriter().println("Session = " + (String) session.getAttribute("sessionProduits"));
			//session.invalidate();*/

		}
		catch (Exception e) {
			throw new ServletException(e);
		}

	}//doPost()

	private void listeProduits(HttpServletRequest request, HttpServletResponse response)
			throws Exception {

			List<Produit> produits = ProduitsDbServices.getProduits();

			request.setAttribute("PRODUITS_LIST", produits);

			RequestDispatcher dispatcher = request.getRequestDispatcher("/rechercheProduit.jsp");
			dispatcher.forward(request, response);
		}

}//RechercheProduit()
