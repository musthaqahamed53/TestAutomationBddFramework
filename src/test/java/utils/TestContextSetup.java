package utils;

import io.cucumber.java.zh_tw.並且;
import org.openqa.selenium.WebDriver;
import pageObjects.PageObjectManager;

import java.io.IOException;

public class TestContextSetup {
	public WebDriver driver;
	public String shortNameLoc;
	public String productNameStr;
	public PageObjectManager pageObjectManager;
	public DriverManager driverManager;
	public BusinessReusables businessReusables;

	public TestContextSetup() throws IOException {
		this.driverManager = new DriverManager();
		this.pageObjectManager = new PageObjectManager(driverManager.WebDriverManager());
		this.businessReusables = new BusinessReusables(driverManager.WebDriverManager());
	}
}
