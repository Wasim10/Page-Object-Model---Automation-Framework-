package testcases;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.BaseTest;
import pages.LoginPage;

public class LoginTest extends BaseTest {
	
	
	
	@Test

	void verifyLogin() {
		LoginPage Ip = new LoginPage(driver);
		String username =  "Demo12";
		String password = "Test123456$";
		
		Ip.loginToPortal(username, password);
	}
	
}
