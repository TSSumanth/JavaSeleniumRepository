package ReusableLibrary;

import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import CustomExceptions.LocatorNotCorrectlyFormatedException;
import FrameworkUtilities.frameworkUtilities;

public final class UI_Components extends frameworkUtilities {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
	
	public final static int timeInSeconds = 60;
	
	public By getLocator(String locator) {
		By finalLocator=null;
		String[] locatorDetails = locator.split("_",2);
		logReport("Splitting given Locator "+ locator, "info");
		for(String element:locatorDetails) {
			logReport("Elements in given locator: "+ element, "info");
		}		
		if(locatorDetails.length != 2) {
			logReport("Locator is not correctly formatted:" + locator,"fail");
				throw new LocatorNotCorrectlyFormatedException("Locator is not correctly formatted: "+ locator);
		}	
		
		if(locatorDetails[0].toLowerCase().equals("id")) {
			finalLocator = By.id(locatorDetails[1]);
		}else if(locatorDetails[0].toLowerCase().equals("clasname")) {
			finalLocator = By.className(locatorDetails[1]);
		}else if(locatorDetails[0].toLowerCase().equals("linktext")) {
			finalLocator = By.linkText(locatorDetails[1]);
		}else if(locatorDetails[0].toLowerCase().equals("partiallinktext")) {
			finalLocator = By.partialLinkText(locatorDetails[1]);
		}else if(locatorDetails[0].toLowerCase().equals("name")) {
			finalLocator = By.name(locatorDetails[1]);
		}else if(locatorDetails[0].toLowerCase().equals("tagname")) {
			finalLocator = By.tagName(locatorDetails[1]);
		}else if(locatorDetails[0].toLowerCase().equals("xpath")) {
			finalLocator = By.xpath(locatorDetails[1]);
		}else if(locatorDetails[0].toLowerCase().equals("cssselector")) {
			finalLocator = By.cssSelector(locatorDetails[1]);
		}else {
			logReport("Locator is not correctly formatted:" + locator,"fail");
			throw new LocatorNotCorrectlyFormatedException("Locator is not correctly formatted: "+ locator);
		}
		return finalLocator;
	}
	
	public WebElement getElement(By locator) {
		WebElement element=null;
		try {
			if(this.waitForElement(locator))
				element = driver.findElement(locator);
			else {
				logReport("Element is not present in UI: "+ locator.toString(), "fail",true);
				throw new NoSuchElementException();
			}
		}catch(Exception e) {
			logReport("Exception while getting element through getElement() for : "+ locator.toString(), "fail");
			logReport("Error details: "+ e.getMessage(), "info");			
			throw new NoSuchElementException();
		}
		return element;
	}
	
	public WebElement getElement(By locator, int timeinseconds) {
		WebElement element=null;
		try {
			if(this.waitForElement(locator,timeinseconds))
				element = driver.findElement(locator);
			else {
				logReport("Element is not present in UI: "+ locator.toString(), "fail",true);
				throw new NoSuchElementException();
			}
		}catch(Exception e) {
			logReport("Exception while getting element through getElement() for : "+ locator.toString(), "fail");
			logReport("Error details: "+ e.getMessage(), "info");			
			throw new NoSuchElementException();
		}
		return element;
	}

	public boolean waitForElement(By locator)
	{
		try {
			WebDriverWait wait = new WebDriverWait(driver, timeInSeconds);
			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			logReport("Element is not present: "+ locator.toString(), "info");
			return true;
		}catch(NoSuchElementException NE) {
			logReport("Element is not present: "+ locator.toString(), "info", true);
			return false;
		}catch(Exception e) {
			logReport("Element is not present: "+ locator.toString(), "info", true);
			logReport("Exception Occured: "+ e.getMessage(), "info");
			return false;
		}
	}
	
	public boolean waitForElement(By locator, int timeinseconds)
	{
		try {
			WebDriverWait wait = new WebDriverWait(driver, timeinseconds);
			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			logReport("Element is not present: "+ locator.toString(), "info");
			return true;
		}catch(NoSuchElementException NE) {
			logReport("Element is not present: "+ locator.toString(), "info", true);
			return false;
		}		
	}	
	
	public boolean waitForElement(By locator, boolean checkVisibility)
	{
		try {
			WebDriverWait wait = new WebDriverWait(driver, timeInSeconds);
			wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
			return true;
		}catch(NoSuchElementException NE ) {
			logReport("Element is not present: "+ locator.toString(), "info", true);
			return false;
		}catch(ElementNotVisibleException NV) {
			logReport("Element is not visible: "+ locator.toString(), "info", true);
			return false;
		}catch(Exception e) {
			logReport("Element is not present: "+ locator.toString(), "fail", true);
			return false;
		}		
	}	
	
	public WebElement getVisibleElement(By locator) {
		WebElement visbileelement = null;
		try {
			List<WebElement> elements = driver.findElements(locator);
			for(WebElement element:elements) {
				try {
				WebDriverWait wait = new WebDriverWait(driver, timeInSeconds);
				wait.until(ExpectedConditions.elementToBeClickable(element));
				logReport("Elements is visible for locator: "+ locator.toString() +" returning the element", "info");
				return element;
				}catch(Exception e) {
					continue;
				}
			}
		}catch(Exception e) {
			logReport("No Elements are visible for locator: "+ locator.toString(), "info");
			return visbileelement;
		}
		logReport("No Elements are visible for locator: "+ locator.toString(), "info");
		return visbileelement;
	}
	
	public boolean checkElementIsClickable(By locator) {
		this.waitForElement(locator,true);
		try {
				WebDriverWait wait = new WebDriverWait(driver, timeInSeconds);
				wait.until(ExpectedConditions.elementToBeClickable(locator));
				return true;					
		}catch(NoSuchElementException NE ) {
			logReport("Element is not present: "+ locator.toString(), "fail", true);
			return false;
		}catch(ElementNotVisibleException NV) {
			logReport("Element is not visible: "+ locator.toString(), "info", true);
			return false;
		}catch(Exception e){
			logReport("Element is not clickable: "+ locator.toString(), "info", true);
			return false;
		}
	}
	
	public boolean checkElementIsClickable(By locator, int timeinseconds) {
		this.waitForElement(locator,true);
		try {
				WebDriverWait wait = new WebDriverWait(driver, timeinseconds);
				wait.until(ExpectedConditions.elementToBeClickable(locator));
				return true;					
		}catch(NoSuchElementException NE ) {
			logReport("Element is not present: "+ locator.toString(), "fail", true);
			return false;
		}catch(ElementNotVisibleException NV) {
			logReport("Element is not visible: "+ locator.toString(), "fail", true);
			return false;
		}catch(Exception e){
			logReport("Element is not clickable: "+ locator.toString(), "info", true);
			return false;
		}
	}
	
	public void clickOnElement(By locator) {
		try {
			WebElement element = this.getElement(locator);
			element.click();
		}catch(Exception e) {
			logReport("Unable to click on element. Error occured, "+e.getMessage(), "fail", true);
			logReport(e.getLocalizedMessage(),"info");
			throw new RuntimeException(e.getMessage());
		}
	}
	
	public void clickOnElement(WebElement element) {
		try {
			element.click();
			logReport("clicked on element.", "pass", true);
		}catch(Exception e) {
			logReport("Unable to click on element. Error occured, "+e.getMessage(), "fail", true);
			logReport(e.getLocalizedMessage(),"info");
			throw new RuntimeException(e.getMessage());
		}
	}
	
	
}
