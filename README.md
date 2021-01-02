#Resources needed to support the product

IDE - Eclipse/IntelliJ
Windows/Mac Machine
Browsers - Chrome, Firefox.
DataDriven framework - Used Excel.
Testing Framework - TestNG
Build Management Tool - Maven
Versioning Tool - GIT
Source Management Tool - GITHUB. 


#Project Structure
src/main/java/basetest - This package includes TestBase class which has all the initalizations added.
src/main/java/constants - all the static details are store into the class.
src/main/java/pages - This package includes the BasePage and other pages, 
where the BasePage is supper class and other pages are extending those.
Used POM pattern with PageFactory design pattern.
src/main/java/report - This package contains Reports, which will be executed after the Test suite gets completed.
src/main/java/utilities - This package has all the classes and interfaces which will be used common across the framework.
This has Excel Operation which will be used for fetching the Test Data from the excel sheet.
Also, this package contains RetryAnalyzer which has retry logic once the test cases gets failed.
src/test/java/testcases - all sub-packages contains only Test executable methods.

#implemented extended reports and can be found inside index.html.

#Instructions to run the project:
1) clone this project. 
2) go to the directory. 
3) provide command "mvn clean test".
