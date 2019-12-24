package steps;

import static org.testng.Assert.assertTrue;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.HomePage;
import pages.UserRegisterationPage;
import tests.Testbase;

public class UserRegistration extends Testbase {
	HomePage homeobj;
	UserRegisterationPage userregisterobj;

	@Given("^the user in the home page$")
	public void the_user_in_the_home_page() {
		homeobj = new HomePage(driver);
		homeobj.openRegisterPage();
	}

	@When("^I click on register link$")
	public void i_click_on_register_link() {
		assertTrue(driver.getCurrentUrl().contains("register"));
	}

	/*
	 * @When("^I entered user data$") public void i_entered_user_data() {
	 * userregisterobj = new UserRegisterationPage(driver);
	 * userregisterobj.userRegisteration("eslam2025", "lotfy2025","eslamlotfy2025@test.com", "123456789"); }
	 */
	
	@When("^I entered \"([^\"]*)\" , \"([^\"]*)\" , \"([^\"]*)\" , \"([^\"]*)\"$")
	public void i_entered(String firstname, String lastname, String email, String password) throws Throwable {
		userregisterobj = new UserRegisterationPage(driver);
		userregisterobj.userRegisteration(firstname, lastname,email, password);
		
	}
	
	@Then("^the registration page displayed successfully$")
	public void the_registration_page_displayed_successfully() {
           userregisterobj.userLogout();
	}

}
