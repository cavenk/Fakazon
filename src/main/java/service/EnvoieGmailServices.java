package service;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import jakarta.servlet.http.HttpServletResponse;

public class EnvoieGmailServices {

//	private boolean envoieCourriel(String nom, String prenom, String courriel,HttpServletResponse response) {
//
//        Properties properties = new Properties();
//        properties.put("mail.smtp.host", "smtp.gmail.com");
//        properties.put("mail.smtp.port", "587");
//        properties.put("mail.smtp.auth", "true");
//        properties.put("mail.smtp.starttls.enable", "true");
//        properties.put("mail.smtp.starttls.required", "true");
//        properties.put("mail.smtp.ssl.protocols", "TLSv1.2");
//        properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
//
//		String courrielUsager = "fakazon.inc@gmail.com";
//        String motDePasse = "tmtwwrzkmmujesvm";
//
//        Session session = Session.getInstance(properties,
//        		new javax.mail.Authenticator(){
//                    @Override
//					protected PasswordAuthentication getPasswordAuthentication() {
//                        return new PasswordAuthentication(courrielUsager, motDePasse);
//                    }
//                });
//
//        try {
//
//            Message message = new MimeMessage(session);
//            message.setFrom(new InternetAddress(courrielUsager));
//            message.setRecipients(
//                    Message.RecipientType.TO,
//                    InternetAddress.parse(courriel)
//            );
//            message.setSubject("Envoi de courriel - Test");
//            message.setText("Bonjour," + prenom + ", " + nom
//                    + "\n\n<b>Vous m'avez envoyé un courriel !</b>"
//                    + "\n\nMerci !"
//                    + "\nAdminstrateur");
//            Transport.send(message);
//            return true;
//        } catch (Exception e) {
//            e.printStackTrace();
//            return false;
//        }
//	}//envoieCourriel

}//EnvoieGmail
