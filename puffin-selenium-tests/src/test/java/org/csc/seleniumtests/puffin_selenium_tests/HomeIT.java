package org.csc.seleniumtests.puffin_selenium_tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import appModules.SignInAction;
import pageObjects.ChooseReferatPage;
import pageObjects.HomePage;
import utility.Constant;

/**
 * This class contains integration test for Puffin Welcome Page
 * 
 * @author hstancheva
 *
 */

@SuppressWarnings({ "nls" })
public class HomeIT extends BaseClassForIT {
	private HomePage home;

	@Override
	protected void customInitialization() {
		// given
		driver.get(Constant.LOGIN_PAGE);
		SignInAction.execute(driver, "user", "password");
		this.home = new HomePage(driver);
	}

	@Test
	public void testClickOnChooseReferatShouldRedirectToCorrectURL() {
		// when
		this.home.clickOnChooseReferat();
		// then
		assertEquals("Puffin", driver.getTitle());
		ChooseReferatPage referatPage = new ChooseReferatPage(driver);
		String referat = referatPage.getChosenReferat().getText();
		assertTrue(referat.contains("Избраната тема е"));
	}

	@Test
	public void testClickOnuploadReferatShouldRedirectToCorrectURL() {
		// when
		this.home.clickOnUploadReferat();
		// then
		assertEquals("Puffin", driver.getTitle());
	}

	@Test
	public void testClickOnmakeRecensionShouldRedirectToCorrectURL() {
		// when
		this.home.clickOnMakeRecension();
		// then
		assertEquals("Puffin", driver.getTitle());
	}

	@Test
	public void testClickOnLogoutShouldRedirectToCorrectURL() {
		// when
		this.home.clickOnLogoutButton();
		// then
		assertEquals("Puffin", driver.getTitle());
	}

}
