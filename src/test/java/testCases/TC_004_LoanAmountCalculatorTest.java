package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.DefaultPage;
import pageObjects.LoanCalculatorPage;
import testBase.BaseClass;

public class TC_004_LoanAmountCalculatorTest extends BaseClass {
	LoanCalculatorPage lcp;

	@Test(priority = 10, groups = { "smoke", "regression" })
	public void verify_calculator_type_opened() throws InterruptedException {
		logger.info("***** Starting TC_004_LoanAmountCalculatorTest *****");
		try {
			DefaultPage dp = new DefaultPage(driver);
			dp.clickCalculators();
			logger.info("Clicked on Calculators Tab...");
			dp.clickLoanCalculator();
			logger.info("Clicked on Loan Calculators option...");
			lcp = new LoanCalculatorPage(driver);
			lcp.clickLoanAmountCalculator();
			logger.info("Clicked on Loan Amount Calculators icon...");
			String result = lcp.activeCalculator.getText().replaceAll("\n", " ").trim();
			logger.info("Validating whether Loan Amount Calculators is opened or not...");
			Assert.assertEquals(result, "Loan Amount Calculator");
			Thread.sleep(5000);
		} catch (Exception e) {
			Assert.fail("An exception occured :" + e.getMessage());
			logger.error("Test failed...");
		}
	}

	@Test(priority = 11, groups = { "regression" }, dependsOnMethods = { "verify_calculator_type_opened" })
	public void verify_EMI_InputAndSlider() throws InterruptedException {
		try {
			logger.info("Entering EMI in input box...");
			enterValue(lcp.eMI, "60000");
			logger.info("Validating UI and proper functioning of EMI input box...");
			assertInputBox(lcp.eMI, 60000, "EMI");
			Thread.sleep(5000);
			logger.info("Moving EMI slider to given value...");
			moveSlider(lcp.loanemislider, 0, 100000, 75000);
			logger.info("Validating UI and proper functioning of EMI slider...");
			assertSlider(lcp.eMI, lcp.loanemislider, 75000, "EMI");
			Thread.sleep(5000);
		} catch (Exception e) {
			Assert.fail("An exception occured :" + e.getMessage());
			logger.error("Test failed...");
		}
	}

	@Test(priority = 12, groups = { "regression" }, dependsOnMethods = { "verify_calculator_type_opened" })
	public void verify_InterestRate_InputAndSlider() throws InterruptedException {
		try {
			logger.info("Entering Interest Rate in input box...");
			enterValue(lcp.interestRate, "9");
			logger.info("Validating UI and proper functioning of Interest Rate input box...");
			assertInputBox(lcp.interestRate, 9, "Interest Rate");
			Thread.sleep(5000);
			logger.info("Moving Interest Rate slider to given value...");
			moveSlider(lcp.interestslider, 0, 20, 15);
			logger.info("Validating UI and proper functioning of Interest Rate slider...");
			assertSlider(lcp.interestRate, lcp.interestslider, 15, "Interest Rate");
			Thread.sleep(5000);
		} catch (Exception e) {
			Assert.fail("An exception occured :" + e.getMessage());
			logger.error("Test failed...");
		}
	}

	@Test(priority = 13, groups = { "regression" }, dependsOnMethods = { "verify_calculator_type_opened" })
	public void verify_LoanTenure_InputAndSlider() throws InterruptedException {
		try {
			scroll(lcp.loanTenure);
			logger.info("Entering Loan Tenure in input box...");
			enterValue(lcp.loanTenure, "18");
			logger.info("Validating UI and proper functioning of Loan Tenure input box...");
			assertInputBox(lcp.loanTenure, 18, "Loan Tenure");
			Thread.sleep(5000);
			logger.info("Moving Loan Tenure slider to given value...");
			moveSlider(lcp.loantenureslider, 0, 30, 15);
			logger.info("Validating UI and proper functioning of Loan Tenure slider...");
			assertSlider(lcp.loanTenure, lcp.loantenureslider, 15, "Loan Tenure");
			Thread.sleep(5000);
		} catch (Exception e) {
			Assert.fail("An exception occured :" + e.getMessage());
			logger.error("Test failed...");
		}
	}

	@Test(priority = 14, groups = { "regression" }, dependsOnMethods = { "verify_calculator_type_opened" })
	public void verify_FeesAndCharges_InputAndSlider() throws InterruptedException {
		try {
			logger.info("Entering Fees and Charges in input box...");
			enterValue(lcp.feesAndCharges, "10000");
			logger.info("Validating UI and proper functioning of Fees and Charges input box...");
			assertInputBox(lcp.feesAndCharges, 10000, "Fees and Charges");
			Thread.sleep(5000);
			logger.info("Moving Fees and Charges slider to given value...");
			moveSlider(lcp.loanfeesslider, 0, 100000, 6000);
			logger.info("Validating UI and proper functioning of Fees and Charges slider...");
			assertSlider(lcp.feesAndCharges, lcp.loanfeesslider, 6000, "Fees and Charges");
		} catch (Exception e) {
			Assert.fail("An exception occured :" + e.getMessage());
			logger.error("Test failed...");
		}
	}

	@Test(priority = 15, groups = { "regression" }, dependsOnMethods = { "verify_calculator_type_opened" })
	public void loanTenureValidation() {
		try {
			logger.info("Validating change in Loan Tenure scale for year and month...");
			boolean validate = lcp.changeLoanTenure();
			Assert.assertEquals(validate, true);
		} catch (Exception e) {
			Assert.fail("An exception occured :" + e.getMessage());
			logger.error("Test failed...");
		}
		logger.info("***** Finished TC_004_LoanAmountCalculatorTest *****");
	}
}
