package com.ctl.it.qa.Test_Four.tools.pages.common;

import java.util.List;

import com.ctl.it.qa.Test_Four.tools.pages.SfaPage;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class OrchestratorPage extends SfaPage {

	//HomePage
	@FindBy(xpath = "//frame[@name='mainFrame']")
	public WebElementFacade orchFrame;
	@FindBy(xpath = "//div[@id='el0']/img")
	public WebElementFacade orderManagerMenu;
	@FindBy(xpath = "//div[text()='Service Request']")
	public WebElementFacade serviceRequestMenuOption;
	@FindBy(xpath = "//input[@name='serviceRequestNumber']")
	public WebElementFacade serviceRequestNumberText;
	@FindBy(xpath = "//img[@name='retrieve']")
	public WebElementFacade retrieveServiceRequestButton;
	@FindBy(xpath = "//table[@bordercolordark='#000099']/tbody/tr[2]/td[1]")
	public WebElementFacade orderRecord;
	
	//Orchestrator Task Page- Task 1
	@FindBy(xpath = "//frame[@name='SRIDETAIL']")
	public WebElementFacade orchTaskPageFrame;
	@FindBy(xpath = "//font[contains(text(),'SOFT ERROR DETAILS,SOFT ERROR DETAILS')]/../../td[2]/font[2]")
	public WebElementFacade overallSoftErrorStatus_Row1;
//	@FindBy(xpath = "//div[@id='divDisplaySMWSA2']/../../../../../table[1]/tbody/tr[2]/td[2]/font[2]")
//	public WebElementFacade overallStatusOfRow1;
//	@FindBy(xpath = "//img[@id='img_divDisplaySMWSA2']")
//	public WebElementFacade expandRow1;
	@FindBy(xpath = "//font[contains(.,'SOFT ERROR DETAILS,SOFT ERROR DETAILS')]/../../../tr[2]/td[3]/a")
	public WebElementFacade expandRow1;
	
//	@FindBy(xpath = "//div[@id='divDisplaySMWSA2']//tr[@bgcolor='#FBF9FA']/td[8]/font")
//	public List<WebElementFacade> statusOfEachRowOfSoftErrorDetails;
	@FindBy(xpath = "//font[contains(.,'SOFT ERROR DETAILS,SOFT ERROR DETAILS')]/../../../../../table[2]//td[8]/font")
	public List<WebElementFacade> statusOfEachRowOfSoftErrorDetails;
	
	
	//public String errorText1="//div[@id='divDisplaySMWSA2']//tr[@bgcolor='#FBF9FA']/td[8]/font/../../td[1]/a";
	@FindBy(xpath = "//select[@name='selProgressStatus']")
	public WebElementFacade selectStatusDropdown;
	
	//Orchestrator Task Page- Task 2 - Not req for Standalone EVC/OVC
//	@FindBy(xpath = "//div[@id='divDisplaySMWSA3']/../../../../../table[1]/tbody/tr[2]/td[2]/font[2]")
//	public WebElementFacade overallStatusOfRow2;
	@FindBy(xpath = "//font[contains(.,'REQ SWC FROM CLLI TABLE,RCV SWC FROM CLLI TABLE')]/../../../tr[2]/td[2]/font[2]")
	public WebElementFacade overallStatusOfSWC;
	
//	@FindBy(xpath = "//img[@id='img_divDisplaySMWSA3']")
//	public WebElementFacade expandRow2;
	@FindBy(xpath = "//font[contains(.,'REQ SWC FROM CLLI TABLE,RCV SWC FROM CLLI TABLE')]/../../../tr[2]/td[3]/a")
	public WebElementFacade expandSWCRow;
//	@FindBy(xpath = "//div[@id='divDisplaySMWSA3']//tr[@bgcolor='#EAE9F3']/td[8]/font")
//	public List<WebElementFacade> statusOfREQ_SWC_FROM_CLLI;
	@FindBy(xpath = "//font[contains(.,'REQ SWC FROM CLLI TABLE,RCV SWC FROM CLLI TABLE')]/../../../../../table[2]//td[8]/font")
	public List<WebElementFacade> statusOfEach_REQ_SWC_FROM_CLLI;
		
	
	//Orchestrator Task Page- Task 3
//	@FindBy(xpath = "//div[@id='divDisplaySMWSA4']/../../../../../table[1]/tbody/tr[2]/td[2]/font[2]")
//	public WebElementFacade overallStatusOfRow3;
	@FindBy(xpath = "//font[contains(.,'REQ NON ASOG DATA,RCV NON ASOG DATA')]/../../../tr[2]/td[2]/font[2]")
	public WebElementFacade overallStatusOfNONAOG;
	@FindBy(xpath = "//font[contains(.,'REQ NON ASOG DATA,RCV NON ASOG DATA')]/../../../tr[2]/td[3]/a")
	public WebElementFacade expandNONASOGRow;	
//	@FindBy(xpath = "//img[@id='img_divDisplaySMWSA4']")
//	public WebElementFacade expandRow3;
//	@FindBy(xpath = "//div[@id='divDisplaySMWSA4']//tr[@bgcolor='#FBF9FA']/td[8]/font")
//	public List<WebElementFacade> statusOfEach_REQ_NON_ASOG_DATA;
	@FindBy(xpath = "//font[contains(.,'REQ NON ASOG DATA,RCV NON ASOG DATA')]/../../../../../table[2]//td[8]/font")
	public List<WebElementFacade> statusOfEach_REQ_NON_ASOG_DATA;
	
	//Orchestrator Task Page- Task 4
	@FindBy(xpath = "//font[contains(.,'SEND IFOC PROV PACKET,AcceptProject,RCV IFOC')]/../../../tr[2]/td[2]/font[2]")
	public WebElementFacade overallStatusOfMob;
	@FindBy(xpath = "//font[contains(.,'SEND IFOC PROV PACKET,AcceptProject,RCV IFOC')]/../../../tr[2]/td[3]/a")
	public WebElementFacade expandMobRow;
	
	
	@FindBy(xpath = "//font[contains(.,'SEND PROV PACKET,AcceptProject,RCV FOC')]/../../../tr[2]/td[2]/font[2]")
	public WebElementFacade overallStatusOfMobForEVC;
	@FindBy(xpath = "//font[contains(.,'SEND PROV PACKET,AcceptProject,RCV FOC')]/../../../tr[2]/td[3]/a")
	public WebElementFacade expandMobRowForEVC;
	
	@FindBy(xpath = "//font[contains(.,'SEND IFOC PROV PACKET,AcceptProject,RCV IFOC')]/../../../../../table[2]//td[8]/font")
	public List<WebElementFacade> statusOfMobErrorDetails;
	@FindBy(xpath = "//font[contains(.,'SEND PROV PACKET,AcceptProject,RCV FOC')]/../../../../../table[2]//td[8]/font")
	public List<WebElementFacade> statusOfMobErrorDetailsForEVC;
	
//	@FindBy(xpath = "//div[@id='divDisplaySMWSA5']/../../../../../table[1]/tbody/tr[2]/td[2]/font[2]")
//	public WebElementFacade overallStatusOfRow4;	
//	@FindBy(xpath = "//img[@id='img_divDisplaySMWSA5']")
//	public WebElementFacade expandRow4;
	
	@FindBy(xpath = "//img[@src='/oe/images/save_down.gif']")
	public WebElementFacade saveAndComplete;
	@FindBy(xpath = "//frame[@name='leftFrame']")
	public WebElementFacade refreshFrame;
	@FindBy(xpath = "//a/img[@src='/oe/wmain/images/Refresh.gif']")
	public WebElementFacade refreshButton;
	@FindBy(xpath = "//a[text()='User Defined Details']")
	public WebElementFacade userDefinedDetailsLink;
	@FindBy(xpath = "//input[@name='Tag88_11Tag1Div']")
	public WebElementFacade swcText;
		
	public WebElementFacade getUniqueElementInPage() {
		return orchFrame;
	}
}
