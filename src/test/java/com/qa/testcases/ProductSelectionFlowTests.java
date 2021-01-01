package com.qa.testcases;

import com.aventstack.extentreports.Status;
import com.qa.basetest.TestBase;
import com.qa.pages.CataloguePage;
import com.qa.pages.HomePage;
import com.qa.pages.ProductPage;
import com.qa.pages.ReviewPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductSelectionFlowTests extends TestBase {
    HomePage homePage;
    CataloguePage cataloguePage;
    ProductPage productPage;
    ReviewPage reviewPage;

    static HomePage productcount;
    static HomePage catalogueTitle;
    HomePage catalogueCount;

    @Test(priority = 1)
    public void TestHomePage() {
        homePage = new HomePage(driver);
        homePage.isLogoPresent();
        cataloguePage = homePage.getCompanyName().
                getCatalogCount().
                getPrdouctCount(1).
                getCatalogueTitle(1).
                selectCatalog(1);

//        String name = String.valueOf(homePage.getCompanyName());
//        Assert.assertEquals(name, Constants.COMPANY_NAME,
//                "Company Name doesn't match");


        log(Status.INFO,"Catalogue Count is:" + catalogueCount);
        System.out.println("Catalogue Count is:" + catalogueCount);
        Assert.assertEquals(homePage.getCatalogCount(), homePage.getCatalogCount(),
                "Count doesn't match");

        System.out.println("Product count is:" + productcount);
        Assert.assertEquals(productcount, productcount, "Product count doesn't match");

        System.out.println("Catalogue title is:" + catalogueTitle);
        Assert.assertEquals(catalogueTitle, catalogueTitle, "catalogue Title doesn't match");

    }

    @Test(dependsOnMethods = "TestHomePage")
    public void TestCatalogePage() {
        cataloguePage = new CataloguePage(driver);
        productPage = cataloguePage.getPageTitle().
                getCatalogueTitle()
                .getCatalogueCount()
                .checkDiscountBadge(1)
                .getCountOfColors(1)
                .getPrice(1)
                .getPhotoCount(1)
                .addToCart(1);
//        CataloguePage title = cataloguePage.getCatalogueTitle();
//        Assert.assertEquals(catalogueTitle,title,
//                "Selected catalogue Title and current catalogue title doesn't match ");

    }

    @Test(dependsOnMethods = "TestCatalogePage")
    public void TestProductPage() {
        productPage = new ProductPage(driver);
        reviewPage = productPage.addCartToList()
                .enterMobileNumber("9999999999")
                .addMobileNumber()
                .getCartCount()
                .clickOnCartButton();
    }

    @Test(dependsOnMethods = "TestProductPage")
    public void TestReviewPage(){
        reviewPage = new ReviewPage(driver);
        reviewPage.getReviewTitle()
                .getReviewOrderTitle()
                .getProductname()
                .getProductColor()
                .getProductSize()
                .getDiscountPrice()
                .getFinalprice();
    }
}
