package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class OffersPage {
    public WebDriver driver;

    public OffersPage(WebDriver driver) {
        this.driver = driver;
    }

    By search = By.xpath("//input[@type='search']");

    public void searchItem(String name) {
        driver.findElement(search).sendKeys(name);
    }

    public ArrayList<String> getProductList() {
        // Locate the table
        WebElement table = driver.findElement(By.tagName("table")); // or other locator

        // Get all header elements
        List<WebElement> headers = table.findElements(By.tagName("th"));
        int targetColIndex = -1;

        // Loop through headers to find the one with a <span> matching the desired name
        for (int i = 0; i < headers.size(); i++) {
            WebElement span = headers.get(i).findElement(By.tagName("span"));
            if (span.getText().trim().equalsIgnoreCase("Veg/fruit name")) {
                targetColIndex = i;
                break;
            }
        }
        if (targetColIndex == -1) {
            System.out.println("Header not found!");
            driver.quit();
        }
        // Get all data rows (excluding header row)
        List<WebElement> rows = table.findElements(By.xpath(".//tbody/tr"));
        ArrayList<String> columnData = new ArrayList<String>();

        for (WebElement row : rows) {
            List<WebElement> cells = row.findElements(By.tagName("td"));
            if (cells.size() > targetColIndex) {
                columnData.add(cells.get(targetColIndex).getText());
            }
        }
        return columnData;
    }

    public void verifyProduct(List<String> columnData, String productNameStr) {
        boolean assertBool = false;
        for (String rowProduct : columnData) {
            if (rowProduct.contentEquals(productNameStr)) {
                System.out.println("Product is Found " + productNameStr);
                assertBool = true;
                break;
            }
        }
        if (!assertBool) {
            Assert.fail("Expected Product " + productNameStr + " is Not Found. Listed Products " + columnData);
        }

    }
}
