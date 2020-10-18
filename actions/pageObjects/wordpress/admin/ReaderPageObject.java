package pageObjects.wordpress.admin;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUI.wordpress.admin.ReaderPageUI;

public class ReaderPageObject extends AbstractPage{
	
	WebDriver driver;

	public ReaderPageObject(WebDriver driver) {
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

}
