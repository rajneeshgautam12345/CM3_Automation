package com.ctl.it.qa.Test_Four.tools.steps.eservices;

import org.openqa.selenium.By;

import com.ctl.it.qa.Test_Four.tools.pages.common.LoginPage;
import com.ctl.it.qa.Test_Four.tools.pages.eservices.FullSanityPage;

import net.serenitybdd.annotations.Step;

@SuppressWarnings("serial")
public class FullSanitySteps extends BaseStep {
	FullSanityPage fullsanitypage;
	LoginPage loginPage;


	@Step
	public void i_am_checking_Mesh_in_specified_environment(String ENV) {
		if (ENV.contains("1")) {
			fullsanitypage.openAt(
					"https://sasi-test1.kubeodc.corp.intranet//inventory/v1/mesh/paths?aend=LTTNCOML&product=ETHERNET&numpaths=1&bandwidth=1000&diversity=No&interface=Optical&protection=No&lowLatency=No&dwdmOnly=No");
		}
		if (ENV.contains("2")) {
			fullsanitypage.openAt(
					"https://sasi-test2.kubeodc.corp.intranet//inventory/v1/mesh/paths?aend=LTTNCOML&product=ETHERNET&numpaths=1&bandwidth=1000&diversity=No&interface=Optical&protection=No&lowLatency=No&dwdmOnly=No");
		}
		if (ENV.contains("4")) {
			fullsanitypage.openAt(
					"https://sasi-test4.kubeodc.corp.intranet//inventory/v1/mesh/paths?aend=LTTNCOML&product=ETHERNET&numpaths=1&bandwidth=1000&diversity=No&interface=Optical&protection=No&lowLatency=No&dwdmOnly=No");
		}
		WaitForPageToLoad(60);
		System.out.println("Mesh Page Launched");
		String url = getDriver().getCurrentUrl();
		System.out.println("Current URL : " + url);
		fullsanitypage.maximize();
		WaitForPageToLoad(10); // wait for auto log in
	}

	@Step
	public void i_am_checking_SASI_in_specified_environment(String ENV) {
	}

	@Step
	public void i_am_checking_ACT_in_specified_environment(String ENV) {
	}

	public void user_is_in_autopilot_page() {
	
		    String AP_Url="https://autopilotapp-test1-01.test.intranet:3443/";
			loginPage.openAt(AP_Url);
			getDriver().manage().window().maximize();
			waitABit(1000);
			String tempcurrentURL = getDriver().getCurrentUrl(); // get the current url
			System.out.println("currentURL  is  " + tempcurrentURL); // // get the current url
			System.setProperty("URL.ID", tempcurrentURL); // set the url into memory
			String OrginalURL = System.getProperty("URL.ID"); // get the url from memory
			//logger.info("OrginalURL  is  " + OrginalURL); // end of getting original url
			
			getDriver().findElement(By.xpath("//input[@name='username']")).sendKeys("AC67376");
			waitABit(2000);
			getDriver().findElement(By.xpath("//input[@name='password']")).sendKeys("Testinglevel@95");
			waitABit(2000);
			getDriver().findElement(By.xpath("//button[@id='sign_in']")).click();
			waitABit(5000);	
}

	public void user_navigate_to_LNAAS_DELETE_TRANSACTION_ACT_TL_V1_flow() {
		
		getDriver().navigate().to("https://autopilotapp-test1-01.test.intranet:3443/workflow_builder/edit?name=LNAAS_DELETE_TRANSACTION_ACT_TL_V1");
		waitABit(3000);
		getDriver().findElement(By.xpath("//button[@aria-label='Start']")).click();
		waitABit(5000);
		getDriver().findElement(By.xpath("//button[@title='Start']")).click();
		waitABit(5000);
		getDriver().findElement(By.xpath("//textarea[@id='job-variables-editor']")).clear();
		waitABit(5000);
				
	}

	public void user_enter_the_request_payload_for_EVC_OVC_Delete(String actIdentifierId, String correlationId) {

		String EVC_OVC_Delete_Payload = String.join(System.lineSeparator(),
			    "{",
			    "  \"requestPayload\": {",
			    "    \"actIdentifierId\": \""+actIdentifierId+"\",",
			    "    \"correlationId\": \""+correlationId+"\"",
			    "  }",
			    "}"
			);
	
	
		getDriver().findElement(By.xpath("//textarea[@id='job-variables-editor']")).sendKeys(EVC_OVC_Delete_Payload);
			
		
	}
	
	public void userStartTheWorkflow() {
		waitABit(5000);
		getDriver().findElement(By.xpath("//button[@title='Start']")).click();
		waitABit(60000);
		
	}
	
	public void user_navigate_to_LNAAS_DELETE_COLORLESS_PORT_SL_V1() {
		getDriver().navigate().to("https://autopilotapp-test1-01.test.intranet:3443/workflow_builder/edit?name=LNAAS_DELETE_COLORLESS_PORT_SL_V1");
		waitABit(3000);
		getDriver().findElement(By.xpath("//button[@aria-label='Start']")).click();
		waitABit(3000);
		getDriver().findElement(By.xpath("//button[@title='Start']")).click();
		waitABit(4000);
		getDriver().findElement(By.xpath("//textarea[@id='job-variables-editor']")).clear();
		waitABit(3000);	
	}
	
	public void user_enter_the_request_payload_for_UNI_Delete(String customerName,String UNIServiceId) {

		String customerNo="";
		if(customerName.equals("VERIZON COMMUNICATIONS"))
		{
			 customerNo="2175";
		}
		else if (customerName.equals("AT&T COMMUNICATIONS"))
		{
			 customerNo="2932";
		}
		else if (customerName.equals("VERIZON WIRELESS"))
		{
			 customerNo="41171";
		}
		else
		{
			 customerNo="2175";
		}
		
		String UNIDeletePayload = String.join(System.lineSeparator(),
			    "{",
			    "  \"requestPayload\": {",
			    "    \"parentCorrelationId\": \"AP-553022638-1690357787465-253550130\",",
			    "    \"failFast\": false,",
			    "    \"customerInfo\": {",
			    "      \"customerName\": \""+customerName+"\",",
			    "      \"customerNumber\": \""+customerNo+"\"",
			    "    },",
			    "    \"orderInfo\": {",
			    "      \"orderSource\": \"SwIFT\",",
			    "      \"orderSourceNumber\": \"553022638\",",
			    "      \"orderId\": \"553022638\",",
			    "      \"orderVersion\": \"1\",",
			    "      \"fulfillmentRequestNumber\": \"\",",
			    "      \"customerRequestedDate\": \"\",",
			    "      \"customerCommittedDate\": \"\"",
			    "    },",
			    "    \"productInfo\": {",
			    "      \"productOfferName\": \"UNI\",",
			    "      \"productInstanceId\": \"338808470\",",
			    "      \"mainProductId\": \"442840513\",",
			    "      \"productSubType\": \"port\",",
			    "      \"localAffiliateName\": \"EQ\"",
			    "    },",
			    "    \"networkInfo\": {",
			    "      \"inventoryUpdateType\": \"hardDelete\",",
			    "      \"portContainer\": {",
			    "        \"serviceId\": \""+UNIServiceId+"\"",
			    "      }",
			    "    }",
			    "  }",
			    "}"
			);
	
	
		getDriver().findElement(By.xpath("//textarea[@id='job-variables-editor']")).sendKeys(UNIDeletePayload);
			
	}
	
	
}
