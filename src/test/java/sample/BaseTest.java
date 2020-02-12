package sample;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.page.LoginPage;
import com.qa.hubspot.util.Credentials;

public class BaseTest {
	WebDriver driver;
	BasePage basePage;
	Properties prop;
	LoginPage loginPage;
	Credentials userCred;

	@BeforeMethod
	@Parameters(value={"browser"})
	public void setUp(String browser) throws InterruptedException {
		String browserName = null;
		basePage = new BasePage();
		prop = basePage.init_properties();
		if (browser.equals(null)) {
			browserName = prop.getProperty("browser");
		} else {
			browserName = browser;
		}
		driver = basePage.init_driver(browserName);
		driver.get(prop.getProperty("url"));
		loginPage = new LoginPage(driver);
		userCred = new Credentials(prop.getProperty("username"), prop.getProperty("password"));
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
