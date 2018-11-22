package testClassPackage;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import utility.Log;

public class config {
	 
		static WebDriver driver = null;
		public WebDriverWait wait;
		static String driverPath = "C:/SeleniumProjects/Testing-master/tools/driver/chromedriver.exe";
		
		@BeforeSuite
		public void setup(){
			DOMConfigurator.configure("log4j.xml");
			Log.startTestCase("Let's buy a Magic Mouse");
			System.setProperty("webdriver.chrome.driver", driverPath);
		    driver=new ChromeDriver();
		    wait = new WebDriverWait(driver,15);
		    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.manage().window().maximize();
		}

		@AfterSuite
		public void tearDown(){
			Log.endTestCase("Magic Mouse order confirmed");
		    driver.quit();
		}

}
