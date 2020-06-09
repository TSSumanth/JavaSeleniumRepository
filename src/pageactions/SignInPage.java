package pageactions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Utilities.FrameworkUtilities.frameworkUtilities;
import Utilities.ReusableLibrary.UI_Components;

public class SignInPage  extends frameworkUtilities{

	UI_Components UIC = new UI_Components(); 
	public final String emailAddress_textBox = "id_email";
	public final String password_textBox = "id_passwd";
	public final String submit_button = "id_SubmitLogin";
	public final String signout_button="xpath_//a[@title='Log me out']";
		
	public void setValueToEmailAddressInputField(String value) {
		By locator = UIC.getLocator(emailAddress_textBox);
		try {
			WebElement element = UIC.getElement(locator);
			UIC.setValueToElement(element,value);
		}
		catch(Exception e) {
			logReport("Exception while clicking on element: ", "fail");
			throw new RuntimeException("Element Not clickable Exception");
		}
	}
	
	public void setValueToPasswordInputField(String value) {
		By locator = UIC.getLocator(password_textBox);
		try {
			WebElement element = UIC.getElement(locator);
			UIC.setValueToElement(element,value);
		}
		catch(Exception e) {
			logReport("Exception while clicking on element: ", "fail");
			throw new RuntimeException("Element Not clickable Exception");
		}
	}
	
	public void clickOnSignInButton() {
		By locator = UIC.getLocator(submit_button);
		try {
			WebElement element = UIC.getVisibleElement(locator);
			UIC.clickOnElement(element);
		}
		catch(Exception e) {
			logReport("Exception while clicking SignIn button", "fail");
			throw new RuntimeException("Element Not clickable Exception");
		}
	}
	
	public void verifySignOutButton() {		
		By locator = UIC.getLocator(signout_button);
		try {
			boolean presence = UIC.waitForElement(locator, true);
			if(presence) {
				logReport("Signout button is present", "pass");
			}else {
				logReport("Signout button is not present", "fail");
			}
		}
		catch(Exception e) {
			throw new RuntimeException("Exception while waiting for Signout button");
		}
	}
}
