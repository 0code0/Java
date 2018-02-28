/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess;

import BusinessObject.Email;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author singhj1
 */
public class EmailDA {

    public static boolean sendMail(Email email) {

        Properties props = System.getProperties();
        props.setProperty("mail.smtp.host", "smtpapp1.sgp.st.com");
     //   props.setProperty("mail.transport.protocol", "smtp");

        Session session = Session.getInstance(props,
          new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(email.getTo(), email.getPassword());
            }
          });

        try {

            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(email.getFrom()));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(email.getTo()));
            message.setSubject(email.getSubject());
            message.setContent(email.getBody(),"text/html");
            
            Transport.send(message);
            return true;
        } catch (MessagingException e) {
            return false;

        }

    }

}
