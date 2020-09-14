package com.projecta.automation.ui.pagefactory;

import com.projecta.automation.common.util.Action;
import com.projecta.automation.common.util.Element;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import java.lang.reflect.InvocationTargetException;

/**
 * BasePage class for the page factory
 */
public class BasePage {

    public WebDriver driver;
    public Action action;
    public Element element;
    public JavascriptExecutor js;
    private Logger log = LogManager.getLogger(getClass());

    public BasePage(WebDriver driver) {
        this.driver = driver;
        action = new Action(driver);
        element = new Element();
        js = (JavascriptExecutor) driver;
    }

    //Method to return the desired page class instance
    public <TPage> TPage getInstance(Class<TPage> pageClass) {
        try {
            log.info("New instance creating for the pageclass : " + pageClass.getName());
            return pageClass.getDeclaredConstructor(WebDriver.class).newInstance(this.driver);

        } catch (InstantiationException e) {
            log.error("Failed creating new instance of : " + pageClass.getName() + "due to" + e.getMessage());
            e.printStackTrace();
            return null;
        } catch (InvocationTargetException e) {
            log.error("Failed creating new instance of : " + pageClass.getName() + "due to" + e.getMessage());
            e.printStackTrace();
            return null;
        } catch (NoSuchMethodException e) {
            log.error("Failed creating new instance of : " + pageClass.getName() + "due to" + e.getMessage());
            e.printStackTrace();
            return null;
        } catch (IllegalAccessException e) {
            log.error("Failed creating new instance of : " + pageClass.getName() + "due to" + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    public WebDriver getDriver() {
        return driver;
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public String getCurrentURL() {
        return driver.getCurrentUrl();
    }

}
