package com.ctl.it.qa.Test_Four.tools.steps.eservices;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.time.Duration;
import java.time.LocalDate;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ctl.it.qa.staf.Page;
import com.ctl.it.qa.staf.Steps;

import net.serenitybdd.core.pages.WebElementFacade;

@SuppressWarnings("serial")
public class BaseStep extends Steps {
	public int count = 0;

	public void customClickableWait(WebElement element) {
		WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(500));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public void customVisibleWaitism(WebElementFacade element) {
		WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(150));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public void customVisibleWaitBAN(WebElementFacade element) {
		WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(150));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public void customwaitforpageloading(Page page) {
		page.withTimeoutOf(Duration.ofSeconds(800))
				.waitForElementsToDisappear(org.openqa.selenium.By.xpath("//div[@class='k-loading-image']"));
		System.out.println("Page Loading Circle is being Displayed");
		// waitABit(5000);
	}

	public void customwaitforpageloadingbilling(Page page) {
		page.withTimeoutOf(Duration.ofSeconds(800))
				.waitForElementsToDisappear(org.openqa.selenium.By.xpath("(//div[@class='popupBackground'])[1]"));
		System.out.println("Page Loading Circle is being Displayed");
		waitABit(5000);
	}

	public void customwaitforpageloadingipvpn(Page page) {
		page.withTimeoutOf(Duration.ofSeconds(300))
				.waitForElementsToDisappear(org.openqa.selenium.By.xpath("//div[@class='lds-ellipsis']"));
		System.out.println("Page Loading Circle is being Displayed");
		waitABit(5000);
	}

	public void customwaitforpageloadingism(Page page) {
		page.withTimeoutOf(Duration.ofSeconds(250))
				.waitForElementsToDisappear(org.openqa.selenium.By.xpath("(//div[contains(.,'Auto signing...')])[4]"));
		System.out.println("Page Loading Circle is being Displayed");
		waitABit(5000);
	}

	public void customwaitforpageloadingasri(Page page) {
		page.withTimeoutOf(Duration.ofSeconds(250)).waitForElementsToDisappear(
				org.openqa.selenium.By.xpath("//button[@class='btn btn-primary'][contains(.,'Loading...')]"));
		System.out.println("Page Loading Circle is being Displayed");
		waitABit(5000);
	}

	public WebElement shadowRootElement(String parent,String elementCss) {
	WebElement content = getDriver().findElement(By.xpath(parent));
	SearchContext shadowRoot1 = content.getShadowRoot();
	WebElement element = shadowRoot1.findElement(By.cssSelector(elementCss));
	return element;
	}

	public boolean isalertpresent() {
		boolean presentFlag = false;
		try {
			WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(30000));
			if (wait.until(ExpectedConditions.alertIsPresent()) == null) {
				System.out.println("Alert is Not Present");
			} else {
				Alert alert = getDriver().switchTo().alert();
				alert.accept();
				System.out.println("Alert was Present and Accepted");
				presentFlag = true;
			}
		} catch (NoAlertPresentException e) {
			e.printStackTrace();
		}
		return presentFlag;
	}

	public void customVisibilityWait(WebElementFacade element) {
		WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(120));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public void customwaitforpageloading() {
		waitABit(20000);
	}

	public void customwaitforpageloading2() {
		waitABit(2000);
	}

	public void customwaitforpageloading5() {
		waitABit(5000);
	}

	public void getserviceIconEnable(boolean isIconEnable, WebElementFacade iconElement) {
		while (isIconEnable && count < 10) {
			waitABit(20000);
			iconElement.click();
			System.out.println("clicked on hierachy");
			count++;
		}
	}

	public Boolean waitForSwiftProgressBar(Page page) {
		Boolean bflag;
		bflag = false;
		try {
			System.out.println("in try for  waitForSwiftProgressBar");
			int ncounter;
			ncounter = 0;
			do {
				waitABit(5000);
				if (page.isElementVisible(By.xpath("//*[@id='ajax-spinner']/div/div[1]"))) {
					System.out.println("Loading progress bar is dispayed");
					ncounter = ncounter + 1;
					waitABit(3000);
				} else {
					System.out.println("All good");
					bflag = true;
				}
			} while (bflag != true);
			System.out.println("out of try for  waitForSwiftProgressBar");
			System.out.println("Loading progress bar  counter is " + ncounter);
			bflag = false;
		} catch (Exception e) {
			System.out.println(e);
		}
		return bflag;
	}

	public static String readExcelData(String sheetName,int rowNo,int cellNo) {
		String value="";
		try
		{
		File folder = new File(System.getProperty("user.dir"));
		String filePath=folder+"\\src\\test\\resources\\testdata\\AutomationTest Data.xlsx";
		
		FileInputStream fis = new FileInputStream(filePath);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheet(sheetName);
		XSSFRow row1 = sheet.getRow(rowNo);
		XSSFCell cell = row1.getCell(cellNo);
		value = cell.getStringCellValue();
		//System.out.println("Value is :" + value);
		wb.close();
		
		}
		catch(IOException e)
		{
			e.printStackTrace();
			
		}
		
		 return value;
	}
	
	public static int readNumericExcelData(String sheetName,int rowNo,int cellNo) {
		int value=0;
		try
		{
		File folder = new File(System.getProperty("user.dir"));
		String filePath=folder+"\\src\\test\\resources\\testdata\\AutomationTest Data.xlsx";
			
		FileInputStream fis = new FileInputStream(filePath);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheet(sheetName);
		XSSFRow row1 = sheet.getRow(rowNo);
		XSSFCell cell = row1.getCell(cellNo);
		value = (int) cell.getNumericCellValue();
		//System.out.println("Value is :" + value);
		wb.close();
		
		}
		catch(IOException e)
		{
			e.printStackTrace();
			
		}
		
		 return value;
	}

	public static void writeDataToExcel(String filePath, String scenario, String smId, String scenarioStatus)
			throws IOException {

		// filePath="https://centurylink.sharepoint.com/:x:/r/sites/EDP-ServiceFulfillment/_layouts/15/Doc.aspx?sourcedoc=%7B6FD7B2FB-D499-497B-9B20-9407E03DA918%7D&file=Pre-%20Submit%20Orders.xlsx&action=default&mobileredirect=true";
		LocalDate date = java.time.LocalDate.now();
		String myEnv = System.getProperty("staf.environment.key");
		FileInputStream fis;
		try {
			fis = new FileInputStream(filePath);
			Workbook wb = WorkbookFactory.create(fis);
			Sheet sheet = wb.getSheetAt(0);
			int lastRow = sheet.getLastRowNum();
			System.out.println("last row=" + lastRow);

			for (int i = lastRow + 1; i <= lastRow + 1; i++) {
				Row row = sheet.getRow(i);
				// System.out.println("Row-"+row);
				if (row == null) {
					row = sheet.createRow(i);
				}
				Cell cell = row.getCell(0);
				if (cell == null) {
					cell = row.createCell(0);
				}
				cell.setCellValue(scenario);

				Cell cell1 = row.getCell(1);
				if (cell1 == null) {
					cell1 = row.createCell(1);
				}
				cell1.setCellValue(smId);

				Cell cell2 = row.getCell(2);
				if (cell2 == null) {
					cell2 = row.createCell(2);
				}
				cell2.setCellValue(scenarioStatus);

				Cell cell3 = row.getCell(3);
				if (cell3 == null) {
					cell3 = row.createCell(3);
				}
				String output = date.toString();
				// System.out.println("output--"+output);
				cell3.setCellValue(output);

				Cell cell4 = row.getCell(4);
				if (cell4 == null) {
					cell4 = row.createCell(4);
				}
				cell4.setCellValue(myEnv);

			}

			FileOutputStream outputStream = new FileOutputStream(filePath);
			wb.write(outputStream);
			outputStream.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
//	public static String WriteNumericExcelData(String sheetName,int rowNo,int cellNo,String cellValue) {
//		//String value="";
//		try
//		{
//		File folder = new File(System.getProperty("user.dir"));
//		String filePath=folder+"\\src\\test\\resources\\testdata\\AutomationTest Data.xlsx";
//			
//		FileInputStream fis = new FileInputStream(filePath);
//		Workbook wb = WorkbookFactory.create(fis);
//		
//		Sheet sheet = wb.getSheet(sheetName);
//		Row row1 = sheet.getRow(rowNo);
//		Cell cell = row1.getCell(cellNo);
//		
//		//String value=cell.setCellValue("aqbv");
//		
//		//value = (int) cell.getNumericCellValue();
//		//System.out.println("Value is :" + value);
//		wb.close();	
//		}
//		catch(IOException e)
//		{
//			e.printStackTrace();
//		}
//		
//		// return value;
//	}

	
	 public static String getPropertyValue(String filePath,String key)
	 {
	 	String value="";
	 	Properties ppt=new Properties();
	 	try
	 	{
	 		ppt.load(new FileInputStream(filePath));
	 		value=ppt.getProperty(key);
	 	}
	 	catch(Exception e){}
	 	return value;
	 }

	 
	 public static String setPropertyValue(String filePath,String key)
	  {
	   String value="";
	   Properties ppt=new Properties();
	   try
	   {  
	    ppt.load(new FileInputStream(filePath));
	    int count=Integer.parseInt(ppt.getProperty(key));
	    System.out.println("count value inside-"+count);
	    OutputStream output = null;
	                 
	         //int count=Integer.parseInt(ppt.getProperty(key));
	          count++;
	          System.out.println("count value inside++-"+count);
	          String abc=Integer.toString(count);
	         //String count=Integer.toString(cnt);
	      output = new FileOutputStream(filePath);

	     // set the properties value
	   //  count++;
	     ppt.setProperty(key,abc);
	     ppt.store(output, null);
	     
	     
	   }
	   catch(Exception e){}
	   return value;
	  }
	 
	 public void quitBrowser()
	 {
			getDriver().quit();
			waitABit(60000);
	 }
}
