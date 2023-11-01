package steps;

import org.openqa.selenium.WebDriver;
import selenium_core.DriverManager;
import selenium_core.DriverManagerFactory;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    WebDriver driver;
    DriverManager driverManager;

    public void setup(String browser, int wait) {
        driverManager = DriverManagerFactory.getDriverManager(browser);
        driver = driverManager.getWebDriver();
        driver.manage().timeouts().implicitlyWait(wait, TimeUnit.SECONDS);
    }

    public void basequit() {
        driverManager.quit();
    }
}
