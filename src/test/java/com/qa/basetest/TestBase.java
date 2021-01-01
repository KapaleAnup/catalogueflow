//package com.qa.basetest;
//
//import com.aventstack.extentreports.ExtentReports;
//import com.aventstack.extentreports.ExtentTest;
//import com.qa.report.ReportManager;
//import com.qa.utilities.Config;
//import io.github.bonigarcia.wdm.WebDriverManager;
//import org.openqa.selenium.PageLoadStrategy;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.firefox.FirefoxOptions;
//import org.testng.ITestResult;
//import org.testng.annotations.*;
//
//
//import java.awt.*;
//import java.io.File;
//import java.io.IOException;
//import java.util.concurrent.TimeUnit;
//
//public class TestBase {
//
//    public static WebDriver driver;
//    public ExtentReports report;
//    public ExtentTest test;
//
//
//
//    @BeforeMethod
//    public void init(ITestResult result) {
//        report = ReportManager.generateReport();
//        test = report.createTest(result.getMethod().getMethodName());
//        test.assignAuthor("Anup Kapale");
//        result.setAttribute("ExtentTestObject", test);
//    }
//
//    @Parameters("browser")
//    @BeforeClass
//    public void init(String browser) {
//        if (browser.equalsIgnoreCase("chrome")) {
//            WebDriverManager.chromedriver().setup();
//            ChromeOptions options = new ChromeOptions();
//            options.addArguments("--incognito");
//            options.addArguments("start-maximized");
//            options.addArguments("disable-notification");
//            options.setPageLoadStrategy(PageLoadStrategy.EAGER);
//            driver = new ChromeDriver(options);
//        }
//        else if (browser.equalsIgnoreCase("firefox")) {
//            WebDriverManager.firefoxdriver().setup();
//            FirefoxOptions options = new FirefoxOptions();
//            options.addArguments("-private");
//            driver = new FirefoxDriver();
//
//        }
//        else{
//            // Log.info(("browser : " + browser + " is invalid, Launching chrome as browser of choice.."));
//            WebDriverManager.chromedriver().setup();
//            ChromeOptions options = new ChromeOptions();
//            options.addArguments("start-maximized");
//            options.addArguments("disable-notification");
//            driver = new ChromeDriver();
//        }
//        driver.manage().window().maximize();
//        driver.get(Config.url);
//        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//    }
//
//    @AfterMethod
//    public void reportFlush() {
//        try {
//            Desktop.getDesktop().browse(new File(System.getProperty("user.dir")+"AutomationReport.html").toURI());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        report.flush();
//    }
//
//    @AfterClass
//    public void tearDown()
//    {
//        driver.quit();
//    }
//
//}