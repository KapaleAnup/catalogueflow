package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CataloguePage extends BasePage{


    public CataloguePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@id='CATALOGUE-INFO']//div[@class='title']")
    private WebElement catalogueName;
    @FindBy(xpath = "//div[@id='CATALOGUE-INFO']//div[@class='subtitle']")
    private WebElement catalogueCount;
    @FindBy(id = "downloadPdf")
    private WebElement downloadPDF;
    @FindBy(xpath = "//div[@class='tag  light']")
    private List<WebElement> tagList;
    @FindBy(xpath = "//div[contains(@class,'discount-badge')]")
    private List<WebElement>discountBadge;
    @FindBy(xpath = "//div[@class='countOfAvailableColors']")
    private List<WebElement>colorCount;
    @FindBy(xpath = "(//div[@class='price']//span)[1]")
    private List<WebElement>productPrice;
    @FindBy(xpath = "//div[@class='picture-count']")
    private List<WebElement>pictureCount;

    @FindBy(xpath = "//div[@class='text-container']")
    private List<WebElement>btnAddToCart;
    @FindBy(xpath = "//div[@class='home-product-row']//a")
    private List<WebElement>productlist;

    public String getPageTitle(){
       return driver.getTitle();
    }
    public String getCatalogueTitle(){
        waitForElementVisibility(catalogueName);
        return catalogueName.getText();
    }
    public String getCatalogueCount(){
        return catalogueCount.getText();
    }
    public void downloadPDF(){
        clickElement(downloadPDF);
    }

    public String checkDiscountBadge(){
        int discountBadgecount = discountBadge.size();
        try {
            for(int i=0;i<discountBadgecount;i++) {
                if (discountBadge.get(i).isDisplayed()){
                    return discountBadge.get(i).getText();
                }else if(!discountBadge.get(i).isDisplayed()){
                    System.out.println("No DiscountBadge is available.");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public String getCountOfColors(){
        int color = colorCount.size();
        try {
            for (int i=0;i<color;i++){
                if (colorCount.get(i).isDisplayed()) {
                    return colorCount.get(i).getText();
                }
                else {
                    System.out.println("Colors are not available.");
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }

    public String getPrice(){
        int price = productPrice.size();
        for (int i = 0; i < price; i++) {
            if (productPrice.get(i).isDisplayed()) {
              return productPrice.get(i).getText();
            }else {
                System.out.println("Prices are not available.");
            }
        }
        return null;
    }

    public String getPhotoCount(){
        int photocount = pictureCount.size();
        try {
            for(int i=0;i<photocount;i++) {
                if (pictureCount.get(i).isDisplayed()){
                   return pictureCount.get(i).getText();

                }else {
                    System.out.println("No photo available.");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


        return null;
    }
    public ProductPage addToCart(){
        int addTocart = btnAddToCart.size();
        try {
            for(int i=0;i<addTocart;i++) {
                if (btnAddToCart.get(i).isDisplayed()){
                    btnAddToCart.get(i).click();
                    System.out.println("Add To cart Button is clicked and Product added to the cart.");
                    break;
                }else {
                    System.out.println("Add To cart Button is missing.");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new ProductPage(driver);

    }

}
