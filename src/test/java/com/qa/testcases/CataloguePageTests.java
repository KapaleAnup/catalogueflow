//package com.qa.testcases;
//
//
//import com.qa.base.TestBase;
//import com.qa.pages.CataloguePage;
//import com.qa.pages.HomePage;
//import org.testng.Assert;
//import org.testng.annotations.Test;
//
//public class CataloguePageTests extends TestBase {
//
//
//    CataloguePage cataloguePage;
//
//    //@Test(priority = 1)
//    public void TestPageTitle(){
//        cataloguePage= new CataloguePage(driver);
//      Assert.assertEquals(cataloguePage.getPageTitle(),driver.getTitle(),"PageTitle doesn't match");
//    }
//
//   // @Test(priority = 2)
//    public void TestCatalogueTitle(){
//        cataloguePage= new CataloguePage(driver);
//        String title = cataloguePage.getCatalogueTitle();
//        Assert.assertEquals(HomePageTests.catalogueTitle,title,
//                "Selected catalogue Title and current catalogue title doesn't match ");
//    }
//
//    @Test(priority = 2)
//    public void TestCatalogueCount(){
//        cataloguePage= new CataloguePage(driver);
//        String count = cataloguePage.getCatalogueCount();
//        Assert.assertEquals(HomePageTests.productcount,count,
//                "Selected product count and current product count doesn't match ");
//    }
//}
