package com.qa.testcases;

import com.aventstack.extentreports.Status;
import com.qa.basetest.TestBase;
import com.qa.constants.Constants;
import com.qa.pages.HomePage;
import com.qa.pages.SearchPage;
import com.qa.utilities.ExcelOperations;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class SearchPageTests extends TestBase {

    SearchPage searchPage;
    HomePage homePage;

    ExcelOperations excelOperations = new ExcelOperations("Search");

    @Test(dataProvider = "mobileData")
    public void TestSearch(Object object) {
        HashMap<String, String> search = (HashMap<String, String>) object;
        homePage = new HomePage(driver);
        homePage.clickOnSearch();
        searchPage = new SearchPage(driver);
        String message = searchPage.getMessage();
        Assert.assertEquals(message, Constants.SEARCH_TEXT,"Search default text is missing.");
        String invaliddata= searchPage.enterSearchData(search.get("SearchInput"));
        log(Status.INFO,"searched data : "+ invaliddata);
        String errorMessage = searchPage.getErrorMessage();
        Assert.assertEquals(errorMessage,Constants.SEARCH_ERROR_MESSAGE,"Error message doesn't match");
        String validData = searchPage.enterSearchData(search.get("SearchInput"));
        log(Status.INFO,"searched data : "+ validData);
    }

    @DataProvider(name = "mobileData")
    public Object[][] testdataProvider() throws Exception {
        Object[][] obj = new Object[excelOperations.getRowCount()][1];
        for (int i = 1; i <= excelOperations.getRowCount(); i++) {
            HashMap<String, String> testData = excelOperations.getTestDataMap(2);
            obj[i - 1][0] = testData;
        }
        return obj;
    }
}

