package pageObjects.wordpress.admin;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUI.wordpress.admin.AbstractPageUI;
import pageUI.wordpress.admin.ReaderPageUI;
import pageUI.wordpress.admin.WelcomePageUI;

public class WelcomePageObject extends AbstractPage{
	
	WebDriver driver;

	public WelcomePageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	public String getHeaderSuccess() {
		waitForElementVisible(driver, ReaderPageUI.HEADER_READER_PAGE);
		return getTextOfElement(driver, ReaderPageUI.HEADER_READER_PAGE).trim();
	}
	
	public String getDashboardHeaderSuccess() {
		waitForElementVisible(driver, ReaderPageUI.HEADER_DASHBOARD_PAGE);
		return getTextOfElement(driver, ReaderPageUI.HEADER_DASHBOARD_PAGE).trim();
	}

	public void backToMySite() {
		waitForElementVisible(driver, AbstractPageUI.MY_SITE_SPAN);
		clickToElement(driver, AbstractPageUI.MY_SITE_SPAN);
		
	}
}
