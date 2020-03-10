package BasicTests;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class propertiesfile {
	
	public static void main(String[] args) throws IOException {
		
		Properties prop = new Properties();
		//creates inpur stream between properties file and Properties class.
		FileInputStream fis = new FileInputStream("D:\\Selenium Java\\Selenium Git\\JavaSeleniumRepository\\SeleniumJava\\src\\BasicTests\\testProperties.properties");
		
		prop.load(fis);
		
		System.out.println(prop.getProperty("Test1"));
		
		System.out.println(prop.setProperty("Testn", "Settingvalue"));
		
		System.out.println(prop.setProperty("Testn", "Settingvalue"));
		
		System.out.println(prop.containsKey("Testn"));
		
		System.out.println(prop.containsValue("setti"));
		
		System.out.println(prop.isEmpty());
	
	}
}