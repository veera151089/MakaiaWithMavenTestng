package tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import lib.selenium.PreAndPostAnnotations;

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
		
		System.out.println("Newly created Lead ID is "+strLeadID);

		click(locateElement("link","Leads"));
		
		click(locateElement("link","Find Leads"));
		Thread.sleep(3000);
		
		type(locateElement("xpath","//input[@name='id']"), strLeadID);
		
		click(locateElement("xpath","//button[text()='Find Leads']"));
		Thread.sleep(5000);
		
		click(locateElement("link",strLeadID));
		
		click(locateElement("link","Edit"));
		
		selectDropDownUsingIndex(locateElement("id","updateLeadForm_industryEnumId"),1);
		
//		Click on Update button
		click(locateElement("class","smallSubmit"));

		System.out.println("Lead "+ strLeadID +" edited successfully");
	}

}
