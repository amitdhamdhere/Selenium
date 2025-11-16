package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class DriverFactory {
    private static ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<>();

    public static WebDriver initDriver() throws IOException {
        Properties properties = new Properties();
        FileInputStream fileInputStream = new FileInputStream(new File(System.getProperty("user.dir")) + "/src/test/resources/config.properties");
        properties.load(fileInputStream);

        String browser = (System.getProperty("browser") == null) ? properties.getProperty("browser") : System.getProperty("browser");

        switch (browser.toLowerCase()) {
            case "chrome":
                threadLocalDriver.set(new ChromeDriver());
                break;

            case "firefox":
                threadLocalDriver.set(new FirefoxDriver());
                break;

            case "edge":
                threadLocalDriver.set(new EdgeDriver());
                break;

            default:
                System.out.println("Browser is not supported....");
        }
        threadLocalDriver.get().manage().window().maximize();
        threadLocalDriver.get().get(properties.getProperty("URL"));
        return threadLocalDriver.get();
    }

    public static void quitDriver() {
        threadLocalDriver.get().quit();
        threadLocalDriver.remove();
    }
}
