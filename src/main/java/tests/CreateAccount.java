package tests;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import lib.selenium.PreAndPostAnnotations;
//import lib.selenium.WebDriverServiceImpl;

public class CreateAccount extends PreAndPostAnnotations {

	public String accName = "TestAccount5";
	public String genAccID, genResID, genSplitID, genResName;

	@Test(dependsOnMethods= {"tests.CreateLead.createLead"}, alwaysRun = true)
	public void main() throws InterruptedException {

		//		Enter User name
		WebElement eleUserName = locateElement("id", "username");
		type(eleUserName, "DemoSalesManager");

		//		Enter Password
		WebElement elePassword = locateElement("id", "password");
		type(elePassword, "crmsfa");

		//		Click on login button
		WebElement eleLogin = locateElement("class", "decorativeSubmit");
		click(eleLogin);

		//		Click on link CRM/SFA
		WebElement eleCRM = locateElement("link", "CRM/SFA");
		click(eleCRM);

		//		Click on Accounts menu
		WebElement eleAccounts = locateElement("link", "Accounts");
		click(eleAccounts);

		//		Click on Create Account link
		WebElement eleCreateAcc = locateElement("link", "Create Account");
		click(eleCreateAcc);

		//		Enter Account name
		WebElement eleAccName = locateElement("id", "accountName");
		type(eleAccName, accName);

		//		Enter Currency
		WebElement eleCurrency = locateElement("id", "currencyUomId");
		type(eleCurrency, "INR - Indian Rupee");

		//		Select Industry
		WebElement eleIndustry = locateElement("name", "industryEnumId");
		type(eleIndustry, "Aerospace");

		//		Select Source
		WebElement eleSource = locateElement("id", "dataSourceId");
		type(eleSource, "Conference");

		//		Select Marketing Campaign 
		WebElement eleMktgCamp = locateElement("id", "marketingCampaignId");
		type(eleMktgCamp, "Automobile");

		//		Enter Primary number
		WebElement elePhone = locateElement("id", "primaryPhoneNumber");
		type(elePhone, "8939123367");

		//		Enter Mail ID
		WebElement eleMail = locateElement("id", "primaryEmail");
		type(eleMail, "alexanderb@gmail.com");

		//		Enter City
		WebElement eleCity = locateElement("id", "generalCity");
		type(eleCity, "Chennai");

		//		Select Country
		WebElement eleCountry = locateElement("id", "generalCountryGeoId");
		type(eleCountry, "India");

		//		Wait for the State to load
		Thread.sleep(3000);

		//		Select State
		WebElement eleState = locateElement("id", "generalStateProvinceGeoId");
		type(eleState, "TAMILNADU");

		//		Click on Create Account button
		WebElement eleBtnCreate = locateElement("class", "smallSubmit");
		click(eleBtnCreate);

		//		Wait for the Account id to be generated
		Thread.sleep(3000);

		//		Get the generated account name and save it to a variable
		WebElement eleAccID = locateElement("xpath", "//span[contains(text(),'"+ accName +"')]");
		genAccID = getText(eleAccID);
		genSplitID = genAccID.split("\\(")[1].split("\\)")[0];
		//genSplitID = genAccID.replaceAll("\\D", "");

		//		Click on Accounts menu
		//		WebElement eleAccounts = locateElement("link", "Accounts");
		//		click(eleAccounts);

		//		Click on Find Accounts link
		WebElement eleFindAcc = locateElement("link", "Find Accounts");
		click(eleFindAcc);

		//		Enter the Account ID to search
		WebElement eleSearchAccID = locateElement("xpath", "//input[@name='id']");
		type(eleSearchAccID, genSplitID);

		//		Enter the account name to search
		WebElement eleSearchAccName = locateElement("xpath", "(//input[@name='accountName'])[2]");
		type(eleSearchAccName, accName);

		//		Click on Find Accounts button
		WebElement eleBtnFindAcc = locateElement("xpath", "//button[text()='Find Accounts']");
		click(eleBtnFindAcc);

		//		Get the Account ID from the search result
		WebElement eleSearchRes = locateElement("link", genSplitID);
		genResID = getText(eleSearchRes);

		//		Compare whether the search result (Account ID) is same as of the searched value
		if (genSplitID.equalsIgnoreCase(genResID))
		{
			System.out.println("Searched Account ID "+ genResID +" is displayed");
		}
		else
		{
			System.err.println("Searched Account ID "+ genResID +" is NOT displayed");
		}
		
//		Get the Account Name from the search result
		WebElement eleSearchNameRes = locateElement("link", accName);
		genResName = getText(eleSearchNameRes);

		//		Compare whether the search result (Account ID) is same as of the searched value
		if (accName.equalsIgnoreCase(genResName))
		{
			System.out.println("Searched Account ID "+ genResName +" is displayed");
		}
		else
		{
			System.err.println("Searched Account ID "+ genResName +" is NOT displayed");
		}
		
//		Close the current Browser
		closeActiveBrowser();
	}

}
