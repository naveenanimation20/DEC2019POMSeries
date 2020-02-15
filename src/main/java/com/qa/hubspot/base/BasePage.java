package com.qa.hubspot.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {

	// public WebDriver driver;
	public Properties prop;
	public static boolean highlighElement;
	public OptionsManager optionsManager;

	public static ThreadLocal<WebDriver> tldriver = new ThreadLocal<WebDriver>();

	public static synchronized WebDriver getDriver() {
		return tldriver.get();
	}

	public WebDriver init_driver(String browserName) {
		highlighElement = prop.getProperty("highlight").equals("yes") ? true : false;
		System.out.println("browser name is: " + browserName);
		optionsManager = new OptionsManager(prop);

		if (browserName.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			// driver = new ChromeDriver(optionsManager.getChromeOptions());
			tldriver.set(new ChromeDriver(optionsManager.getChromeOptions()));
		}

		else if (browserName.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			// driver = new FirefoxDriver(optionsManager.getFirefoxOptions());
			tldriver.set(new FirefoxDriver(optionsManager.getFirefoxOptions()));

		} else if (browserName.equals("safari")) {
			WebDriverManager.getInstance(SafariDriver.class).setup();
			// driver = new SafariDriver();
			tldriver.set(new SafariDriver());
		}

		else {
			System.out.println("browser Name " + browserName + " is not found, please pass the correct browser");
		}

		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().fullscreen();

		return getDriver();
	}

	public Properties init_properties() {
		prop = new Properties();
		String path = null;
		String env = null;

		try {
			env = System.getProperty("env");

			if (env.equals("qa")) {
				path = "./src/main/java/com/qa/hubspot/config/config.qa.properties";
			} else if (env.equals("stg")) {
				path = "./src/main/java/com/qa/hubspot/config/config.stg.properties";
			}
		} catch (Exception e) {
			path = "./src/main/java/com/qa/hubspot/config/config.properties";
		}

		try {
			FileInputStream ip = new FileInputStream(path);
			prop.load(ip);
		} catch (FileNotFoundException e) {
			System.out.println("some issue with config properties....Please correct your config...");
		} catch (IOException e) {
			e.printStackTrace();
		}

		return prop;
	}

	/**
	 * take screenshot
	 */

	public String getScreenshot() {

		File src = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir") + "/screenshots/" + System.currentTimeMillis() + ".png";
		File destination = new File(path);

		try {
			FileUtils.copyFile(src, destination);
		} catch (IOException e) {
			System.out.println("screenshot captured failed...");
		}

		return path;

	}

}
