package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//img[@class='logo-icon']")
    private WebElement hompageLogo;
    @FindBy(xpath = "//p[@class='companyName']")
    private WebElement companyName;
    @FindBy(xpath = "//div[@class='catalogueCount']")
    private WebElement catalogueCount;
    @FindBy(xpath = "//div[@class='catalogue-list catalogue-grid-view']//a")
    private List<WebElement> catalogueList;
    @FindBy(xpath = "//div[@class='bottom bottom-grid-layout']")
    private List<WebElement> productCount;
    @FindBy(xpath = "//div[@class='catalogue-title-grid']")
    private List<WebElement> catalogueProdcutName;

    public boolean isLogoPresent(){
        try{
            if(hompageLogo.isDisplayed()){
                return true;
            }else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Element not found!!! ");
        }

    }

    public HomePage getCompanyName(){
        companyName.getText();
        return this;
    }

    public HomePage getCatalogCount(){
       catalogueCount.getText();
        return this;
    }

    public CataloguePage selectCatalog(int index){

        int cataloguelistcount = catalogueList.size();
        System.out.println("CatalogueList Count is :"+ cataloguelistcount);
        for(int i=0;i<cataloguelistcount;i++){
            catalogueList.get(index).click();
            break;
        }

        return new CataloguePage(driver);

    }

    public HomePage getPrdouctCount(int index){
        int productItems = productCount.size();
        for (int i=0;i<productItems;i++){
             productCount.get(index).getText();
        }
        return this;
    }

    public HomePage getCatalogueTitle(int index){
        int catalogueName = catalogueProdcutName.size();
        for (int i=0;i<catalogueName;i++){
            catalogueProdcutName.get(index).getText();
        }
        return this;
    }
}
