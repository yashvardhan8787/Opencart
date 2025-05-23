OpenCart E-commerce Web Application - Quality Assurance Project
Project Overview
This repository showcases the comprehensive testing efforts for the OpenCart E-commerce web application. The primary goal of this project was to ensure the quality, functionality, and reliability of key user flows and features within the application. Both manual and automated testing approaches were employed to achieve robust test coverage.

Project Structure
The project is organized to provide clear visibility into test artifacts and automation scripts:

├── artifacts/
│   ├── Opencart_TestCases
│   ├── Opencart_Testplan
│   └── Opencart_Defect_report
├──opencart/
│   ├── src/
│   │   ├── main/java/com/opencart/automation/  (or similar package structure)
│   │   │   ├── testBase/
│   │   │   │   └── BaseTest.java
│   │   │   ├── pageObjects/
│   │   │   │   ├── LoginPage.java
│   │   │   │   ├── RegistrationPage.java
│   │   │   │   └── ... (other page objects)
│   │   │   └── testCases
│   │   │    ├── LoginTests.java
│   │   │    ├── RegistrationTests.java
│   │   │    └── ... (other test classes)
│   │   │   └── utilities/
│   │   │       ├── ExcelReader.java
│   │   │       ├── ExtentReporterManager.java
│   │   │       └── ... (other utility classes)
│   │   └── testData
│   │       └── TestData.xlsx  (.xlxs)
│   │   └── Reports
│   │       └── ... (Reports files)
│   │   └── logs
│   │       └── logs.txt
│   ├── pom.xml
│   └── testng.xml
├── README.md
Manual Testing Artifacts (artifacts/)
The artifacts folder contains essential documentation from the manual testing phase:

testcases/:
Detailed test cases for various features, including positive, negative, and edge scenarios.
Covered features:
Login & Logout
Forgot Password functionality
User Registration
Product Search
Product Detail Page
Add to Cart & Wishlist functionalities
Checkout process
TestPlan_OpenCart.docx / TestPlan_OpenCart.pdf:
A comprehensive test plan outlining the scope, objectives, strategy, resources, and schedule for the testing project.
DefectReport_OpenCart.xlsx:
A consolidated report of all identified defects, including their severity, priority, status, and steps to reproduce.
Test Automation (automation/)
The automation folder houses the automated test suite developed for the OpenCart application.

Framework Details
Framework Type: Hybrid Driven Framework
Combines the advantages of Data-Driven, Keyword-Driven, and Page Object Model (POM) approaches for maintainability, reusability, and scalability.
Tools & Technologies:
Selenium WebDriver: For browser automation and interacting with web elements.
TestNG: As the testing framework for test execution, annotations, and reporting.
Java: The programming language used for script development.
Maven: For build automation and dependency management (indicated by pom.xml).
Key Automation Features
Page Object Model (POM): Separates test logic from UI elements, making tests more readable and maintainable.
Data-Driven Testing: Utilizes external data sources (e.g., Excel, properties files) to run tests with multiple sets of data, enhancing test coverage.
Reusable Components: Common functions and utilities are developed to promote code reusability across tests.
Robust Error Handling: Mechanisms to handle unexpected conditions and provide informative error messages.
Reporting
ExtentReports: Integrated to generate visually rich, interactive, and comprehensive test execution reports. These reports provide a clear overview of test pass/fail status, detailed logs, and execution times, aiding in quick analysis and debugging.
How to Run Automation Tests
Prerequisites:
Java Development Kit (JDK) installed.
Maven installed.
WebDriver compatible browser (e.g., Chrome, Firefox) installed.
Clone the Repository:
Bash

git clone <repository_url>
cd opencart-qa-project/automation
Update Maven Dependencies:
Bash

mvn clean install
Execute Tests:
Using TestNG XML:
Bash

mvn test -DsuiteXmlFile=testng.xml
From IDE (e.g., IntelliJ IDEA, Eclipse): Right-click on testng.xml or individual test classes and select "Run as TestNG Test."
Extent Reports Location
After test execution, the Extent Reports will typically be generated in a folder like test-output/ExtentReports/ or a similar path configured in the automation project. Open the .html file in your browser to view the report.

Features Covered in Automation
The automation suite covers critical functionalities, mirroring the manual test cases:

Login & Logout: Valid and invalid login attempts, successful logout.
User Registration: New user registration with various data sets.
Forgot Password: Testing the password reset flow.
Product Search: Searching for existing and non-existing products.
Product Detail Page: Verifying product information, adding to cart/wishlist from this page.
Add to Cart & Wishlist: Functionality to add items to cart and wishlist, quantity updates.
Checkout Process: End-to-end checkout flow for registered users.
