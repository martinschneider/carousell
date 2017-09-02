package at.mschneider.appium.tests;

import java.net.URL;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.codeborne.selenide.WebDriverRunner;

import io.appium.java_client.android.AndroidDriver;

/**
 * Base class for Appium tests
 */
public abstract class AppiumTest
{
    public static WebDriver driver;

    @BeforeSuite
    public void setUp() throws Exception
    {
        String userDir = System.getProperty("user.dir");
        String localApp = "carousell.apk";
        String appPath = Paths.get(userDir, localApp).toAbsolutePath().toString();
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", "Android");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("app", appPath);
        capabilities.setCapability("appPackage", "com.thecarousell.Carousell");
        capabilities.setCapability("appActivity", "com.thecarousell.Carousell.activities.EntryActivity");
        URL serverAddress = new URL("http://127.0.0.1:4723/wd/hub");
        driver = new AndroidDriver<WebElement>(serverAddress, capabilities);
        driver.manage().timeouts().implicitlyWait(1500, TimeUnit.MILLISECONDS);
        WebDriverRunner.setWebDriver(driver);
    }

    @AfterSuite
    public void tearDown() throws Exception
    {
        if (driver != null)
        {
            driver.quit();
        }
    }
}