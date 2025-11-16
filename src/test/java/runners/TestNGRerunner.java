package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features = "@reports/Rerun/Rerun.txt",
        glue = {"stepDefinitions", "hooks"},
        dryRun = false,
        plugin = {
                "html:reports/Cucumber-HTML Reports/Cucumber_Report.html",
                "json:reports/Cucumber-JSON Reports/Cucumber_JSON.json",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
        }
)
public class TestNGRerunner extends AbstractTestNGCucumberTests {
    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
