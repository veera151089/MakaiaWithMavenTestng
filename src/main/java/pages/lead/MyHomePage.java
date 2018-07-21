package pages.lead;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.aventstack.extentreports.ExtentTest;

import cucumber.api.java.en.Given;
import lib.selenium.WebDriverServiceImpl;

public class MyHomePage extends WebDriverServiceImpl{

	public MyHomePage(ExtentTest test, EventFiringWebDriver driver)
	{
		this.driver = driver;
		this.test = test;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText = "Leads")
	WebElement eleLeads;
	
	@Given("Click on Leads link")	//JUnit annotation to be used by runCucumberTests.java
	public MyLeadsPage clickLeads()
	{
		click(eleLeads);
		return new MyLeadsPage(test, driver);
	}
}
