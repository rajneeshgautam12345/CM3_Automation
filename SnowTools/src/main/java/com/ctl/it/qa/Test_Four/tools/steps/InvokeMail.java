package com.ctl.it.qa.Test_Four.tools.steps;

import javax.mail.MessagingException;

public class InvokeMail {
	public static void main(String[] args) throws MessagingException {
		// String to[] = {"test02@gmail.com","test03@gmail.com"};
		String to[] = { "ericw.steele@centurylink.com" };
		SendMail.send("test01@gmail.com", to, "JUnit Report", "Check the PDF attachment.");
	}
}