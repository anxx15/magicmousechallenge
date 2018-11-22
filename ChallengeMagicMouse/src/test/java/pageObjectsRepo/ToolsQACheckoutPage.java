package pageObjectsRepo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import utility.Log;

public class ToolsQACheckoutPage {
	public static WebElement element = null;
	private static By textQuantity = By.xpath("//em[@class='count']");
	private static By btnContinue = By.xpath("//*[contains(text(),'Continue')]");
	private static By checkBoxShippingSameBilling = By.id("shippingSameBilling");
	private static By email = By.xpath("//input[@title='billingemail']");
	private static By firstName = By.xpath("//input[@title='billingfirstname']");
	private static By lastName = By.xpath("//input[@title='billinglastname']");
	private static By address = By.xpath("//textarea[@title='billingaddress']");
	private static By city = By.xpath("//input[@title='billingcity']");
	private static By state = By.xpath("//input[@title='billingstate']");
	private static By phone = By.xpath("//input[@title='billingphone']");
	private static By country = By.xpath("//select[@title='billingcountry']");
	private static By btnPurchase = By.xpath("//input[@class='make_purchase wpsc_buy_button']");
	
	public static String getQuantity(WebDriver driver, WebDriverWait wait) {
		return driver.findElement(textQuantity).getText();
	}
	
	public static void clickContinue(WebDriver driver, WebDriverWait wait){
		driver.findElement(btnContinue).click();
		Log.info("Continue to checkout");
	}
	public static void clickCheckBoxShippingSameBilling(WebDriver driver, WebDriverWait wait){
		driver.findElement(checkBoxShippingSameBilling).click();
		Log.info("Checkbox for billing and shipping same address");
	}
	
	public static WebElement email(WebDriver driver, WebDriverWait wait ) {
		Log.info("Enter user email");
		return driver.findElement(email);
	}
	
	public static WebElement fname(WebDriver driver, WebDriverWait wait) {
		Log.info("Enter user first name");
		return driver.findElement(firstName);
	}
	
	public static WebElement lname(WebDriver driver, WebDriverWait wait) {
		Log.info("Enter user last name");
		return driver.findElement(lastName);
	}
	
	public static WebElement address(WebDriver driver, WebDriverWait wait) {
		Log.info("Enter user address");
		return driver.findElement(address);
	}
	
	public static WebElement city(WebDriver driver, WebDriverWait wait) {
		Log.info("Enter user city");
		return driver.findElement(city);
	}
	
	public static WebElement state(WebDriver driver, WebDriverWait wait) {
		Log.info("Enter user state");
		return driver.findElement(state);
	}
	
	public static WebElement phone(WebDriver driver, WebDriverWait wait) {
		Log.info("Enter user phone number");
		return driver.findElement(phone);
	}
	
	public static Select country(WebDriver driver, WebDriverWait wait) {
		Log.info("Select user country");
		return new Select(driver.findElement(country));
	}
	
	public static void clickPurchase(WebDriver driver, WebDriverWait wait){
		driver.findElement(btnPurchase).click();
		Log.info("Complete purchase");
	}
}