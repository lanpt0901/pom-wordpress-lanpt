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
import commons.PageGenerator;
import pageObjects.wordpress.admin.LoginPageObject;
import pageObjects.wordpress.admin.MySitePageObject;
import pageObjects.wordpress.admin.ReaderPageObject;

public class Login_06_Log4j extends AbstractTest{

	private WebDriver driver;
	private DriverManager driverManager;
	private MySitePageObject mySitePage;
	
	@BeforeClass
	@Parameters("browser")
	public void beforeClass(String browserName) {
		driverManager = DriverManagerFactory.getBrowser(browserName);
		driver = driverManager.getDriver(GlobalConstants.WORPRESS_URL);
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
	
	
	public void TC_01_LoginSuccessAndGoToDashboard() {
		log.info("Login - Step 01: Open login page");
		LoginPageObject loginPage = new LoginPageObject(driver);
		log.info("Login- Step 02: Send Email or Username: lanpt2011 acc");
		loginPage.sendEmailOrUsername("lanpt2011");
		log.info("Login - Step 03: click to ContinueButton");
		loginPage.clickToContinueButton();
		log.info("Login - Step 04: Send password");
		loginPage.sendPassword("Noidinao890");
		loginPage.clickToContinueButton();

		log.info("Login - Step 05: Open Reader page - the first page");
		ReaderPageObject dashboardPage = new ReaderPageObject(driver);
		Assert.assertEquals(dashboardPage.getDashboardHeaderSuccess(), "Let's get your site a domain!");

		log.info("Login - Step 06: Go to My Site page");
		mySitePage = PageGenerator.getMySitePage(driver);
	}
	
	@Test
	public void TC_01_LoginSuccessAndGoToDashboardFC() {
		log.info("Login - Step 06: Go to My Site page");
		LoginPageObject loginPage = new LoginPageObject(driver);
		log.info("Login- Step 02: Send Email or Username: automationeditor acc");
		loginPage.sendEmailOrUsername("automationeditor");
		log.info("Login - Step 03: click to ContinueButton");
		loginPage.clickToContinueButton();
		log.info("Login - Step 04: Send password");
		loginPage.sendPassword("automationfc");
		loginPage.clickToContinueButton();

		log.info("Login - Step 05: Open Reader page - the first page");
		ReaderPageObject readerPage = new ReaderPageObject(driver);
		mySitePage = PageGenerator.getMySitePage(driver);
		mySitePage.sleepInSecond(2);
		log.info("Login - Step 06: Go to My Site page");
		verifyEquals(mySitePage.getHeaderSuccess(driver), "Stats and Insights");
	}
	
	@Test
	public void TC_02_Element_Displayed_In_DOM() {
		mySitePage.sleepInSecond(2);
		log.info("Element displayed - Step 01: check sub menu displayed in dom");
		verifyFalse(mySitePage.isSubmenuDisplayed("Stats"));
	}
	
	@Test
	public void TC_03_Element_Undisplayed_Not_In_DOM() {
		log.info("Element undisplayed - Step 01: check media sub menu displayed in dom");
		verifyFalse(mySitePage.isMediaSubMenuUnDisplayed());
		log.info("Element undisplayed - Step 02: check settings sub menu displayed in dom");
		verifyFalse(mySitePage.isSettingsMenuUnDisplayed());
	}
}
