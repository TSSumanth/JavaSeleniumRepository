package BasicTests;

import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SwitchWindows {

	static WebDriver driver;
	public static void main(String[] args) 
	{
		LaunchApplication.launchBrowser("chrome");
		LaunchApplication.launchApplication("http://demo.automationtesting.in/Windows.html");
		driver=LaunchApplication.driver;
		SwitchWindows object= new SwitchWindows();
		String tab1 = driver.getWindowHandle();
		object.clickonNewTabbedWindowClickButton();
		Set<String> tabs = driver.getWindowHandles();
		String tab2 = null;
		for(String tab:tabs)
		{
			if(!tab.equals(tab1))
			{
				tab2=tab;
			}
		}
		driver.switchTo().window(tab2);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		LaunchApplication.quitApplication();
		driver.switchTo().window(tab1);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		LaunchApplication.quitApplication();
		System.out.println("Execution Completed");
	}
	
	public void clickonNewTabbedWindowClickButton()
	{
		WebElement element = driver.findElement(By.xpath("//button[text()='    click   ']"));
		element.click();
	}

}
