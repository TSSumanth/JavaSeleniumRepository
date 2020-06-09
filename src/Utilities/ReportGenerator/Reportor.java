package Utilities.ReportGenerator;

import java.io.File;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Reportor {
	private static ExtentHtmlReporter reporter;
	protected static ExtentReports extent;
	protected static ExtentTest logReport;
	public static String overallSuiteStatus = "Passed";
	public static String currentSuiteStatus = "Passed";
	public static Set<String> failedTests = new HashSet<String>(); 
	public static String currentTestName="";
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		createHTMLDocument("D:\\Java\\Selenium Results\\new.html");
		HashMap<String,String> info = new HashMap<String,String>();
		
		info.put("URL","http://www.newtours.demoaut.com/");
		info.put("Screenshot Location","Location Details");
		info.put("Runt Type","RRF Run");	
	
		CreateTestCaseInReport("Test 1");
		logReport("Sampl eingor", "info");
		logReport("Sampl eingor", "pass");
		logReport("Sampl eingor", "fail");
		logReport("Sampl eingor", "pass");
		logReport("Sampl eingor", "pass");
		CreateTestCaseInReport("Test 2");
		logReport("Sampl eingor", "info");
		logReport("Sampl eingor", "pass");
		logReport("Sampl eingor", "pass");
		logReport("Sampl eingor", "pass");
		logReport("Sampl eingor", "pass");
		addSystemInfo(info);
		System.out.println("completed");
		logReport("Sampl eingor", "pass");
		logReport("Sampl eingor", "pass");
		logReport("Sampl eingor", "pass");
		extent.flush();	
	}
	
	public static void createHTMLDocument(String ReportLocation) {
		
			reporter = new ExtentHtmlReporter(ReportLocation);
			reporter.config().setReportName("Build VErification TEst Report");
			reporter.config().setDocumentTitle("Central Run Report");
			reporter.config().setTheme(Theme.DARK);
			extent = new ExtentReports();
			extent.attachReporter(reporter);
	}
	
	public static void addSystemInfo(HashMap<String,String> info) {
		Set keyset = info.entrySet();
		Iterator itr = keyset.iterator();
		
		while(itr.hasNext()) {
			Map.Entry me = (Map.Entry) itr.next();
			String key = (String) me.getKey();
			extent.setSystemInfo(key, info.get(key));
		}		
		Set<String> keys = info.keySet();
		Iterator iterator = keys.iterator();
		while(iterator.hasNext()) {
			String key = (String) iterator.next();
			extent.setSystemInfo(key, info.get(key));
		}				
		extent.setSystemInfo("test", "test");
		extent.flush();
	}
	
	public static void CreateTestCaseInReport(String TestCaseName) {	
		logReport = extent.createTest(TestCaseName);
		currentTestName = TestCaseName;
		extent.flush();
	}
	
	public static void logReport(String Message, String status) {
		if(status.toLowerCase().equals("info")) {
			logReport.log(Status.INFO, Message);
		}else if(status.toLowerCase().equals("warning")) {
			logReport.log(Status.WARNING, Message);
		}else if(status.toLowerCase().equals("pass")) {
			logReport.log(Status.PASS, Message);
		}else if(status.toLowerCase().equals("fail")) {
			logReport.log(Status.FAIL, Message);
			failedTests.add(currentTestName);
			currentSuiteStatus = "Failed";
		}
		extent.flush();		
	}
	
}
