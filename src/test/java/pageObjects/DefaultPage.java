package pageObjects;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utilities.ExcelUtility;

public class DefaultPage extends BasePage {
	WebDriver driver;
	JavascriptExecutor js;
	ExcelUtility xlutil = new ExcelUtility(".\\testData\\DataInput.xlsx");

	public DefaultPage(WebDriver driver) {
		super(driver);
		js = (JavascriptExecutor) driver;
	}

	@FindBy(xpath = "//a[@id='menu-item-dropdown-2696']")
	WebElement calculators;

	@FindBy(xpath = "//a[@title='Home Loan EMI Calculator']")
	WebElement homeLoanEMICalculator;

	@FindBy(xpath = "//a[@title='Loan Calculator']")
	WebElement loanCalculator;

	@FindBy(xpath = "//a[normalize-space()='Car Loan']")
	WebElement carLoan;

	@FindBy(xpath = "//input[@id='loanamount']")
	public WebElement carLoanAmount;

	@FindBy(xpath = "//input[@id='loaninterest']")
	public WebElement interestRate;

	@FindBy(xpath = "//input[@id='loanterm']")
	public WebElement loanTenure;

	@FindBy(xpath = "//label[normalize-space()='Yr']")
	WebElement yr;

	@FindBy(xpath = "//*[@id=\"emiamount\"]/p/span")
	WebElement emiAmnt;

	@FindBy(xpath = "//*[@id='year2024']")
	public WebElement currentYr;

	@FindBy(xpath = "//*[@id='monthyear2024']//tr[1]/td[3]")
	WebElement interestAmnt;

	@FindBy(xpath = "//*[@id='monthyear2024']//tr[1]/td[2]")
	WebElement principalAmnt;

	public void clickCarLoan() {
		carLoan.click();
	}

	public void setCarLoanAmount() throws IOException {
		carLoanAmount.clear();
		String amount = xlutil.getCellData("TC_001_CarLoan", 1, 0);
		carLoanAmount.sendKeys(amount);
	}

	public void setInterestRate() throws IOException {
		String interest = xlutil.getCellData("TC_001_CarLoan", 1, 1);
		js.executeScript("arguments[0].value=arguments[1]", interestRate, interest);
	}

	public void setLoanTenure() throws IOException {
		String tenure = xlutil.getCellData("TC_001_CarLoan", 1, 2);
		js.executeScript("arguments[0].value=arguments[1]", loanTenure, tenure);
	}

	public void clickYr() {
		yr.click();
	}

	public String getEMIAmount() {
		return emiAmnt.getText();
	}

	public void clickcurrentYr() {
		currentYr.click();
	}

	public String getInterestAmount() {
		return interestAmnt.getText();
	}

	public String getPrincipalAmount() {
		return principalAmnt.getText();
	}

	public void clickCalculators() {
		calculators.click();
	}

	public void clickHomeLoanEmiCalculator() {
		homeLoanEMICalculator.click();
	}

	public void clickLoanCalculator() {
		loanCalculator.click();
	}
}
