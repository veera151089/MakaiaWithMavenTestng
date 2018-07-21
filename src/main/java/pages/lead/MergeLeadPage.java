package pages.lead;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.aventstack.extentreports.ExtentTest;

import lib.selenium.WebDriverServiceImpl;

public class MergeLeadPage extends WebDriverServiceImpl{

	public MergeLeadPage(ExtentTest test, EventFiringWebDriver driver)
	{
		this.driver = driver;
		this.test = test;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "(//img[@alt='Lookup'])[1]")
	WebElement eleFromLead;
	
	public FindLeadWindowPage clickFromLead()
	{
		click(eleFromLead);
		return new FindLeadWindowPage(test, driver);
	}
	
	@FindBy(xpath = "(//img[@alt='Lookup'])[2]")
	WebElement eleToLead;
	
	public FindLeadWindowPage clickToLead()
	{
		click(eleToLead);
		return new FindLeadWindowPage(test, driver);
	}
}
