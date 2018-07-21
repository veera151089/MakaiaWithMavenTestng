package testcase.leads;

import org.testng.annotations.BeforeTest;
//import org.testng.annotations.DataProvider;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Set;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import lib.selenium.PreAndPostAnnotations;
import pages.lead.FindLeadWindowPage;
import pages.lead.FindLeadsPage;
import pages.lead.MergeLeadPage;
import pages.lead.MyHomePage;
import pages.lead.MyLeadsPage;

public class MergeLead extends PreAndPostAnnotations{

	@BeforeTest
	public void setVal()
	{
		testName = "MergeLead";
		testDesc = "Merge two leads";
		testModule = "Leads Module";
		testAuthor = "Alexander";
		testCategory = "smoke";
		excelFileName = "MergeLeadInput";
	}

	@Test(groups = {"sanity"}, dataProvider = "Test")
	public void mergeLead(String strFromLeadID, String strToLeadID) throws InterruptedException {
		
		new MyHomePage(test, driver).clickLeads();
		
		new MyLeadsPage(test, driver).clickMergeLead();

		new MergeLeadPage(test, driver).clickFromLead();

		new FindLeadWindowPage(test, driver).switchWindow(1);

		new FindLeadsPage(test, driver).setLeadID(strFromLeadID)
		.clickSearchFindLead();
		Thread.sleep(3000);

		//		Select an entry from the search result
		click(locateElement("link", strFromLeadID));

		//		Take the control back to the parent window
		new FindLeadWindowPage(test, driver).switchWindow(0);

		//		Click on the image to select To Lead
		new MergeLeadPage(test, driver).clickToLead();

		//		Switch the driver control to the second window
		new FindLeadWindowPage(test, driver).switchWindow(1);

		//		Enter the lead id to search
		new FindLeadsPage(test, driver).setLeadID(strToLeadID)
		.clickSearchFindLead();
		Thread.sleep(5000);

		//		Select an entry from the search result
		click(locateElement("link", strToLeadID));

		//		Take the control back to the parent window
		new FindLeadWindowPage(test, driver).switchWindow(0);

		//		Click on Merge button
		click(locateElement("link", "Merge"));

		//		Click OK in the confirmation alert
		acceptAlert();

		//		Print the error message that occurred, in case merge failed
		if (getElementsSize("class", "messages") > 0)
		{
			String errMsg = getText(locateElement("class", "messages"));
			System.out.println(errMsg);

			//		Validate the error message
			if (errMsg.contains("Cannot merge party"))
			{
				System.out.println("Expected error message is displayed");
			}
			else
			{
				System.out.println("Expected error message is NOT displayed");
			}
		}
	}
}
