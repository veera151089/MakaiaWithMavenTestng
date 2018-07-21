package tests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import lib.selenium.WebDriverServiceImpl;

public class Flipkart extends WebDriverServiceImpl{
	
	public String filterAmount, newAmount, firstProdValue, secondProdValue;

	@Test
	public void SamsungCompare() throws InterruptedException {
//		Close the login window
		driver.getKeyboard().sendKeys(Keys.ESCAPE);
		Thread.sleep(2000);
		
//		Mouse Over on TVs & Appliances
		WebElement eleTVAppl = locateElement("xpath","//span[text()='TVs & Appliances']");
		mouseOver(eleTVAppl);
		
//		Wait till all the options are displayed
		Thread.sleep(3000);
		
//		Click on Samsung link
		WebElement eleSamsung = locateElement("xpath","(//span[text()='Samsung'])[2]");
		click(eleSamsung);
		
//		Select value from Minimum amount filter
		WebElement eleMinFilter = locateElement("xpath","(//select[@class='fPjUPw'])[1]");
		selectDropDownUsingValue(eleMinFilter, "25000");
		
//		Wait for the page to re-load after applying filter
		Thread.sleep(2000);
		
//		Select value from maximum amount filter
		WebElement eleMaxFilter = locateElement("xpath","(//select[@class='fPjUPw'])[2]");
		selectDropDownUsingValue(eleMaxFilter, "60000");
		
//		Wait for the page to re-load after applying filter
		Thread.sleep(2000);
		
//		Click on Screen size link
		WebElement eleScreenSize = locateElement("xpath","//div[text()='Screen Size']");
		click(eleScreenSize);
		
//		Select the option 48-55
		WebElement eleSize = locateElement("xpath", "//div[text()='48 - 55']");
		click(eleSize);
		
//		Wait for the page to re-load after applying filter
		Thread.sleep(3000);
		
//		Get the amount of the first product
		WebElement eleAmount = locateElement("xpath", "//div[@class='_1vC4OE _2rQ-NK']");
		filterAmount = getText(eleAmount);
		
//		Click on the first product
		WebElement eleFirstLink = locateElement("xpath", "//div[@class='_3wU53n']");
		click(eleFirstLink);
		
//		Wait till the second page is loaded
		Thread.sleep(3000);
		
//		Switch to the newly opened window
		switchToWindow(1);
		
//		Get the amount of the first product from the new page opened
		WebElement eleNewAmount = locateElement("xpath", "//div[@class='_1vC4OE _3qQ9m1']");
		newAmount = getText(eleNewAmount);
		
//		Verify both the amounts are same
		verifyExactText(eleNewAmount, filterAmount);
		
//		Close the current Browser
		closeActiveBrowser();
		
//		Switch back to the main window
		switchToWindow(0);
		
//		Select the check-box Add to Compare for first product
		WebElement eleFirstProd = locateElement("xpath", "(//div[@class='bhgxx2 col-12-12']/following::div[@class='_1p7h2j'])[1]");
		mouseClick(eleFirstProd);
		
//		Select the check-box Add to Compare for second product
		WebElement eleSecondProd = locateElement("xpath", "(//div[@class='bhgxx2 col-12-12']/following::div[@class='_1p7h2j'])[2]");
		mouseClick(eleSecondProd);
		
//		Click on Compare button
		WebElement eleBtnCompare = locateElement("xpath", "//span[text()='COMPARE']");
		click(eleBtnCompare);
		
//		Verify the title is having compare in it
		verifyPartialTitle("compare");
		
//		Get the value of the first product from compare screen
		WebElement eleFrstAmt = locateElement("xpath", "(//div[@class='_1vC4OE'])[1]");
		firstProdValue = getText(eleFrstAmt);
		firstProdValue = firstProdValue.replaceAll("\\D", "");
		System.out.println("First Product value: "+ firstProdValue);
		
//		Get the value of the second product from compare screen
		WebElement eleScndAmt = locateElement("xpath", "(//div[@class='_1vC4OE'])[2]");
		secondProdValue = getText(eleScndAmt).replaceAll("\\D", "");
//		secondProdValue = secondProdValue.replaceAll("\\D", "");
		System.out.println("Second Product value: "+ secondProdValue);
		
//		Print the lowest price between these two values
		if (Integer.parseInt(firstProdValue) > Integer.parseInt(secondProdValue))
		{
			System.out.println("Second product value is lesser than the first product");
		}
		else
		{
			System.out.println("First product value is lesser than the second product");
		}
		
//		Close the active browser
		closeActiveBrowser();
	}

}
