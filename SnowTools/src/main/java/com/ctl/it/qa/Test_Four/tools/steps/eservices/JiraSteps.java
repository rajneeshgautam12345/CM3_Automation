package com.ctl.it.qa.Test_Four.tools.steps.eservices;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import com.ctl.it.qa.Test_Four.tools.pages.eservices.JiraPage;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.annotations.findby.By;

@SuppressWarnings("serial")
public class JiraSteps extends BaseStep {
	JiraPage jirapage;

	@Step
	public void i_am_logged_in_as_a_user_in_Jira(String user, String story) {
		jirapage.openAt("https://ctl.atlassian.net/browse/" + story + "");
		WaitForPageToLoad();
		jirapage.maximize();
		System.out.println("Jira Page Launched");
		jirapage.tbx_username.sendKeys("abhishek.tripathi1@lumen.com");
		jirapage.btn_continue.waitUntilClickable();
		jirapage.btn_continue.click();
		WaitForPageToLoad(60);
		System.out.println("Jira Logging In");
		String url = getDriver().getCurrentUrl();
		System.out.println("Current URL : " + url);
		jirapage.tbx_email.waitUntilClickable();
		jirapage.tbx_email.sendKeys("abhishek.tripathi1@lumen.com");
		jirapage.btn_next.waitUntilClickable();
		jirapage.btn_next.click();
		waitABit(2000);
		jirapage.tbx_password.waitUntilClickable();
		jirapage.tbx_password.sendKeys("Nov@5451");
		jirapage.btn_next.waitUntilClickable();
		jirapage.btn_next.click();
		jirapage.btn_next.waitUntilClickable();
		jirapage.btn_next.click();
		WaitForPageToLoad();
		System.out.println("Jira Logged In");
	}

	@Step
	// jirapage.user1(user).click();
	public void i_am_logged_in_as_a_user_in_Jira_as_a_user(String user) {
		jirapage.openAt(
				"https://ctl.atlassian.net/jira/software/c/projects/CNSNAAS/boards/4472/backlog?issueLimit=100");
		WaitForPageToLoad(60);
		jirapage.maximize();
		System.out.println("Jira Page Loaded");
		customwaitforpageloading2();
		jirapage.tbx_username.sendKeys("abhishek.tripathi1@lumen.com");
		customwaitforpageloading2();
		jirapage.btn_continue.click();
		WaitForPageToLoad(60);
		jirapage.tbx_login.sendKeys("abhishek.tripathi1@lumen.com");
		customwaitforpageloading2();
		jirapage.btn_next.click();
		System.out.println("User Name Entered");
		customwaitforpageloading2();
		jirapage.tbx_password.sendKeys("");
		customwaitforpageloading2();
		jirapage.btn_next.click();
		customwaitforpageloading2();
		jirapage.btn_next.click();
		WaitForPageToLoad(100);
		System.out.println("Jira Page LoggedIn");
		String url = getDriver().getCurrentUrl();
		System.out.println("Current URL : " + url);
		jirapage.maximize();
		WaitForPageToLoad(10); // wait for auto log in
		customwaitforpageloading(jirapage);
		jirapage.user1(user).click();
	}

	@Step
	public void i_start_working_on_some_specific_story_of_any_specific_sprint(String story) {
		/*
		 * jirapage.tbx_story_search.sendKeys(story); waitABit(2000);
		 * jirapage.story1(story).click(); waitABit(2000);
		 */
		jirapage.btn_open.click();
		waitABit(2000);
		jirapage.btn_start.click();
		waitABit(2000);
		String Story_Point = getDriver().findElement(By.xpath("(//span[@class='css-92dv6g'])[2]")).getText();
		System.out.println("Story Point = " + Story_Point);
		String Sub_Points = (Story_Point + 5);
		System.out.println(Sub_Points);
		jirapage.btn_subtasks.click();
		waitABit(2000);
		jirapage.tbx_task.sendKeys("Test : Test Requirement Analysis");
		waitABit(2000);
		jirapage.btn_task1_create.click();
		waitABit(6000);
		jirapage.tbx_task.sendKeys("Test : Test Case Design");
		waitABit(2000);
		jirapage.btn_task1_create.click();
		waitABit(6000);
		jirapage.tbx_task.sendKeys("Test : Test Data Preparation");
		waitABit(2000);
		jirapage.btn_task1_create.click();
		waitABit(6000);
		jirapage.tbx_task.sendKeys("Test : Test Automation");
		waitABit(2000);
		WebElement Create = getDriver()
				.findElement(By.xpath("(//span[@class='css-19r5em7'][contains(.,'Create')])[2]"));
		JavascriptExecutor js0 = ((JavascriptExecutor) getDriver());
		js0.executeScript("arguments[0].click();", Create);
		waitABit(6000);
		jirapage.tbx_task.sendKeys("Test : Test Execution");
		waitABit(2000);
		js0.executeScript("arguments[0].click();", Create);
		waitABit(6000);
	}

	@Step
	public void i_create_sub_tasks_for_that_story() {
	}

	@Step
	public void sub_tasks_should_be_created_for_that_story_having_equal_story_points() {
		// jirapage.lnk_unassigned.click();
		waitABit(3000);
		getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN, Keys.ENTER, Keys.TAB);
		// jirapage.lnk_unassigned.click();
		waitABit(3000);
		getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
		// jirapage.lnk_unassigned.click();
		waitABit(3000);
		getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
		// jirapage.lnk_unassigned.click();
		waitABit(3000);
		getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
		// jirapage.lnk_unassigned.click();
		waitABit(3000);
		getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
		waitABit(3000);
	}
}
