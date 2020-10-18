package pageObjects.wordpress.admin;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;

public class PagesPageObject extends AbstractPage{

	WebDriver driver;

	public PagesPageObject(WebDriver driver) {
		this.driver = driver;
	}
	
}
