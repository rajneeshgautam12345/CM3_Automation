package com.ctl.it.qa.Test_Four.tools.pages.common;

import java.util.List;

import com.ctl.it.qa.Test_Four.tools.pages.SfaPage;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class EasePage extends SfaPage {

	// Ease Login
	@FindBy(xpath = "//*[text()='Go to Login Page']")
	public WebElementFacade goToLoginPage;
	@FindBy(xpath = "//input[@id='loginName']")
	public WebElementFacade username;
//	@FindBy(xpath = "//select[@name='serviceRequestType']")
//	public WebElementFacade module;
	@FindBy(xpath = "//input[@id='password']")
	public WebElementFacade password;
	@FindBy(xpath = "//a/img[@src='images/login.gif']")
	public WebElementFacade loginButton;

	// Menus
	@FindBy(xpath = "//div[@id='orderlistmenu']//th[@id='orderTab']")
	public WebElementFacade orderTab;
	@FindBy(xpath = "(//div[contains(text(),'Search') and contains(@id,'menuItemText')])[1]")
	public WebElementFacade searchMenuOption;
	@FindBy(xpath = "(//div[contains(text(),'Save As Order') and contains(@id,'menuItemText')])[2]")
	public WebElementFacade saceAsOrderMenuOption;

	@FindBy(xpath = "//input[@name='searchFor']")
	public WebElementFacade searchText;
	@FindBy(xpath = "//a/img[@src='images/search.gif']")
	public WebElementFacade searchButton;
//	@FindBy(xpath = "//td/span[contains(text(),'End User Switched Ethernet')]//../../th/input[@name='selectedRadio']")
//	public WebElementFacade radioSelectionOfPON;
	@FindBy(xpath = "//input[@name='selectedRadio']")
	public WebElementFacade radioSelectionOfPON;
	@FindBy(xpath = "//td/span[contains(.,'End User Switched Ethernet')]/../../th/input[@name='selectedRadio']")
	public WebElementFacade radioSelectionOfUNI_EVCCOMBO_PON;
	@FindBy(xpath = "//td/span[contains(.,'Standalone EVC')]/../../th/input[@name='selectedRadio']")
	public WebElementFacade radioSelectionOfEVC_OVC_PON;
	public String ponNumberLink1 = "(//td/span[contains(text(),'End User Switched Ethernet')]//../..//td//a[contains(@href,'";
	public String ponNumberLink2 = "')])[1]";

	// Order creation details
	@FindBy(xpath = "//input[@name='newPon']")
	public WebElementFacade enterPONNumber;
	@FindBy(xpath = "//input[@id='ICSC']")
	public WebElementFacade enterICSE;
	@FindBy(xpath = "//select[@name='activity']")
	public WebElementFacade activity;
	@FindBy(xpath = "//select[@name='service']")
	public WebElementFacade service;
	@FindBy(xpath = "//img[@id='savegif']")
	public WebElementFacade save;

	// ASR Page Details
	@FindBy(xpath = "//select[@name='selectedccna']") // Common for UNI/EVC/combo
	public WebElementFacade ccna;
	
	@FindBy(xpath = "//input[@name='DDD']") // Common for UNI/EVC/combo
	public WebElementFacade dueDateE;
	@FindBy(xpath = "//input[@name='activity']") // Common for UNI/EVC/combo
	public WebElementFacade activityHeader;
	
	
	
	@FindBy(xpath = "(//td/span[contains(., 'DDD')]/../../../tr[2]/td/input)[1]") // common for EVC/UNI/Combo
	public WebElementFacade dueDate;
	@FindBy(xpath = "(//td/span[contains(., 'SPEC')]/../../../tr[2]/td/input)[1]")
	public WebElementFacade specCode;
	@FindBy(xpath = "//td/span[contains(., 'ASR_REMARKS')]/../../../tr[2]/td/textarea")
	public WebElementFacade remarks;
	@FindBy(xpath = "(//td/span[contains(., 'ECCKT')]/../../../tr[2]/td/input)[1]")
	public WebElementFacade ecckt;
	@FindBy(xpath = "(//td/span[contains(., 'TSP')]/../../../tr[2]/td/input)[1]")
	public WebElementFacade tsp;

	// SES Menu Details
	@FindBy(xpath = "//td/img[@id='SESMenu']")
	public WebElementFacade sesMenu;
//	@FindBy(xpath = "//select[@name='ASR_SERVICE_REQUEST::0#SWITCHED_ETHERNET_SVC::0#SES::0#SES_SVC_DETAILS::0#ES::0']")
//	public WebElementFacade esValue;
	@FindBy(xpath = "(//td/span[contains(., 'ES')]/../../../tr[2]/td/select)[1]")
	public WebElementFacade esValue;
	
	@FindBy(xpath = "(//td/span[contains(., 'PROFE')]/../../../tr[2]/td/input)[1]")
	public WebElementFacade profe;
	@FindBy(xpath = "(//td/span[contains(., 'PROFI')]/../../../tr[2]/td/input)[1]")
	public WebElementFacade profi;
	
	
//	@FindBy(id = "ASR_SERVICE_REQUEST::0#SWITCHED_ETHERNET_SVC::0#SES::0#SES_SVC_DETAILS::0#NC::0")
//	public WebElementFacade ncCode;
	@FindBy(xpath = "(//td/span[contains(., 'NC')]/../../../tr[2]/td/input)[1]")
	public WebElementFacade ncCode;
	
//	@FindBy(id = "ASR_SERVICE_REQUEST::0#SWITCHED_ETHERNET_SVC::0#SES::0#SES_SVC_DETAILS::0#NCI::0")
//	public WebElementFacade nciCode;
	@FindBy(xpath = "(//td/span[contains(., 'NCI')]/../../../tr[2]/td/input)[1]")
	public WebElementFacade nciCode;
	
//	@FindBy(id = "ASR_SERVICE_REQUEST::0#SWITCHED_ETHERNET_SVC::0#SES::0#SES_SVC_DETAILS::0#SECNCI::0")
//	public WebElementFacade secNci;
	@FindBy(xpath = "(//td/span[contains(., 'SECNCI')]/../../../tr[2]/td/input)[1]")
	public WebElementFacade secNci;
	
	@FindBy(id = "ASR_SERVICE_REQUEST::0#SWITCHED_ETHERNET_SVC::0#SES::0#SES_SVC_DETAILS::0#DIVCKT::0")
	public WebElementFacade divCkt;
	@FindBy(id = "ASR_SERVICE_REQUEST::0#SWITCHED_ETHERNET_SVC::0#SES::0#SES_SVC_DETAILS::0#DIVPON::0")
	public WebElementFacade divPon;
	@FindBy(xpath = "//input[@id='ASR_SERVICE_REQUEST::0#SWITCHED_ETHERNET_SVC::0#SES::0#SES_LOCATION::0#ESP::0']")
	public WebElementFacade esp;
	

	// ValidateAndSubmit
	
	@FindBy(xpath = "//input[@name='pon']")
	public WebElementFacade retrievePON;
	@FindBy(xpath = "//div/a/img[@title='Validate']")
	public WebElementFacade validateButton;
	@FindBy(xpath = "//div[@id='MWJminiwinMAX1']")
	public WebElementFacade errorPopupValidation;
	@FindBy(xpath = "//iframe[@name='Wisor']")
	public WebElementFacade errorFrame;
	@FindBy(xpath = "//body[@bgcolor='#FFFFFF' and @text='#000000']/table[@width='98%']/tbody/tr[contains(@bgcolor,'#')]")
	public List<WebElementFacade> allError;
	@FindBy(xpath = "//body[@bgcolor='#FFFFFF' and @text='#000000']/table[@width='98%']/tbody/tr[contains(@bgcolor,'#')]/td//a")
	public List<WebElementFacade> allErrorText;
	@FindBy(xpath = "(//td[text()='ErrorCode List']/../td[3]//a[2])[1]")
	public WebElementFacade closeErrorPopup;
	@FindBy(xpath = "//th[@id='submitIconId1']")
	public WebElementFacade submitButton;
	@FindBy(xpath = "//input[@name='status']")
	public WebElementFacade statusOfOrder;
	
	@FindBy(xpath = "//input[@name='version']")
	public WebElementFacade version;
	@FindBy(xpath = "//input[@name='supp']")
	public WebElementFacade suppType;	
	
	

	// EVC
	@FindBy(xpath = "//td/img[@id='EVCMenu']")
	public WebElementFacade evcMenu;
	@FindBy(xpath = "(//div[@id='EVC1']//td/span[contains(., 'EVCID')]/../../../tr[2]/td[1]/input)[1]")
	public WebElementFacade evcID;	
	@FindBy(xpath = "(//div[@id='EVC1']//td/span[contains(., 'NC')]/../../../tr[2]/td[1]/input)[1]")
	public WebElementFacade evcNC;
	@FindBy(xpath = "(//div[@id='EVC1']//td/span[contains(., 'EVCSP')]/../../../tr[2]/td[1]/input)[1]")
	public WebElementFacade evcsp_ruid1;
	@FindBy(xpath = "(//div[@id='EVC1']//td/span[contains(., 'RUID')]/../../../tr[2]/td[1]/input)[1]")
	public WebElementFacade ruid1;
	@FindBy(xpath = "(//div[@id='EVC1']//td/span[contains(., 'NCI')]/../../../tr[2]/td[1]/input)[1]")
	public WebElementFacade evcNCI_ruid1;
	@FindBy(xpath = "(//div[@id='EVC1']//td/span[contains(.,'VACT')]/../../../tr[2]/td[1]/select)[2]")
	public WebElementFacade ce_vact_ruid1;
	@FindBy(xpath = "(//div[@id='EVC1']//td/span[contains(.,'CE_VLAN_START')]/../../../tr[2]/td[1]/input)[1]")
	public WebElementFacade ce_vlan_ruid1;
	@FindBy(xpath = "(//div[@id='EVC1']//td/span[contains(.,'S_VACT')]/../../../tr[2]/td[1]/select)[1]")
	public WebElementFacade s_vact_ruid1;
	@FindBy(xpath = "(//div[@id='EVC1']//td/span[contains(.,'S_VLAN_START')]/../../../tr[2]/td[1]/input)[1]")
	public WebElementFacade s_vlan_ruid1;
	@FindBy(xpath = "(//div[@id='EVC1']//td/span[contains(.,'LOS')]/../../../tr[2]/td[1]/input)[1]")
	public WebElementFacade los1_ruid1;
	@FindBy(xpath = "(//div[@id='EVC1']//td/span[contains(.,'BDW')]/../../../tr[2]/td[1]/input)[1]")
	public WebElementFacade evcBandwidth_ruid1;

	@FindBy(xpath = "(//div[@id='EVC1']//td/span[contains(., 'EVCSP')]/../../../tr[2]/td[1]/input)[2]")
	public WebElementFacade evcsp_ruid2;
	@FindBy(xpath = "(//div[@id='EVC1']//td/span[contains(., 'RUID')]/../../../tr[2]/td[1]/input)[2]")
	public WebElementFacade ruid2;
	@FindBy(xpath = "(//div[@id='EVC1']//td/span[contains(., 'NCI')]/../../../tr[2]/td[1]/input)[2]")
	public WebElementFacade evcNCI_ruid2;
	@FindBy(xpath = "(//div[@id='EVC1']//td/span[contains(.,'S_VACT')]/../../../tr[2]/td[1]/select)[2]")
	public WebElementFacade s_vact_ruid2;
	@FindBy(xpath = "(//div[@id='EVC1']//td/span[contains(.,'S_VLAN_START')]/../../../tr[2]/td[1]/input)[2]")
	public WebElementFacade s_vlan_ruid2;
	@FindBy(xpath = "(//div[@id='EVC1']//td/span[contains(.,'VACT')]/../../../tr[2]/td[1]/select)[4]")
	public WebElementFacade ce_vact_ruid2;
	@FindBy(xpath = "(//div[@id='EVC1']//td/span[contains(.,'CE_VLAN_START')]/../../../tr[2]/td[1]/input)[2]")
	public WebElementFacade ce_vlan_ruid2;
	@FindBy(xpath = "(//div[@id='EVC1']//td/span[contains(.,'LOS')]/../../../tr[2]/td[1]/input)[2]")
	public WebElementFacade los_ruid2;
	@FindBy(xpath = "(//div[@id='EVC1']//td/span[contains(.,'BDW')]/../../../tr[2]/td[1]/input)[2]")
	public WebElementFacade evcBandwidth_ruid2;

	// Supps
	@FindBy(xpath = "//img[@title='Supplement-Cancel']")
	public WebElementFacade supp1Icon;
	@FindBy(xpath = "//th/a/img[@title=' Supplement-DDDChange']")
	public WebElementFacade dddChange;
	@FindBy(xpath = "//input[@id='ddd']")
	public WebElementFacade dddtext;
	@FindBy(xpath = "//img[@onclick='javascript:goChange();']")
	public WebElementFacade changeButton;
	@FindBy(xpath = "//frame[@id='topFrame2']")
	public WebElementFacade suppsFrame;
	
	//Supp3/4
	@FindBy(xpath = "//img[@title='Supplement-Others']")
	public WebElementFacade supp3_4_Icon;
	
	//Adddress
	@FindBy(xpath = "(//td/span[contains(., 'SANO')]/../../../tr[2]/td/input)[1]")
	public WebElementFacade sano_Text;
	@FindBy(xpath = "(//td/span[contains(., 'SASN')]/../../../tr[2]/td/input)[1]")
	public WebElementFacade sasn_Text;
	@FindBy(xpath = "(//td/span[contains(., 'SATH')]/../../../tr[2]/td/input)[1]")
	public WebElementFacade sath_Text;
	@FindBy(xpath = "(//td/span[contains(., 'LD1')]/../../../tr[2]/td/input)[1]")
	public WebElementFacade ld1_Text;
	@FindBy(xpath = "(//td/span[contains(., 'LV1')]/../../../tr[2]/td/input)[1]")
	public WebElementFacade lv1;
	@FindBy(xpath = "(//td/span[contains(., 'LD2')]/../../../tr[2]/td/input)[1]")
	public WebElementFacade ld2_Text;
	@FindBy(xpath = "(//td/span[contains(., 'LV2')]/../../../tr[2]/td/input)[1]")
	public WebElementFacade lv2;
	
	@FindBy(xpath = "(//td/span[contains(., 'LD3')]/../../../tr[2]/td/input)[1]")
	public WebElementFacade ld3;
	
	@FindBy(xpath = "(//td/span[contains(., 'LV3')]/../../../tr[2]/td/input)[1]")
	public WebElementFacade lv3;
	
	@FindBy(xpath = "//input[@id='ASR_SERVICE_REQUEST::0#SWITCHED_ETHERNET_SVC::0#SES::0#SES_LOCATION::0#SALI::0#ADDR::0#CITY::0']")
	public WebElementFacade city;
	
	@FindBy(xpath = "//input[@id='ASR_SERVICE_REQUEST::0#SWITCHED_ETHERNET_SVC::0#SES::0#SES_LOCATION::0#SALI::0#ADDR::0#STATE::0']")
	public WebElementFacade state;
	
	@FindBy(xpath = "//input[@id='ASR_SERVICE_REQUEST::0#SWITCHED_ETHERNET_SVC::0#SES::0#SES_LOCATION::0#SALI::0#ADDR::0#ZIP::0']")
	public WebElementFacade zip;

	public WebElementFacade getUniqueElementInPage() {
		return loginButton;
	}
}
