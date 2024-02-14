package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageObjects.DefaultPage;
import testBase.BaseClass;

public class TC_001_CarLoanCalculatorTest extends BaseClass {

	@Test(priority = 1, groups = { "smoke", "regression" })
	public void verify_inputs_car_loan_calculator() {

		logger.info("***** Starting TC_001_CarLoanCalculatorTest *****");

		try {
			DefaultPage dp = new DefaultPage(driver);
			dp.clickCarLoan();
			logger.info("Clicked on Car Loan Tab...");
			logger.info("Entering Car Loan Amount...");
			;
			dp.setCarLoanAmount();
			logger.info("Entering Car Loan Interest...");
			dp.setInterestRate();
			logger.info("Entering Car Loan Tenure...");
			dp.setLoanTenure();
			dp.clickYr();
			logger.info("Clicked on Yr button...");

			logger.info("Validating the input values send...");
			SoftAssert sa = new SoftAssert();
			sa.assertEquals(dp.carLoanAmount.getAttribute("value"), "15,00,000");
			sa.assertEquals(dp.interestRate.getAttribute("value"), "9.5");
			sa.assertEquals(dp.loanTenure.getAttribute("value"), "1");
			sa.assertAll();
		}

		catch (Exception e) {
			Assert.fail("An exception occured :" + e.getMessage());
			logger.error("Test failed...");
		}
	}

	@Test(priority = 2, groups = { "regression" }, dependsOnMethods = { "verify_inputs_car_loan_calculator" })
	public void verify_car_loan_calculator() {

		try {
			DefaultPage dp = new DefaultPage(driver);

			logger.info("Fetching the car EMI amount...");
			String emiAmnt = dp.getEMIAmount();
			System.out.println("The EMI for the car is : ₹ " + emiAmnt);
			dp.clickcurrentYr();
			logger.info("Clicked on the current year in the table...");

			scroll(dp.currentYr);
			logger.info("Fetching the car interest amount of 1st month...");
			String interestAmnt = dp.getInterestAmount();
			System.out.println("The 1st month interest is : " + interestAmnt);

			logger.info("Fetching the car pricipal amount of 1st month...");
			String principalAmnt = dp.getPrincipalAmount();
			System.out.println("The 1st month principal is : " + principalAmnt);

			logger.info("Validating the car EMI calculation...");
			SoftAssert sa = new SoftAssert();
			sa.assertEquals(emiAmnt, "1,31,525");
			sa.assertEquals(interestAmnt, "₹ 11,875");
			sa.assertEquals(principalAmnt, "₹ 1,19,650");
			sa.assertAll();
		}

		catch (Exception e) {
			Assert.fail("An exception occured :" + e.getMessage());
			logger.error("Test failed...");
		}

		logger.info("***** Finished TC_001_CarLoanCalculatorTest *****");
	}
}
