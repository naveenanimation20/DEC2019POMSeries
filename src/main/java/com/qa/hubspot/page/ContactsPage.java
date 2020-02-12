package com.qa.hubspot.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.util.ElementUtil;
import com.qa.hubspot.util.JavaScriptUtil;

import io.qameta.allure.Step;

public class ContactsPage extends BasePage {

	WebDriver driver;
	ElementUtil elementUtil;
	JavaScriptUtil jsUtil;

	By createContactButton = By.xpath("(//button[@type='button']//span[text()='Create contact'])[position()=1]");
	By createContactFormButton = By.xpath("(//button[@type='button']//span[text()='Create contact'])[position()=2]");

	By email = By.xpath("//input[@data-field='email']");
	By firstName = By.xpath("//input[@data-field='firstname']");
	By lastName = By.xpath("//input[@data-field='lastname']");
	By jobTitle = By.xpath("//input[@data-field='jobtitle']");

	public ContactsPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
		jsUtil = new JavaScriptUtil(driver);
		
	}

	public String getContactsPageTitle() {
		//jsUtil.checkPageIsReady();
		elementUtil.waitForTitlePresent("Contacts");
		return elementUtil.doGetPageTitle();
	}

	@Step("Create new contact with {0}, {1}, {2}, {3}")
	public void createNewContact(String mail, String FN, String LN, String jobtitle) {
		//Thread.sleep(5000);
		elementUtil.waitForElementPresent(createContactButton);
		elementUtil.doClick(createContactButton);

		elementUtil.waitForElementPresent(email);
		elementUtil.doSendKeys(email, mail);

		elementUtil.doSendKeys(firstName, FN);

		elementUtil.doSendKeys(lastName, LN);

		elementUtil.doSendKeys(jobTitle, jobtitle);

		//elementUtil.doClick(createContactFormButton);
		jsUtil.clickElementByJS(elementUtil.getElement(createContactFormButton));
		
	}

}
