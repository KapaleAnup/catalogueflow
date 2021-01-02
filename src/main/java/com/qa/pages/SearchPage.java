package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends BasePage{
    public SearchPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@type='search']")
    private WebElement searchBox;

    @FindBy(xpath = "//p[@class='search-by-text']")
    private WebElement searchText;

    @FindBy(xpath = "//div[@class='no-search-results']")
    private WebElement errorSearchText;



    public String enterSearchData(String searchData){
        waitForElementVisibility(searchBox);
        writeText(searchBox,searchData);
        return searchData;
    }

    public String getMessage(){
        waitForElementVisibility(searchText);
        if(searchText.isDisplayed()) {
            return searchText.getText();
        }else {
            System.out.println("No message is displayed.");
        }
        return null;
    }

    public String getErrorMessage(){
        waitForElementVisibility(errorSearchText);
        return errorSearchText.getText();
    }
}
