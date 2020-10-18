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

public class Login_05_Assert_Verify extends AbstractTest{

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
		LoginPageObject loginPage = new LoginPageObject(driver);
		loginPage.sendEmailOrUsername("lanpt2011");
		loginPage.clickToContinueButton();
		loginPage.sendPassword("Noidinao890");
		loginPage.clickToContinueButton();

		ReaderPageObject dashboardPage = new ReaderPageObject(driver);
		Assert.assertEquals(dashboardPage.getDashboardHeaderSuccess(), "Let's get your site a domain!");
		
		mySitePage = PageGenerator.getMySitePage(driver);
	}
	
	@Test
	public void TC_01_LoginSuccessAndGoToDashboardFC() {
		LoginPageObject loginPage = new LoginPageObject(driver);
		loginPage.sendEmailOrUsername("automationeditor");
		loginPage.clickToContinueButton();
		loginPage.sendPassword("automationfc");
		loginPage.clickToContinueButton();

		ReaderPageObject readerPage = new ReaderPageObject(driver);
		mySitePage = PageGenerator.getMySitePage(driver);
		mySitePage.sleepInSecond(2);
		verifyEquals(mySitePage.getHeaderSuccess(driver), "Stats and Insights");
	}
	
	@Test
	public void TC_02_Element_Displayed_In_DOM() {
		mySitePage.sleepInSecond(2);
		System.out.println("Start check sub menu displayed in dom Start: " + mySitePage.getDateNow());
		verifyFalse(mySitePage.isSubmenuDisplayed("Stats"));
		System.out.println("Start check sub menu displayed in dom Start: " + mySitePage.getDateNow());
	}
	
	@Test
	public void TC_03_Element_Undisplayed_Not_In_DOM() {
		System.out.println("Start check sub menu undisplayed in dom Start: " + mySitePage.getDateNow());
		verifyFalse(mySitePage.isMediaSubMenuUnDisplayed());
		System.out.println("Start check sub menu undisplayed in dom End: " + mySitePage.getDateNow());
		
		System.out.println("Start check menu undisplayed not in dom Start: " + mySitePage.getDateNow());
		verifyFalse(mySitePage.isSettingsMenuUnDisplayed());
		System.out.println("Start check menu undisplayed not in dom End: " + mySitePage.getDateNow());
		
		
	}
}
