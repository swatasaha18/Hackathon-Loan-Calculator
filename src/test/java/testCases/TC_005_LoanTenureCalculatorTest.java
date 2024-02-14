package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.DefaultPage;
import pageObjects.LoanCalculatorPage;
import testBase.BaseClass;

public class TC_005_LoanTenureCalculatorTest extends BaseClass {
	LoanCalculatorPage lcp;

	@Test(priority = 16, groups = { "smoke", "regression" })
	public void verify_calculator_type_opened() throws InterruptedException {
		logger.info("***** Starting TC_005_LoanTenureCalculatorTest *****");
		try {
			DefaultPage dp = new DefaultPage(driver);
			dp.clickCalculators();
			logger.info("Clicked on Calculators Tab...");
			dp.clickLoanCalculator();
			logger.info("Clicked on Loan Calculators option...");
			lcp = new LoanCalculatorPage(driver);
			lcp.clickLoanTenureCalculator();
			logger.info("Clicked on Loan Tenure Calculators icon...");
			String result = lcp.activeCalculator.getText().replaceAll("\n", " ").trim();
			logger.info("Validating whether Loan Tenure Calculators is opened or not...");
			Assert.assertEquals(result, "Loan Tenure Calculator");
			Thread.sleep(5000);
		} catch (Exception e) {
			Assert.fail("An exception occured :" + e.getMessage());
			logger.error("Test failed...");
		}
	}

	@Test(priority = 17, groups = { "regression" }, dependsOnMethods = { "verify_calculator_type_opened" })
	public void verify_LoanAmount_InputAndSlider() throws InterruptedException {
		try {
			logger.info("Entering Loan Amount in input box...");
			enterValue(lcp.loanAmount, "600000");
			logger.info("Validating UI and proper functioning of Loan Amount input box...");
			assertInputBox(lcp.loanAmount, 600000, "LoanAmount");
			Thread.sleep(5000);
			logger.info("Moving Loan Amount slider to given value...");
			moveSlider(lcp.loanamountslider, 0, 20000000, 700000);
			logger.info("Validating UI and proper functioning of Loan Amount slider...");
			assertSlider(lcp.loanAmount, lcp.loanamountslider, 700000, "Loan Amount");
			Thread.sleep(5000);
		} catch (Exception e) {
			Assert.fail("An exception occured :" + e.getMessage());
			logger.error("Test failed...");
		}
	}

	@Test(priority = 18, groups = { "regression" }, dependsOnMethods = { "verify_calculator_type_opened" })
	public void verify_InterestRate_InputAndSlider() throws InterruptedException {
		try {
			scroll(lcp.interestRate);
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

	@Test(priority = 19, groups = { "regression" }, dependsOnMethods = { "verify_calculator_type_opened" })
	public void verify_EMI_InputAndSlider() throws InterruptedException {
		try {
			scroll(lcp.eMI);
			logger.info("Entering EMI in input box...");
			enterValue(lcp.eMI, "60000");
			logger.info("Validating UI and proper functioning of EMI input box...");
			assertInputBox(lcp.eMI, 60000, "EMI");
			Thread.sleep(5000);
			logger.info("Moving EMI slider to given value...");
			moveSlider(lcp.loanemislider, 0, 100000, 15064);
			logger.info("Validating UI and proper functioning of EMI slider...");
			assertSlider(lcp.eMI, lcp.loanemislider, 15064, "EMI");
			Thread.sleep(5000);
		} catch (Exception e) {
			Assert.fail("An exception occured :" + e.getMessage());
			logger.error("Test failed...");
		}
	}

	@Test(priority = 20, groups = { "regression" }, dependsOnMethods = { "verify_calculator_type_opened" })
	public void verify_FeesAndCharges_InputAndSlider() throws InterruptedException {
		try {
			scroll(lcp.feesAndCharges);
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
		logger.info("***** Finished TC_005_LoanTenureCalculatorTest *****");
	}
}
