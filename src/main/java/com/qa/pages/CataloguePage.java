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
    @FindBy(xpath = "//div[@class='price']")
    private List<WebElement>productPrice;
    @FindBy(xpath = "//div[@class='picture-count']")
    private List<WebElement>pictureCount;

    @FindBy(xpath = "//div[@class='text-container']")
    private List<WebElement>btnAddToCart;
    @FindBy(xpath = "//div[@class='home-product-row']//a")
    private List<WebElement>productlist;

    public CataloguePage getPageTitle(){

        driver.getTitle();
        return this;
    }
    public CataloguePage getCatalogueTitle(){
        String title = catalogueName.getText();
        System.out.println("Catalogue Title is :" + title);
        return this;
    }

    public CataloguePage getCatalogueCount(){

        String count = catalogueCount.getText();
        System.out.println("Catalogue Page count is :" + count);
        return this;
    }
    public void downloadPDF(){ clickElement(downloadPDF); }

    public CataloguePage checkDiscountBadge(int index){
        int discountBadgecount = discountBadge.size();
        try {
            for(int i=0;i<discountBadgecount;i++) {
                if (discountBadge.get(i).isDisplayed()){
                    String discountBadgeDisc = discountBadge.get(index).getText();
                    System.out.println("Badge discount description is : "+discountBadgeDisc);
                    break;
                }else if(!discountBadge.get(i).isDisplayed()){
                    System.out.println("No DiscountBadge is available.");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return this;

    }

    public CataloguePage getCountOfColors(int index){
        int color = colorCount.size();
        for (int i=0;i<color;i++){
            if (colorCount.get(i).isDisplayed()) {
                String colorData = colorCount.get(index).getText();
                System.out.println("color count is :" + color);
                break;
            }
            else {
                System.out.println("Colors are not available.");
            }
        }
        return this;
    }

    public CataloguePage getPrice(int index){
        int price = productPrice.size();

        for (int i = 0; i < price; i++) {
            if (productPrice.get(i).isDisplayed()) {
                String priceData = productPrice.get(i).getText();
                System.out.println("Price Data :" + priceData);
                break;
            }else {
                System.out.println("Prices are not available.");
            }
        }

        return this;
    }

    public CataloguePage getPhotoCount(int index){
        int photocount = pictureCount.size();
        try {
            for(int i=0;i<photocount;i++) {
                if (pictureCount.get(i).isDisplayed()){
                    String photo = pictureCount.get(i).getText();
                    System.out.println("photo count is : "+photo);
                    break;
                }else {
                    System.out.println("No photo available.");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return this;

    }
    public ProductPage addToCart(int index){
        int addTocart = btnAddToCart.size();
        try {
            for(int i=0;i<addTocart;i++) {
                if (btnAddToCart.get(index).isDisplayed()){
                    btnAddToCart.get(index).click();
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
