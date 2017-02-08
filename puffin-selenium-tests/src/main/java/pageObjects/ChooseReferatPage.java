package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ChooseReferatPage {
	private WebDriver driver;

	public ChooseReferatPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "/html/body/div/div[1]/h4")
	private WebElement chosenReferat; //"Все още не си си избрал тема" "Избраната тема е" 

	@FindBy(name = "project_theme")
	private WebElement projectTheme;

	@FindBy(name = "project_theme_select")
	private WebElement projectThemeSelect;

	@FindBy(xpath = "/html/body/div/div[1]/div[3]/form/a")
	private WebElement submit;


	public void setProjectTheme(final String projectTheme) {
		this.projectTheme.clear();
		this.projectTheme.sendKeys(projectTheme);
	}
	
	public WebElement getChosenReferat() {
		return this.chosenReferat;
	}
/*
	public void clickProjectThemeSelect() {
		this.projectThemeSelect.click();
		}
*/
	

}
