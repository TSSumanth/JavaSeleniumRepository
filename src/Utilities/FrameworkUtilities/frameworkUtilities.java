package Utilities.FrameworkUtilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.aventstack.extentreports.Status;

import Utilities.ReportGenerator.Reportor;

public class frameworkUtilities extends Reportor{

	public static void main(String[] args) {
		generateExecutionId();
	}
	public static WebDriver driver; 
	public static String resultsLocation = "D:\\Java\\Selenium Results";
	public static int screenshot_count=1; 
	public final static String ProjectDirectory = System.getProperty("user.dir");
	public static String screenshotsLocation = "";
	public static String suiteName="";
	public static String testCaseName="";
	public static Sheet RunManagerMainSheet ;
	public static XSSFWorkbook RunManagerWorkBook;
	public static int totalNumberOfTests;
	public static int currentTestNumber;
	public static String ExecutionId;
	public static HashMap<String,String> testDetails = new HashMap<String,String>();
	
	public static void generateExecutionId() {
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		ExecutionId = timeStamp.replace(".", "-");
	}
	
	public static void createResultsLocation() {
		resultsLocation = resultsLocation +"\\"+ExecutionId;
		boolean bool = new File(resultsLocation).mkdirs();
		//Creating the directory
//	      boolean bool = file.mkdir();
	      if(bool){
	         System.out.println("Results directory created successfully.");
	      }else{
	         System.out.println("Results directory isn’t created.");
	      }
	}
	
	public static void launchBrowser(String BrowserName){
		if(BrowserName.toUpperCase().equals("FIREFOX"))
		{
			System.out.println("inside firefox launch block");
			System.setProperty("webdriver.gecko.driver",  ProjectDirectory+"//jars//geckodriver.exe");
			driver=new FirefoxDriver();
			logReport("firefox started","info");
		}
		else if(BrowserName.toUpperCase().equals("CHROME"))
		{
			System.out.println("inside chrome launch block");
			System.setProperty("webdriver.chrome.driver", ProjectDirectory+"//jars//chromedriver.exe");
			driver=new ChromeDriver();
			logReport("chrome started","info");
		}
		else if(BrowserName.toUpperCase().equals("HEADLESSCHROME"))
		{
			System.setProperty("webdriver.chrome.driver", ProjectDirectory+"//jars//chromedriver.exe");
			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.addArguments("--window-size=1200x600");
		    chromeOptions.addArguments("--headless");
		    driver = new ChromeDriver(chromeOptions);
		    logReport("headless chrome started","info");
		}
		driver.manage().window().maximize();		
	}
	
	public static void launchApllication(String URL) {
		if(driver != null) {
			driver.get(URL);
		}
		else {
			System.out.println("Driver is not yet initialized");
		}
	}
	public static void closeBrowser() {
		driver.close();
		logReport("closed browser","info");
	}
	
	private static void takeScreehshot() {
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(src, new File(screenshotsLocation+"//screenshot_"+screenshot_count+".png"));
			logReport("Screenshot taken","info");
			screenshot_count++;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void logReport(String Message, String status, boolean takeScreenshot) {
		System.out.println("log report method siwth screenshot");
		if(status.toLowerCase().equals("info")) {
			System.out.println("info method starting");
			logReport.log(Status.INFO, Message);
			System.out.println("info method done");
			if(takeScreenshot){
				takeScreehshot();
			}
		}else if(status.toLowerCase().equals("warning")) {
			logReport.log(Status.WARNING, Message);
			if(takeScreenshot){
				takeScreehshot();
			}
		}else if(status.toLowerCase().equals("pass")) {
			System.out.println("pass method starting");
			logReport.log(Status.PASS, Message);
			System.out.println("pass method done");
			if(takeScreenshot){
				takeScreehshot();
			}
		}else if(status.toLowerCase().equals("fail")) {
			logReport.log(Status.FAIL, Message);
			if(takeScreenshot) {
				takeScreehshot();
			}
			logReport.log(Status.FAIL, Message);
			failedTests.add(currentTestName);
			currentSuiteStatus = "Failed";
		}
		extent.flush();		
	}
	
	
	
	
}
