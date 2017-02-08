package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	private WebDriver driver;

	private static String PAGE_URL = "https://www.toptal.com";

	public HomePage(WebDriver driver) {
		this.driver = driver;
		driver.get(PAGE_URL);
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@href='http://62.44.100.139/WEBTECH/www_7ed_referats/img/logout.png']")
	private WebElement logoutButton;

	@FindBy(xpath = "//a[@href='http://62.44.100.139/WEBTECH/www_7ed_referats/img/choose.png']")
	private WebElement chooseReferat;

	@FindBy(xpath = "//a[@href='http://62.44.100.139/WEBTECH/www_7ed_referats/img/upload.png']")
	private WebElement uploadReferat;

	@FindBy(xpath = "//a[@href='http://62.44.100.139/WEBTECH/www_7ed_referats/img/review.png']")
	private WebElement makeRecension;

	@FindBy(xpath = "//a[@href='http://62.44.100.139/WEBTECH/www_7ed_referats/img/logo.png")
	private WebElement logo;

	public void clickOnLogoutButton() {
		logoutButton.click();
	}
	
}
