package com.ctl.it.qa.Test_Four.tests;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import com.ctl.it.qa.staf.Environment;
import com.ctl.it.qa.staf.HtmlReport;
import com.ctl.it.qa.staf.STAFEnvironment;
import com.ctl.it.qa.staf.Steps;
import com.ctl.it.qa.staf.TestEnvironment;
import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;

@TestEnvironment(Environment.TEST1) // Test Environment on which execution is to happen is provided
@RunWith(CucumberWithSerenity.class)
@CucumberOptions(plugin = { "pretty", "html:target/cucumber.html", "html:target/site/serenity/index.html",
		"json:target/jira-xray-data.json", "json:targets/sanity.json", "json:target/cucumber-report.json",
		"usage:target/site/serenity/cucumber-usage.json" }, features = "src/test/resources/features", tags = "@CNB")

public class CukesTest2 {

	/*
	 * COMMENTS ARE ADDED TO BELOW MENTIONED CLA-SSES IN TESTS PROJCTS FOR BETTER
	 * |fd UNDERSTANDING OF STAF
	 * /SampleTests/src/test/java/com/ctl/it/qa/sample/tests/CukesTest.java
	 * /SampleTests/src/test/java/com/ctl/it/qa/sample/tests/steps/centurylink/
	 * SmallBusinessStepDefinition.java
	 * /SampleTests/src/test/java/com/ctl/it/qa/sample/tests/steps/user/
	 * UserStepDefinition.java
	 */
	/*
	 * COMMENTS ARE ADDED TO BELOW MENTIONED CLASSES IN TOOLS PROJECTS FOR BETTER
	 * UNDERSTANDING OF STAF
	 * /SampleTools/src/main/java/com/ctl/it/qa/sample/tools/steps/user/UserSteps.
	 * java
	 * /SampleTools/src/main/java/com/ctl/it/qa/sample/tools/steps/smallbusiness/
	 * SmallBusinessSteps.java
	 * /SampleTools/src/main/java/com/ctl/it/qa/sample/tools/pages/common/HomePage.
	 * java
	 */

	@BeforeClass
	public static void setEnvironment() {
		STAFEnvironment.registerEnvironment(CukesTest2.class);
		Steps.initialize("Test_Four.xml");// Data input file name (present in SampleTools/src/test/resources) is provided
		// Steps.initialize("E2E.xml"); // Data input file name for DIA BAU

	}

	@AfterClass
	public static void clearEnvironment() {
//		String text="";
//		for(int i=0;i<=StepDefinition.strScenarioName.size()-1;i++)
//		{
//			
//		System.out.println(StepDefinition.strScenarioName.get(i).toString() +"-"+ StepDefinition.strSMID.get(i).toString());
//	    text= text+"\r\n"+StepDefinition.strScenarioName.get(i).toString()+"-"+StepDefinition.strSMID.get(i).toString();
//		}
//		String to[] = { "Rajneesh.k.gautam@lumen.com" };
//		try {
//			SendMail.send2("Rajneesh.k.gautam@lumen.com", to, "Digital Dialogue SNOW" + " - " + " - ",
//					text);
//		} catch (MessagingException e) {
//			e.printStackTrace();
//		}

		HtmlReport.generate();
	}
}