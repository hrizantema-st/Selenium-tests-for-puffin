package org.csc.seleniumtests.puffin_selenium_tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.experimental.categories.Category;

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
@SuppressWarnings({"nls"})
public class UploadReferatIT extends BaseClassForIT {
	private UploadReferatPage uploadPage;
	
	@Override
	protected void customInitialization() {
		driver.get(Constant.LOGIN_PAGE);
		SignInAction.execute(driver, "user", "password");
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

}
