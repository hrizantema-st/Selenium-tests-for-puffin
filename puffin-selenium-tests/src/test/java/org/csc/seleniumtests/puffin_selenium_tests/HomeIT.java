package org.csc.seleniumtests.puffin_selenium_tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import appModules.SignInAction;
import pageObjects.ChooseReferatPage;
import pageObjects.HomePage;
import utility.Constant;

/**
 * This class contains integration test for Puffin Welcome Page 
 * @author hstancheva
 *
 */
@SuppressWarnings({"static-method", "nls"})
public class HomeIT {
	private static WebDriver driver;
	private HomePage home;
	@Before
	public void setup() {
		//given
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\Downloads\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(Constant.LOGIN_PAGE);
		SignInAction.execute(driver, "hstancheva", "9408050499");
		this.home = new HomePage(driver);
	}
	
	@Test
	public void testClickOnChooseReferatShouldRedirectToCorrectURL() {
		//when
	    this.home.clickOnChooseReferat();
		//then
		assertEquals("Puffin", driver.getTitle());
		ChooseReferatPage referatPage = new ChooseReferatPage(driver);
		String referat = referatPage.getChosenReferat().getText();
		assertTrue(referat.contains("Избраната тема е"));
		
	}
	
	
	@Test
	public void testClickOnuploadReferatShouldRedirectToCorrectURL() {
		//when
	    this.home.clickOnUploadReferat();
		//then
		assertEquals("Puffin", driver.getTitle());
	}
	
	@Test
	public void testClickOnmakeRecensionShouldRedirectToCorrectURL() {
		//when
	    this.home.clickOnMakeRecension();
		//then
		assertEquals("Puffin", driver.getTitle());
	}
	
	@Test
	public void testClickOnLogoutShouldRedirectToCorrectURL() {
		//when
	    this.home.clickOnLogoutButton();
		//then
		assertEquals("Puffin", driver.getTitle());
	}
	
	@After
	public void cleanUp() {
		driver.close();
	}

}
