package com.projecta.automation.ui.pagefactory;

import com.projecta.automation.common.util.Element;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;


/**
 * HomePage Class contains all the Home Page elements and its related funtions
 */
public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//header/h1")
    WebElement lbl_homePage;

    @FindBy(xpath = "//label[@for = 'username']")
    WebElement lbl_userName;

    @FindBy(xpath = "//input[@id = 'username']")
    WebElement input_userName;

    @FindBy(xpath = "//button[@type= 'submit']")
    WebElement btn_go;

    @FindBy(xpath = "//p[@class= 'repo-amount']")
    WebElement lbl_repoAmount;

    @FindBy(xpath = "//p[@class= 'output-status-text']")
    WebElement lbl_noRepo;

    String lnk_repoList_xpath = "//div[@class= 'repo-list-container']/ul/li";

    String lbl_success_message = "//section[@class ='message-area']/p[@class= 'message-success']";

    String lbl_failure_message = "//section[@class ='message-area']/p[@class= 'message-failure']";

    public Boolean isHomePageHeaderVisible() {
        return lbl_homePage.isDisplayed();
    }

    public String getHomePageHeader() {
        return lbl_homePage.getText();
    }

    public Boolean isUserNameVisible() {
        return lbl_userName.isDisplayed();
    }

    public Boolean isGoButtonVisible() {
        return btn_go.isDisplayed();
    }

    public Boolean isEnterUserVisible() {
        return input_userName.isDisplayed();
    }

    @Step("Clicking Go Button")
    public void clickGo() throws Exception {
        action.click(btn_go);
    }

    @Step("Entering the username")
    public void enterUserName(String userName) throws Exception {
        action.enterValue(input_userName, userName);
    }

    public List<WebElement> getRepoList() throws Exception {
        return Element.getElements(driver, By.xpath(lnk_repoList_xpath), 3);
    }

    @Step("Clicking the {0}th Gitrepo link listed")
    public void clickLinkFromRepoList(int elementIndex) throws Exception {
        if (elementIndex <= Element.getElements(driver, By.xpath(lnk_repoList_xpath), 3).size()) {
            String linkXpath = lnk_repoList_xpath + "[" + elementIndex + "]/p/a";
            Element.getElement(driver, By.xpath(linkXpath), 3).click();
        } else {
            throw new Exception("Index greater than the repo list size");
        }
    }

    public String getRepoAmount() {
        return lbl_repoAmount.getText();
    }

    @Step("Checking the 'No Repo' message")
    public boolean isNoRepoDisplayed() {
        return Element.isDisplayed(lbl_noRepo);
    }

    @Step("Checking the 'Success' message")
    public boolean isSuccessMessageDisplayed() throws InterruptedException {
        return Element.isElementAvailable(driver, By.xpath(lbl_success_message), 3);
    }

    @Step("Checking the 'Failure' message")
    public boolean isNoGitUserMessageDisplayed() throws InterruptedException {
        return Element.isElementAvailable(driver, By.xpath(lbl_failure_message), 5);
    }

}