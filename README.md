# OpenCart E-commerce Web Application - Quality Assurance Project

## Project Overview

This repository showcases the comprehensive testing efforts for the OpenCart E-commerce web application. The primary goal of this project was to ensure the quality, functionality, and reliability of key user flows and features within the application. Both manual and automated testing approaches were employed to achieve robust test coverage.



## Manual Testing Artifacts (`artifacts/`)

The `artifacts` folder contains essential documentation from the manual testing phase:

* **`Opencart_TestCases/`**:
    * Detailed test cases for various features, including positive, negative, and edge scenarios.
    * Covered features:
        * Login & Logout
        * Forgot Password functionality
        * User Registration
        * Product Search
        * Product Detail Page
        * Add to Cart & Wishlist functionalities
        * Checkout process
* **`Opencart_Testplan.docx` / `Opencart_Testplan.pdf`**:
    * A comprehensive test plan outlining the scope, objectives, strategy, resources, and schedule for the testing project.
* **`Opencart_Defect_report.xlsx`**:
    * A consolidated report of all identified defects, including their severity, priority, status, and steps to reproduce.

## Test Automation (`opencart/`)

The `opencart` folder houses the automated test suite developed for the OpenCart application.

### Framework Details

* **Framework Type:** Hybrid Driven Framework
    * Combines the advantages of Data-Driven, Keyword-Driven, and Page Object Model (POM) approaches for maintainability, reusability, and scalability.
* **Tools & Technologies:**
    * **Selenium WebDriver:** For browser automation and interacting with web elements.
    * **TestNG:** As the testing framework for test execution, annotations, and reporting.
    * **Java:** The programming language used for script development.
    * **Maven:** For build automation and dependency management (indicated by `pom.xml`).

### Key Automation Features

* **Page Object Model (POM):** Separates test logic from UI elements, making tests more readable and maintainable.
* **Data-Driven Testing:** Utilizes external data sources (e.g., Excel) to run tests with multiple sets of data, enhancing test coverage.
* **Reusable Components:** Common functions and utilities are developed to promote code reusability across tests.
* **Robust Error Handling:** Mechanisms to handle unexpected conditions and provide informative error messages.

### Reporting

* **ExtentReports:** Integrated to generate visually rich, interactive, and comprehensive test execution reports. These reports provide a clear overview of test pass/fail status, detailed logs, and execution times, aiding in quick analysis and debugging.

### How to Run Automation Tests

1.  **Prerequisites:**
    * Java Development Kit (JDK) installed.
    * Maven installed.
    * WebDriver compatible browser (e.g., Chrome, Firefox) installed.
2.  **Clone the Repository:**
    ```bash
    git clone <repository_url>
    cd opencart
    ```
3.  **Update Maven Dependencies:**
    ```bash
    mvn clean install
    ```
4.  **Execute Tests:**
    * **Using TestNG XML:**
        ```bash
        mvn test -DsuiteXmlFile=testng.xml
        ```
    * **From IDE (e.g., IntelliJ IDEA, Eclipse):** Right-click on `testng.xml` or individual test classes and select "Run as TestNG Test."

### Extent Reports Location

After test execution, the Extent Reports will be generated in the `opencart/Reports/` folder. Open the `.html` file in your browser to view the report.

### Logs

Test execution logs will be stored in the `opencart/logs/logs.txt` file, providing detailed information about the test run.

## Features Covered in Automation

The automation suite covers critical functionalities, mirroring the manual test cases:

* **Login & Logout:** Valid and invalid login attempts, successful logout.
* **User Registration:** New user registration with various data sets.
* **Forgot Password:** Testing the password reset flow.
* **Product Search:** Searching for existing and non-existing products.
* **Product Detail Page:** Verifying product information, adding to cart/wishlist from this page.
* **Add to Cart & Wishlist:** Functionality to add items to cart and wishlist, quantity updates.
* **Checkout Process:** End-to-end checkout flow for registered users.
