package com.ctl.it.qa.Test_Four.tools.steps.eservices;

import com.ctl.it.qa.Test_Four.tools.pages.eservices.FullSanityPage;

import net.serenitybdd.annotations.Step;

@SuppressWarnings("serial")
public class FullSanitySteps extends BaseStep {
	FullSanityPage fullsanitypage;

	@Step
	public void i_am_checking_Mesh_in_specified_environment(String ENV) {
		if (ENV.contains("1")) {
			fullsanitypage.openAt(
					"https://sasi-test1.kubeodc.corp.intranet//inventory/v1/mesh/paths?aend=LTTNCOML&product=ETHERNET&numpaths=1&bandwidth=1000&diversity=No&interface=Optical&protection=No&lowLatency=No&dwdmOnly=No");
		}
		if (ENV.contains("2")) {
			fullsanitypage.openAt(
					"https://sasi-test2.kubeodc.corp.intranet//inventory/v1/mesh/paths?aend=LTTNCOML&product=ETHERNET&numpaths=1&bandwidth=1000&diversity=No&interface=Optical&protection=No&lowLatency=No&dwdmOnly=No");
		}
		if (ENV.contains("4")) {
			fullsanitypage.openAt(
					"https://sasi-test4.kubeodc.corp.intranet//inventory/v1/mesh/paths?aend=LTTNCOML&product=ETHERNET&numpaths=1&bandwidth=1000&diversity=No&interface=Optical&protection=No&lowLatency=No&dwdmOnly=No");
		}
		WaitForPageToLoad(60);
		System.out.println("Mesh Page Launched");
		String url = getDriver().getCurrentUrl();
		System.out.println("Current URL : " + url);
		fullsanitypage.maximize();
		WaitForPageToLoad(10); // wait for auto log in
	}

	@Step
	public void i_am_checking_SASI_in_specified_environment(String ENV) {
	}

	@Step
	public void i_am_checking_ACT_in_specified_environment(String ENV) {
	}
}
