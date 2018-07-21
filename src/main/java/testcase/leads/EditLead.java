package testcase.leads;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import lib.selenium.PreAndPostAnnotations;
import pages.lead.CreateLeadPage;
import pages.lead.MyHomePage;
import pages.lead.MyLeadsPage;
import pages.lead.ViewLeadPage;

public class EditLead extends PreAndPostAnnotations {
	
	@BeforeTest
	public void setVal()
	{
		testName = "EditLead";
		testDesc = "Edit a lead and do some update";
		testModule = "Leads Module";
		testAuthor = "Alexander";
		testCategory = "smoke";
		excelFileName = "EditLeadInput";
	}
	
	/*@DataProvider(name = "UAT", indices = {1})
	public Object[] edtLead()
	{
		Object[] edtLead = new Object[3];
		edtLead[0] = "10021";
		edtLead[1] = "10026";
		edtLead[2] = "10024";
		return edtLead;
	}*/

	@Test(description = "Editing the lead", groups = {"smoke"}, dataProvider = "Test")
	public void editLead(String strLeadID) throws InterruptedException {

		new MyHomePage(test, driver).clickLeads();
		
		new MyLeadsPage(test, driver).clickFindLead()
		.setLeadID(strLeadID)
		.clickSearchFindLead();
		Thread.sleep(3000);
		
		click(locateElement("link",strLeadID));
		
		new ViewLeadPage(test, driver).clickEdit();
		
		new CreateLeadPage(test, driver).selectIndustryByIndex(0)
		.clickCreateLead();
	}
}
