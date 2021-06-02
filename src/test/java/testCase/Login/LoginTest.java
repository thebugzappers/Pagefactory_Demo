package testCase.Login;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.page.LoginPage;
import com.testBase.TestBase;

public class LoginTest extends TestBase {

	LoginPage loginP;

	public LoginTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		getDriver();
		loginP = new LoginPage();
	}

	@Test
	public void verifyLoginWithCreadentials() throws InterruptedException {

		String username = prop.getProperty("AdminUname");
		System.out.println(username);
		String password = prop.getProperty("Adminpasswd");
		System.out.println(password);
		loginP.loginOperation(username, password);

	}



}
