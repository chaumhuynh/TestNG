package ReviewClass_043018;

import org.testng.annotations.Test;

public class arrayReview {

	@Test
	public void arrayTest() {
		String [] myArray = new String [3];
		myArray[0] = "Hello 1";
		myArray[1] = "Hello 2";
		myArray[2] = "Hello 3";
		
		for (int i = 0; i<myArray.length; i++ ) {
			System.out.println(myArray[i]);
		}
	}
}
