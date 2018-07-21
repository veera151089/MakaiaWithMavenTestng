package testcase.leads;

import org.testng.annotations.BeforeTest;
//import org.testng.annotations.DataProvider;
//import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import lib.selenium.PreAndPostAnnotations;
import pages.lead.CreateLeadPage;
import pages.lead.FindLeadsPage;
import pages.lead.MyHomePage;
import pages.lead.MyLeadsPage;
import pages.lead.ViewLeadPage;

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

		new MyHomePage(test, driver).clickLeads();
		
		new MyLeadsPage(test, driver).clickFindLead();
		Thread.sleep(3000);
		
		new FindLeadsPage(test, driver).setLeadID(strLeadID);
		
		new FindLeadsPage(test, driver).clickSearchFindLead();
		Thread.sleep(5000);
		
		click(locateElement("link",strLeadID));
		
		new ViewLeadPage(test, driver).clickDuplicateLead();
		
		new CreateLeadPage(test, driver).clickCreateLead();
		
		System.out.println("Lead "+ strLeadID +" Duplicated successfully");
	}
}
