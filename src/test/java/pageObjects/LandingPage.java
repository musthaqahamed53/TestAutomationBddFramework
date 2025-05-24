package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class LandingPage {
    public WebDriver driver;
    public LandingPage(WebDriver driver) {
        this.driver = driver;
    }
    private By search = By.xpath("//input[@type='search']");
    private By productName = By.cssSelector("h4.product-name");
    private By topDeals = By.linkText("Top Deals");
    private By cartImg = By.xpath("//img[@alt='Cart']");
    private By proceedToCheckOut = By.xpath("//button[text()='PROCEED TO CHECKOUT']");


    public void searchItem(String name){
        driver.findElement(search).sendKeys(name);
    }

    public String getProductName(){
        return driver.findElement(productName).getText().split(" ")[0];
    }
    public void clickTopdeals(){
        driver.findElement(topDeals).click();
    }

    public void addQuantityForItem(int quantity, String productNameStr) throws InterruptedException {

        WebElement plusIconElem = driver.findElement(By.xpath("//h4[contains(text(),'"+productNameStr+"')]/parent::div//a[@class='increment']"));

        for(int i=1;i<quantity;i++){
            plusIconElem.click();
        }

    }

    public void verifyQuantityAdded(int quantity, String productNameStr) {
        WebElement quantityElem = driver.findElement(By.xpath("//h4[contains(text(),'"+productNameStr+"')]/parent::div//input"));
        String actualQuantity = quantityElem.getDomProperty("value");
        if(actualQuantity != null){
            Assert.assertEquals(quantity, Integer.parseInt(actualQuantity));
        }
        else{
            Assert.fail("Quantity is null");
        }
    }

    public void addToCart(String productNameStr) throws InterruptedException {
        WebElement addToCart = driver.findElement(By.xpath("//h4[contains(text(),'"+productNameStr+"')]/parent::div//button"));
        addToCart.click();
        driver.findElement(cartImg).click();
        driver.findElement(proceedToCheckOut).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlContains("cart"));
    }
}
