package pageObjects;

import org.openqa.selenium.WebDriver;
import stepDefinitions.CartPageStepDef;

public class PageObjectManager {

    public WebDriver driver;
    public LandingPage landingPage;
    public OffersPage offersPage;
    public CartPage cartPage;

    public PageObjectManager(WebDriver driver){
        this.driver = driver;
    }
    public LandingPage getLandingPage(){
        return landingPage = new LandingPage(driver);
    }
    public OffersPage getOffersPage(){
        return offersPage = new OffersPage(driver);
    }

    public CartPage getCartPage(){
        return cartPage = new CartPage(driver);
    }

}
