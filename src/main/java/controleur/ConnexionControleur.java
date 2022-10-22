package controleur;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Enumeration;

import javax.sql.DataSource;

import jakarta.annotation.Resource;
import jakarta.faces.context.ExternalContext;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modele.Utilisateur;
import service.UtilisateurDb;


@WebServlet("/connexionControleur" )
public class ConnexionControleur extends HttpServlet {
    
    @Resource(name="jdbc/TPJava")
	private DataSource dataSource;

    private UtilisateurDb utilisateurDb = null;

    @Override
    public void init() throws ServletException {
        utilisateurDb = new UtilisateurDb(dataSource);
    }

    // Function qui gère le login
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            String origin = req.getParameter("origin");
            RequestDispatcher dispatcher = null;

            // Verifier si le user est deja connecter
            // Si le user est connecter retourner a la page acceuil avec un message
            if(isUserLoggedIn(req)){
                req.setAttribute("toast", "Vous etes deja connecter");
                dispatcher = req.getRequestDispatcher("rechercheProduitControleur");
                dispatcher.forward(req, resp);
                return;
            }

            // Verifier les inputs sont toutes valides sinon envoyer a la page login
            if(!isInputValid(req)){
                dispatcher = req.getRequestDispatcher("login.jsp");
                dispatcher.forward(req, resp);
                return;
            }

            // Faire login et forward a la page origin ou acceuil
            login(req);

            if(origin.isBlank() == false)
                resp.sendRedirect(origin);
            else{
                req.setAttribute("toast", "Vous etes connecter");
                dispatcher = req.getRequestDispatcher("rechercheProduitControleur");
                dispatcher.forward(req, resp);
            }
           

        } catch(Exception exception) {

            resp.sendRedirect("error.jsp");
        }
    }

    // Function pour se deconnecter
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            RequestDispatcher dispatcher = null;

            // Vérifier si le user est deconnecter deja
            // Rediriger vers la page acceuil avec message
            if(!isUserLoggedIn(req)){
                req.setAttribute("toast", "Vous etes deja deconnecter");
                dispatcher = req.getRequestDispatcher("rechercheProduitControleur");
                dispatcher.forward(req, resp);
                return;
            }

            // logout le user
            req.logout();
            req.getSession().invalidate();
            req.setAttribute("toast", "Vous etes deconnecter");
            dispatcher = req.getRequestDispatcher("rechercheProduitControleur");
            dispatcher.forward(req, resp);

        } catch(Exception exception){
            exception.printStackTrace();
            resp.sendRedirect("error.jsp");
        }
    }

    private void login(HttpServletRequest req) throws ServletException, SQLException{
        String courriel = req.getParameter("courriel");
        String motDePasse = req.getParameter("motDePasse");

         // Login
         req.login(courriel, motDePasse);

         // Sauvegarder le profil de l'utilisateur dans la session
         Utilisateur user = utilisateurDb.getUserByCourriel(courriel);
         req.getSession().setAttribute("user", user);
    }

    private boolean isUserLoggedIn(HttpServletRequest req){
        String username = req.getRemoteUser();

        return username == null ? false : true;
    }

    private boolean isInputValid(HttpServletRequest req){
        String courriel = req.getParameter("courriel");
        String motDePasse = req.getParameter("motDePasse");
        boolean isValid = true;

         // Verifier les champs
         if(courriel.isBlank()){
             req.setAttribute("courrielError", "Entrer courriel valide");
             isValid = false;
         }

         if(motDePasse.isBlank()){
             req.setAttribute("motDePasseError", "Entrer mot de passe");
             isValid = false;
        }

        return isValid;
    }
    
}
