package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.ElementUtils;
import utils.commonutils;

public class SearchPage {

	private ElementUtils elementutils;
	WebDriver driver;

	public SearchPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		elementutils = new ElementUtils(driver);
	}

	@FindBy(linkText = "HP LP3065")
	private WebElement validProductSearchtext;

	@FindBy(xpath = "(//p)[3]")
	private WebElement invalidProductSearchtext;

	public String getValidProductSearchText() {
		// return validProductSearchtext.getText();
		return elementutils.getTextInValidProductSearch(validProductSearchtext, commonutils.EXPLICIT_WAIT_BASIC_TIME);

	}

	public String getInvalidProductSeachText() {
		
		return elementutils.getTextInValidProductSearch(invalidProductSearchtext, commonutils.EXPLICIT_WAIT_BASIC_TIME);
	}

}
