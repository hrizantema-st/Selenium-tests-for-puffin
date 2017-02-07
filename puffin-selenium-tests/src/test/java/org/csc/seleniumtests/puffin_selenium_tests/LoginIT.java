package org.csc.seleniumtests.puffin_selenium_tests;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import appModules.SignInAction;
import utility.Constant;

/**
 * This class contains integration test for Puffin Login Page 
 * @author hstancheva
 *
 */
@Category(IntegrationTest.class)
@SuppressWarnings({"static-method", "nls"})
public class LoginIT {
	private static WebDriver driver;

	@Before
	public void setup() {
		//given
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\Downloads\\chromedriver.exe");
		driver = new ChromeDriver();
		/*System.setProperty("webdriver.gecko.driver", "C:\\Users\\User\\Downloads\\geckodriver.exe");
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\hstancheva\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();*/
		driver.get(Constant.LOGIN_PAGE);
	}
	/**
	 * This test performs scenario on the Login Page of Puffin
	 * After inserting correct credentials(username and password)
	 * in the login form and after clicking Login button this s
	 * should redirect us to the home page of puffin
	 */
	@Test
	public void testSuccessfulLoginAfterEnteringCorrectCredentials() {
		//when
		SignInAction.execute(driver, Constant.USERNAME, Constant.PASSWORD);
		//then
		assertEquals(driver.getTitle(), "Puffin");
	}
	
	@Test
	public void testUnsuccessfulLoginAfterEnteringWrongCredentials() {
		//when
		SignInAction.execute(driver, Constant.USERNAME, "wrongPassword");
		//then
		assertEquals(driver.getTitle(), "Puffin");
	}
	
	@Test
	public void testUnsuccessfulLoginAfterEnteringUsernameAndLeftPasswordFieldEmpty() {
		//when
		SignInAction.execute(driver, Constant.USERNAME, "");
		List<WebElement> errors = driver.findElements(By.cssSelector("span.error"));
		//then
		assertEquals("Въведете парола", errors.get(1).getText());
	}
	
	@Test
	public void testUnsuccessfulLoginUsernameAndPasswordFieldEmpty() {
		//when
		SignInAction.execute(driver, "", "");
		List<WebElement> errors = driver.findElements(By.cssSelector("span.error"));
		//then
		assertEquals("Въведете потребителско име", errors.get(0).getText());
		assertEquals("Въведете парола", errors.get(1).getText());
	}
	@Test
	public void testUnsuccessfulLoginWIthNonExistingUserAndProvidedPassword() {
		//when
		SignInAction.execute(driver, "nonexistingUser", "password");
		List<WebElement> errors = driver.findElements(By.cssSelector("span.error"));
		//then
		assertEquals("Няма регистриран потребител с това име в системата", errors.get(0).getText());
		//assertEquals("Въведете парола", errors.get(1).getText());
	}
	
	@After
	public void cleanUp() {
		driver.close();
	}

}