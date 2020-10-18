package pageObjects.wordpress.admin;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;

public class CommentsPageObject extends AbstractPage{

	WebDriver driver;

	public CommentsPageObject(WebDriver driver) {
		this.driver = driver;
	}
	
}
