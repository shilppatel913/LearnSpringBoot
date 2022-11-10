package emailapi;

import org.springframework.boot.SpringApplication;

import java.io.File;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EmailapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmailapiApplication.class, args);
		System.out.println("Email will be sent from here");
		String message="Message for security check";
		String subject="Security";
		String to="dessin.ish@gmail.com";
		String from="shilpnirajbhai.patel2019@vitstudent.ac.in";
		//sendEmail(message,subject,to,from);
		sendAttach(message,subject,to,from); //we will send attachment from this method
	}

	private static void sendAttach(String message, String subject, String to, String from) {
String host="smtp.gmail.com";
		
		//get the system properties
		Properties properties=System.getProperties();
		
		//setting the attributes to properties object
		properties.put("mail.smtp.host", host);
		properties.put("mail.smtp.port", "465");
		properties.put("mail.smtp.ssl.enable", "true");
		properties.put("mail.smtp.auth","true");
		
		//1. Get the session object
		Session session=Session.getInstance(properties,new Authenticator() {

			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				// TODO Auto-generated method stub
				return new PasswordAuthentication(from,"Vellore@1234");
			}
			
		});
		session.setDebug(true);
		//Step 2 Compose the message
		MimeMessage m=new MimeMessage(session);
		try {
			//set some mime message properties
			m.setFrom(from);
			
			//adding recipient
			m.addRecipient(Message.RecipientType.TO,new InternetAddress(to));
			
			//adding subject
			m.setSubject(subject);
			
			//here we will send both text and attachment
			//get the path of your file to send it as an attachment
			String path="C:\\Users\\Shilp\\OneDrive\\Desktop\\default_user.png";
			
			//make an object of mimeMultipart and we will send both text and attachment in this 
			MimeMultipart mimeMultipart=new MimeMultipart();
			
			MimeBodyPart textMime=new MimeBodyPart();
			MimeBodyPart fileMime=new MimeBodyPart();
			
			try {
				textMime.setText(message);
				File file=new File(path);
				fileMime.attachFile(file);
				
				mimeMultipart.addBodyPart(fileMime);
				mimeMultipart.addBodyPart(textMime);
				m.setContent(mimeMultipart);
			}catch(Exception e) {
				System.out.println("Something went wrong while attaching this file");
				e.printStackTrace();
			}
			
			
			
			
			
			//Step3 Send the message using transport class
			Transport.send(m);
			
			System.out.println("The attachement was successfully sent to the recipient");
			
			
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Sorry the email could not be sent");
		}
		
	}

	private static void sendEmail(String message, String subject, String to, String from) {
		//we will be using the gmail service to send the mail  through smtp server
		String host="smtp.gmail.com";
		
		//get the system properties
		Properties properties=System.getProperties();
		
		//setting the attributes to properties object
		properties.put("mail.smtp.host", host);
		properties.put("mail.smtp.port", "465");
		properties.put("mail.smtp.ssl.enable", "true");
		properties.put("mail.smtp.auth","true");
		
		//1. Get the session object
		Session session=Session.getInstance(properties,new Authenticator() {

			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				// TODO Auto-generated method stub
				return new PasswordAuthentication(from,"Vellore@1234");
			}
			
		});
		session.setDebug(true);
		//Step 2 Compose the message
		MimeMessage m=new MimeMessage(session);
		try {
			//set some mime message properties
			m.setFrom(from);
			
			//adding recipient
			m.addRecipient(Message.RecipientType.TO,new InternetAddress(to));
			
			//adding subject
			m.setSubject(subject);
			
			//adding text to the message
			m.setText(message);
			
			//Step3 Send the message using transport class
			Transport.send(m);
			
			System.out.println("The email was successfully sent to the recipient");
			
			
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Sorry the email could not be sent");
		}
		
	}

}
