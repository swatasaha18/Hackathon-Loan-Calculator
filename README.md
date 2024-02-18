# Interest Calculator for Current Year

## Overview
The Interest Calculator for Current Year project is designed to provide a suite of financial tools for calculating Equated Monthly Installments (EMIs) for car, home, and general loans. The project focuses on automating tasks related to the "emicalculator.net" website using Selenium automation testing techniques.

### Primary Objectives
- Input value into text boxes and utilize scales to determine car loan prices.
- Navigate through different loan menus.
- Verify the presence of text boxes, scales, and other UI elements.
- Reuse validation processes for Loan Amount Calculator & Loan Tenure Calculator.

### Functionalities
1. **Car EMI Calculator**
   - Calculate EMI for a car loan based on user-provided inputs.
   - Display EMI, Interest Amount, and Principal Amount for one month.

2. **Home Loan EMI Extraction**
   - Automate extraction of data from the year-on-year table of a Home Loan EMI Calculator.
   - Store extracted data in an Excel spreadsheet for analysis.

3. **Loan Calculator UI Validation**
   - Perform UI validation tests on a Loan Calculator.
   - Validate text boxes, scales, and changes in Loan Tenure for both years and months.

## Project Structure
### Maven Repository
- **Maven Version**: 3.9.6

### Libraries and Dependencies
- **Apache POI**
  - **Version**: 5.2.2
  - **Purpose**: Read and write Excel files for data-driven testing.
  
- **TestNG**
  - **Version**: 7.8.0
  - **Purpose**: Framework for test automation with support for parallel execution and flexible configurations.
  
- **Extent Report**
  - **Version**: 5.0.9
  - **Purpose**: Generate interactive and detailed HTML reports for comprehensive test result analysis.
  
- **Selenium**
  - **Version**: 4.15.0
  - **Purpose**: Facilitate interaction with web elements, navigation, and form submission in web browsers.
  
- **Loggers**
  - **Version**: 2.20.0
  - **Purpose**: Provide logging capabilities for enhanced debugging and traceability.

## Automation Flow
1. Navigate to "https://emicalculator.net/".
2. Navigate to "Car Loan" section.
3. Enter required input fields.
4. Extract One-month EMI & print on console.
5. Navigate to "Home Loan" section.
6. Fill required input fields.
7. Extract year-on-year table and store in Excel file.
8. Navigate to "Loan Calculator" from the menu.
9. Perform UI validation for input boxes and sliders.
10. Change Loan tenure for years & months and verify scale changes.

## How to Run the Tests
1. **Open Eclipse IDE**:
   - Launch Eclipse IDE on your machine.
   
2. **Import Project**:
   - Select File -> Import from the menu.
   - Choose Existing Maven Projects and click Next.
   - Browse to the directory where you cloned the repository and select the project.
   
3. **Update Maven Project**:
   - Right-click on the project in the Project Explorer.
   - Choose Maven -> Update Project.
   - Click OK to update dependencies.
   
4. **Set Up Configuration**:
   - Open the src/test/resources/config.properties file.
   - Update configuration parameters like browser type, URLs, etc., as needed.
   
5. **Run Test Suite**:
   - Locate the test suite file (e.g., /testng.xml).
   - Right-click on the file and choose Run As -> TestNG Suite.
   
6. **View Reports**:
   - After execution, open the test-output folder and open index.html for reports.
   - Find the Extent Report HTML file (myReport.html) in the reports folder for detailed test reports.

## Suggested Site
- [EMICalculator.net](https://emicalculator.net/) or any other legitimate site.

## Contributor
- Swata Saha

This readme provides comprehensive guidance on setting up, running, and understanding the Interest Calculator for Current Year project. For further assistance or inquiries, feel free to contact the contributor.
