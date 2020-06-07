package Executor;

import java.util.HashMap;
import Utilities.FrameworkUtilities.frameworkUtilities;
import pageactions.HomePage;
import pageactions.TShirtsPage;

public class TestExecutor extends frameworkUtilities {

	public static void main(String[] args) {
		createHTMLDocument("D:\\Java\\Selenium Results\\sample2.html");
		screenshotsLocation = "D:\\Java\\Selenium Results";
		HashMap<String,String> info = new HashMap<String,String>();
		
		info.put("URL"," http://automationpractice.com/index.php");
		info.put("Screenshot Location","Location Details");
		info.put("Runt Type","RRF Run");	
	
		CreateTestCaseInReport("Test 1");
		addSystemInfo(info);
		launchBrowser("chrome");
		launchApllication("http://automationpractice.com/index.php");
		logReport("Sampl eingor", "info",true);
		HomePage mhp = new HomePage();
		mhp.clickOnTshirtsLink();
		TShirtsPage tst = new TShirtsPage();
		tst.clickOnListView();
		closeBrowser();
		
		System.out.println("completed");
		System.out.println("test");
	}

}
