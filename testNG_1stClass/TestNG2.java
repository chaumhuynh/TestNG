package testNG_1stClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNG2 {
	public static WebDriver driver;

	@BeforeMethod
	public void ClassNG3() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Chau\\Downloads\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();

		driver.get("http://www.google.com/");
	}

	@Test
	public void testGoogle() {
		driver.findElement(By.id("lst-ib")).sendKeys("syntax technologies");
		driver.findElement(By.xpath("//input[@value='Google Search']")).click();
	}

	@AfterTest
	public void quitBrowser() {
		driver.quit();
	}
}
