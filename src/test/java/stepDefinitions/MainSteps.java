package stepDefinitions;

import org.testng.Assert;

import io.cucumber.java.en.*;

public class MainSteps {

	@Given("User is on Landing Page")
	public void user_is_on_landing_page() {
		System.out.println("User is on Landing Page");
	}

	@When("Login in to application sec feature")
	public void login_in_to_application2() {
		System.out.println("Login in to application sec feature");
	}
	
	@When("Login in to application")
	public void login_in_to_application() {
		System.out.println("Login in to application");
	}

	@Then("Home page is displayed")
	public void home_page_is_displayed() {
		System.out.println("Home page is displayed");
	}

	@Then("I validate the login {string} and {string}")
	public void i_validate_the_login_and(String string, String string2) {
		System.out.println("I validate the " + string + " " + string2);
	}
	
	@Then("Try for capcha {string}")
	public void try_for_capcha(String string) {
		System.out.println("I capcha the " + string);
	}
	
	@Then("^Try for capcha (.+) regex$")
	public void try_for_capcha_regex(String string) {
		System.out.println("I regex capcha the " + string);
		if(string.contentEquals("capcha3")) {
			Assert.assertTrue(false);
		}
		
	}
	@Given("Check Background Common")
	public void check_background() {
		System.out.println("****************************");
		System.out.println("Check Background Common");
	}
}
