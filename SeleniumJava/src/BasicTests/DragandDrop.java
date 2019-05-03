package BasicTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class DragandDrop {

	static WebDriver driver;
	public static void main(String[] args) {
		
		LaunchApplication.launchBrowser("chrome");
		LaunchApplication.launchApplication("http://demo.automationtesting.in/Static.html");
		driver=LaunchApplication.driver;
		DragandDrop object= new DragandDrop();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		WebElement from = object.getAngularElement();
		WebElement to = object.getDropArea();
		Actions act = new Actions(driver);
		//act.dragAndDrop(object.getAngularElement(), object.getDropArea()).build().perform();
		act.clickAndHold(from).moveToElement(to).release(from).build().perform();
		act.dragAndDropBy(from,0, 200).build().perform();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		LaunchApplication.quitApplication();
	}

	public WebElement getAngularElement()
	{
		WebElement element = driver.findElement(By.xpath("//img[@id='angular']/parent::div"));
		return element;
	}
	
	public WebElement getDropArea()
	{
		WebElement element = driver.findElement(By.xpath("//div[@id='droparea']"));
		return element;
	}
	
}
