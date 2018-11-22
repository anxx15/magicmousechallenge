
package pageObjectsRepo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import testClassPackage.config;
import utility.Log;

public class ToolsQAProductCategoryPage {
	public static WebElement element = null;
	private static By btnAddToCartMouse = By.xpath("//a[contains(text(),'Magic Mouse')]/../..//input[@value='Add To Cart']");
	
	public static void clickAddToCartMouse(WebDriver driver, WebDriverWait wait) {
		driver.findElement(btnAddToCartMouse).click();
		Log.info("Adding product to cart");
   }
	
}