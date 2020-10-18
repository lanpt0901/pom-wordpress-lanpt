package com.wordpress.media;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import BrowserFactory.DriverManager;
import BrowserFactory.DriverManagerFactory;
import commons.GlobalConstants;
import commons.PageGenerator;
import pageObjects.wordpress.admin.LoginPageObject;
import pageObjects.wordpress.admin.MediaPageObject;
import pageObjects.wordpress.admin.MySitePageObject;
import pageObjects.wordpress.admin.ReaderPageObject;
import pageObjects.wordpress.admin.UploadFilePageObject;

public class Media_01_uploadFile {

	private WebDriver driver;
	private DriverManager driverManager;
	private MediaPageObject mediaPage;
	private String file1 = "abc2.jpg";
	private String file2 = "ip72.jpg";
	private String file3 = "lukaku.jpg";
	
	@BeforeClass
	@Parameters("browser")
	public void beforeClass(String browserName) {
		driverManager = DriverManagerFactory.getBrowser(browserName);
		driver = driverManager.getDriver(GlobalConstants.WORPRESS_URL);
	}

	@AfterClass
	public void afterClass() {
		//driver.quit();
	}
	
	
	public void TC_01_LoginSuccessAndGoToDashboard() {
		LoginPageObject loginPage = new LoginPageObject(driver);
		loginPage.sendEmailOrUsername("lanpt2011");
		loginPage.clickToContinueButton();
		loginPage.sendPassword("Noidinao890");
		loginPage.clickToContinueButton();

		ReaderPageObject dashboardPage = new ReaderPageObject(driver);
		Assert.assertEquals(dashboardPage.getDashboardHeaderSuccess(), "Let's get your site a domain!");
		
		MySitePageObject mySitePage = PageGenerator.getMySitePage(driver);
		Assert.assertEquals(mySitePage.getHeaderSuccess(driver), "My Home");
		mySitePage.clickToMoreSubDynamicPageMenu(driver, "Site", "Media");
		mediaPage = PageGenerator.getMediaPage(driver);
		
	}
	@Test
	public void TC_01_LoginSuccessAndGoToDashboardFC() {
		LoginPageObject loginPage = new LoginPageObject(driver);
		loginPage.sendEmailOrUsername("automationeditor");
		loginPage.clickToContinueButton();
		loginPage.sendPassword("automationfc");
		loginPage.clickToContinueButton();

		ReaderPageObject dashboardPage = new ReaderPageObject(driver);
		Assert.assertEquals(dashboardPage.getDashboardHeaderSuccess(), "Let's get your site a domain!");
		
		MySitePageObject mySitePage = PageGenerator.getMySitePage(driver);
		Assert.assertEquals(mySitePage.getHeaderSuccess(driver), "Stats and Insights");
		mediaPage = (MediaPageObject) mySitePage.clickToMoreSubDynamicPageMenu(driver, "Site", "Media");
		
	}
	@Test
	public void TC_02_uploadMultipleFile() {
		//after login by TC_01
		//mediaPage.clickToAddNewButton();
		mediaPage.inputMultiFile(file1, file2, file3);
		mediaPage.waitForProgressbarInvisible();
		mediaPage.VerifyUploadMultiFile(file1, file2, file3);
		
	}
}
