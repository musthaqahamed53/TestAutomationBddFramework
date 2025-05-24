package env;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import utils.TestContextSetup;

import java.io.IOException;

public class Hooks {
	TestContextSetup testContextSetup;
	public Hooks(TestContextSetup testContextSetup){
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
	
}
