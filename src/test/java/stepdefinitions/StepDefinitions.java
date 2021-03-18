package stepdefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

import org.junit.After;

import com.pages.HomePage;
import com.testbase.TestBase;

public class StepDefinitions extends TestBase {
	HomePage home = new HomePage();
	
	public StepDefinitions() {
		super();
	}
	@Given("^user is on home page$")
	public void navigateToHome() {
		home.navigateToHomePage();
	}
	
	@Then("^verify right count of values appear on screen$") //do not exactly understand the ask here, my understanding is to see if we can see five value fields on the page
	public void verifyCountOfValues() {
		
	}
	
	@Then("^verify the values on the screen are greater than zero$")
	public void verifyforNonZeroFields() {
		home.verifyValuesGreaterThanZero();
	}
	
	@Then("^verify the total balance is correct based on the values listed on the screen$")
	public void verifyTotalBalance() {
		home.verifySumOfValues();
	}
	
	@Then("^verify the values are formatted as currency values$")
	public void validateCurrencyFormat() {
		home.validateValueFormat();
	}
	@After
	public void tearDown() {
		driver.quit();
	}
}
