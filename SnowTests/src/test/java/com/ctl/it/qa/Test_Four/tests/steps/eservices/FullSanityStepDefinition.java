package com.ctl.it.qa.Test_Four.tests.steps.eservices;

import com.ctl.it.qa.Test_Four.tools.steps.eservices.FullSanitySteps;

import io.cucumber.java.en.Given;
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
}
