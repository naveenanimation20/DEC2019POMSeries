package sample;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.hubspot.page.HomePage;

public class HomePageTest extends BaseTest {

	HomePage homePage;

	//@BeforeClass
	public void setup() {
		homePage = loginPage.doLogin(userCred);
	}

	@Test(priority = 1)
	public void verifyHomePageTitleTest() {
		setup();
		String title = homePage.getHomePageTitle();
		System.out.println("home page title is : " + title);
		Assert.assertEquals(title, "Reports dashboard");
	}

	@Test(priority = 2)
	public void verifyHomePageHeaderTest() {
		setup();
		String header = homePage.getHomePageHeader();
		System.out.println("home page header is : " + header);
		Assert.assertEquals(header, "Sales Dashboard");
	}

	@Test(priority = 3)
	public void verifyLoggedInUserTest() {
		setup();
		String accountName = homePage.getLoggedInUserAccountName();
		System.out.println("logged in account name : " + accountName);
		Assert.assertEquals(accountName, "crmpro");
	}

}
