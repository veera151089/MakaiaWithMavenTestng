package tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import lib.selenium.PreAndPostAnnotations;

public class CreateLead extends PreAndPostAnnotations{
	
	public String leadId;
	
	@BeforeTest
	public void setVal()
	{
		testName = "CreateLead";
		testDesc = "Create a new lead";
		testModule = "Leads Module";
		testAuthor = "Alexander";
		testCategory = "smoke";
		excelFileName = "CreateLeadInput";
	}

	@Test(description = "Creating Lead", groups= {"smoke"}, dataProvider = "Test")
	public void createLead(String cmpyName, String firstName, String lastName) {

		click(locateElement("link","Leads"));

		click(locateElement("link","Create Lead"));

		type(locateElement("id", "createLeadForm_companyName"),cmpyName);

		type(locateElement("id", "createLeadForm_firstName"),firstName);

		type(locateElement("id", "createLeadForm_lastName"),lastName);

		click(locateElement("class", "smallSubmit"));

		String message = getText(locateElement("id", "viewLead_companyName_sp"));
		System.out.println(message);
		
		leadId = message.replaceAll("\\D", "");
		
		verifyPartialText(locateElement("id", "viewLead_companyName_sp"), leadId);
		
//		closeActiveBrowser();
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
