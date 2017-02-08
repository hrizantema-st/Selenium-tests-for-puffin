package org.csc.seleniumtests.puffin_selenium_tests;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import appModules.SignInAction;
import pageObjects.HomePage;
import pageObjects.UploadReferatPage;
import utility.Constant;

/**
 * This class contains integration test for Puffin Login Page 
 * @author hstancheva
 *
 */
@Category(IntegrationTest.class)
@SuppressWarnings({"static-method", "nls"})
public class UploadReferatIT {
	private static WebDriver driver;
	private UploadReferatPage uploadPage;
	
	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\Downloads\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(Constant.LOGIN_PAGE);
		SignInAction.execute(driver, "hstancheva", "9408050499");
		HomePage home = new HomePage(driver);
		home.clickOnUploadReferat();
		this.uploadPage = new UploadReferatPage(driver);
	}
	
	@Test
	public void testUploadHTMLFileShouldFail() {
		this.uploadPage.setUserFile("C:\\Users\\User\\Downloads\\referat.html");
		this.uploadPage.setComment("example comment");
		this.uploadPage.clickOnUpload();
		assertEquals("Допускат се само файлове с разширение .zip", this.uploadPage.getError().getText());
	}
	
	@Test
	public void testUploadZipFileShouldFail() {
		this.uploadPage.setUserFile("C:\\Users\\User\\Downloads\\referat.zip");
		this.uploadPage.setComment("example comment");
		this.uploadPage.clickOnUpload();
		//assertEquals("Допускат се само файлове с разширение .zip", this.uploadPage.getError().getText());
	}

	@After
	public void cleanUp() {
		//driver.close();
	}

}
