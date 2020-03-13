package BasicTests;

import org.openqa.selenium.WebDriver;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;


public class sikulitest {

	static WebDriver driver;
	public static void main(String[] args) 
	{

		LaunchApplication.launchBrowser("chrome");
		LaunchApplication.launchApplication("http://demo.automationtesting.in/Alerts.html");
		driver=LaunchApplication.driver;
		sikulitest object= new sikulitest();
		
		Screen screen = new Screen(); 
		Pattern pauseinppattern = new Pattern("Pathtotheimage.img");
		try {
			screen.wait(pauseinppattern,2000);
		} catch (FindFailed e) {
			e.printStackTrace();
		}
		screen.click();
		
		
	}

}
