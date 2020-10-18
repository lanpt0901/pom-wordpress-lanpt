package pageObjects.wordpress.admin;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUI.wordpress.admin.LoginPageUI;

public class LoginPageObject extends AbstractPage{
	WebDriver driver;

	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void sendEmailOrUsername(String string) {
		waitForElementVisible(driver, LoginPageUI.EMAIL_OR_USERNAME_TEXTBOX);
		sendKeyToElement(driver, LoginPageUI.EMAIL_OR_USERNAME_TEXTBOX, string);
		
	}

	public void clickToContinueButton() {
		clickToElement(driver, LoginPageUI.CONTINUE_BUTTON);
	}

	public String getErrorMsg() {
		waitForElementVisible(driver, LoginPageUI.ERROR_MSG);
		return getTextOfElement(driver, LoginPageUI.ERROR_MSG).trim();
	}

	public void sendPassword(String string) {
		waitForElementVisible(driver, LoginPageUI.PASSWORD);
		sendKeyToElement(driver, LoginPageUI.PASSWORD, string);
		
	}

}
