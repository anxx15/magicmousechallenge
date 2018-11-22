package pageObjectsRepo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import testClassPackage.config;
import utility.Log;

public class ToolsQATransactionResultPage {
	public static WebElement element = null;
	private static By confirmationText = By.xpath("//*[contains(text(),'Thank you for purchasing with ONLINE STORE')]");
	private static By orderedQuantity = By.xpath("//table//tbody//td[3]");
	
	public static String confirmationText(WebDriver driver, WebDriverWait wait) {
		Log.info("Confirmation Text");
		return driver.findElement(confirmationText).getText();
   }
	
	public static String orderQuantity(WebDriver driver, WebDriverWait wait) {
		Log.info("Order Quantity");
		return driver.findElement(orderedQuantity).getText();
   }
	
}