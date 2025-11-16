package stepDefinitions;

import context.TestContext;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import pages.HomePage;

public class HomeSteps {
    private TestContext testContext;
    private HomePage homePage;

    public HomeSteps(TestContext testContext) {
        this.testContext = testContext;
        homePage = testContext.getPageObjectManager().getHomePage();
    }

    @Then("Success message {string} should be displayed")
    public void success_message_should_be_displayed(String expectedMessage) {
        String actualMessage = homePage.getSuccessMessage();
        Assert.assertEquals(actualMessage, expectedMessage);
    }
}
