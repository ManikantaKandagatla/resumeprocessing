/**
 * @author ManiKanta Kandagatla
 *
 */

package com.mywork.resumeprocessing.service;

import org.springframework.stereotype.Service;

import com.mywork.resumeprocessing.model.commons.Mail;

import javax.mail.PasswordAuthentication;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

@Service
public class MailService {
	
	//private static String FROM = "EmployeeServices@teradata.com";

	//private static String HOST = "outlook.td.teradata.com";
	
	private static String FROM = "kanta.123479@gmail.com";
	
	private static String HOST = "smtp.gmail.com";
	
    private static String password = "kanta.123479";
    
	public void sendHtmlMail(Mail mail)
	{
		// Get system properties
		Properties properties = new Properties();

		// Setup mail server
		properties.put("mail.smtp.auth", "true");
	    properties.put("mail.smtp.starttls.enable", "true");
	    properties.put("mail.smtp.port", "587");
		properties.put("mail.smtp.host", HOST);

		// Get the default Session object.
		Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
		    protected PasswordAuthentication getPasswordAuthentication() {
		        return new PasswordAuthentication(FROM, password);
		    }
		});

		try
		{
			// Create a default MimeMessage object.
			MimeMessage message = new MimeMessage(session);

			// Set From: header field of the header.
			message.setFrom(new InternetAddress(FROM));

			// Set To: header field of the header.
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(mail.getToAddress()));

			// Set Subject: header field
			message.setSubject(mail.getSubject());

			// Send the actual HTML message, as big as you like
			message.setContent(mail.getBody(), "text/html");

			// Send message
			Transport.send(message);
			System.out.println("Sent message successfully....");
		}
		catch (MessagingException mex)
		{
			mex.printStackTrace();
		}
	}
	
}
