package controleur;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;

import javax.sql.DataSource;

import jakarta.annotation.Resource;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import modele.Adresse;
import modele.Utilisateur;
import service.AdresseDb;
import service.TransactionDb;

@WebServlet("/compteControleur" )
public class CompteControleur extends HttpServlet {
    
    @Resource(name="jdbc/TPJava")
    private DataSource dataSource;
    private TransactionDb transactionDb;
    private AdresseDb adresseDb;

    @Override
    public void init() throws ServletException {
        transactionDb = new TransactionDb(dataSource);
        adresseDb = new AdresseDb(dataSource);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            String action = req.getParameter("action");

            if(action == null)
                action = "";

            switch(action){
                case "create":
                    createUtilisateur(req, resp);
                    break;

                case "update":
                    updateUtilisateur(req, resp);
                    break;
                
                default:
                    getUtilisateurInfo(req, resp);
                    break;
            }

         } catch(Exception exception){
           RequestDispatcher dispatcher = req.getRequestDispatcher("/error.jsp");
           dispatcher.forward(req, resp);

           exception.printStackTrace();
         }
      
        
    }

    private void updateUtilisateur(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException, SQLException{
        Utilisateur utilisateur = verifyAndGetUtilisateur(req);
        Adresse adresse = verifyAndGetAdresse(req);
        Adresse adresseLiv = verifyAndGetAdresseLivraison(req);
        Utilisateur currentUser = (Utilisateur) req.getSession().getAttribute("user");

         // If user or adresse or adresse de livraison is null,
        // it means that some input in the form is missing.
        // Return the form to complete
        if(utilisateur == null || adresseLiv == null || adresse == null){
            RequestDispatcher dispatcher = req.getRequestDispatcher("updateCompte.jsp");
            dispatcher.forward(req, res);
            return;
        }

        // Set the ids of the objects
        utilisateur.setIdUtilisateur(currentUser.getIdUtilisateur());
        utilisateur.setIdAdresse(currentUser.getIdAdresse());
        utilisateur.setIdAdresseLivraison(currentUser.getIdAdresseLivraison());
        adresse.setIdAdresse(currentUser.getIdAdresse());
        adresseLiv.setIdAdresse(currentUser.getIdAdresseLivraison());

        // Update database
        transactionDb.updateCompte(currentUser, adresse, adresseLiv);

        // Update user info on session
        req.getSession().setAttribute("user", utilisateur);

        // Redirect to home page
        req.setAttribute("toast", "Votre compte a été modifier avec succès !");
        RequestDispatcher dispatcher = req.getRequestDispatcher("rechercheProduitControleur");
        dispatcher.forward(req, res);
    }

    private void getUtilisateurInfo(HttpServletRequest req, HttpServletResponse res) throws SQLException, ServletException, IOException{
        Utilisateur user = (Utilisateur) req.getSession().getAttribute("user");
        Adresse adresse = adresseDb.getAdresse(user.getIdAdresse());
        Adresse adresseLiv = adresseDb.getAdresse(user.getIdAdresseLivraison());

        req.setAttribute("adresse", adresse);
        req.setAttribute("adresseLiv", adresseLiv);

        RequestDispatcher dispatcher = req.getRequestDispatcher("updateCompte.jsp");
        dispatcher.forward(req, res);
    }

    private void createUtilisateur(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException, SQLException{
        Utilisateur user = verifyAndGetUtilisateur(req);
        Adresse adresse = verifyAndGetAdresse(req);
        Adresse adresseLiv = verifyAndGetAdresseLivraison(req);

        // If user or adresse or adresse de livraison is null,
        // it means that some input in the form is missing.
        // Return the form to complete
        if(user == null || adresseLiv == null || adresse == null){
            RequestDispatcher dispatcher = req.getRequestDispatcher("/register.jsp");
            dispatcher.forward(req, res);
            return;
        }
      
        // Save new Utilisateur to database
        Utilisateur newUser = transactionDb.createCompte(user, adresse, adresseLiv);

        // Login
        req.login(newUser.getCourriel(), newUser.getMotPass());

        // Save utilisateur to session context
        HttpSession session = req.getSession();
        session.setAttribute("user", newUser);

        // Redirect to home page
        req.setAttribute("toast", "Compte a été crée avec succès !");
        RequestDispatcher dispatcher = req.getRequestDispatcher("rechercheProduitControleur");
        dispatcher.forward(req, res);


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

        // If something in the form is not valid, return null else return Utilisateur object
        if(!isValid)
            return null;
        else
            return new Utilisateur(
                prenom, 
                nom, 
                Date.valueOf(dateDeNaissance), 
                telephone, 
                courriel, 
                motDePasse
            );
    }

    private Adresse verifyAndGetAdresse(HttpServletRequest req){
        String adresse = req.getParameter("adresse");
        String ville = req.getParameter("ville");
        String province = req.getParameter("province");
        String pays = req.getParameter("pays");
        String codePostal = req.getParameter("codePostal");
        Boolean isValid = true;

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

        // If something in the form is not valid, return null else return Adresse object
        if(!isValid)
            return null;
        else
            return new Adresse(adresse, ville, province, pays, codePostal);
    } 

    private Adresse verifyAndGetAdresseLivraison(HttpServletRequest req){
        String adresseLivraison = req.getParameter("adresseLivraison");
        String villeLivraison = req.getParameter("villeLivraison");
        String provinceLivraison = req.getParameter("provinceLivraison");
        String paysLivraison = req.getParameter("paysLivraison");
        String codePostalLivraison = req.getParameter("codePostalLivraison");
        Boolean isValid = true;

        // Véfier adresse
        if(adresseLivraison.isBlank()){
                req.setAttribute("errorAdresseLivraison", "Entrer adresse de livraison");
                isValid = false;
            }

        // Véfier ville
        if(villeLivraison.isBlank()){
            req.setAttribute("errorVilleLivraison", "Entrer ville de livraison");
            isValid = false;
        }

        // Véfier province
        if(provinceLivraison.isBlank()){
            req.setAttribute("errorProvinceLivraison", "Enter province de livraison");
            isValid = false;
        }

        // Véfier pays 
        if(paysLivraison.isBlank()){
            req.setAttribute("errorPaysLivraison", "Entrer pays de livraison");
            isValid = false;
        }

        // Véfier code postal
        if(codePostalLivraison.isBlank()){
            req.setAttribute("errorCodePostalLivraison", "Entrer code postal de livraison");
            isValid = false;
        }

        // If form is not valid return null else return Adresse
        if(!isValid)
            return null;
        else
            return new Adresse(adresseLivraison, villeLivraison, provinceLivraison, paysLivraison, codePostalLivraison);
    }

}
