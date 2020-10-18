package pageObjects.wordpress.admin;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sun.org.apache.xerces.internal.impl.xpath.XPath;

import commons.AbstractPage;
import commons.GlobalConstants;
import pageUI.wordpress.admin.MediaPageUI;

public class MediaPageObject extends AbstractPage{
	
	WebDriver driver;

	public MediaPageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	public String getHeaderSuccess(String locator) {
		waitForElementVisible(driver, locator);
		return getTextOfElement(driver, locator).trim();
	}

	public void inputMultiFile(String... fileName) {
		String filePath = GlobalConstants.USER_DIR + "\\uploadFile\\";
		String fullFilePath = "";
		for (String aName : fileName) {
			fullFilePath += filePath + aName + "\n";
		}
		System.out.println("=======fullFilePath====== " + fullFilePath);
		sendKeyToElement(driver, MediaPageUI.INPUT_FILE_LOCATOR, fullFilePath.trim());
		
		
	}

	public void waitForProgressbarInvisible() {
		System.out.println("=======MediaPageUI.PROGRESS_BAR_LOCATOR====== " + MediaPageUI.PROGRESS_BAR_LOCATOR);
		waitForElementsInvisible(driver, MediaPageUI.PROGRESS_BAR_LOCATOR);
		
	}

	private void waitForElementsInvisible(WebDriver driver2, String progressBarLocator) {
		explicitWait = new WebDriverWait(driver, GlobalConstants.LONG_TIMEOUT);
		List<WebElement> elements = driver.findElements(byXpath(progressBarLocator));
		explicitWait.until(ExpectedConditions.invisibilityOfAllElements(elements));
	}

	public Boolean VerifyUploadMultiFile(String... inputList) {
		List<String> outputList = new ArrayList<>();
		Integer fileSize = inputList.length;
		List<WebElement> outList = findElementsByXpath(driver, MediaPageUI.IMG_LOCATOR);
		int index = 1;
		for (WebElement element : outList) {
			outputList.add(element.getAttribute("src"));
			index ++;
			if(index == fileSize) {
				break;
			}
		}
		Boolean result = false;

		for (String inputPath: inputList) {
			String fileName = inputPath.split(".")[0].toLowerCase();
			System.out.println("========fileName ===" + fileName);
			
			for(int j=0 ; j< outputList.size(); j++) {
				String src = outputList.get(j);
				System.out.println("src===========" + src);
				
				//compare
				if(!src.contains(fileName)) {
					result = false;
					if(j == outputList.size() - 1) {
						return result;
					}
				} else {
					result = true;
					break;
				}
			}
		}
		return result;
		
	}

	public void clickToAddNewButton() {
		waitForElementVisible(driver, MediaPageUI.ADD_NEW_BUTTON);
		clickToElement(driver, MediaPageUI.ADD_NEW_BUTTON);
		
	}
	
	
}
