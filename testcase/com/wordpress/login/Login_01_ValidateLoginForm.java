package com.wordpress.login;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.AbstractTest;
import pageObjects.wordpress.admin.LoginPageObject;
import pageObjects.wordpress.admin.ReaderPageObject;

public class Login_01_ValidateLoginForm extends AbstractTest {
	WebDriver driver;
	LoginPageObject loginPage;
	ReaderPageObject dashboardPage;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
	}

	@BeforeMethod
	public void beforeMethod() {
		driver.get("https://wordpress.com/log-in?redirect_to=https%3A%2F%2Fwordpress.com%2Fstart%2Fdomains");
	}

	@AfterClass
	public void afterClass() {
//		 driver.quit();
	}

	public void TC_01_fillEmptyEmail() {
		loginPage = new LoginPageObject(driver);
		loginPage.sendEmailOrUsername("");
		loginPage.clickToContinueButton();
		Assert.assertEquals(loginPage.getErrorMsg(), "Please enter a username or email address.");
	}

	public void TC_02_fillWrongFormatEmail() {
		loginPage = new LoginPageObject(driver);
		loginPage.sendEmailOrUsername("123@123.com");
		loginPage.clickToContinueButton();
		Assert.assertEquals(loginPage.getErrorMsg(),
				"Please log in using your WordPress.com username instead of your email address.");
	}

	public void TC_03_fillRightEmailAndInvalidPass() {
		loginPage = new LoginPageObject(driver);
		loginPage.sendEmailOrUsername("abc123@gmail.com");
		loginPage.clickToContinueButton();
		loginPage.sendPassword("");
		loginPage.clickToContinueButton();
		Assert.assertEquals(loginPage.getErrorMsg(), "Don't forget to enter your password.");
	}

	public void TC_04_fillRightEmailAndWrongPass() {
		loginPage = new LoginPageObject(driver);
		loginPage.sendEmailOrUsername("abc123@gmail.com");
		loginPage.clickToContinueButton();
		loginPage.sendPassword("123");
		loginPage.clickToContinueButton();
		Assert.assertEquals(loginPage.getErrorMsg(), "Oops, that's not the right password. Please try again!");
	}

	@Test
	public void TC_05_LoginSuccessAndGoToDashboard() {
		loginPage = new LoginPageObject(driver);
		loginPage.sendEmailOrUsername("automationeditor");
		loginPage.clickToContinueButton();
		loginPage.sendPassword("automationfc");
		loginPage.clickToContinueButton();

		dashboardPage = new ReaderPageObject(driver);
		Assert.assertEquals(dashboardPage.getDashboardHeaderSuccess(), "Let's get your site a domain!");
	}
}
