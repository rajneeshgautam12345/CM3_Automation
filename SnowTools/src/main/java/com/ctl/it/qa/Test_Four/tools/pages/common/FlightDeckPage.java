package com.ctl.it.qa.Test_Four.tools.pages.common;

import java.util.List;

import com.ctl.it.qa.Test_Four.tools.pages.SfaPage;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class FlightDeckPage extends SfaPage {

	//Login
	@FindBy(xpath = "//input[@name='email']")
	public WebElementFacade username;
	@FindBy(xpath = "//input[@name='password']")
	public WebElementFacade password;
	@FindBy(xpath = "//button[@class='login_btn']")
	public WebElementFacade loginButton;
	@FindBy(xpath = "//div[@class='MessageBoxButtonSection']/button")
	public WebElementFacade okButton;
	
	//Menu
	@FindBy(xpath = "(//div[@class='panel-title'])[1]") // _searchId
	public WebElementFacade basicMenuButton;
	@FindBy(xpath = "//a[@title='Advanced Search']") // _search button
	public WebElementFacade advanceSearch;
	@FindBy(xpath = "//*[@role='tablist']//div[text()='Advanced Search ']") // _search button
	public WebElementFacade advanceSearchHeader;
	
	//Advance Search
	@FindBy(xpath = "(//*[@type='checkbox'])[2]")
	public WebElementFacade excludeSysTaskCheckbox;
	@FindBy(xpath = "//*[@id='General Search Parameters-defaultLayout11']/..") // _search button
	public WebElementFacade orderIDSearch;
	@FindBy(xpath = "//button[@color='primary']/span[text()=' Search ']/..") // _search button
	public WebElementFacade searchButton;
	@FindBy(xpath = "//label[text()='Source Task ID']/../../span[2]/select")
	public WebElementFacade sourceTaskIdDropdown;
	@FindBy(xpath = "//input[@id='General Search Parameters-defaultLayout0']")
	public WebElementFacade sourceTaskISearchTextBox;
	
	@FindBy(xpath = "//span[@title='Refresh List']")
	public WebElementFacade taskRefreshButton;
	
	//Autopilot Page//
	@FindBy(xpath = "//input[@name='username']")
	public WebElementFacade usernameAP;
	@FindBy(xpath = "//input[@name='password']")
	public WebElementFacade passwordAP;
	@FindBy(xpath = "//button[@type='submit']")
	public WebElementFacade sign_In;
	@FindBy(xpath = "//a[@href='/workflow_engine/manager']")
	public WebElementFacade jobManager;
	@FindBy(xpath = "//button[@data-test='column-swap-next-Job Name']/span[@class='p-button-icon p-c ri ri_arrow_empty_right']")
	public WebElementFacade nextColumnArrow;
	@FindBy(xpath = "//span[@id='pr_id_15']/input")
	public WebElementFacade jodDescriptionSearchText;
	@FindBy(xpath = "//table[@class='p-datatable-scrollable-body-table ph-grid-table']//tbody/tr")
	public List<WebElementFacade> orderRecords;
	
	//Task Searched Result Page
	@FindBy(xpath = "//span[text()='Per Page: ']/..//select")
	public WebElementFacade sizeWebelement;
	@FindBy(xpath = "//div[@col-id='TASK_NAME' and @role='gridcell']/div/span")
	public List<WebElementFacade> allTasks;
	@FindBy(xpath = "//div[@col-id='TASK_NAME' and @role='gridcell']/div/span/../../../div[3]/div")
	public List<WebElementFacade> allSourceTaskId;
	@FindBy(xpath = "//div[@aria-label='Next Page']")
	public WebElementFacade nextPageIcon;
	@FindBy(xpath = "//span[@ref='lbRecordCount']")
	public WebElementFacade totalRecords;
	@FindBy(xpath = "//div[contains(text(),'Search Results')]")
	public WebElementFacade searchResults;
	
	public String taskStatus1 = "//div[@col-id='TASK_NAME']/div/span[text()='";
	public String taskStatus2 = "']/../../../div[@col-id='TASK_STATUS']/div/span";
	public String taskName1 = "//*[text()='";
	public String taskName2 = "']/../../../div[@col-id='TASK_INSTANCE_ID']";
	public String getCorrIId="//*[text()='Colorless Metro Order Fulfillment']/../../../div[3]/div/span//a";
	
	@FindBy(xpath = "//div[@id='mat-tab-label-0-2']/div/button/div")
	public WebElementFacade closeOpenedTask;
	
	//Opened Task Page
	public String content1 = "#print-section1 > fdc-page-2";
	public String content2 = "#mat-tab-content-0-2 > div > div > app-page-content > sa-task-details-framework > fd-task-detail-micro > div:nth-child(4) > app-task-action > div > fdc-confirm";
	public String shadowRoot1 = "#dom-id-page-vertical-1";
	public String shadowRoot2 = "div.page-div > fdc-tab > fdc-actions-widget";
	
	public String shadowRootTaskDetails = "#dom-id-page-section-8";
	public String shadowRootTaskDetails2="#dom-id-page-section-9-col-1";
			
    public String shadowRoottaskDetailsWidget="#dom-id-widget-dynamicTaskInstanceParamWidget";
	public String shadowRoottaskDetailsAddressWidget="fdc-expansion-panel[id='Select Address Location'] > div > div > div > fdc-expansion-sub-panel > dynamic-data-table-widget";
	public String shadowRoottaskDetailsTable ="#dynamic-data-table";
	public String shadowRootPageSection1 = "#dom-id-page-section-1";
	public String shadowRootPageSection1Col2 = "#dom-id-page-section-1-col-2";
	public String shadowRootAssignmentInfoWidget ="#dom-id-widget-assignmentInfoWidget";
	public String shadowRootWorkgroupAssignedElement ="div[id='Assigned Workgroup']> div.value>span";
	public String shadowRoottaskDetailsAddressRadioButton ="div > div.p-datatable.p-component.p-datatable-resizable.p-datatable-scrollable > div.p-datatable-scrollable-wrapper > div > div.p-datatable-scrollable-body > table > tbody > tr:nth-child(2) > td:nth-child(1) > input[type=radio]";

	public String parentUserDropdown="(//*[@id='User'])[2]";
	public String rootElementUserDropDown="div.dropdown";
	public String parentSaveButton="//fdc-button[@id='Save']";
	public String rootElementSaveElement="button[title='Save']";
	public String parentRemarks="//fdc-input[@id='Remark']";
	public String rootElementRemarks="textarea[class='outline']";
	public String parentTaskPagePopupBar="//mat-tab-body[@id='mat-tab-content-0-2']//fdc-alert";
	public String rootElementTaskPagePopupBar="#btn-alert-close";
	
	public WebElementFacade getUniqueElementInPage() {
		return sourceTaskISearchTextBox;
	}
}
