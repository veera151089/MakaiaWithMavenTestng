package tests;

import org.testng.annotations.BeforeTest;
//import org.testng.annotations.DataProvider;
//import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import lib.selenium.PreAndPostAnnotations;

public class DeleteLead extends PreAndPostAnnotations {
	
	@BeforeTest
	public void setVal()
	{
		testName = "DeleteLead";
		testDesc = "Delete a lead";
		testModule = "Leads Module";
		testAuthor = "Alexander";
		testCategory = "smoke";
		excelFileName = "DeleteLeadInput";
	}

	@Test(description = "Delete the lead", dataProvider = "Test")
	public void deleteLead(String strLeadID) throws InterruptedException {

		click(locateElement("link","Leads"));
		
		click(locateElement("link","Find Leads"));
		
		type(locateElement("xpath","//input[@name='id']"), strLeadID);
		
		click(locateElement("xpath","//button[text()='Find Leads']"));
		Thread.sleep(5000);
		
		click(locateElement("link",strLeadID));
		
		click(locateElement("link","Delete"));
		
		System.out.println("Lead "+ strLeadID +" deleted successfully");
	}
}
