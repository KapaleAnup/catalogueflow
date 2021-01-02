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

    public String getReviewTitle(){
       return reviewTitle.getText();

    }
    public String getReviewOrderTitle(){
       return orderTitle.getText();

    }

    public String getProductname(){
        return reviewProductName.getText();

    }
    public String getProductColor(){
        return reviewColor.getText();

    }
    public String getProductSize(){
        return reviewSize.getText();

    }

    public String getDiscountPrice(){
        if(reviewDiscountprice.isDisplayed()){
           return reviewDiscountprice.getText();
        }else {
            System.out.println("Selected Product doesn't have discount price");
        }

        return null;
    }

    public String getFinalprice(){
       return reviewFinalPrice.getText();

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
