package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MakeRecensionPage {
	private WebDriver driver;

	public MakeRecensionPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "fn")
	private WebElement fn;

	@FindBy(name = "name")
	private WebElement name;

	@FindBy(name = "pass")
	private WebElement pass;

	@FindBy(name = "mail")
	private WebElement mail;

	@FindBy(css = "html body div.container div.content div.form_holder form#myform a.btn.green")
	private WebElement register;

	public void setFn(final String fn) {
		this.fn.clear();
		this.fn.sendKeys(fn);
	}

	public void setName(final String name) {
		this.name.clear();
		this.name.sendKeys(name);
	}

	public void setpass(final String pass) {
		this.pass.clear();
		this.pass.sendKeys(pass);
	}

	public void setMail(final String mail) {
		this.mail.clear();
		this.mail.sendKeys(mail);
	}

	public void clickOnRegister() {
		this.register.click();
	}

}
