package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.DefaultPage;
import pageObjects.LoanCalculatorPage;
import testBase.BaseClass;

public class TC_003_EMICalculatorTest extends BaseClass {
	LoanCalculatorPage lcp;

	@Test(priority = 4, groups = { "smoke", "regression" })
	public void verify_calculator_type_opened() throws InterruptedException {
		logger.info("***** Starting TC_003_EMICalculatorTest *****");
		try {
			DefaultPage dp = new DefaultPage(driver);
			dp.clickCalculators();
			logger.info("Clicked on Calculators Tab...");
			dp.clickLoanCalculator();
			logger.info("Clicked on Loan Calculators option...");
			lcp = new LoanCalculatorPage(driver);
			lcp.clickEMICalculator();
			logger.info("Clicked on EMI Calculators icon...");
			String result = lcp.activeCalculator.getText().replaceAll("\n", " ").trim();
			logger.info("Validating whether EMI Calculators is opened or not...");
			Assert.assertEquals(result, "EMI Calculator");
			Thread.sleep(3000);
		} catch (Exception e) {
			Assert.fail("An exception occured :" + e.getMessage());
			logger.error("Test failed...");
		}
	}

	@Test(priority = 5, groups = { "regression" }, dependsOnMethods = { "verify_calculator_type_opened" })
	public void verify_LoanAmount_InputAndSlider() {
		try {
			logger.info("Entering Loan Amount in input box...");
			enterValue(lcp.loanAmount, "600000");
			logger.info("Validating UI and proper functioning of Loan Amount input box...");
			assertInputBox(lcp.loanAmount, 600000, "Loan Amount");
			logger.info("Moving Loan Amount slider to given value...");
			moveSlider(lcp.loanamountslider, 0, 20000000, 700000);
			logger.info("Validating UI and proper functioning of Loan Amount slider...");
			assertSlider(lcp.loanAmount, lcp.loanamountslider, 700000, "Loan Amount");
		} catch (Exception e) {
			Assert.fail("An exception occured :" + e.getMessage());
			logger.error("Test failed...");
		}
	}

	@Test(priority = 6, groups = { "regression" }, dependsOnMethods = { "verify_calculator_type_opened" })
	public void verify_InterestRate_InputAndSlider() {
		try {
			logger.info("Entering Interest Rate in input box...");
			enterValue(lcp.interestRate, "9");
			logger.info("Validating UI and proper functioning of Interest Rate input box...");
			assertInputBox(lcp.interestRate, 9, "Interest Rate");
			logger.info("Moving Interest Rate slider to given value...");
			moveSlider(lcp.interestslider, 0, 20, 15);
			logger.info("Validating UI and proper functioning of Interest Rate slider...");
			assertSlider(lcp.interestRate, lcp.interestslider, 15, "Interest Rate");
		} catch (Exception e) {
			Assert.fail("An exception occured :" + e.getMessage());
			logger.error("Test failed...");
		}
	}

	@Test(priority = 7, groups = { "regression" }, dependsOnMethods = { "verify_calculator_type_opened" })
	public void verify_LoanTenure_InputAndSlider() {
		try {
			scroll(lcp.loanTenure);
			logger.info("Entering Loan Tenure in input box...");
			enterValue(lcp.loanTenure, "18");
			logger.info("Validating UI and proper functioning of Loan Tenure input box...");
			assertInputBox(lcp.loanTenure, 18, "Loan Tenure");
			logger.info("Moving Loan Tenure slider to given value...");
			moveSlider(lcp.loantenureslider, 0, 30, 15);
			logger.info("Validating UI and proper functioning of Loan Tenure slider...");
			assertSlider(lcp.loanTenure, lcp.loantenureslider, 15, "Loan Tenure");
		} catch (Exception e) {
			Assert.fail("An exception occured :" + e.getMessage());
			logger.error("Test failed...");
		}
	}

	@Test(priority = 8, groups = { "regression"}, dependsOnMethods = { "verify_calculator_type_opened" })
	public void verify_FeesAndCharges_InputAndSlider() {
		try {
			logger.info("Entering Fees and Charges in input box...");
			enterValue(lcp.feesAndCharges, "10000");
			logger.info("Validating UI and proper functioning of Fees and Charges input box...");
			assertInputBox(lcp.feesAndCharges, 10000, "Fees and Charges");
			logger.info("Moving Fees and Charges slider to given value...");
			moveSlider(lcp.loanfeesslider, 0, 100000, 6000);
			logger.info("Validating UI and proper functioning of Fees and Charges slider...");
			assertSlider(lcp.feesAndCharges, lcp.loanfeesslider, 6000, "Fees and Charges");
		} catch (Exception e) {
			Assert.fail("An exception occured :" + e.getMessage());
			logger.error("Test failed...");
		}
	}

	@Test(priority = 9, groups = { "regression" }, dependsOnMethods = { "verify_calculator_type_opened" })
	public void loanTenureValidation() {
		try {
			logger.info("Validating change in Loan Tenure scale for year and month...");
			boolean validate = lcp.changeLoanTenure();
			Assert.assertEquals(validate, true);
		} catch (Exception e) {
			Assert.fail("An exception occured :" + e.getMessage());
			logger.error("Test failed...");
		}
		logger.info("***** Finished TC_003_EMICalculatorTest *****");
	}
}
