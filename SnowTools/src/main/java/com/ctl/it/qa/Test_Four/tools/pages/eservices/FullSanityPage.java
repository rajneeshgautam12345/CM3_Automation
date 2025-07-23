package com.ctl.it.qa.Test_Four.tools.pages.eservices;

import com.ctl.it.qa.staf.Page;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class FullSanityPage extends Page {
	@FindBy(xpath = "//a[contains(@id,'searchBtn')]")
	public WebElementFacade btn_search;
	@FindBy(xpath = "//span[@class='html-tag'][contains(.,'<totalResources>')]")
	public WebElementFacade lnk_total_resources;

	@Override
	public WebElementFacade getUniqueElementInPage() {
		return btn_search;
	}
}
