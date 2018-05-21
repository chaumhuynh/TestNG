package ReviewClass_043018;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class dataProviderReview {
WebDriver driver;
	

	@Test (dataProvider = "data")
	public void OHRMLogin(String UID, String PWD) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Chau\\Downloads\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.get("http://opensource.demo.orangehrmlive.com");
		driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys(UID);
		driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys(PWD);
		driver.findElement(By.xpath("//input[@id='btnLogin']")).click();		
		
		Thread.sleep(3000);
		driver.quit();
	}
	
	@DataProvider (name = "data")
	public Object[][] testData() {
		//[row]: how many times you want to run your test (below, code will run 3 times)
		//[column]: how many parameters we will be passing 
		
		Object[][] data = new Object[3][2];
		
		//1st set
		data[0][0] = "Admin";
		data[0][1] = "admin";
		
		//2nd set
		data[1][0] = "Admin";
		data[1][1] = "admin";
		
		//3rd set
		data[2][0] = "Admin"; 
		data[2][1] = "admin";	
		
		return data;
	}
	

}
