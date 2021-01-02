package com.qa.testcases;

import com.aventstack.extentreports.Status;
import com.qa.basetest.TestBase;
import com.qa.constants.Constants;
import com.qa.pages.CataloguePage;
import com.qa.pages.HomePage;
import com.qa.pages.ProductPage;
import com.qa.pages.ReviewPage;
import com.qa.utilities.ExcelOperations;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.HashMap;

public class ProductSelectionFlowTests extends TestBase {
    HomePage homePage;
    CataloguePage cataloguePage;
    ProductPage productPage;
    ReviewPage reviewPage;

    String homeproductCount;
    String hompecatalogueTitle;
    String cataloguePageCatalogueTitle;
    String cataloguePagePrice;
    String productPageColor;
    String productPageSize;
    String cataloguePagediscountBadge;

    ExcelOperations excelOperations = new ExcelOperations("mobileNumber");

    @Test(priority = 1)
    public void TestHomePage() {
        homePage = new HomePage(driver);

        Assert.assertTrue(homePage.isLogoPresent(),"Logo is not present");

        String homePageCompanyName = homePage.getCompanyName();
        log(Status.INFO,"Campany Name is :" + homePageCompanyName);
        Assert.assertEquals(homePageCompanyName,Constants.COMPANY_NAME,"Company Name doesn't match.");

        String homePageCatalogCount= homePage.getCatalogCount();
        log(Status.INFO,"Total catalogue count is :" + homePageCatalogCount);
        Assert.assertEquals(homePageCatalogCount,homePage.getCatalogCount()," catalogue Count doesn't match.");

        homeproductCount = homePage.getPrdouctCount(1);
        log(Status.INFO,"Total product count is :" + homeproductCount);
        Assert.assertEquals(homeproductCount,homePage.getPrdouctCount(1),"Product count doesn't match.");

        hompecatalogueTitle =  homePage.getCatalogueTitle(1);
        log(Status.INFO,"Catalogue title is :" + hompecatalogueTitle);
        Assert.assertEquals(hompecatalogueTitle,homePage.getCatalogueTitle(1),"catalogue title doesn't match.");

        cataloguePage = homePage.selectCatalog(1);
        log(Status.INFO,"The user is redirected to the catalogue/product selection page");

    }

    @Test(dependsOnMethods = "TestHomePage")
    public void TestCatalogePage() {
        cataloguePage = new CataloguePage(driver);

        String cataloguePagePageTitle = cataloguePage.getPageTitle();
        log(Status.INFO,"page title is :" + cataloguePagePageTitle);
        Assert.assertEquals(cataloguePagePageTitle,cataloguePage.getPageTitle(),"page title doesn't match.");

        String cataloguePageCatalogueTitle = cataloguePage.getCatalogueTitle();
        log(Status.INFO,"Catalogue title is :" + cataloguePageCatalogueTitle);
        Assert.assertEquals(cataloguePageCatalogueTitle,hompecatalogueTitle,"catalogue title doesn't match.");

        String cataloguePageCatalogueCount = cataloguePage.getCatalogueCount();
        log(Status.INFO,"Catalogue count is :" + cataloguePageCatalogueCount);
        Assert.assertEquals(cataloguePageCatalogueCount,homeproductCount,"catalogue count doesn't match");

        cataloguePagediscountBadge = cataloguePage.checkDiscountBadge();
        log(Status.INFO,"discount badge is :" + cataloguePagediscountBadge);
        Assert.assertEquals(cataloguePagediscountBadge,cataloguePage.checkDiscountBadge(),"discount badge doesn't match");

        String cataloguePageCountOfColors = cataloguePage.getCountOfColors();
        log(Status.INFO,"count of color is :" + cataloguePageCountOfColors);
        Assert.assertEquals(cataloguePageCountOfColors,cataloguePage.getCountOfColors(),"count of colors doesn't match");

        cataloguePagePrice = cataloguePage.getPrice();
        log(Status.INFO,"price is :" + cataloguePagePrice);
        Assert.assertEquals(cataloguePagePrice,cataloguePage.getPrice(),"price doesn't match");

        String cataloguePagePhotoCount = cataloguePage.getPhotoCount();
        log(Status.INFO,"photo Count is :" + cataloguePagePhotoCount);
        Assert.assertEquals(cataloguePagePhotoCount,cataloguePage.getPhotoCount(),"photo Count doesn't match");

        productPage = cataloguePage.addToCart();
        log(Status.INFO,"The user is redirected to the product page");

    }

    /**
     * @param object this will be used to fetch mobile number from excel
     */
    @Test(dependsOnMethods = "TestCatalogePage",dataProvider = "mobileData")
    public void TestProductPage(Object object) {
        HashMap<String, String> mobile = (HashMap<String, String>) object;
        productPage = new ProductPage(driver);

        productPageColor = productPage.getColor();
        log(Status.INFO,"Product color is :" + productPageColor);
        Assert.assertEquals(productPageColor,productPage.getColor(),"color doesn't match");

        productPageSize = productPage.getSize();
        log(Status.INFO,"Product Size is :" + productPageSize);
        Assert.assertEquals(productPageSize,productPage.getSize(),"Size doesn't match");

        productPage.addCartToList();
        log(Status.INFO,"add to Cart button clicked");

        String mobileNumber = productPage.enterMobileNumber(mobile.get("mobile"));
        log(Status.INFO,"Provided mobile Number is:" + mobileNumber);

        productPage.addMobileNumber();
        log(Status.INFO,"Mobile number is added.");

        String cartCount = productPage.getCartCount();
        log(Status.INFO,"Cart Count is :" + cartCount);
        Assert.assertEquals(cartCount,productPage.getCartCount(),"cart Count doesn't match");

        reviewPage = productPage.clickOnCartButton();
        log(Status.INFO,"The user redirected to the review page");
    }

    @Test(dependsOnMethods = "TestProductPage")
    public void TestReviewPage(){
        reviewPage = new ReviewPage(driver);

        String reviewTitle = reviewPage.getReviewTitle();
        log(Status.INFO,"Review Title :" + reviewTitle);
        Assert.assertEquals(reviewTitle,reviewPage.getReviewTitle(),"Review Title doesn't match.");

        String orderTitle = reviewPage.getReviewOrderTitle();
        log(Status.INFO,"order Title :" + orderTitle);
        Assert.assertEquals(orderTitle,reviewPage.getReviewOrderTitle(),"order Title doesn't match.");

        String reviewPageProductname = reviewPage.getProductname();
        log(Status.INFO,"Review Product name is :" + reviewPageProductname);
        Assert.assertEquals(reviewPageProductname,reviewPageProductname,"Review Product name doesn't match.");

        String reviewPageProductColor = reviewPage.getProductColor();
        log(Status.INFO,"Review Product color is :" + reviewPageProductColor);
        Assert.assertEquals(reviewPageProductColor,productPageColor,"review Product Color doesn't match.");

        String reviewPageProductSize = reviewPage.getProductSize();
        log(Status.INFO,"Review Product Size is :" + reviewPageProductSize);
        Assert.assertEquals(reviewPageProductSize,productPageSize,"review Product size doesn't match.");

        String reviewPageDiscountPrice = reviewPage.getDiscountPrice();
        log(Status.INFO,"Review Product discounted price is :" + reviewPageDiscountPrice);
        Assert.assertEquals(reviewPageDiscountPrice,cataloguePagediscountBadge,"Discount price is mismatched.");

        String reviewPageFinalprice = reviewPage.getFinalprice();
        log(Status.INFO,"Final price is :" + reviewPageFinalprice);
        Assert.assertEquals(reviewPageFinalprice,reviewPage.getFinalprice(),"final price doesn't match.");

    }


    @DataProvider(name = "mobileData")
    public Object[][] testdataProvider() throws Exception {
        Object[][] obj = new Object[excelOperations.getRowCount()][1];
        for (int i = 1; i <= excelOperations.getRowCount(); i++) {
            HashMap<String, String> testData = excelOperations.getTestDataMap(i);
            obj[i - 1][0] = testData;
        }
        return obj;
    }
}
