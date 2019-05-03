package BasicTests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class PerformActionsOnElements {

	static WebDriver driver;
	public static void main(String[] args) {
		
		LaunchApplication.launchBrowser("chrome");
		LaunchApplication.launchApplication("http://demo.automationtesting.in/Register.html");
		driver=LaunchApplication.driver;
		PerformActionsOnElements object= new PerformActionsOnElements();
		object.enterFirstName("Sai Sumanth Reddy");
		object.enterLastName("Talamanchi");
		object.selectCountry("Australia");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		object.selectSkills("Analytics");
		LaunchApplication.quitApplication();
		System.out.println("Execution Completed");

	}
	
	public void enterFirstName(String firstName)
	{
		WebElement element = driver.findElement(By.xpath("//input[@placeholder='First Name']"));
		element.sendKeys(firstName);
	}
	
	public void enterLastName(String lastName)
	{
		WebElement element = driver.findElement(By.xpath("//input[@placeholder='Last Name']"));
		element.sendKeys(lastName);
	}
	
	public void selectCountry(String countryname)
	{
		WebElement countrydropdown = driver.findElement(By.xpath("//select[@id='country']/following-sibling::span/span/span"));
		countrydropdown.click();
		WebElement countrysearchbox = driver.findElement(By.xpath("//ul[@id='select2-country-results']/parent::span/parent::span/span/input"));
		countrysearchbox.sendKeys("Aus");
		List<WebElement> countrieslist = driver.findElements(By.xpath("//ul[@id='select2-country-results']"));
		for(int i=0;i<countrieslist.size();i++)
		{
			WebElement countrylist = countrieslist.get(i);
			if(countrylist.getText().toUpperCase().equals(countryname.toUpperCase()))
			{
				countrylist.click();
			}
		}
	}
	
	
	public void selectSkills(String SkillType)
	{
		WebElement element = driver.findElement(By.id("Skills"));
		Select select = new Select(element);
		select.selectByValue(SkillType);
	}
}
