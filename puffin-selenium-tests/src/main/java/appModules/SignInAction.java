package appModules;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.WebDriver;

import pageObjects.LoginPage;

public class SignInAction {
	public static void execute(final WebDriver driver, final String sUsername, final String sPassword) {

		LoginPage.txtbxUserName(driver).sendKeys(sUsername);

		LoginPage.txtbxPassword(driver).sendKeys(sPassword);

		LoginPage.btnLogIn(driver).click();

	}

	public static List<String> getErrors(final WebDriver driver) {
		return LoginPage.errors(driver).stream().map(a -> a.getText()).collect(Collectors.toList());
	}
}
