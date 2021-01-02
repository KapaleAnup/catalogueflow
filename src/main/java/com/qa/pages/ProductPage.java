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

    @FindBy(xpath = "(//div[@class='label'])[1]")
    private WebElement lableColor;

    @FindBy(xpath = "(//div[@class='label'])[2]")
    private WebElement labelSize;

    @FindBy(xpath = "//div[@class='button ']")
    private WebElement btnCart;

    @FindBy(xpath = "//input[@type='tel']")
    private WebElement inputMobileNo;

    @FindBy(xpath = "//div[@class='button']")
    private WebElement addTocartMobileNo;

    @FindBy(xpath = "//span[@class='count']")
    private WebElement cartCount;


    public void addCartToList(){
        waitForElementVisibility(btnAddTolist);
        if(btnAddTolist.isDisplayed())
        {
            clickElement(btnAddTolist);
        }else {
            System.out.println("Button is not present");
        }
    }

    public String enterMobileNumber(String number){
        waitForElementVisibility(inputMobileNo);
        writeText(inputMobileNo,number);

        return number;
    }

    public void addMobileNumber(){
        waitForElementVisibility(addTocartMobileNo);
        clickElement(addTocartMobileNo);
    }

    public String getCartCount(){
        return cartCount.getText();
    }

    public String getColor(){
        return lableColor.getText();
    }

    public String getSize(){
        return labelSize.getText();
    }

    public ReviewPage clickOnCartButton(){
        clickElement(btnCart);
        return new ReviewPage(driver);
    }


}
