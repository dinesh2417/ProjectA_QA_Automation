package com.projecta.automation.common.util;

import com.projecta.automation.ui.base.TestBase;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

/**
 * TestUtil Class contains all the utility methods
 */
public class TestUtil extends TestBase {

    public static String takeScreenshot() throws IOException {
        File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String currentDir = System.getProperty("user.dir");
        File screenshotPath = new File(currentDir + "\\screenshot\\" + System.currentTimeMillis() + ".png");
        FileUtils.copyFile(file, screenshotPath);
        return screenshotPath.toString();
    }

    public static void deleteAllCookies() {
        driver.manage().deleteAllCookies();
    }
}
