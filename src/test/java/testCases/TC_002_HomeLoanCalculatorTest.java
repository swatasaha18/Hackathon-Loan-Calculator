package testCases;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.DefaultPage;
import pageObjects.HomeLoanCalculatorPage;
import testBase.BaseClass;
import utilities.ExcelUtility;

public class TC_002_HomeLoanCalculatorTest extends BaseClass {

	@Test(priority = 3, groups = { "smoke", "regression" })
	public void verify_home_loan() throws IOException, InterruptedException {

		logger.info("***** Starting TC_002_HomeLoanCalculatorTest *****");
		try {
			DefaultPage dp = new DefaultPage(driver);
			dp.clickCalculators();
			logger.info("Clicked on Calculators Tab...");
			dp.clickHomeLoanEmiCalculator();
			logger.info("Clicked on Home Loan EMI Calculators Option...");

			HomeLoanCalculatorPage hcp = new HomeLoanCalculatorPage(driver);
			logger.info("Entering input details for home loan EMI calculation...");
			hcp.setHomeValue();
			hcp.setMargin();
			hcp.setLoanInsurance();
			hcp.setLoanAmount();
			hcp.setInterestRate();
			hcp.setLoanTenure();
			hcp.setLoanFeesCharges();
			hcp.setStartMonthYear();
			hcp.setOneTimeExpenses();
			hcp.setPropertyTaxes();
			hcp.setHomeInsurance();
			hcp.setMaintenance();

			String path = ".\\testData\\HomeLoan.xlsx";
			ExcelUtility xlutil = new ExcelUtility(path);

			scroll(hcp.tableHeader.get(0));
			logger.info("Extracting and storing result in excel sheet...");
			for (int i = 0; i < hcp.tableHeader.size(); i++) {
				String header = hcp.tableHeader.get(i).getText();
				xlutil.setCellData("Sheet1", 0, i, header);
			}
			Thread.sleep(5000);
			for (int i = 0; i < hcp.getNoOfRows(); i++) {
				WebElement row = hcp.tableData.get(i);
				List<WebElement> col = row.findElements(By.tagName("td"));
				for (int j = 0; j < col.size(); j++) {
					String data = col.get(j).getText();
					xlutil.setCellData("Sheet1", i + 1, j, data);
				}
			}
			Assert.assertTrue(true);
		}

		catch (Exception e) {
			Assert.fail("An exception occured :" + e.getMessage());
			logger.error("Test failed...");
		}
		logger.info("***** Finished TC_002_HomeLoanCalculatorTest *****");
	}
}
