package appModules;

import org.openqa.selenium.WebDriver;

import pageObjects.RegistrationPage;

public class RegistrationAction {
	public static void execute(final WebDriver driver, final String fn, final String username, final String password, final String email){
		RegistrationPage.txtbxFN(driver).sendKeys(fn);
		
		RegistrationPage.txtbxUsername(driver).sendKeys(username);
		 
        RegistrationPage.txtbxPassword(driver).sendKeys(password);
        
        RegistrationPage.txtbxEmail(driver).sendKeys(email);
 
        RegistrationPage.btnRegistration(driver).click();
 
     }
}
