package BrowserFactory;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ChromeDriverManager extends DriverManager{

	@Override
	public void createBrowser() {
		WebDriverManager.chromedriver().setup();
		DesiredCapabilities capacities = new DesiredCapabilities().chrome();
		ChromeOptions options = new ChromeOptions();
//		options.addArguments("--incognito"); // chay voi tab ẩn danh private
		capacities.setCapability(ChromeOptions.CAPABILITY, options);
		driver = new ChromeDriver();
	}

}
