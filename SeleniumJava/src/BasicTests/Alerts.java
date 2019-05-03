package BasicTests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Alerts {

	static WebDriver driver;
	public static void main(String[] args) 
	{

		LaunchApplication.launchBrowser("chrome");
		LaunchApplication.launchApplication("http://demo.automationtesting.in/Alerts.html");
		driver=LaunchApplication.driver;
		Alerts object= new Alerts();
		
		object.clickonAlertdisplaybutton();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//driver.switchTo().alert().accept();	
		driver.switchTo().alert().dismiss();	
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		object.clickonAlertwithokandcanceltab();
		object.clickonAlertOkandcanceldisplaybutton();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.switchTo().alert().accept();	
		//driver.switchTo().alert().dismiss();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		object.clickonAlertwithtexttab();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		object.clickonAlerttextboxdisplaybutton();
		driver.switchTo().alert().sendKeys("Sumanth");
		driver.switchTo().alert().accept();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		LaunchApplication.quitApplication();
		System.out.println("Execution Completed");
		
	}
	
	public void clickonAlertdisplaybutton()
	{
		WebElement element = driver.findElement(By.xpath("//div[@id='OKTab']/button"));
		element.click();
	}
	
	public void clickonAlertwithokandcanceltab()
	{
		WebElement element = driver.findElement(By.xpath("//a[text()='Alert with OK & Cancel ']"));
		element.click();
	}
	
	public void clickonAlertwithtexttab()
	{
		WebElement element = driver.findElement(By.xpath("//a[text()='Alert with Textbox ']"));
		element.click();
	}
	
	public void clickonAlertOkandcanceldisplaybutton()
	{
		WebElement element = driver.findElement(By.xpath("//div[@id='CancelTab']/button"));
		element.click();
	}
	
	public void clickonAlerttextboxdisplaybutton()
	{
		WebElement element = driver.findElement(By.xpath("//div[@id='Textbox']/button"));
		element.click();
	}

}
