package testNG_042618;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNG_Annotations {

	//Use all annotations and see in which order they run
	
	@BeforeSuite
	public void beforeSuiteAnnotation() {
		System.out.println("This is Before Suite annotation");
	}
		
	@AfterSuite
	public void afterSuiteAnnotation() {
		System.out.println("This is After Suite annotation");
	}
	
	@BeforeTest
	public void beforeTestAnnotation() {
		System.out.println("This is Before Test annotation");
	}
	
	@AfterTest
	public void afterTestAnnotation() {
		System.out.println("This is After Test annotation");
	}
	
	@BeforeClass
	public void beforeClassAnnotation() {
		System.out.println("This is Before Class annotation");
	}
	
	@AfterClass
	public void afterClassAnnotation() {
		System.out.println("This is After Class annotation");
	}
	
	@BeforeMethod
	public void beforeMethodAnnotation() {
		System.out.println("This is Before Method annotation");
	}
	
	@AfterMethod
	public void afterMethodAnnotation() {
		System.out.println("This is After Method annotation");
	}
	
	@Test
	public void testAnnotation1() {
		System.out.println("This is Test annotation 1");
	}
	
	@Test
	public void testAnnotation2() {
		System.out.println("This is Test annotation 2");
	}
	
	@Test
	public void testAnnotation3() {
		System.out.println("This is Test annotation 3");
	}
}
