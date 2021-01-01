package com.qa.utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.qa.basetest.TestBase;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.IAnnotationTransformer;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.ITestAnnotation;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class Listener implements ITestListener, IAnnotationTransformer {
    public ExtentReports report;
    public ExtentTest test;

    @Override
    public void onTestStart(ITestResult result) {

    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ExtentTest test = (ExtentTest) result.getAttribute("ExtentTestObject");
        test.log(Status.PASS, "Test case " + result.getMethod().getMethodName() + " is passed");

    }

    @Override
    public void onTestFailure(ITestResult result) {
        ExtentTest test = (ExtentTest)result.getAttribute("ExtentTestObject");
        test.log(Status.FAIL, "Test case " + result.getMethod().getMethodName() + " is Failed " +
                result.getThrowable().getMessage() );

        String fileName = System.getProperty("user.dir") + File.separator+ "Screenshots"+ File.separator
           + result.getMethod().getMethodName();

                File file =  ((TakesScreenshot) TestBase.driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(file, new File(fileName +".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ExtentTest test =(ExtentTest)result.getAttribute("ExtentTestObject");
        test.log(Status.SKIP, result.getName() + " is Skipped");
    }

//    @Override
//    public void onStart(ITestContext context) {
//
//    }
//
//    @Override
//    public void onFinish(ITestContext context) {
//
//    }
    @Override
    public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
        annotation.setRetryAnalyzer(RetryAnalyzer.class);
    }
}
