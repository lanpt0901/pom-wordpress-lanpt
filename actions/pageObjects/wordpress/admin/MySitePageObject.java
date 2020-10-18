package pageObjects.wordpress.admin;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUI.wordpress.admin.AbstractPageUI;

public class MySitePageObject extends AbstractPage{
	
	WebDriver driver;

	public MySitePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isSubmenuDisplayed(String... locator) {
		waitForElementVisible(driver, AbstractPageUI.DYNAMIC_MENU, locator);
		return isElementDisplayed(driver, AbstractPageUI.DYNAMIC_MENU, locator);
	}
	
	public boolean isSubmenuUnDisplayed(String locator, String... values) {
		return isElementUnDisplayed(driver, AbstractPageUI.DYNAMIC_MENU, values);
	}

	public boolean isMediaSubMenuUnDisplayed() {
		return isElementUnDisplayed(driver, AbstractPageUI.MEDIA_SUB_MENU);
	}

	public boolean isSettingsMenuUnDisplayed() {
		return isElementUnDisplayed(driver, AbstractPageUI.SETTINGS_MENU);
	}
	
}
