//package com.ctl.it.qa.Test_Four.tools.steps.user;
//
//import java.io.IOException;
//import java.text.SimpleDateFormat;
//import java.time.Duration;
//import java.time.format.DateTimeFormatter;
//import java.util.Calendar;
//import java.util.Date;
//
//import org.junit.Assert;
//import org.openqa.selenium.Alert;
//import org.openqa.selenium.By;
//import org.openqa.selenium.Keys;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.support.ui.Select;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import com.ctl.it.qa.Test_Four.tools.pages.common.EasePage;
//import com.ctl.it.qa.Test_Four.tools.pages.common.LoginPage;
//import com.ctl.it.qa.Test_Four.tools.steps.E2ESteps;
//import com.ctl.it.qa.Test_Four.tools.steps.eservices.BaseStep;
//
//import net.serenitybdd.annotations.Step;
//
//@SuppressWarnings("serial")
//public class EaseSteps extends E2ESteps {
//
//	LoginPage loginPage;
//	EasePage easePage;
//	private final Logger logger = LoggerFactory.getLogger(EaseSteps.class);
//	public static String pon_Number;
//
//	// @SuppressWarnings("deprecation")
//	@Step
//	public void logs_in_as(String userType) {
//		System.setProperty("Type.ID", userType);
//		String mytypeID = System.getProperty("Type.ID");
//		logger.info("userType is  " + mytypeID); // end of getting user type id
//		String myUser = envData.getContainer("LoginPage").getContainer(userType).getFieldValue("tbx_username");
//		String myUserPassword = envData.getContainer("LoginPage").getContainer(userType).getFieldValue("tbx_password");
//		waitABit(5000);
//		loginPage.btn_next_submit.waitUntilClickable().withTimeoutOf(Duration.ofSeconds(2000));
//		loginPage.tbx_username.sendKeys(myUser);
//		loginPage.btn_next_submit.waitUntilClickable().withTimeoutOf(Duration.ofSeconds(10));
//		loginPage.btn_next_submit.click(); // click on new button new code for 2 step
//		loginPage.waitForTextToAppear("Enter password", 60000);
//		loginPage.tbx_password.sendKeys(myUserPassword);
//
////		enterEncryptedPassword(loginPage.tbx_password, myUser);
////		shouldExist(loginPage);
////		IntDataContainer datacontainer= envData.getContainer(loginPage.getClass().getSimpleName()).getContainer(userType);
////		fillFields(loginPage, datacontainer.getMandatoryFieldsFromAllContainers());
//
//		loginPage.btn_next_submit.waitUntilClickable().withTimeoutOf(Duration.ofSeconds(10));
//		loginPage.btn_next_submit.click(); // click on new button new code for 2 step
//		loginPage.waitForTextToAppear("Do this to reduce the number of times you are asked to sign in.", 190000);
//
//		loginPage.btn_NO.waitUntilClickable().withTimeoutOf(Duration.ofSeconds(500));
//		loginPage.btn_NO.click(); // click the no button
//		logger.info("Successfully logged in SFA");
//	}
//
//	@Step
//	public void is_in_ease_login_page() {
//
//		String vfoUrl = envData.getFieldValue("EASE");
//		System.out.println("EASE url=" + vfoUrl);
//		loginPage.openAt(vfoUrl);
//		getDriver().manage().window().maximize();
//		waitABit(1000);
//		String tempcurrentURL = getDriver().getCurrentUrl(); // get the current url
//		logger.info("currentURL  is  " + tempcurrentURL); // // get the current url
//		System.setProperty("URL.ID", tempcurrentURL); // set the url into memory
//		String OrginalURL = System.getProperty("URL.ID"); // get the url from memory
//		logger.info("OrginalURL  is  " + OrginalURL); // end of getting original url
//	}
//
//	@Step
//	public void should_be_on_login_page() {
//		loginPage.shouldExist(loginPage);
//	}
//
//	@Step
//	public void SearchPONNumber(String order) {
//		String referencePON ="";
//		if(order.equals("UNI"))
//		{
//		 referencePON = "RGUNITEST";
//		}
//		else if(order.equals("EVC"))
//		{
//		  referencePON = "RGEVCINSREF";
//		}
//		else if(order.equals("EVCCOMBO"))
//		{
//		  referencePON = "EVCCOMBOINSREF";
//		}
//		else if(order.equals("OVC"))
//		{
//		  referencePON = "OVCINSREF";
//		}
//		else if(order.equals("OVCCOMBO"))
//		{
//		  referencePON = "OVCCOMBOINSREF";
//		}
//	
//				
//		getDriver().switchTo().frame(1);
//		System.out.println("Switched to EASE home page frame");
//		waitABit(2000);
//		Actions a1 = new Actions(getDriver());
//		a1.moveToElement(easePage.orderTab).build().perform();
//		waitABit(2500);
//		System.out.println("Mouse over to Order Tab section ");
//
//		a1.moveToElement(easePage.searchMenuOption).click().build().perform();
//		waitABit(4000);
//
//		String currentWindow = getDriver().getWindowHandle(); // will keep current window to switch back
//		for (String winHandle : getDriver().getWindowHandles()) {
//			String title = getDriver().switchTo().window(winHandle).getTitle();
//			System.out.println("Title of window-" + title);
//			if (title.equals("Order Search Page")) {
//				System.out.println("Switched to Order Search Page Window");
//				break;
//			} else {
//				getDriver().switchTo().window(currentWindow);
//			}
//		}
//
//		easePage.searchText.sendKeys(referencePON);
//		System.out.println("Entered PON number in Search Text Box");
//		waitABit(1000);
//		easePage.searchButton.click();
//		System.out.println("Clicked on PON number Search button");
//		waitABit(2000);
//		String titleOfWindow = getDriver().switchTo().window(currentWindow).getTitle();
//		System.out.println("Title of Window2-" + titleOfWindow);
//		System.out.println("Switched back to Ease home page window");
//		waitABit(2000);
//		getDriver().switchTo().frame(1);
//		System.out.println("Switched to EASE home page frame");
//		easePage.radioSelectionOfPON.click();
//		System.out.println("Selected the Seached PON radio button");
//		waitABit(2000);
//	}
//
//	@Step
//	public void enterOrderDetails(String ponNumber, String ICSC,String activity) {
//		Actions a1 = new Actions(getDriver());
//		a1.moveToElement(easePage.orderTab).build().perform();
//		waitABit(2500);
//		System.out.println("Mouse over to Order Tab section ");
//		a1.moveToElement(easePage.saceAsOrderMenuOption).click().build().perform();
//		waitABit(5000);
//
//		String currentWindow = getDriver().getWindowHandle(); // will keep current window to switch back
//		for (String winHandle : getDriver().getWindowHandles()) {
//			String title = getDriver().switchTo().window(winHandle).getTitle();
//			System.out.println("Title of window-" + title);
//			if (title.equals("Order SaveAs... VFO")) {
//				System.out.println("Switched to Order SaveAs...VFO Window");
//				break;
//			} else {
//				getDriver().switchTo().window(currentWindow);
//			}
//		}
//
//		easePage.enterPONNumber.sendKeys(ponNumber);
//		System.out.println("PON Number entered");
//		waitABit(1500);
//		easePage.enterICSE.sendKeys(ICSC);
//		waitABit(1500);
//		getDriver().switchTo().activeElement().sendKeys(Keys.ENTER);
//		System.out.println("ICSC value entered");
//		waitABit(1500);
//		easePage.activity.selectByVisibleText(activity);
//		waitABit(1500);
//		easePage.save.click();
//		System.out.println("Save button clicked");
//		waitABit(5000);
//
//		pon_Number = ponNumber;
//
//	}
//
//	@Step
//	public void enterASRPageDetails(String ccna, String dd, String specCode, String remarks,String tspValue,String ecckt) {
//		String currentWindow = getDriver().getWindowHandle(); // will keep current window to switch back
//		for (String winHandle : getDriver().getWindowHandles()) {
//			String titleOfWindow = getDriver().switchTo().window(winHandle).getTitle();
//			System.out.println("Title of Window3-" + titleOfWindow);
//
//			if (titleOfWindow.contains("End User Switched Ethernet - Form: ASR")) {
//				System.out.println("Switched to End User Switched Ethernet - Form: ASR Window");
//				break;
//			} else {
//				getDriver().switchTo().window(currentWindow);
//			}
//		}
//
//		
//		Select s1 = new Select(easePage.ccna);
//		waitABit(2000);
//		s1.selectByVisibleText(ccna);
//		System.out.println("CCNA calue selected");
//		waitABit(1000);
//		easePage.dueDate.sendKeys(dd);
//		System.out.println("Due Date entered");
//
//		if(!specCode.equals(""))
//		{
//		waitABit(1000);
//		easePage.specCode.clear();
//		easePage.specCode.sendKeys("SVCMUX");
//		System.out.println("Spec Code Value entered");
//		}
//
//		if(!remarks.equals(""))
//		{
//		waitABit(1000);
//		easePage.remarks.clear();
//		easePage.remarks.sendKeys(remarks);
//		System.out.println("Remarks value entered");
//		waitABit(1000);
//		}
//		
//		if(!tspValue.equals(""))
//		{
//		waitABit(1000);
//		easePage.tsp.clear();
//		easePage.tsp.sendKeys();
//		System.out.println("TSP value entered");
//		waitABit(1000);
//		}
//		if(!ecckt.equals(""))
//		{
//		waitABit(1000);
//		easePage.ecckt.clear();
//		easePage.ecckt.sendKeys();
//		System.out.println("ECCKT value entered");
//		waitABit(1000);
//		}
//		
//	}
//
//	@Step
//	public void enterSESDetails(String esValue, String ncCodeValue, String nciCodeValue, String secNciValue) {
//
//		easePage.sesMenu.click();
//		System.out.println("Switched to SES Menu section");
//		waitABit(1500);
//
//		if(!esValue.equals(""))
//		{
//		Select s2 = new Select(easePage.esValue);
//		s2.selectByVisibleText(esValue);
//		System.out.println("ES Value selected");
//		waitABit(1000);
//		}
//
//		if(!ncCodeValue.equals(""))
//		{
//		easePage.ncCode.clear();
//		easePage.ncCode.sendKeys(ncCodeValue);
//		System.out.println("nc Code Value entered");
//		waitABit(1000);
//		}
//
//		if(!nciCodeValue.equals(""))
//		{
//		easePage.nciCode.clear();
//		easePage.nciCode.sendKeys(nciCodeValue);
//		System.out.println("nci Code Value entered");
//		waitABit(1000);
//		}
//
//		if(!secNciValue.equals(""))
//		{
//		easePage.secNci.clear();
//		easePage.secNci.sendKeys(secNciValue);
//		System.out.println("secNci Code Value entered");
//		waitABit(1000);
//		}
//	}
//
//	@Step
//	public void clickOnValidateButton_and_validateErrorText() {
//		String orderId = pon_Number;
//		easePage.validateButton.click();
//		System.out.println("Clicked on validate button");
//		waitABit(20000);		
//		easePage.errorPopupValidation.waitUntilEnabled().withTimeoutOf(Duration.ofSeconds(120));
//		waitABit(3000);
//		System.out.println("Error Popup Validated");
//		
//		getDriver().switchTo().frame(easePage.errorFrame);
//		System.out.println("Switched to Error Page frame");
//		System.out.println("Size of error-" + easePage.allErrorText.size());
//		for (int i = 0; i <= easePage.allErrorText.size() - 1; i++) {
//			String errorText = easePage.allErrorText.get(i).getText();
//			System.out.println("Error no -" + i+1+ "=" + errorText);
//			if ((orderId.startsWith("SCUNIIN")||orderId.contains("CNB"))&& errorText.equals("GIVEN ADDRESS IS NEAR_MATCH"))
//					{
//				System.out.println("ignore error");
//				} 
//			else if (((orderId.startsWith("SCEVCIN"))||(orderId.startsWith("SCOVCIN")))&& errorText.equals("EVCSP LOCATION ICSC DOES NOT MATCH ICSC OR OEC ICSC")) {
//				
//				System.out.println("ignore error");
//				}
//             else if ((orderId.startsWith("SCECOMIN")||orderId.startsWith("SCOCOMIN"))&& (errorText.equals("LEVEL OF SERVICE ERROR")||errorText.equals("GIVEN ADDRESS IS NEAR_MATCH"))) {
//				
//				System.out.println("ignore error");
//				}
////             else if (orderId.startsWith("AUTOVC")&& (errorText.equals("LEVEL OF SERVICE ERROR")||errorText.equals("EVCSP LOCATION ICSC DOES NOT MATCH ICSC OR OEC ICSC"))) {
//// 				
//// 				System.out.println("ignore error");
//// 				}
//			 else {
//				Assert.assertEquals("Throw exception", "actual");
//			}
//		}
//
//		getDriver().switchTo().defaultContent();
//		waitABit(2000);
//		Actions a2 = new Actions(getDriver());
//		a2.moveToElement(easePage.closeErrorPopup).click().build().perform();
//		System.out.println("clicked on close button of error popup");
//		waitABit(4000);
//	}
//
//	@Step
//	public void clickOnSubmitOrderButton() {
//		Actions a2 = new Actions(getDriver());
//		a2.moveToElement(easePage.submitButton).click().build().perform();
//		System.out.println("Clicked on OrderSubmit button");
//		waitABit(20000);
//		String statusOfOrder = easePage.statusOfOrder.getAttribute("value");
//		System.out.println("statusOfOrder-" + statusOfOrder);
//		Assert.assertEquals("Submitted", statusOfOrder);
//	}
//	
//	@Step
//	public void enterEVCDetails(String evcNC, String evcsp_ruid1, String ruid1, String evcNCI_ruid1,
//			String vact_ruid1,String ce_vlan_ruid1,String los1_ruid1,String evcBandwidth_ruid1,String evcsp_ruid2,
//			String ruid2,String evcNCI_ruid2,String vact_ruid2,String ce_vlan_ruid2,String los_ruid2,String evcBandwidth_ruid2) {
//
//		easePage.evcMenu.click();
//		System.out.println("Switched to EVC Menu section");
//		waitABit(2000);
//
//		if(!evcNC.equals(""))
//		{
//		easePage.evcNC.clear();
//		easePage.evcNC.sendKeys(evcNC);
//		System.out.println("NC Value entered");
//		waitABit(1500);
//		}
//
//		if(!evcsp_ruid1.equals(""))
//		{
//		easePage.evcsp_ruid1.clear();
//		easePage.evcsp_ruid1.sendKeys(evcsp_ruid1);         //M001 device
//		System.out.println("evcsp_ruid1 Value entered");
//		waitABit(1500);
//		}
//
//		if(!ruid1.equals(""))
//		{
//		easePage.ruid1.clear();
//		easePage.ruid1.sendKeys(ruid1);
//		System.out.println("ruid1 Value entered");
//		waitABit(1500);
//		}
//		
//		if(!evcNCI_ruid1.equals(""))
//		{
//		easePage.evcNCI_ruid1.clear();
//		easePage.evcNCI_ruid1.sendKeys(evcNCI_ruid1);
//		System.out.println("evcNCI_ruid1 Value entered");
//		waitABit(1500);
//		}
//		
//		if((!vact_ruid1.equals(""))&&(evcNCI_ruid1.equals("02VLN.VST")))
//		{
//		Select s2 = new Select(easePage.s_vact_ruid1);
//		s2.selectByVisibleText(vact_ruid1);
//		System.out.println("vact_ruid1 Value selected");
//		waitABit(1500);
//		}
//		else if((!vact_ruid1.equals(""))&&(!evcNCI_ruid1.equals("02VLN.VST")))
//		{
//		Select s2 = new Select(easePage.ce_vact_ruid1);
//		s2.selectByVisibleText(vact_ruid1);
//		System.out.println("vact_ruid1 Value selected");
//		waitABit(1500);
//		}
//		
//		if((!ce_vlan_ruid1.equals(""))&&(evcNCI_ruid1.equals("02VLN.VST")))
//		{
//		easePage.s_vlan_ruid1.clear();
//		easePage.s_vlan_ruid1.sendKeys(ce_vlan_ruid1);
//		System.out.println("ce_vlan_ruid1 Value entered");
//		waitABit(1500);
//		}
//		
//		else if((!ce_vlan_ruid1.equals(""))&&(!evcNCI_ruid1.equals("02VLN.VST")))
//		{
//		easePage.ce_vlan_ruid1.clear();
//		easePage.ce_vlan_ruid1.sendKeys(ce_vlan_ruid1);
//		System.out.println("ce_vlan_ruid1 Value entered");
//		waitABit(1500);
//		}
//		
//		if(!los1_ruid1.equals(""))
//		{
//		easePage.los1_ruid1.clear();
//		easePage.los1_ruid1.sendKeys(los1_ruid1);
//		System.out.println("los1_ruid1 Value entered");
//		waitABit(1500);
//		}
//		
//		if(!evcBandwidth_ruid1.equals(""))
//		{
//		easePage.evcBandwidth_ruid1.clear();
//		easePage.evcBandwidth_ruid1.sendKeys(evcBandwidth_ruid1);
//		System.out.println("evcBandwidth_ruid1 Value entered");
//		waitABit(1500);
//		}
//		
//		if(!evcsp_ruid2.equals(""))
//		{
//		easePage.evcsp_ruid2.clear();
//		easePage.evcsp_ruid2.sendKeys(evcsp_ruid2);             //M002 device
//		System.out.println("evcsp_ruid2 Value entered");
//		waitABit(1500);
//		}
//		
//		if(!ruid2.equals(""))
//		{
//		easePage.ruid2.clear();
//		easePage.ruid2.sendKeys(ruid2);
//		System.out.println("ruid2 Value entered");
//		waitABit(1500);
//		}
//		
//		if(!evcNCI_ruid2.equals(""))
//		{
//		easePage.evcNCI_ruid2.clear();
//		easePage.evcNCI_ruid2.sendKeys(evcNCI_ruid2);
//		System.out.println("evcNCI_ruid2 Value entered");
//		waitABit(1500);
//		}
//		
//		if((!vact_ruid2.equals(""))&&(!evcNCI_ruid2.equals("02VLN.VST")))
//		{
//		Select s3 = new Select(easePage.ce_vact_ruid2);
//		s3.selectByVisibleText(vact_ruid2);
//		System.out.println("vact_ruid2 Value selected");
//		waitABit(1500);
//		}
//		else if((!vact_ruid2.equals(""))&&(evcNCI_ruid2.equals("02VLN.VST")))
//		{
//		Select s3 = new Select(easePage.s_vact_ruid2);
//		s3.selectByVisibleText(vact_ruid2);
//		System.out.println("s_vact_ruid2 Value selected");
//		waitABit(1500);
//		}
//		
//		if((!ce_vlan_ruid2.equals(""))&&(!evcNCI_ruid2.equals("02VLN.VST")))
//		{
//		easePage.ce_vlan_ruid2.clear();
//		easePage.ce_vlan_ruid2.sendKeys(ce_vlan_ruid2);
//		System.out.println("ce_vlan_ruid2 Value entered");
//		waitABit(1500);
//		}
//		else if((!ce_vlan_ruid2.equals(""))&&(evcNCI_ruid2.equals("02VLN.VST")))
//		{
//		easePage.s_vlan_ruid2.clear();
//		easePage.s_vlan_ruid2.sendKeys(ce_vlan_ruid2);
//		System.out.println("s_vlan_ruid2 Value entered");
//		waitABit(1500);
//		}
//		
//		if(!los_ruid2.equals(""))
//		{
//		easePage.los_ruid2.clear();
//		easePage.los_ruid2.sendKeys(los_ruid2);
//		System.out.println("los_ruid2 Value entered");
//		waitABit(1500);
//		}
//		
//		if(!evcBandwidth_ruid2.equals(""))
//		{
//		easePage.evcBandwidth_ruid2.clear();
//		easePage.evcBandwidth_ruid2.sendKeys(evcBandwidth_ruid2);
//		System.out.println("evcBandwidth_ruid2 Value entered");
//		waitABit(1500);
//		}		
//	}
//
////
////	public void searchPON() {
////
////		String orderId = "RGUNITEST";
////
////		WebElement ponNumber = getDriver()
////				.findElement(By.xpath(easePage.ponNumberLink1 + orderId + easePage.ponNumberLink2));
////		ponNumber.click();
////
//////	        
////
//////
//////	        // Here we will check if child window has other child windows and will fetch the heading of the child window
//////	        while (iterator.hasNext()) {
//////	            String ChildWindow = iterator.next();
//////	            System.out.println(ChildWindow);
//////	                if  (!mainWindowHandle.equalsIgnoreCase(ChildWindow)) {
//////	                getDriver().switchTo().window(ChildWindow);
//////	                WebElement text = getDriver().findElement(By.id("sampleHeading"));
//////	                System.out.println("Heading of child window is " + text.getText());
//////	            }
//////	        }
//////	    }
////
////		// th[@id='orderTab']//a/img
////	}
//	
//	
////	@Step
////	public void login_in_Orchestrator() {
////
////		getDriver().quit();
////		String orchUrl = envData.getFieldValue("Orchestrator");
////		System.out.println("EASE url=" + orchUrl);
////		loginPage.openAt(orchUrl);
////		getDriver().manage().window().maximize();
////		waitABit(1000);
////		String tempcurrentURL = getDriver().getCurrentUrl(); // get the current url
////		logger.info("currentURL  is  " + tempcurrentURL); // // get the current url
////		System.setProperty("URL.ID", tempcurrentURL); // set the url into memory
////		String OrginalURL = System.getProperty("URL.ID"); // get the url from memory
////		logger.info("OrginalURL  is  " + OrginalURL); // end of getting original url
////		
////		
////		String myUser = envData.getContainer("LoginPage").getContainer("Valid").getFieldValue("tbx_username");
////		String myUserPassword = envData.getContainer("LoginPage").getContainer("Valid").getFieldValue("tbx_password");
////		waitABit(5000);
////		loginPage.btn_next_submit.waitUntilClickable().withTimeoutOf(Duration.ofSeconds(2000));
////		loginPage.tbx_username.sendKeys(myUser);
////		loginPage.btn_next_submit.waitUntilClickable().withTimeoutOf(Duration.ofSeconds(10));
////		loginPage.btn_next_submit.click(); // click on new button new code for 2 step
////		loginPage.waitForTextToAppear("Enter password", 5000);
////		loginPage.tbx_password.sendKeys(myUserPassword);
////
////		loginPage.btn_next_submit.waitUntilClickable().withTimeoutOf(Duration.ofSeconds(10));
////		loginPage.btn_next_submit.click(); // click on new button new code for 2 step
////		loginPage.waitForTextToAppear("Do this to reduce the number of times you are asked to sign in.", 190000);
////
////		loginPage.btn_NO.waitUntilClickable().withTimeoutOf(Duration.ofSeconds(500));
////		loginPage.btn_NO.click(); // click the no button
////		logger.info("Successfully logged in SFA");
////		waitABit(7000);
////
////	}
////
////	
////	public void searchPON_In_Orchestrator(String PON)
////	{
////		//String searchPON=  "SCUNIIN061651"+"%";
////		WebElement orchFrame=getDriver().findElement(By.xpath("//frame[@name='mainFrame']"));
////		getDriver().switchTo().frame(easePage.orchFrame);  //Switched to main frame
////		//String ponNumber=  pon_Number;
////		String searchPON=pon_Number+"%";
////		Actions a1= new Actions(getDriver());
////		a1.moveToElement(easePage.orderManagerMenu).build().perform();
////		
////		System.out.println("Successfully navigated to OrderManager Menu Section");
////		easePage.serviceRequestMenuOption.click();
////		System.out.println("Successfully clicked on service RequestMenu Option");
////		easePage.serviceRequestNumberText.sendKeys(searchPON);
////		System.out.println("Successfully entered service request Number");
////		easePage.retrieveServiceRequestButton.click();
////		System.out.println("Successfully clicked on retrieve service Request button");
////		waitABit(5000);
////	}
////	
////	
////	public void validateSearchedPON_In_Orchestrator()
////	{
////		getDriver().navigate().refresh();
////		waitABit(4000);
//////		easePage.orderRecord.waitUntilClickable().withTimeoutOf(Duration.ofSeconds(60));
//////		System.out.println("Successfully displayed the record");
////		WebElement orchFrame=getDriver().findElement(By.xpath("//frame[@name='mainFrame']"));
////		getDriver().switchTo().frame(easePage.orchFrame);
////		System.out.println(easePage.orderRecord.getText());
////		String actualOrder=easePage.orderRecord.getText();
////		String ponNumberValidation=actualOrder.substring(0,13);
////		System.out.println(ponNumberValidation);
////		easePage.orderRecord.click();
////		
////		System.out.println("Successfully clicked on the record");
////		getDriver().switchTo().defaultContent();    //switched back to window from main frame
////		
////	}
////	
////	public void enterSWC()
////	{	
////		waitABit(5000);
////		WebElement orchTaskPageFrame=getDriver().findElement(By.xpath("//frame[@name='SRIDETAIL']"));
////		getDriver().switchTo().frame(easePage.orchTaskPageFrame);   //Switched to Task page frame
////		
////		easePage.expandMobRow.click();
////		System.out.println("Successfully expanded row4 section");
////		waitABit(2000);
////		
////		WebElement firstTask=getDriver().findElement(By.xpath("(//div[@id='divDisplaySMWSA5']//tr[@bgcolor='#EAE9F3']/td[8]/font/../../td[2]/font)[1]"));
////		System.out.println("Row 4 -Task 1 text-"+firstTask.getText());
////		firstTask.click();
////		waitABit(4000);
////		System.out.println("Successfully clicked on first task of 4th row");
////		
////		String currentWindow1 = getDriver().getWindowHandle(); // will keep current window to switch back
////		   for (String winHandle1 : getDriver().getWindowHandles()) {
////			String titleOfWindow1 = getDriver().switchTo().window(winHandle1).getTitle();
////			System.out.println("Title of Window1-" + titleOfWindow1);
////			waitABit(3000);
////			if (titleOfWindow1.contains("RazorFlow Orchestrator - WorkScheduleActivity Details")) {
////				System.out.println("Switched to RazorFlow Orchestrator - WorkScheduleActivity Details");
////				easePage.userDefinedDetailsLink.click();
////				System.out.println("Successfully clicked on User Defined Details link");
////				waitABit(4000);
////				
////				String currentWindow2 = getDriver().getWindowHandle(); 
////				for (String winHandle2 : getDriver().getWindowHandles()) {
////					String titleOfWindow2 = getDriver().switchTo().window(winHandle2).getTitle();
////					waitABit(2000);
////					System.out.println("Title of Window2-" + titleOfWindow2);
////					if (titleOfWindow2.contains("Work Schedule Activity UDO Tags")) {
////						System.out.println("Switched to Work Schedule Activity UDO Tags window");
////						waitABit(2000);
////						easePage.swcText.clear();
////						waitABit(1500);
////						easePage.swcText.sendKeys("DNVRCONODS0");
////						System.out.println("Successfully entered SWC");
////						waitABit(2000);
////						easePage.saveAndComplete.click();
////						System.out.println("Clicked on save and complete button");
////						waitABit(3000);
////						break;
////						
////					}		
////				}
////			
////				getDriver().switchTo().window(currentWindow2);
////				System.out.println("Swiched to window2");
////				waitABit(3000);
////                easePage.saveAndComplete.click();
////                System.out.println("Clicked on save and complete button");
////				break;			
////			} 
////		}
////		   
////		   getDriver().switchTo().window(currentWindow1);
////	}
////	
////	
////	public void validateOverallStatusOfRow1()
////	{
////		waitABit(3000);
////		WebElement orchTaskPageFrame=getDriver().findElement(By.xpath("//frame[@name='SRIDETAIL']"));
////		getDriver().switchTo().frame(easePage.orchTaskPageFrame);   //Switched to Task page frame
////		
////		waitABit(1000);
////		String overallStatusOfRow1=easePage.overallStatusOfRow1.getText();
////		System.out.println("Overall status of Row 1-"+overallStatusOfRow1);
////		easePage.expandRow1.click();
////		waitABit(2000);
////		System.out.println("Successfully expanded row1 section");
////		
////		if(overallStatusOfRow1.equals("UnAssigned")||overallStatusOfRow1.equals("Pending"))
////		{
////			int no_of_row=easePage.statusOfEachRowOfSoftErrorDetails.size();
////			System.out.println("No of row-"+no_of_row);
////			String statusOfFirstTask=easePage.statusOfEachRowOfSoftErrorDetails.get(0).getText();
////			System.out.println("Status of Row1 first task-"+statusOfFirstTask);
////			Assert.assertEquals("Completed",statusOfFirstTask );
////				
////			String statusOfSecondTask=easePage.statusOfEachRowOfSoftErrorDetails.get(1).getText();
////			System.out.println("Status of Row1 second task-"+statusOfSecondTask);
////            if(statusOfSecondTask.equals("UnAssigned")||statusOfSecondTask.equals("Pending"))
////               {
////            	  WebElement ele=getDriver().findElement(By.xpath("(//div[@id='divDisplaySMWSA2']//tr[@bgcolor='#FBF9FA']/td[8]/font/../../td[2]/font)[2]"));
////            	  System.out.println("Row 1 second task text-"+ele.getText());
////            	  ele.click();
////            	  waitABit(4000);
////                  System.out.println("Clicked on second task");
////            	  String currentWindow = getDriver().getWindowHandle(); // will keep current window to switch back
////           		  for (String winHandle : getDriver().getWindowHandles()) {
////           			String titleOfWindow = getDriver().switchTo().window(winHandle).getTitle();
////           			System.out.println("Title of Window3-" + titleOfWindow);
////           			if (titleOfWindow.contains("RazorFlow Orchestrator - WorkScheduleActivity Details")) {
////           				System.out.println("Switched to RazorFlow Orchestrator - WorkScheduleActivity Details");
////           			    Select s1=new Select(easePage.selectStatusDropdown);
////                        s1.selectByVisibleText("Completed");
////                        System.out.println("Selected the Complete option from dropdown");
////                        easePage.saveAndComplete.click();
////                        System.out.println("Clicked on save and complete button");
////           				break;
////           				
////           			} else {
////           				getDriver().switchTo().window(currentWindow);
////           			}
////           		}
////           		getDriver().switchTo().window(currentWindow);
////           	    System.out.println("Switched to parent window");
////               }	   
////			}
////	
////	
////	}
////	
////	public void validateOverallStatusOfRow2()
////	{
////        WebElement orchTaskPageFrame=getDriver().findElement(By.xpath("//frame[@name='SRIDETAIL']"));
////		getDriver().switchTo().frame(easePage.orchTaskPageFrame);
////		
////		String overallStatusOfRow2=easePage.overallStatusOfRow2.getText();
////		System.out.println("Overall status of Row 2-"+overallStatusOfRow2);
////		easePage.expandRow2.click();
////		waitABit(2000);
////		System.out.println("Successfully expanded row2 section");
////		
////		if(overallStatusOfRow2.equals("UnAssigned")||overallStatusOfRow2.equals("Pending")||overallStatusOfRow2.equals("Jeopardy"))
////		{
////			int no_of_row=easePage.statusOfREQ_SWC_FROM_CLLI.size();
////			System.out.println("No of Row--"+no_of_row);
////			String statusOfFirstTask=easePage.statusOfREQ_SWC_FROM_CLLI.get(0).getText();
////			System.out.println("Status of Row2 first task-"+statusOfFirstTask);
////			Assert.assertEquals("Completed",statusOfFirstTask );
////				
////			String statusOfSecondTask=easePage.statusOfREQ_SWC_FROM_CLLI.get(1).getText();
////			System.out.println("Status of Row2 second task-"+statusOfSecondTask);
////            if(statusOfSecondTask.equals("UnAssigned")||statusOfSecondTask.equals("Jeopardy"))
////               {
////            	  WebElement ele=getDriver().findElement(By.xpath("(//div[@id='divDisplaySMWSA3']//tr[@bgcolor='#EAE9F3']/td[8]/font/../../td[2]/font)[2]"));
////            	  System.out.println("2nd Row Second task text-"+ele.getText());
////            	  ele.click();  
////            	  waitABit(4000);
////            	  System.out.println("Clicked on second task");
////            	  String currentWindow = getDriver().getWindowHandle(); // will keep current window to switch back
////           		  for (String winHandle : getDriver().getWindowHandles()) {
////           			String titleOfWindow = getDriver().switchTo().window(winHandle).getTitle();
////           			System.out.println("Title of Window2-" + titleOfWindow);
////
////           			if (titleOfWindow.contains("RazorFlow Orchestrator - WorkScheduleActivity Details")) {
////           				System.out.println("Switched to RazorFlow Orchestrator - WorkScheduleActivity Details");
////           			    Select s1=new Select(easePage.selectStatusDropdown);
////                        s1.selectByVisibleText("Completed");
////                        easePage.saveAndComplete.click();
////                        System.out.println("Clicked on save and complete button");
////           				break;
////           				
////           			} else {
////           				getDriver().switchTo().window(currentWindow);
////           			}
////           		}
////           	   getDriver().switchTo().window(currentWindow);
////           	   System.out.println("Switched to parent window");
////               }	   
////			}
////		
////	}
////	
////	public void validateOverallStatusOfNonASOGRow()
////	{
////		WebElement orchTaskPage=getDriver().findElement(By.xpath("//frame[@name='SRIDETAIL']"));
////		getDriver().switchTo().frame(easePage.orchTaskPageFrame);
////		
////	    boolean status=false;
////    	for(int i=1;i<=5;i++)
////		{
////		String statusOfRow3=easePage.overallStatusOfNONAOG.getText();
////	    System.out.println("Overall status of NonASOG-"+statusOfRow3);
////        if(!statusOfRow3.equals("Completed"))
////        {
////        	getDriver().switchTo().defaultContent();
////        	refreshOrchestratorPage();
////        	waitABit(10000);
////        	getDriver().switchTo().frame(orchTaskPage);
////        	
////        }
////        else
////        {
////        	status=true;
////        	System.out.println("NonASOG Row all tasks completed");
////        	break;
////        }
////		}
////    	getDriver().switchTo().defaultContent();
////    	Assert.assertEquals(true, status);
////    	
////	}
////	
////	public void validateAcceptProjectStatusForUNI_Or_Combo()
////	{
////		
////		WebElement orchTaskPage=getDriver().findElement(By.xpath("//frame[@name='SRIDETAIL']"));
////		getDriver().switchTo().frame(easePage.orchTaskPageFrame);
////		
////		String statusOfRow4=easePage.overallStatusOfMob.getText();
////		System.out.println("Overall status of Mob Row-"+statusOfRow4);
////		easePage.expandMobRow.click();
////		waitABit(2000);
////		System.out.println("Successfully expanded Mob Row section");
////		//String statusOfFirstTask=easePage.statusOfMobErrorDetails.get(1).getText();
////		
////		for(int i=1;i<=5;i++)
////		{
////		 String statusOfFirstTask=easePage.statusOfMobErrorDetails.get(0).getText();		
////		 System.out.println("Status of Mob Row -"+1+" task-"+statusOfFirstTask);
////         if(!statusOfFirstTask.equals("Completed"))
////          {
////        	waitABit(15000);
////        	getDriver().switchTo().defaultContent();
////        	refreshOrchestratorPage();
////        	waitABit(3000);
////        	getDriver().switchTo().frame(orchTaskPage);
////        	easePage.expandMobRow.click();
////        	waitABit(4000);
////        	System.out.println("Successfully expanded Mob Row section");
////          }
////         else
////         {
////        	 System.out.println("Status of Mob Row-"+1+" task-"+statusOfFirstTask);
////        	 getDriver().switchTo().defaultContent();
////        	 break;
////         }
////	    }
////		
////		refreshOrchestratorPage();
////		waitABit(4000);
////		WebElement orchTaskPage2=getDriver().findElement(By.xpath("//frame[@name='SRIDETAIL']"));
////		getDriver().switchTo().frame(orchTaskPage2);
////    	easePage.expandMobRow.click();
////    	waitABit(2000);
////    	System.out.println("Successfully expanded Mob Row section");
////    	
////		for(int i=1;i<=10;i++)
////		{
////		 String statusOfSecondTask=easePage.statusOfMobErrorDetails.get(1).getText();		
////		 System.out.println("Status of Mob Row-"+2+" task-"+statusOfSecondTask);
////         if(!statusOfSecondTask.equals("Completed"))
////          {
////        	waitABit(15000);
////        	getDriver().switchTo().defaultContent();
////        	refreshOrchestratorPage();
////        	waitABit(4000);
////        	getDriver().switchTo().frame(orchTaskPage2);
////        	easePage.expandMobRow.click();
////        	waitABit(2000);
////        	System.out.println("Successfully expanded Mob Row section");
////          }
////         else
////         {
////        	 System.out.println("Status of Mob Row-"+2+" task-"+statusOfSecondTask);
////        	 getDriver().switchTo().defaultContent();
////        	 break;
////         }
////		
////	    }
////		
////		
////	}
////		
////	public void refreshOrchestratorPage()
////	{
////		WebElement refreshFrame=getDriver().findElement(By.xpath("//frame[@name='leftFrame']"));
////		getDriver().switchTo().frame(easePage.refreshFrame);
////		easePage.refreshButton.click();
////		System.out.println("Successfully clicked on refresh button..... ");
////		waitABit(7000);
////		getDriver().switchTo().defaultContent();
////	}
////	
////	public void validateAcceptProjectStatusForEVC()
////	{
////		
////		WebElement orchTaskPageFrame=getDriver().findElement(By.xpath("//frame[@name='SRIDETAIL']"));
////		getDriver().switchTo().frame(easePage.orchTaskPageFrame);
////		
////		String statusOfRow4=easePage.overallStatusOfMobForEVC.getText();
////		System.out.println("Overall status of Row 4-"+statusOfRow4);
////		easePage.expandMobRowForEVC.click();
////		waitABit(2000);
////		System.out.println("Successfully expanded row4 section");
////		//String statusOfFirstTask=easePage.statusOfMobErrorDetails.get(1).getText();
////		
////		for(int i=1;i<=5;i++)
////		{
////		 String statusOfFirstTask=easePage.statusOfMobErrorDetailsForEVC.get(0).getText();		
////		 System.out.println("Status of 4th Row-"+1+" task-"+statusOfFirstTask);
////         if(!statusOfFirstTask.equals("Completed"))
////          {
////        	waitABit(15000);
////        	getDriver().switchTo().defaultContent();
////        	refreshOrchestratorPage();
////        	waitABit(3000);
////        	getDriver().switchTo().frame(orchTaskPageFrame);
////        	easePage.expandMobRowForEVC.click();
////        	waitABit(2000);
////        	System.out.println("Successfully expanded row4 section");
////          }
////         else
////         {
////        	 System.out.println("Status of 4th row-"+1+" task-"+statusOfFirstTask);
////        	 getDriver().switchTo().defaultContent();
////        	 break;
////         }
////	    }
////		
////		refreshOrchestratorPage();
////		waitABit(4000);
////		WebElement orchTaskPage2=getDriver().findElement(By.xpath("//frame[@name='SRIDETAIL']"));
////		getDriver().switchTo().frame(orchTaskPage2);
////    	easePage.expandMobRowForEVC.click();
////    	waitABit(2000);
////    	System.out.println("Successfully expanded row4 section");
////    	
////		for(int i=1;i<=10;i++)
////		{
////		 String statusOfSecondTask=easePage.statusOfMobErrorDetailsForEVC.get(1).getText();		
////		 System.out.println("Status of 4th row-"+2+" task-"+statusOfSecondTask);
////         if(!statusOfSecondTask.equals("Completed"))
////          {
////        	waitABit(15000);
////        	getDriver().switchTo().defaultContent();
////        	refreshOrchestratorPage();
////        	getDriver().switchTo().frame(orchTaskPage2);
////        	easePage.expandMobRowForEVC.click();
////        	waitABit(2000);
////        	System.out.println("Successfully expanded row4 section");
////          }
////         else
////         {
////        	 System.out.println("Status of 4th Row-"+2+" task-"+statusOfSecondTask);
////        	 getDriver().switchTo().defaultContent();
////        	 break;
////         }
////		
////	    }	
////	}
////
////	
//	
//	//VFO Page
//	@Step
//	public void user_Submit_Supp2_On_Order() {	
//		String existing_ddd=easePage.dueDate.getAttribute("value");
//		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
//		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy"); // Set Date
//		Calendar cal = Calendar.getInstance();
//		cal.setTime(new Date());
//		
//		//LocalDate date = LocalDate.parse(existing_ddd, formatter);
//		cal.add(Calendar.DATE, 15);
//		String newDate = dateFormat.format(cal.getTime());
//
//		easePage.dddChange.click();
//		
//		
//		 String currentWindow = getDriver().getWindowHandle(); // will keep current window to switch back
//  		  for (String winHandle : getDriver().getWindowHandles()) {
//  			String titleOfWindow = getDriver().switchTo().window(winHandle).getTitle();
//  			System.out.println("Title of Window2-" + titleOfWindow);
//
//  			if (titleOfWindow.contains("Desired Due Date Change")) {
//  				System.out.println("Switched to Desired Due Date Change window");
//
//  				//WebElement dueDateFrame=getDriver().findElement(By.xpath("//frame[@id='topFrame2']"));
//  				getDriver().switchTo().frame(easePage.suppsFrame);
//  				easePage.dddtext.type(newDate);
//  				waitABit(2000);
//  				easePage.changeButton.click();
//  				waitABit(2000);
//  				break;
//	             }
//  			
//  		  }
//  		  
//  		  getDriver().switchTo().defaultContent();
//		
//	}
//
//	@Step
//	public void userSubmitUNIChangeOrder() throws IOException {
//		String sheetName="UNI_Change";
//		String service,esValue,tspValue,specValue;
//	
//		esValue=BaseStep.readExcelData(sheetName,9, 1);
//		tspValue=BaseStep.readExcelData(sheetName,3, 1);
//		specValue=BaseStep.readExcelData(sheetName,5, 1);
//		service=BaseStep.readExcelData(sheetName,2, 1);
//
//		easePage.ecckt.sendKeys(service);
//		
//		
//		//enterOrderDetails()
//		
//	}	
//	
//	@Step
//	public void user_Search_Install_PON(String pon)
//	{
//		getDriver().switchTo().frame(1);
//		System.out.println("Switched to EASE home page frame");
//		waitABit(3000);
//		Actions a1 = new Actions(getDriver());
//		a1.moveToElement(easePage.orderTab).build().perform();
//		waitABit(3000);
//		System.out.println("Mouse over to Order Tab section ");
//
//		a1.moveToElement(easePage.searchMenuOption).click().build().perform();
//		waitABit(4000);
//
//		String currentWindow = getDriver().getWindowHandle(); // will keep current window to switch back
//		for (String winHandle : getDriver().getWindowHandles()) {
//			String title = getDriver().switchTo().window(winHandle).getTitle();
//			System.out.println("Title of window-" + title);
//			if (title.equals("Order Search Page")) {
//				System.out.println("Switched to Order Search Page Window");
//				break;
//			} else {
//				getDriver().switchTo().window(currentWindow);
//			}
//		}
//
//		easePage.searchText.sendKeys(pon);
//		System.out.println("Entered PON number in Search Text Box");
//		waitABit(1000);
//		easePage.searchButton.click();
//		System.out.println("Clicked on PON number Search button");
//		waitABit(2000);
//		String titleOfWindow = getDriver().switchTo().window(currentWindow).getTitle();
//		System.out.println("Title of Window2-" + titleOfWindow);
//		System.out.println("Switched back to Ease home page window");
//		waitABit(2000);
//		getDriver().switchTo().frame(1);
//		System.out.println("Switched to EASE home page frame");
//			
//		if((pon.contains("UNI"))||pon.contains("COM"))
//		{
//			easePage.radioSelectionOfUNI_EVCCOMBO_PON.click();
//			System.out.println("Selected the Seached PON radio button");
//			String ponElement1="//td/span/a/span[contains(.,'";
//			String ponElement2="')]";
//			WebElement ponElement=getDriver().findElement(By.xpath(ponElement1+pon+ponElement2));
//			ponElement.click();
//			waitABit(6000);
//		}
//		else if((pon.contains("EVC"))||pon.contains("OVC")) 
//		{
//			easePage.radioSelectionOfEVC_OVC_PON.click();
//			System.out.println("Selected the Seached PON radio button");		
//			String ponElement1="//td/span/a/span[contains(.,'";
//			String ponElement2="')]";		
//			WebElement ponElement=getDriver().findElement(By.xpath(ponElement1+pon+ponElement2));
//			ponElement.click();
//			waitABit(6000);
//		}
//	}
//	
//	@Step
//	public void user_Submit_Supp1_On_Order(String pon)
//	{
//		String windowTitle="MCI - "+pon;
//		String currentWindow1 = getDriver().getWindowHandle(); // will keep current window to switch back
//		for (String winHandle : getDriver().getWindowHandles()) {
//			String title = getDriver().switchTo().window(winHandle).getTitle();
//			System.out.println("Title of window-" + title);
//			if (title.contains(windowTitle)) {
//				System.out.println("Switched to ASR Order Page Window");
//				break;
//			} else {
//				getDriver().switchTo().window(currentWindow1);
//			}
//		}
//		
//		String currentWindow = getDriver().getWindowHandle();
//		easePage.supp1Icon.click();
//		System.out.println("Successfully clicked on supp1 icon");
//		waitABit(6000);
//		Alert a1= getDriver().switchTo().alert();
//		a1.accept();
//		waitABit(8000);	 
//
//		// String currentWindow = getDriver().getWindowHandle(); // will keep current window to switch back
// 		  for (String winHandle : getDriver().getWindowHandles()) {
// 			String titleOfWindow = getDriver().switchTo().window(winHandle).getTitle();
// 			System.out.println("Title of Window2-" + titleOfWindow);
//
// 			if (titleOfWindow.contains("Cancel")) {
// 				System.out.println("Switched to Cancel window");
// 				waitABit(2000);
// 				//WebElement cancelFrame=getDriver().findElement(By.xpath("//frame[@id='topFrame2']"));		
// 				getDriver().switchTo().frame(easePage.suppsFrame);
// 				System.out.println("Switched to Cancel frame");
// 				easePage.changeButton.click();
// 				System.out.println("Successfully clicked on ok button");
// 				break;
//	            }
// 			
// 		  }
// 		  //getDriver().switchTo().defaultContent();
// 		  waitABit(5000);	
// 		  getDriver().switchTo().window(currentWindow);
// 		 	 
// 		waitABit(15000);
//		String statusOfOrder = easePage.statusOfOrder.getAttribute("value");
//		System.out.println("statusOfOrder-" + statusOfOrder);
//		Assert.assertEquals("Cancel Submitted", statusOfOrder);
//	}
//	
//	@Step
//	public void user_Open_Install_Order(String pon)
//	{
//		String windowTitle="MCI - "+pon;
//		String currentWindow1 = getDriver().getWindowHandle(); // will keep current window to switch back
//		for (String winHandle : getDriver().getWindowHandles()) {
//			String title = getDriver().switchTo().window(winHandle).getTitle();
//			System.out.println("Title of window-" + title);
//			if (title.contains(windowTitle)) {
//				System.out.println("Switched to ASR Order Page Window");
//				break;
//			} else {
//				getDriver().switchTo().window(currentWindow1);
//			}
//		}		
//	}
//	
//}