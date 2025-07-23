package com.ctl.it.qa.Test_Four.tests.steps.eservices;

import java.io.IOException;

import com.ctl.it.qa.Test_Four.tests.AutomationConstants;
import com.ctl.it.qa.Test_Four.tools.steps.ease.EaseSteps;
import com.ctl.it.qa.Test_Four.tools.steps.eservices.BaseStep;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;

public class EaseStepDefinition {

	@Steps
	EaseSteps easeSteps;

	@Given("User is in EASE url")
	public void user_is_in_ease_url() {
		easeSteps.is_in_ease_login_page();
	}

	@When("^User logs in as a \"([^\"]*)\" user$")
	public void User_logs_in_as_a_user(String userType) {
		easeSteps.logs_in_as(userType);
	}

	@When("User search the existing {string} PON")
	public void user_search_the_existing_pon(String refPON) {
		easeSteps.SearchPONNumber(refPON);
	}

	@When("User fillup order details ES as {string} and spec as {string} for UNI")
	public void user_fillup_order_details_es_as_and_spec_as_for_uni(String esValue, String specValue) {

		String pon = BaseStep.readExcelData("UNI_Install", 1, 1) + AutomationConstants.randomNo;
		//String spec = BaseStep.readExcelData("UNI_Install", 2, 1);
		String ncValue = BaseStep.readExcelData("UNI_Install", 3, 1);
		String nciValue = BaseStep.readExcelData("UNI_Install", 4, 1);
		String secNciValue = BaseStep.readExcelData("UNI_Install", 5, 1);

		easeSteps.enterOrderDetails(pon, "MS02", "N");
		easeSteps.enterASRPageDetails("MCI", "08/25/2025", specValue, "UNI 1 GIG order with SPEC-"+specValue+" and ES value as- "+esValue, "",
				"");
		easeSteps.enterSESDetails(esValue, ncValue, nciValue, secNciValue,"");
		easeSteps.clickOnValidateButton_and_validateErrorText();
		easeSteps.clickOnSubmitOrderButton();
	}
	
	@When("User fillup order details ES as {string} and spec as {string} for CNB")
	public void user_fillup_order_details_es_as_and_spec_as_for_cnb(String esValue, String specValue) {
		String pon = BaseStep.readExcelData("CNB_Order", 1, 1) + AutomationConstants.randomNo;
		String ncValue = BaseStep.readExcelData("CNB_Order", 3, 1);
		String nciValue = BaseStep.readExcelData("CNB_Order", 4, 1);
		String secNciValue = BaseStep.readExcelData("CNB_Order", 5, 1);

		easeSteps.enterOrderDetails(pon, "MS02", "N");
		easeSteps.enterASRPageDetails("MCI", "08/25/2025", specValue, "CNB 1 GIG order with SPEC-SVCMUX and ES-S", "",
				"");
		easeSteps.enterSESDetails(esValue, ncValue, nciValue, secNciValue,"");
		easeSteps.clickOnValidateButton_and_validateErrorText();
		easeSteps.clickOnSubmitOrderButton();
	}

	@When("User fillup order details for EVC")
	public void user_fillup_order_details_for_evc() {

		String pon = BaseStep.readExcelData("EVC_Install", 1, 1) + AutomationConstants.randomNo;
		System.out.println("PONNumber--" + pon);
		String evcNC = BaseStep.readExcelData("EVC_Install", 2, 1);
		String evcsp_ruid1 = BaseStep.readExcelData("EVC_Install", 3, 1);
		String ruid1 = BaseStep.readExcelData("EVC_Install", 4, 1);
		String evcNCI_ruid1 = BaseStep.readExcelData("EVC_Install", 5, 1);
		String vact_ruid1 = "N";
		
		int intce_vlan_ruid1 = BaseStep.readNumericExcelData("EVC_Install", 6, 1);
		String ce_vlan_ruid1 = Integer.toString(intce_vlan_ruid1);
		String los1_ruid1 = BaseStep.readExcelData("EVC_Install", 7, 1);
		String evcBandwidth_ruid1 = BaseStep.readExcelData("EVC_Install", 8, 1);

		String evcsp_ruid2 = BaseStep.readExcelData("EVC_Install", 9, 1);
		String ruid2 = BaseStep.readExcelData("EVC_Install", 10, 1);
		String evcNCI_ruid2 = BaseStep.readExcelData("EVC_Install", 11, 1);
		String vact_ruid2 = "N";// need to modify
		int intce_vlan_ruid2 = BaseStep.readNumericExcelData("EVC_Install", 12, 1);
		String ce_vlan_ruid2 = Integer.toString(intce_vlan_ruid2);
		String los_ruid2 = BaseStep.readExcelData("EVC_Install", 13, 1);
		String evcBandwidth_ruid2 = BaseStep.readExcelData("EVC_Install", 14, 1);
		String remarks = BaseStep.readExcelData("EVC_Install", 15, 1);

		easeSteps.enterOrderDetails(pon, "MS02", "N");
		easeSteps.enterASRPageDetails("MCI", "08/25/2025", "", remarks+"with ruids-"+ruid1+"& "+ruid2, "", "");
		easeSteps.enterEVCDetails(evcNC, evcsp_ruid1, ruid1, evcNCI_ruid1, vact_ruid1, ce_vlan_ruid1, los1_ruid1,
				evcBandwidth_ruid1, evcsp_ruid2, ruid2, evcNCI_ruid2, vact_ruid2, ce_vlan_ruid2, los_ruid2,
				evcBandwidth_ruid2);
		easeSteps.clickOnValidateButton_and_validateErrorText();
		easeSteps.clickOnSubmitOrderButton();
	}

	@When("User fillup order details for EVC_Combo")
	public void user_fillup_order_details_for_evc_combo() {
		String pon = BaseStep.readExcelData("EVC_COMBO_Install", 1, 1) + AutomationConstants.randomNo;
		String evcNC = BaseStep.readExcelData("EVC_COMBO_Install", 2, 1);
		String evcNCI_ruid1 = BaseStep.readExcelData("EVC_COMBO_Install", 3, 1);
		String vact_ruid1 = "N";
		int intce_vlan_ruid1 = BaseStep.readNumericExcelData("EVC_COMBO_Install", 4, 1);
		String ce_vlan_ruid1 = Integer.toString(intce_vlan_ruid1);
		String los1_ruid1 = BaseStep.readExcelData("EVC_COMBO_Install", 5, 1);
		String evcBandwidth_ruid1 = BaseStep.readExcelData("EVC_COMBO_Install", 6, 1);

		String evcsp_ruid2 = BaseStep.readExcelData("EVC_COMBO_Install", 7, 1);
		String ruid2 = BaseStep.readExcelData("EVC_COMBO_Install", 8, 1);
		String evcNCI_ruid2 = BaseStep.readExcelData("EVC_COMBO_Install", 9, 1);
		String vact_ruid2 = "N";// need to modify
		int intce_vlan_ruid2 = BaseStep.readNumericExcelData("EVC_COMBO_Install", 10, 1);
		String ce_vlan_ruid2 = Integer.toString(intce_vlan_ruid2);
		// String ce_vlan_ruid2 = BaseStep.readExcelData("EVC_COMBO_Install", 10, 1);
		String los_ruid2 = BaseStep.readExcelData("EVC_COMBO_Install", 11, 1);
		String evcBandwidth_ruid2 = BaseStep.readExcelData("EVC_COMBO_Install", 12, 1);
		String specCode = BaseStep.readExcelData("EVC_COMBO_Install", 14, 1);
		String esValue = BaseStep.readExcelData("EVC_COMBO_Install", 17, 1);
		String ncValue = BaseStep.readExcelData("EVC_COMBO_Install", 18, 1);
		String nciValue = BaseStep.readExcelData("EVC_COMBO_Install", 19, 1);
		String secNciValue = BaseStep.readExcelData("EVC_COMBO_Install", 20, 1);
		
		
		System.out.println(pon);
		System.out.println(specCode);
		System.out.println(evcNC);
		System.out.println(evcNCI_ruid1);
		System.out.println(vact_ruid1);
		System.out.println(ce_vlan_ruid1);
		System.out.println(los1_ruid1);
		System.out.println(evcBandwidth_ruid1);
		System.out.println(evcsp_ruid2);
		System.out.println(ruid2);
		System.out.println(evcNCI_ruid2);
		System.out.println(vact_ruid2);
		System.out.println(ce_vlan_ruid2);
		System.out.println(los_ruid2);
		System.out.println(evcBandwidth_ruid2);
		
		easeSteps.enterOrderDetails(pon, "MS02", "N");
		easeSteps.enterASRPageDetails("MCI", "08/25/2025", specCode, "EVC Combo Order", "", "");
		easeSteps.enterSESDetails(esValue, ncValue, nciValue, secNciValue,"");
		easeSteps.enterEVCDetails(evcNC, "", "", evcNCI_ruid1, vact_ruid1, ce_vlan_ruid1, los1_ruid1,
				evcBandwidth_ruid1, evcsp_ruid2, ruid2, evcNCI_ruid2, vact_ruid2, ce_vlan_ruid2, los_ruid2,
				evcBandwidth_ruid2);
		easeSteps.clickOnValidateButton_and_validateErrorText();
		 easeSteps.clickOnSubmitOrderButton();
	}

	@When("User fillup order details for OVC")
	public void user_fillup_order_details_for_ovc() {

		String pon = BaseStep.readExcelData("OVC_Install", 1, 1) + AutomationConstants.randomNo;
		String ovcNC = BaseStep.readExcelData("OVC_Install", 2, 1);
		String evcsp_ruid1 = BaseStep.readExcelData("OVC_Install", 3, 1);
		String ruid1 = BaseStep.readExcelData("OVC_Install", 4, 1);
		String ovcNCI_ruid1 = BaseStep.readExcelData("OVC_Install", 5, 1);
		String s_vact_ruid1 = "N";
		String s_vlan_ruid1 = BaseStep.readExcelData("OVC_Install", 6, 1);
		String los1_ruid1 = BaseStep.readExcelData("OVC_Install", 7, 1);
		String evcBandwidth_ruid1 = BaseStep.readExcelData("OVC_Install", 8, 1);

		String evcsp_ruid2 = BaseStep.readExcelData("OVC_Install", 9, 1);
		String ruid2 = BaseStep.readExcelData("OVC_Install", 10, 1);
		String ovcNCI_ruid2 = BaseStep.readExcelData("OVC_Install", 11, 1);
		String vact_ruid2 = "N";// need to modify
		// String ce_vlan_ruid2 = BaseStep.readExcelData("OVC_Install", 12, 1);
		String los_ruid2 = BaseStep.readExcelData("OVC_Install", 13, 1);
		String evcBandwidth_ruid2 = BaseStep.readExcelData("OVC_Install", 14, 1);

		easeSteps.enterOrderDetails(pon, "MS02", "N");
		easeSteps.enterASRPageDetails("MCI", "08/25/2025", "", "OVC Install Order", "", "");
		easeSteps.enterEVCDetails(ovcNC, evcsp_ruid1, ruid1, ovcNCI_ruid1, s_vact_ruid1, s_vlan_ruid1, los1_ruid1,
				evcBandwidth_ruid1, evcsp_ruid2, ruid2, ovcNCI_ruid2, vact_ruid2, "", los_ruid2, evcBandwidth_ruid2);
		easeSteps.clickOnValidateButton_and_validateErrorText();
		 easeSteps.clickOnSubmitOrderButton();
	}

	@When("User fillup order details for OVC_Combo")
	public void user_fillup_order_details_for_ovc_combo() {

		String pon = BaseStep.readExcelData("OVC_COMBO_Install", 1, 1) + AutomationConstants.randomNo;
		String ovcNC = BaseStep.readExcelData("OVC_COMBO_Install", 2, 1);
		String evcNCI_ruid1 = BaseStep.readExcelData("OVC_COMBO_Install", 3, 1);
		String vact_ruid1 = "N";
		int intce_vlan_ruid1 = BaseStep.readNumericExcelData("OVC_COMBO_Install", 4, 1);
		String ce_vlan_ruid1 = Integer.toString(intce_vlan_ruid1);
		String los1_ruid1 = BaseStep.readExcelData("OVC_COMBO_Install", 5, 1);
		String evcBandwidth_ruid1 = BaseStep.readExcelData("OVC_COMBO_Install", 6, 1);

		String evcsp_ruid2 = BaseStep.readExcelData("OVC_COMBO_Install", 7, 1);
		String ruid2 = BaseStep.readExcelData("OVC_COMBO_Install", 8, 1);
		String evcNCI_ruid2 = BaseStep.readExcelData("OVC_COMBO_Install", 9, 1);
		String vact_ruid2 = "N";// need to modify
		int ints_vlan_ruid2 = BaseStep.readNumericExcelData("OVC_COMBO_Install", 10, 1);
		String s_vlan_ruid2 = Integer.toString(ints_vlan_ruid2);
		String los_ruid2 = BaseStep.readExcelData("OVC_COMBO_Install", 11, 1);
		String evcBandwidth_ruid2 = BaseStep.readExcelData("OVC_COMBO_Install", 12, 1);
		
		String specCode = BaseStep.readExcelData("OVC_COMBO_Install", 14, 1);
		String remarks = BaseStep.readExcelData("OVC_COMBO_Install", 13, 1);
		String esValue = BaseStep.readExcelData("OVC_COMBO_Install", 17, 1);
		String ncValue = BaseStep.readExcelData("OVC_COMBO_Install", 18, 1);
		String nciValue = BaseStep.readExcelData("OVC_COMBO_Install", 19, 1);
		String secNciValue = BaseStep.readExcelData("OVC_COMBO_Install", 20, 1);
		
		easeSteps.enterOrderDetails(pon, "MS02", "N");
		easeSteps.enterASRPageDetails("MCI", "08/25/2025", specCode, remarks+" with ENNI-"+ruid2, "", "");
		easeSteps.enterSESDetails(esValue, ncValue, nciValue, secNciValue,"");
		easeSteps.enterEVCDetails(ovcNC, "", "", evcNCI_ruid1, "", "", los1_ruid1,
				evcBandwidth_ruid1, evcsp_ruid2, ruid2, evcNCI_ruid2, vact_ruid2, s_vlan_ruid2, los_ruid2,
				evcBandwidth_ruid2);
		easeSteps.clickOnValidateButton_and_validateErrorText();
	    easeSteps.clickOnSubmitOrderButton();
	}

//Supp2
	@When("User submit supp2 on order")
	public void user_submit_supp2_on_order() {
		
		easeSteps.user_Submit_Supp2_On_Order();
	}

	@When("User submit the UNI Change order by changing {string} , {string} and {string} field")
	public void user_submit_the_uni_change_order_by_changing_and_field(String string, String string2, String string3)
			throws IOException {

		String pon = BaseStep.readExcelData("UNI_Change", 1, 1) + AutomationConstants.randomNo;
		String esValue = BaseStep.readExcelData("UNI_Change", 9, 1);
		String tspValue = BaseStep.readExcelData("UNI_Change", 3, 1);
		String specValue = BaseStep.readExcelData("UNI_Change", 5, 1);
		String service = BaseStep.readExcelData("UNI_Change", 2, 1);
		String remarks = BaseStep.readExcelData("UNI_Change", 10, 1);
		String espValue = BaseStep.readExcelData("", 10, 1);
		easeSteps.enterOrderDetails(pon, "MS02", "C");
		easeSteps.enterASRPageDetails("MCI", "08/25/2025", specValue, remarks, tspValue, service);
		easeSteps.enterSESDetails(esValue, "", "", "",espValue);
		easeSteps.clickOnValidateButton_and_validateErrorText();
		easeSteps.clickOnSubmitOrderButton();
	}

	@When("User submit the UNI Change order by changing {string} , {string} field")
	public void user_submit_the_uni_change_order_by_changing_field(String string, String string2) {

		String pon = BaseStep.readExcelData("UNI_HotCut", 1, 1) + AutomationConstants.randomNo;
		String service = BaseStep.readExcelData("UNI_HotCut", 2, 1);
		String ncCodeValue = BaseStep.readExcelData("UNI_HotCut", 6, 1);
		String nciCodeValue = BaseStep.readExcelData("UNI_HotCut", 7, 1);
		String secNciValue = BaseStep.readExcelData("UNI_HotCut", 8, 1);
		String remarks = BaseStep.readExcelData("UNI_HotCut", 10, 1);
		String espValue = BaseStep.readExcelData("UNI_HotCut", 10, 1);
		
		easeSteps.enterOrderDetails(pon, "MS02", "C");
		easeSteps.enterASRPageDetails("MCI", "08/25/2025", "", remarks, "", service);
		easeSteps.enterSESDetails("", ncCodeValue, nciCodeValue, secNciValue, "");
		easeSteps.clickOnValidateButton_and_validateErrorText();
		easeSteps.clickOnSubmitOrderButton();
	}

	@When("User search the install {string} PON")
	public void user_search_the_install_pon(String orderType) {
		String pon = "";
		if (orderType.equals("UNI")) {
			pon = BaseStep.readExcelData("UNI_Supp", 1, 1);
		} else if (orderType.equals("EVC")) {
			pon = BaseStep.readExcelData("EVC_Supp", 1, 1);
		} else if (orderType.equals("OVC")) {
			pon = BaseStep.readExcelData("OVC_Supp", 1, 1);
		} else if (orderType.equals("EVCCombo")) {
			pon = BaseStep.readExcelData("EVC_COMBO_Supp", 1, 1);
		} else if (orderType.equals("OVCCombo")) {
			pon = BaseStep.readExcelData("OVC_COMBO_Supp", 1, 1);
		}
		easeSteps.user_Search_Install_PON(pon);
	}

	@When("User submit the Supp1 on order")
	public void user_submit_the_supp1_on_order() {
		String pon = BaseStep.readExcelData("EVC_Supp", 1, 1);
		easeSteps.user_Submit_Supp1_On_Order(pon);
	}

	@Then("User validate Supp1 successfully submitted")
	public void user_validate_supp1_successfully_submitted() {

	}

	@When("User open the install {string} order")
	public void user_open_the_install_order(String orderType) {
		
		//easeSteps.user_Open_Install_Order(orderType);
	}

	@When("User submit the {string} disconnect order")
	public void user_submit_the_disconnect_order(String orderType) {

		
		if(orderType.equals("UNI"))
		{
		String pon = BaseStep.readExcelData("UNI_Disconnect", 1, 1) + AutomationConstants.randomNo;
		String service = BaseStep.readExcelData("UNI_Disconnect", 2, 1);
		String ncCodeValue = BaseStep.readExcelData("UNI_Disconnect", 3, 1);
		String nciCodeValue = BaseStep.readExcelData("UNI_Disconnect", 4, 1);
		String secNciValue = BaseStep.readExcelData("UNI_Disconnect", 5, 1);
		String specCode = BaseStep.readExcelData("UNI_Disconnect", 6, 1);		
		String remarks = BaseStep.readExcelData("UNI_Disconnect", 7, 1);
		
		easeSteps.enterOrderDetails(pon, "MS02","D");
		easeSteps.enterASRPageDetails("MCI", "07/21/2025", specCode, remarks, "", service);
		easeSteps.enterSESDetails("", ncCodeValue, nciCodeValue, secNciValue,"");
		easeSteps.clickOnValidateButton_and_validateErrorText();
		easeSteps.clickOnSubmitOrderButton();
		}
		else if(orderType.equals("EVC"))
		{	
			System.out.println("Enter EVC Disconnect details");
		String pon = BaseStep.readExcelData("EVC_Disconnect", 1, 1) + AutomationConstants.randomNo;
		String evcNC = BaseStep.readExcelData("EVC_Disconnect", 2, 1);
		String ruid1 = BaseStep.readExcelData("EVC_Disconnect", 3, 1);
		String evcNCI_ruid1 = BaseStep.readExcelData("EVC_Disconnect", 4, 1);
		String ruid2 = BaseStep.readExcelData("EVC_Disconnect", 5, 1);
		String evcNCI_ruid2 = BaseStep.readExcelData("EVC_Disconnect", 6, 1);		
		String remarks = BaseStep.readExcelData("EVC_Disconnect", 7, 1);
		String evcId = BaseStep.readExcelData("EVC_Disconnect", 8, 1);
		
		easeSteps.enterOrderDetails(pon, "MS02","D");
		easeSteps.enterASRPageDetails("MCI", "07/21/2025", "", remarks+"-"+evcId, "", "");
		//easeSteps.enterSESDetails("", ncCodeValue, nciCodeValue, secNciValue,"");
		easeSteps.enterEVCDetails(evcNC, "", ruid1, evcNCI_ruid1, "", "", "",
				"", "", ruid2, evcNCI_ruid2, "", "", "","");
		easeSteps.enterEVC_Id_for_Change_and_Disconnect(evcId);
		easeSteps.clickOnValidateButton_and_validateErrorText();
		easeSteps.clickOnSubmitOrderButton();
		
		}
		
	
	}
	
	@When("User submit the UNI transfer order by changing {string} field")
	public void user_submit_the_uni_transfer_order_by_changing_field(String string) {
		String pon = BaseStep.readExcelData("TRANSFER_Order", 1, 1) + AutomationConstants.randomNo;
		String service = BaseStep.readExcelData("TRANSFER_Order", 2, 1);
		String ncCodeValue = BaseStep.readExcelData("TRANSFER_Order", 4, 1);
		String nciCodeValue = BaseStep.readExcelData("TRANSFER_Order", 5, 1);
		String secNciValue = BaseStep.readExcelData("TRANSFER_Order", 6, 1);
		String remarks = BaseStep.readExcelData("TRANSFER_Order", 7, 1);
		String espValue = BaseStep.readExcelData("", 7, 1);
		
		easeSteps.enterOrderDetails(pon, "MS02", "T");
		easeSteps.enterASRPageDetails("MCI", "08/25/2025", "", remarks, "", service);
		easeSteps.enterSESDetails("", ncCodeValue, nciCodeValue, secNciValue,espValue);
		//easeSteps.enterAddressDetailsInSESPage("", ncCodeValue, nciCodeValue, secNciValue);
		easeSteps.clickOnValidateButton_and_validateErrorText();
		easeSteps.clickOnSubmitOrderButton();
	}

	@When("User submit the UNI Move order by changing {string} field")
	public void user_submit_the_uni_move_order_by_changing_field(String string) {
		String pon = BaseStep.readExcelData("MOVE_Order", 1, 1) + AutomationConstants.randomNo;
		String service = BaseStep.readExcelData("MOVE_Order", 2, 1);
		String specCode = BaseStep.readExcelData("MOVE_Order", 3, 1);
		String ncCodeValue = BaseStep.readExcelData("MOVE_Order", 4, 1);
		String nciCodeValue = BaseStep.readExcelData("MOVE_Order", 5, 1);
		String secNciValue = BaseStep.readExcelData("MOVE_Order", 6, 1);
		String remarks = BaseStep.readExcelData("MOVE_Order", 8, 1);
		String espValue = BaseStep.readExcelData("MOVE_Order", 7, 1);

		easeSteps.enterOrderDetails(pon, "MS02", "M");
		easeSteps.enterASRPageDetails("MCI", "08/25/2025", specCode, remarks+service, "", service);
		easeSteps.enterSESDetails("", ncCodeValue, nciCodeValue, secNciValue,espValue);
		easeSteps.clickOnValidateButton_and_validateErrorText();
		easeSteps.clickOnSubmitOrderButton();
	}

	
	@When("User submit the Supp3 on order")
	public void user_submit_the_supp3_on_order() {
	    String pon ="";
	    String specCode = BaseStep.readExcelData("UNI_Supp", 2, 1);
		//easeSteps.user_Submit_Supp3_On_Order(pon);
	    System.out.println("Spec-"+specCode);
		easeSteps.enterASRPageDetails("", "", specCode, "Supp3 Submitted", "", "");
		easeSteps.enterSESDetails("", "", "", "","");
		easeSteps.clickOnValidateButton_and_validateErrorText();
		easeSteps.clickOnSubmitOrderButton();
	}

	@Then("User validate Supp3 successfully submitted")
	public void user_validate_supp3_successfully_submitted() {
	   
	}

}
