package stepDefinitions;

import io.cucumber.java.en.Then;
import pageObjects.LandingPage;
import pageObjects.OffersPage;
import utils.TestContextSetup;

import java.util.ArrayList;

public class OfferPageStepDef {
	TestContextSetup testContextSetup;
	OffersPage offersPage;
	LandingPage landingPage;
	public OfferPageStepDef(TestContextSetup testContextSetup) {
		this.testContextSetup = testContextSetup;
		this.offersPage = testContextSetup.pageObjectManager.getOffersPage();
		this.landingPage = testContextSetup.pageObjectManager.getLandingPage();
	}


	@Then("User Searched for same shortname in offers page")
	public void user_searched_for_same_shortname_in_offers_page() throws InterruptedException {
		switchToOFfersPage();

		offersPage.searchItem(testContextSetup.shortNameLoc);
//		Thread.sleep(2000);
	}

	public void switchToOFfersPage() {
		landingPage.clickTopdeals();
		testContextSetup.businessReusables.switchWindowToChild();
	}

	@Then("Validate if products exists")
	public void validate_if_products_exists() {

		ArrayList<String> columnData = offersPage.getProductList();
		offersPage.verifyProduct(columnData,testContextSetup.productNameStr);

	}

}
