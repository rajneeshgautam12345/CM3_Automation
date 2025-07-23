package com.ctl.it.qa.Test_Four.tests;

import java.io.File;
import java.text.SimpleDateFormat;
//import java.io.FileInputStream;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.ResultSet;
//import java.sql.Statement;
//import java.time.LocalDate;
//import java.util.ArrayList;
//
//import org.apache.poi.ss.usermodel.Cell;
//import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.ss.usermodel.Sheet;
//import org.apache.poi.ss.usermodel.Workbook;
//import org.apache.poi.ss.usermodel.WorkbookFactory;
//import org.openqa.selenium.By;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

import com.ctl.it.qa.Test_Four.tools.steps.E2ESteps;

import io.restassured.RestAssured;
import io.restassured.response.Response;
//import com.ctl.it.qa.Test_Four.tools.steps.eservices.BaseStep;
//import com.ctl.it.qa.staf.xml.reader.IntDataContainer;
//
//import net.serenitybdd.core.Serenity;
import io.restassured.specification.RequestSpecification;



public class Testing extends E2ESteps {
	
	public static void main(String[] args)
	{
		
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy"); // Set Date
		Calendar cal = Calendar.getInstance();
		Calendar cal1 = Calendar.getInstance();
		cal.setTime(new Date());
		cal1.setTime(new Date());
		cal.add(Calendar.DATE, 15);
		cal1.add(Calendar.DATE, 0);
		String newDate = dateFormat.format(cal.getTime());
		String discDate = dateFormat.format(cal1.getTime());
		System.out.println("NewDate-"+newDate);
		System.out.println("DiscDate-"+discDate);
		
//		String orde="ATMOVE072144MCI";
//		String data=orde.substring(0, orde.length()-3);
//		System.out.println("Data-- "+data);
//		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy"); // Set Date
//		Calendar cal = Calendar.getInstance();
//		cal.setTime(new Date());
//		cal.add(Calendar.DATE, 15);
//		String newDate = dateFormat.format(cal.getTime());
//		System.out.println(dateFormat.format(cal.getTime()));
//		
		
//		LocalDate myObj = LocalDate.now(); // Create a date object
//	    System.out.println(myObj); // Display the current date
//	    String date=myObj.toString();
//	    String [] dates=date.split("-");
//	    System.out.println("String converted"+date); // Display the current date
//	    for(int i=0;i<=dates.length-1;i++)
//	    {
//	    	System.out.println("dates-"+i+"-"+dates[i]);
//	    }
//	    
//	    String[] fdate=(LocalDate.now().toString()).split("-");
////	    String.valueOf(Math.round(Math.random() * 100));
//	    
//	    for(int i=0;i<=fdate.length-1;i++)
//	    {
//	    	System.out.println("dates-"+i+"-"+fdate[i]);
//	    }
//	    
//	    
////	    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
//	    String dateww="20/07/2025";
//	    System.out.println("D-"+dateww.substring(0, 2));
//	    System.out.println("M-"+dateww.substring(3, 5));
//	    
//	    long M=Long.parseLong(dateww.substring(3, 5))+1;
//	    System.out.println("Mon-"+M);
//		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy"); // Set Date
//		Calendar cal = Calendar.getInstance();
//		cal.setTime(new Date());
//		//System.out.println(("Date--"+Calendar.DATE));
//		cal.add(Calendar.DATE, 15);
//		String newDate = dateFormat.format(cal.getTime());
//		System.out.println("New Date-"+newDate);
		
		
		
			// Specify the base URL to the RESTful web service
//			RestAssured.baseURI = "https://demoqa.com/BookStore/v1/Books";
//
//			// Get the RequestSpecification of the request that is to be sent
//			// to the server.
//			RequestSpecification httpRequest = RestAssured.given();
//
//			// Call RequestSpecification.get() method to get the response.
//			// Make sure you specify the resource name.
//			Response response = httpRequest.get("");
//
//			// Response.asString method will directly return the content of the body
//			// as String.
//			System.out.println("Response Body is =>  " + response.asString());
		}
//		String corrId1="AP-RGEVCJUN06-01-68359127-CM3-1-1170";
//		
////		String corrId1=getDiver().findElement(By.xpath("//*[text()='Colorless Metro Order Fulfillment']/../../../div[3]/div/span//a")).getText();
//		String []corrId=corrId1.split("CM3-1");
//		for(int i=0;i<corrId.length;i++)
//		{
//			System.out.println("CorrId " + i +"="+ corrId[i]);
//		}
//		String dir=System.getProperty("user.dir");
//		String path=userDir + "\\src\\test\\resources\\testdata\\IPJustificationForm.xlsx";
//		System.out.println(dir);
		//System.out.println(AutomationConstants.CONFIG_PATH);
		//String countValue=BaseStep.getPropertyValue(AutomationConstants.CONFIG_PATH, AutomationConstants.UNIQUE);
		//System.out.println("Count Value-"+AutomationConstants.UNIQUE);
		//System.out.println("Count Value after set-"+AutomationConstants.Set_UNIQUE);
//		String ce_vlan_ruid2 = BaseStep.readExcelData("OVC_Install", 12, 1);
//		 System.out.println("ce_vlan_ruid2-"+ce_vlan_ruid2);
//			
//		String pon = BaseStep.readExcelData("UNI_Install", 1, 1)+ AutomationConstants.randomNo;
//		 System.out.println("PON-"+pon);
		
//		Long tempNum = Math.round(Math.random() * 100);
//		String myOppName = String.valueOf(tempNum);
//		System.out.println("Count Value after set-"+myOppName);
	
//	    
//	    String[] fdate=(LocalDate.now().toString()).split("-");
//	    String.valueOf(Math.round(Math.random() * 100));
	    
//	    for(int i=0;i<=dates.length-1;i++)
//	    {
//	    	System.out.println("dates-"+i+"-"+dates[i]);
//	    }
//		
//		String evcNC = BaseStep.readExcelData("EVC_Install", 2, 1);
//		String evcsp_ruid1 = BaseStep.readExcelData("EVC_Install", 3, 1);
//		String ruid1 = BaseStep.readExcelData("EVC_Install", 4, 1);
//		String evcNCI_ruid1 = BaseStep.readExcelData("EVC_Install", 5, 1);
//
//		String vact_ruid1 = "N";
//		int intce_vlan_ruid1 = BaseStep.readNumericExcelData("EVC_Install", 6, 1);
//		String ce_vlan_ruid1=Integer.toString(intce_vlan_ruid1);
//		String los1_ruid1 = BaseStep.readExcelData("EVC_Install", 7, 1);
//		String evcBandwidth_ruid1 = BaseStep.readExcelData("EVC_Install", 8, 1);
//
//		String evcsp_ruid2 = BaseStep.readExcelData("EVC_Install", 9, 1);
//		String ruid2 = BaseStep.readExcelData("EVC_Install", 10, 1);
//		String evcNCI_ruid2 = BaseStep.readExcelData("EVC_Install", 11, 1);
//
//		String vact_ruid2 = "N";// need to modify
//		int intce_vlan_ruid2 = BaseStep.readNumericExcelData("EVC_Install", 12, 1);
//		String ce_vlan_ruid2=Integer.toString(intce_vlan_ruid2);
//		String los_ruid2 = BaseStep.readExcelData("EVC_Install", 13, 1);
//		String evcBandwidth_ruid2 = BaseStep.readExcelData("EVC_Install", 14, 1);
//		
//		System.out.println("evcNC="+evcNC);
//		System.out.println("evcsp_ruid1="+evcsp_ruid1);
//		System.out.println("ruid1="+ruid1);
//		System.out.println("evcNCI_ruid1="+evcNCI_ruid1);
//		System.out.println("ce_vlan_ruid1="+ce_vlan_ruid1);
//		
//		System.out.println("los1_ruid1="+los1_ruid1);
//		System.out.println("evcBandwidth_ruid1="+evcBandwidth_ruid1);
//		System.out.println("evcsp_ruid2="+evcsp_ruid2);
//		System.out.println("ruid2="+ruid2);
//		System.out.println("evcNCI_ruid2="+evcNCI_ruid2);
//		System.out.println("ce_vlan_ruid2="+ce_vlan_ruid2);
//		System.out.println("los_ruid2="+los_ruid2);
//		System.out.println("evcBandwidth_ruid2="+evcBandwidth_ruid2);
//		
		
//}

//	public void jdbcConnection()
//	{
//		
//		
//		String OrderID = "";
//		Serenity.setSessionVariable("OrderID").to("");
//		//String envData="TEST4";
//		IntDataContainer dataContainer = envData.getContainer("Database Connection");
//		
//		String userName = dataContainer.getFieldValue("userName");		
//		String pwd = dataContainer.getFieldValue("password");		
//		String url = dataContainer.getFieldValue("url");
//		
//		
//		 String sql1 = "select SUBSTR(sod.CUSTOMER_ORDER_ID,1,9),sos.SUPERCEDED_TIMESTAMP,sos.SO_STATUS_ENUM,sod.PRODUCT_NAME,sod.LAST_UPDATED,sod.BANDWIDTH,sod.A_ULTIMATE_CLLI,sod.TRANSPORT_TYPE,sod.Order_submitted_by " + 
//			       "from SERVICE_ORDER_DATA sod,SO_STATUS sos where sos.SERVICE_ORDER_DATA_PK = sod.SERVICE_ORDER_DATA_PK " + 
//			       "AND sod.PRODUCT_NAME = 'Dedicated Internet Access' AND sod.TRANSPORT_TYPE = 'On-Net' " +
//			       "AND sos.SO_STATUS_ENUM = 'Accepted' " +
//			       "And sos.SUPERCEDED_TIMESTAMP = TO_DATE('9999-12-31', 'YYYY-MM-DD') " +  
//			       "AND NOT EXISTS (select * from SERVICE_ORDER_DATA where CUSTOMER_ORDER_ID = sod.CUSTOMER_ORDER_ID " +
//			         "AND CUSTOMER_ORDER_VERSION = sod.CUSTOMER_ORDER_VERSION " +
//                 "AND PRODUCT_FAMILY = 'MANAGEDSERVICE') " +
//			       "AND NOT EXISTS (select * from RELATED_SERVICE_ORDER rso, SERVICE_ORDER_DATA sod2 " +
//                 "WHERE rso.SERVICE_ORDER_DATA_PK = sod2.SERVICE_ORDER_DATA_PK " + 
//                 "AND sod2.PRODUCT_FAMILY = 'HC_SDWAN_CPE' AND rso.RELATED_SO_SERVICE_ID = sod.SERVICE_ORDER_ID ) " +
//                 "AND (sod.Order_submitted_by = 'l3svc.smauto' or sod.Order_submitted_by = 'AC67376') " +
//               "order by sod.LAST_UPDATED DESC";
//  
// 
//	    String sql2 = "select SUBSTR(sod.CUSTOMER_ORDER_ID,1,9),sos.SUPERCEDED_TIMESTAMP,sos.SO_STATUS_ENUM,sod.PRODUCT_NAME,sod.LAST_UPDATED,sod.BANDWIDTH,sod.A_ULTIMATE_CLLI,sod.TRANSPORT_TYPE,sod.Order_submitted_by " + 
//			       "from SERVICE_ORDER_DATA sod,SO_STATUS sos where sos.SERVICE_ORDER_DATA_PK = sod.SERVICE_ORDER_DATA_PK " + 
//			       "AND sod.PRODUCT_NAME = 'Dedicated Internet Access' AND sod.TRANSPORT_TYPE = 'On-Net' " +
//			       "AND sos.SO_STATUS_ENUM = 'Complete' " +
//			       "And sos.SUPERCEDED_TIMESTAMP = TO_DATE('9999-12-31', 'YYYY-MM-DD') " +  
//			       "AND NOT EXISTS (select * from SERVICE_ORDER_DATA where CUSTOMER_ORDER_ID = sod.CUSTOMER_ORDER_ID " +
//			         "AND CUSTOMER_ORDER_VERSION = sod.CUSTOMER_ORDER_VERSION " +
//                 "AND PRODUCT_FAMILY = 'MANAGEDSERVICE') " +
//			       "AND NOT EXISTS (select * from RELATED_SERVICE_ORDER rso, SERVICE_ORDER_DATA sod2 " +
//                 "WHERE rso.SERVICE_ORDER_DATA_PK = sod2.SERVICE_ORDER_DATA_PK " + 
//                 "AND sod2.PRODUCT_FAMILY = 'HC_SDWAN_CPE' AND rso.RELATED_SO_SERVICE_ID = sod.SERVICE_ORDER_ID ) " +
//                 "AND (sod.Order_submitted_by = 'l3svc.smauto' or sod.Order_submitted_by = 'AC67376') "+
//               "order by sod.LAST_UPDATED DESC"; 
//
//
//		Connection con = null;
//		
//	
//		try {
//			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
//			
//			con = DriverManager.getConnection(url, userName, pwd);
//			System.out.println("Connecting Database...     --Successful");
//			
//			Statement st1 = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
//			Statement st2 = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
//			
//			ResultSet rs1 = st1.executeQuery(sql1);
//			ResultSet rs2 = st2.executeQuery(sql2);
//			System.out.println("Executing Queries...     --Successful");
//			
//		} catch(Exception exp) {
//			exp.printStackTrace();
//			//assertTrue("Database Method Failed", false);
//		}
//	}
		
//		if(!rs.next()) {
//		assertTrue("Order ID not found in DB.", false);
//	} else {
//		System.out.println(rs.getString(1));
//		OrderID = rs.getString(1);
//		Serenity.setSessionVariable("OrderID").to(OrderID);				
//	}
//	
//	rs.beforeFirst();
//	
//	boolean takeThis = false;
//	
//	while(rs1.next()) {
//		if(!rs2.next()) {
//			takeThis = true;
//		}
//		
//		rs2.beforeFirst();
//		
//		while(rs2.next()) {
//			if(rs1.getString(1).equals(rs2.getString(1))) {
//				takeThis = false;
//				break;
//			} else {
//				takeThis = true;
//			}
//		}
//		
//		if(takeThis == true) {
//			System.out.println(rs1.getString(1));
//			OrderID = rs1.getString(1);
//			Serenity.setSessionVariable("OrderID").to(OrderID);
//			break;
//		}
//	}
//	
//} catch(Exception exp) {
//	exp.printStackTrace();
//	assertTrue("Database Method Failed", false);
//}
//
//if (OrderID.equals("")) {
//	assertTrue("Order ID not found in DB.", false);
//} 
//
//
//		
//	}
		
		
	public static void main1(String[] args) {
		// aa
//		int j = 1;
		String a = "new";
		String b = "ggg";
		String introOfNinja = a + "\r\n" + b;
		System.out.println(introOfNinja);
//		ArrayList<String> strArrayList = new ArrayList<>();
//		while(j<4)
//		{
//		 strArrayList.add("test");
//		 j++;
//		}
//		System.out.println(strArrayList);
		// div[@aria-label='Pre- Submit Orders.xlsx']/div
		// div[@aria-label='Pre- Submit Orders.xlsx']/div/i[1]

		// button[@aria-label='More']/span/i[1]
		// button[@name='Download']/div

//		File folder = new File(System.getProperty("user.dir"));
//		//List the files on that folder
//		File[] listOfFiles = folder.listFiles();
//		boolean found = false;
//		File f = null;
//		     //Look for the file in the files
//		     // You should write smart REGEX according to the filename
//		     for (File listOfFile : listOfFiles) {
//		         if (listOfFile.isFile()) {
//		              String fileName = listOfFile.getName();
//		               System.out.println("File " + listOfFile.getName());
//		               if (fileName.matches("5MB.zip")) {
//		                   f = new File(fileName);
//		                   found = true;
//		                }
//		            }
//		        }
//		//Assert.assertTrue(found, "Downloaded document is not found");
//		f.deleteOnExit();
//		
//		
//		
//		
//		
//		String filePath="https://centurylink.sharepoint.com/:x:/r/sites/EDP-ServiceFulfillment/Shared%20Documents/General/Service%20Fulfillment-Order%20Management/Pre-%20Submit%20Orders.xlsx?d=w6fd7b2fbd499497b9b209407e03da918&csf=1&web=1&e=yUzElT";
//		LocalDate date=java.time.LocalDate.now();
//		String myEnv = "ENB";
//		FileInputStream fis;
//		try {
//			fis = new FileInputStream(filePath);
//		 Workbook wb=WorkbookFactory.create(fis);
//		Sheet sheet=wb.getSheetAt(0);
//		int lastRow=sheet.getLastRowNum();
//		System.out.println("last row="+lastRow);
//		
//		for(int i=lastRow+1;i<=lastRow+1;i++)
//		{
//		Row row = sheet.getRow(i);
//		System.out.println("Row-"+row);	
//		 if(row == null) {
//		       row = sheet.createRow(i);
//		    }
//		    Cell cell = row.getCell(0);     
//		    if(cell == null ) {
//		        cell=row.createCell(0);
//		    }
//		    cell.setCellValue("scenario");
//		    
//		    Cell cell1 = row.getCell(1);     
//		    if(cell1 == null ) {
//		        cell1=row.createCell(1);
//		    }
//		    cell1.setCellValue("smId");
//		    
//		    Cell cell2 = row.getCell(2);     
//		    if(cell2 == null ) {
//		        cell2=row.createCell(2);
//		    }
//		    cell2.setCellValue("scenarioStatus");
//		    
//		    Cell cell3 = row.getCell(3);     
//		    if(cell3 == null ) {
//		        cell3=row.createCell(3);
//		    }
//		    String output = date.toString();
//		    //System.out.println("output--"+output);  
//		    cell3.setCellValue(output);
//		    
//		    Cell cell4 = row.getCell(4);     
//		    if(cell4 == null ) {
//		        cell4=row.createCell(4);
//		    }
//		    cell4.setCellValue(myEnv);
//		    
//		}
//		
//		FileOutputStream outputStream = new FileOutputStream(filePath);
//		wb.write(outputStream);
//		outputStream.close();
//		
//		} 
//		catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}		
//
//
	}

	public void rename() {
		// Create an object of the File class
		// Replace the file path with path of the directory
		File file = new File("/home/mayur/Folder/GFG.java");

		// Create an object of the File class
		// Replace the file path with path of the directory
		File rename = new File("/home/mayur/Folder/HelloWorld.java");

		// store the return value of renameTo() method in
		// flag
		boolean flag = file.renameTo(rename);

		// if renameTo() return true then if block is
		// executed
		if (flag == true) {
			System.out.println("File Successfully Rename");
		}
		// if renameTo() return false then else block is
		// executed
		else {
			System.out.println("Operation Failed");
		}
	}

}
