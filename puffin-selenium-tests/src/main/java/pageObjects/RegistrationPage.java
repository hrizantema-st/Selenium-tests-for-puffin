package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
@SuppressWarnings("nls")
public class RegistrationPage {
	 private static WebElement element = null;

	public static WebElement txtbxFN(WebDriver driver) {
		element = driver.findElement(By.name("fn"));
		 
        return element;
	}

	public static WebElement txtbxUsername(WebDriver driver) {
		element = driver.findElement(By.name("name"));
		 
        return element;
	}
	
	public static WebElement txtbxPassword(WebDriver driver) {
		element = driver.findElement(By.name("pass"));
		 
        return element;
	}
	
	public static WebElement txtbxEmail(WebDriver driver) {
		element = driver.findElement(By.name("mail"));
		 
        return element;
	}

	public static WebElement btnRegistration(WebDriver driver) {
		List<WebElement> buttons = driver.findElements(By.cssSelector(".btn"));
		
		return buttons.get(0);
	}

}
