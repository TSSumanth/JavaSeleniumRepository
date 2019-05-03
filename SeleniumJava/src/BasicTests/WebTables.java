package BasicTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WebTables {

	static WebDriver driver;
	public static void main(String[] args) {
		
		LaunchApplication.launchBrowser("chrome");
		LaunchApplication.launchApplication("http://demo.automationtesting.in/WebTable.html");
		driver=LaunchApplication.driver;
		WebTables object= new WebTables();
		String source = driver.getPageSource();
		System.out.println(source);
		LaunchApplication.quitApplication();
		System.out.println("Execution Completed");
	}

	
	public void webtable(String firstName)
	{
		WebElement element = driver.findElement(By.xpath("//input[@placeholder='First Name']"));
		element.sendKeys(firstName);
	}
}
