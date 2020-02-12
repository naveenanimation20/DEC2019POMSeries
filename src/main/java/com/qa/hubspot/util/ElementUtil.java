package com.qa.hubspot.util;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.hubspot.base.BasePage;

public class ElementUtil extends BasePage{

	WebDriver driver;
	WebDriverWait wait;
	JavaScriptUtil jsUtil;
	Properties prop;

	public ElementUtil(WebDriver driver) {
		prop = super.prop;
		this.driver = driver;
		wait = new WebDriverWait(driver, AppConstants.DEFAULT_TIME_OUT);
		jsUtil = new JavaScriptUtil(driver);
	}

	public boolean waitForTitlePresent(String title) {
		wait.until(ExpectedConditions.titleIs(title));
		return true;
	}

	public boolean waitForElementPresent(By locator) {
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		return true;
	}

	public boolean waitForElementVisible(By locator) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		return true;
	}

	public String doGetPageTitle() {
		try {
			return driver.getTitle();
		} catch (Exception e) {
			System.out.println("some exception got occurred while getting the title.....");
		}
		return null;
	}

	/**
	 * this method is used to create the webelement on the basis of By locator
	 * 
	 * @param locator
	 * @return element
	 */
	public WebElement getElement(By locator) {
		WebElement element = null;
		try {
				
			// if(waitForElementPresent(locator));
			element = driver.findElement(locator);
			if(highlighElement){
				jsUtil.flash(element);
			}
			
		} catch (Exception e) {
			System.out.println("some exception got occurred while creating the web element.....");
		}
		return element;
	}

	public void doClick(By locator) {
		try {
			getElement(locator).click();
		} catch (Exception e) {
			System.out.println("some exception got occurred while clicking on the web element.....");

		}
	}
	
	
	public void doActionClick(By locator){
		try {
			WebElement ele = getElement(locator);
			Actions action = new Actions(driver);
			action.click(ele);
		} catch (Exception e) {
			System.out.println("some exception got occurred while clicking on the web element.....");

		}
	}
	
	
	public void doActionSendKeys(By locator, String value){
		try {
			WebElement ele = getElement(locator);
			Actions action = new Actions(driver);
			action.sendKeys(ele, value);
		} catch (Exception e) {
			System.out.println("some exception got occurred while clicking on the web element.....");

		}
	}

	public void doSendKeys(By locator, String value) {
		try {
			//wait visible
			WebElement ele = getElement(locator);
			ele.clear();
			ele.sendKeys(value);
		} catch (Exception e) {
			System.out.println("some exception got occurred while entering value in a field.....");

		}
	}

	public boolean doIsDisplayed(By locator) {
		try {
			waitForElementPresent(locator);
			return getElement(locator).isDisplayed();
		} catch (Exception e) {
			System.out.println("some exception got occurred.....");
		}
		return false;
	}

	public String doGetText(By locator) {
		try {
			waitForElementPresent(locator);
			return getElement(locator).getText();
		} catch (Exception e) {
			System.out.println("some exception got occurred while getting the text from a webelement.....");
		}
		return null;
	}

}
