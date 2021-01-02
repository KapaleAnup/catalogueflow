package com.qa.pages;

import com.qa.constants.Constants;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class BasePage {
    public WebDriver driver;
    private String readText;

    public BasePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    protected void waitforElementToShow(WebElement element){
        new WebDriverWait(driver, Constants.getExplicitWait()).
                until(ExpectedConditions.presenceOfElementLocated((By) element));

    }
    protected void waitforElementToClick(WebElement locator){
        new WebDriverWait(driver,Constants.getExplicitWait()).
                until(ExpectedConditions.elementToBeClickable(locator));

    }
    public void waitForElementVisibility(WebElement element)
    {
        new WebDriverWait(driver, Constants.getExplicitWait()).
                until(ExpectedConditions.visibilityOf(element));
    }

    public void clickElement(WebElement element)
    {
        waitForElementVisibility(element);
        try {
            if (element.isDisplayed() || element.isEnabled())
                element.click();
        }
        catch (NoSuchElementException e)
        {
            e.printStackTrace();
            throw new RuntimeException("Element not found!!! " + element);

        }

    }

    public void writeText(WebElement element, String str)
    {
        waitForElementVisibility(element);
        try
        {
            if(element.isEnabled()||element.isDisplayed()) {
                element.clear();
                element.sendKeys(str);

            }
        }
        catch (Exception e)
        {
            // e.printStackTrace();
            throw new RuntimeException("Searched element is not found!!! "+element);
        }
    }

    public String readText(WebElement element) {

        waitForElementVisibility(element);
        try {
            if (element.isDisplayed() || element.isEnabled())
            {
                readText = element.getText();
            }

        } catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException("Text not readable !!! "+element);
        }
        return readText;

    }

    public void clickElementJavaScript(WebElement element){
        waitForElementVisibility(element);
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();", element);
    }

    public void scrollPage(List<WebElement> element){
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].scrollIntoView();", element);
    }

    public void clickElementWithJavaScript(List<By> element){
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();", element);
    }

}
