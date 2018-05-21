package testNG_042818;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Parameter_OrangeHRM {
	@Test
	@Parameters({"username", "password", "firstName", "middleName", "lastName", "email", "contact", "comment"})
	public void param(String userID, String pass, String first, String middle, String last, String email, String contact, String comment) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Chau\\Downloads\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		//navigate to OrangeHRM
		driver.get("http://opensource.demo.orangehrmlive.com");
		
		//login
		driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys(userID);
		driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys(pass);
		driver.findElement(By.xpath("//input[@id='btnLogin']")).click();
		
		//add candidate and save
		driver.findElement(By.id("menu_recruitment_viewRecruitmentModule")).click();
		driver.findElement(By.id("btnAdd")).click();
		
		driver.findElement(By.id("addCandidate_firstName")).sendKeys(first);
		driver.findElement(By.id("addCandidate_middleName")).sendKeys(middle);
		driver.findElement(By.id("addCandidate_lastName")).sendKeys(last);
		driver.findElement(By.id("addCandidate_email")).sendKeys(email);
		driver.findElement(By.id("addCandidate_contactNo")).sendKeys(contact);
		driver.findElement(By.id("addCandidate_comment")).sendKeys(comment);
		
		driver.findElement(By.id("btnSave")).click();

		String URL = driver.getCurrentUrl();
		System.out.println("The current URL is: " + URL);
	}
}
