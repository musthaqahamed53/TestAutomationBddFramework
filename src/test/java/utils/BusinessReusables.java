package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class BusinessReusables {
    public WebDriver driver;

    public BusinessReusables(WebDriver driver){
        this.driver = driver;
    }

    public void switchWindowToChild(){
        Set<String> windowHandles = driver.getWindowHandles();
        Iterator<String> i1 = windowHandles.iterator();
        String parentWindow = i1.next();
        String childWindow = i1.next();
        driver.switchTo().window(childWindow);
    }

    public int getColumnIndexByHeader(WebElement tableElem,String headerName){
        int headerIndex = -1;
        List<WebElement> headers = tableElem.findElements(By.xpath("./thead/tr/td"));
        for(int i = 0; i<headers.size(); i++){
            if(headers.get(i).findElement(By.tagName("b")).getText().equalsIgnoreCase(headerName)){
                headerIndex = i;
                break;
            }
        }
        return headerIndex;
    }

    public List<WebElement> getTableRows(WebElement tableElem){
        return tableElem.findElements(By.xpath(".//tbody/tr"));
    }
}
