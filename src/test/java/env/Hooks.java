package env;

import com.aventstack.extentreports.reporter.FileUtil;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import utils.TestContextSetup;

import java.io.File;
import java.io.IOException;

public class Hooks {
    TestContextSetup testContextSetup;

    public Hooks(TestContextSetup testContextSetup) {
        this.testContextSetup = testContextSetup;
    }

    @Before("not @HookedTest")
    public void check_background() {
        System.out.println("****************************");
        System.out.println("Before Hook");
    }

    @After
    public void tearDown() throws IOException {
        testContextSetup.driverManager.WebDriverManager().quit();
        System.out.println("After Hook");
        System.out.println("****************************");
    }

    @AfterStep
    public void AddScreenShot(Scenario scenario) throws IOException {
        WebDriver driver = testContextSetup.driverManager.WebDriverManager();
        if(scenario.isFailed()){
            File sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            byte[] fileContent= FileUtils.readFileToByteArray(sourcePath);
            scenario.attach(fileContent,"image/png","image");
        }
    }
}

