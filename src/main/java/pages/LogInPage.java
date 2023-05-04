package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.ElementUtils;
import utils.commonutils;

public class LogInPage {
	
	private ElementUtils elementutils;
	WebDriver driver;
	
	public LogInPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);	
		elementutils = new ElementUtils(driver);
	}
	
	
	@FindBy (id = "input-email")
    private	WebElement emailAddressField;
	
	
	@FindBy(id="input-password")
	private WebElement passwordTextField;
	
	@FindBy(xpath = "//input[@value ='Login']")
	private WebElement logInButton;
	
	
	@FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
	private WebElement displayProperWarningMessageIncoorectUsernameandPass; 
	
	
	public void enterEmailAddressinEmailField(String validemailText) {
		elementutils.typeTextIntoElement(emailAddressField, validemailText, commonutils.EXPLICIT_WAIT_BASIC_TIME);
		//emailAddressField.sendKeys(validemailText);
	}
	
	public void enterPassinPassField(String validpassText) {
		elementutils.typeTextIntoElement(passwordTextField, validpassText, commonutils.EXPLICIT_WAIT_BASIC_TIME);
		//passwordTextField.sendKeys(validpassText);
	}
	
	public void clickOnLogInButton() {
		elementutils.clickOnElements(logInButton, commonutils.EXPLICIT_WAIT_BASIC_TIME);
		//logInButton.click();
	}
	 
	public boolean getProperWarningMessageIncoorectUsernameandPass() {
		
	return elementutils.getDisplayTextFromElement(displayProperWarningMessageIncoorectUsernameandPass,commonutils.EXPLICIT_WAIT_BASIC_TIME);
		
	}
	

}
