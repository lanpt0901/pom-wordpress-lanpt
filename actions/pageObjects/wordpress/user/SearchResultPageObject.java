package pageObjects.wordpress.user;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;

public class SearchResultPageObject extends AbstractPage{

	WebDriver driver;

	public SearchResultPageObject(WebDriver driver) {
		this.driver = driver;
	}
	
}
