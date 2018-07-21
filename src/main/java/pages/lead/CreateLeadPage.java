package pages.lead;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.ExtentTest;

import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import lib.selenium.WebDriverServiceImpl;

public class CreateLeadPage extends WebDriverServiceImpl{

	public CreateLeadPage(ExtentTest test, EventFiringWebDriver driver)
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
	
	@FindBy(id = "updateLeadForm_industryEnumId")
	WebElement eleIndustry;
	
	@FindBy(className = "smallSubmit")
	WebElement eleCreateLead;
	
	@And ("Enter company name as (.*)")
	public CreateLeadPage typeCmpy(String strCmpyName)
	{
		type(eleCmpyName, strCmpyName);
		return this;
	}
	
	@And ("Enter first name as (.*)")
	public CreateLeadPage typeFirstName(String strFirstName)
	{
		type(eleFirstName, strFirstName);
		return this;
	}
	
	@And ("Enter Last name as (.*)")
	public CreateLeadPage typeLastName(String strLastName)
	{
		type(eleLastName, strLastName);
		return this;
	}
	
	public CreateLeadPage selectIndustryByIndex(int indexVal)
	{
		Select objSelect = new Select(eleIndustry);
		objSelect.selectByIndex(indexVal);
		return this;
	}
	
	@When ("Click on Create Lead button")
	public ViewLeadPage clickCreateLead()
	{
		click(eleCreateLead);
		return new ViewLeadPage(test, driver);
	}
}
