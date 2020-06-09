package pagefunctions;

import Utilities.FrameworkUtilities.frameworkUtilities;
import pageactions.SignInPage;

public class SignInPageFunctions extends frameworkUtilities {

	SignInPage sin = new SignInPage();
	public void signin() {
		sin.setValueToEmailAddressInputField("tssumanth@gmail.com");
		sin.setValueToPasswordInputField("Test1993");
		sin.clickOnSignInButton();
		sin.verifySignOutButton();
	}
	
}
