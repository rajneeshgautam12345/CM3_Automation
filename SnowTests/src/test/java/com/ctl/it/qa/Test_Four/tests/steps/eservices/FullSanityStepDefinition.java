package com.ctl.it.qa.Test_Four.tests.steps.eservices;

import com.ctl.it.qa.Test_Four.tools.steps.eservices.FullSanitySteps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;

public class FullSanityStepDefinition {
	@Steps
	FullSanitySteps fullsanitysteps;

	@Given("I am checking Mesh in specified environment {string}")
	public void i_am_checking_Mesh_in_specified_environment(String ENV) {
		fullsanitysteps.i_am_checking_Mesh_in_specified_environment(ENV);
	}

	@Given("I am checking SASI in specified environment {string}")
	public void i_am_checking_SASI_in_specified_environment(String ENV) {
		fullsanitysteps.i_am_checking_SASI_in_specified_environment(ENV);
	}

	@Given("I am checking ACT in specified environment {string}")
	public void i_am_checking_ACT_in_specified_environment(String ENV) {
		fullsanitysteps.i_am_checking_ACT_in_specified_environment(ENV);
	}
	
	
	

@Given("User is in Autopilot url")
public void user_is_in_autopilot_url() {
	fullsanitysteps.user_is_in_autopilot_page();
}

@When("User navigate to LNAAS_DELETE_TRANSACTION_ACT_TL_V1 flow in automatio Studio")
public void user_navigate_to_lnaas_delete_transaction_act_tl_v1_flow_in_automatio_studio() {
	fullsanitysteps.user_navigate_to_LNAAS_DELETE_TRANSACTION_ACT_TL_V1_flow();
}

@When("User enters the details {string} and {string}")
public void user_enters_the_details_and(String actIdentifierId, String correlationId) {
	fullsanitysteps.user_enter_the_request_payload_for_EVC_OVC_Delete(actIdentifierId,correlationId);
}

//@When("User enters the details")
//public void user_enters_the_details() {
//	
//	
//	
//}

@When("User enters UNI details for cleanup {string} and {string}")
public void user_enters_uni_details_for_cleanup_and(String customerName, String serviceId) {
	fullsanitysteps.user_enter_the_request_payload_for_UNI_Delete(customerName, serviceId);
	
}

@When("User navigate to LNAAS_DELETE_COLORLESS_PORT_SL_V1 flow in automatio Studio")
public void user_navigate_to_lnaas_delete_colorless_port_sl_v1_flow_in_automatio_studio() {
	fullsanitysteps.user_navigate_to_LNAAS_DELETE_COLORLESS_PORT_SL_V1();
}

@When("User click on start to trigger the flow")
public void user_click_on_start_to_trigger_the_flow() {
	fullsanitysteps.userStartTheWorkflow();
}

@Then("User validates workflow status")
public void user_validates_workflow_status() {
  //
}
}
