package pages.lead;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.aventstack.extentreports.ExtentTest;

import cucumber.api.java.en.And;
import lib.selenium.WebDriverServiceImpl;

public class MyLeadsPage extends WebDriverServiceImpl{

	public MyLeadsPage(ExtentTest test, EventFiringWebDriver driver)
	{
		this.driver = driver;
		this.test = test;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText = "Create Lead")
	WebElement eleCreateLead;
	
	@And ("Click on Create Lead link")
	public CreateLeadPage clickCreateLead()
	{
		click(eleCreateLead);
		return new CreateLeadPage(test, driver);
	}
	
	@FindBy(linkText = "Find Leads")
	WebElement eleFindLeads;
	
	public FindLeadsPage clickFindLead()
	{
		click(eleFindLeads);
		return new FindLeadsPage(test,driver);
	}
	
	@FindBy(linkText = "Merge Leads")
	WebElement eleMergeLeads;
	
	public MergeLeadPage clickMergeLead()
	{
		click(eleMergeLeads);
		return new MergeLeadPage(test,driver);
	}
}
