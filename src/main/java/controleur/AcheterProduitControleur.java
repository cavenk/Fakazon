package controleur;

import java.io.IOException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.HttpConstraint;
import jakarta.servlet.annotation.ServletSecurity;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/acheter")
@ServletSecurity(
	value = @HttpConstraint(rolesAllowed ={"2"})
)
public class AcheterProduitControleur extends HttpServlet {
	private static final long serialVersionUID = 1L;


	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("authenticationg");
		request.authenticate(response);
		response.sendRedirect("register.jsp");
	

		/*
		response.setContentType("text/html");
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String courriel = request.getParameter("courriel");
		response.getWriter().println("Post - Bonjour, " + nom + " " + prenom + " " + courriel);
		*/

		response.setContentType("text/html");

		String nom = "Hernandez";
		String prenom = "Ana";
		String courriel = "ana.hernandez7531@gmail.com";


		boolean reponse = envoieCourriel(nom, prenom, courriel, response);
		if(reponse) {
			System.out.println("Envoi de courriel réussi");
			response.getWriter().println("Envoi de courriel réussi");
		}else{
			System.out.println("Échec de l'envoi de courriel");
			response.getWriter().println("Échec de l'envoi de courriel");
		}

	}//doGet

	private boolean envoieCourriel(String nom, String prenom, String courriel,HttpServletResponse response) {

        Properties properties = new Properties();
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.starttls.required", "true");
        properties.put("mail.smtp.ssl.protocols", "TLSv1.2");
        properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

		String courrielUsager = "fakazon.inc@gmail.com";
        String motDePasse = "tmtwwrzkmmujesvm";

        Session session = Session.getInstance(properties,
        		new javax.mail.Authenticator(){
                    @Override
					protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(courrielUsager, motDePasse);
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(courrielUsager));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(courriel)
            );
            message.setSubject("Envoi de courriel - Test");
            message.setText("Bonjour," + prenom + ", " + nom
                    + "\n\n<b>Vous m'avez envoyé un courriel !</b>"
                    + "\n\nMerci !"
                    + "\nAdminstrateur");
            Transport.send(message);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
	}//envoieCourriel


}//AcheterProduitControleur
