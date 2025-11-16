package stepDefinitions;

import context.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;

public class LoginSteps {
    private TestContext testContext;
    private LoginPage loginPage;

    public LoginSteps(TestContext testContext) {
        this.testContext = testContext;
        loginPage = testContext.getPageObjectManager().getLoginPage();
    }

    @Given("User is on the practice login page")
    public void user_is_on_the_practice_login_page() {

    }

    @When("User enters valid username {string}")
    public void user_enters_valid_username(String username) {
        loginPage.enterUsername(username);
    }

    @When("User enters valid password {string}")
    public void user_enters_valid_password(String password) {
        loginPage.enterPassword(password);
    }

    @When("User clicks the login button")
    public void user_clicks_the_login_button() {
        loginPage.clickSubmit();
    }
}
