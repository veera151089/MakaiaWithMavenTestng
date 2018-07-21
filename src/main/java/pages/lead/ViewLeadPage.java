package pages.lead;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.aventstack.extentreports.ExtentTest;

import cucumber.api.java.en.Then;
import lib.selenium.WebDriverServiceImpl;

public class ViewLeadPage extends WebDriverServiceImpl{

	public ViewLeadPage(ExtentTest test, EventFiringWebDriver driver)
	{
		this.driver = driver;
		this.test = test;
		PageFactory.initElements(driver, this);
	}
		
	@FindBy(id = "viewLead_firstName_sp")
	WebElement eleFirstName;
	
	public ViewLeadPage verifyFirstName(String strFirstName)
	{
		verifyExactText(eleFirstName, strFirstName);
		return this;
	}
	
	@FindBy(linkText = "Delete")
	WebElement eleDelete;
	
	public MyLeadsPage clickDelete()
	{
		click(eleDelete);
		return new MyLeadsPage(test,driver);
	}
	
	@FindBy(linkText = "Duplicate Lead")
	WebElement eleDupLead;
	
	public DuplicateLead clickDuplicateLead()
	{
		click(eleDupLead);
		return new DuplicateLead(test,driver);
	}
	
	@FindBy(linkText = "Edit")
	WebElement eleEditLead;
	
	public EditLeadPage clickEdit()
	{
		click(eleEditLead);
		return new EditLeadPage(test,driver);
	}
	
	@Then ("New Lead should be created")
	public void verifyName()
	{
		System.out.println("New lead created");
	}
}
