package testNG_042618;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderPractice {
	
	@Test (dataProvider = "data")
	public void runTest(String username, String password, int age) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Chau\\Downloads\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://qa.syntaxlive.com/home/");
		
		driver.findElement(By.id("edit-name")).sendKeys(username);
		driver.findElement(By.id("edit-pass")).sendKeys(password);
		driver.findElement(By.id("edit-submit")).click();
		
		System.out.println(age);
	}
	
	@DataProvider (name = "data")
	public Object[][] practice() {
		Object [][] data = new Object[1][3]; //size of table - 2 rows and 3 columns
		
		/*	editor		|	Welcome1	|	20
		 * 	editor2		|	Welcome2	|	40
		 */	
		
		data[0][0] = "editor";
		data[0][1] = "Welcome1";
		data[0][2] = 20;
		
	/*	data[1][0] = "editor2";
		data[1][1] = "Welcome2";
		data[1][2] = 40; */
				
		return data;
	}
}
