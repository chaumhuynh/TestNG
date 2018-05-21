package testNG_042818;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataDrivenWeb {

	@Test (dataProvider = "Credentials")
	public void appLogin(String username, String password) {
		System.out.println("My username is " + username);
		System.out.println("My password is " + password);
	}
	
	@DataProvider(name="Credentials")
	public Object[][] credentialsData() {
		ExcelData config = new ExcelData ("C:\\Users\\Chau\\.eclipse\\SampleCredentials.xlsx");
		int rows = config.getRowCount(0);
		Object[][] data = new Object[rows][2];
		for (int i = 0; i < rows; i++) {
			data[i][0] = config.getData(0, i, 0);
			data[i][1] = config.getData(0, i, 1);
			
		}
		return data;
	}
}
