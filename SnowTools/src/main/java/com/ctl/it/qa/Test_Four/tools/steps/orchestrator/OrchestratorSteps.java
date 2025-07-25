package com.ctl.it.qa.Test_Four.tools.steps.orchestrator;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ctl.it.qa.Test_Four.tools.pages.common.LoginPage;
import com.ctl.it.qa.Test_Four.tools.pages.common.OrchestratorPage;
import com.ctl.it.qa.Test_Four.tools.steps.E2ESteps;
import com.ctl.it.qa.Test_Four.tools.steps.ease.EaseSteps;

import net.serenitybdd.annotations.Step;

@SuppressWarnings("serial")
public class OrchestratorSteps extends E2ESteps {

	LoginPage loginPage;
	OrchestratorPage orchestratorPage;

	private final Logger logger = LoggerFactory.getLogger(EaseSteps.class);

	@Step
	public void login_in_Orchestrator() {

		// getDriver().quit();
		waitABit(2000);
		String orchUrl = envData.getFieldValue("Orchestrator");
//		System.out.println("Orchestrator url=" + orchUrl);
//		loginPage.openAt(orchUrl);
//		getDriver().manage().window().maximize();

		getDriver().navigate().to(orchUrl);
		waitABit(1000);
		String tempcurrentURL = getDriver().getCurrentUrl(); // get the current url
		logger.info("currentURL  is  " + tempcurrentURL); // // get the current url
		String myUser = envData.getContainer("LoginPage").getContainer("Valid").getFieldValue("tbx_username");
		String myUserPassword = envData.getContainer("LoginPage").getContainer("Valid").getFieldValue("tbx_password");
		waitABit(5000);
//		loginPage.btn_next_submit.waitUntilClickable().withTimeoutOf(Duration.ofSeconds(2000));
//		loginPage.tbx_username.sendKeys(myUser);
//		loginPage.btn_next_submit.waitUntilClickable().withTimeoutOf(Duration.ofSeconds(10));
//		loginPage.btn_next_submit.click(); // click on new button new code for 2 step
//		loginPage.waitForTextToAppear("Enter password", 5000);
//		loginPage.tbx_password.sendKeys(myUserPassword);
//		loginPage.btn_next_submit.waitUntilClickable().withTimeoutOf(Duration.ofSeconds(10));
//		loginPage.btn_next_submit.click(); // click on new button new code for 2 step
//		loginPage.waitForTextToAppear("Do this to reduce the number of times you are asked to sign in.", 190000);
//		loginPage.btn_NO.waitUntilClickable().withTimeoutOf(Duration.ofSeconds(500));
//		loginPage.btn_NO.click(); // click the no button
//		logger.info("Successfully logged in Orchestrator");
//		waitABit(7000);
	}

	@Step
	public void searchPON_In_Orchestrator() {
		// String searchPON= "ATEVCDISC071974"+"%";
		String searchPON = EaseSteps.pon_Number + "MCI";
		getDriver().switchTo().frame(orchestratorPage.orchFrame); // Switched to main frame
		// String searchPON=EaseSteps.pon_Number+"%";
		Actions a1 = new Actions(getDriver());
		a1.moveToElement(orchestratorPage.orderManagerMenu).build().perform();
		System.out.println("Successfully navigated to OrderManager Menu Section");
		orchestratorPage.serviceRequestMenuOption.click();
		System.out.println("Successfully clicked on service RequestMenu Option");
		orchestratorPage.serviceRequestNumberText.sendKeys(searchPON);
		System.out.println("Successfully entered service request Number");
		orchestratorPage.retrieveServiceRequestButton.click();
		logger.info("Successfully clicked on retrieve service Request button");
		waitABit(2000);

	}

	@Step
	public void validateSearchedPON_In_Orchestrator() {
		getDriver().navigate().refresh();
		waitABit(4000);
		getDriver().switchTo().frame(orchestratorPage.orchFrame);
		System.out.println(orchestratorPage.orderRecord.getText());
		String actualOrder = orchestratorPage.orderRecord.getText();
		String ponNumberValidation = actualOrder.substring(0, actualOrder.length() - 3);
		System.out.println("PON-" + ponNumberValidation);
		System.setProperty("PON.NO", ponNumberValidation);
		orchestratorPage.orderRecord.click();
		logger.info("Successfully clicked on the record");
		getDriver().switchTo().defaultContent(); // switched back to window from main frame

	}

	public void refreshOrchestratorPage() {
		
		getDriver().switchTo().frame(orchestratorPage.refreshFrame);
		orchestratorPage.refreshButton.click();
		System.out.println("Successfully clicked on refresh button..... ");
		waitABit(5000);
		getDriver().switchTo().defaultContent();
	}
	
	@Step
	public void enterSWC() {
		waitABit(5000);
		getDriver().switchTo().frame(orchestratorPage.orchTaskPageFrame); // Switched to Task page frame
		orchestratorPage.expandMobRow.click();
		System.out.println("Successfully expanded row4 section");
		waitABit(2000);

		WebElement fourthRowfirstTask = getDriver().findElement(By.xpath(
				"(//font[contains(.,'SEND IFOC PROV PACKET,AcceptProject,RCV IFOC')]/../../../../../table[2]//td[2]/font/a)[1]"));
		System.out.println("Row 4 -Task 1 text-" + fourthRowfirstTask.getText());
		fourthRowfirstTask.click();
		waitABit(4000);
		System.out.println("Successfully clicked on first task of 4th row");

		String currentWindow1 = getDriver().getWindowHandle(); // will keep current window to switch back
		for (String winHandle1 : getDriver().getWindowHandles()) {
			String titleOfWindow1 = getDriver().switchTo().window(winHandle1).getTitle();
			System.out.println("Title of Window1-" + titleOfWindow1);
			waitABit(3000);
			if (titleOfWindow1.contains("RazorFlow Orchestrator - WorkScheduleActivity Details")) {
				System.out.println("Switched to RazorFlow Orchestrator - WorkScheduleActivity Details");
				orchestratorPage.userDefinedDetailsLink.click();
				System.out.println("Successfully clicked on User Defined Details link");
				waitABit(4000);

				String currentWindow2 = getDriver().getWindowHandle();
				for (String winHandle2 : getDriver().getWindowHandles()) {
					String titleOfWindow2 = getDriver().switchTo().window(winHandle2).getTitle();
					waitABit(2000);
					System.out.println("Title of Window2-" + titleOfWindow2);
					if (titleOfWindow2.contains("Work Schedule Activity UDO Tags")) {
						System.out.println("Switched to Work Schedule Activity UDO Tags window");
						waitABit(2000);
						orchestratorPage.swcText.clear();
						waitABit(1500);
						orchestratorPage.swcText.sendKeys("DNVRCONODS0");
						System.out.println("Successfully entered SWC");
						waitABit(2000);
						orchestratorPage.saveAndComplete.click();
						System.out.println("Clicked on save and complete button");
						waitABit(3000);
						break;
					}
				}
				getDriver().switchTo().window(currentWindow2);
				System.out.println("Swiched to window2");
				waitABit(3000);
				orchestratorPage.saveAndComplete.click();
				System.out.println("Clicked on save and complete button");
				waitABit(3000);
				break;
			}
		}

		getDriver().switchTo().window(currentWindow1);
		logger.info("Successfully entered the SWC for order");
	}

	@Step
	public void validateOverallStatusOfRow1() {
		waitABit(3000);
		getDriver().switchTo().frame(orchestratorPage.orchTaskPageFrame); // Switched to Task page frame
		waitABit(1000);
		// String overallStatusOfRow1=orchestratorPage.overallStatusOfRow1.getText();
		String overallStatusOfRow1 = orchestratorPage.overallSoftErrorStatus_Row1.getText();
		System.out.println("Overall status of Row 1-" + overallStatusOfRow1);
		orchestratorPage.expandRow1.click();
		waitABit(2000);
		System.out.println("Successfully expanded row1 section");

		if (overallStatusOfRow1.equals("UnAssigned") || overallStatusOfRow1.equals("Pending")
				|| overallStatusOfRow1.equals("Jeopardy")) {
			//int no_of_row = orchestratorPage.statusOfEachRowOfSoftErrorDetails.size();
			// System.out.println("No of row-"+no_of_row);
			String statusOfFirstTask = orchestratorPage.statusOfEachRowOfSoftErrorDetails.get(0).getText();
			System.out.println("Status of Row1 first task-" + statusOfFirstTask);
			Assert.assertEquals("Completed", statusOfFirstTask);

			String statusOfSecondTask = orchestratorPage.statusOfEachRowOfSoftErrorDetails.get(1).getText();
			System.out.println("Status of Row1 second task-" + statusOfSecondTask);
			if (statusOfSecondTask.equals("UnAssigned") || statusOfSecondTask.equals("Pending")
					|| statusOfSecondTask.equals("Jeopardy")) {

				WebElement ele = getDriver().findElement(By.xpath(
						"(//font[contains(.,'SOFT ERROR DETAILS,SOFT ERROR DETAILS')]/../../../../../table[2]//td[2]/font/a)[2]"));

				System.out.println("Row 1 second task text-" + ele.getText());
				ele.click();
				waitABit(4000);
				System.out.println("Clicked on second task");
				String currentWindow = getDriver().getWindowHandle(); // will keep current window to switch back
				for (String winHandle : getDriver().getWindowHandles()) {
					String titleOfWindow = getDriver().switchTo().window(winHandle).getTitle();
					System.out.println("Title of Window3-" + titleOfWindow);
					if (titleOfWindow.contains("RazorFlow Orchestrator - WorkScheduleActivity Details")) {
						System.out.println("Switched to RazorFlow Orchestrator - WorkScheduleActivity Details");
						Select s1 = new Select(orchestratorPage.selectStatusDropdown);
						s1.selectByVisibleText("Completed");
						System.out.println("Selected the Complete option from dropdown");
						orchestratorPage.saveAndComplete.click();
						System.out.println("Clicked on save and complete button");
						break;

					} else {
						getDriver().switchTo().window(currentWindow);
					}
				}
				getDriver().switchTo().window(currentWindow);
				System.out.println("Switched to parent window");
			}
		}

		logger.info("Successfully completed the Soft Error tasks");
	}

	public void validateOverallStatusOfRow2() {
		getDriver().switchTo().frame(orchestratorPage.orchTaskPageFrame);
		String overallStatusOfRow2 = orchestratorPage.overallStatusOfSWC.getText();
		System.out.println("Overall status of Row 2-" + overallStatusOfRow2);
		orchestratorPage.expandSWCRow.click();
		waitABit(2000);
		System.out.println("Successfully expanded row2 section");

		if (overallStatusOfRow2.equals("UnAssigned") || overallStatusOfRow2.equals("Pending")
				|| overallStatusOfRow2.equals("Jeopardy")) {
			int no_of_row = orchestratorPage.statusOfEach_REQ_SWC_FROM_CLLI.size();

			// System.out.println("No of Row--"+no_of_row);
			String statusOfFirstTask = orchestratorPage.statusOfEach_REQ_SWC_FROM_CLLI.get(0).getText();
			System.out.println("Status of Row2 first task-" + statusOfFirstTask);
			Assert.assertEquals("Completed", statusOfFirstTask);
			
			String statusOfSecondTask = orchestratorPage.statusOfEach_REQ_SWC_FROM_CLLI.get(1).getText();
			System.out.println("Status of Row2 second task-" + statusOfSecondTask);
			if (statusOfSecondTask.equals("UnAssigned") || statusOfSecondTask.equals("Jeopardy")) {

				WebElement ele = getDriver().findElement(By.xpath(
						"(//font[contains(.,'REQ SWC FROM CLLI TABLE,RCV SWC FROM CLLI TABLE')]/../../../../../table[2]//tr[4]/td[2]/font)[1]"));

				System.out.println("2nd Row Second task text-" + ele.getText());
				ele.click();
				waitABit(4000);
				System.out.println("Clicked on second task");
				String currentWindow = getDriver().getWindowHandle(); // will keep current window to switch back
				for (String winHandle : getDriver().getWindowHandles()) {
					String titleOfWindow = getDriver().switchTo().window(winHandle).getTitle();
					System.out.println("Title of Window2-" + titleOfWindow);

					if (titleOfWindow.contains("RazorFlow Orchestrator - WorkScheduleActivity Details")) {
						System.out.println("Switched to RazorFlow Orchestrator - WorkScheduleActivity Details");
						Select s1 = new Select(orchestratorPage.selectStatusDropdown);
						s1.selectByVisibleText("Completed");
						orchestratorPage.saveAndComplete.click();
						System.out.println("Clicked on save and complete button");
						break;

					} else {
						getDriver().switchTo().window(currentWindow);
					}
				}
				getDriver().switchTo().window(currentWindow);
				System.out.println("Switched to parent window");
			}
		}

		logger.info("Successfully completed the SWC tasks");
	}

	public void validateOverallStatusOfNonASOGRow() {

		getDriver().switchTo().frame(orchestratorPage.orchTaskPageFrame);

		boolean status = false;
		for (int i = 1; i <= 5; i++) {
			String statusOfRow3 = orchestratorPage.overallStatusOfNONAOG.getText();
			System.out.println("Overall status of NonASOG-" + statusOfRow3);
			if (!statusOfRow3.equals("Completed")) {
				getDriver().switchTo().defaultContent();
				refreshOrchestratorPage();
				waitABit(10000);
				getDriver().switchTo().frame(orchestratorPage.orchTaskPageFrame);

			} else {
				status = true;
				System.out.println("NonASOG Row all tasks completed");
				break;
			}
		}
		getDriver().switchTo().defaultContent();
		Assert.assertEquals(true, status);
		logger.info("Successfully completed the NonASOG tasks");

	}

	public void validateAcceptProjectStatusForUNI_Or_Combo() {

		getDriver().switchTo().frame(orchestratorPage.orchTaskPageFrame);

		String statusOfRow4 = orchestratorPage.overallStatusOfMob.getText();
		System.out.println("Overall status of Mob Row-" + statusOfRow4);
		orchestratorPage.expandMobRow.click();
		waitABit(2000);
		System.out.println("Successfully expanded Mob Row section");

		for (int i = 1; i <= 5; i++) {
			String statusOfFirstTask = orchestratorPage.statusOfMobErrorDetails.get(0).getText();
			System.out.println("Status of Mob Row -" + 1 + " task-" + statusOfFirstTask);
			if (!statusOfFirstTask.equals("Completed")) {
				waitABit(15000);
				getDriver().switchTo().defaultContent();
				refreshOrchestratorPage();
				waitABit(3000);
				getDriver().switchTo().frame(orchestratorPage.orchTaskPageFrame);
				orchestratorPage.expandMobRow.click();
				waitABit(4000);
				System.out.println("Successfully expanded Mob Row section");
			} else {
				// System.out.println("Status of Mob Row-"+1+" task-"+statusOfFirstTask);
				getDriver().switchTo().defaultContent();
				break;
			}
		}

		refreshOrchestratorPage();
		waitABit(4000);
		WebElement orchTaskPage2 = getDriver().findElement(By.xpath("//frame[@name='SRIDETAIL']"));
		getDriver().switchTo().frame(orchTaskPage2);
		orchestratorPage.expandMobRow.click();
		waitABit(2000);
		System.out.println("Successfully expanded Mob Row section");

		for (int i = 1; i <= 10; i++) {
			String statusOfSecondTask = orchestratorPage.statusOfMobErrorDetails.get(1).getText();
			System.out.println("Status of Mob Row-" + 2 + " task-" + statusOfSecondTask);
			if (!statusOfSecondTask.equals("Completed")) {
				waitABit(15000);
				getDriver().switchTo().defaultContent();
				refreshOrchestratorPage();
				WebElement orchTaskPage21 = getDriver().findElement(By.xpath("//frame[@name='SRIDETAIL']"));
				waitABit(5000);
				getDriver().switchTo().frame(orchTaskPage21);
				orchestratorPage.expandMobRow.click();
				waitABit(2000);
				System.out.println("Successfully expanded Mob Row section");
			} else {
				// System.out.println("Status of Mob Row-"+2+" task-"+statusOfSecondTask);
				getDriver().switchTo().defaultContent();
				break;
			}

		}

		logger.info("Successfully completed the Accept Project task");
	}

	public void validateAcceptProjectStatusForEVC() {

		getDriver().switchTo().frame(orchestratorPage.orchTaskPageFrame);
		String statusOfRow4 = orchestratorPage.overallStatusOfMobForEVC.getText();
		System.out.println("Overall status of Row 4-" + statusOfRow4);
		orchestratorPage.expandMobRowForEVC.click();
		waitABit(2000);
		System.out.println("Successfully expanded row4 section");
		// String
		// statusOfFirstTask=orchestratorPage.statusOfMobErrorDetails.get(1).getText();

		for (int i = 1; i <= 5; i++) {
			String statusOfFirstTask = orchestratorPage.statusOfMobErrorDetailsForEVC.get(0).getText();
			System.out.println("Status of 4th Row-" + 1 + " task-" + statusOfFirstTask);
			if (!statusOfFirstTask.equals("Completed")) {
				waitABit(15000);
				getDriver().switchTo().defaultContent();
				refreshOrchestratorPage();
				waitABit(3000);
				getDriver().switchTo().frame(orchestratorPage.orchTaskPageFrame);
				orchestratorPage.expandMobRowForEVC.click();
				waitABit(2000);
				System.out.println("Successfully expanded row4 section");
			} else {
				System.out.println("Status of 4th row-" + 1 + " task-" + statusOfFirstTask);
				getDriver().switchTo().defaultContent();
				break;
			}
		}

		refreshOrchestratorPage();
		waitABit(4000);
		WebElement orchTaskPage2 = getDriver().findElement(By.xpath("//frame[@name='SRIDETAIL']"));
		getDriver().switchTo().frame(orchTaskPage2);
		orchestratorPage.expandMobRowForEVC.click();
		waitABit(2000);
		System.out.println("Successfully expanded row4 section");

		for (int i = 1; i <= 10; i++) {
			String statusOfSecondTask = orchestratorPage.statusOfMobErrorDetailsForEVC.get(1).getText();
			System.out.println("Status of 4th row-" + 2 + " task-" + statusOfSecondTask);
			if (!statusOfSecondTask.equals("Completed")) {
				waitABit(15000);
				getDriver().switchTo().defaultContent();
				refreshOrchestratorPage();
				waitABit(4000);
				getDriver().switchTo().frame(orchTaskPage2);
				orchestratorPage.expandMobRowForEVC.click();
				waitABit(2000);
				System.out.println("Successfully expanded row4 section");
			} else {
				System.out.println("Status of 4th Row-" + 2 + " task-" + statusOfSecondTask);
				getDriver().switchTo().defaultContent();
				break;
			}

		}
	}

	@Step
	public void enterSWCForDisco() {
		waitABit(5000);
		getDriver().switchTo().frame(orchestratorPage.orchTaskPageFrame); // Switched to Task page frame
		orchestratorPage.expandMobRowForEVC.click();
		System.out.println("Successfully expanded row4 section");
		waitABit(2000);

		// WebElement
		// fourthRowfirstTask=getDriver().findElement(By.xpath("(//div[@id='divDisplaySMWSA5']//tr[@bgcolor='#EAE9F3']/td[8]/font/../../td[2]/font)[1]"));
		WebElement fourthRowfirstTask = getDriver().findElement(By.xpath(
				"(//font[contains(.,'SEND PROV PACKET,AcceptProject,RCV FOC')]/../../../../../table[2]//td[2]/font/a)[1]"));
		System.out.println("Row 4 -Task 1 text-" + fourthRowfirstTask.getText());
		fourthRowfirstTask.click();
		waitABit(4000);
		System.out.println("Successfully clicked on first task of 4th row");

		String currentWindow1 = getDriver().getWindowHandle(); // will keep current window to switch back
		for (String winHandle1 : getDriver().getWindowHandles()) {
			String titleOfWindow1 = getDriver().switchTo().window(winHandle1).getTitle();
			System.out.println("Title of Window1-" + titleOfWindow1);
			waitABit(3000);
			if (titleOfWindow1.contains("RazorFlow Orchestrator - WorkScheduleActivity Details")) {
				System.out.println("Switched to RazorFlow Orchestrator - WorkScheduleActivity Details");
				orchestratorPage.userDefinedDetailsLink.click();
				System.out.println("Successfully clicked on User Defined Details link");
				waitABit(4000);

				String currentWindow2 = getDriver().getWindowHandle();
				for (String winHandle2 : getDriver().getWindowHandles()) {
					String titleOfWindow2 = getDriver().switchTo().window(winHandle2).getTitle();
					waitABit(2000);
					System.out.println("Title of Window2-" + titleOfWindow2);
					if (titleOfWindow2.contains("Work Schedule Activity UDO Tags")) {
						System.out.println("Switched to Work Schedule Activity UDO Tags window");
						waitABit(2000);
						orchestratorPage.swcText.clear();
						waitABit(1500);
						orchestratorPage.swcText.sendKeys("DNVRCONODS0");
						System.out.println("Successfully entered SWC");
						waitABit(2000);
						orchestratorPage.saveAndComplete.click();
						System.out.println("Clicked on save and complete button");
						waitABit(3000);
						break;
					}
				}
				getDriver().switchTo().window(currentWindow2);
				System.out.println("Swiched to window2");
				waitABit(3000);
				orchestratorPage.saveAndComplete.click();
				System.out.println("Clicked on save and complete button");
				break;
			}
		}

		getDriver().switchTo().window(currentWindow1);
		logger.info("Successfully entered the SWC for order");
	}
}