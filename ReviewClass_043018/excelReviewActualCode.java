package ReviewClass_043018;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class excelReviewActualCode {

	WebDriver driver;
	@Test (dataProvider = "Credentials")
	public void OrangeHRM_Excel(String uName, String pName, String fName, String lName) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Chau\\Downloads\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://opensource.demo.orangehrmlive.com");
		
		driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys(uName);
		driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys(pName);
		driver.findElement(By.xpath("//input[@id='btnLogin']")).click();
		
		//click on PIM & Add Employee
		driver.findElement(By.id("menu_pim_viewPimModule")).click();
		driver.findElement(By.cssSelector("a[id='menu_pim_addEmployee']")).click();
				
		// add employee first, last names & middle name
		driver.findElement(By.xpath("//input[@id='firstName']")).sendKeys(fName);
		driver.findElement(By.xpath("//input[@id='lastName']")).sendKeys(lName);

		// save
		driver.findElement(By.id("btnSave")).click();
		
		//quit
		Thread.sleep(3000);
		driver.quit();
	}
	
	
		@DataProvider (name = "Credentials")
		public Object [][] testData() throws IOException {
			excelUtilityReview obj = new excelUtilityReview();
			obj.excelBook("C:\\Users\\Chau\\Desktop\\Book1.xlsx");
			
			int rows = obj.rowCount(0);
			int cells = obj.cellCount(0);
			
			//rows and cells are calculated automatically
			//so even if excel data changes, we won't need to change our code
			Object[][] data = new Object[rows][cells];
			
			for (int i = 0; i < rows; i++) {
			//add another For loop - holding cell	
				for (int y = 0; y < cells; y++) {
					//this will return a String
					String value = obj.excelData(0, i, y); 
					System.out.println(value);
					data [i][y] =value;
					
				}
			}
		
			return data;
	}
}
