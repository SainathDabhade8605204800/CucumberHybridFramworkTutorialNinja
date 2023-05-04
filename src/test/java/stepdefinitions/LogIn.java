package stepdefinitions;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;
import pages.AccountPage;
import pages.HomePage;
import pages.LogInPage;
import utils.ElementUtils;
import utils.commonutils;

public class LogIn {
	WebDriver driver;
	private LogInPage loginPage;
	private commonutils cm;
	private DriverFactory driverfactory;

	@Given("User Navigate to log in page")
	public void user_navigate_to_log_in_page() {
		driverfactory = new DriverFactory();
		driver = driverfactory.getDriver();
		HomePage homePage = new HomePage(driver);
		homePage.clickOnMyAccount();
		homePage.clickOnLogInOptio();
	}

	@When("^User has enters valid email address (.+) into email field.$")
	public void user_has_enters_valid_email_address_into_email_field(String validemailText) {
		loginPage = new LogInPage(driver);
		loginPage.enterEmailAddressinEmailField(validemailText);
	}

	@And("^User has enters valid passwords (.+) into passwords filed$")
	public void user_has_enters_valid_passwords_into_passwords_filed(String validpassText) {
		loginPage = new LogInPage(driver);
		loginPage.enterPassinPassField(validpassText);
	}

	@And("User click on Log in button")
	public void user_click_on_log_in_button() {

		loginPage.clickOnLogInButton();
	}

	@SuppressWarnings("deprecation")
	@Then("User should get successfully logged in")
	public void user_should_get_successfully_logged_in() {

		AccountPage accountpage = new AccountPage(driver);
		Assert.assertTrue(accountpage.getDisplayStatusOfEditAccountInformation());
	}

	@When("User has enters invalid email address into email field.")
	public void user_has_enters_invalid_email_address_into_email_field1() {

		cm = new commonutils();
		loginPage = new LogInPage(driver);
		loginPage.enterEmailAddressinEmailField(cm.getEmailWithTimeStamp());
	}

	@When("User has enters invalid passwords {string} into passwords filed")
	public void user_has_enters_invalid_passwords_into_passwords_filed(String invalidpassText) {

		loginPage.enterPassinPassField(invalidpassText);
	}

	@Then("User should get proper warning message credentials miss matched")
	public void user_should_get_proper_warning_message_credentials_miss_matched() {

		Assert.assertTrue(loginPage.getProperWarningMessageIncoorectUsernameandPass());
	}

	@When("User dont enter the email address into email field.")
	public void user_dont_enter_the_email_address_into_email_field() {
		loginPage = new LogInPage(driver);
		loginPage.enterEmailAddressinEmailField("");
	}

	@When("User dont enter the passwords into passwords filed")
	public void user_dont_enter_the_passwords_into_passwords_filed() {
		loginPage = new LogInPage(driver);
		loginPage.enterPassinPassField("");
	}

}
