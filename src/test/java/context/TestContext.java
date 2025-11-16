package context;

import base.DriverFactory;
import managers.PageObjectManager;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class TestContext {
    private WebDriver driver;
    private PageObjectManager pageObjectManager;

    public TestContext() throws IOException {
        this.driver = DriverFactory.initDriver();
        pageObjectManager = new PageObjectManager(this.driver);
    }

    public WebDriver getDriver() {
        return driver;
    }

    public PageObjectManager getPageObjectManager() {
        if (pageObjectManager == null) {
            pageObjectManager = new PageObjectManager(this.driver);
        }
        return pageObjectManager;
    }
}
