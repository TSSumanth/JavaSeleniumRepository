package BasicTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LaunchApplication {

	static WebDriver driver;
	public static void main(String[] args) 
	{
		launchBrowser("FIREFOX");
		launchApplication("https://www.linkedin.com/");
		quitApplication();
		System.out.println("Execution Completed Firefox");
		launchBrowser("CHROME");
		launchApplication("https://www.linkedin.com/");
		quitApplication();
		System.out.println("Execution Completed CHROME");
		launchBrowser("HEADLESSCHROME");
		launchApplication("https://www.linkedin.com/");
		quitApplication();
		System.out.println("Execution Completed HEADLESSCHROME");
	}
	
	public static void launchBrowser(String BrowserName)
	{
		if(BrowserName.toUpperCase().equals("FIREFOX"))
		{
			System.setProperty("webdriver.gecko.driver", "D:\\Selenium Java\\chromedriver\\geckodriver.exe");
			driver=new FirefoxDriver();
		}
		else if(BrowserName.toUpperCase().equals("CHROME"))
		{
			System.setProperty("webdriver.chrome.driver", "D:\\Selenium Java\\chromedriver\\chromedriver.exe");
			driver=new ChromeDriver();
		}
		else if(BrowserName.toUpperCase().equals("HEADLESSCHROME"))
		{
			System.setProperty("webdriver.chrome.driver", "D:\\Selenium Java\\chromedriver\\chromedriver.exe");
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
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(driver.getTitle());
	}
	
	public static void quitApplication()
	{
		driver.close();
	}

}
