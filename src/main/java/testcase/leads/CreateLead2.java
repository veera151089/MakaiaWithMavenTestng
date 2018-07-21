package testcase.leads;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import lib.selenium.PreAndPostAnnotations;
import pages.lead.CreateLeadPage;
import pages.lead.MyHomePage;
import pages.lead.MyLeadsPage;
import pages.lead.ViewLeadPage;

public class CreateLead2 extends PreAndPostAnnotations{
	
	public String leadId;
	
	@BeforeTest
	public void setVal()
	{
		testName = "CreateLead2";
		testDesc = "Create a new lead";
		testModule = "Leads Module";
		testAuthor = "Alexander";
		testCategory = "smoke";
		excelFileName = "CreateLeadInput";
	}

	@Test(description = "Creating Lead", groups= {"smoke"}, dataProvider = "Test")
	public void createLead(String cmpyName, String firstName, String lastName) {

		new MyHomePage(test, driver)
		.clickLeads();
		
		new MyLeadsPage(test, driver).clickCreateLead();
		
		new CreateLeadPage(test, driver)
		.typeCmpy(cmpyName)
		.typeFirstName(firstName)
		.typeLastName(lastName)
		.clickCreateLead();
		
		new ViewLeadPage(test, driver).verifyFirstName(firstName);
	}
	
	/*@DataProvider(name = "UAT", indices = {1})
	public Object[][] passUATData()
	{
		Object[][] arrData = new Object[3][3];
		arrData[0][0] = "Company 1";
		arrData[0][1] = "First Name 1";
		arrData[0][2] = "Last Name 1";
		
		arrData[1][0] = "Company 2";
		arrData[1][1] = "First Name 2";
		arrData[1][2] = "Last Name 2";
		
		arrData[2][0] = "Company 3";
		arrData[2][1] = "First Name 3";
		arrData[2][2] = "Last Name 3";
		
		return arrData;
	}*/
}
