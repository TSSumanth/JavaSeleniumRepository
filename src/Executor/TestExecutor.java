package Executor;

import java.util.HashMap;
import Utilities.FrameworkUtilities.frameworkUtilities;
import pageactions.HomePage;
import pageactions.SignInPage;
import pageactions.TShirtsPage;
import pagefunctions.SignInPageFunctions;

public class TestExecutor extends frameworkUtilities {

	public static void main(String[] args) {
		createHTMLDocument("D:\\Java\\Selenium Results\\sample2.html");
		screenshotsLocation = "D:\\Java\\Selenium Results";
		HashMap<String,String> info = new HashMap<String,String>();
		
		info.put("URL"," http://automationpractice.com/index.php");
		info.put("Screenshot Location",screenshotsLocation);
		info.put("Runt Type","RRF Run");	
	
		CreateTestCaseInReport("Test 1");
		addSystemInfo(info);
		launchBrowser("chrome");
		launchApllication("http://automationpractice.com/index.php");
		HomePage mhp = new HomePage();
		mhp.clickOnTshirtsLink();
		TShirtsPage tst = new TShirtsPage();
		tst.clickOnListView();
		closeBrowser();
		if(currentSuiteStatus.equals("Failed")) {
			overallSuiteStatus = "Failed";
			currentSuiteStatus="";
		}
		CreateTestCaseInReport("Test 2" );
		launchBrowser("chrome");
		
		launchApllication(" http://automationpractice.com/index.php");
		mhp.clickOnSignInLink();
		
		SignInPageFunctions sin = new SignInPageFunctions();
		sin.signin();
		closeBrowser();		
		
		System.out.println("completed");
		if(overallSuiteStatus.equals("Failed")) {
			throw new RuntimeException("Overall Suite Status is Failed");
		}
	}

}
