package appModules;

import org.openqa.selenium.WebDriver;

import pageObjects.ChooseReferatPage;

public class ChooseReferatAction {
	private WebDriver driver;
	
	public static void execute(final WebDriver driver, final String theme){
		ChooseReferatPage referatPage = new ChooseReferatPage(driver);
		referatPage.setProjectTheme(theme);
     }
}
