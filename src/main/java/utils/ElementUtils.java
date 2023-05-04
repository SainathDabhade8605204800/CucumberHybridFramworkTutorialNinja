package utils;

import java.time.Duration;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtils {

	WebDriver driver;

	public ElementUtils(WebDriver driver) {

		this.driver = driver;
	}

	public void clickOnElements(WebElement element, long durationInSeconds) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationInSeconds));
		WebElement WebElement = wait.until(ExpectedConditions.elementToBeClickable(element));
		WebElement.click();
	}

	public void typeTextIntoElement(WebElement element, String textToBeType, long durationInSeconds) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationInSeconds));
		WebElement WebElement = wait.until(ExpectedConditions.elementToBeClickable(element));
		WebElement.click();
		WebElement.clear();
		WebElement.sendKeys(textToBeType);

	}

	public void selectDropDownOption(WebElement element, String dropDownOption, long durationInSeconds) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationInSeconds));
		WebElement WebElement = wait.until(ExpectedConditions.elementToBeClickable(element));
		Select select = new Select(element);
		select.selectByVisibleText(dropDownOption);

	}

	public void acceptAlert(WebElement element, long durationInSeconds) {
		Alert alert = waitForAlert(durationInSeconds);
		alert.accept();
	}

	public void dissmissAlert(WebElement element, long durationInSeconds) {
		Alert alert = waitForAlert(durationInSeconds);
		alert.dismiss();
	}

	public Alert waitForAlert(long durationInSeconds) {
		Alert alert = null;

		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationInSeconds));
			alert = wait.until(ExpectedConditions.alertIsPresent());
		} catch (Throwable e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return alert;
	}

	public void mouseHoverAndClick(WebElement element, long durationInSeconds) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationInSeconds));
		WebElement WebElement = wait.until(ExpectedConditions.visibilityOf(element));
		Actions ac = new Actions(driver);
		ac.moveToElement(WebElement).click().build().perform();
	}

	public void javaScriptClick(WebElement element, long durationInSeconds) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationInSeconds));
		WebElement WebElement = wait.until(ExpectedConditions.visibilityOf(element));

		JavascriptExecutor jse = ((JavascriptExecutor) driver);
		jse.executeScript("arguments[0].click();", WebElement);
	}

	public void javaScriptType(WebElement element, long durationInSeconds, String textToBeType) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationInSeconds));
		WebElement WebElement = wait.until(ExpectedConditions.visibilityOf(element));
		JavascriptExecutor jse = ((JavascriptExecutor) driver);
		jse.executeScript("arguments[0].value='" + textToBeType + "';", WebElement);
	}

	public boolean getDisplayTextFromElement(WebElement element, long durationInSeconds) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationInSeconds));
		WebElement WebElement = wait.until(ExpectedConditions.visibilityOf(element));
		return WebElement.isDisplayed();
	}

	public boolean displayStatusOfElement(WebElement element, long durationInSeconds) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationInSeconds));
		WebElement WebElement = wait.until(ExpectedConditions.visibilityOf(element));
		return WebElement.isDisplayed();
	}

	public String getTextOfAccountCreatedMessage(WebElement element, long durationInSeconds) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationInSeconds));
		WebElement WebElement = wait.until(ExpectedConditions.visibilityOf(element));
		return WebElement.getText();
	}

	public String getTextOfemailaddAllreadyregitseredText(WebElement element, long durationInSeconds) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationInSeconds));
		WebElement WebElement = wait.until(ExpectedConditions.visibilityOf(element));
		return WebElement.getText();
	}

	public String getTextOfeagreeTermsAndConditionText(WebElement element, long durationInSeconds) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationInSeconds));
		WebElement WebElement = wait.until(ExpectedConditions.visibilityOf(element));
		return WebElement.getText();
	}
	
	public String getTheTextFirstNameWarningMessage(WebElement element, long durationInSeconds) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationInSeconds));
		WebElement WebElement = wait.until(ExpectedConditions.visibilityOf(element));
		return WebElement.getText();
	}
	
	public String getTheTextlastNameWarningMessage(WebElement element, long durationInSeconds) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationInSeconds));
		WebElement WebElement = wait.until(ExpectedConditions.visibilityOf(element));
		return WebElement.getText();
	}
	 
	public String getTheTextEmailWarningMessage(WebElement element, long durationInSeconds) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationInSeconds));
		WebElement WebElement = wait.until(ExpectedConditions.visibilityOf(element));
		return WebElement.getText();
	}
	
	public String getTheTextOfPhoneNumberWarningMessage(WebElement element, long durationInSeconds) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationInSeconds));
		WebElement WebElement = wait.until(ExpectedConditions.visibilityOf(element));
		return WebElement.getText();
	}
	public String getTheTextPasswordsWarningMessage(WebElement element, long durationInSeconds) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationInSeconds));
		WebElement WebElement = wait.until(ExpectedConditions.visibilityOf(element));
		return WebElement.getText();
	}
	
	public String getTextValidProductSearch(WebElement element, long durationInSeconds) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationInSeconds));
		WebElement WebElement = wait.until(ExpectedConditions.visibilityOf(element));
		return WebElement.getText();
	}
	
	public String getTextInValidProductSearch(WebElement element, long durationInSeconds) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationInSeconds));
		WebElement WebElement = wait.until(ExpectedConditions.visibilityOf(element));
		return WebElement.getText();
	}
}