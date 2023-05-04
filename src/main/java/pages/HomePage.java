package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.ElementUtils;
import utils.commonutils;

public class HomePage {

	WebDriver driver;
	private ElementUtils elementutils;

	// Create the constructor
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this); // initialize the webelements When object is created for the Home
		// page and constructor is called and then automatically initilize the elements
		elementutils = new ElementUtils(driver);
	}

	@FindBy(xpath = "//span[contains(text(), 'My Account')]")
	private WebElement myAccountDropMenu;

	@FindBy(xpath = "//a[contains(text(),'Login')]")
	private WebElement logInOpion;

	@FindBy(xpath = "(//li/a[contains(text(),'Register')])[1]")
	private WebElement regitserOption;

	@FindBy(xpath = "//input[@name='search']")
	private WebElement searchField;

	@FindBy(xpath = "//button[@class='btn btn-default btn-lg']")
	private WebElement searchButton;

	public void clickOnMyAccount() {
		elementutils.clickOnElements(myAccountDropMenu, commonutils.EXPLICIT_WAIT_BASIC_TIME);
	}

	public void clickOnLogInOptio() {
		elementutils.clickOnElements(logInOpion, commonutils.EXPLICIT_WAIT_BASIC_TIME);
	}

	public void clickOnRegitserOption() {
		elementutils.clickOnElements(regitserOption, commonutils.EXPLICIT_WAIT_BASIC_TIME);
	}

	public void enterTheValidProductIntoSearchField(String ProductText) {
		
		elementutils.typeTextIntoElement(searchField, ProductText, commonutils.EXPLICIT_WAIT_BASIC_TIME);
		//searchField.sendKeys(ProductText);

	}

	public void clickOnSearchButton() {
		elementutils.clickOnElements(searchButton, commonutils.EXPLICIT_WAIT_BASIC_TIME);
		//searchButton.click();
	}

	public void enterInvalidProdcutIntoSeachField(String ProductText) {
		elementutils.typeTextIntoElement(searchField, ProductText, commonutils.EXPLICIT_WAIT_BASIC_TIME);
		//searchField.sendKeys(ProductText);
	}

}
