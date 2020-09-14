package com.projecta.automation.common.util;

import com.projecta.automation.ui.base.TestBase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;

public class WindowHandle extends TestBase {

    private static Logger log = LogManager.getLogger(WindowHandle.class);

    public static ArrayList<String> getAllWindows() {
        return new ArrayList<String>(driver.getWindowHandles());
    }

    public static void switchWindowTo(String windowName) {
        log.info("Switching to window : " + windowName);
        driver.switchTo().window(windowName);
    }

    public static void switchWindowTo(int windowIndex) throws Exception {
        ArrayList<String> windowList = new ArrayList<String>(driver.getWindowHandles());
        if (windowIndex < windowList.size()) {
            log.info("Switching to window : " + windowList.get(windowIndex));
            driver.switchTo().window(windowList.get(windowIndex));
        } else {
            log.error("Failed to switch window due to Index greater than window list");
            throw new Exception("Index greater than the number of actual window");
        }
    }
}
