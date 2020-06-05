package pageactions;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Utilities.FrameworkUtilities.frameworkUtilities;
import Utilities.ReusableLibrary.UI_Components;

public class HomePage extends frameworkUtilities{

	UI_Components UIC = new UI_Components(); 
	public static void main(String[] args) {
		createHTMLDocument("D:\\Java\\Selenium Results\\sample.html");
		screenshotsLocation = "D:\\Java\\Selenium Results";
		HashMap<String,String> info = new HashMap<String,String>();
		
		info.put("URL"," http://automationpractice.com/index.php");
		info.put("Screenshot Location","Location Details");
		info.put("Runt Type","RRF Run");	
	
		CreateTestCaseInReport("Test 1");
		
		
		launchBrowser("FIREFOX");
		launchApllication(" http://automationpractice.com/index.php");
		HomePage mhp = new HomePage();
		mhp.clickOnTshirtsLink();
		closeBrowser();
		
//		CreateTestCaseInReport("Test 2 - headless chrome" );
//		launchBrowser("headlesschrome");
//		launchApllication(" http://automationpractice.com/index.php");
//		mhp.clickOnRegisterLink();
//		closeBrowser();		
//		addSystemInfo(info);
		System.out.println("completed");
		System.out.println("test");
		

	}
	
	public final String Nav_TSHIRTS_link = "xpath_//a[text()='T-shirts']";
	
	public void clickOnTshirtsLink() {
		By locator = UIC.getLocator(Nav_TSHIRTS_link);
		try {
			WebElement element = UIC.getVisibleElement(locator);
			UIC.clickOnElement(element);
		}
		catch(Exception e) {
			logReport("Exception while clicking on element: ", "fail");
			throw new RuntimeException("Element Not clickable Exception");
		}
	}
	

}
