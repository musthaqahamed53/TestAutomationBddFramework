package stepDefinitions;

import io.cucumber.java.en.Then;
import pageObjects.CartPage;
import utils.BusinessReusables;
import utils.TestContextSetup;

public class CartPageStepDef {

    TestContextSetup testContextSetup;
    CartPage cartPage;
    public CartPageStepDef(TestContextSetup testContextSetup) {
        this.testContextSetup = testContextSetup;
        this.cartPage = testContextSetup.pageObjectManager.getCartPage();
    }

    @Then("^User Validates the Product Added with Quantity (.+)$")
    public void user_validates_the_product_added_with_quantity(int quantity) {

        BusinessReusables businessReusables = testContextSetup.businessReusables;
        cartPage.validateProductNameAndQuantity(testContextSetup.productNameStr,quantity,businessReusables);
    }
    @Then("User Validate the Checkout page buttons")
    public void user_validate_the_checkout_page_buttons() {
        cartPage.checkForButtonsInCartPage();
        System.out.println("Test");
    }

}
