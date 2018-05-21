package testNG_1stClass;

import org.testng.annotations.Test;

public class TestNG_practice {

	//annotation (before importing Test class, code won't run because there is no main method)
	@Test
	public void sum() {
		int a = 10;
		int b = 5;
		int c = a + b;
		System.out.println("Sum of a and b is " + c);
		
	}
	@Test
	public void sub() {
		int a = 10;
		int b = 5;
		int c = a - b;
		System.out.println("Subtraction of a and b is " + c);
	}
	@Test
	public void mul() {
		int a = 10;
		int b = 5;
		int c = a * b;
		System.out.println("Multiplication of a and b is " + c);
	}
	@Test
	public void div() {
		int a = 10;
		int b = 5;
		int c = a / b;
		System.out.println("Division of a and b is " + c);
	}
	
}
