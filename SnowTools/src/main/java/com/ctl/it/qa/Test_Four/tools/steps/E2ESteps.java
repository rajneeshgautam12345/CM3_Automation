package com.ctl.it.qa.Test_Four.tools.steps;

import java.time.Duration;
import javax.mail.MessagingException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.ctl.it.qa.staf.Steps;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.WebElementFacade;

//@SuppressWarnings("serial")
public class E2ESteps extends Steps {
	//private final Logger logger = LoggerFactory.getLogger(E2ESteps.class);

	// LATAMPage latamPage;
	
	static String ANSI_GREEN_BACKGROUND = "\u001B[42m";
	static String ANSI_RED_BACKGROUND = "\u001B[41m";
	static final String BLACK_UNDERLINED = "\033[4;30m";
	static String ANSI_RESET = "\u001B[0m";

	public static void printInGreenColor(String statementToBePrinted, String variable) {
		System.out.println(ANSI_GREEN_BACKGROUND + statementToBePrinted + variable + ANSI_RESET);
	}
	

	public static void printInRedColor(String statementToBePrinted, String variable) {
		System.out.println(ANSI_RED_BACKGROUND + statementToBePrinted + variable + ANSI_RESET);
	}

	public static void softAssertError(String appName, Boolean condition, String expected, String Actual) {
		if (!condition) {
			System.out.println(ANSI_RED_BACKGROUND + "*******************Test Failure in " + appName
					+ "*******************--> Expected was... " + expected + " , But actual is.. " + Actual
					+ ANSI_RESET);
		} else {
			System.out.println(ANSI_GREEN_BACKGROUND + appName + "--> Both Expected & actual are same ..."
					+ "Expected : " + expected + " , Actual : " + Actual + ANSI_RESET);
		}
	}
//	 public static void printInColor(String statementToBePrinted, String variable) {
//		 if (!condition) { 
//			 System.out.println(ANSI_RED_BACKGROUND + "*******************Test Failure in " + variable + "*******************--> "+ ANSI_RESET);
//		 }else {
//			 System.out.println(ANSI_GREEN_BACKGROUND + statementToBePrinted + variable + ANSI_RESET);
//		 }
//	 }

//	public Boolean WaitAndSync() {
//		Boolean bflag;
//		bflag = false;
//		try {
//			System.out.println("in try for  WaitAndSync");
//			int ncounter;
//			ncounter = 0;
//			do {
//				waitABit(2000);
//				if (productPage.isElementVisible(By.xpath("//div[@class='lds-ellipsis']"))) {
//					// if
//					// (productPage.isElementVisible(By.xpath("//div[@class='k-loading-image']"))) {
//					System.out.println("Loading circle is dispayed");
//					ncounter = ncounter + 1;
//					waitABit(2000);
//				} else {
//					System.out.println("All good");
//					bflag = true;
//				}
//			} while (bflag != true);
//			System.out.println("out of try for  WaitAndSync");
//			System.out.println("Loading circle counter is " + ncounter);
//			bflag = false;
//		} catch (Exception e) {
//			System.out.println(e);
//		}
//		return bflag;
//	}
//
//	public void sendMailReport(String tasknum) throws MessagingException {
//		String currentURL = getDriver().getCurrentUrl(); // get the current url of page in now
//		String nSwiftID = System.getProperty("Swift.ID"); // get the swift id from memory
//		String myEnv = System.getProperty("staf.environment.key");
//		String myProductType = System.getProperty("myProduct.ID");
//		logger.info("currentURL  is  " + currentURL); // // get the current url
//		logger.info("the Env is : " + myEnv);
//		waitABit(1000);
////			String to[] = {"Norman.Fulton@CenturyLink.com", "ericw.steele@centurylink.com","richard.allen@centurylink.com","Purnima.Muskula@lumen.com","Sapna.Hallikeri@lumen.com"};
////			SendMail.send("staf.sanity@centurylink.com", to, "Lightening Quote to Order - " + tasknum  + nSwiftID +" - "+ currentURL +" - "+" - "+ myEnv, "");
//	}

	public void sendMailReport_beforeSwift(String tasknum) throws MessagingException {
		String currentURL = getDriver().getCurrentUrl(); // get the current url of page in now
		String SIDID = System.getProperty("SID.ID");
		System.out.println("Scenario ID is  " + SIDID); // end of getting order id
		String myEnv = System.getProperty("staf.environment.key");
		String myProductType = System.getProperty("myProduct.ID");
		System.out.println("the Env is : " + myEnv);
		waitABit(1000);
//		String to[] = { "Norman.Fulton@CenturyLink.com", "ericw.steele@centurylink.com",
//				"leslie.tancredo@centurylink.com", "madhumitha.ganesh@centurylink.com" };
//		SendMail.send("staf.sanity@centurylink.com", to, tasknum + "  " + SIDID + " - " + myEnv, "");
	}

	public void customClickableWait(WebElementFacade element) {
		WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(500));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public void customVisibleWaitism(WebElementFacade element) {
		WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(150));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	

	public Boolean WaitAndSync1() {
		Boolean bflag;
		bflag = false;
		try {
			System.out.println("in try for  waitForSwiftProgressBar");
			int ncounter;
			ncounter = 0;
			do {
				// waitABit(1000);
				try {
					WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(5));
					wait.until(
							ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='lds-ellipsis']")));
					System.out.println("All good");
					bflag = true;
				} catch (TimeoutException e) {
					System.out.println("Loading progress bar is dispayed");
					ncounter = ncounter + 1;
					waitABit(1000);
				}
			} while (bflag != true);
			System.out.println("out of try for  waitForSwiftProgressBar");
			System.out.println("Loading progress bar  counter is " + ncounter);
			bflag = false;
		} catch (Exception e) {
			System.out.println(e);
		}
		return bflag;
	}

	
}
