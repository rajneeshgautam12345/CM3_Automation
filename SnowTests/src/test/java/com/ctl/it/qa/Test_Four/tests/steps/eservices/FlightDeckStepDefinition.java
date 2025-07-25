package com.ctl.it.qa.Test_Four.tests.steps.eservices;
import java.util.List;
import org.junit.Assert;
import com.ctl.it.qa.Test_Four.tools.steps.eservices.BaseStep;
import com.ctl.it.qa.Test_Four.tools.steps.flightdeck.FlightDeckSteps;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FlightDeckStepDefinition {
	
	@Steps
	FlightDeckSteps flightDecksteps;
	private final Logger logger = LoggerFactory.getLogger(FlightDeckStepDefinition.class);

	@Given("User logs in as valid user in flight deck")
	public void user_logs_in_as_valid_user_in_flight_deck() {
		flightDecksteps.logs_in_flightDeck();
		//logger.info("Successfully logged in Flight Deck Apllication");
	}

	@When("User navigate to Advance Search Page")
	public void user_navigate_to_Advance_Search_Page() {
		flightDecksteps.navigate_To_AdvanceSearch();
		
	}

	@Then("User successfully navigated to advance search page")
	public void user_successfully_navigated_to_advance_search_page() {
		flightDecksteps.validateAdvanceSearchPage();
	}

	
	@When("User enters the Order Id and hit on search")
	public void user_enters_the_Order_Id_and_hit_on_search() {
		flightDecksteps.searchOrderId();
		flightDecksteps.selectPerPageTaskSize("10");
	}

	@Then("Order records successfully dispalyed")
	public void order_records_successfully_dispalyed() {
	}

	// Snow Added
	@When("User logs in flightdeck application")
	public void user_logs_in_flightdeck_application() {
		flightDecksteps.logs_in_flightDeck();
	}

	@Then("User validates the {string} task kicked off for order")
	public void user_validates_the_task_kicked_off_for_order(String taskName) {
		flightDecksteps.user_Switch_To_Flight_Deck_Window();
		flightDecksteps.waitABit(60000);
		// flightDecksteps.User_Search_Task(taskName);
	}

	@Then("User validates {string} task successfully completed")
	public void user_validates_task_successfully_completed(String taskName) {

		boolean status = false;
		for (int i = 1; i <= 10; i++) {
			flightDecksteps.userRefreshTaskPage();
			flightDecksteps.waitABit(5000);
			int totalTask = flightDecksteps.userValidateTotalNumberOfTasks();
			if (taskName.equals("Get Mesh Path")) {
				flightDecksteps.waitABit(25000);
				if (totalTask >= 16) {
					flightDecksteps.waitABit(5000);
					flightDecksteps.userValidateTaskName(taskName);
					flightDecksteps.userValidateTaskIsInCompletedStatus(taskName);
					status = true;
					break;
				}
			}

			else if (taskName.equals("Select Location")) {
				if (totalTask >= 21) {
					flightDecksteps.waitABit(5000);
					flightDecksteps.userRefreshTaskPage();
					flightDecksteps.waitABit(2000);
					flightDecksteps.userValidateTaskName(taskName);
					String taskStatus=flightDecksteps.userValidateTaskStatus(taskName);
					if (taskStatus.equals("Assigned") || taskStatus.equals("Created")) {
						flightDecksteps.waitABit(5000);
						logger.info("Select Location task is in "+taskStatus+" state");
						continue;
					}
					flightDecksteps.userValidateTaskIsInCompletedStatus(taskName);
					status = true;
					break;
				}
			}
			

			else if (taskName.equals("Activate UNI in ACT")) {
				flightDecksteps.waitABit(60000);
				if (totalTask >= 37) {
					flightDecksteps.waitABit(5000);
					flightDecksteps.userValidateTaskName(taskName);
					String taskStatus=flightDecksteps.userValidateTaskStatus(taskName);
					//String taskStatus = flightDecksteps.userValidateTaskIsInCompletedStatus(taskName);
					if (taskStatus.equals("In-Progress") || taskStatus.equals("Retry Submitted")||taskStatus.equals("Created")) {
						flightDecksteps.waitABit(5000);
						logger.info("Activate UNI in ACT task is in "+taskStatus+" state");
						continue;
					}
					flightDecksteps.userValidateTaskIsInCompletedStatus(taskName);
					status = true;
					break;

				}

			} else if (taskName.equals("CM-Test and Tag")) {
				flightDecksteps.waitABit(10000);
				if (totalTask >= 43) {
					flightDecksteps.waitABit(5000);
					flightDecksteps.userValidateTaskName(taskName);
					flightDecksteps.userValidateTaskIsInCompletedStatus(taskName);
					status = true;
					break;
				}

			} else if (taskName.equals("Send Manual PTA")) {
				flightDecksteps.waitABit(10000);
				if (totalTask >= 46) {
					flightDecksteps.waitABit(5000);
					flightDecksteps.userValidateTaskName(taskName);
					flightDecksteps.userValidateTaskIsInCompletedStatus(taskName);
					status = true;
					break;
				}

			}
		 else if (taskName.equals("Supervised Disconnect Review")) {
			//flightDecksteps.waitABit(10000);
			if (totalTask >= 21) {
				//flightDecksteps.waitABit(5000);
				flightDecksteps.userValidateTaskName(taskName);
				flightDecksteps.userValidateTaskIsInCompletedStatus(taskName);
				status = true;
				break;
			}

		}

		}
		if (status == false) {
			Assert.assertEquals("Task should completed", taskName + " is not in completed status");
		}

		logger.info("Successfully validated the" +taskName +" is in completed status");
	}

	@When("User refresh the page")
	public void user_refresh_the_page() {
		flightDecksteps.userRefreshTaskPage();
	}

	@Then("User validates the {string} task is in {string} status")
	public void user_validates_the_task_is_in_status(String taskName, String status) {
		boolean taskStatus = false;
		for (int i = 1; i <= 10; i++) {
			flightDecksteps.userRefreshTaskPage();
			flightDecksteps.waitABit(9000);
			int totalTask = flightDecksteps.userValidateTotalNumberOfTasks();

			if (taskName.equals("Select Location")) {
//				if (i == 1) {
//					flightDecksteps.waitABit(60000);
//				}
				flightDecksteps.waitABit(15000);
				if (totalTask >= 21) {
					flightDecksteps.waitABit(5000);
					flightDecksteps.userValidateTaskName(taskName);
					String taskStatus2 = flightDecksteps.userValidateTaskStatus(taskName);
					if (taskStatus2.equals("Created")) {
						//i++;
						flightDecksteps.waitABit(3000);
						 System.out.println(taskName +" is in "+taskStatus2+" status");
						continue;						
					}
					flightDecksteps.userValidateTaskStatus(taskName, status);
					taskStatus = true;
					break;
				}
			}

			else if (taskName.equals("CM-Test and Tag")) {
//				if (i == 1) {
//					flightDecksteps.waitABit(120000);
//					flightDecksteps.userRefreshTaskPage();
//				}
				flightDecksteps.waitABit(20000);
				if (totalTask >= 44) {
					flightDecksteps.userValidateTaskName(taskName);
					String taskStatus2 = flightDecksteps.userValidateTaskStatus(taskName, status);
					if (taskStatus2.equals("Ready") && !taskStatus2.equals(status) && i<=9) {
                        i++;
                        //taskStatus = true;
                        flightDecksteps.waitABit(3000);
                        System.out.println(taskName +" is in "+taskStatus2+" status");
						continue;
					}
					taskStatus = true;
					break;
				}
			}

			else if (taskName.equals("Send Manual PTA")) {
//				if (i == 1) {
//					flightDecksteps.waitABit(80000);
//				}
				flightDecksteps.waitABit(15000);
				if (totalTask >= 46) {
					flightDecksteps.userValidateTaskName(taskName);
					String taskStatus2=flightDecksteps.userValidateTaskStatus(taskName);
					if (taskStatus2.equals("Created")) {
						flightDecksteps.waitABit(3000);
						System.out.println(taskName +" is in "+taskStatus2+" status");
						continue;
					}			
					flightDecksteps.userValidateTaskStatus(taskName, status);
					taskStatus = true;
					break;
				}
			}

			else if (taskName.equals("Ease Completion sent")) {
//				if (i == 1) {
//					flightDecksteps.waitABit(90000);
//				}
				flightDecksteps.waitABit(15000);
				if (totalTask > 49) {
					flightDecksteps.userValidateTaskName(taskName);
					String taskStatus2=flightDecksteps.userValidateTaskStatus(taskName);
					if (taskStatus2.equals("Created")||taskStatus2.equals("In-Progress")) {
                        i++;
                        flightDecksteps.waitABit(3000);
                        System.out.println(taskName +" is in "+taskStatus2+" status");
						continue;
					}
					flightDecksteps.userValidateTaskStatus(taskName, status);
					taskStatus = true;
					break;
				}
			}

			else if (taskName.equals("MOB Notification")) {
//				if (i == 1) {
//					flightDecksteps.waitABit(20000);
//				}
				flightDecksteps.waitABit(10000);
				if (totalTask > 49) {
					flightDecksteps.userValidateTaskName(taskName);		
					String taskStatus2=flightDecksteps.userValidateTaskStatus(taskName);
					if (taskStatus2.equals("Created")||taskStatus2.equals("In-Progress")) {
                        i++;
                        flightDecksteps.waitABit(3000);
                        System.out.println(taskName +" is in "+taskStatus2+" status");
						continue;
					}
					flightDecksteps.userValidateTaskStatus(taskName, status);
					taskStatus = true;
					break;
					}
				
			} else if (taskName.equals("Disconnect Arm Inventory delay")) {

				flightDecksteps.waitABit(20000);
				if (totalTask >= 32) {
					flightDecksteps.userValidateTaskName(taskName);
					flightDecksteps.userValidateTaskStatus(taskName, status);
					taskStatus = true;
					break;
				}
			}
				else if (taskName.equals("Disconnect Order")) {

					flightDecksteps.waitABit(20000);
					if (totalTask > 16) {
						flightDecksteps.userValidateTaskName(taskName);
						flightDecksteps.userValidateTaskStatus(taskName, status);
						taskStatus = true;
						break;
					}
			}
		
		else if (taskName.equals("Supervised Disconnect Review")) {

			flightDecksteps.waitABit(20000);
			if (totalTask > 20) {
				flightDecksteps.userValidateTaskName(taskName);
				flightDecksteps.userValidateTaskStatus(taskName, status);
				taskStatus = true;
				break;
			}
	}
			
		else if (taskName.equals("CNB Determine Action")||taskName.equals("Colorless Network Build"))
				{
//			if (i == 1) {
//				flightDecksteps.waitABit(20000);
//			}
			flightDecksteps.waitABit(20000);
			if (totalTask > 24) {
				flightDecksteps.userValidateTaskName(taskName);
				//flightDecksteps.userValidateTaskStatus(taskName, status);
				taskStatus = true;
				break;
			}
		}
		}
		
		if (taskStatus == false) {
			Assert.assertEquals("Task status is not correct", taskName + " is in wrong status");
		}
	}

	@When("User enters the details and retry the task")
	public void user_enters_the_details_and_retry_the_task() {
		flightDecksteps.User_Search_And_Open_Task("Select Location");
		flightDecksteps.userSelfAssignTask();
		flightDecksteps.closeTaskPagePopupBar();
		flightDecksteps.userClickOnEditTaskButton();
		flightDecksteps.userSelectLocation();
		flightDecksteps.clickOnSaveButtonOnTask();
		flightDecksteps.clickOnRetryButtonOnTask();
		flightDecksteps.closedOpenedTask();
		flightDecksteps.switchBackTSearchResultSection();
	}

	@When("User self assign and complete the {string} task")
	public void user_self_assign_and_complete_the_task(String task) {
		flightDecksteps.User_Search_And_Open_Task(task);
		if (task.equals("CM-Test and Tag")) {			
			flightDecksteps.retrieveServiceId();			
			flightDecksteps.userOpenTasksMoreMenuOption();
		}
		if (task.equals("Supervised Disconnect Review")) {
			flightDecksteps.unblockTask();
			flightDecksteps.closeTaskPagePopupBar();
		}
		flightDecksteps.userSelfAssignTask();
		flightDecksteps.closeTaskPagePopupBar();
		flightDecksteps.completeTask();
		flightDecksteps.closeTaskPagePopupBar();
		flightDecksteps.closedOpenedTask();
		flightDecksteps.switchBackTSearchResultSection();
	}

	@When("User complete the task")
	public void user_complete_the_task() {
		flightDecksteps.completeTask();
		flightDecksteps.closeTaskPagePopupBar();
		flightDecksteps.closedOpenedTask();
		flightDecksteps.switchBackTSearchResultSection();
	}

	@When("User self assign and enter the {string} task details")
	public void user_self_assign_and_enter_the_task_details(String task) {
		flightDecksteps.User_Search_And_Open_Task(task);
		flightDecksteps.userSelfAssignTask();
		flightDecksteps.closeTaskPagePopupBar();
		flightDecksteps.userClickOnEditTaskButton();
		flightDecksteps.enterDetailsInTask(task);
		flightDecksteps.clickOnSaveButtonOnTask();
	}

	// For EVC
	@Then("User validates Order_Persistence flow task successfully completed")
	public void user_validates_Order_Persistence_flow_task_successfully_completed(DataTable dataTable) {
		List<List<String>> data = dataTable.asLists();
		
		String taskStatus = "In-Progress";
		for (int i = 0; i <= data.size()-1; i++) {
			String taskName = data.get(i).get(0);
			for (int j = 0; j <= 4 & (!taskStatus.equals("Completed")); j++) {
				flightDecksteps.userRefreshTaskPage();
				flightDecksteps.waitABit(2000);
				flightDecksteps.userValidateTaskName(taskName);
				taskStatus = flightDecksteps.userValidateTaskStatus(taskName);
				flightDecksteps.waitABit(2000);
			}
			flightDecksteps.userValidateTaskIsInCompletedStatus(taskName);
		}
		
		
//		for (int i = 0; i <= data.size()-1; i++) {
//			String taskName = data.get(i).get(0);
//			flightDecksteps.userValidateTaskName(taskName);
//			flightDecksteps.userValidateTaskIsInCompletedStatus(taskName);
//		}
		flightDecksteps.waitABit(30000);
		
	}

	@Then("User validates Master_Qualification flow task successfully completed")
	public void user_validates_Master_Qualification_flow_task_successfully_completed(
			io.cucumber.datatable.DataTable dataTable) {
		List<List<String>> data = dataTable.asLists();	
		
		String taskStatus = "In-Progress";
		for (int i = 0; i <= data.size()-1; i++) {
			String taskName = data.get(i).get(0);
			for (int j = 0; j <= 5 & (!taskStatus.equals("Completed")); j++) {
				flightDecksteps.userRefreshTaskPage();
				flightDecksteps.waitABit(2000);
				flightDecksteps.userValidateTaskName(taskName);
				taskStatus = flightDecksteps.userValidateTaskStatus(taskName);
				flightDecksteps.waitABit(2000);
			}
			taskStatus = "In-Progress";
			flightDecksteps.userValidateTaskIsInCompletedStatus(taskName);
		}
				
//		for (int i = 0; i <= data.size()-1; i++) {
//			String taskName = data.get(i).get(0);
//			flightDecksteps.userValidateTaskName(taskName);
//			flightDecksteps.userValidateTaskIsInCompletedStatus(taskName);
//		}
		flightDecksteps.waitABit(30000);
	}

	@Then("User validates Business_Qualification flow task successfully completed")
	public void user_validates_Business_Qualification_flow_task_successfully_completed(
			io.cucumber.datatable.DataTable dataTable) {
		List<List<String>> data = dataTable.asLists();
		
		String taskStatus = "In-Progress";
		for (int i = 0; i <= data.size()-1; i++) {
			String taskName = data.get(i).get(0);
			for (int j = 0; j <= 4 & (!taskStatus.equals("Completed")); j++) {
				flightDecksteps.userRefreshTaskPage();
				flightDecksteps.waitABit(2000);
				flightDecksteps.userValidateTaskName(taskName);
				taskStatus = flightDecksteps.userValidateTaskStatus(taskName);
				flightDecksteps.waitABit(2000);
			}
			taskStatus = "In-Progress";
			flightDecksteps.userValidateTaskIsInCompletedStatus(taskName);
		}
				
//		for (int i = 0; i <= data.size()-1; i++) {
//			String taskName = data.get(i).get(0);
//			flightDecksteps.userValidateTaskName(taskName);
//			flightDecksteps.userValidateTaskIsInCompletedStatus(taskName);
//		}
		flightDecksteps.waitABit(60000);
	}

	@Then("User validates CLC_Management flow task successfully completed")
	public void user_validates_CLC_Management_flow_task_successfully_completed(
			io.cucumber.datatable.DataTable dataTable) {
		List<List<String>> data = dataTable.asLists();
		
		String taskStatus = "In-Progress";
		for (int i = 0; i <= data.size()-1; i++) {
			String taskName = data.get(i).get(0);
			for (int j = 0; j <= 4 & (!taskStatus.equals("Completed")); j++) {
				flightDecksteps.userRefreshTaskPage();
				flightDecksteps.waitABit(2000);
				flightDecksteps.userValidateTaskName(taskName);
				taskStatus = flightDecksteps.userValidateTaskStatus(taskName);
				flightDecksteps.waitABit(2000);
			}
			taskStatus = "In-Progress";
			flightDecksteps.userValidateTaskIsInCompletedStatus(taskName);
		}		
		
//		for (int i = 0; i <= data.size()-1; i++) {
//			String taskName = data.get(i).get(0);
//			flightDecksteps.userValidateTaskName(taskName);
//			flightDecksteps.userValidateTaskIsInCompletedStatus(taskName);
//		}
		flightDecksteps.waitABit(35000);
	}

	@Then("User validates VLAN_Processing flow task successfully completed")
	public void user_validates_VLAN_Processing_flow_task_successfully_completed(
			io.cucumber.datatable.DataTable dataTable) {
		List<List<String>> data = dataTable.asLists();
		
		String taskStatus = "In-Progress";
		for (int i = 0; i <= data.size()-1; i++) {
			String taskName = data.get(i).get(0);
			for (int j = 0; j <= 4 & (!taskStatus.equals("Completed")); j++) {
				flightDecksteps.userRefreshTaskPage();
				flightDecksteps.waitABit(2000);
				flightDecksteps.userValidateTaskName(taskName);
				taskStatus = flightDecksteps.userValidateTaskStatus(taskName);
				flightDecksteps.waitABit(2000);
			}
			taskStatus = "In-Progress";
			flightDecksteps.userValidateTaskIsInCompletedStatus(taskName);
		}
				
//		for (int i = 0; i <= data.size()-1; i++) {
//			String taskName = data.get(i).get(0);
//			flightDecksteps.userValidateTaskName(taskName);
//			flightDecksteps.userValidateTaskIsInCompletedStatus(taskName);
//		}
		flightDecksteps.waitABit(30000);
	}
	
	@Then("User validates Create_UNI flow task successfully completed")
	public void user_validates_Create_UNI_flow_task_successfully_completed(
			io.cucumber.datatable.DataTable dataTable) {
		flightDecksteps.waitABit(270000);
		flightDecksteps.userRefreshTaskPage();
		List<List<String>> data = dataTable.asLists();
		
		String taskStatus = "In-Progress";
		for (int i = 0; i <= data.size()-1; i++) {
			String taskName = data.get(i).get(0);
			for (int j = 0; j <= 4 & (!taskStatus.equals("Completed")); j++) {
				flightDecksteps.userRefreshTaskPage();
				flightDecksteps.waitABit(2000);
				flightDecksteps.userValidateTaskName(taskName);
				taskStatus = flightDecksteps.userValidateTaskStatus(taskName);
				flightDecksteps.waitABit(2000);
			}
			taskStatus = "In-Progress";
			flightDecksteps.userValidateTaskIsInCompletedStatus(taskName);
		}
				
//		for (int i = 0; i <= data.size()-1; i++) {
//			String taskName = data.get(i).get(0);
//			flightDecksteps.userValidateTaskName(taskName);
//			flightDecksteps.userValidateTaskIsInCompletedStatus(taskName);
//		}
		flightDecksteps.waitABit(60000);
		
	}
	
	@Then("User validates FOC_Processing flow task successfully completed")
	public void user_validates_FOC_Processing_flow_task_successfully_completed(
			io.cucumber.datatable.DataTable dataTable) {
		List<List<String>> data = dataTable.asLists();
		String taskStatus = "In-Progress";
		//flightDecksteps.waitABit(30000);
		for (int i = 0; i <= data.size()-1; i++) {
			String taskName = data.get(i).get(0);
			for (int j = 0; j <= 4 & (!taskStatus.equals("Completed")); j++) {
				flightDecksteps.userRefreshTaskPage();
				flightDecksteps.waitABit(2000);
				flightDecksteps.userValidateTaskName(taskName);
				taskStatus = flightDecksteps.userValidateTaskStatus(taskName);
				flightDecksteps.waitABit(2000);
			}
			taskStatus = "In-Progress";
			flightDecksteps.userValidateTaskIsInCompletedStatus(taskName);
		}
		flightDecksteps.waitABit(40000);
	}

	@Then("User validates Dispatch flow task is in {string} status")
	public void user_validates_dispatch_flow_task_is_in_status(String status, io.cucumber.datatable.DataTable dataTable) {
		List<List<String>> data = dataTable.asLists();
		
//		String taskStatus = "In-Progress";
//		for (int i = 0; i <= data.size()-1; i++) {
//			String taskName = data.get(i).get(0);
//			for (int j = 0; j <= 4 & (!taskStatus.equals("Completed")); j++) {
//				flightDecksteps.userRefreshTaskPage();
//				flightDecksteps.waitABit(2000);
//				flightDecksteps.userValidateTaskName(taskName);
//				taskStatus = flightDecksteps.userValidateTaskStatus(taskName);
//				flightDecksteps.waitABit(2000);
//			}
//			flightDecksteps.userValidateTaskIsInCompletedStatus(taskName);
//		}
		
		for (int i = 0; i <= data.size()-1; i++) {
			String taskName = data.get(i).get(0);
			flightDecksteps.userValidateTaskName(taskName);
			flightDecksteps.userValidateTaskStatus(taskName,status);
		}
		flightDecksteps.waitABit(60000);
	}

	@Then("User validates RUID_Validation flow task successfully completed")
	public void user_validates_RUID_Validation_flow_task_successfully_completed(
			io.cucumber.datatable.DataTable dataTable) {
		List<List<String>> data = dataTable.asLists();
		
		String taskStatus = "In-Progress";
		for (int i = 0; i <= data.size()-1; i++) {
			String taskName = data.get(i).get(0);
			for (int j = 0; j <= 4 & (!taskStatus.equals("Completed")); j++) {
				flightDecksteps.userRefreshTaskPage();
				flightDecksteps.waitABit(2000);
				flightDecksteps.userValidateTaskName(taskName);
				taskStatus = flightDecksteps.userValidateTaskStatus(taskName);
				flightDecksteps.waitABit(2000);
			}
			taskStatus = "In-Progress";
			flightDecksteps.userValidateTaskIsInCompletedStatus(taskName);
		}
		
//		for (int i = 0; i <= data.size()-1; i++) {
//			String taskName = data.get(i).get(0);
//			flightDecksteps.userValidateTaskName(taskName);
//			flightDecksteps.userValidateTaskIsInCompletedStatus(taskName);
//		}
		flightDecksteps.waitABit(300000);
	}

	@Then("User validates Create_xVC flow task successfully completed")
	public void user_validates_Create_xVC_flow_task_successfully_completed(io.cucumber.datatable.DataTable dataTable) {
		List<List<String>> data = dataTable.asLists();
		
		String taskStatus = "In-Progress";
		for (int i = 0; i <= data.size()-1; i++) {
			String taskName = data.get(i).get(0);
			for (int j = 0; j <= 4 & (!taskStatus.equals("Completed")); j++) {
				flightDecksteps.userRefreshTaskPage();
				flightDecksteps.waitABit(2000);
				flightDecksteps.userValidateTaskName(taskName);
				taskStatus = flightDecksteps.userValidateTaskStatus(taskName);
				flightDecksteps.waitABit(2000);
			}
			taskStatus = "In-Progress";
			flightDecksteps.userValidateTaskIsInCompletedStatus(taskName);
		}
//		
//		for (int i = 0; i <= data.size()-1; i++) {
//			String taskName = data.get(i).get(0);
//			//System.out.println("Row-" + i + taskName);
//			flightDecksteps.userValidateTaskName(taskName);
//			flightDecksteps.userValidateTaskIsInCompletedStatus(taskName);
//		}
		flightDecksteps.waitABit(30000);
		
	}
	
	@Then("User validates Create_Ovc flow task successfully completed")
	public void user_validates_create_ovc_flow_task_successfully_completed(io.cucumber.datatable.DataTable dataTable) {
		List<List<String>> data = dataTable.asLists();
		
		String taskStatus = "In-Progress";
		for (int i = 0; i <= data.size()-1; i++) {
			String taskName = data.get(i).get(0);
			for (int j = 0; j <= 4 & (!taskStatus.equals("Completed")); j++) {
				flightDecksteps.userRefreshTaskPage();
				flightDecksteps.waitABit(2000);
				flightDecksteps.userValidateTaskName(taskName);
				taskStatus = flightDecksteps.userValidateTaskStatus(taskName);
				flightDecksteps.waitABit(2000);
			}
			taskStatus = "In-Progress";
			flightDecksteps.userValidateTaskIsInCompletedStatus(taskName);
		}
		
//		for (int i = 0; i <= data.size()-1; i++) {
//			String taskName = data.get(i).get(0);
//			flightDecksteps.userValidateTaskName(taskName);
//			flightDecksteps.userValidateTaskIsInCompletedStatus(taskName);
//		}
		flightDecksteps.waitABit(35000);
	}

	@Then("User validates Mesa_Test_OL flow task successfully completed")
	public void user_validates_Mesa_Test_OL_flow_task_successfully_completed(io.cucumber.datatable.DataTable dataTable) {
		List<List<String>> data = dataTable.asLists();
		
		String taskStatus = "In-Progress";
		for (int i = 0; i <= data.size()-1; i++) {
			String taskName = data.get(i).get(0);
			for (int j = 0; j <= 4 & (!taskStatus.equals("Completed")); j++) {
				flightDecksteps.userRefreshTaskPage();
				flightDecksteps.waitABit(2000);
				flightDecksteps.userValidateTaskName(taskName);
				taskStatus = flightDecksteps.userValidateTaskStatus(taskName);
				
				if(taskStatus.equals("Failed"))
				{
					flightDecksteps.User_Search_And_Open_Task(taskName);
					flightDecksteps.userOpenTasksMoreMenuOption();
					flightDecksteps.userSelfAssignTask();
					flightDecksteps.closeTaskPagePopupBar();
					flightDecksteps.completeTask();
					flightDecksteps.closeTaskPagePopupBar();
					flightDecksteps.closedOpenedTask();
					flightDecksteps.switchBackTSearchResultSection();			
					flightDecksteps.waitABit(10000);
				}
				flightDecksteps.waitABit(10000);
			}
			taskStatus = "In-Progress";
			flightDecksteps.userValidateTaskIsInCompletedStatus(taskName);
		}
		
//		for (int i = 0; i <= data.size()-1; i++) {
//			String taskName = data.get(i).get(0);
//			flightDecksteps.userValidateTaskName(taskName);
//			flightDecksteps.userValidateTaskIsInCompletedStatus(taskName);
//		}
		flightDecksteps.waitABit(35000);
	}
	
	
	@Then("User validates Send_Manual_PTA flow task is in {string} status")
	public void user_validates_send_manual_pta_flow_task_is_in_status(String status, io.cucumber.datatable.DataTable dataTable) {
		flightDecksteps.waitABit(40000);
		flightDecksteps.userRefreshTaskPage();
		List<List<String>> data = dataTable.asLists();
		for (int i = 0; i <= data.size()-1; i++) {
			String taskName = data.get(i).get(0);
			flightDecksteps.userValidateTaskName(taskName);
			flightDecksteps.userValidateTaskStatus(taskName,status);
		}
		flightDecksteps.waitABit(60000);
	}


	
	@Then("User validates Ease_Completion flow task successfully completed")
	public void user_validates_ease_completion_flow_task_successfully_completed(io.cucumber.datatable.DataTable dataTable) {
       List<List<String>> data = dataTable.asLists();
       flightDecksteps.waitABit(40000);

		String taskStatus = "In-Progress";
		for (int i = 0; i <= data.size()-1; i++) {
			String taskName = data.get(i).get(0);
			for (int j = 0; j <= 4 & (!taskStatus.equals("Completed")); j++) {
				flightDecksteps.userRefreshTaskPage();
				flightDecksteps.waitABit(2000);
				flightDecksteps.userValidateTaskName(taskName);
				taskStatus = flightDecksteps.userValidateTaskStatus(taskName);
				flightDecksteps.waitABit(2000);
			}
			taskStatus = "In-Progress";
			flightDecksteps.userValidateTaskIsInCompletedStatus(taskName);
		}

		flightDecksteps.waitABit(40000);
	}

	@Then("User validates Mob_Completion_Notification flow task successfully completed")
	public void user_validates_mob_completion_notification_flow_task_successfully_completed(io.cucumber.datatable.DataTable dataTable) {

List<List<String>> data = dataTable.asLists();
		
		String taskStatus = "In-Progress";
		for (int i = 0; i <= data.size()-1; i++) {
			String taskName = data.get(i).get(0);
			for (int j = 0; j <= 4 & (!taskStatus.equals("Completed")); j++) {
				flightDecksteps.userRefreshTaskPage();
				flightDecksteps.waitABit(2000);
				flightDecksteps.userValidateTaskName(taskName);
				taskStatus = flightDecksteps.userValidateTaskStatus(taskName);
				flightDecksteps.waitABit(2000);
			}
			taskStatus = "In-Progress";
			flightDecksteps.userValidateTaskIsInCompletedStatus(taskName);
		}
		
		flightDecksteps.waitABit(5000);
	}
	

	@When("User enters the install order Id and hit on search")
	public void user_enters_the_install_order_id_and_hit_on_search() {		
		String pon = BaseStep.readExcelData("EVC_COMBO_Supp", 1, 1);
		flightDecksteps.user_Search_Install_Order_Id(pon);
		flightDecksteps.selectPerPageTaskSize("10");
	}
	
@When("User enters the install {string} order Id and hit on search")
public void user_enters_the_install_order_id_and_hit_on_search(String orderType) {
   
	String pon="";
	if(orderType.equals("UNI"))
	{
		pon = BaseStep.readExcelData("UNI_Supp", 1, 1);
	}
	else if (orderType.equals("EVCCombo"))
	{
	 pon = BaseStep.readExcelData("EVC_COMBO_Supp", 1, 1);
	}
	else if (orderType.equals("OVCCombo"))
	{
		 pon = BaseStep.readExcelData("OVC_COMBO_Supp", 1, 1);
	}
	else if (orderType.equals("EVC"))
	{
		 pon = BaseStep.readExcelData("EVC_Supp", 1, 1);
	}
	else if (orderType.equals("OVC"))
	{
		pon = BaseStep.readExcelData("OVC_Supp", 1, 1);
	}
	flightDecksteps.user_Search_Install_Order_Id(pon);
	flightDecksteps.selectPerPageTaskSize("10");
}

	@Then("User validates {string} task moved to cancelled status")
	public void user_validates_task_moved_to_cancelled_status(String taskName) {

	}

	@When("User enters the supp version Order Id and hit on search")
	public void user_enters_the_supp_version_order_id_and_hit_on_search() {

		//String pon = BaseStep.readExcelData("UNI_Supp", 1, 1);
		flightDecksteps.userEnterSuppOrderId("pon");
		// flightDecksteps.user_Search_Install_Order_Id(pon);

	}

	@Then("User validates CO_Qualification_OL flow task successfully completed")
	public void user_validates_CO_Qualification_OL_flow_task_successfully_completed(
			io.cucumber.datatable.DataTable dataTable) {

		List<List<String>> data = dataTable.asLists();
		for (int i = 0; i <= data.size()-1; i++) {
			String taskName = data.get(i).get(0);
			System.out.println("Row-" + i + taskName);
			flightDecksteps.userValidateTaskName(taskName);
			flightDecksteps.userValidateTaskIsInCompletedStatus(taskName);
		}
		flightDecksteps.waitABit(30000);
	}

	@Then("User validates CO_Processor flow task successfully completed")
	public void user_validates_CO_Processor_flow_task_successfully_completed(
			io.cucumber.datatable.DataTable dataTable) {
		List<List<String>> data = dataTable.asLists();
		for (int i = 0; i <= data.size()-1; i++) {
			String taskName = data.get(i).get(0);
			System.out.println("Row-" + i + taskName);
			flightDecksteps.userValidateTaskName(taskName);
			flightDecksteps.userValidateTaskIsInCompletedStatus(taskName);
		}
		flightDecksteps.waitABit(30000);

		// document.querySelector("#print-section1 >
		// fdc-page-2").shadowRoot.querySelector("#dom-id-page-vertical-1").shadowRoot.querySelector("#dom-id-page-section-8").shadowRoot.querySelector("#dom-id-page-section-9-col-1").shadowRoot.querySelector("#dom-id-widget-dynamicTaskInstanceParamWidget").shadowRoot.querySelector("#cm3HotcutPayload
		// > div > div > div > div > div > div > div.tree-block > div > div >
		// div.ui-tree-row > div:nth-child(1) > span > input[type=checkbox]")
		// document.querySelector("#print-section1 >
		// fdc-page-2").shadowRoot.querySelector("#dom-id-page-vertical-1").shadowRoot.querySelector("#dom-id-page-section-8").shadowRoot.querySelector("#dom-id-page-section-9-col-1").shadowRoot.querySelector("#dom-id-widget-dynamicTaskInstanceParamWidget").shadowRoot.querySelector("#cm3HotcutPayload
		// > div > div > div > div > div > div > div.tree-labels > div.action-box >
		// fdc-dropdown-2").shadowRoot.querySelector("div.dropdown > div.dropdown-field
		// > div")
	}

	@Then("User validates CO_Message_Handler_OL flow task successfully completed")
	public void user_validates_CO_Message_Handler_OL_flow_task_successfully_completed(
			io.cucumber.datatable.DataTable dataTable) {
		List<List<String>> data = dataTable.asLists();
		for (int i = 0; i <= data.size()-1; i++) {
			String taskName = data.get(i).get(0);
			System.out.println("Row-" + i + taskName);
			flightDecksteps.userValidateTaskName(taskName);
			flightDecksteps.userValidateTaskIsInCompletedStatus(taskName);
		}
		flightDecksteps.waitABit(30000);
	}

	@Then("User validates Order_Acceptance_OL flow task successfully completed")
	public void user_validates_Order_Acceptance_OL_flow_task_successfully_completed(
			io.cucumber.datatable.DataTable dataTable) {
		List<List<String>> data = dataTable.asLists();
		for (int i = 0; i <= data.size()-1; i++) {
			String taskName = data.get(i).get(0);
			System.out.println("Row-" + i + taskName);
			flightDecksteps.userValidateTaskName(taskName);
			flightDecksteps.userValidateTaskIsInCompletedStatus(taskName);
		}
		flightDecksteps.waitABit(30000);
	}

	@Then("User validates Disconnect_Qualification_OL flow task successfully completed")
	public void user_validates_Disconnect_Qualification_OL_flow_task_successfully_completed(
			io.cucumber.datatable.DataTable dataTable) {
		List<List<String>> data = dataTable.asLists();
		for (int i = 0; i <= data.size()-1; i++) {
			String taskName = data.get(i).get(0);
			//System.out.println("Row-" + i + taskName);
			flightDecksteps.userValidateTaskName(taskName);
			flightDecksteps.userValidateTaskIsInCompletedStatus(taskName);
		}
		flightDecksteps.waitABit(30000);
	}

	@Then("User validates service successfully disconected in act")
	public void user_validates_service_successfully_disconected_in_act(io.cucumber.datatable.DataTable dataTable) {
		List<List<String>> data = dataTable.asLists();
		flightDecksteps.waitABit(150000);
		flightDecksteps.userRefreshTaskPage();
		for (int i = 0; i <= data.size()-1; i++) {
			String taskName = data.get(i).get(0);
			System.out.println("Row-" + i + taskName);
			flightDecksteps.userValidateTaskName(taskName);
			flightDecksteps.userValidateTaskIsInCompletedStatus(taskName);
		}
		flightDecksteps.waitABit(30000);
	}

	@Then("User open the {string} task")
	public void user_open_the_task(String task) {
		flightDecksteps.User_Search_And_Open_Task(task);
	}

	@Then("validates the changes in task")
	public void validates_the_changes_in_task() {

	}	

@When("user retrieve the service Id from task {string}")
public void user_retrieve_the_service_id_from_task(String task) {
	flightDecksteps.User_Search_And_Open_Task(task);
	flightDecksteps.retrieveOrder();
}

}
