package com.projecta.automation.common.util;

import org.testng.annotations.DataProvider;

/**
 * Class to pass Test data to test methods
 */
public class TestDataProvider {

    public static TestDataProvider getInstance() {
        return new TestDataProvider();
    }

    @DataProvider(name = "getValidUserNames")
    public Object[][] getValidUserNames() {
        return GetDataFromExcel.getData("UserNameDetails", "validUserNames");
    }

    @DataProvider(name = "getInvalidUserNames")
    public Object[][] getInvalidUserNames() {
        return GetDataFromExcel.getData("UserNameDetails", "invalidUserNames");
    }
}
