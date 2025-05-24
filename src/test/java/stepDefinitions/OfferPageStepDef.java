package stepDefinitions;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.cucumber.java.en.Then;
import pageObjects.LandingPage;
import pageObjects.OffersPage;
import utils.TestContextSetup;

public class OfferPageStepDef {
	TestContextSetup testContextSetup;

	public OfferPageStepDef(TestContextSetup testContextSetup) {
		this.testContextSetup = testContextSetup;
	}


	@Then("User Searched for same shortname in offers page")
	public void user_searched_for_same_shortname_in_offers_page() throws InterruptedException {
		switchToOFfersPage();
		OffersPage offersPage = testContextSetup.pageObjectManager.getOffersPage();
		offersPage.searchItem(testContextSetup.shortNameLoc);
//		WebElement searchBtn = testContextSetup.driver.findElement(By.xpath("//input[@type='search']"));
//		searchBtn.sendKeys(testContextSetup.shortNameLoc);
		Thread.sleep(2000);
	}

	public void switchToOFfersPage() {
		LandingPage landingPage = testContextSetup.pageObjectManager.getLandingPage();
		landingPage.clickTopdeals();
//		testContextSetup.driver.findElement(landingPage.topDeals).click();
		testContextSetup.businessReusables.switchWindowToChild();
	}
	

	
	@Then("Validate if products exists")
	public void validate_if_products_exists() {


		OffersPage offersPage = testContextSetup.pageObjectManager.offersPage;
		ArrayList<String> columnData = offersPage.getProductList();

		offersPage.verifyProduct(columnData,testContextSetup.productNameStr);

	}

}
