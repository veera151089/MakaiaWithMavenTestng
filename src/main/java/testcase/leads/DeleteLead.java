package testcase.leads;

import org.testng.annotations.BeforeTest;
//import org.testng.annotations.DataProvider;
//import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import lib.selenium.PreAndPostAnnotations;
import pages.lead.FindLeadsPage;
import pages.lead.MyHomePage;
import pages.lead.MyLeadsPage;
import pages.lead.ViewLeadPage;

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

		new MyHomePage(test, driver).clickLeads();
		
		new MyLeadsPage(test, driver).clickFindLead();
		
		new FindLeadsPage(test, driver).setLeadID(strLeadID);
		
		new FindLeadsPage(test, driver).clickSearchFindLead();
		Thread.sleep(3000);
		
		click(locateElement("link",strLeadID));
		
		new ViewLeadPage(test, driver).clickDelete();
		
		System.out.println("Lead "+ strLeadID +" deleted successfully");
	}
}
