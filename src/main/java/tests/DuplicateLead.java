package tests;

import org.testng.annotations.BeforeTest;
//import org.testng.annotations.DataProvider;
//import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import lib.selenium.PreAndPostAnnotations;

public class DuplicateLead extends PreAndPostAnnotations {
	
	@BeforeTest
	public void setVal()
	{
		testName = "DuplicateLead";
		testDesc = "Duplicate a lead";
		testModule = "Leads Module";
		testAuthor = "Alexander";
		testCategory = "smoke";
		excelFileName = "DuplicateLeadInput";
	}

	@Test(dependsOnMethods = {"tests.CreateLead.createLead"}, description = "Duplicate the lead", groups = {"smoke"}, 
			dataProvider = "Test")
	public void duplicateLead(String strLeadID) throws InterruptedException {
//		Variable declaration
//		String strLeadID = "10035";
		
		System.out.println("Newly created Lead ID is "+strLeadID);

		click(locateElement("link","Leads"));
		
		click(locateElement("link","Find Leads"));
		Thread.sleep(3000);
		
		type(locateElement("xpath","//input[@name='id']"), strLeadID);
		
		click(locateElement("xpath","//button[text()='Find Leads']"));
		Thread.sleep(5000);
		
		click(locateElement("link",strLeadID));
		
		click(locateElement("link","Duplicate Lead"));
		
//		Click on Create Lead button
		click(locateElement("class","smallSubmit"));

		System.out.println("Lead "+ strLeadID +" Duplicated successfully");
	}
}
