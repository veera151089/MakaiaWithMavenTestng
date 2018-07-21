package tests;

import org.testng.annotations.BeforeTest;
//import org.testng.annotations.DataProvider;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Set;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import lib.selenium.PreAndPostAnnotations;

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
		//		Variable declaration
		//		String strFromLeadID = "10085";

		click(locateElement("link","Leads"));

		click(locateElement("link","Merge Leads"));

		//		Click on the image to select From Lead
		click(locateElement("xpath", "(//img[@alt='Lookup'])[1]"));

		//		Switch the driver control to the second window
		switchToWindow(1);

		//		Enter the lead id to search
		type(locateElement("name", "id"), strFromLeadID);

		//		Click on Find Leads button
		click(locateElement("xpath", "//button[text()='Find Leads']"));

		Thread.sleep(5000);

		//		Select an entry from the search result
		click(locateElement("link", strFromLeadID));

		//		Take the control back to the parent window
		switchToWindow(0);

		//		Click on the image to select To Lead
		click(locateElement("xpath", "(//img[@alt='Lookup'])[2]"));

		//		Switch the driver control to the second window
		switchToWindow(1);

		//		Enter the lead id to search
		type(locateElement("name", "id"), strToLeadID);

		//		Click on Find Leads button
		click(locateElement("xpath", "//button[text()='Find Leads']"));

		Thread.sleep(5000);

		//		Select an entry from the search result
		click(locateElement("link", strToLeadID));

		//		Take the control back to the parent window
		switchToWindow(0);

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
