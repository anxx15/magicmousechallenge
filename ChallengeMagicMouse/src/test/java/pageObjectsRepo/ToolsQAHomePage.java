package pageObjectsRepo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import utility.Log;

public class ToolsQAHomePage {
	public static WebElement element = null;
	private static By linkProductCat = By.linkText("Product Category");
	private static By linkAccessories = By.linkText("Accessories");
	private static By linkCheckout = By.xpath("//a[@title='Checkout']");
	
	public static void clickProductCategoryTab(WebDriver driver, WebDriverWait wait) {
//		WebElement ele = driver.findElement(linkProductCat);
//		Actions actions = new Actions(driver);
//		actions.moveToElement(ele).build().perform();
		driver.findElement(linkProductCat).click();
		Log.info("Move mouse to Product/Accessories");
   }
	
	public static void clickAccessories(WebDriver driver, WebDriverWait wait) {
//		WebElement ele = driver.findElement(linkAccessories);
//		Actions actions = new Actions(driver);
//		actions.moveToElement(ele).build().perform();
//		actions.click();
   }
	public static void clickCheckout(WebDriver driver, WebDriverWait wait) {
		driver.findElement(linkCheckout).click();
		Log.info("Click on checkout");
   }
}