package com.ctl.it.qa.Test_Four.tools.pages.eservices;

import com.ctl.it.qa.staf.Page;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class JiraPage extends Page {
	@FindBy(xpath = "//span[@aria-label='Abhishek Tripathi']")
	public WebElementFacade btn_user;

	public WebElementFacade user1(String user) {
		WebElementFacade user1 = findBy("//span[@aria-label='" + user + "']");
		return user1;
	}

	public WebElementFacade story1(String story) {
		WebElementFacade story1 = findBy("//a[@title='" + story + "']");
		return story1;
	}

	@FindBy(xpath = "//input[@id='search-field-input']")
	public WebElementFacade tbx_story_search;
	@FindBy(xpath = "//span[@class='css-19r5em7'][contains(.,'Open')]")
	public WebElementFacade btn_open;
	@FindBy(xpath = "//span[contains(.,'Start Progress')]")
	public WebElementFacade btn_start;
	@FindBy(xpath = "(//span[@role='presentation'])[24]")
	public WebElementFacade btn_subtasks;
	@FindBy(xpath = "//input[@id='childIssuesPanel']")
	public WebElementFacade tbx_task;
	@FindBy(xpath = "(//span[@class='css-19r5em7'][contains(.,'Create')])[2]")
//	@FindBy(xpath = "(//span[contains(.,'Create')])[49]")
	public WebElementFacade btn_task1_create;
	@FindBy(xpath = "//input[contains(@id,'username')]")
	public WebElementFacade tbx_username;
	@FindBy(xpath = "//input[contains(@type,'email')]")
	public WebElementFacade tbx_email;
	@FindBy(xpath = "//*[@name=\"loginfmt\"]")
	public WebElementFacade tbx_login;
	@FindBy(xpath = "(//span[contains(.,'Continue')])[2]")
	public WebElementFacade btn_continue;
	@FindBy(xpath = "//*[@type=\"submit\"]")
	public WebElementFacade btn_next;
	@FindBy(xpath = "//*[@type=\"password\"]")
	public WebElementFacade tbx_password;

	@Override
	public WebElementFacade getUniqueElementInPage() {
		return btn_user;
	}
}
