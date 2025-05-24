package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.BusinessReusables;

import java.time.Duration;
import java.util.List;
import java.util.UUID;

public class CartPage {

    public WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public By cartTable = By.xpath("//table[@class='cartTable']");
    public By promobtn = By.xpath("//button[@class='promoBtn']");
    public By promoField = By.xpath("//input[@class='promoCode']");
    public By promoInfo = By.xpath("//span[@class='promoInfo']");
    public By placeOrder = By.xpath("//button[text()='Place Order']");

    public void validateProductNameAndQuantity(String productNameStr, int quantity, BusinessReusables businessReusables) {

        WebElement cartTableElem = driver.findElement(cartTable);
        int ProductNameIndex = businessReusables.getColumnIndexByHeader(cartTableElem, "Product Name");
        if (ProductNameIndex == -1) {
            Assert.fail("Header not found!");
            driver.quit();
        }

        int QuantityIndex = businessReusables.getColumnIndexByHeader(cartTableElem, "Quantiry");
        if (QuantityIndex == -1) {
            Assert.fail("Header not found!");
            driver.quit();
        }

        List<WebElement> rows = businessReusables.getTableRows(cartTableElem);
        for (WebElement row : rows) {
            List<WebElement> coulumnData = row.findElements(By.xpath(".//td"));
            String prodName = coulumnData.get(ProductNameIndex).findElement(By.xpath("./p")).getText().split(" ")[0];
            if (prodName.contentEquals(productNameStr)) {
                Assert.assertEquals(quantity, Integer.parseInt(coulumnData.get(QuantityIndex).findElement(By.xpath("./p")).getText()), "Quantity Present is " + Integer.parseInt(coulumnData.get(QuantityIndex).findElement(By.xpath("./p")).getText()));
                break;
            }
        }


    }

    public void checkForButtonsInCartPage() throws InterruptedException {
        String randomStr = UUID.randomUUID().toString().replace("-", "").substring(0, 10);
        driver.findElement(promoField).sendKeys(randomStr);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(promobtn)).click();
        WebElement promoTextElem = wait.until(ExpectedConditions.presenceOfElementLocated(promoInfo));
        Assert.assertEquals(promoTextElem.getText(),"Invalid code ..!");
//        Thread.sleep(4000);
    }
}
