package com.ctl.it.qa.Test_Four.tests.steps.eservices;

import com.ctl.it.qa.Test_Four.tools.steps.orchestrator.OrchestratorSteps;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;

public class OrchestratorStepDefinition {

	@Steps
	OrchestratorSteps orchestatorSteps;	

	@Given("User logs in as valid user in orchestrator")
	public void user_logs_in_as_valid_user_in_orchestrator() {
		orchestatorSteps.login_in_Orchestrator();
	}

	@When("User search the order")
	public void user_search_the_order() {
		orchestatorSteps.searchPON_In_Orchestrator();
	}

	@Then("order record should display")
	public void order_record_should_display() {
		orchestatorSteps.validateSearchedPON_In_Orchestrator();
	}

	@When("User entered the SWC for UNI and Combo Order")
	public void user_entered_the_swc_for_uni_and_combo_order() {
		orchestatorSteps.enterSWC();
	}

	@Then("User validate and complete the INTERNAL tasks")
	public void user_validate_and_complete_the_internal_tasks() {
		orchestatorSteps.waitABit(7000);
		orchestatorSteps.refreshOrchestratorPage();
		orchestatorSteps.waitABit(5000);
		orchestatorSteps.validateOverallStatusOfRow1();
		orchestatorSteps.waitABit(10000);
	}

	@Then("User validate and complete the SWC tasks")
	public void user_validate_and_complete_the_swc_tasks() {
		orchestatorSteps.refreshOrchestratorPage();
		orchestatorSteps.waitABit(5000);
		orchestatorSteps.validateOverallStatusOfRow2();
		orchestatorSteps.waitABit(8000);
		orchestatorSteps.refreshOrchestratorPage();
		orchestatorSteps.waitABit(5000);

	}

	@Then("User validate NONASOG tasks in completed status")
	public void user_validate_nonasog_tasks_in_completed_status() {
		orchestatorSteps.validateOverallStatusOfNonASOGRow();
		orchestatorSteps.waitABit(3000);
		orchestatorSteps.refreshOrchestratorPage();
		orchestatorSteps.waitABit(5000);
	}

	@Then("User validate accept project task is in Completed status")
	public void user_validate_accept_project_task_is_in_completed_status() {
		orchestatorSteps.validateAcceptProjectStatusForUNI_Or_Combo();
		orchestatorSteps.refreshOrchestratorPage();
		orchestatorSteps.waitABit(5000);
		//easeSteps.
		//baseStep.quitBrowser();
	}
	
	@Then("User validate accept project task is in Completed status for EVC")
	public void user_validate_accept_project_task_is_in_completed_status_for_evc() {
		orchestatorSteps.validateAcceptProjectStatusForEVC();
		//baseStep.quitBrowser();
		
	}
	

@When("User entered the SWC for UNI Disco and Combo Order")
public void user_entered_the_swc_for_uni_disco_and_combo_order() {
	orchestatorSteps.enterSWCForDisco();}

}
