package testClassPackage;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjectsRepo.ToolsQACheckoutPage;
import pageObjectsRepo.ToolsQAHomePage;
import pageObjectsRepo.ToolsQAProductCategoryPage;
import pageObjectsRepo.ToolsQATransactionResultPage;
import utility.Log;

public class TestClass extends config {
	public static WebElement element = null;
	String appUrl;
	
	@Test (priority = 1)
	public void testStep1(){
		Log.startTestCase("STEP 1: Go to http://store.demoqa.com/");
		try {
			Log.info("Launch http://store.demoqa.com/");
//			System.out.println("STEP 1: Go to http://store.demoqa.com/");
			appUrl = "http://store.demoqa.com/";
			driver.navigate().to(appUrl);
			WebDriverWait wait = new WebDriverWait(driver, 15);
			wait.until(ExpectedConditions.titleContains("Toolsqa Dummy Test site"));
			System.out.println("Title-->>"+driver.getTitle());
			Log.info("Home page loaded with title"+driver.getTitle());
		} catch (Exception e) {
			Log.error("Error while in Step 1");
		}
		finally {
	  		Log.endTestCase("STEP 1");
	  	}
	}
	
	@Test (priority = 2)
	public void testStep2() throws Exception{
		Log.startTestCase("STEP 2: Go to Product category and select Accessories");
		try {
			Log.info("Going to Accessories page");
//			System.out.println("");
			ToolsQAHomePage.clickProductCategoryTab(driver, wait);
//		Thread.sleep(10000);
		} catch (Exception e) {
			Log.error("Error while in Step 2");
		}
		finally {
	  		Log.endTestCase("STEP 2");
	  	}
	}
	
	@Test (priority = 3)
	public void testStep3() throws Exception{
		Log.startTestCase("STEP 3: Click on “Add to Cart” for just Magic Mouse");
		try {
			Log.info("Clicking Add to Cart Button");
//			System.out.println("STEP 3: Click on “Add to Cart” for just Magic Mouse");
			ToolsQAProductCategoryPage.clickAddToCartMouse(driver, wait);
//		Thread.sleep(10000);
		} catch (Exception e) {
			Log.error("Error while in Step 3");
		}
		finally {
	  		Log.endTestCase("STEP 3");
	  	}
	}

	@Test (priority = 4)
	public void testStep4(){
		Log.startTestCase("STEP 4: Click on “Checkout” and confirm you have 1 Magic Mouse in your Check-Out Page");
		try {
			Log.info("Verifying Checkout page");
//			System.out.println("");
			ToolsQAHomePage.clickCheckout(driver, wait);
			String actualQty = ToolsQACheckoutPage.getQuantity(driver, wait);
			Assert.assertEquals(actualQty, "1", "1 Magic Mouse");
		} catch (Exception e) {
			Log.error("Error while in Step 4");
		}
		finally {
	  		Log.endTestCase("STEP 4");
	  	}
	}
	
	@Test (priority = 5)
	public void testStep5() throws Exception{
		Log.startTestCase("STEP 5: After confirming, click on Continue");
		try {
			Log.info("Clicking on Continue Button");
			ToolsQACheckoutPage.clickContinue(driver, wait);
//		Thread.sleep(10000);
		} catch (Exception e) {
			Log.error("Error while in Step 5");
		}
		finally {
	  		Log.endTestCase("STEP 5");
	  	}
	}
	
	@Test (priority = 6)
	public void testStep6() throws Exception{
		Log.startTestCase("STEP 6: Enter test (dummy) data needed for email, billing/contact details and click Purchase");
		try {
			Log.info("Entering on Billing User Data");
			ToolsQACheckoutPage.clickCheckBoxShippingSameBilling(driver, wait);
			ToolsQACheckoutPage.email(driver, wait).sendKeys(utility.TestData.User_Email);		
			ToolsQACheckoutPage.email(driver, wait).sendKeys(Keys.TAB);
			ToolsQACheckoutPage.fname(driver, wait).sendKeys(utility.TestData.User_First_Name);
			ToolsQACheckoutPage.fname(driver, wait).sendKeys(Keys.TAB);
			ToolsQACheckoutPage.lname(driver, wait).sendKeys(utility.TestData.User_Last_Name);
			ToolsQACheckoutPage.lname(driver, wait).sendKeys(Keys.TAB);
			ToolsQACheckoutPage.address(driver, wait).sendKeys(utility.TestData.User_Address);
			ToolsQACheckoutPage.address(driver, wait).sendKeys(Keys.TAB);
			ToolsQACheckoutPage.city(driver, wait).sendKeys(utility.TestData.User_City);
			ToolsQACheckoutPage.city(driver, wait).sendKeys(Keys.TAB);
			ToolsQACheckoutPage.state(driver, wait).sendKeys(utility.TestData.User_State);
			ToolsQACheckoutPage.state(driver, wait).sendKeys(Keys.TAB);
			ToolsQACheckoutPage.country(driver, wait).selectByVisibleText(utility.TestData.User_Country);;
			ToolsQACheckoutPage.phone(driver, wait).sendKeys(utility.TestData.User_Telephone);
			ToolsQACheckoutPage.phone(driver, wait).sendKeys(Keys.TAB);
			ToolsQACheckoutPage.clickPurchase(driver, wait);
		} catch (Exception e) {
			Log.error("Error while in Step 6");
		}
		finally {
	  		Log.endTestCase("STEP 6");
	  	}
	}
	
	@Test (priority = 7)
	public void testStep7(){
		Log.startTestCase("STEP 7: Confirm that you have placed the Order in ‘Transaction Results’ page");
		try {
			Log.info("Confirmation of order Transaction results page");
			String expectedText = ToolsQATransactionResultPage.confirmationText(driver, wait);
//			Assert.assertEquals(", any items to be shipped will be processed as soon as possible, any items that can be downloaded can be downloaded using the links on this page. All prices include tax and postage and packaging where applicable. You ordered these items:", expectedText);
			System.out.println("Confirmation msg::"+expectedText);
			Assert.assertEquals(ToolsQATransactionResultPage.orderQuantity(driver, wait), "1");
		} catch (Exception e) {
			Log.error("Error while in Step 7");
		}
		finally {
	  		Log.endTestCase("STEP 7");
	  	}
	}
	
}

