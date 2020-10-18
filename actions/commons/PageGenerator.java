package commons;

import org.openqa.selenium.WebDriver;

import pageObjects.wordpress.admin.CommentsPageObject;
import pageObjects.wordpress.admin.FeedbackPageObject;
import pageObjects.wordpress.admin.LoginPageObject;
import pageObjects.wordpress.admin.MediaPageObject;
import pageObjects.wordpress.admin.MySitePageObject;
import pageObjects.wordpress.admin.PagesPageObject;
import pageObjects.wordpress.admin.PostsPageObject;
import pageObjects.wordpress.admin.ReaderPageObject;
import pageObjects.wordpress.admin.NewEditPageObject;
import pageObjects.wordpress.admin.StatsPageObject;
import pageObjects.wordpress.admin.UploadFilePageObject;
import pageObjects.wordpress.admin.WelcomePageObject;
import pageObjects.wordpress.user.DetailPostPageObject;

public class PageGenerator {

	public static LoginPageObject getLoginPage(WebDriver driver) {
		return new LoginPageObject(driver);
	}
	
	public static ReaderPageObject getReaderPage(WebDriver driver) {
		return new ReaderPageObject(driver);
	}

	public static MediaPageObject getMediaPage(WebDriver driver) {
		return new MediaPageObject(driver);
	}

	public static MySitePageObject getMySitePage(WebDriver driver) {
		return new MySitePageObject(driver);
	}

	public static UploadFilePageObject getUploadPage(WebDriver driver) {
		return new UploadFilePageObject(driver);
	}

	public static PagesPageObject getPagesPage(WebDriver driver) {
		return new PagesPageObject(driver);
	}

	public static PostsPageObject getPostsPage(WebDriver driver) {
		return new PostsPageObject(driver);
	}
	public static NewEditPageObject getSitePage(WebDriver driver) {
		return new NewEditPageObject(driver);
	}
	public static StatsPageObject getStatsPage(WebDriver driver) {
		return new StatsPageObject(driver);
	}
	public static CommentsPageObject getCommentsPage(WebDriver driver) {
		return new CommentsPageObject(driver);
	}
	public static FeedbackPageObject getFeedbackPage(WebDriver driver) {
		return new FeedbackPageObject(driver);
	}

	public static WelcomePageObject getWelcomePage(WebDriver driver) {
		return new WelcomePageObject(driver);
	}
	
	public static DetailPostPageObject getDetailPostUserPage(WebDriver driver) {
		return new DetailPostPageObject(driver);
	}
}
