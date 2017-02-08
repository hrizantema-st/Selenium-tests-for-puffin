package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
@SuppressWarnings("nls")
public class LoginPage {
	 private static WebElement element = null;
	 
	 @FindBy
	 private WebElement alabala;
	 
	public static WebElement txtbxUserName(WebDriver driver) {
		element = driver.findElement(By.name("name"));
		 
        return element;
	}

	public static WebElement txtbxPassword(WebDriver driver) {
		element = driver.findElement(By.name("pass"));
		 
        return element;
	}

	public static WebElement btnLogIn(WebDriver driver) {
		List<WebElement> buttons = driver.findElements(By.cssSelector(".btn"));
		
		return buttons.get(0);
	}
	
	
	public static List<WebElement> errors(WebDriver driver) {
		
		return driver.findElements(By.cssSelector("span.error"));
	}
}
