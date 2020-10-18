package com.wordpress.login;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import BrowserFactory.DriverManager;
import BrowserFactory.DriverManagerFactory;
import commons.AbstractTest;
import commons.GlobalConstants;
import pageObjects.wordpress.admin.LoginPageObject;
import pageObjects.wordpress.admin.ReaderPageObject;

public class Login_03_BrowserFactoryPattern extends AbstractTest {
	WebDriver driver;
	DriverManager driverManger;
	LoginPageObject loginPage;
	ReaderPageObject dashboardPage;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driverManger = DriverManagerFactory.getBrowser(browserName);
		driver = driverManger.getDriver(GlobalConstants.WORPRESS_URL);
	}

	@AfterClass
	public void afterClass() {
//		driverManger.quitDriver();
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
