package stepdefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import factory.DriverFactory;
import io.cucumber.java.en.*;
import junit.framework.Assert;
import pages.HomePage;
import pages.SearchPage;

public class Search {
	HomePage homepage;
	WebDriver driver;
	private DriverFactory driverfactory;

	@Given("User open the applications")
	public void user_open_the_applications() {

		driverfactory = new DriverFactory();
		driver = driverfactory.getDriver();
	}

	@When("user enter the valid product {string} in the search fields")
	public void user_enter_the_valid_product_in_the_search_fields(String validproductText) {
		homepage = new HomePage(driver);
		homepage.enterTheValidProductIntoSearchField(validproductText);
	}

	@When("User click on the search button")
	public void user_click_on_the_search_button() {
		homepage = new HomePage(driver);
		homepage.clickOnSearchButton();
	}

	@SuppressWarnings("deprecation")
	@Then("User should get the displayed the valid seached prodcuts")
	public void user_should_get_the_displayed_the_valid_seached_prodcuts() {

		SearchPage searchpage = new SearchPage(driver);
		Assert.assertTrue(searchpage.getValidProductSearchText().contains("HP LP3065"));
	}

	@When("user enter the Invalid product {string} in the search fields")
	public void user_enter_the_invalid_product_in_the_search_fields(String invalidproductSearch) {
		homepage = new HomePage(driver);
		homepage.enterInvalidProdcutIntoSeachField(invalidproductSearch);
	}

	@SuppressWarnings("deprecation")
	@Then("User should get the proper message about no products matching.")
	public void user_should_get_the_proper_message_about_no_products_matching() {

		SearchPage searchpage = new SearchPage(driver);
		Assert.assertTrue(searchpage.getInvalidProductSeachText()
				.contains("There is no product that matches the search criteria."));
	}

	@SuppressWarnings("deprecation")
	@When("user dont enter the any product name in search fields.")
	public void user_dont_enter_the_any_product_name_in_search_fields() {
		// intentially dont enter in the search field.

	}

}
