package stepDefinitions;

import io.cucumber.java.en.Given;
import utils.ExcelUtils;

import java.util.List;

public class LoginStepDef {

    private static List<String[]> loginData;
    private static int currentRow = 0;

    @Given("I login with {string} and {string}")
    public void i_login_with_and(String placeholderUser, String placeholderPass) throws Exception {
        if (loginData == null) {
            loginData = ExcelUtils.readLoginData("src/test/resources/test_data.xlsx", 0);
        }

        if (currentRow >= loginData.size()) {
            throw new RuntimeException("Not enough data in Excel for multiple scenario runs.");
        }

        String[] dataRow = loginData.get(currentRow++);
        String username = dataRow[0];
        String password = dataRow[1];

        System.out.println("Login Attempt: " + username + " / " + password);
        // Your login logic using username & password
    }
}
