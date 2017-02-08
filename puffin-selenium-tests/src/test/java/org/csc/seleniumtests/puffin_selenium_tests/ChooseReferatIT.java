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

import appModules.RegistrationAction;
import utility.Constant;

/**
 * This class contains integration test for Puffin Login Page 
 * @author hstancheva
 *
 */
@Category(IntegrationTest.class)
@SuppressWarnings({"static-method", "nls"})
public class ChooseReferatIT {
	private static WebDriver driver;

	@Before
	public void setup() {
		//given
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\Downloads\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(Constant.CHOOSE_REFERAT_PAGE);
	}

	
	@After
	public void cleanUp() {
		driver.close();
	}

}
