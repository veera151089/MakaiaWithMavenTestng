package testSteps;

/*import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import cucumber.api.java.en.*;*/
//import cucumber.api.java.en.Given;

public class LoginSteps {
	
	/*public static WebDriver driver;

	@Given("Open browser")
	public void openBrowser()
	{
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	@And("Launch LeafTaps URL as (.*)")
	public void launchURL(String URL)
	{
		driver.get(URL);
	}
	
	@And("Enter username as (.*)")
	public void enterUser(String uName)
	{
		driver.findElement(By.id("username")).sendKeys(uName);
	}
	
	@And("Enter password as (.*)")
	public void enterPassword(String pass)
	{
		driver.findElement(By.id("password")).sendKeys(pass);
	}
	
	@When ("Click on login button")
	public void clickLogin() throws InterruptedException
	{
		driver.findElement(By.className("decorativeSubmit")).click();
		Thread.sleep(2000);
	}
	
	@And ("Click on CRM\\/SFA link")
	public void clickCRM() throws InterruptedException
	{
		driver.findElement(By.linkText("CRM/SFA")).click();
		Thread.sleep(4000);
	}
	
	@Then ("MyHome page should be displayed")
	public void loginSuccess()
	{
		System.out.println("Login successful");
	}
	
	@Then ("Login should fail")
	public void loginFailure()
	{
		System.out.println("Login Unsuccessful");
	}*/
	
	/*//Create Lead steps are below
	@Given("Click on Leads link")
	public void clickLead()
	{
		driver.findElement(By.linkText("Leads")).click();
	}
	
	@And ("Click on Create Lead link")
	public void clickCreateLead()
	{
		driver.findElement(By.linkText("Create Lead")).click();
	}
	
	@And ("Enter company name as (.*)")
	public void setCmpyName(String cmpyName)
	{
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys(cmpyName);
	}
	
	@And ("Enter first name as (.*)")
	public void setFirstName(String firstName)
	{
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys(firstName);
	}
	
	@And ("Enter Last name as (.*)")
	public void setLastName(String lastName)
	{
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys(lastName);
	}
	
	@When ("Click on Create Lead button")
	public void clickCreate()
	{
		driver.findElement(By.className("smallSubmit")).click();
	}
	
	@Then ("New Lead should be created")
	public void verifyLead()
	{
		System.out.println(driver.findElement(By.id("viewLead_firstName_sp")).getText());
	}*/
}
