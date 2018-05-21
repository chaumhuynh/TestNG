package testNG_042618;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Dependencies {
	public static WebDriver driver;

	@Test
	public void startBrowser() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Chau\\Downloads\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://opensource.demo.orangehrmlive.com");
	}
	
	//we can add description to each test (will show in index.html when paste into browser)
	@Test(dependsOnMethods="startBrowser", description = "This method provides login information")
	public void validCredentials() {
		driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@id='btnLogin']")).click();
	}
	
	@Test(dependsOnMethods="validCredentials")
	public void addContent() {
		//click on PIM & Add Employee
		driver.findElement(By.id("menu_pim_viewPimModule")).click();
		driver.findElement(By.cssSelector("a[id='menu_pim_addEmployee']")).click();
		
		//add employee first, last names & middle name
		driver.findElement(By.xpath("//input[@id='firstName']")).sendKeys("Chau");
		driver.findElement(By.xpath("//input[@id='middleName']")).sendKeys("Minh");
		driver.findElement(By.xpath("//input[@id='lastName']")).sendKeys("Huynh");
		
		//save
		driver.findElement(By.id("btnSave")).click();
	}
	
	@Test(dependsOnMethods="addContent")
	public void quitBrowser() {
		driver.quit();
	}
	
/* Using dependencies, we can run methods without setting priority or including/excluding
 * Methods will be run based on the order dependencies are set, not in alphabetical order
 * However, if one method fails, the next method that depends on it will not run	 */
	
	
}
