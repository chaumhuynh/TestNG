package testNG_1stClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNG_1 {
	
	//add annotation
/*	@Test
	public void classNGmethod() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Chau\\Downloads\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("http://www.google.com/");

	} */
	
	//tests will be run in alphabetical order
	
	@Test
	public void bProgram() {
		System.out.println("This is B Program");
	}
	@Test
	public void aProgram() {
		System.out.println("This is A Program");
	}
	
	//we can set priority when running tests
	
	@Test (priority = 2)
	public void eProgram() {
		System.out.println("This is E Program");
	}
	
	@Test (priority = 1)
	public void cProgram() {
		System.out.println("This is C Program");
		Assert.assertEquals(12, 13);	//fail this test forcefully (expected vs actual)
	}	
	
}
