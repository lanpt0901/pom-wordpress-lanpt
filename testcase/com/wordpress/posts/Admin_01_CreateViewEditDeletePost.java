package com.wordpress.posts;

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
import pageObjects.wordpress.admin.PostsPageObject;
import pageObjects.wordpress.admin.WelcomePageObject;
import pageObjects.wordpress.user.DetailPostPageObject;

public class Admin_01_CreateViewEditDeletePost extends AbstractTest{

	private DriverManager driverManager;
	private WebDriver driver;
	private PostsPageObject postsPage;
	

	@BeforeClass
	@Parameters("browser")
	public void beforeClass(String browserName) {
		driverManager = DriverManagerFactory.getBrowser(browserName);
		driver = driverManager.getDriver(GlobalConstants.WORPRESS_URL);
		LoginPageObject loginPage = new LoginPageObject(driver);
		loginPage.sendEmailOrUsername(GlobalConstants.WORDPRESS_USERNAME_LANPT);
		loginPage.clickToContinueButton();
		loginPage.sendPassword(GlobalConstants.WORDPRESS_PASSWORD_LANPT);
		loginPage.clickToContinueButton();

		WelcomePageObject welcomePage = PageGenerator.getWelcomePage(driver);
		Assert.assertEquals(welcomePage.getDashboardHeaderSuccess(), "Let's get your site a domain!");
		welcomePage.backToMySite();
		
		MySitePageObject mySitePage = (MySitePageObject) welcomePage.clickToMoreSubDynamicPageMenu(driver, "My Site", null);
		Assert.assertEquals(mySitePage.getHeaderSuccess(driver), "Stats and Insights");
		mySitePage.openPageByClickMenu(driver, "Site", "Posts");
		postsPage = PageGenerator.getPostsPage(driver);
		Assert.assertEquals(postsPage.getHeaderSuccess(driver), "Posts");
	}

	@AfterClass(alwaysRun=true)
	public void afterClass() {
		closeBrowserAndDriver(driver);
//		driver.quit();
	}

	private String newTitle = "[LanPT] New_Post_20201013";
	private String newContent = "New post content is PHỤ NỮ LÀ ĐỂ YÊU - QUÀ VÀ HOA NGẬP LỐI ❤️\n" + 
			"❌ SALE UPTO 50% TOÀN BỘ SẢN PHẨM ❌\n" + 
			"💗  Hãy dành tất cả sự yêu thương,kính trọng tới những người phụ nữ quan trọng nhất đời mình. Đừng tiếc trao tặng một lời nói yêu thương, một cái ôm ấm áp và một món quà xinh xắn để bày tỏ tình cảm tới một nửa thế giới.\n" + 
			"👉 Để chuẩn bị cho ĐẠI TIỆC  sale lần này PAZZION đã huy động HÀNG NGÀN sản phẩm ĐẸP- ĐỘC- CHẤT, sale UP TO 50% chắc chắn sẽ không làm các bạn thất vọng.\n" + 
			"🔥SALE 20% các sản phẩm trong BST mới\n" + 
			"🔥 SALE 30% toàn bộ sản phẩm còn lại\n" + 
			"🔥 SALE 50% KID_SHOES và giày lẻ size\n" + 
			"📛📛 Comment (.) ngay cho Page để nhận list sản phẩm ĐỒNG GIÁ từ 499k \n" + 
			"🎁 ĐẶC BIỆT: Tặng ví son cao cấp cho đơn hàng trên 2.000.000\n" + 
			"🔖 Áp dụng khi mua tại cửa hàng và online.\n" + 
			"🔖 Chương trình diễn ra từ ngày 11/10/2020 - 20/10/2020";
	private String newCategory = "LanPT new Category";
	private String newTag = "LanPT new tag";
	private DetailPostPageObject detailPostUserPage;
	@Test
	public void TC_01_CreateNewPost_AtAdminPage() {
		//create new post at admin page and then, verify new created page
		//Search Post at admin page
		//View page at admin page
		//Go detail page at user page
		//Search post at user page
		postsPage.clickNewPostButton();
		postsPage.addTitle(newTitle);
		postsPage.clickAddBlockButtonInHeader();
		postsPage.switchToFrame();
		postsPage.fillToSearchInAddBlock("image");
		postsPage.clickToImageInAddBlock();
		postsPage.uploadImage();
		postsPage.fillContent();
		postsPage.clickToSettingIcon();
		postsPage.clickToPostSetting();
		postsPage.scrollToAddNewCategory();
		postsPage.clickToAddNewCategoryLink();
		postsPage.fillNewCategory(newCategory);
		postsPage.clickToAddNewTags();
		postsPage.fillNewTag(newTag);
		postsPage.closeSettingBlock();
		postsPage.clickToPublishIcon();
		postsPage.publishNewPost();
		postsPage.openCreatedPost();
		detailPostUserPage = PageGenerator.getDetailPostUserPage(driver);
		
		////div[contains(@class,'main')]/iframe
		
		
		
		
		
	}
	
	@Test
	public void TC_01_EditPost_AtAdminPage() {
		//Search post at admin page
		//click to edit icon to edit post
		//fill infor to edit post and save
		//Search Post at admin page
		//View page at admin page
		//Go detail page at user page
		//Search post at user page
		
		
	}
	
}
