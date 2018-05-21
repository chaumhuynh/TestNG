package ReviewClass_043018;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class parameterReview {
	WebDriver driver;
	
	@BeforeMethod
	@Parameters({"browser"})
	public void setUp(String browser) {
		if(browser.equalsIgnoreCase("chrome")) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Chau\\Downloads\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		} else {
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\Chau\\Downloads\\Drivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		}
		
	}
	@Test
	@Parameters({"UID", "PWD"})
	public void OHRMLogin(String UID, String PWD) {
		driver.get("http://opensource.demo.orangehrmlive.com");
		driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys(UID);
		driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys(PWD);
		driver.findElement(By.xpath("//input[@id='btnLogin']")).click();		
	}
	
	@AfterMethod
	public void cleanUp() throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();
	}
	
}
