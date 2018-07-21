package pages.lead;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.aventstack.extentreports.ExtentTest;

import lib.selenium.WebDriverServiceImpl;

public class FindLeadWindowPage extends WebDriverServiceImpl{

	public FindLeadWindowPage(ExtentTest test, EventFiringWebDriver driver)
	{
		this.driver = driver;
		this.test = test;
		PageFactory.initElements(driver, this);
	}
	
	public FindLeadsPage switchWindow(int index)
	{
		Set<String> allWin = driver.getWindowHandles();
		List<String> listAllWin = new ArrayList<String>();
		listAllWin.addAll(allWin);
		driver.switchTo().window(listAllWin.get(index));
		return new FindLeadsPage(test, driver);
	}
}
