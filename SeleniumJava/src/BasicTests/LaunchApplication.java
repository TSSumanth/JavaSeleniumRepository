package BasicTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LaunchApplication {

	static WebDriver driver;
	public static void main(String[] args) 
	{
		launchBrowser("HEADLESSCHROME");
		launchApplication("https://www.linkedin.com/");
		quitApplication();
		System.out.println("Execution Completed");
	}
	
	public static void launchBrowser(String BrowserName)
	{
		if(BrowserName.toUpperCase().equals("FIREFOX"))
		{
			
		}
		else if(BrowserName.toUpperCase().equals("CHROME"))
		{
			System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chromedriver_win32\\chromedriver.exe");
			driver=new ChromeDriver();
		}
		else if(BrowserName.toUpperCase().equals("HEADLESSCHROME"))
		{
			System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chromedriver_win32\\chromedriver.exe");
			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.addArguments("--window-size=1200x600");
		    chromeOptions.addArguments("--headless");
		    driver = new ChromeDriver(chromeOptions);
		}
		driver.manage().window().maximize();
	}
	
	public static void launchApplication(String ApplicationURL)
	{
		driver.get(ApplicationURL);
	}
	
	public static void quitApplication()
	{
		driver.close();
	}

}
