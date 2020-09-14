package com.projecta.automation.common.util;

import com.projecta.automation.ui.base.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * Wait Class contains all the web driver waits
 */
public class Wait extends TestBase {
    static WebDriverWait wait;
    static WebElement elementToBeClickable;

    public static WebElement explicitWait(WebDriver driver, WebElement element, int timeoutInSeconds, int sleepInMillis) {
        wait = new WebDriverWait(driver, timeoutInSeconds);
        elementToBeClickable = wait.until(ExpectedConditions.elementToBeClickable(element));
        return elementToBeClickable;
    }

    public static WebElement explicitWait(WebDriver driver, WebElement element) {
        wait = new WebDriverWait(driver, Long.parseLong(prop.getPropertyValue("selenium-framework", "expilicitwait.timeoutInSeconds")));
        elementToBeClickable = wait.until(ExpectedConditions.elementToBeClickable(element));
        return elementToBeClickable;
    }

    public static void implicitWait(WebDriver driver, int timeoutInSeconds) {
        driver.manage().timeouts().implicitlyWait(timeoutInSeconds, TimeUnit.SECONDS);
    }

    public static void pageLoadTimeoutWait(WebDriver driver, int timeoutInSeconds) {
        driver.manage().timeouts().pageLoadTimeout(timeoutInSeconds, TimeUnit.SECONDS);
    }


}
