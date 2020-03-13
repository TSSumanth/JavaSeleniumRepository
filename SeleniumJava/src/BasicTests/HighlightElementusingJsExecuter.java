package BasicTests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HighlightElementusingJsExecuter {

	static WebDriver driver;
	public static void main(String[] args) {
		
		LaunchApplication.launchBrowser("chrome");
		LaunchApplication.launchApplication("http://demo.automationtesting.in/Index.html");
		driver=LaunchApplication.driver;
		HighlightElementusingJsExecuter object= new HighlightElementusingJsExecuter();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		WebElement from = object.getAngularElement();
		WebElement to = object.getDropArea();
		object.drawborder(driver,from);
		object.drawborder(driver,to);
		object.generateAlert(driver, "Error message: expected value finish date is not present ");
		object.handleAlert(driver);
		object.clickOnElement(driver,from);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		LaunchApplication.quitApplication();
	}

	public WebElement getAngularElement()
	{
		WebElement element = driver.findElement(By.xpath("//button[text()='Sign In']"));
		return element;
	}
	
	public WebElement getDropArea()
	{
		WebElement element = driver.findElement(By.xpath("//button[@id='btn2']"));
		return element;
	}
	
	public void flash(WebDriver driver,WebElement element)
	{
		JavascriptExecutor js =(JavascriptExecutor)driver;
		String bgcolor = element.getCssValue("backgroundColor");
		System.out.println(bgcolor);
		for(int i=0;i<10;i++)
		{
			this.changecolor(driver,element,"rgba(200,0,0,200)");
			//this.changecolor(driver,element,bgcolor);
		}
	}
	
	public void changecolor(WebDriver driver,WebElement element,String color) {
		
		JavascriptExecutor js =(JavascriptExecutor)driver;
		js.executeScript("arguments[0].style.backgorundColor = '"+color+"'", element);
		try {
			System.out.println("waiting");
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void drawborder(WebDriver driver,WebElement element) {
		
		JavascriptExecutor js =(JavascriptExecutor)driver;
		js.executeScript("arguments[0].style.border = '3px solid red'", element);
		
	}
	
	public void generateAlert(WebDriver driver,String message) {
		JavascriptExecutor js =(JavascriptExecutor)driver;
		js.executeScript("alert('"+message+"')");
	}
	
	public void handleAlert(WebDriver driver)
	{
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();
	}
	
	public void clickOnElement(WebDriver driver,WebElement element) {
		JavascriptExecutor js =(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();",element);
	}

	public void refreshPageJS(WebDriver driver) {
		JavascriptExecutor js =(JavascriptExecutor)driver;
		js.executeScript("history.go(0)");
	}

	
}
