package automationFramework;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import appModules.SignInAction;
import utility.Constant;

public class GlobalVarTC {
	private static WebDriver driver = null;

	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\hstancheva\\geckodriver.exe");
		driver = new FirefoxDriver();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// Launch the Online Store Website using Constant Variable

		driver.get(Constant.LOGIN_PAGE);

		// Pass Constant Variables as arguments to Execute method

		SignInAction.execute(driver, Constant.USERNAME, Constant.PASSWORD);

		System.out.println("Login Successfully, now it is the time to Log Off buddy.");

		// HomePage.lnkLogOut(driver).click();

		// driver.quit();

	}

}
