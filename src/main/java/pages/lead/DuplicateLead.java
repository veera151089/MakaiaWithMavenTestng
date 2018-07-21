package pages.lead;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.aventstack.extentreports.ExtentTest;

import lib.selenium.WebDriverServiceImpl;

public class DuplicateLead extends WebDriverServiceImpl{

	public DuplicateLead(ExtentTest test, EventFiringWebDriver driver)
	{
		this.driver = driver;
		this.test = test;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "createLeadForm_companyName")
	WebElement eleCmpyName;
	
	@FindBy(id = "createLeadForm_firstName")
	WebElement eleFirstName;
	
	@FindBy(id = "createLeadForm_lastName")
	WebElement eleLastName;
	
	@FindBy(className = "smallSubmit")
	WebElement eleCreateLead;
	
	public DuplicateLead typeCmpy(String strCmpyName)
	{
		type(eleCmpyName, strCmpyName);
		return this;
	}
	
	public DuplicateLead typeFirstName(String strFirstName)
	{
		type(eleFirstName, strFirstName);
		return this;
	}
	
	public DuplicateLead typeLastName(String strLastName)
	{
		type(eleLastName, strLastName);
		return this;
	}
	
	public ViewLeadPage clickCreateLead()
	{
		click(eleCreateLead);
		return new ViewLeadPage(test, driver);
	}
}
