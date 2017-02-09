package org.csc.seleniumtests.puffin_selenium_tests;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import appModules.RegistrationAction;
import utility.Constant;

/**
 * This class contains integration test for Puffin Registration Page 
 * @author hstancheva
 *
 */
@Category(IntegrationTest.class)
@SuppressWarnings({"static-method", "nls"})
public class RegistrationIT extends BaseClassForIT {

	@Override
	protected void customInitialization() {
		//given
		driver.get(Constant.REGISTRATION_PAGE);
	}

	@Test
	public void testUnsuccessfulLoginUsernameAndPasswordFieldEmpty() {
		//when
		RegistrationAction.execute(driver, "", "", "", "");
		List<WebElement> errors = driver.findElements(By.cssSelector("span.error"));
		//then
		assertEquals(4, errors.size());
		assertEquals("Въведи реален факултетен номер", errors.get(0).getText());
		assertEquals("Въведи потребителско име", errors.get(1).getText());
		assertEquals("Въведи парола", errors.get(2).getText());
		assertEquals("Въведи мейл", errors.get(3).getText());
	}

}
