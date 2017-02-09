package org.csc.seleniumtests.puffin_selenium_tests;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import appModules.SignInAction;
import utility.Constant;

/**
 * This class contains integration test for Puffin Login Page
 * 
 * @author hstancheva
 *
 */
@Category(IntegrationTest.class)
@SuppressWarnings({ "static-method", "nls" })
public class LoginIT extends BaseClassForIT {

	@Override
	protected void customInitialization() {
		driver.get(Constant.LOGIN_PAGE);
	}

	@Test
	public void testSuccessfulLoginAfterEnteringCorrectCredentials() {
		// when
		SignInAction.execute(driver, Constant.USERNAME, Constant.PASSWORD);
		List<WebElement> h2 = driver.findElements(By.tagName("h2"));
		// then
		assertEquals("Здравей!", h2.get(0).getText());
	}

	@Test
	public void testUnsuccessfulLoginAfterEnteringWrongCredentials() {
		// when
		SignInAction.execute(driver, Constant.USERNAME, "wrongPassword");
		List<String> errors = SignInAction.getErrors(driver);
		// then
		assertEquals("Грешна парола", errors.get(1));
	}

	@Test
	public void testUnsuccessfulLoginAfterEnteringUsernameAndLeftPasswordFieldEmpty() {
		// when
		SignInAction.execute(driver, Constant.USERNAME, "");
		List<String> errors = SignInAction.getErrors(driver);
		// then
		assertEquals("Въведете парола", errors.get(1));
	}

	@Test
	public void testUnsuccessfulLoginUsernameAndPasswordFieldEmpty() {
		// when
		SignInAction.execute(driver, "", "");
		List<String> errors = SignInAction.getErrors(driver);
		// then
		for (int i = 0; i < errors.size(); i++) {
			System.out.println(errors.get(i));
		}
		assertEquals("Въведете потребителско име", errors.get(0));
		assertEquals("Въведете парола", errors.get(1));
	}

	@Test
	public void testUnsuccessfulLoginWIthNonExistingUserAndProvidedPassword() {
		// when
		SignInAction.execute(driver, "nonexistingUser", "password");
		List<String> errors = SignInAction.getErrors(driver);
		// then
		assertEquals("Няма регистриран потребител с това име в системата", errors.get(0));
		// assertEquals("Въведете парола", errors.get(1).getText());
	}

}
