package com.qa.testcases;



import com.qa.basetest.TestBase;
import com.qa.constants.Constants;
import com.qa.pages.CataloguePage;
import com.qa.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTests extends TestBase {

    HomePage homePage;
    CataloguePage cataloguePage;

    static HomePage productcount;
    static HomePage catalogueTitle;
    HomePage catalogueCount;

   // @Test(priority = 1)
    public void TestPageTitle(){
        homePage = new HomePage(driver);
        Assert.assertTrue(homePage.isLogoPresent(), "Logo is not present");
    }

   // @Test(priority = 2)
    public void TestCompanyName(){
        homePage = new HomePage(driver);
       Assert.assertEquals(homePage.getCompanyName(), Constants.COMPANY_NAME,
               "Company Name doesn't match");
    }

   //  @Test(priority = 3)
    public void TestCatalogueCount(){
         homePage = new HomePage(driver);
         HomePage catalogueCount= homePage.getCatalogCount();
         System.out.println("Catalogue Count is:"+catalogueCount);
         Assert.assertEquals(homePage.getCatalogCount(),homePage.getCatalogCount(),
                 "Count doesn't match");
    }

    @Test(priority = 1)
    public void TestFlow(){
        homePage = new HomePage(driver);
      //  homePage.isLogoPresent();
        cataloguePage = homePage.getCompanyName().
                getCatalogCount().
                getPrdouctCount(1).
                getCatalogueTitle(1).
                selectCatalog(1);

        String name = String.valueOf(homePage.getCompanyName());
        Assert.assertEquals(name, Constants.COMPANY_NAME,
                "Company Name doesn't match");


        System.out.println("Catalogue Count is:"+catalogueCount);
        Assert.assertEquals(homePage.getCatalogCount(),homePage.getCatalogCount(),
                "Count doesn't match");

        System.out.println("Product count is:"+ productcount);
        Assert.assertEquals(productcount,productcount,"Product count doesn't match");

        System.out.println("Catalogue title is:"+ catalogueTitle);
        Assert.assertEquals(catalogueTitle,catalogueTitle,"catalogue Title doesn't match");
    }

    @Test(dependsOnMethods = "TestFlow")
    public void TestFlow2(){
        cataloguePage = new CataloguePage(driver);
       // cataloguePage.getCatalogueTitle();
        cataloguePage.getCatalogueTitle().
                getCatalogueCount();

        CataloguePage title = cataloguePage.getCatalogueTitle();
        Assert.assertEquals(HomePageTests.catalogueTitle,title,
                "Selected catalogue Title and current catalogue title doesn't match ");

        CataloguePage count = cataloguePage.getCatalogueCount();
        Assert.assertEquals(HomePageTests.productcount,count,
                "Selected product count and current product count doesn't match ");
    }



    /**
     * This function will check the Product count available on the product.
     *  We will to provide an index[which product] you have to select, so the index
        start with 0 hence we will have provide the number/index accordingly.
     */
   // @Test(priority = 4)
    public void TestProductCount(){
        homePage = new HomePage(driver);
        productcount= homePage.getPrdouctCount(1);
        System.out.println("Product count is:"+ productcount);
        Assert.assertEquals(productcount,productcount,"Product count doesn't match");
    }
   // @Test(priority = 5)
    public void TestCatalogueTitle(){
        homePage = new HomePage(driver);
        catalogueTitle = homePage.getCatalogueTitle(1);
        System.out.println("Catalogue title is:"+ catalogueTitle);
        Assert.assertEquals(catalogueTitle,catalogueTitle,"catalogue Title doesn't match");
    }
     // @Test(priority = 6)
    public void TestCatalogueSelection() {
        homePage = new HomePage(driver);
        cataloguePage =  homePage.selectCatalog(1);
    }
}
