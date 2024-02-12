package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageObjects.DefaultPage;
import testBase.BaseClass;

public class TC_001_CarLoanCalculatorTest extends BaseClass{
	
	@Test(priority = 1)
	public void verify_car_loan_calculator() {
		logger.info("***** Starting TC_001_CarLoanCalculatorTest *****");
		try {
		DefaultPage dp = new DefaultPage(driver);
		dp.clickCarLoan();
		logger.info("Clicked on Car Loan Tab...");
		dp.setCarLoanAmount();
		dp.setInterestRate();
		dp.setLoanTenure();
		dp.clickYr();
		
		String emiAmnt = dp.getEMIAmount();
		System.out.println("The EMI for the car is : ₹ " + emiAmnt);
		dp.clickcurrentYr();
		scroll(dp.currentYr);
		String interestAmnt = dp.getInterestAmount();
		System.out.println("The 1st month interest is : " +interestAmnt);
		String principalAmnt = dp.getPrincipalAmount();
		
		System.out.println("The 1st month principal is : " +principalAmnt);
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(emiAmnt, "1,31,525");
		sa.assertEquals(interestAmnt, "₹ 11,875");
		sa.assertEquals(principalAmnt, "₹ 1,19,650");
		sa.assertAll();
		}
		catch(Exception e) {
			Assert.fail("An exception occured :"+ e.getMessage());
		}
		logger.info("***** Finished TC_001_CarLoanCalculatorTest *****");
	}
}
