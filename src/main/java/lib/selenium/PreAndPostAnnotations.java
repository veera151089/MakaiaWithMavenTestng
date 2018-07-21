package lib.selenium;

//import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import data.reader.ReadExcelFile;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class PreAndPostAnnotations extends WebDriverServiceImpl {
	
	public String testName, testDesc, testModule, testAuthor, testCategory, excelFileName;

	@Parameters({"url","userName", "passWord"})
	@BeforeMethod(groups= {"smoke", "sanity"})
	public void beforeMethod(String URL, String uName, String pwd) {
		startTestModule(testModule);
		test.assignAuthor(testAuthor);
		test.assignCategory(testCategory);
		
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		webdriver = new ChromeDriver();

		driver = new EventFiringWebDriver(webdriver);
		driver.register(this);

		driver.manage().window().maximize();
		driver.get(URL);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		System.out.println("beforeMethod");
		
		type(locateElement("id", "username"), uName);

		type(locateElement("id", "password"), pwd);

		click(locateElement("class", "decorativeSubmit"));

		click(locateElement("link", "CRM/SFA"));
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("afterMethod");
		closeActiveBrowser();
	}

	@BeforeClass
	public void beforeClass() {
		startTestCase(testName, testDesc);
	}

	@AfterClass
	public void afterClass() {
		System.out.println("afterClass");
	}

	@BeforeTest
	public void beforeTest() {
		System.out.println("beforeTest");
	}

	@AfterTest
	public void afterTest() {
		System.out.println("afterTest");
	}

	@BeforeSuite
	public void beforeSuite() {
		startReport();
	}

	@AfterSuite
	public void afterSuite() {
		endResult();
	}
	
	@DataProvider(name = "Test"/*, indices = {0}*/)
	public Object[][] passTstData() throws IOException
	{
		ReadExcelFile readData = new ReadExcelFile();
		Object[][] arrData = readData.readExcel(excelFileName);
		return arrData;
	}

}
