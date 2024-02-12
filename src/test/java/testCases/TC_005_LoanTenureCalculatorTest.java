package testCases;

import org.testng.annotations.Test;

import pageObjects.DefaultPage;
import pageObjects.LoanCalculatorPage;
import testBase.BaseClass;

public class TC_005_LoanTenureCalculatorTest extends BaseClass{
	LoanCalculatorPage lcp;
	
	@Test(priority = 0)
	public void verify_calculator() throws InterruptedException {
		DefaultPage dp = new DefaultPage(driver);
		dp.clickCalculators();
		dp.clickLoanCalculator();
		lcp = new LoanCalculatorPage(driver);
		lcp.clickLoanTenureCalculator();
		Thread.sleep(5000);
	}
	
	@Test(priority = 1)
	public void verify_LoanAmount_InputAndSlider() throws InterruptedException {
		enterValue(lcp.loanAmount,"600000");
		assertInputBox(lcp.loanAmount,600000,"LoanAmount");
		Thread.sleep(5000);
		moveSlider(lcp.loanamountslider, 0, 20000000, 700000);
		assertSlider(lcp.loanAmount, lcp.loanamountslider, 700000, "Loan Amount");
		Thread.sleep(5000);
	}
	
	@Test(priority = 3)
	public void verify_EMI_InputAndSlider() throws InterruptedException {
		enterValue(lcp.eMI,"60000");
		assertInputBox(lcp.eMI,60000,"EMI");
		Thread.sleep(5000);
		moveSlider(lcp.loanemislider, 0, 100000, 15064);
		assertSlider(lcp.eMI, lcp.loanemislider, 15064, "EMI");
		Thread.sleep(5000);
	}
	
	@Test(priority = 2)
	public void verify_InterestRate_InputAndSlider() throws InterruptedException {
		enterValue(lcp.interestRate,"9");
		assertInputBox(lcp.interestRate,9,"Interest Rate");
		Thread.sleep(5000);
		moveSlider(lcp.interestslider, 0, 20, 15);
		assertSlider(lcp.interestRate, lcp.interestslider, 15, "Interest Rate");
		Thread.sleep(5000);
	}
	
	@Test(priority = 4)
	public void verify_FeesAndCharges_InputAndSlider() throws InterruptedException {
		enterValue(lcp.feesAndCharges,"10000");
		assertInputBox(lcp.feesAndCharges,10000,"Fees and Charges");
		Thread.sleep(5000);
		moveSlider(lcp.loanfeesslider, 0, 100000, 6000);
		assertSlider(lcp.feesAndCharges, lcp.loanfeesslider, 6000, "Fees and Charges");
	}
}
