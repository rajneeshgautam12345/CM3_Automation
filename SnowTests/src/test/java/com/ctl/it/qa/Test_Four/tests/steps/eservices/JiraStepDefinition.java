package com.ctl.it.qa.Test_Four.tests.steps.eservices;

import com.ctl.it.qa.Test_Four.tools.steps.eservices.JiraSteps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;

public class JiraStepDefinition {
	@Steps
	JiraSteps jirasteps;

	@Given("I am logged in as a {string} in Jira {string}")
	public void i_am_logged_in_as_a_in_Jira(String user, String story) {
		jirasteps.i_am_logged_in_as_a_user_in_Jira(user, story);
	}

	@When("I start working on some specific story {string} of any specific sprint")
	public void i_start_working_on_some_specific_story_of_any_specific_sprint(String story) {
		jirasteps.i_start_working_on_some_specific_story_of_any_specific_sprint(story);
	}

	@When("I create sub tasks for that story")
	public void i_create_sub_tasks_for_that_story() {
		jirasteps.i_create_sub_tasks_for_that_story();
	}

	@Then("Sub tasks should be created for that story having equal story points")
	public void sub_tasks_should_be_created_for_that_story_having_equal_story_points() {
		jirasteps.sub_tasks_should_be_created_for_that_story_having_equal_story_points();
	}
}
