package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	private WebDriver driver;

//	/private static String PAGE_URL = Constant.HOME_PAGE;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "/html/body/div/div[1]/div[2]/ul/li[1]/a/center/div/span[1]/img")
	private WebElement chooseReferat;

	@FindBy(xpath = "/html/body/div/div[1]/div[2]/ul/li[2]/a/center/div/span[1]/img")
	private WebElement uploadReferat;

	@FindBy(xpath = "/html/body/div/div[1]/div[2]/ul/li[3]/a/center/div/span[1]/img")
	private WebElement makeRecension;
	
	@FindBy(xpath = "/html/body/div/div[1]/div[2]/ul/li[4]/a/center/div/span[1]/img")
	private WebElement logoutButton;

	@FindBy(xpath = "/html/body/div/div[1]/div[1]/center/a/div/span[1]/img")
	private WebElement logo;

	public void clickOnLogoutButton() {
		this.logoutButton.click();
	}
	
	public void clickOnChooseReferat() {
		this.chooseReferat.click();
	}
	
	public void clickOnUploadReferat() {
		this.uploadReferat.click();
	}
	
	public void clickOnMakeRecension() {
		this.makeRecension.click();
	}
	
	public void clickOnLogo() {
		this.logo.click();
	}
	
}
