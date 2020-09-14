package com.projecta.automation.ui.homepagetests;

import com.projecta.automation.api.service.GitHubRepoServices;
import com.projecta.automation.common.util.RetryAnalyser;
import com.projecta.automation.common.util.TestDataProvider;
import com.projecta.automation.common.util.WindowHandle;
import com.projecta.automation.ui.base.TestBase;
import com.projecta.automation.ui.pagefactory.HomePage;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.*;

@Listeners(com.projecta.automation.common.listener.TestListener.class)
public class HomePageTest extends TestBase {
    private HomePage homePage;
    private String inCorrectHomePageHeader = "Get Github Repos1";
    GitHubRepoServices gitHubRepoServices = GitHubRepoServices.getInstance();

    @BeforeMethod
    @Parameters("browser")
    @Step("Lauching the browser and enter url")
    public void setup(@Optional("headless") String browserName) throws Exception {
        intialize(browserName);
        openPage(prop.getApplicationPropertyValue("url"));
        homePage = basePage.getInstance(HomePage.class);
    }

    @Test(description = "verify the homepage header displays properly", retryAnalyzer = RetryAnalyser.class)
    @Severity(SeverityLevel.MINOR)
    @Description("verify the homepage header displays properly")
    @Story("TC_UI_HP_S01_P01")
    public void testHomePageHeader() {
        Assert.assertEquals(homePage.getHomePageHeader(), inCorrectHomePageHeader, "Home page header not displayed properly");
    }

    // Test search git user repo list function with valid username and verify the list displayed properly
    @Test(dataProvider = "getValidUserNames", dataProviderClass = TestDataProvider.class, enabled = true, retryAnalyzer = RetryAnalyser.class)
    @Severity(SeverityLevel.BLOCKER)
    @Description("verify search git user repo list function with valid username")
    @Story("TC_UI_HP_S02_P01 & TC_UI_HP_S02_P02")
    public void testSearchGitUserRepoSuccess(String username) throws Exception {

        homePage.enterUserName(username);
        homePage.clickGo();
        Thread.sleep(500);
        //verify the success message
        Assert.assertTrue(homePage.isSuccessMessageDisplayed(), "Message not displayed");

        //verify that displayed repo amount and displayed repo list size are the same
        Assert.assertTrue(homePage.getRepoAmount().contains(String.valueOf(homePage.getRepoList().size())));

        //verify that displayed repo amount and api response repo amount are same
        String gitRepoListSizeFromAPIResponse = String.valueOf(gitHubRepoServices.getGitHubRepoSize(username));
        Assert.assertTrue(homePage.getRepoAmount().contains(gitRepoListSizeFromAPIResponse));

        //click any link from the displayed repo list and verify the navigation
        homePage.clickLinkFromRepoList(2);
        Thread.sleep(1000);
        WindowHandle.switchWindowTo(1);
        Assert.assertTrue(homePage.getCurrentURL().contains(prop.getApplicationPropertyValue("github.url")));
        Assert.assertTrue(homePage.getCurrentURL().contains("/" + username + "/"));
    }

    // Test search git user repo list function with invalid username and verify the 'user not found' message displayed
    @Test(dataProvider = "getInvalidUserNames", dataProviderClass = TestDataProvider.class, enabled = true, retryAnalyzer = RetryAnalyser.class)
    @Severity(SeverityLevel.CRITICAL)
    @Description("verify search git user repo list function with invalid username")
    @Story("TC_UI_HP_S03_N01")
    public void testSearchGitUserRepoFailure(String username) throws Exception {

        homePage.enterUserName(username);
        homePage.clickGo();
        Thread.sleep(500);
        //verify the failure message
        Assert.assertTrue(homePage.isNoGitUserMessageDisplayed(), "Message not displayed");

        //verify that repo amount section shows 'No repo'
        Assert.assertTrue(homePage.isNoRepoDisplayed());

    }

    @AfterMethod
    @Step("Closing the browser")
    public void tearDown() {
        quitBrowser();
    }
}
