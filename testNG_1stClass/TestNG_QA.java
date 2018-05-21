package testNG_1stClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNG_QA {

	public static WebDriver driver;
	
	@BeforeTest
	public void Practice() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Chau\\Downloads\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://opensource.demo.orangehrmlive.com/");
	}
	@Test
	public void QALive() {
		driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@id='btnLogin']")).click();
		
		//use Assert to verify that you have logged in as Dashboard
		String expected = "Dashboard";
		String dashboardText = driver.findElement(By.xpath("//b[contains(.,'Dashboard')]")).getText();
		Assert.assertEquals(expected, dashboardText);
		
		
		//use boolean to check if element is displayed
		boolean obj = driver.findElement(By.xpath("//img[@alt='OrangeHRM']")).isDisplayed();
		Assert.assertEquals(true, obj);
		
	}
	@AfterTest
	public void Quit() {
		driver.quit();
	}
	
}
