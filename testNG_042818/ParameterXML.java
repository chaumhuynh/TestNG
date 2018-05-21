package testNG_042818;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParameterXML {

	@Test
	@Parameters({"username", "password"})
	public void param(String userID, String pass) {
		System.out.println("The username is: " + userID);
		System.out.println("The password is: " + pass);
	}
}
