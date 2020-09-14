package com.projecta.automation.ui.webdriver;

import com.projecta.automation.ui.base.TestBase;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;

/**
 * Driver Factory class to get Browser type and return the corresponding Webdriver instance
 */
public class DriverFactory extends TestBase {

    public static String browser;
    private ThreadLocal<WebDriver> tldriver = new ThreadLocal<>();
    private Logger log = LogManager.getLogger(getClass());

    public DriverFactory(String browser) {
        this.browser = browser;
    }

    /**
     * getBrowser fetches browser type from maven options and property file.
     * Highest priority is given to maven options . if its null , it searches for property file
     * if property is also null or empty . it selects default as chrome browser
     */
    public synchronized WebDriver getDriver() {
        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.getInstance(DriverManagerType.CHROME).setup();
            ChromeOptions options = new ChromeOptions();
            options.setExperimentalOption("useAutomationExtension", false);
            log.info("Launching Chrome browser");
            tldriver.set(new ChromeDriver(options));
            log.info("Chrome browser launched");
            return tldriver.get();
        }
        if (browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.getInstance(DriverManagerType.FIREFOX).setup();
            File pathBinary = new File(System.getProperty("user.home") + prop.getPropertyValue("selenium-framework", "firefox.path"));
            FirefoxBinary firefoxBinary = new FirefoxBinary(pathBinary);
            DesiredCapabilities desired = DesiredCapabilities.firefox();
            FirefoxOptions options = new FirefoxOptions();
            desired.setCapability(FirefoxOptions.FIREFOX_OPTIONS, options.setBinary(firefoxBinary));
            log.info("Launching Firefox browser");
            tldriver.set(new FirefoxDriver(options));
            log.info("Firefox browser launched");
            return tldriver.get();
        }
        if (browser.equalsIgnoreCase("headless")) {
            WebDriverManager.getInstance(DriverManagerType.CHROME).setup();
            ChromeOptions options = new ChromeOptions();
            options.setExperimentalOption("useAutomationExtension", false);
            options.setHeadless(true);
            tldriver.set(new ChromeDriver(options));
            return tldriver.get();
        }
        return tldriver.get();
    }
}
