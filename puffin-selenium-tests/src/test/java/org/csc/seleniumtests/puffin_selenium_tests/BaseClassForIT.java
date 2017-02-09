package org.csc.seleniumtests.puffin_selenium_tests;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public abstract class BaseClassForIT {
	
	@Before
	public void setup() {
		/*System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\Downloads\\chromedriver.exe");
		driver = new ChromeDriver();*/
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\hstancheva\\geckodriver.exe");
        driver = new FirefoxDriver();
		customInitialization();
	}
	
	@After
	public void cleanUp() {
		driver.close();
	}
	
	protected static WebDriver driver;
	protected abstract void customInitialization();
}
