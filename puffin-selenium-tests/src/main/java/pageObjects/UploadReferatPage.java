package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UploadReferatPage {
	private WebDriver driver;

	public UploadReferatPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "userfile")
	private WebElement userfile;

	@FindBy(id = "comment")
	private WebElement comment;

	@FindBy(xpath = "/html/body/div/div[1]/div[3]/form/a")
	private WebElement upload;

	@FindBy(css = "html body div.container div.content div.form_holder center span.error")
	private WebElement error;

	public void setUserFile(final String path) {
		this.userfile.sendKeys(path);
	}

	public void setComment(final String comment) {
		this.comment.clear();
		this.comment.sendKeys(comment);
	}

	public void clickOnUpload() {
		this.upload.click();
	}

	public WebElement getError() {
		return this.error;
	}

}
