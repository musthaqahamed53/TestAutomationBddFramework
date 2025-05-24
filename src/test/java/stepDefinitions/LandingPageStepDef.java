package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageObjects.LandingPage;
import utils.BusinessReusables;
import utils.TestContextSetup;

import java.io.IOException;

public class LandingPageStepDef {

    TestContextSetup testContextSetup;
    LandingPage landingPage;
    BusinessReusables businessReusables;
    public LandingPageStepDef(TestContextSetup testContextSetup) {
        this.testContextSetup = testContextSetup;
        this.landingPage = testContextSetup.pageObjectManager.getLandingPage();
        this.businessReusables = testContextSetup.businessReusables;
    }

    @Given("User is on GreenCart Landing Page")
    public void user_is_on_green_cart_landing_page() throws IOException {
        Assert.assertTrue(businessReusables.verifyTitle("GreenKart"));
    }

    @When("^User Searched with Short name (.+) and Extract the Actual Name$")
    public void user_searched_with_short_name_and_extract_the_actual_name(String shortName)
            throws InterruptedException {
        landingPage.searchItem(shortName);
        testContextSetup.shortNameLoc = shortName;
        Thread.sleep(2000);
        testContextSetup.productNameStr = landingPage.getProductName();
        System.out.println("Product name in Home Page " + testContextSetup.productNameStr);

    }


    @When("^User adds Quantities (.+) and adds to Cart$")
    public void user_adds_quantities_and_adds_to_cart(int quantity) throws InterruptedException {
        landingPage.addQuantityForItem(quantity,testContextSetup.productNameStr);
        landingPage.verifyQuantityAdded(quantity,testContextSetup.productNameStr);

    }
    @Then("User Proceeds to Cart Checkout")
    public void user_proceeds_to_cart_checkout() throws InterruptedException {
        landingPage.addToCart(testContextSetup.productNameStr);
    }

}
