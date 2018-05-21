package testNG_042618;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderExercise {
	
	@Test(dataProvider="credentials")
	public void practice(String username, String password, int age) {
		System.out.println("The username is " + username);
		System.out.println("The password is " + password);
		System.out.println("The age is " + age);
	}
	
	//we use Object b/c credentials may be a combination of String and int -- dimensional array

	@DataProvider(name="credentials")
	public Object[][] enterData() {
		//table has [2] rows and [3] columns
		/*	editor		|	Welcome1	|	20
		 * 	editor2		|	Welcome2	|	30
		 */	
	
		Object[][] data = new Object[2][3]; //create new instance of Object and provide size of array
	
		//index starts at 0, but size of table starts at 1
		
		data[0][0] = "editor";  //(at row 0 and column 0, the value is "editor")
		data[0][1] = "Welcome1";
		data[0][2] = 20;
		
		data[1][0] = "editor2";  
		data[1][1] = "Welcome2";
		data[1][2] = 30;
		
		return data;
	}
	
}
