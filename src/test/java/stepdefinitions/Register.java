package stepdefinitions;

import java.util.Date;
import java.util.Map;

import org.hamcrest.DiagnosingMatcher;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;
import pages.AccountPage;
import pages.HomePage;
import pages.RegisterPage;
import utils.commonutils;

public class Register {

	WebDriver driver;
	private RegisterPage registerpage;
	private commonutils cm;
	private DriverFactory driverfactory;

	@Given("User navigate to the register account page")
	public void user_navigate_to_the_register_account_page() {
		driverfactory = new DriverFactory();
		driver = driverfactory.getDriver();
		HomePage homepage = new HomePage(driver);
		homepage.clickOnMyAccount();
		homepage.clickOnRegitserOption();
		// driver.findElement(By.xpath("//span[text()='My Account']")).click();
		// driver.findElement(By.xpath("(//li/a[contains(text(),
		// 'Register')])[1]")).click();

	}

	@When("User enter details into the below fileds")
	public void user_enter_details_into_the_below_fileds(DataTable dataTable) {
		cm = new commonutils();
		Map<String, String> dataMap = dataTable.asMap(String.class, String.class);
		registerpage = new RegisterPage(driver);
		registerpage.enterFirstNameInFirstNameField(dataMap.get("firstName"));
		registerpage.enterLastNameInLastNameField(dataMap.get("lastName"));
		registerpage.enterEmailInEmailField(cm.getEmailTimeStamp1());
		registerpage.entertelephoneNumberinTelephoneField(dataMap.get("telephone"));
		registerpage.enterpassIntoPassField(dataMap.get("passwords"));
		registerpage.enterconfirmPassIntoConfirmPassField(dataMap.get("passwords"));

		// driver.findElement(By.id("input-firstname")).sendKeys(dataMap.get("firstName"));
		// driver.findElement(By.id("input-lastname")).sendKeys(dataMap.get("lastName"));
		// driver.findElement(By.id("input-email")).sendKeys(getEmailTimeStamp1());
		// driver.findElement(By.id("input-telephone")).sendKeys(dataMap.get("telephone"));
		// driver.findElement(By.id("input-password")).sendKeys(dataMap.get("passwords"));
		// driver.findElement(By.id("input-confirm")).sendKeys(dataMap.get("passwords"));

	}

	@When("User enter duplicate details into the below fileds")
	public void user_enter_duplicate_details_into_the_below_fileds(io.cucumber.datatable.DataTable dataTable) {
		Map<String, String> dataMap = dataTable.asMap(String.class, String.class);

		registerpage = new RegisterPage(driver);
		registerpage.enterFirstNameInFirstNameField(dataMap.get("firstName"));
		registerpage.enterLastNameInLastNameField(dataMap.get("lastName"));
		registerpage.enterEmailInEmailField(dataMap.get("email"));
		registerpage.entertelephoneNumberinTelephoneField(dataMap.get("telephone"));
		registerpage.enterpassIntoPassField(dataMap.get("passwords"));
		registerpage.enterconfirmPassIntoConfirmPassField(dataMap.get("passwords"));

		/*
		 * driver.findElement(By.id("input-firstname")).sendKeys(dataMap.get("firstName"
		 * ));
		 * driver.findElement(By.id("input-lastname")).sendKeys(dataMap.get("lastName"))
		 * ; driver.findElement(By.id("input-email")).sendKeys(dataMap.get("email"));
		 * driver.findElement(By.id("input-telephone")).sendKeys(dataMap.get("telephone"
		 * ));
		 * driver.findElement(By.id("input-password")).sendKeys(dataMap.get("passwords")
		 * );
		 * driver.findElement(By.id("input-confirm")).sendKeys(dataMap.get("passwords"))
		 * ;
		 */
	}

	@And("User select the privacy policy")
	public void user_select_the_privacy_policy() {
		registerpage.clickOnPrivacyPolicyCheckbox();
	}

	@And("User click on contiue button")
	public void user_click_on_contiue_button() {
		registerpage = new RegisterPage(driver);
		registerpage.clickOnContinueButton();
	}

	@SuppressWarnings("deprecation")
	@Then("User account should get successfully created")
	public void user_account_should_get_successfully_created() {
		AccountPage accountpage = new AccountPage(driver);
		Assert.assertEquals("Your Account Has Been Created!", accountpage.getTextOfAccountCreatedMessage());
	}

	@When("User selects the Yes for newsletter")
	public void user_selects_the_yes_for_newsletter() {

		registerpage = new RegisterPage(driver);
		registerpage.clickcOnontinueforNewsLetterradioButton();

	}

	@SuppressWarnings("deprecation")
	@Then("User should get the proper error message.")
	public void user_should_get_the_proper_error_message() throws InterruptedException {
		Thread.sleep(3000);
		Assert.assertEquals("Warning: E-Mail Address is already registered!",
				registerpage.getTextOfemailAllreadyregitseredText());
	}

	@When("User dont enter the any fields.")
	public void user_dont_enter_the_any_fields() {
		// kept all field blank
	}

	@SuppressWarnings("deprecation")
	@Then("User should get the proper error message evry fields is mandetory.")
	public void user_should_get_the_proper_error_message_evry_fields_is_mandetory() {

		Assert.assertTrue(registerpage.getTextOfagreeTermAndConditioWarning()
				.contains("Warning: You must agree to the Privacy Policy!"));

		Assert.assertTrue(registerpage.getfirstNameMustWarningMessage()
				.contains("First Name must be between 1 and 32 characters!"));

		Assert.assertTrue(
				registerpage.getlastNameWarningMessage().contains("Last Name must be between 1 and 32 characters!"));

		Assert.assertTrue(
				registerpage.getemailWarningMessage().contains("E-Mail Address does not appear to be valid!"));

		Assert.assertTrue(
				registerpage.getphoneNumberWarningMessage().contains("Telephone must be between 3 and 32 characters!"));

		Assert.assertTrue(
				registerpage.getPassWarningMessage().contains("Password must be between 4 and 20 characters!"));

	}

}
