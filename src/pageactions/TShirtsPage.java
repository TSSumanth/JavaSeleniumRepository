package pageactions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Utilities.FrameworkUtilities.frameworkUtilities;
import Utilities.ReusableLibrary.UI_Components;

public class TShirtsPage extends frameworkUtilities{

	UI_Components UIC = new UI_Components(); 
	public final String listview = "xpath_//li[@class='display-title' and text()='View']/following-sibling::li[@id='list']";
	
	public void clickOnListView() {
		By locator = UIC.getLocator(listview);
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
