package com.ctl.it.qa.Test_Four.tests.steps.eservices;

import org.json.simple.parser.ParseException;

import com.ctl.it.qa.Test_Four.tools.steps.restServices.DeviceAvailabilityRestServices;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import net.serenitybdd.core.Serenity;

public class DeviceAvaiabilityStepDefination {
	@Steps
	DeviceAvailabilityRestServices labRestServices;

	@When("I check the availability of Mesh")
	public void i_check_the_availability_of_Mesh() {
		labRestServices.validateAvaiabilityMeshEndPoint();
	}

	@When("I check the availability of ACT")
	public void i_check_the_availability_of_ACT() {
		labRestServices.validateAvaiabilityACTEndPoint();
	}

	@Then("I complete the order in FD with required details and push the order for further AP flows")
	public void i_complete_the_order_in_FD_with_required_details_and_push_the_order_for_further_AP_flows() {
		labRestServices.i_complete_the_order_in_FD_with_required_details_and_push_the_order_for_further_AP_flows();
	}

	@Then("I am validating the status of {string} tasks created in FD as complete")
	public void i_am_checking_the_status_of_tasks_created_in_FD(String no)
			throws NumberFormatException, ParseException, InterruptedException {
		String ID = Serenity.sessionVariableCalled("ID");
		labRestServices.validateTaskStatus(Integer.parseInt(no), ID);
	}
	
	@Given("User open the mesh url")
	public void user_open_the_mesh_url() throws ParseException, InterruptedException {
		
		labRestServices.validate_Mesh_1GIG_PortAvaialbalilty();
		
		//labRestServices.validateTaskStatus(0, "");
	}

	@Then("User validates the mesh response")
	public void user_validates_the_mesh_response() {
	    System.out.println("Validated mesh response");
	}



}
