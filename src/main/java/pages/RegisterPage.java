package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import net.bytebuddy.build.Plugin.Engine.Dispatcher.Materializable.ForRetainedElement;
import utils.ElementUtils;
import utils.commonutils;

public class RegisterPage {

	WebDriver driver;
	private ElementUtils elementutils;

	public RegisterPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		elementutils = new ElementUtils(driver);
	}

	@FindBy(id = "input-firstname")
	private WebElement firstNameField;

	@FindBy(id = "input-lastname")
	private WebElement lastNameField;

	@FindBy(id = "input-email")
	private WebElement emailField;

	@FindBy(id = "input-telephone")
	private WebElement telephoneField;

	@FindBy(id = "input-password")
	private WebElement passwordsField;

	@FindBy(id = "input-confirm")
	private WebElement confirmPassworsField;

	@FindBy(xpath = "//input[@name='agree']")
	private WebElement privacyPolicyCheckbox;

	@FindBy(xpath = "//input[@value='Continue']")
	private WebElement continueButton;

	@FindBy(xpath = "(//input[@name ='newsletter'])[1]")
	private WebElement continueforNewsLetterradioButton;

	@FindBy(xpath = "(//div)[25]")
	private WebElement emailAllreadyregitseredMessage;

	@FindBy(xpath = "//div[contains(text(), 'Warning: You must agree to the Privacy Policy!')]")
	private WebElement agreeTermAndConditioWarningMessage;

	@FindBy(xpath = "(//div[@class ='text-danger'])[1]")
	private WebElement firstNameMustWarningMessage;

	@FindBy(xpath = "(//div[@class ='text-danger'])[2]")
	private WebElement lastNameMustWarningMessage;

	@FindBy(xpath = "(//div[@class ='text-danger'])[3]")
	private WebElement emailAddressMustWarningMessage;

	@FindBy(xpath = "(//div[@class ='text-danger'])[4]")
	private WebElement telephoneMustWarningMessage;

	@FindBy(xpath = "(//div[@class ='text-danger'])[5]")
	private WebElement passMustWarningMessage;

	public void enterFirstNameInFirstNameField(String firstNameText) {
		elementutils.typeTextIntoElement(firstNameField, firstNameText, commonutils.EXPLICIT_WAIT_BASIC_TIME);
		// firstNameField.sendKeys(firstNameText);
	}

	public void enterLastNameInLastNameField(String lastNameText) {
		elementutils.typeTextIntoElement(lastNameField, lastNameText, commonutils.EXPLICIT_WAIT_BASIC_TIME);
		// lastNameField.sendKeys(lastNameText);
	}

	public void enterEmailInEmailField(String emailText) {
		elementutils.typeTextIntoElement(emailField, emailText, commonutils.EXPLICIT_WAIT_BASIC_TIME);
		// emailField.sendKeys(emailText);
	}

	public void entertelephoneNumberinTelephoneField(String telephoneText) {
		elementutils.typeTextIntoElement(telephoneField, telephoneText, commonutils.EXPLICIT_WAIT_BASIC_TIME);
		// telephoneField.sendKeys(telephoneText);
	}

	public void enterpassIntoPassField(String passText) {
		elementutils.typeTextIntoElement(passwordsField, passText, commonutils.EXPLICIT_WAIT_BASIC_TIME);
		// passwordsField.sendKeys(passText);
	}

	public void enterconfirmPassIntoConfirmPassField(String confirnpasstext) {

		elementutils.typeTextIntoElement(confirmPassworsField, confirnpasstext, commonutils.EXPLICIT_WAIT_BASIC_TIME);
		// confirmPassworsField.sendKeys(confirnpasstext);
	}

	public void clickOnPrivacyPolicyCheckbox() {
		elementutils.clickOnElements(privacyPolicyCheckbox, commonutils.EXPLICIT_WAIT_BASIC_TIME);
		// privacyPolicyCheckbox.click();
	}

	public void clickOnContinueButton() {
		elementutils.clickOnElements(continueButton, commonutils.EXPLICIT_WAIT_BASIC_TIME);
		// continueButton.click();
	}

	public void clickcOnontinueforNewsLetterradioButton() {
		elementutils.clickOnElements(continueforNewsLetterradioButton, commonutils.EXPLICIT_WAIT_BASIC_TIME);
		// continueforNewsLetterradioButton.click();
	}

	public String getTextOfemailAllreadyregitseredText() {
		return elementutils.getTextOfemailaddAllreadyregitseredText(emailAllreadyregitseredMessage, commonutils.EXPLICIT_WAIT_BASIC_TIME);
		// String allreadyAccountText= emailAllreadyregitseredMessage.getText();
		// return allreadyAccountText;
	}

	public String getTextOfagreeTermAndConditioWarning() {

		return elementutils.getTextOfeagreeTermsAndConditionText(agreeTermAndConditioWarningMessage, commonutils.EXPLICIT_WAIT_BASIC_TIME);

		// String agreeTermAndConditioWarningText =
		// agreeTermAndConditioWarningMessage.getText();
		// return agreeTermAndConditioWarningText;
	}

	public String getfirstNameMustWarningMessage() {

		return elementutils.getTheTextFirstNameWarningMessage(firstNameMustWarningMessage, commonutils.EXPLICIT_WAIT_BASIC_TIME);
		// String firstNameMustWarningText = firstNameMustWarningMessage.getText();
		// return firstNameMustWarningText;
	}

	public String getlastNameWarningMessage() {

		return elementutils.getTheTextlastNameWarningMessage(lastNameMustWarningMessage, commonutils.EXPLICIT_WAIT_BASIC_TIME);
		// String lastNameMustWarningText = lastNameMustWarningMessage.getText();
		// return lastNameMustWarningText;
	}

	public String getemailWarningMessage() {
		return elementutils.getTheTextFirstNameWarningMessage(emailAddressMustWarningMessage, commonutils.EXPLICIT_WAIT_BASIC_TIME);

		// String emailMustWarningText = emailAddressMustWarningMessage.getText();
		// return emailMustWarningText;
	}

	public String getphoneNumberWarningMessage() {

		return elementutils.getTheTextOfPhoneNumberWarningMessage(telephoneMustWarningMessage, commonutils.EXPLICIT_WAIT_BASIC_TIME);
		// String telePhoneMustText = telephoneMustWarningMessage.getText();
		// return telePhoneMustText;
	}

	public String getPassWarningMessage() {

		return elementutils.getTheTextPasswordsWarningMessage(passMustWarningMessage, commonutils.EXPLICIT_WAIT_BASIC_TIME);
		// String passMustText = passMustWarningMessage.getText();
		// return passMustText;
	}
}
