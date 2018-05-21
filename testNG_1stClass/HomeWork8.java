package testNG_1stClass;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HomeWork8 {

	public static WebDriver driver;
	
	@BeforeTest
	public void openAmazon() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Chau\\Downloads\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://www.amazon.com/");
	}

	@Test
	//verify Amazon.com's page title
	public void assertTitle() {
		String expectedTitle = "Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more";
		String actualTitle = driver.getTitle();
		
		Assert.assertEquals(actualTitle, expectedTitle);
	}
	
	@Test
	//search for "iPad" and sort results by "Newest Arrivals"
	public void productSearch() throws InterruptedException {
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iPad");
		driver.findElement(By.xpath("//input[@value='Go']")).click();
		
		Select sort = new Select (driver.findElement(By.xpath("//select[@id='sort']")));
		sort.selectByVisibleText("Newest Arrivals");
		Thread.sleep(3000); //browser loads too fast & screenshot of newest arrivals were not captured
	}
	@Test
	//capture screenshot
	public void screenShot() throws IOException {
		TakesScreenshot screenshot = (TakesScreenshot)driver;
		File source = screenshot.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File ("C:\\Users\\Chau\\eclipse-workspace\\testNG_InClass\\Screenshot\\Amazonscreenshot.png"));
		
	}
	
	@AfterTest
	public void closeBroswer() {
		driver.quit();
	}
}
