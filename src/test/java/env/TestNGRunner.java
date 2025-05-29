package env;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(dryRun = false, features = {"src/test/resources/features/addToCart.feature", "src/test/resources/features/searchProduct.feature"},
        glue = {"stepDefinitions", "env"}, monochrome = true, tags = "@SmokeTest or @Regex or @SearchTest or @AddToCart",
        plugin = {"pretty", "html:target/cucumber.html", "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
                "rerun:target/failed_scenarios.txt"})
public class TestNGRunner extends AbstractTestNGCucumberTests {


    @DataProvider(parallel = false)
    @Override
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
