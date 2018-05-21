package testNG_042818;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class PropertiesPractice {
	WebDriver driver;
	
	@Test
	public void Prop() throws IOException {
		//import Properties class
		Properties myProp = new Properties();
		
		//provide destination of file
		FileInputStream source = new FileInputStream("C:\\Users\\Chau\\eclipse-workspace\\testNG_InClass\\TestNG_Prop.properties");
		
		//load file
		myProp.load(source);
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Chau\\Downloads\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.get(myProp.getProperty("URL"));
		//use Properties class to increase security (Ex: not sharing admin credentials with others)
		driver.findElement(By.xpath(myProp.getProperty("usernameXpath"))).sendKeys(myProp.getProperty("username"));
		driver.findElement(By.xpath(myProp.getProperty("passwordXpath"))).sendKeys(myProp.getProperty("password"));
		driver.findElement(By.xpath("//input[@id='btnLogin']")).click();
	
		/* Options to work with data:
		 * excel, array, XML, txt, Properties
		 */
	}
}
