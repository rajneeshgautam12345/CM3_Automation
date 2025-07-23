package com.ctl.it.qa.Test_Four.tools.pages.common;

import com.ctl.it.qa.Test_Four.tools.pages.SfaPage;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class SmokeDD extends SfaPage {
	@FindBy(id = "loginForm:username") // user txt
	public WebElementFacade txt_username;
	@FindBy(id = "loginForm:password") // password txt
	public WebElementFacade txt_password;
	@FindBy(id = "loginForm:loginButton") // log in button
	public WebElementFacade btnlogin;
	@FindBy(linkText = "Manage Services") // continue Button
	public WebElementFacade btn_manage_services;
	@FindBy(xpath = "//*[@id=\"app\"]/div/div[1]/div[2]/input") // Search for order
	public WebElementFacade txt_ordersearch;
	@FindBy(xpath = "//*[@id=\"app\"]/div/div[1]/div[2]/i") // search icon
	public WebElementFacade img_iconsearch;
	@FindBy(xpath = "//*[@id=\"app\"]/div/div[2]/div/table/tbody/tr/td[1]/a") // Swift order ID link
	public WebElementFacade lnk_orderdd;

	@Override
	public WebElementFacade getUniqueElementInPage() {
		return txt_username;
	}
}