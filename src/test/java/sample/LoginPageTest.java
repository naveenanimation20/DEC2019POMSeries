package sample;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.hubspot.page.HomePage;

public class LoginPageTest extends BaseTest {

	@Test(priority = 1)
	public void verifyLoginPageTitleTest() throws InterruptedException {
		Thread.sleep(5000);
		String title = loginPage.getPageTitle();
		System.out.println("login page title is : " + title);
		Assert.assertEquals(title, "HubSpot Login");
	}

	@Test(priority = 2)
	public void verifySignUpLinkTest() {
		Assert.assertTrue(loginPage.checkSignUpLink());
	}

	@Test(priority = 3)
	public void loginTest() {
		HomePage homePage = loginPage.doLogin(userCred);
		String accountName = homePage.getLoggedInUserAccountName();
		Assert.assertEquals(accountName, "crmpro");
	}

}
