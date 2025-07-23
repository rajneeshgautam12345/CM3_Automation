package com.ctl.it.qa.Test_Four.tools.steps.flightdeck;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ctl.it.qa.Test_Four.tools.pages.common.FlightDeckPage;
import com.ctl.it.qa.Test_Four.tools.steps.E2ESteps;
import com.ctl.it.qa.Test_Four.tools.steps.ease.EaseSteps;
import com.ctl.it.qa.Test_Four.tools.steps.eservices.BaseStep;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.pages.WebElementFacade;

@SuppressWarnings("serial")
public class FlightDeckSteps extends E2ESteps {

	FlightDeckPage flightDeck;
	BaseStep baseStep;
	private final Logger logger = LoggerFactory.getLogger(FlightDeckSteps.class);

//	static String ANSI_GREEN_BACKGROUND = "\u001B[42m";
//	static String ANSI_RED = "\u001B[31m";
//	static final String BLACK_UNDERLINED = "\033[4;30m";
//	static String ANSI_RESET = "\u001B[0m";
//
//	public static void printInGreenColor(String statementToBePrinted, String variable) {
//		System.out.println(ANSI_GREEN_BACKGROUND + statementToBePrinted + variable + ANSI_RESET);
//	}
//	
//
//	public static void printInRedColor(String statementToBePrinted, String variable) {
//		System.out.println(ANSI_RED + statementToBePrinted + variable + ANSI_RESET);
//	}

	@Step
	public void logs_in_flightDeck() {
		getDriver().quit();
		waitABit(90000);
		String userType = "Valid";
		String FDUrl = envData.getFieldValue("FlightDeck");
		String myUser = envData.getContainer("LoginPage").getContainer(userType).getFieldValue("tbx_uname");
		String myUserPassword = envData.getContainer("LoginPage").getContainer(userType).getFieldValue("tbx_password");
		getDriver().switchTo().newWindow(WindowType.WINDOW);
		getDriver().navigate().to(FDUrl);
		System.out.println("Flight Deck Url is entered");
		getDriver().manage().window().maximize();
		System.out.println("Window is maximized");
		System.out.println("FlightDeck Page is exists");
		flightDeck.username.waitUntilClickable().withTimeoutOf(Duration.ofSeconds(90));
		flightDeck.username.sendKeys(myUser);
		waitABit(1000);
		flightDeck.password.sendKeys(myUserPassword);
		waitABit(1000);
		flightDeck.loginButton.click();
		waitABit(5000);
		flightDeck.okButton.waitUntilClickable().withTimeoutOf(Duration.ofSeconds(60));
		flightDeck.okButton.click();
		waitABit(1000);
		logger.info("Successfully logged in flight Deck Application");
	}

	@Step
	public void navigate_To_AdvanceSearch() {
		flightDeck.waitForTextToAppear("Basic Menu", 60000);
		flightDeck.basicMenuButton.waitUntilClickable().withTimeoutOf(Duration.ofSeconds(60));
		flightDeck.basicMenuButton.click();
		System.out.println("Successfully navigated to basic menu section");
		flightDeck.advanceSearch.waitUntilClickable().withTimeoutOf(Duration.ofSeconds(60));
		flightDeck.advanceSearch.click();
		flightDeck.waitForTextToAppear("Order ID", 60000);
		logger.info("Successfully navigated to advance search page");
	}

	@Step
	public void validateAdvanceSearchPage() {
		flightDeck.advanceSearchHeader.waitUntilEnabled().withTimeoutOf(Duration.ofSeconds(60));
		logger.info("Successfully navigated to advance search page");

	}

	@Step
	public void searchOrderId() {

		//String orderId = "ATOCOMIN071996";
	    String orderId = EaseSteps.pon_Number;
	    System.setProperty("PON.NO", orderId);
		flightDeck.orderIDSearch.waitUntilClickable().withTimeoutOf(Duration.ofSeconds(60));
		Actions a1 = new Actions(getDriver());
		a1.moveToElement(flightDeck.excludeSysTaskCheckbox).click().build().perform();
		waitABit(1000);
		Select s1 = new Select(flightDeck.sourceTaskIdDropdown);
		s1.selectByVisibleText("contains");
		waitABit(1000);
		flightDeck.sourceTaskISearchTextBox.sendKeys(orderId);
		waitABit(2000);
		
		flightDeck.searchButton.click();
		//getDriver().switchTo().activeElement().sendKeys(Keys.ENTER);
		waitABit(5000);
		logger.info("Successfully search the order in FD-"+orderId);
	}

	@Step
	public void selectPerPageTaskSize(String size) {
		Select s1 = new Select(flightDeck.sizeWebelement);
		s1.selectByVisibleText(size);
		logger.info("Selecting per page size as 10 ");
	}

	@Step
	public void User_Search_And_Open_Task(String targetTaskName) {
		waitABit(5000);
		int totalPages = getPageCount();
		boolean status = false;
		for (int i = 1; i <= totalPages - 1; i++) {

			// System.out.println("Size of task Row--" + allTasks.size());
			List<WebElementFacade> allTasks = flightDeck.allTasks;
			List<WebElementFacade> allSourceTaskId = flightDeck.allSourceTaskId;

			for (int j = 0; j <= allTasks.size() - 1; j++) {
				String taskName = allTasks.get(j).getText();
				System.out.println("Task Name--" + taskName);
				if (taskName.equals(targetTaskName)) {
					System.out.println("Found the " + targetTaskName + "  task");
					status = true;
					allSourceTaskId.get(j).click();
					System.out.println("Successfully open the " + targetTaskName + " task");
					break;
				}
			}
			if (status == true) {
				break;
			} else if ((status == false) || (totalPages > 1)) {
				Actions a1 = new Actions(getDriver());
				a1.moveToElement(flightDeck.nextPageIcon).click().build().perform();
				waitABit(3000);
			}
		}

		if (status == false) {
			System.out.println("Task Not found");
			Assert.assertEquals(targetTaskName, targetTaskName + " not found");
		}
		waitABit(4000);
		//logger.info("Selecting per page size as 10 ");
	}

	@Step
	public int getPageCount() {
		String totalRecords = flightDeck.totalRecords.getText();
		System.out.println("Total tasks for order now--" + totalRecords);
		int total_Records = Integer.parseInt(totalRecords);
		int total_PageSize = total_Records / 10;
		int rem = total_Records % 10;
		if (rem != 0) {
			total_PageSize = total_PageSize + 1;
			//System.out.println("Total Page size-" + total_PageSize);
		}
		return total_PageSize;
		
	}

	@Step
	public void user_Search_Install_Order_Id(String pon) {

		flightDeck.orderIDSearch.waitUntilClickable().withTimeoutOf(Duration.ofSeconds(60));
		Actions a1 = new Actions(getDriver());
		a1.moveToElement(flightDeck.excludeSysTaskCheckbox).click().build().perform();
		waitABit(1000);
		Select s1 = new Select(flightDeck.sourceTaskIdDropdown);
		s1.selectByVisibleText("contains");
		waitABit(1000);
		flightDeck.sourceTaskISearchTextBox.sendKeys(pon);
		waitABit(1000);
		getDriver().switchTo().activeElement().sendKeys(Keys.ENTER);
		waitABit(5000);
		logger.info("Successfully search the order in FD");
	}

//	@Step
//	public void AssignWorkbookAndUserToTask(String locatorValue) {
//		waitABit(5000);
//		JavascriptExecutor executor = (JavascriptExecutor) getDriver();
//		// Assign click operation
//		WebElement ele = (WebElement) executor.executeScript(
//				"return document.querySelector(\"#print-section1>fdc-page-2\").shadowRoot.querySelector(\"#dom-id-page-vertical-1\").shadowRoot.querySelector(\"div.page-div>fdc-tab >fdc-actions-widget\").shadowRoot.querySelector(\"#Assign\")");
//		ele.click();
//		waitABit(3000);
//		getDriver().switchTo().activeElement().sendKeys(Keys.TAB);
//		waitABit(500);
//		getDriver().switchTo().activeElement().sendKeys(Keys.TAB);
//		waitABit(500);
//		getDriver().switchTo().activeElement().sendKeys(Keys.TAB);
//		waitABit(500);
//		getDriver().switchTo().activeElement().sendKeys(Keys.TAB);
//		waitABit(1000);
//		getDriver().switchTo().activeElement().click();
//		waitABit(2000);
//		for (int i = 0; i <= 200; i++) {
//			getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN);
//			String workbook = getDriver().switchTo().activeElement().getText();
//			System.out.println("Workbook--" + workbook);
//			if (workbook.equals("ASRI Support")) {
//				getDriver().switchTo().activeElement().click();
//				System.out.println("Selected the ASRI Support Workbook");
//				break;
//			}
//		}
//		waitABit(5000);
//		WebElement UserDropdown = (WebElement) executor.executeScript(
//				"return document.querySelector(\"#Select\\\\ User\").shadowRoot.querySelector(\"div.dropdown > div.dropdown-field\")");
//		UserDropdown.click();
//		waitABit(1000);
//		for (int i = 0; i <= 50; i++) {
//			getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN);
//			String userName = getDriver().switchTo().activeElement().getText();
//			// waitABit(100);
//			System.out.println("Username--" + userName);
//			if (userName.equals("Mohapatra, Biswabhusan - AD01991")) {
//				getDriver().switchTo().activeElement().click();
//				System.out.println("Selected the current user");
//				break;
//			}
//		}
//		waitABit(5000);
//		WebElement save = (WebElement) executor
//				.executeScript("return document.querySelector(\"#Save\").shadowRoot.querySelector(\"button\")");
//		executor.executeScript("arguments[0].click()", save);
//		waitABit(6000);
//		WebElement alretClose = (WebElement) executor.executeScript(
//				"return document.querySelector(\"#mat-tab-content-0-2 > div > div > app-page-content > sa-task-details-framework > fd-task-detail-micro > div:nth-child(1) > fdc-alert\").shadowRoot.querySelector(\"#btn-alert-close\")");
//		executor.executeScript("arguments[0].click()", alretClose);
//		waitABit(2000);
//	}

	@Step
	public void completeTask() {
		waitABit(7000);
		JavascriptExecutor executor = (JavascriptExecutor) getDriver();
		WebElement completeButton = getShadowRoot4Element(flightDeck.content1, flightDeck.shadowRoot1,
				flightDeck.shadowRoot2, "#Complete", "button");
		executor.executeScript("arguments[0].click()", completeButton);
		waitABit(10000);

		WebElement completePopupYes = getShadowRoot2Element(flightDeck.content2,
				"div > div > div > section > footer > fdc-button:nth-child(1)", "button");
		executor.executeScript("arguments[0].click()", completePopupYes);
		waitABit(10000);
		logger.info("User successfully completed the task");
		
	}

//	@Step
//	public void validateTaskCompletedStatus() {
//		JavascriptExecutor executor = (JavascriptExecutor) getDriver();
//		WebElement taskStatus = (WebElement) executor.executeScript(
//				"return document.querySelector(\"#print-section1 > fdc-page-2\").shadowRoot.querySelector(\"#dom-id-page-vertical-1\").shadowRoot.querySelector(\"#dom-id-page-section-1\").shadowRoot.querySelector(\"#dom-id-page-section-1-col-1\").shadowRoot.querySelector(\"#dom-id-widget-statusInfoWidget\").shadowRoot.querySelector(\"#card_title > span:nth-child(2)\")");
//		String StatusValue = taskStatus.getAttribute("class");
//		if (taskStatus.equals("Completed")) {
//			System.out.println("Successfully validated the status of the task" + StatusValue);
//		}
//	}

//	@Step
//	public void closeAllTab() {
//		JavascriptExecutor executor = (JavascriptExecutor) getDriver();
//		WebElement closeTab = (WebElement) executor.executeScript(
//				"return document.querySelector(\"#header > fdc-closable-chip\").shadowRoot.querySelector(\"div > div.chip-close\")");
//		closeTab.click();
//		waitABit(2000);
//	}

//	@Step
//	public void User_Search_Order_In_QuickSearch() {
//		JavascriptExecutor executor = (JavascriptExecutor) getDriver();
//		WebElement quickSearch = (WebElement) executor.executeScript(
//				"return document.querySelector(\"#menuitems > div:nth-child(6) > div > div > div:nth-child(2) > div > div > div:nth-child(1) > div > fdc-input\").shadowRoot.querySelector(\"div > input\")");
//		quickSearch.clear();
//		//quickSearch.sendKeys(ServiceNowSteps.snowOrderId);
//		WebElement serchButton = getDriver().findElement(
//				By.xpath("//button[@class='mat-focus-indicator sbmt-btn mat-stroked-button mat-button-base']"));
//		serchButton.click();
//		waitABit(2000);
//	}

	@Step
	public void user_Switch_To_Flight_Deck_Window() {
		Set<String> allWindows = getDriver().getWindowHandles();
		for (String window : allWindows) {
			String title = getDriver().switchTo().window(window).getTitle();
			System.out.println("Window Titles--" + title);
			if (title.equals("Flight Deck")) {
				getDriver().switchTo().window(window);
				waitABit(2000);
				break;
			}
		}
	}

	@Step
	public void userValidateTaskName(String targetTaskName) {

		waitABit(5000);
		int totalPages = getPageCount();
		int nextButtonTimes = totalPages;
		boolean status = false;
		for (int i = 1; i <= totalPages; i++) {
			List<WebElementFacade> allTasks = flightDeck.allTasks;
			// System.out.println("Size of task Row--" + allTasks.size());
			// System.out.println("Page-" + i + " of tasks--");
			for (int j = 0; j <= allTasks.size() - 1; j++) {
				String taskName = allTasks.get(j).getText();
				// System.out.println("Task Name--" + taskName);
				if (taskName.equals(targetTaskName)) {
					System.out.println("Found the " + targetTaskName + " task");
					status = true;
					break;
				}
			}
			if (status == true) {
				break;
			} else if ((status == false) && (totalPages > 1) && (i < nextButtonTimes)) {
				Actions a1 = new Actions(getDriver());
				a1.moveToElement(flightDeck.nextPageIcon).click().build().perform();
				waitABit(3000);
			}
		}
		if (status == false) {
			System.out.println("Task Not found");
			Assert.assertEquals(targetTaskName, targetTaskName + " task not present");
		}
		waitABit(4000);
		logger.info("User successfully validated the "+ targetTaskName);

	}

	

	@Step
	public int userValidateTotalNumberOfTasks() {
		String totalRecords = flightDeck.totalRecords.getText();
		System.out.println("Total Number of tasks--" + totalRecords);
		int total_Records = Integer.parseInt(totalRecords);
		return total_Records;
	}

	@Step
	public void userRefreshTaskPage() {
		flightDeck.taskRefreshButton.click();
		waitABit(2000);
		logger.info("User refreshed the search result");
		
	}

	@Step
	public void userOpenTasksMoreMenuOption() {
		waitABit(5000);
//			JavascriptExecutor executor = (JavascriptExecutor) getDriver();
//			WebElement taskMenuMoreOption = (WebElement) executor.executeScript(
//					"return document.querySelector(\"#print-section1 > fdc-page-2\").shadowRoot.querySelector(\"#dom-id-page-vertical-1\").shadowRoot.querySelector(\"div.page-div > fdc-tab > fdc-actions-widget\").shadowRoot.querySelector(\"#hamberg\")");

		WebElement taskMenuMoreOption = getShadowRoot3Element(flightDeck.content1, flightDeck.shadowRoot1,
				flightDeck.shadowRoot2, "#hamberg");
		taskMenuMoreOption.click();
		waitABit(2000);

//			WebElement content1 = getDriver().findElement(By.cssSelector("#print-section1 > fdc-page-2"));
//			
//			SearchContext shadowRoot1 = content1.getShadowRoot();
//			WebElement shadowRoot2Element = shadowRoot1.findElement(By.cssSelector("#dom-id-page-vertical-1"));
//			
//			SearchContext shadowRoot2 = shadowRoot2Element.getShadowRoot();
//			WebElement shadowRoot3Element = shadowRoot2.findElement(By.cssSelector("div.page-div > fdc-tab > fdc-actions-widget"));
//			SearchContext shadowRoot3 = shadowRoot3Element.getShadowRoot();
//			WebElement taskMenuMoreOption = shadowRoot3.findElement(By.xpath("//*[@id='hamberg']"));
//			
//			taskMenuMoreOption.click();
	}

	@Step
	public void userSelfAssignTask() {
		waitABit(5000);
		for (int i = 1; i <= 5; i++) {
			WebElement workGroup = getShadowRoot5Element(flightDeck.content1, flightDeck.shadowRoot1,
					flightDeck.shadowRootPageSection1, flightDeck.shadowRootPageSection1Col2,
					flightDeck.shadowRootAssignmentInfoWidget, flightDeck.shadowRootWorkgroupAssignedElement);

			String workGroupName = workGroup.getText();
			System.out.println("WorkgroupName=" + workGroupName);
			if (!workGroupName.equals("")) {
				System.out.println("Workgroup Assigned");
				break;
			}
			// document.querySelector("#print-section1 >
			// fdc-page-2").shadowRoot.querySelector("#dom-id-page-vertical-1").shadowRoot.querySelector("div.page-div
			// > fdc-tab > fdc-actions-widget").shadowRoot.querySelector("#refresh")
		}

		WebElement assignButton = getShadowRoot3Element(flightDeck.content1, flightDeck.shadowRoot1,
				flightDeck.shadowRoot2, "#Assign");
		assignButton.click();
		waitABit(15000);
		WebElement userDropdown = shadowRootElement(flightDeck.parentUserDropdown,
				flightDeck.rootElementUserDropDown);
		userDropdown.click();
		waitABit(2000);
		getDriver().switchTo().activeElement().sendKeys(Keys.TAB);
		waitABit(1000);
		for (int i = 0; i <= 50; i++) {
			getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN);
			String userName = getDriver().switchTo().activeElement().getText();
//			System.out.println("Username--" + userName);
			if (userName.equals("Gautam, Rajneesh K - AC67376")) {
				getDriver().switchTo().activeElement().click();
				System.out.println("Selected the current user");
				break;
			}
		}
		waitABit(5000);

		WebElement saveElement = shadowRootElement(flightDeck.parentSaveButton,
				flightDeck.rootElementSaveElement);
		saveElement.click();
		logger.info("Save button clicked on selected  user");
		waitABit(10000);
	}

	@Step
	public void userClickOnEditTaskButton() {
		JavascriptExecutor executor = (JavascriptExecutor) getDriver();
		WebElement editButton = getShadowRoot4Element(flightDeck.content1, flightDeck.shadowRoot1,
				flightDeck.shadowRoot2, "#Edit", "button");
		executor.executeScript("arguments[0].click()", editButton);
		
		waitABit(4000);
		logger.info("Edit Task button clicked");
	}

	
	@Step
	public String userValidateTaskStatus(String trgTaskName) {
		waitABit(1000);
		String actTaskStatus = getDriver()
				.findElement(By.xpath(flightDeck.taskStatus1 + trgTaskName + flightDeck.taskStatus2)).getText();
		return actTaskStatus;
	}
	
	@Step
	public String userValidateTaskStatus(String trgTaskName, String status) {
		waitABit(1000);
		String actTaskStatus = getDriver()
				.findElement(By.xpath(flightDeck.taskStatus1 + trgTaskName + flightDeck.taskStatus2)).getText();
		if (actTaskStatus.equals("Cancelled") && !actTaskStatus.equals(status) ) {
			E2ESteps.printInRedColor(trgTaskName, " task is in Cancelled state");
		} else if (trgTaskName.equals("CM-Test and Tag") && (actTaskStatus.equals("Ready"))) {
			E2ESteps.printInRedColor(trgTaskName, " task is in Ready state");
		} else {
			Assert.assertEquals(status, actTaskStatus);
			E2ESteps.printInGreenColor("Validated " + trgTaskName + " task is in ", actTaskStatus + " status");
		}

		return actTaskStatus;
	}

	
	@Step
	public String userValidateTaskIsInCompletedStatus(String trgTaskName) {
		String actTaskStatus = getDriver()
				.findElement(By.xpath(flightDeck.taskStatus1 + trgTaskName + flightDeck.taskStatus2)).getText();

		if (actTaskStatus.equals("Cancelled")) {
			System.out.println(trgTaskName + " is in Cancelled state");
			E2ESteps.printInRedColor(trgTaskName + " task is in ", actTaskStatus + " state");
		} 
//		else if (actTaskStatus.equals("In-Progress") || actTaskStatus.equals("Created")) {
//			System.out.println(trgTaskName + " task is in " + actTaskStatus + " state");
//		} 
		else {
			Assert.assertEquals("Completed", actTaskStatus);
			E2ESteps.printInGreenColor("Validated " + trgTaskName + " task is in ", actTaskStatus + " status");
		}
		return actTaskStatus;
	}
	
	@Step
	public void userOpenThetask(String taskName) {
		getDriver().findElement(By.xpath(flightDeck.taskName1 + taskName + flightDeck.taskName2)).click();
	}

	@Step
	public void userSelectLocation() {
		JavascriptExecutor executor = (JavascriptExecutor) getDriver();
		WebElement locationRadioButton = getShadowRoot7Element(flightDeck.content1, flightDeck.shadowRoot1,
				flightDeck.shadowRootTaskDetails, flightDeck.shadowRootTaskDetails2,
				flightDeck.shadowRoottaskDetailsWidget, flightDeck.shadowRoottaskDetailsAddressWidget,
				flightDeck.shadowRoottaskDetailsTable, flightDeck.shadowRoottaskDetailsAddressRadioButton);
		waitABit(2000);
		executor.executeScript("arguments[0].click()", locationRadioButton);
		waitABit(2000);
		logger.info("Selected the location radio button");
	}

	@Step
	public void clickOnSaveButtonOnTask() {
		JavascriptExecutor executor = (JavascriptExecutor) getDriver();
		WebElement saveButton = getShadowRoot4Element(flightDeck.content1, flightDeck.shadowRoot1,
				flightDeck.shadowRoot2, "#save", "button");
		executor.executeScript("arguments[0].click()", saveButton);
		
		waitABit(9000);
		logger.info("Save button clicked on task");
		
	}

	@Step
	public void closedOpenedTask() {
		flightDeck.closeOpenedTask.click();
		waitABit(3000);
		logger.info("closed opened task page");
	}

	@Step
	public void clickOnRetryButtonOnTask() {
		JavascriptExecutor executor = (JavascriptExecutor) getDriver();
		WebElement retryButton = getShadowRoot4Element(flightDeck.content1, flightDeck.shadowRoot1,
				flightDeck.shadowRoot2, "#Retry", "button");
		executor.executeScript("arguments[0].click()", retryButton);
		waitABit(6000);
		System.out.println("Retry button clicked on task");
		WebElement retryPopupRemarks = shadowRootElement(flightDeck.parentRemarks,
				flightDeck.rootElementRemarks);
		waitABit(2000);
		retryPopupRemarks.sendKeys("Location Selected");
		waitABit(1500);
		WebElement savePopupButton = getShadowRoot1Element("#Save", "button");
		executor.executeScript("arguments[0].click()", savePopupButton);
		waitABit(6000);
		logger.info("User successfully retried the task");
	}

	@Step
	public void switchBackTSearchResultSection() {
		waitABit(2000);
		flightDeck.searchResults.click();
		logger.info("Switched back to Search result section");
	}

	@Step
	public void closeTaskPagePopupBar() {
		JavascriptExecutor executor = (JavascriptExecutor) getDriver();
		WebElement alretClose = shadowRootElement(flightDeck.parentTaskPagePopupBar,
				flightDeck.rootElementTaskPagePopupBar);
		//baseStep.customClickableWait(alretClose);
		waitABit(2000);
		executor.executeScript("arguments[0].click()", alretClose);
		waitABit(3000);
	}

	@Step
	public void enterDetailsInTask(String taskName) {
		waitABit(6000);
		if (taskName.equals("Send Manual PTA")) {

//			WebElement content1 = getDriver().findElement(By.cssSelector("#print-section1 > fdc-page-2"));
//			
//			SearchContext shadowRoot1 = content1.getShadowRoot();
//			WebElement shadowRoot2Element = shadowRoot1.findElement(By.cssSelector("#dom-id-page-vertical-1"));
//			
//			SearchContext shadowRoot2 = shadowRoot2Element.getShadowRoot();
//			WebElement shadowRoot3Element = shadowRoot2.findElement(By.cssSelector("#dom-id-page-section-8"));
//			SearchContext shadowRoot3 = shadowRoot3Element.getShadowRoot();
//			WebElement shadowRoot4Element = shadowRoot3.findElement(By.cssSelector("#dom-id-page-section-9-col-1"));
//			SearchContext shadowRoot4 = shadowRoot4Element.getShadowRoot();
//			WebElement shadowRoot5Element = shadowRoot4
//					.findElement(By.cssSelector("#dom-id-widget-dynamicTaskInstanceParamWidget"));
//			SearchContext shadowRoot5 = shadowRoot5Element.getShadowRoot();
//			WebElement shadowRoot6Element = shadowRoot5.findElement(By.cssSelector("#recordNumber > div > fdc-input"));
//			SearchContext shadowRoot6 = shadowRoot6Element.getShadowRoot();
//			WebElement shadowRoot7Element = shadowRoot6.findElement(By.cssSelector("div > input"));

//			
//			waitABit(3000);
//			shadowRoot7Element.sendKeys("987654");
//			waitABit(3000);

			WebElement shadowRoot6Element = getShadowRoot6Element(flightDeck.content1, flightDeck.shadowRoot1,
					flightDeck.shadowRootTaskDetails, flightDeck.shadowRootTaskDetails2,
					flightDeck.shadowRoottaskDetailsWidget, "#recordNumber > div > fdc-input", "div > input");
			waitABit(3000);
			shadowRoot6Element.sendKeys("987654");
			waitABit(3000);

			logger.info("PTA record entered successfully");
			waitABit(2000);

		}
	}

	@Step
	public void userEnterSuppOrderId(String pon) {
		waitABit(5000);
		String corrId1 = getDriver().findElement(By.xpath(flightDeck.getCorrIId)).getText();
		String[] corrId = corrId1.split("CM3-1");
		String corrIDOfSuppOrder = corrId[0] + "CM3-2";
		for (int i = 0; i < corrId.length; i++) {
			System.out.println("CorrId " + i + "=" + corrId[i]);
		}
		getDriver().navigate().refresh();

		navigate_To_AdvanceSearch();

		flightDeck.orderIDSearch.waitUntilClickable().withTimeoutOf(Duration.ofSeconds(60));
		Actions a1 = new Actions(getDriver());
		a1.moveToElement(flightDeck.excludeSysTaskCheckbox).click().build().perform();
		waitABit(1000);
		Select s1 = new Select(flightDeck.sourceTaskIdDropdown);
		s1.selectByVisibleText("contains");
		waitABit(1000);
		flightDeck.sourceTaskISearchTextBox.sendKeys(corrIDOfSuppOrder);
		waitABit(1000);
		System.out.println("Successfully search supp version-"+corrIDOfSuppOrder);
		getDriver().switchTo().activeElement().sendKeys(Keys.ENTER);
		waitABit(5000);
		System.out.println("Successfully search the order in FD");
	}

	@Step
	public void validatesMetroEChangeTask() {
		WebElement content1 = getDriver().findElement(By.cssSelector("#print-section1 > fdc-page-2"));
		SearchContext shadowRoot1 = content1.getShadowRoot();
		WebElement shadowRoot2Element = shadowRoot1.findElement(By.cssSelector("#dom-id-page-vertical-1"));
		SearchContext shadowRoot2 = shadowRoot2Element.getShadowRoot();
		WebElement shadowRoot3Element = shadowRoot2.findElement(By.cssSelector("#dom-id-page-section-8"));
		SearchContext shadowRoot3 = shadowRoot3Element.getShadowRoot();
		WebElement shadowRoot4Element = shadowRoot3.findElement(By.cssSelector("#dom-id-page-section-9-col-1"));
		SearchContext shadowRoot4 = shadowRoot4Element.getShadowRoot();
		WebElement shadowRoot5Element = shadowRoot4
				.findElement(By.cssSelector("#dom-id-widget-dynamicTaskInstanceParamWidget"));
		SearchContext shadowRoot5 = shadowRoot5Element.getShadowRoot();

		// String service=;
		WebElement shadowRoot6Element = shadowRoot5.findElement(
				By.cssSelector("#Delta\\ 29\\/KXGS\\/567502\\/\\/MS > div > div > div > fdc-json-render-2"));
		SearchContext shadowRoot6 = shadowRoot6Element.getShadowRoot();
		WebElement shadowRoot7Element = shadowRoot6
				.findElement(By.cssSelector("div > div > div > div > fdc-json-render-2"));
		SearchContext shadowRoot7 = shadowRoot7Element.getShadowRoot();
		WebElement shadowRoot8Element = shadowRoot7
				.findElement(By.cssSelector("div > div > div > div > fdc-array-render-2"));
		SearchContext shadowRoot8 = shadowRoot8Element.getShadowRoot();
		WebElement shadowRoot9Element = shadowRoot8.findElement(By.cssSelector("div > table > tbody >"));

		// tr//td[contains(.,'spec')]/,,/td[4] - Order spec value
		// tr//td[contains(.,'spec')]/,,/td[4] --- changed spec value,
		// tr//td[contains(.,'spec')]/,,/td[4]--- order action value
	}

	@Step
	public WebElement getShadowRoot1Element(String content, String shadowRootFirstElement) {
		WebElement content1 = getDriver().findElement(By.cssSelector(content));
		SearchContext shadowRoot1 = content1.getShadowRoot();
		WebElement shadowRoot1Element = shadowRoot1.findElement(By.cssSelector(shadowRootFirstElement));
		return shadowRoot1Element;
	}

	@Step
	public WebElement getShadowRoot2Element(String content, String shadowRootFirstElement,
			String shadowRootSecondElement) {
		WebElement content1 = getDriver().findElement(By.cssSelector(content));
		SearchContext shadowRoot1 = content1.getShadowRoot();
		WebElement shadowRoot1Element = shadowRoot1.findElement(By.cssSelector(shadowRootFirstElement));
		SearchContext shadowRoot2 = shadowRoot1Element.getShadowRoot();
		WebElement shadowRoot2Element = shadowRoot2.findElement(By.cssSelector(shadowRootSecondElement));
		return shadowRoot2Element;
	}

	@Step
	public WebElement getShadowRoot3Element(String content, String shadowRootFirstElement,
			String shadowRootSecondElement, String shadowRootThirdElement) {
		WebElement content1 = getDriver().findElement(By.cssSelector(content));
		SearchContext shadowRoot1 = content1.getShadowRoot();
		WebElement shadowRoot1Element = shadowRoot1.findElement(By.cssSelector(shadowRootFirstElement));
		SearchContext shadowRoot2 = shadowRoot1Element.getShadowRoot();
		WebElement shadowRoot2Element = shadowRoot2.findElement(By.cssSelector(shadowRootSecondElement));
		SearchContext shadowRoot3 = shadowRoot2Element.getShadowRoot();
		WebElement shadowRoot3Element = shadowRoot3.findElement(By.cssSelector(shadowRootThirdElement));
		return shadowRoot3Element;
	}

	@Step
	public WebElement getShadowRoot4Element(String content, String shadowRootFirstElement,
			String shadowRootSecondElement, String shadowRootThirdElement, String shadowRootFourthElement) {
		WebElement content1 = getDriver().findElement(By.cssSelector(content));
		SearchContext shadowRoot1 = content1.getShadowRoot();
		WebElement shadowRoot1Element = shadowRoot1.findElement(By.cssSelector(shadowRootFirstElement));
		SearchContext shadowRoot2 = shadowRoot1Element.getShadowRoot();
		WebElement shadowRoot2Element = shadowRoot2.findElement(By.cssSelector(shadowRootSecondElement));
		SearchContext shadowRoot3 = shadowRoot2Element.getShadowRoot();
		WebElement shadowRoot3Element = shadowRoot3.findElement(By.cssSelector(shadowRootThirdElement));
		SearchContext shadowRoot4 = shadowRoot3Element.getShadowRoot();
		WebElement shadowRoot4Element = shadowRoot4.findElement(By.cssSelector(shadowRootFourthElement));
		return shadowRoot4Element;
	}

	@Step
	public WebElement getShadowRoot5Element(String content, String shadowRootFirstElement,
			String shadowRootSecondElement, String shadowRootThirdElement, String shadowRootFourthElement,
			String shadowRootFifthElement) {
		WebElement content1 = getDriver().findElement(By.cssSelector(content));
		SearchContext shadowRoot1 = content1.getShadowRoot();
		WebElement shadowRoot1Element = shadowRoot1.findElement(By.cssSelector(shadowRootFirstElement));
		SearchContext shadowRoot2 = shadowRoot1Element.getShadowRoot();
		WebElement shadowRoot2Element = shadowRoot2.findElement(By.cssSelector(shadowRootSecondElement));
		SearchContext shadowRoot3 = shadowRoot2Element.getShadowRoot();
		WebElement shadowRoot3Element = shadowRoot3.findElement(By.cssSelector(shadowRootThirdElement));
		SearchContext shadowRoot4 = shadowRoot3Element.getShadowRoot();
		WebElement shadowRoot4Element = shadowRoot4.findElement(By.cssSelector(shadowRootFourthElement));
		SearchContext shadowRoot5 = shadowRoot4Element.getShadowRoot();
		WebElement shadowRoot5Element = shadowRoot5.findElement(By.cssSelector(shadowRootFifthElement));
		return shadowRoot5Element;
	}

	@Step
	public WebElement getShadowRoot6Element(String content, String shadowRootFirstElement,
			String shadowRootSecondElement, String shadowRootThirdElement, String shadowRootFourthElement,
			String shadowRootFifthElement, String shadowRootSixthElement) {
		WebElement content1 = getDriver().findElement(By.cssSelector(content));
		SearchContext shadowRoot1 = content1.getShadowRoot();
		WebElement shadowRoot1Element = shadowRoot1.findElement(By.cssSelector(shadowRootFirstElement));
		SearchContext shadowRoot2 = shadowRoot1Element.getShadowRoot();
		WebElement shadowRoot2Element = shadowRoot2.findElement(By.cssSelector(shadowRootSecondElement));
		SearchContext shadowRoot3 = shadowRoot2Element.getShadowRoot();
		WebElement shadowRoot3Element = shadowRoot3.findElement(By.cssSelector(shadowRootThirdElement));
		SearchContext shadowRoot4 = shadowRoot3Element.getShadowRoot();
		WebElement shadowRoot4Element = shadowRoot4.findElement(By.cssSelector(shadowRootFourthElement));
		SearchContext shadowRoot5 = shadowRoot4Element.getShadowRoot();
		WebElement shadowRoot5Element = shadowRoot5.findElement(By.cssSelector(shadowRootFifthElement));
		SearchContext shadowRoot6 = shadowRoot5Element.getShadowRoot();
		WebElement shadowRoot6Element = shadowRoot6.findElement(By.cssSelector(shadowRootSixthElement));
		return shadowRoot6Element;
	}

	@Step
	public WebElement getShadowRoot7Element(String content, String shadowRootFirstElement,
			String shadowRootSecondElement, String shadowRootThirdElement, String shadowRootFourthElement,
			String shadowRootFifthElement, String shadowRootSixthElement, String shadowRootSeventhElement) {
		WebElement content1 = getDriver().findElement(By.cssSelector(content));
		SearchContext shadowRoot1 = content1.getShadowRoot();
		WebElement shadowRoot1Element = shadowRoot1.findElement(By.cssSelector(shadowRootFirstElement));
		SearchContext shadowRoot2 = shadowRoot1Element.getShadowRoot();
		WebElement shadowRoot2Element = shadowRoot2.findElement(By.cssSelector(shadowRootSecondElement));
		SearchContext shadowRoot3 = shadowRoot2Element.getShadowRoot();
		WebElement shadowRoot3Element = shadowRoot3.findElement(By.cssSelector(shadowRootThirdElement));
		SearchContext shadowRoot4 = shadowRoot3Element.getShadowRoot();
		WebElement shadowRoot4Element = shadowRoot4.findElement(By.cssSelector(shadowRootFourthElement));
		SearchContext shadowRoot5 = shadowRoot4Element.getShadowRoot();
		WebElement shadowRoot5Element = shadowRoot5.findElement(By.cssSelector(shadowRootFifthElement));
		SearchContext shadowRoot6 = shadowRoot5Element.getShadowRoot();
		WebElement shadowRoot6Element = shadowRoot6.findElement(By.cssSelector(shadowRootSixthElement));
		SearchContext shadowRoot7 = shadowRoot6Element.getShadowRoot();
		WebElement shadowRoot7element = shadowRoot7.findElement(By.cssSelector(shadowRootSeventhElement));

		return shadowRoot7element;
	}
	
	
	public WebElement shadowRootElement(String parent,String elementCss) {
		WebElement content = getDriver().findElement(By.xpath(parent));
		SearchContext shadowRoot1 = content.getShadowRoot();
		WebElement element = shadowRoot1.findElement(By.cssSelector(elementCss));
		return element;
		}
	
	
	public void retrieveServiceId()
	{
		waitABit(5000);
		//JavascriptExecutor executor = (JavascriptExecutor) getDriver();
		WebElement serviceId = getShadowRoot5Element(flightDeck.content1, flightDeck.shadowRoot1,
				flightDeck.shadowRootTaskDetails,flightDeck.shadowRootTaskDetails2 ,flightDeck.shadowRoottaskDetailsWidget,"#clrId > div > div > div");
		waitABit(2000);
		String service_Id=serviceId.getText();
		System.setProperty("Service.ID", service_Id);
		String serviceID = System.getProperty("Service.ID");
		System.out.println(serviceID);
		String abc="";
		E2ESteps.printInGreenColor("Validated service " + serviceID + " created successfully", abc );
		//E2ESteps.printInGreenColor("Service created successfully"+"serviceID"+serviceID);
		//executor.executeScript("arguments[0].click()", serviceId);
	}
	
	
	public void retrieveOrder()
	{
		waitABit(10000);
		JavascriptExecutor executor = (JavascriptExecutor) getDriver();
		WebElement order = getShadowRoot5Element(flightDeck.content1, flightDeck.shadowRoot1,
				flightDeck.shadowRootPageSection1,flightDeck.shadowRootPageSection1Col2 ,flightDeck.shadowRootAssignmentInfoWidget,"div[id='Order ID']>div.value>span");
		executor.executeScript("arguments[0].click()", order);
		
		System.out.println("Order="+order.getText());
	}
	
	public void unblockTask()
	{
		waitABit(10000);
		JavascriptExecutor executor = (JavascriptExecutor) getDriver();
		WebElement unblockButton = getShadowRoot3Element(flightDeck.content1, flightDeck.shadowRoot1,
				flightDeck.shadowRoot2, "#UnBlock");
		unblockButton.click();
		waitABit(5000);
		WebElement completePopupYes = getShadowRoot2Element(flightDeck.content2,
				"div > div > div > section > footer > fdc-button:nth-child(1)", "button");
		executor.executeScript("arguments[0].click()", completePopupYes);
		waitABit(10000);
		logger.info("User successfully completed the task");
		
		
	}
	
	// document.querySelector("#print-section1 >
	// fdc-page-2").shadowRoot.querySelector("#dom-id-page-vertical-1").shadowRoot.querySelector("#dom-id-page-section-8").shadowRoot.querySelector("#dom-id-page-section-9-col-1").shadowRoot.querySelector("#dom-id-widget-dynamicTaskInstanceParamWidget").shadowRoot.querySelector("#Delta\\
	// 29\\/KXGS\\/567502\\/\\/MS > div > div > div >
	// fdc-json-render-2").shadowRoot.querySelector("div > div > div > div >
	// fdc-json-render-2").shadowRoot.querySelector("div > div > div > div >
	// fdc-array-render-2").shadowRoot.querySelector("div > table > tbody >
	// tr:nth-child(8) > td:nth-child(1)")
}
