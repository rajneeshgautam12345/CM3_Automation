package com.ctl.it.qa.Test_Four.tools.steps.ease;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ctl.it.qa.Test_Four.tools.pages.common.EasePage;
import com.ctl.it.qa.Test_Four.tools.pages.common.LoginPage;
import com.ctl.it.qa.Test_Four.tools.steps.E2ESteps;
import net.serenitybdd.annotations.Step;

@SuppressWarnings("serial")
public class EaseSteps extends E2ESteps {

	LoginPage loginPage;
	EasePage easePage;
	private final Logger logger = LoggerFactory.getLogger(EaseSteps.class);
	public static String pon_Number;

	// @SuppressWarnings("deprecation")
	@Step
	public void logs_in_as(String userType) {
		System.setProperty("Type.ID", userType);
		String mytypeID = System.getProperty("Type.ID");
		logger.info("userType is  " + mytypeID); // end of getting user type id
		String myUser = envData.getContainer("LoginPage").getContainer(userType).getFieldValue("tbx_username");
		String myUserPassword = envData.getContainer("LoginPage").getContainer(userType).getFieldValue("tbx_password");
		waitABit(5000);
		loginPage.btn_next_submit.waitUntilClickable().withTimeoutOf(Duration.ofSeconds(2000));
		loginPage.tbx_username.sendKeys(myUser);
		loginPage.btn_next_submit.waitUntilClickable().withTimeoutOf(Duration.ofSeconds(10));
		loginPage.btn_next_submit.click(); // click on new button new code for 2 step
		loginPage.waitForTextToAppear("Enter password", 60000);
		loginPage.tbx_password.sendKeys(myUserPassword);

//		enterEncryptedPassword(loginPage.tbx_password, myUser);
//		shouldExist(loginPage);
//		IntDataContainer datacontainer= envData.getContainer(loginPage.getClass().getSimpleName()).getContainer(userType);
//		fillFields(loginPage, datacontainer.getMandatoryFieldsFromAllContainers());

		loginPage.btn_next_submit.waitUntilClickable().withTimeoutOf(Duration.ofSeconds(10));
		loginPage.btn_next_submit.click(); // click on new button new code for 2 step
		loginPage.waitForTextToAppear("Do this to reduce the number of times you are asked to sign in.", 190000);

		loginPage.btn_NO.waitUntilClickable().withTimeoutOf(Duration.ofSeconds(500));
		loginPage.btn_NO.click(); // click the no button
		logger.info("Successfully logged in SFA");
	}

	@Step
	public void is_in_ease_login_page() {
		String vfoUrl = envData.getFieldValue("EASE");
//		ChromeOptions options = new ChromeOptions();
//		LoggingPreferences logPrefs = new LoggingPreferences();
//		logPrefs.enable(LogType.BROWSER, Level.ALL);
//		options.setCapability(options.LOGGING_PREFS, logPrefs);
//		new ChromeDriver(options);
//		loginPage.getDevTools();
		String tagName=System.getProperty("ScenarioName");
		if(tagName.equals("UNI_Install_PerPort_SVCMUX")||tagName.equals("UNI_Install_PerService_SVCMUX")||tagName.equals("UNI_Install_PerPort_TLSMOE")||tagName.equals("UNI_Install_PerService_TLSMOE")||tagName.equals("EVC_COMBO_INSTALL")||tagName.equals("OVC_COMBO_INSTALL")||tagName.equals("EVC_GREEN_COMBO_INSTALL"))
		{	
		System.out.println("EASE url=" + vfoUrl);
		String meshRes = System.getProperty("Mesh Response"); // get the url from memory
		if(meshRes.startsWith("NID"))
		{
			loginPage.openAt(vfoUrl);
			getDriver().manage().window().maximize();
			waitABit(1000);
			String tempcurrentURL = getDriver().getCurrentUrl(); // get the current url
			System.out.println("currentURL  is  " + tempcurrentURL); // // get the current url
			System.setProperty("URL.ID", tempcurrentURL); // set the url into memory
			String OrginalURL = System.getProperty("URL.ID"); // get the url from memory
			logger.info("OrginalURL  is  " + OrginalURL); // end of getting original url
			
		}else
		{
			//System.out.println("Mesh returns-"+meshRes);	
			E2ESteps.printInRedColor("Mesh returns "+meshRes, "- Don't have any port available to progress UNI/Combo order.So failing scripts");
			Assert.assertEquals("NID", meshRes);
			
		}
		}
		else {
		loginPage.openAt(vfoUrl);
		getDriver().manage().window().maximize();
		waitABit(1000);
		String tempcurrentURL = getDriver().getCurrentUrl(); // get the current url
		System.out.println("currentURL  is  " + tempcurrentURL); // // get the current url
		System.setProperty("URL.ID", tempcurrentURL); // set the url into memory
		String OrginalURL = System.getProperty("URL.ID"); // get the url from memory
		logger.info("OrginalURL  is  " + OrginalURL); // end of getting original url
		}

	}

	@Step
	public void should_be_on_login_page() {
		loginPage.shouldExist(loginPage);
	}

	@Step
	public void SearchPONNumber(String order) {
		String referencePON = "";
		if (order.equals("UNI")) {
			referencePON = "RGUNITEST";
		}

		else if (order.equals("EVC")) {
			referencePON = "RGEVCINSREF";
		} else if (order.equals("EVCCOMBO")) {
			referencePON = "EVCCOMBOINSREF";
		} else if (order.equals("OVC")) {
			referencePON = "OVCINSREF";
		} else if (order.equals("OVCCOMBO")) {
			referencePON = "OVCCOMBOINSREF";
		} else if (order.equals("MOVE")) {
			referencePON = "RGMOVETEST22";
		} else if (order.equals("TRANSFER")) {
			referencePON = "UNITRANSFERREF";
		} else if (order.equals("UNI_Disconnect")) {
			referencePON = "UNIDISCO";
		} else if (order.equals("EVC_Disconnect")) {
			referencePON = "EVCDISCOREF";
		}

		getDriver().switchTo().frame(1);
		System.out.println("Switched to EASE home page frame");
		waitABit(2000);
		Actions a1 = new Actions(getDriver());
		a1.moveToElement(easePage.orderTab).build().perform();
		System.out.println("Mouse over to Order Tab section ");
		easePage.searchMenuOption.waitUntilClickable().withTimeoutOf(Duration.ofSeconds(10));
		a1.moveToElement(easePage.searchMenuOption).click().build().perform();
		waitABit(4000);
		String currentWindow = getDriver().getWindowHandle(); // will keep current window to switch back
		for (String winHandle : getDriver().getWindowHandles()) {
			String title = getDriver().switchTo().window(winHandle).getTitle();
			System.out.println("Title of window-" + title);
			if (title.equals("Order Search Page")) {
				System.out.println("Switched to Order Search Page Window");
				break;
			} else {
				getDriver().switchTo().window(currentWindow);
			}
		}
		easePage.searchText.sendKeys(referencePON);
		System.out.println("Entered PON number in Search Text Box");
		easePage.searchButton.waitUntilClickable().withTimeoutOf(Duration.ofSeconds(10));
		easePage.searchButton.click();
		System.out.println("Clicked on PON number Search button");
		waitABit(2000);
		String titleOfWindow = getDriver().switchTo().window(currentWindow).getTitle();
		System.out.println("Title of Window-" + titleOfWindow);
		System.out.println("Switched back to Ease home page window");
		waitABit(2000);
		getDriver().switchTo().frame(1);
		System.out.println("Switched to EASE home page frame");
		easePage.radioSelectionOfPON.click();
		System.out.println("Selected the Seached PON radio button");
		waitABit(2000);
		logger.info("Order record successfully selected");
	}

	@Step
	public void enterOrderDetails(String ponNumber, String ICSC, String activity) {
		Actions a1 = new Actions(getDriver());
		a1.moveToElement(easePage.orderTab).build().perform();
		System.out.println("Mouse over to Order Tab section ");
		easePage.saceAsOrderMenuOption.waitUntilClickable().withTimeoutOf(Duration.ofSeconds(10));
		a1.moveToElement(easePage.saceAsOrderMenuOption).click().build().perform();
		waitABit(5000);

		String currentWindow = getDriver().getWindowHandle(); // will keep current window to switch back
		for (String winHandle : getDriver().getWindowHandles()) {
			String title = getDriver().switchTo().window(winHandle).getTitle();
			System.out.println("Title of window-" + title);
			if (title.equals("Order SaveAs... VFO")) {
				System.out.println("Switched to Order SaveAs...VFO Window");
				break;
			} else {
				getDriver().switchTo().window(currentWindow);
			}
		}
		easePage.enterPONNumber.sendKeys(ponNumber);
		System.out.println("PON Number entered-" + ponNumber);
		System.setProperty("PON.NO", ponNumber);
		String ponNo = System.getProperty("PON.NO");
		System.out.println("PON Number entered-" + ponNo);
		easePage.enterICSE.waitUntilClickable().withTimeoutOf(Duration.ofSeconds(10));
		easePage.enterICSE.sendKeys(ICSC);
		waitABit(1200);
		getDriver().switchTo().activeElement().sendKeys(Keys.ENTER);
		System.out.println("ICSC value entered");
		waitABit(1000);
		easePage.activity.selectByVisibleText(activity);
		waitABit(800);
		easePage.save.click();
		System.out.println("Save button clicked");
		waitABit(5000);

		pon_Number = ponNumber;
		logger.info(ponNumber + "-Order successfully saved");

	}

	@Step
	public void enterASRPageDetails(String ccna, String dd, String specCode, String remarks, String tspValue,
			String ecckt) {

		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy"); // Set Date
		Calendar cal = Calendar.getInstance();
		Calendar cal1 = Calendar.getInstance();
		cal.setTime(new Date());
		cal1.setTime(new Date());
		cal.add(Calendar.DATE, 15);
		cal1.add(Calendar.DATE, 0);
		String newDate = dateFormat.format(cal.getTime());
		String discDate = dateFormat.format(cal1.getTime());
		System.out.println(dateFormat.format(cal.getTime()));

		String currentWindow = getDriver().getWindowHandle(); // will keep current window to switch back
		for (String winHandle : getDriver().getWindowHandles()) {
			String titleOfWindow = getDriver().switchTo().window(winHandle).getTitle();
			System.out.println("Title of Window-" + titleOfWindow);

			if (titleOfWindow.contains("End User Switched Ethernet - Form: ASR")) {
				System.out.println("Switched to End User Switched Ethernet - Form: ASR Window");
				break;
			} else {
				getDriver().switchTo().window(currentWindow);
			}
		}

		String act = easePage.activityHeader.getAttribute("value");
		if (!ccna.equals("")) {
			Select s1 = new Select(easePage.ccna);
			waitABit(1000);
			s1.selectByVisibleText(ccna);
			System.out.println("CCNA calue selected");
			waitABit(500);
		}

		if (!dd.equals("")) {
			if (act.equals("D")) {
				easePage.dueDate.sendKeys(discDate);
			} else {
				easePage.dueDate.sendKeys(newDate);
				System.out.println("Due Date entered");
			}

		}

		if (!specCode.equals("")) {
			waitABit(500);
			easePage.specCode.clear();
			easePage.specCode.sendKeys(specCode);
			System.out.println("Spec Code Value entered");
		}

		if (!remarks.equals("")) {
			waitABit(500);
			easePage.remarks.clear();
			easePage.remarks.sendKeys(remarks);
			System.out.println("Remarks value entered");
			waitABit(500);
		}

		if (!tspValue.equals("")) {
			waitABit(500);
			easePage.tsp.clear();
			easePage.tsp.sendKeys(tspValue);
			System.out.println("TSP value entered");
			waitABit(500);
		}
		if (!ecckt.equals("")) {
			waitABit(500);
			easePage.ecckt.clear();
			easePage.ecckt.sendKeys(ecckt);
			System.out.println("ECCKT value entered");
			waitABit(1000);
		}
		logger.info("ASR Details successfully entered");
	}

	@Step
	public void enterSESDetails(String esValue, String ncCodeValue, String nciCodeValue, String secNciValue,
			String espValue) {

		easePage.sesMenu.click();
		System.out.println("Switched to SES Menu section");
		waitABit(1500);

		if (!esValue.equals("")) {
			Select s2 = new Select(easePage.esValue);
			s2.selectByVisibleText(esValue);
			System.out.println("ES Value selected");
			waitABit(800);

			if (esValue.equals("M")) {
				easePage.profe.clear();
				waitABit(500);
				easePage.profi.clear();
				waitABit(500);
			}
		}

		if (!ncCodeValue.equals("")) {
			easePage.ncCode.clear();
			easePage.ncCode.sendKeys(ncCodeValue);
			System.out.println("nc Code Value entered");
			waitABit(500);
		}

		if (!nciCodeValue.equals("")) {
			easePage.nciCode.clear();
			easePage.nciCode.sendKeys(nciCodeValue);
			System.out.println("nci Code Value entered");
			waitABit(500);
		}

		if (!secNciValue.equals("")) {
			easePage.secNci.clear();
			easePage.secNci.sendKeys(secNciValue);
			System.out.println("secNci Code Value entered");
			waitABit(500);
		}

		if (!espValue.equals("")) {
			easePage.esp.clear();
			easePage.esp.sendKeys(espValue);
			System.out.println("esp Value entered");
			waitABit(500);
		}

		logger.info("SES Details successfully entered");
	}

	@Step
	public void enterEVCDetails(String evcNC, String evcsp_ruid1, String ruid1, String evcNCI_ruid1, String vact_ruid1,
			String ce_vlan_ruid1, String los1_ruid1, String evcBandwidth_ruid1, String evcsp_ruid2, String ruid2,
			String evcNCI_ruid2, String vact_ruid2, String ce_vlan_ruid2, String los_ruid2, String evcBandwidth_ruid2) {

		easePage.evcMenu.click();
		System.out.println("Switched to EVC Menu section");
		waitABit(2000);

		if (!evcNC.equals("")) {
			easePage.evcNC.clear();
			easePage.evcNC.sendKeys(evcNC);
			System.out.println("NC Value entered");
			waitABit(700);
		}

		if (!evcsp_ruid1.equals("")) {
			easePage.evcsp_ruid1.clear();
			easePage.evcsp_ruid1.sendKeys(evcsp_ruid1); // M001 device
			System.out.println("evcsp_ruid1 Value entered");
			waitABit(700);
		}

		if (!ruid1.equals("")) {
			easePage.ruid1.clear();
			easePage.ruid1.sendKeys(ruid1);
			System.out.println("ruid1 Value entered");
			waitABit(700);
		}

		if (!evcNCI_ruid1.equals("")) {
			easePage.evcNCI_ruid1.clear();
			easePage.evcNCI_ruid1.sendKeys(evcNCI_ruid1);
			System.out.println("evcNCI_ruid1 Value entered");
			waitABit(700);
		}

		if ((!vact_ruid1.equals("")) && (evcNCI_ruid1.equals("02VLN.VST"))) {
			Select s2 = new Select(easePage.s_vact_ruid1);
			s2.selectByVisibleText(vact_ruid1);
			System.out.println("vact_ruid1 Value selected");
			waitABit(700);
		} else if ((!vact_ruid1.equals("")) && (!evcNCI_ruid1.equals("02VLN.VST"))) {
			Select s2 = new Select(easePage.ce_vact_ruid1);
			s2.selectByVisibleText(vact_ruid1);
			System.out.println("vact_ruid1 Value selected");
			waitABit(700);
		}

		if ((!ce_vlan_ruid1.equals("")) && (evcNCI_ruid1.equals("02VLN.VST"))) {
			easePage.s_vlan_ruid1.clear();
			easePage.s_vlan_ruid1.sendKeys(ce_vlan_ruid1);
			System.out.println("ce_vlan_ruid1 Value entered");
			waitABit(700);
		}

		else if ((!ce_vlan_ruid1.equals("")) && (!evcNCI_ruid1.equals("02VLN.VST"))) {
			easePage.ce_vlan_ruid1.clear();
			easePage.ce_vlan_ruid1.sendKeys(ce_vlan_ruid1);
			System.out.println("ce_vlan_ruid1 Value entered");
			waitABit(700);
		}

		if (!los1_ruid1.equals("")) {
			easePage.los1_ruid1.clear();
			easePage.los1_ruid1.sendKeys(los1_ruid1);
			System.out.println("los1_ruid1 Value entered");
			waitABit(700);
		}

		if (!evcBandwidth_ruid1.equals("")) {
			easePage.evcBandwidth_ruid1.clear();
			easePage.evcBandwidth_ruid1.sendKeys(evcBandwidth_ruid1);
			System.out.println("evcBandwidth_ruid1 Value entered");
			waitABit(700);
		}

		if (!evcsp_ruid2.equals("")) {
			easePage.evcsp_ruid2.clear();
			easePage.evcsp_ruid2.sendKeys(evcsp_ruid2); // M002 device
			System.out.println("evcsp_ruid2 Value entered");
			waitABit(700);
		}

		if (!ruid2.equals("")) {
			easePage.ruid2.clear();
			easePage.ruid2.sendKeys(ruid2);
			System.out.println("ruid2 Value entered");
			waitABit(700);
		}

		if (!evcNCI_ruid2.equals("")) {
			easePage.evcNCI_ruid2.clear();
			easePage.evcNCI_ruid2.sendKeys(evcNCI_ruid2);
			System.out.println("evcNCI_ruid2 Value entered");
			waitABit(700);
		}

		if ((!vact_ruid2.equals("")) && (!evcNCI_ruid2.equals("02VLN.VST"))) {
			Select s3 = new Select(easePage.ce_vact_ruid2);
			s3.selectByVisibleText(vact_ruid2);
			System.out.println("vact_ruid2 Value selected");
			waitABit(700);
		} else if ((!vact_ruid2.equals("")) && (evcNCI_ruid2.equals("02VLN.VST"))) {
			Select s3 = new Select(easePage.s_vact_ruid2);
			s3.selectByVisibleText(vact_ruid2);
			System.out.println("s_vact_ruid2 Value selected");
			waitABit(700);
		}

		if ((!ce_vlan_ruid2.equals("")) && (!evcNCI_ruid2.equals("02VLN.VST"))) {
			easePage.ce_vlan_ruid2.clear();
			easePage.ce_vlan_ruid2.sendKeys(ce_vlan_ruid2);
			System.out.println("ce_vlan_ruid2 Value entered");
			waitABit(700);
		} else if ((!ce_vlan_ruid2.equals("")) && (evcNCI_ruid2.equals("02VLN.VST"))) {
			easePage.s_vlan_ruid2.clear();
			easePage.s_vlan_ruid2.sendKeys(ce_vlan_ruid2);
			System.out.println("s_vlan_ruid2 Value entered");
			waitABit(700);
		}

		if (!los_ruid2.equals("")) {
			easePage.los_ruid2.clear();
			easePage.los_ruid2.sendKeys(los_ruid2);
			System.out.println("los_ruid2 Value entered");
			waitABit(700);
		}

		if (!evcBandwidth_ruid2.equals("")) {
			easePage.evcBandwidth_ruid2.clear();
			easePage.evcBandwidth_ruid2.sendKeys(evcBandwidth_ruid2);
			System.out.println("evcBandwidth_ruid2 Value entered");
			waitABit(700);
		}

		logger.info("EVC Details successfully entered");
	}

	@Step
	public void clickOnValidateButton_and_validateErrorText() {
		String orderId = easePage.retrievePON.getAttribute("value");
		easePage.validateButton.waitUntilClickable().withTimeoutOf(Duration.ofSeconds(10));
		easePage.validateButton.click();
		System.out.println("Clicked on validate button");
		easePage.errorPopupValidation.waitUntilEnabled().withTimeoutOf(Duration.ofSeconds(120));
		waitABit(2000);
		System.out.println("Error Popup Validated");

		getDriver().switchTo().frame(easePage.errorFrame);
		System.out.println("Switched to Error Page frame");
		System.out.println("Size of error-" + easePage.allErrorText.size());
		for (int i = 0; i <= easePage.allErrorText.size() - 1; i++) {
			String errorText = easePage.allErrorText.get(i).getText();
			int errorN0 = i + 1;
			System.out.println("Error no -" + errorN0 + "=" + errorText);
			if ((orderId.startsWith("ATUNIIN") || orderId.contains("CNB"))
					&& (errorText.equals("GIVEN ADDRESS IS NEAR_MATCH")
							|| errorText.equals("THE SES.PROFI FIELD IS PROHIBITED WHEN THE SES.ES FIELD IS NOT S")
							|| errorText.equals("THE SES.PROFE FIELD IS PROHIBITED WHEN THE SES.ES FIELD IS NOT S"))) {
				System.out.println("ignore error");
			} else if (((orderId.startsWith("ATEVCIN")) || (orderId.startsWith("ATOVCIN")))
					&& errorText.equals("EVCSP LOCATION ICSC DOES NOT MATCH ICSC OR OEC ICSC")) {

				System.out.println("ignore error");
			} else if ((orderId.startsWith("ATECOMIN") || orderId.startsWith("ATOCOMIN"))
					&& (errorText.equals("LEVEL OF SERVICE ERROR")
							|| errorText.equals("GIVEN ADDRESS IS NEAR_MATCH"))) {

				System.out.println("ignore error");
			}

			else if ((orderId.startsWith("ATMOVE") || orderId.startsWith("ATTRANSF"))
					&& (errorText.equals("CIRCUIT NOT FOUND IN CABS BILLING")
							|| errorText.equals("GIVEN ADDRESS IS NEAR_MATCH"))) {

				System.out.println("ignore error");
			} else if ((orderId.startsWith("ATUNIDISC")) && (errorText.equals("CIRCUIT NOT FOUND IN CABS BILLING")
					|| errorText.equals("ECCKT IS INVALID"))) {

				System.out.println("ignore error");
			} else if ((orderId.startsWith("ATEVCDISC")) && (errorText.equals("CIRCUIT NOT FOUND IN CABS BILLING"))) {

				System.out.println("ignore error");
			}

//             else if (orderId.startsWith("AUTOVC")&& (errorText.equals("LEVEL OF SERVICE ERROR")||errorText.equals("EVCSP LOCATION ICSC DOES NOT MATCH ICSC OR OEC ICSC"))) {
// 				
// 				System.out.println("ignore error");
// 				}
			else {
				Assert.assertEquals("Throw exception", "actual");
			}
		}

		logger.info("Order successfully validated");
		getDriver().switchTo().defaultContent();
		waitABit(1500);
		Actions a2 = new Actions(getDriver());
		a2.moveToElement(easePage.closeErrorPopup).click().build().perform();
		waitABit(2000);
		logger.info("Successfully closed the Error Popup");

	}

	@Step
	public void clickOnSubmitOrderButton() {
		Actions a2 = new Actions(getDriver());
		a2.moveToElement(easePage.submitButton).click().build().perform();
		System.out.println("Clicked on OrderSubmit button");
		waitABit(20000);
		String statusOfOrder = easePage.statusOfOrder.getAttribute("value");
		System.out.println("statusOfOrder-" + statusOfOrder);
		Assert.assertEquals("Submitted", statusOfOrder);
		logger.info("Order Successfully submitted");

		String currentWindow = getDriver().getWindowHandle(); // will keep current window to switch back
		for (String winHandle : getDriver().getWindowHandles()) {
			String titleOfWindow = getDriver().switchTo().window(winHandle).getTitle();
			System.out.println("Title of Window-" + titleOfWindow);
			if (titleOfWindow.contains("VFO - Order List")) {
				System.out.println("Switched to VFO Order List");
				break;
			} else {
				getDriver().switchTo().window(currentWindow);
			}
		}
	}

	@Step
	public void user_Search_Install_PON(String pon) {
		getDriver().switchTo().frame(1);
		System.out.println("Switched to EASE home page frame");
		waitABit(2000);
		Actions a1 = new Actions(getDriver());
		a1.moveToElement(easePage.orderTab).build().perform();
		waitABit(1000);
		System.out.println("Mouse over to Order Tab section ");
		a1.moveToElement(easePage.searchMenuOption).click().build().perform();
		waitABit(4000);

		String currentWindow = getDriver().getWindowHandle(); // will keep current window to switch back
		for (String winHandle : getDriver().getWindowHandles()) {
			String title = getDriver().switchTo().window(winHandle).getTitle();
			System.out.println("Title of window-" + title);
			if (title.equals("Order Search Page")) {
				System.out.println("Switched to Order Search Page Window");
				break;
			} else {
				getDriver().switchTo().window(currentWindow);
			}
		}

		easePage.searchText.sendKeys(pon);
		System.out.println("Entered PON number in Search Text Box");
		waitABit(1000);
		easePage.searchButton.click();
		System.out.println("Clicked on PON number Search button");
		waitABit(2000);
		String titleOfWindow = getDriver().switchTo().window(currentWindow).getTitle();
		System.out.println("Title of Window-" + titleOfWindow);
		System.out.println("Switched back to Ease home page window");
		waitABit(2000);
		getDriver().switchTo().frame(1);
		System.out.println("Switched to EASE home page frame");

		if ((pon.contains("UNI")) || pon.contains("COM")) {
			easePage.radioSelectionOfUNI_EVCCOMBO_PON.click();
			System.out.println("Selected the Seached PON radio button");

			String ponElement1 = "//td/span[contains(.,'End User Switched Ethernet')]/../../td/span/a[contains(.,'";
			String ponElement2 = "')]";
			WebElement ponElement = getDriver().findElement(By.xpath(ponElement1 + pon + ponElement2));
			ponElement.click();
			waitABit(6000);
		} else if ((pon.contains("EVC")) || pon.contains("OVC")) {
			easePage.radioSelectionOfEVC_OVC_PON.click();
			System.out.println("Selected the Seached PON radio button");
			String ponElement1 = "//td/span[contains(.,'Standalone EVC')]/../../td/span/a[contains(.,'";
			String ponElement2 = "')]";
			WebElement ponElement = getDriver().findElement(By.xpath(ponElement1 + pon + ponElement2));
			ponElement.click();
			waitABit(6000);
		}

		String windowTitle = "MCI - " + pon;
		String currentWindow1 = getDriver().getWindowHandle(); // will keep current window to switch back
		for (String winHandle : getDriver().getWindowHandles()) {
			String title = getDriver().switchTo().window(winHandle).getTitle();
			System.out.println("Title of window-" + title);
			if (title.contains(windowTitle)) {
				System.out.println("Switched to ASR Order Page Window");
				break;
			} else {
				getDriver().switchTo().window(currentWindow1);
			}
		}

		logger.info("User successfully opened the Install PON");
	}

	@Step
	public void user_Submit_Supp2_On_Order() {
		waitABit(2000);
		String existing_dd = easePage.dueDateE.getAttribute("value");
		// String dd=existing_ddd.substring(3, 5);
		System.out.println("Existing Due Date-" + existing_dd);
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy"); // Set Date
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		cal.add(Calendar.DATE, 25);
		String newDate = dateFormat.format(cal.getTime());

		if (!existing_dd.equals(newDate)) {
			newDate = dateFormat.format(cal.getTime());
		} else {
			cal.add(Calendar.DATE, 26);
			newDate = dateFormat.format(cal.getTime());
		}

		easePage.dddChange.click();
		waitABit(4000);

		String currentWindow = getDriver().getWindowHandle(); // will keep current window to switch back
		for (String winHandle : getDriver().getWindowHandles()) {
			String titleOfWindow = getDriver().switchTo().window(winHandle).getTitle();
			System.out.println("Title of Window2-" + titleOfWindow);

			if (titleOfWindow.contains("Desired Due Date Change")) {
				System.out.println("Switched to Desired Due Date Change window");
				// WebElement
				// dueDateFrame=getDriver().findElement(By.xpath("//frame[@id='topFrame2']"));
				getDriver().switchTo().frame(easePage.suppsFrame);
				easePage.dddtext.type(newDate);
				System.out.println("Due Date Changed-" + newDate);
				waitABit(2000);
				easePage.changeButton.click();
				waitABit(2000);
				break;
			}
		}
		getDriver().switchTo().window(currentWindow);
		waitABit(30000);
		String statusOfOrder = easePage.statusOfOrder.getAttribute("value");
		System.out.println("statusOfOrder-" + statusOfOrder);
		Assert.assertEquals("Submitted", statusOfOrder);
		logger.info("Order Successfully submitted");

		String versionOfOrder = easePage.version.getAttribute("value");
		String suppType = easePage.suppType.getAttribute("value");
		logger.info("Version of order-" + versionOfOrder + " and Supp Type-" + suppType);
		logger.info("Supp2 successfully performed");
	}

//	@Step
//	public void userSubmitUNIChangeOrder() throws IOException {
//		String sheetName="UNI_Change";
//		String service,esValue,tspValue,specValue;
//		esValue=BaseStep.readExcelData(sheetName,9, 1);
//		tspValue=BaseStep.readExcelData(sheetName,3, 1);
//		specValue=BaseStep.readExcelData(sheetName,5, 1);
//		service=BaseStep.readExcelData(sheetName,2, 1);
//		easePage.ecckt.sendKeys(service);		
//		//enterOrderDetails()		
//	}	

	public void user_Submit_Supp3_On_Order(String pon) {

		waitABit(2000);
		String windowTitle = "MCI - " + pon;
		String currentWindow1 = getDriver().getWindowHandle(); // will keep current window to switch back
		for (String winHandle : getDriver().getWindowHandles()) {
			String title = getDriver().switchTo().window(winHandle).getTitle();
			System.out.println("Title of window-" + title);
			if (title.contains(windowTitle)) {
				System.out.println("Switched to ASR Order Page Window");
				break;
			} else {
				getDriver().switchTo().window(currentWindow1);
			}
		}

		String currentWindow = getDriver().getWindowHandle();
		easePage.supp3_4_Icon.click();
		System.out.println("Successfully clicked on supp3/4 icon");
		waitABit(6000);

		for (String winHandle : getDriver().getWindowHandles()) {
			String titleOfWindow = getDriver().switchTo().window(winHandle).getTitle();
			System.out.println("Title of Window-" + titleOfWindow);

			if (titleOfWindow.contains("Supplement Others")) {
				System.out.println("Switched to Supp3/4 window");
				waitABit(2000);
				getDriver().switchTo().frame(easePage.suppsFrame);
				System.out.println("Switched to Cancel frame");
				easePage.changeButton.click();
				System.out.println("Successfully clicked on ok button");
				break;
			}

		}
		waitABit(5000);
		getDriver().switchTo().window(currentWindow);

		waitABit(15000);
	}

	@Step
	public void user_Submit_Supp1_On_Order(String pon) {
		String currentWindow = getDriver().getWindowHandle();
		easePage.supp1Icon.click();
		System.out.println("Successfully clicked on supp1 icon");
		waitABit(6000);
		Alert a1 = getDriver().switchTo().alert();
		a1.accept();
		waitABit(8000);

		for (String winHandle : getDriver().getWindowHandles()) {
			String titleOfWindow = getDriver().switchTo().window(winHandle).getTitle();
			System.out.println("Title of Window2-" + titleOfWindow);

			if (titleOfWindow.contains("Cancel")) {
				System.out.println("Switched to Cancel window");
				waitABit(2000);
				getDriver().switchTo().frame(easePage.suppsFrame);
				System.out.println("Switched to Cancel frame");
				easePage.changeButton.click();
				System.out.println("Successfully clicked on ok button");
				break;
			}

		}
		waitABit(5000);
		getDriver().switchTo().window(currentWindow);

		waitABit(15000);
		String statusOfOrder = easePage.statusOfOrder.getAttribute("value");
		System.out.println("statusOfOrder-" + statusOfOrder);
		Assert.assertEquals("Cancel Submitted", statusOfOrder);
	}

	public void enterEVC_Id_for_Change_and_Disconnect(String evcID) {
		if (!evcID.equals("")) {
			waitABit(1000);
			easePage.evcID.clear();
			easePage.evcID.sendKeys(evcID);
			System.out.println("EVC ID Value entered");
			waitABit(1000);
		}
	}
}
