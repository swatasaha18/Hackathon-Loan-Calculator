# Project Name: Interest Calculator for Current Year

## Overview
 
- This project aims to provide a set of financial tools to calculate EMIs for car, home and loans. 
- This Selenium automation testing project focuses on automating tasks related to the "EMICalculator.net". 
- The primary objectives include , giving the value to the text box and use of scale to get the car loan price , navigating through the different loan menu, verifying the presence of text box & scales, and  Re-use the same validation for Loan Amount Calculator & Loan Tenure Calculator . The project uses various dependencies and libraries to facilitate automation.
- This atomation process involves extracting data from a Home Loan EMI Calculator, and validate UI elements in a Loan Calculator and calculating Interest for one month.
 
## Functionalities
 
### 1. Car EMI Calculator
- Calculate Equated Monthly Installment (EMI) for a car loan based on provided inputs.
- Display EMI, Interest Amount, and Principal Amount for one month.
 
### 2. Home Loan EMI Extraction
- Automate extraction of data from the year-on-year table of a Home Loan EMI Calculator.
- Store extracted data in an Excel spreadsheet for analysis.
 
### 3. Loan Calculator UI Validation
- Perform UI validation tests on a Loan Calculator.
- Validate text boxes, scales, and changes in Loan Tenure for both years and months.

## Project Structure
### 1. Maven Repository
- *Maven Version*: 3.9.6

### 2. Libraries and Dependencies
- **Apache POI**
  - Version: 5.2.2
  - Purpose: Used for reading and writing Excel files, facilitating data-driven testing.
- **TestNG**
  - Version: 7.8.0
  - Purpose: Framework for test automation that allows for parallel execution and flexible test configuration.
- **Extent Report**
  - Version: 5.0.9
  - Purpose: Generates interactive and detailed HTML reports to enhance test result analysis.
- **Selenium**
  - Version: 4.15.0
  - Purpose: Enables interaction with web elements, navigation, and form submission in the browser.
- **Loggers**
  - Version: 2.20.0
  - Purpose: Provides logging capabilities for better debugging and traceability.

## Automation Flow
1. Navigating to "https://emicalculator.net/".
2. Naviagating to "Car Loan".
3. Entering the required input fields.
4. Extracting One month EMI & printing on console.
5. Navigating to "Home Loan" .
6. Filling the required input fields.
7. Extracting the year-on-year table and storing in Excel file.
8. Navigating to "Loan Calculator" from menu.
9. UI Validating for input box and sliders.
10. Changing the Loan tenure for year & month and checking the change in scale.
    
## How to Run the Tests
1. *Open Eclipse IDE:*
   - Launch Eclipse IDE on your machine.
2. *Import Project:*
   - Select File -> Import from the menu.
   - Choose Existing Maven Projects and click Next.
   - Browse to the directory where you cloned the repository and select the project.
3. *Update Maven Project:*
   - Right-click on the project in the Project Explorer.
   - Choose Maven -> Update Project.
   - Click OK to update dependencies.
4. *Set Up Configuration:*
   - Open the src/test/resources/config.properties file.
   - Update any configuration parameters like browser type, URLs, etc., as needed.
5. *Run Test Suite:*
   - Locate the test suite file (e.g. /testng.xml).
   - Right-click on the file and choose Run As -> TestNG Suite.
6. *View Reports:*
   - After execution, open the test-output folder and open index.html for reports.
   - Find the Extent Report HTML file (myReport.html) in reports folder for detailed test reports.
has context menu

## Suggested Site
- [emicalculator.net](https://emicalculator.net) (or any other legitimate site).

## Contributor
Swata Saha