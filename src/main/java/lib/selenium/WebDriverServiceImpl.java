package lib.selenium;

//import java.io.File;
//import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
//import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.InvalidElementStateException;
import org.openqa.selenium.NoSuchElementException;
//import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import lib.listeners.WebDriverListener;

public class WebDriverServiceImpl extends WebDriverListener implements WebDriverService{

	public WebElement locateElement(String locator, String locValue) {

		try {
			switch (locator) {
			case "id": return driver.findElement(By.id(locValue));

			case "class": return driver.findElement(By.className(locValue));

			case "link" : return driver.findElement(By.linkText(locValue));

			case "xpath": return driver.findElement(By.xpath(locValue));

			case "name": return driver.findElement(By.name(locValue));

			case "partiallink": return driver.findElement(By.partialLinkText(locValue));

			case "css": return driver.findElement(By.cssSelector(locValue));

			case "tag": return driver.findElement(By.tagName(locValue));

			default:
				reportSteps("Locator value should only be id/class/link/xpath/name/partiallink/css/tag (Case Sensitive)", "Fail");
				break;
			}
			reportSteps("Element with locator: "+ locator +" and value: "+ locValue +" found", "Pass");
		} catch (NoSuchElementException e) {
			reportSteps("Element with locator: "+ locator +" and value: "+ locValue +" not found", "Fail");
		}
		return null;
	}
	
	public int getElementsSize(String locator, String locValue)
	{
		try {
			switch (locator) {
			case "id": return driver.findElements(By.id(locValue)).size();

			case "class": return driver.findElements(By.className(locValue)).size();

			case "link" : return driver.findElements(By.linkText(locValue)).size();

			case "xpath": return driver.findElements(By.xpath(locValue)).size();

			case "name": return driver.findElements(By.name(locValue)).size();

			case "partiallink": return driver.findElements(By.partialLinkText(locValue)).size();

			case "css": return driver.findElements(By.cssSelector(locValue)).size();

			case "tag": return driver.findElements(By.tagName(locValue)).size();

			default:
				reportSteps("Locator value should only be id/class/link/xpath/name/partiallink/css/tag (Case Sensitive)", "Fail");
				break;
			}
		} catch (NoSuchElementException e) {
			reportSteps("Element with locator: "+ locator +" and value: "+ locValue +" not found", "Fail");
		}
		return 0;
	}

	public void type(WebElement ele, String data) {
		try {
			ele.sendKeys(data);
			reportSteps("Data "+ data +" set in the edit field", "Pass");
		} catch (InvalidElementStateException e) {
			reportSteps("Element is not in editable mode", "Fail");
		}
	}

	public void click(WebElement ele) {
		try {
			ele.click();
			reportSteps("Element clicked", "Pass");
		} catch (ElementNotInteractableException e) {
			reportSteps("Element not in Clickable state", "Fail");
		}
	}

	public String getText(WebElement ele) {
		try {
			reportSteps("Text: "+ele.getText() +" got from the element", "Pass");
		} catch (ElementNotVisibleException e) {
			reportSteps("Element is not in Visible mode to get text value", "Fail");
		}
		return ele.getText();
	}

	public void selectDropDownUsingVisibleText(WebElement ele, String value) {
		Select objSelect = new Select(ele);
		objSelect.selectByVisibleText(value);
		reportSteps(value +" selected from the dropdown", "Pass");
	}

	public void selectDropDownUsingValue(WebElement ele, String value) {
		Select objSelect = new Select(ele);
		objSelect.selectByValue(value);
		reportSteps(value +" selected from the dropdown", "Pass");
	}

	public void selectDropDownUsingIndex(WebElement ele, int index) {
		Select objSelect = new Select(ele);
		objSelect.selectByIndex(index);
		reportSteps("Value with index: "+ index +" selected from the dropdown", "Pass");
	}

	public boolean verifyExactTitle(String expectedTitle) {
		//		Verify Exact text is matching with the expectedText value
		try {
			if (driver.getTitle().equals(expectedTitle))
			{
				reportSteps("Expected title is matching exactly", "Pass");
				return true;
			}
			else
			{
				reportSteps("Expected title is NOT matching. Actual title is \""+ driver.getTitle() +"\"", "Fail");
				return false;
			}
		} catch (WebDriverException e) {
			reportSteps("Something went wrong with the Browser", "Fail");
			return false;
		}
	}
	
	public boolean verifyPartialTitle(String expectedTitle) {
		//		Verify Exact text is matching with the expectedText value
		try {
			if (driver.getTitle().contains(expectedTitle))
			{
				reportSteps("Expected title is present", "Pass");
				System.out.println("Adding sysout statement");
				return true;
			}
			else
			{
				reportSteps("Expected title is NOT present. Actual title is \""+ driver.getTitle() +"\"", "Fail");
				return false;
			}
		} catch (WebDriverException e) {
			reportSteps("Something went wrong with the Browser", "Fail");
			return false;
		}
	}

	public void verifyExactText(WebElement ele, String expectedText) {
		//		Verify Exact text is matching with the expectedText value
		try {
			if (ele.getText().equals(expectedText))
			{
				reportSteps("Expected text is matching exactly", "Pass");
			}
			else
			{
				reportSteps("Expected text is NOT matching. Actual text is \""+ ele.getText() +"\"", "Fail");
			}
		} catch (NoSuchElementException e) {
			reportSteps("Element "+ ele +"not present", "Fail");
		}
	}

	public void verifyPartialText(WebElement ele, String expectedText) {
		//		Verify partial text is matching with the expectedText value
		try {
			if (ele.getText().contains(expectedText))
			{
				reportSteps("Expected text "+ expectedText +" is present", "Pass");
			}
			else
			{
				reportSteps("Expected text is NOT present. Actual text is \""+ ele.getText() +"\"", "Fail");
			}
		} catch (NoSuchElementException e) {
			reportSteps("Element "+ ele +"not present", "Fail");
		}

	}

	public void verifyExactAttribute(WebElement ele, String attribute, String value) {
		// TODO Auto-generated method stub

	}

	public void verifyPartialAttribute(WebElement ele, String attribute, String value) {
		// TODO Auto-generated method stub

	}

	public void verifySelected(WebElement ele) {
		// TODO Auto-generated method stub

	}

	public void verifyDisplayed(WebElement ele) {
		boolean displayed = ele.isDisplayed();
		System.out.println(displayed);
	}

	public void switchToWindow(int index) {
		Set<String> allWin = driver.getWindowHandles();
		List<String> listAllWin = new ArrayList<String>();
		listAllWin.addAll(allWin);
		driver.switchTo().window(listAllWin.get(index));
//		reportSteps("Switched to windows with index: "+ index, "Pass");
	}

	public void switchToFrame(WebElement ele) {
		reportSteps("Swithcing to Frame", "Pass");
		driver.switchTo().frame(ele);
	}

	public void acceptAlert() {
		driver.switchTo().alert().accept();
		reportSteps("Alert accepted", "Pass");
	}

	public void dismissAlert() {
		driver.switchTo().alert().dismiss();
		reportSteps("Alert dismissed", "Pass");
	}

	public String getAlertText() {
		reportSteps("Alert text: "+driver.switchTo().alert().getText(), "Pass");
		return driver.switchTo().alert().getText();
	}

	public void closeActiveBrowser() {
		try {
			reportSteps("Browser closed successfully", "Pass");
			driver.close();
		} catch (WebDriverException e) {
			reportSteps("Browser doesnot exist", "Fail");
		}
	}

	public void closeAllBrowsers() {
		try {
			reportSteps("Browser closed successfully", "Pass");
			driver.quit();
		} catch (WebDriverException e) {
			reportSteps("Browser doesnot exist", "Fail");
		}
	}

	public void mouseOver(WebElement eleTarget)
	{
		Actions objAction = new Actions(driver);
		objAction.moveToElement(eleTarget).perform();
		reportSteps("Mouse over done on "+eleTarget, "Pass");
	}
	
	public void mouseClick(WebElement eleTarget)
	{
		Actions objAction = new Actions(driver);
		objAction.click(eleTarget);
		reportSteps("Mouse over done on "+eleTarget, "Pass");
	}

}
