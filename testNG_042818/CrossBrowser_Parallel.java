package testNG_042818;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CrossBrowser_Parallel {

	WebDriver driver;
	
	//use Test annotations to tell program we are using TestNG framework
	@Test
	@Parameters("browser")
	public void verifyPage(String browserName) throws InterruptedException {
		if(browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\Chau\\Downloads\\Drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
			driver.get("http://opensource.demo.orangehrmlive.com");
		} else {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Chau\\Downloads\\Drivers\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.get("http://opensource.demo.orangehrmlive.com");
		}
	//parallel testing - run below code on both browsers (chrome & firefox)	
		driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@id='btnLogin']")).click();
		
		Thread.sleep(3000);
		
		//add candidate and save
		driver.findElement(By.id("menu_recruitment_viewRecruitmentModule")).click();
		driver.findElement(By.id("btnAdd")).click();

		driver.findElement(By.id("addCandidate_firstName")).sendKeys("Chau");
		driver.findElement(By.id("addCandidate_middleName")).sendKeys("M");
		driver.findElement(By.id("addCandidate_lastName")).sendKeys("Huynh");
		driver.findElement(By.id("addCandidate_email")).sendKeys("chau.huynh123@yahoo.com");
		driver.findElement(By.id("addCandidate_contactNo")).sendKeys("5712349000");
		driver.findElement(By.id("addCandidate_comment")).sendKeys("Testing 123");

		driver.findElement(By.id("btnSave")).click();

		String URL = driver.getCurrentUrl();
		System.out.println("The current URL is: " + URL);

	}
}
