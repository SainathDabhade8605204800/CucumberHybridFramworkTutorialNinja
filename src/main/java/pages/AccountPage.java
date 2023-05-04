package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.ElementUtils;
import utils.commonutils;

public class AccountPage {

	WebDriver driver;
	private ElementUtils elementutils;

	public AccountPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);
		elementutils = new ElementUtils(driver);

	}

	@FindBy(linkText = "Edit your account information")
	private WebElement displayEditYourAccountInformation;

	@FindBy(xpath = "//h1[text()='Your Account Has Been Created!']")
	private WebElement displayAccountCreatedMessage;

	public boolean getDisplayStatusOfEditAccountInformation() {
		return elementutils.getDisplayTextFromElement(displayEditYourAccountInformation, commonutils.EXPLICIT_WAIT_BASIC_TIME);

	}

	public String getTextOfAccountCreatedMessage() {
		return elementutils.getTextOfAccountCreatedMessage(displayAccountCreatedMessage, commonutils.EXPLICIT_WAIT_BASIC_TIME);

	}

}
