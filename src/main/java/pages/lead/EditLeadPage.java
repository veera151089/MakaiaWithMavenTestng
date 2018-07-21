package pages.lead;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.aventstack.extentreports.ExtentTest;

import lib.selenium.WebDriverServiceImpl;

public class EditLeadPage extends WebDriverServiceImpl{

	public EditLeadPage(ExtentTest test, EventFiringWebDriver driver)
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
	WebElement eleUpdate;
	
	public EditLeadPage typeCmpy(String strCmpyName)
	{
		type(eleCmpyName, strCmpyName);
		return this;
	}
	
	public EditLeadPage typeFirstName(String strFirstName)
	{
		type(eleFirstName, strFirstName);
		return this;
	}
	
	public EditLeadPage typeLastName(String strLastName)
	{
		type(eleLastName, strLastName);
		return this;
	}
	
	public ViewLeadPage clickUpdate()
	{
		click(eleUpdate);
		return new ViewLeadPage(test, driver);
	}
}
