package org.csc.seleniumtests.puffin_selenium_tests;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import appModules.SignInAction;
import utility.Constant;

/**
 * This class contains integration test for Puffin Logout 
 * @author hstancheva
 *
 */
@Category(IntegrationTest.class)
@SuppressWarnings({"static-method", "nls"})
public class LogoutIT {
	private static WebDriver driver;

	@BeforeClass
	public static void setup() {
		//given
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\Downloads\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(Constant.LOGIN_PAGE);
		SignInAction.execute(driver, Constant.USERNAME, Constant.PASSWORD);
	}

	@Test
	public void testSuccessfulLogout() {
		//when
		driver.findElement(By.xpath("//a[@href='http://62.44.100.5/WEBTECH/www_7ed_referats/logout.php']")).click();
		List<WebElement> h3 = driver.findElements(By.cssSelector("h3"));
		//then
		assertEquals("Влезте в своя профил", h3.get(0).getText());
	}
	
	
	@After
	public void cleanUp() {
		driver.close();
	}

}
