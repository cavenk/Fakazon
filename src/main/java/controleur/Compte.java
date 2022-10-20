package controleur;

import java.io.IOException;
import java.sql.Date;

import javax.sql.DataSource;

import jakarta.annotation.Resource;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import modele.AdresseLivraison;
import modele.Utilisateur;
import service.UtilisateurDb;

@WebServlet("/compte" )
public class Compte extends HttpServlet {
    
    @Resource(name="jdbc/TPJava")
    private DataSource dataSource;
    private service.UtilisateurDb utilisateurDb;

    @Override
    public void init() throws ServletException {
       utilisateurDb = new UtilisateurDb(dataSource);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{

            Utilisateur user = verifyAndGetUtilisateur(req);
            AdresseLivraison adresseLiv = verifyAndGetAdresseLivraison(req);

            // If user or adresse de livraison is null,
            // it means that some input in the form is missing.
            // Return the form to complete
            if(user == null || adresseLiv == null){
                RequestDispatcher dispatcher = req.getRequestDispatcher("/register.jsp");
                dispatcher.forward(req, resp);
                return;
            }
          
            // Save utilisateur to database
            int userID = utilisateurDb.createUser(user, adresseLiv);
            user.setIdUtilisateur(userID);

            // Save utilisateur to session context
            HttpSession session = req.getSession();
            session.setAttribute("utilisateur", user);

            // Redirect to home page
            req.setAttribute("toast", "Compte a été crée avec succès !");
            RequestDispatcher dispatcher = req.getRequestDispatcher("/index.jsp");
            dispatcher.forward(req, resp);

         } catch(Exception exception){
           RequestDispatcher dispatcher = req.getRequestDispatcher("/error.jsp");
           dispatcher.forward(req, resp);

           System.out.println(exception);
         }
      
        
    }

    private Utilisateur verifyAndGetUtilisateur(HttpServletRequest req){
         // Information générale
         String nom = req.getParameter("nom");
         String prenom = req.getParameter("prenom");
         String dateDeNaissance = req.getParameter("dateDeNaissance");
         String telephone = req.getParameter("telephone");
         String courriel = req.getParameter("courriel");
         String confirmerCourriel = req.getParameter("confirmerCourriel");
         String motDePasse = req.getParameter("motDePasse");
         String confirmerMotDePasse = req.getParameter("confirmerMotDePasse");

         // Adresse
         String adresse = req.getParameter("adresse");
         String ville = req.getParameter("ville");
         String province = req.getParameter("province");
         String pays = req.getParameter("pays");
         String codePostal = req.getParameter("codePostal");

         Boolean isValid = true;


        //  Vérifier nom
        if(nom.isBlank()){
            req.setAttribute("errorNom", "Enter nom");
            isValid = false;
        }

        // Véfier prénom
        if(prenom.isBlank()){
            req.setAttribute("errorPrenom", "Entrer prenom");
            isValid = false;
        }

        // Véfier date de naissance
        if(dateDeNaissance.isBlank()){
            req.setAttribute("errorDateDeNaissance", "Entrer date de naissance");
            isValid = false;
        }

        // Véfier telephone
        if(telephone.isBlank()){
            req.setAttribute("errorTelephone", "Entrer telephone");
            isValid = false;
        }

        // Véfier courriel
        if(courriel.isBlank()){
            req.setAttribute("errorCourriel", "Entrer courriel");
            isValid = false;
        }

        // Véfier confirmer courriel
        if(confirmerCourriel.equals(courriel) == false){
            req.setAttribute("errorConfirmerCourriel", "Confirmer le courriel");
            isValid = false;
        }

        // Véfier motDePasse
        if(motDePasse.isBlank()){
            req.setAttribute("errorMotDePasse", "Entrer mot de passe");
            isValid = false;
        }

        // Véfier confirmer motDePasse
        if(confirmerMotDePasse.equals(motDePasse) == false){
            req.setAttribute("errorConfirmerMotDePasse", "Confirmer le mot de passe");
            isValid = false;
        }

        // Véfier adresse
        if(adresse.isBlank()){
            req.setAttribute("errorAdresse", "Entrer adresse");
            isValid = false;
        }

        // Véfier ville
        if(ville.isBlank()){
            req.setAttribute("errorVille", "Entrer ville");
            isValid = false;
        }

        // Véfier province
        if(province.isBlank()){
            req.setAttribute("errorProvince", "Entrer province");
            isValid = false;
        }

        // Véfier pays 
        if(pays.isBlank()){
            req.setAttribute("errorPays", "Entrer pays");
            isValid = false;
        }

        // Véfier code postal
        if(codePostal.isBlank()){
            req.setAttribute("errorCodePostal", "Entrer code postal");
            isValid = false;
        }

        // If something in the form is not valid, return null else return Utilisateur object
        if(!isValid)
            return null;
        else
            return new Utilisateur(
                prenom, prenom, Date.valueOf(dateDeNaissance), 
                telephone, courriel, motDePasse, 
                adresse, ville, province, 
                pays, codePostal, 2
            );
    }

    private AdresseLivraison verifyAndGetAdresseLivraison(HttpServletRequest req){
        String adresseLivraison = req.getParameter("adresseLivraison");
        String villeLivraison = req.getParameter("villeLivraison");
        String provinceLivraison = req.getParameter("provinceLivraison");
        String paysLivraison = req.getParameter("paysLivraison");
        String codePostalLivraison = req.getParameter("codePostalLivraison");

        Boolean isValid = true;

        // Véfier adresse
        if(adresseLivraison.isBlank()){
                req.setAttribute("adresseLivraisonValid", false);
                isValid = false;
            }

        // Véfier ville
        if(villeLivraison.isBlank()){
            req.setAttribute("villeLivraisonValid", false);
            isValid = false;
        }

        // Véfier province
        if(provinceLivraison.isBlank()){
            req.setAttribute("provinceLivraisonValid", false);
            isValid = false;
        }

        // Véfier pays 
        if(paysLivraison.isBlank()){
            req.setAttribute("paysLivraisonValid", false);
            isValid = false;
        }

        // Véfier code postal
        if(codePostalLivraison.isBlank()){
            req.setAttribute("codePostalLivraisonValid", false);
            isValid = false;
        }

        // If form is not valid return null else return Adresse
        if(!isValid)
            return null;
        else
            return new AdresseLivraison(adresseLivraison, villeLivraison, provinceLivraison, paysLivraison, codePostalLivraison);
    }

}
