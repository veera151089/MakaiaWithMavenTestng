package pages.lead;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.aventstack.extentreports.ExtentTest;

import lib.selenium.WebDriverServiceImpl;

public class FindLeadsPage extends WebDriverServiceImpl{

	public FindLeadsPage(ExtentTest test, EventFiringWebDriver driver)
	{
		this.driver = driver;
		this.test = test;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "id")
	WebElement eleLeadID;
	
	public FindLeadsPage setLeadID(String strLeadId)
	{
		type(eleLeadID, strLeadId);
		return this;
	}
	
	@FindBy(name = "firstName")
	WebElement eleFirstName;
	
	public FindLeadsPage setFirstName(String strFirstName)
	{
		type(eleFirstName, strFirstName);
		return this;
	}
	
	@FindBy(name = "lastName")
	WebElement eleLastName;
	
	public FindLeadsPage setLastName(String strLastName)
	{
		type(eleLastName, strLastName);
		return this;
	}
	
	@FindBy(name = "companyName")
	WebElement eleCmpyName;
	
	public FindLeadsPage setCmpyName(String strCmpyName)
	{
		type(eleCmpyName, strCmpyName);
		return this;
	}
	
	@FindBy(linkText = "Find Leads")
	WebElement eleFindLead;
	
	public FindLeadsPage clickSearchFindLead()
	{
		click(eleFindLead);
		return this;
	}
}
