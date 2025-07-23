package com.ctl.it.qa.Test_Four.tools.steps.user;

import java.time.Duration;
import javax.mail.MessagingException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.ctl.it.qa.Test_Four.tools.pages.common.LoginPage;
import com.ctl.it.qa.Test_Four.tools.steps.E2ESteps;
import net.serenitybdd.annotations.Step;

@SuppressWarnings("serial")
public class UserSteps extends E2ESteps {

	LoginPage loginPage;
	private final Logger logger = LoggerFactory.getLogger(UserSteps.class);

	//@SuppressWarnings("deprecation")
	@Step
	public void logs_in_as(String userType) {
		System.setProperty("Type.ID", userType);
		String mytypeID = System.getProperty("Type.ID");
		logger.info("userType is  " + mytypeID); // end of getting user type id
		// loginPage.enterCredentials(userType);
		String myUser = envData.getContainer("LoginPage").getContainer(userType).getFieldValue("tbx_username");
		String myUserPassword = envData.getContainer("LoginPage").getContainer(userType).getFieldValue("tbx_password");
		waitABit(5000);
		loginPage.btn_next_submit.waitUntilClickable().withTimeoutOf(Duration.ofSeconds(2000));
		loginPage.tbx_username.sendKeys(myUser);
		loginPage.btn_next_submit.waitUntilClickable().withTimeoutOf(Duration.ofSeconds(10));
		loginPage.btn_next_submit.click(); // click on new button new code for 2 step
		// waitABit(2000);
		loginPage.waitForTextToAppear("Enter password", 5000);
		loginPage.tbx_password.sendKeys(myUserPassword);
		
		
		
//		enterEncryptedPassword(loginPage.tbx_password, myUser);
//		shouldExist(loginPage);
//		IntDataContainer datacontainer= envData.getContainer(loginPage.getClass().getSimpleName()).getContainer(userType);
//		fillFields(loginPage, datacontainer.getMandatoryFieldsFromAllContainers());
		
		loginPage.btn_next_submit.waitUntilClickable().withTimeoutOf(Duration.ofSeconds(10));
		loginPage.btn_next_submit.click(); // click on new button new code for 2 step
		// waitABit(2000);
		loginPage.waitForTextToAppear("Do this to reduce the number of times you are asked to sign in.", 190000);

		loginPage.btn_NO.waitUntilClickable().withTimeoutOf(Duration.ofSeconds(500));
		loginPage.btn_NO.click(); // click the no button
		logger.info("Successfully logged in SFA");
	}

	public void is_in_sfa_login_page() {
//		System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
//		ChromeOptions options = new ChromeOptions();
		// options.setPageLoadStrategy(PageLoadStrategy.EAGER);
//		options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
		loginPage.openAt(envData.getFieldValue("url"));
		getDriver().manage().window().maximize();
		waitABit(1000);
		String tempcurrentURL = getDriver().getCurrentUrl(); // get the current url
		logger.info("currentURL  is  " + tempcurrentURL); // // get the current url
		System.setProperty("URL.ID", tempcurrentURL); // set the url into memory
		String OrginalURL = System.getProperty("URL.ID"); // get the url from memory
		logger.info("OrginalURL  is  " + OrginalURL); // end of getting original url
		loginPage.btn_SSO.click(); // click on the single sign in button
		logger.info("Successfully launched the SFA url");

	}

//	@Step
//	public void should_be_on_home_page() {
//		homePage.shouldExist(homePage);
//	}

	@Step
	public void should_be_on_login_page() {
		loginPage.shouldExist(loginPage);
	}

	@Step
	public void user_can_work_order_in_provisioning() throws MessagingException {
		System.out.println("user_can_work_order_in_provisioning");
		String currentURL = getDriver().getCurrentUrl(); // get the current url of
		System.out.println("currentURL is " + currentURL); // // get the current url
		String myEnv = System.getProperty("staf.environment.key");
		logger.info("the Env is : " + myEnv);
//		waitABit(10000);		
//		String to[] = { "Rajneesh.k.gautam@lumen.com", "ericw.steele@centurylink.com", "swarna.mishra@level3.com" };
//		 SendMail.send("staf.sanity@centurylink.com", to, "Digital Dialog - " +
//				 " - "+ currentURL +" - "+" - "+ myEnv, "");
		// tasknum + nSwiftID +" - "+ currentURL +" - "+" - "+ myEnv, "");
	}
	
	
	
	
	/////EASE///////
	
//
//	public void searchPON() {
//		
//		 String orderId="RGUNITEST";
//		WebDriver ele=getDriver().switchTo().frame(1);
//		//String ele1= getDriver().getPageSource();
//		//System.out.println(ele1);
//		
//		waitABit(8000);
//		WebElement order=getDriver().findElement(By.xpath("//th[@id='orderTab']//a/img"));
//		Actions a1=new Actions(getDriver());
//		a1.moveToElement(order).build().perform();
//		
//		waitABit(7000);
//
//	        String currentWindow = getDriver().getWindowHandle();  //will keep current window to switch back
//	        for(String winHandle : getDriver().getWindowHandles()){
//	        	//System.out.println("CurrWndow="+winHandle);
//	        	//System.out.println(getDriver().getTitle());
//	        	String title=getDriver().switchTo().window(winHandle).getTitle();
//	        	System.out.println("Title of window-"+title);
//	          //if (getDriver().switchTo().window(winHandle).getTitle().equals("Order SaveAs... VFO")) {
//	           if (title.equals("Order Search Page")) {
//	        	   //This is the one you're looking for
//	             break;
//	           } 
//	           else {
//	        	   getDriver().switchTo().window(currentWindow);
//	           } 
//	        }
//	        
////	        waitABit(2000);
////	        getDriver().findElement(By.xpath("//input[@name='newPon']")).sendKeys("RGUNITEST1");
////	        waitABit(2000);
////	        getDriver().findElement(By.xpath("//input[@id='ICSC']")).sendKeys("MS02");
////	        waitABit(2000);
////	        getDriver().switchTo().activeElement().sendKeys(Keys.ENTER);
////	        waitABit(2000);
////	        getDriver().findElement(By.xpath("//img[@id='savegif']")).click();
////	        waitABit(5000);
//	       
//	        
//	        WebElement searchButton=getDriver().findElement(By.xpath("//img[@onclick='javascript:goSearch();']"));
//	        WebElement searchText=getDriver().findElement(By.xpath("//input[@name='searchFor'] "));
//	        searchText.sendKeys(orderId);		  
//	        searchButton.click();
//	        
//	        
//	        waitABit(5000);
//	        String titleOfWindow=getDriver().switchTo().window(currentWindow).getTitle();
//	        System.out.println("Title of Window2-"+titleOfWindow);
//	        //getDriver().switchTo().window(currentWindow);
//	        waitABit(5000);
//	        getDriver().switchTo().frame(1);
//	      //frame[@name='mainFrame']
//	        WebElement radio=getDriver().findElement(By.xpath("//td/span[contains(text(),'End User Switched Ethernet')]//../../th/input[@name='selectedRadio']")); 
//	        radio.click();
//	        waitABit(5000);
//	        WebElement ponNumber=getDriver().findElement(By.xpath("(//td/span[contains(text(),'End User Switched Ethernet')]//../..//td//a[contains(@href,'RGUNITEST')])[1]"));
//	        ponNumber.click();
//	        waitABit(8000);
//	        String currentWindow1 = getDriver().getWindowHandle();  //will keep current window to switch back
//	        for(String winHandle1 : getDriver().getWindowHandles()){
//	        	String titleOfWindow3=getDriver().switchTo().window(winHandle1).getTitle();
//		        System.out.println("Title of Window3-"+titleOfWindow3);
//	        	//System.out.println("CurrWndow="+winHandle);
//	           //if (getDriver().switchTo().window(winHandle).getTitle().equals("Order SaveAs... VFO")) {
//	           if (titleOfWindow3.contains("End User Switched Ethernet - Form: ASR")) {
// 
//	        	   //This is the one you're looking for
//	             break;
//	           } 
//	           else {
//	        	   getDriver().switchTo().window(currentWindow1);
//	           } 
//	        }
//	       // MCI - RGUNIMAY19-05 - 01 - End User Switched Ethernet - Form: ASR
//	        
//	        WebElement ccna=getDriver().findElement(By.xpath("//select[@name='selectedccna']"));
//	        Select s1=new Select(ccna);
//	        s1.selectByVisibleText("MCI");
//	        
//	        WebElement ddd=getDriver().findElement(By.xpath("//input[@name='ASR_SERVICE_REQUEST::0#SWITCHED_ETHERNET_SVC::0#ASR::0#ADMIN::0#DDD::0']"));
//	        ddd.sendKeys("06/25/2025");
//	        
//	        WebElement sesMenu=getDriver().findElement(By.xpath("//td/img[@id='SESMenu']"));
//	        sesMenu.click();
//	        WebElement ES=getDriver().findElement(By.xpath("//select[@name='ASR_SERVICE_REQUEST::0#SWITCHED_ETHERNET_SVC::0#SES::0#SES_SVC_DETAILS::0#ES::0']"));
//	        Select s2=new Select(ES);
//	       // s2.selectByVisibleText("S");
//	        
//	        WebElement validate=getDriver().findElement(By.xpath("//div/a/img[@title='Validate']"));
//	        validate.click();
//	        waitABit(18000);
//	        WebElement frame=getDriver().findElement(By.xpath("//iframe[@name='Wisor']"));
//	        
//	        getDriver().switchTo().frame(frame);
//	        List<WebElement> allError=getDriver().findElements(By.xpath("//body[@bgcolor='#FFFFFF' and @text='#000000']/table[@width='98%']/tbody/tr[contains(@bgcolor,'#')]"));
//	     
//	        List<WebElement> allErrorText=getDriver().findElements(By.xpath("//body[@bgcolor='#FFFFFF' and @text='#000000']/table[@width='98%']/tbody/tr[contains(@bgcolor,'#')]/td//a"));
//	        //allErrorText.size();
//	        System.out.println("Size of error-"+allErrorText.size());
//	        for (int i=0;i<=allErrorText.size()-1;i++)  
//	        {
//	        	String errorText=allErrorText.get(i).getText();
//	        	System.out.println("Error no "+i+ errorText);
//	        	if(orderId.contains("UNI")&&errorText.equals("GIVEN ADDRESS IS NEAR_MATCH"))
//	        	{
//	        		System.out.println("ignore error");
//	        	}
//	        	else if(orderId.contains("EVC"))
//	        	{
//	        		
//	        	}
//	        	else
//	        	{
//	        		System.out.println("throw exception");
//	        	}
//	        }
//	        
//	        getDriver().switchTo().defaultContent();
//	        waitABit(2000);
//	        
//	        WebElement closeError=getDriver().findElement(By.xpath("(//td[text()='ErrorCode List']/../td[3]//a[2])[1]"));
//	        Actions a2= new Actions(getDriver());
//	        a2.moveToElement(closeError).click().build().perform();
//	        
//	        waitABit(5000);
//	        WebElement submit=getDriver().findElement(By.xpath("//th[@id='submitIconId1']"));
//	        a2.moveToElement(submit).click().build().perform();
//	        
//	        waitABit(20000);
//	        
//	        String statusOfOrder= getDriver().findElement(By.xpath("//input[@name='status']")).getAttribute("value");
//		    System.out.println("statusOfOrder-"+statusOfOrder);
//	        
//	        		
	        
	        
//	        
	        
//
//	        // Here we will check if child window has other child windows and will fetch the heading of the child window
//	        while (iterator.hasNext()) {
//	            String ChildWindow = iterator.next();
//	            System.out.println(ChildWindow);
//	                if  (!mainWindowHandle.equalsIgnoreCase(ChildWindow)) {
//	                getDriver().switchTo().window(ChildWindow);
//	                WebElement text = getDriver().findElement(By.id("sampleHeading"));
//	                System.out.println("Heading of child window is " + text.getText());
//	            }
//	        }
//	    }
	
		//th[@id='orderTab']//a/img
//}
}