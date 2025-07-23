package com.ctl.it.qa.Test_Four.tools.steps.SmokeTest;

import javax.mail.MessagingException;

import com.ctl.it.qa.Test_Four.tools.pages.common.SmokeDD;
import com.ctl.it.qa.Test_Four.tools.steps.E2ESteps;
import com.ctl.it.qa.Test_Four.tools.steps.SendMail;

@SuppressWarnings("serial")
public class SmokeTestSteps extends E2ESteps {
	SmokeDD smokedd;

	public void user_can_smoke_test_order_in_provisioning(String id, String env) throws MessagingException {
		String myEnv = System.getProperty("staf.environment.key");
		System.out.println("the Env is : " + myEnv);
		String myID = "";
		if (myEnv.equals("TEST1") || myEnv.equals("TEST2") || myEnv.equals("TEST4")) {
			myID = id;
		}
		smokedd.openAt(envData.getFieldValue("dcepturl")); // the digital portal url from the e2e.xml
		smokedd.maximize();
		smokedd.txt_username.type("mayuserdd@gmail.com");// set use
		smokedd.txt_password.type("Denver12345@"); // set pwd
		smokedd.btnlogin.click(); // click on log in button
		smokedd.waitForTextToAppear("Order ID", 20000); // Wait for page to load;
		smokedd.txt_ordersearch.type(myID);
		smokedd.img_iconsearch.click();
		smokedd.waitForTextToAppear(myID, 20000); // waiting for smokedd order to appear;
		String rc = "";
		// String rcc="";
		rc = smokedd.lnk_orderdd.getText();
		// rc= rcc.substring(1, 9);
		if (rc.equals(myID)) {
			System.out.println(("pass rc is" + rc + "myID " + myID)); // // get the current url
			// Assert.assertEquals(rc,myID,"Passed : the myIDs are equal swift myID " +myID+
			// " the one from GUI is " +rc);
			// Assert.assertTrue(message, condition);
			// Assert.assertSame(id, myID);
		} else {
			System.out.println(("Failed rc is not same " + rc + "myID " + myID)); // // get the current url
			// Assert.assertEquals(rc, myID,"Failed : the myIDs are not equal to swift myID
			// " + myID+ " the one from GUI is " + rc);
			// Assert.assertNotSame(rc, myID);
		}
		String currentURL = getDriver().getCurrentUrl(); // get the current url of
		// page in now
		System.out.println("currentURL is " + currentURL); // // get the current url
		// String myEnv=System.getProperty("staf.environment.key");
		System.out.println("the Env is : " + myEnv);
		waitABit(10000);
		String to[] = { "Norman.Fulton@CenturyLink.com", "ericw.steele@centurylink.com", "sumana.gowda@centurylink.com",
				"shanel.havely@centurylink.com", "swarna.mishra@centurylink.com" };
		SendMail.send("staf.sanity@centurylink.com", to,
				"Smoke Test Digital Dialog - " + myID + " - " + currentURL + " - " + " - " + myEnv, "");
		//
		// //String to[] = {"ericw.steele@centurylink.com,
		// Norman.Fulton@CenturyLink.com, swarna.mishra@level3.com"};
		// String to[] = {"Norman.Fulton@CenturyLink.com",
		// "ericw.steele@centurylink.com","swarna.mishra@level3.com" };
		// SendMail.send("staf.sanity@centurylink.com", to, "Digital Dialog - " +
		// tasknum + myID +" - "+ currentURL +" - "+" - "+ myEnv, "");
	}
}
