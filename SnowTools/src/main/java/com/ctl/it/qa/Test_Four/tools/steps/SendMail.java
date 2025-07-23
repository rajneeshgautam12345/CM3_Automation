package com.ctl.it.qa.Test_Four.tools.steps;

import java.util.Properties;

import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class SendMail {
	public static void send(String from, String tos[], String subject, String text) throws MessagingException {
		// Get the session object
		Properties props = new Properties();
		// props.put("mail.smtp.host", "cas-odc.ctl.intranet"); // Dosen't Work
		// props.put("mail.smtp.host", "151.117.137.33"); // Dosen't Work
		// props.put("mail.smtp.host", "4.72.132.10"); // L3 SMTP Server - Works - Port
		// 465 - ericw.steele@level3.com
		// props.put("mail.smtp.host", "smtp.gmail.com"); // Gmail SMTP Server - Works -
		// Port 465
		// props.put("mail.smtp.host", "mailgate.uswc.uswest.com"); CTL SMTP Server -
		// Works - Port 25 - staf.sanity@centurylink.com
		props.put("mail.smtp.host", "151.117.137.12"); // CTL SMTP Server - Works - Port 25 -
														// staf.sanity@centurylink.com
		props.put("mail.smtp.socketFactory.port", "25");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "25");
		// Email Username and Password variables
		final String emailusername = "staf.sanity@centurylink.com";
		final String emailpassword = "";
		// Password Decrypt
		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(
						// "ericw.steele@centurylink.com", "PASSWORDHERE");// change accordingly
						emailusername, emailpassword);// change accordingly
			}
		});
		// compose message
		try {
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(from));// change accordingly
			for (String to : tos) {
				message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			}
			/*
			 * for (String cc : ccs) message.addRecipient(Message.RecipientType.CC,new
			 * InternetAddress(cc));
			 */
			message.setSubject(subject);
			// Option 1: To send normal text message
			message.setText(text);
			// Option 2: Send the actual HTML message, as big as you like
			// message.setContent("<h1>This is actual message</h1></br></hr>" +
			// text, "text/html");
			// Set the attachment path
			// String filename = "C:\\temp\\SwIFTExternalSystemsSanity.txt";
//			String filename = "C:\\jenkins\\workspace\\RUBICONSanity.html";
			BodyPart objMessageBodyPart = new MimeBodyPart();
			String myEnv = System.getProperty("staf.environment.key");
			String scenarioName = System.getProperty("ScenarioName");
			String SMId = System.getProperty("SID.ID");
			String OrderID = System.getProperty("OppOrder.ID");
			// Option 3: Send text along with attachment
//			objMessageBodyPart.setContent("<h1>Mail from Selenium Snow E2E Project!</h1></br>" + text,
//					"text/html");
			objMessageBodyPart.setContent("<h1>Mail from Selenium Snow E2E Project!</h1></br>" + "<h3>Env - " + myEnv
					+ "</br>" + "<h3>Scenario - " + scenarioName + "</br>" + "<h3>Opportunity Id - " + OrderID + "</br>"
					+ "<h3>ScenarioManager Id-" + SMId, "text/html");
			Multipart multipart = new MimeMultipart();
			multipart.addBodyPart(objMessageBodyPart);
			// objMessageBodyPart = new MimeBodyPart();
			// DataSource source = new FileDataSource(filename);
			// objMessageBodyPart.setDataHandler(new DataHandler(source));
			// objMessageBodyPart.setFileName(filename);
			// multipart.addBodyPart(objMessageBodyPart);
			message.setContent(multipart);
			// send message
			Transport.send(message);
			System.out.println("message sent successfully");
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}// End of SEND method

	public static void send2(String from, String tos[], String subject, String text) throws MessagingException {
		// Get the session object
		Properties props = new Properties();
		// props.put("mail.smtp.host", "cas-odc.ctl.intranet"); // Dosen't Work
		// props.put("mail.smtp.host", "151.117.137.33"); // Dosen't Work
		// props.put("mail.smtp.host", "4.72.132.10"); // L3 SMTP Server - Works - Port
		// 465 - ericw.steele@level3.com
		// props.put("mail.smtp.host", "smtp.gmail.com"); // Gmail SMTP Server - Works -
		// Port 465
		// props.put("mail.smtp.host", "mailgate.uswc.uswest.com"); CTL SMTP Server -
		// Works - Port 25 - staf.sanity@centurylink.com
		props.put("mail.smtp.host", "151.117.137.12"); // CTL SMTP Server - Works - Port 25 -
														// staf.sanity@centurylink.com
		props.put("mail.smtp.socketFactory.port", "25");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "25");
		// Email Username and Password variables
		final String emailusername = "staf.sanity@centurylink.com";
		final String emailpassword = "";
		// Password Decrypt
		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(
						// "ericw.steele@centurylink.com", "PASSWORDHERE");// change accordingly
						emailusername, emailpassword);// change accordingly
			}
		});
		// compose message
		try {
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(from));// change accordingly
			for (String to : tos) {
				message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			}
			/*
			 * for (String cc : ccs) message.addRecipient(Message.RecipientType.CC,new
			 * InternetAddress(cc));
			 */
			message.setSubject(subject);
			// Option 1: To send normal text message
			message.setText(text);
			// Option 2: Send the actual HTML message, as big as you like
			// message.setContent("<h1>This is actual message</h1></br></hr>" +
			// text, "text/html");
			// Set the attachment path
			// String filename = "C:\\temp\\SwIFTExternalSystemsSanity.txt";
//			String filename = "C:\\jenkins\\workspace\\RUBICONSanity.html";
			BodyPart objMessageBodyPart = new MimeBodyPart();
			String myEnv = System.getProperty("staf.environment.key");
			// Option 3: Send text along with attachment
//			objMessageBodyPart.setContent("<h1>Mail from Selenium Snow E2E Project!</h1></br>" + text,
//					"text/html");
			objMessageBodyPart.setContent("<h1>Mail from Selenium Snow E2E Project!</h1></br>" + "<h3>Env - " + myEnv
					+ "</br>" + "<h3> " + text + "</br>", "text/html");
			Multipart multipart = new MimeMultipart();
			multipart.addBodyPart(objMessageBodyPart);
			// objMessageBodyPart = new MimeBodyPart();
			// DataSource source = new FileDataSource(filename);
			// objMessageBodyPart.setDataHandler(new DataHandler(source));
			// objMessageBodyPart.setFileName(filename);
			// multipart.addBodyPart(objMessageBodyPart);
			message.setContent(multipart);
			// send message
			Transport.send(message);
			System.out.println("message sent successfully");
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}// End of SEND method
}
