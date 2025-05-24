package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pageObjects.LandingPage;
import utils.TestContextSetup;

import java.io.IOException;

public class LandingPageStepDef {

    TestContextSetup testContextSetup;

    public LandingPageStepDef(TestContextSetup testContextSetup) {
        this.testContextSetup = testContextSetup;
    }

    @Given("User is on GreenCart Landing Page")
    public void user_is_on_green_cart_landing_page() throws IOException {
        WebDriver driver = testContextSetup.driverManager.WebDriverManager();
//        WebDriver driver;
        String title = driver.getTitle();
        assert title != null;
        Assert.assertTrue(title.contains("GreenKart"), "Landing Title Not Found");
        System.out.println("Title is " + title);

    }

    @When("^User Searched with Short name (.+) and Extract the Actual Name$")
    public void user_searched_with_short_name_and_extract_the_actual_name(String shortName)
            throws InterruptedException {

        LandingPage landingPage = testContextSetup.pageObjectManager.getLandingPage();
        landingPage.searchItem(shortName);

        testContextSetup.shortNameLoc = shortName;
        Thread.sleep(2000);
        testContextSetup.productNameStr = landingPage.getProductName();

        System.out.println("Product name in Home Page " + testContextSetup.productNameStr);
//		String homePageHandle = testContextSetup.driver.getWindowHandle();

    }


    @When("^User adds Quantities (.+) and adds to Cart$")
    public void user_adds_quantities_and_adds_to_cart(int quantity) throws InterruptedException {
        LandingPage landingPage = testContextSetup.pageObjectManager.getLandingPage();

        landingPage.addQuantityForItem(quantity,testContextSetup.productNameStr);
        landingPage.verifyQuantityAdded(quantity,testContextSetup.productNameStr);

    }
    @Then("User Proceeds to Cart Checkout")
    public void user_proceeds_to_cart_checkout() throws InterruptedException {
        LandingPage landingPage = testContextSetup.pageObjectManager.getLandingPage();
        landingPage.addToCart(testContextSetup.productNameStr);
    }

}
