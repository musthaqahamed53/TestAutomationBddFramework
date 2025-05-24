package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class DriverManager {
    public WebDriver driver;

    public WebDriver WebDriverManager() throws IOException {
        FileInputStream fileInputStream = new FileInputStream(System.getProperty("user.dir")+"//src//test//resources//globalSettings.properties");
        Properties properties = new Properties();
        properties.load(fileInputStream);
        if(driver == null){
            if(properties.getProperty("browser").equalsIgnoreCase("chrome")){
                driver = new ChromeDriver();
            } else if (properties.getProperty("browser").equalsIgnoreCase("firefox")) {
                driver = new FirefoxDriver();
            } else if (properties.getProperty("browser").equalsIgnoreCase("edge")) {
                driver = new EdgeDriver();
            }


            driver.get(properties.getProperty("url"));
            driver.manage().window().maximize();
        }
        return driver;
    }
}
