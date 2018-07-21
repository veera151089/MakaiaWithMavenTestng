package tests;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.omg.PortableServer.THREAD_POLICY_ID;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class FixMyBugs {

	@Test
	public void main() throws InterruptedException {

		// launch the browser
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		ChromeOptions options =  new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.myntra.com/");
		

		// Mouse Over on Men
		Actions builder = new Actions(driver);
		builder.moveToElement(driver.findElementByLinkText("Men")).perform();

		// Click on Jackets
		driver.findElementByXPath("//a[text()='Jackets']").click();
		Thread.sleep(3000);
		driver.getKeyboard().sendKeys(Keys.DOWN);
		driver.getKeyboard().sendKeys(Keys.DOWN);
		driver.findElementByClassName("results-showmore").click();
		driver.getKeyboard().sendKeys(Keys.CONTROL, Keys.HOME);
		

WebElement pr = driver.findElementByXPath("//span[@class='horizontal-filters-sub']");
//WebDriverWait wait = new WebDriverWait(driver, 30);
//wait.until(ExpectedConditions.textToBePresentInElementValue( pr, "6719"));
		// Find the count of Jackets
		String leftCount = 
				driver.findElementByXPath("//input[@value='Jackets']/following-sibling::span")
				.getText()
				.replaceAll("\\D", "");
		System.out.println(leftCount);


		// Click on Jackets and confirm the count is same
		driver.findElementByXPath("//label[text()='Jackets']").click();

		// Wait for some time
		Thread.sleep(5000);

		/*driver.getKeyboard().sendKeys(Keys.DOWN);
		driver.getKeyboard().sendKeys(Keys.DOWN);
		driver.getKeyboard().sendKeys(Keys.CONTROL, Keys.HOME);
		// Check the count
*/		
		driver.findElementByClassName("results-showmore").click();
		String rightCount = 
				driver.findElementByXPath("//h1[text()='Mens Jackets']/following-sibling::span")
				.getText()
				.replaceAll("\\D", "");
		System.out.println(rightCount);

		// If both count matches, say success
		if(leftCount.equals(rightCount)) {
			System.out.println("The count matches on either case");
		}else {
			System.err.println("The count does not match");
		}

		// Click on Offers
		WebElement findElementByXPath = driver.findElementByXPath("//h4[text()='Offers']");
		builder.click(findElementByXPath).perform();
		

		// Find the costliest Jacket
		List<WebElement> productsPrice = driver.findElementsByXPath("//span[@class='product-discountedPrice']");
		List<String> onlyPrice = new ArrayList<String>();

		for (WebElement productPrice : productsPrice) {
			onlyPrice.add(productPrice.getText().replaceAll("\\D", ""));
		}

		// Sort them 
		/*String max = Collections.max(onlyPrice);*/
		Collections.sort(onlyPrice);

		// Find the top one
		System.out.println(onlyPrice);
		
		//driver.close();

		// Print Only Allen Solly Brand Minimum Price
		driver.findElementByXPath("//input[@value='Allen Solly']/following-sibling::div").click();
Thread.sleep(6000);
		// Find the costliest Jacket
		List<WebElement> allenSollyPrices = driver.findElementsByXPath("//span[@class='product-discountedPrice']");

		List<String> offerP = new ArrayList<String>();

		for (WebElement a : allenSollyPrices) {
			offerP.add(a.getText().replaceAll("\\D", ""));
		}

		// Get the minimum Price 
	//	String min = Collections.min(onlyPrice);
		Collections.reverse(offerP);

		// Find the lowest priced Allen Solly
		System.out.println(offerP);


	}

}