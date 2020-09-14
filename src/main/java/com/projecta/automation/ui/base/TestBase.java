package com.projecta.automation.ui.base;


import com.projecta.automation.common.config.ConfigPropertyLoader;
import com.projecta.automation.common.listener.WebEventListener;
import com.projecta.automation.common.util.TestUtil;
import com.projecta.automation.common.util.Wait;
import com.projecta.automation.ui.pagefactory.BasePage;
import com.projecta.automation.ui.webdriver.DriverFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

/**
 * Test Base class for Web Testing
 */
public class TestBase {
    public static WebDriver driver;
    public static ConfigPropertyLoader prop;
    private static EventFiringWebDriver event_driver;
    private static WebEventListener event_listener;
    public static BasePage basePage;
    private Logger log = LogManager.getLogger(getClass());

    public TestBase() {
        this.prop = ConfigPropertyLoader.getInstance();
    }

    public void intialize(String browser) {
        driver = new DriverFactory(browser).getDriver();
        event_driver = new EventFiringWebDriver(driver);
        event_listener = new WebEventListener();
        event_driver.register(event_listener);
        driver = event_driver;

        basePage = new BasePage(driver);
        driver.manage().window().maximize();

        log.info("Deleting all the cookies");
        TestUtil.deleteAllCookies();
    }

    public void openPage(String url) {
        log.info("Entering URL into the browser");
        driver.get(url);
        Wait.pageLoadTimeoutWait(driver, 20);
        Wait.implicitWait(driver, 20);
    }

    public void quitBrowser() {
        log.info("Closing the browser");
        driver.quit();
        driver = null;
        log.info("Browser closed");
    }
}