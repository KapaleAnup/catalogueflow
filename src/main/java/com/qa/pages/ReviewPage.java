package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ReviewPage extends BasePage {


    public ReviewPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(xpath = "//div[@class='content review-content']//div[@class='title']")
    private WebElement reviewTitle;

    @FindBy(xpath = "//div[@class='review-items-header']//div[@class='title']")
    private WebElement orderTitle;

    @FindBy(xpath = "//div[@class='review-item-image']")
    private WebElement productImage;

    @FindBy(className = "review-product-name")
    private WebElement reviewProductName;

    @FindBy(xpath = "(//div[@class='option-value-container']//div[@class='option-value'])[1]")
    private WebElement reviewColor;

    @FindBy(xpath = "(//div[@class='option-value-container']//div[@class='option-value'])[2]")
    private WebElement reviewSize;

    @FindBy(xpath = "//span[@class='discount-percent-text']")
    private WebElement reviewDiscountprice;

    @FindBy(xpath = "//span[@class='final-price']")
    private WebElement reviewFinalPrice;

    public ReviewPage getReviewTitle(){
        reviewTitle.getText();
        return this;
    }
    public ReviewPage getReviewOrderTitle(){
        orderTitle.getText();
        return this;
    }

    public ReviewPage getProductname(){
        reviewProductName.getText();
        return this;
    }
    public ReviewPage getProductColor(){
        reviewColor.getText();
        return this;
    }
    public ReviewPage getProductSize(){
        reviewSize.getText();
        return this;
    }

    public ReviewPage getDiscountPrice(){
        if(reviewDiscountprice.isDisplayed()){
            reviewDiscountprice.getText();
        }else {
            System.out.println("Selected Product doesn't have discount price");
        }
        return this;
    }

    public ReviewPage getFinalprice(){
        reviewFinalPrice.getText();
        return this;
    }



    public boolean isProductImagePresent(){
        if(productImage.isDisplayed()){
            System.out.println("Image is presnet");

            return true;

        }else {
            System.out.println("Image is not present");
            return false;
        }
    }

}
