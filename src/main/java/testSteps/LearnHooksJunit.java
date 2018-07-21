package testSteps;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import cucumber.api.Scenario;
import cucumber.api.java.*;
import lib.selenium.WebDriverServiceImpl;

//This class cannot be extended to any class
//This annotation class should be present inside the package where the implementation is available
public class LearnHooksJunit extends WebDriverServiceImpl {

	@Before
	public void beforeHookMethod(Scenario sc)
	{
		startReport();
		startTestCase(sc.getName(), sc.getId());
		
		startTestModule(sc.getName());
		test.assignAuthor("Alexander");
		test.assignCategory("smoke");
		
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		webdriver = new ChromeDriver();

		driver = new EventFiringWebDriver(webdriver);
		driver.register(this);

		driver.manage().window().maximize();
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		System.out.println("beforeMethod");
		
		type(locateElement("id", "username"), "DemoSalesManager");

		type(locateElement("id", "password"), "crmsfa");

		click(locateElement("class", "decorativeSubmit"));

		click(locateElement("link", "CRM/SFA"));
	}
	
	@After
	public void afterHookMethod(Scenario sc)
	{
		closeActiveBrowser();
		endResult();
	}
}
