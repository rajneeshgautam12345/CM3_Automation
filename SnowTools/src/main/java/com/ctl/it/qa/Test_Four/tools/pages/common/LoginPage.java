package com.ctl.it.qa.Test_Four.tools.pages.common;

import com.ctl.it.qa.Test_Four.tools.pages.SfaPage;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class LoginPage extends SfaPage {
	@FindBy(name = "loginfmt")
	public WebElementFacade tbx_username;
	@FindBy(id = "idSIButton9")
	public WebElementFacade btn_next_submit;
	@FindBy(name = "passwd")
	public WebElementFacade tbx_password;
	@FindBy(id = "idBtn_Back")
	public WebElementFacade btn_NO;
	@FindBy(xpath = "//*[@id=\"idp_section_buttons\"]/button/span")
	public WebElementFacade btn_SSO;
	@FindBy(css = "#footer")
	public WebElementFacade ele_footer;
	@FindBy(xpath = "//html/body/div/div/form/input[4]")
	public WebElementFacade btn_log_In_To_Salesforce;

	@Override
	public WebElementFacade getUniqueElementInPage() {
		return btn_log_In_To_Salesforce;
	}

//	public void enterCredentials(String userType) {
//		System.out.println("in enterCredentials ");
//		IntDataContainer dataContainer = envData.getContainer(this.getClass().getSimpleName()).getContainer(userType);
//		tbx_username.type(dataContainer.getFieldValue("tbx_username"));
//		this.btn_next_submit.click(); // click on new button new code for 2 step
//		waitABit(3000);
//		tbx_password.type(dataContainer.getFieldValue("tbx_password"));
//		this.btn_next_submit.click(); // click on new button new code for 2 step
//		waitABit(3000);
//		this.btn_NO.click(); // click the no button
//		waitABit(3000);
//		String username = dataContainer.getFieldValue("tbx_username");
//		String[] myusername = username.split("@");
//		System.setProperty("USER.ID", myusername[0]);
//		String USERID = System.getProperty("USER.ID");
//		System.out.println("User ID is  " + USERID); // end of getting order id
//		String userpassword = dataContainer.getFieldValue("tbx_password");
//		System.setProperty("PSW.ID", userpassword);
//		
//	}

	public void clickLogin() {
		btn_log_In_To_Salesforce.click();
	}
}