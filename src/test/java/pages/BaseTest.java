package pages;

import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;

import utility.BrowserFactory;
import utility.ConfigDataProvider;

public class BaseTest {
	
	public WebDriver driver;
	public ConfigDataProvider config;
	
	
	
	@BeforeClass
	public void setUp() {
		 config = new ConfigDataProvider();
		driver = BrowserFactory.startApplication(driver, config.getBrowser(), config.getStagingUrl());
	}
	
	
	
	
	@AfterClass
	public void tearDown() {
		BrowserFactory.quitBrowser(driver);
	}
	
	public void captureScreenShot(WebDriver driver,String testName) throws IOException
	 {
		 // Convert webdriver object to TakesScreenshot interface
		 TakesScreenshot screenshot= ((TakesScreenshot)driver);
		 
		 // Step 2 :call getScreenshotAs method to capture image file
		 
		 File src= screenshot.getScreenshotAs(OutputType.FILE);
		 File srcpath=new File("."+"//Screenshots//"+ testName + ".png");
		 
		 // Step 3 : copy image file to destination 
		 FileUtils.copyFile(src, srcpath);
		 
	 }

}
