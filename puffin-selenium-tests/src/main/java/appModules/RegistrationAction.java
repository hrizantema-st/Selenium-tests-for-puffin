package appModules;

import org.openqa.selenium.WebDriver;

import pageObjects.RegistrationPage;

public class RegistrationAction {
	private WebDriver driver;
	
	public static void execute(final WebDriver driver, final String fn, final String name, final String pass, final String mail){
		RegistrationPage regPage = new RegistrationPage(driver);
		
		regPage.setFn(fn);
		regPage.setName(name);
		regPage.setpass(pass);
		regPage.setMail(mail);
		regPage.clickOnRegister();
 
     }
}
