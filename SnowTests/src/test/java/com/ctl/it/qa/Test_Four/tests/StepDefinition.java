package com.ctl.it.qa.Test_Four.tests;

import java.io.File;
import java.util.ArrayList;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.ctl.it.qa.Test_Four.tools.steps.ease.EaseSteps;
import com.ctl.it.qa.Test_Four.tools.steps.user.UserSteps;
import com.ctl.it.qa.staf.Page;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import net.serenitybdd.annotations.Steps;
import net.serenitybdd.core.Serenity;

public class StepDefinition {
	@Steps
	UserSteps userSteps;

	@Before
	public void beforeEveryScenario(Scenario scenario) {
		Serenity.setSessionVariable("file_type").to(scenario.getName());
		System.setProperty("ScenarioName", "");

		ArrayList<String> allTags = (ArrayList<String>) scenario.getSourceTagNames();
		String scenarioName22 = scenario.getName();
		System.out.println("Scenario Name-" + scenarioName22);
		for (int i = 0; i <= allTags.size() - 1; i++) {
			if (allTags.get(i).startsWith("@UNI_") || allTags.get(i).startsWith("@EVC_")
					|| allTags.get(i).startsWith("@OVC_") || allTags.get(i).startsWith("@EVCCombo_Install")) {
				String scenarioNameTag = allTags.get(i);
				System.out.println("Scenario Tag Name=" + scenarioNameTag);
				String scenarioName = allTags.get(i).substring(1);
				System.setProperty("ScenarioName", scenarioName);
				System.out.println(System.getProperty("ScenarioName"));
			}
		}

	}

	@After
	public void afterEveryScenario(Scenario scenario) {

		try {
			com.ctl.it.qa.staf.Steps.isInitialized = false;
			Page.isInitialized = false;
			scenario.log("PON Number used for this test case:" +  System.getProperty("PON.NO"));
			
//			String scenarioStatus = scenario.getStatus().toString();
			String userDir = System.getProperty("user.dir");

//			BaseStep.writeDataToExcel(userDir + "\\src\\test\\resources\\Test_Data.xlsx", scenarioName, smId,
//					scenarioStatus);
			// ServiceNowSteps.snowOrderId = "";
			// scenario.write("Boid Id used for this test case:" +boid );
			if (scenario.isFailed()) {
				byte[] screenshot = ((TakesScreenshot) userSteps.getDriver()).getScreenshotAs(OutputType.BYTES);
				scenario.attach(screenshot, "image/png", "screenshots");
				File srcFile = ((TakesScreenshot) userSteps.getDriver()).getScreenshotAs(OutputType.FILE);
				String scName = scenario.getName().substring(0, 5);
				FileUtils.copyFile(srcFile, new File(userDir + "\\target\\screenshot\\" + scName + ".png"));
			}
		} catch (Exception e) {
		} finally {
//			String scenarioName22 = scenario.getName();
//			String tcNumber=scenarioName22.substring(3, 5);
//			System.out.println("TestCase No-"+tcNumber);
//			int tcNo = Integer.parseInt((scenario.getName().substring(3, 5)));
//			System.out.println("Test Case No" + tcNo);
//			switch (tcNo) {
//			case 01:
//				BaseStep.setPropertyValue(AutomationConstants.CONFIG_PATH, "UNI_INSTALL");
//				break;
//
//			case 03:
//				BaseStep.setPropertyValue(AutomationConstants.CONFIG_PATH, "UNI_CHANGE");
//				break;
//
//			case 04:
//				BaseStep.setPropertyValue(AutomationConstants.CONFIG_PATH, "UNI_HOTCUTCHANGE");
//				break;
//
//			case 05:
//				BaseStep.setPropertyValue(AutomationConstants.CONFIG_PATH, "UNI_DISCO");
//				break;
//				
//			case 07:
//				BaseStep.setPropertyValue(AutomationConstants.CONFIG_PATH, "EVC_INSTALL");
//				break;
//				
////			case 09:
////				BaseStep.setPropertyValue(AutomationConstants.CONFIG_PATH, "EVC_COMBO");
////				break;
//
//			default:
//				System.out.println("No value");
//				break;
//			}

//			String currentURL = userSteps.getDriver().getCurrentUrl(); // get the current url of
//			String to[] = { "Rajneesh.k.gautam@lumen.com" };
//			try {
//				//SendMail.send("Rajneesh.k.gautam@lumen.com", to, "Digital Dialogue SNOW" + " - " + currentURL + " - ",
//				//		"");
//			} catch (MessagingException e) {
//				e.printStackTrace();
//			}

			userSteps.captureTestResult(scenario);
			userSteps.getDriver().close();
			userSteps.getDriver().quit();
		}
	}
}
