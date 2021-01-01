package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BasePage{
    public ProductPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(className = "add-to-list-action")
    private WebElement btnAddTolist;

    @FindBy(xpath = "//div[@class='button ']")
    private WebElement btnCart;

    @FindBy(xpath = "//input[@type='tel']")
    private WebElement inputMobileNo;

    @FindBy(xpath = "//div[@class='button']")
    private WebElement addTocartMobileNo;

    @FindBy(xpath = "//span[@class='count']")
    private WebElement cartCount;


    public ProductPage addCartToList(){
        waitForElementVisibility(btnAddTolist);
        clickElement(btnAddTolist);
        return this;
    }

    public ProductPage enterMobileNumber(String number){
        waitForElementVisibility(inputMobileNo);
        writeText(inputMobileNo,number);
        return this;
    }

    public ProductPage addMobileNumber(){
        waitForElementVisibility(addTocartMobileNo);
        clickElement(addTocartMobileNo);
        return this;
    }

    public ProductPage getCartCount(){
        readText(cartCount);
        return this;
    }

    public ReviewPage clickOnCartButton(){
        clickElement(btnCart);
        return new ReviewPage(driver);
    }


}
