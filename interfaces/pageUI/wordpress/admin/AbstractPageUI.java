package pageUI.wordpress.admin;

public class AbstractPageUI {
	
	public static final String DYNAMIC_MENU = "//span[text()='%s']";
	public static final String SITE_SUB_MENU = "//span[text()='Site']";
	public static final String MEDIA_SUB_MENU = "//span[text()='Media']";
	public static final String MY_SITE_SPAN = "//a[text()='Back to My Sites']";
	public static final String SETTINGS_MENU = "//span[text()='abc']";

	public static final String HEADER = "//h1[@class='formatted-header__title']";
	public static final String HEADER_MY_SITE = "//header/h1[contains(@class, 'formatted-header__title')]";
}
