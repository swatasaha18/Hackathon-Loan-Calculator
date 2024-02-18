package pageObjects;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import utilities.ExcelUtility;

public class HomeLoanCalculatorPage extends BasePage {
	WebDriver driver;
	JavascriptExecutor js;
	ExcelUtility xlutil = new ExcelUtility(".\\testData\\DataInput.xlsx");

	public HomeLoanCalculatorPage(WebDriver driver) {
		super(driver);
		js = (JavascriptExecutor) driver;
	}

	@FindBy(xpath = "//input[@id='homeprice']")
	WebElement homeValue;

	@FindBy(xpath = "//input[@id='downpayment']")
	WebElement marginORDownPayment;

	@FindBy(xpath = "//input[@id='homeloaninsuranceamount']")
	WebElement loanInsurance;

	@FindBy(xpath = "//input[@id='homeloanamount']")
	WebElement loanAmount;

	@FindBy(xpath = "//input[@id='homeloaninterest']")
	WebElement interestRate;

	@FindBy(xpath = "//input[@id='homeloanterm']")
	WebElement loanTenure;

	@FindBy(xpath = "//input[@id='loanfees']")
	WebElement loanFeesCharges;

	@FindBy(xpath = "//input[@id='startmonthyear']")
	WebElement startMonthYear;

	@FindBy(xpath = "//span[@class='month focused active']")
	WebElement currentMonth;

	@FindBy(xpath = "//input[@id='onetimeexpenses']")
	WebElement onetimeExpenses;

	@FindBy(xpath = "//input[@id='propertytaxes']")
	WebElement propertyTaxes;

	@FindBy(xpath = "//input[@id='homeinsurance']")
	WebElement homeInsurance;

	@FindBy(xpath = "//input[@id='maintenanceexpenses']")
	WebElement maintenance;

	@FindBy(tagName = "th")
	public List<WebElement> tableHeader;

	@FindAll(@FindBy(xpath = "//*[@id='paymentschedule']//tr[@class='row no-margin yearlypaymentdetails']"))
	public List<WebElement> tableData;

	public void setHomeValue() throws IOException {
		homeValue.clear();
		String hv = xlutil.getCellData("TC_002_HomeLoan", 1, 0);
		homeValue.sendKeys(hv);
	}

	public void setMargin() throws IOException {
		marginORDownPayment.clear();
		String mdp = xlutil.getCellData("TC_002_HomeLoan", 1, 1);
		marginORDownPayment.sendKeys(mdp);
	}

	public void setLoanInsurance() throws IOException {
		loanInsurance.clear();
		String li = xlutil.getCellData("TC_002_HomeLoan", 1, 2);
		loanInsurance.sendKeys(li);
	}

	public void setLoanAmount() throws IOException {
		loanAmount.clear();
		String la = xlutil.getCellData("TC_002_HomeLoan", 1, 3);
		loanAmount.sendKeys(la);
	}

	public void setInterestRate() throws IOException {
		String ir = xlutil.getCellData("TC_002_HomeLoan", 1, 4);
		js.executeScript("arguments[0].value = arguments[1]", interestRate, ir);
	}

	public void setLoanTenure() throws IOException {
		String lt = xlutil.getCellData("TC_002_HomeLoan", 1, 5);
		js.executeScript("arguments[0].value= arguments[1]", loanTenure, lt);
	}

	public void setLoanFeesCharges() throws IOException {
		loanFeesCharges.clear();
		String lfc = xlutil.getCellData("TC_002_HomeLoan", 1, 6);
		loanFeesCharges.sendKeys(lfc);
	}

	public void setStartMonthYear() {
		startMonthYear.click();
		currentMonth.click();
	}

	public void setOneTimeExpenses() throws IOException {
		onetimeExpenses.clear();
		String ote = xlutil.getCellData("TC_002_HomeLoan", 1, 7);
		onetimeExpenses.sendKeys(ote);
	}

	public void setPropertyTaxes() throws IOException {
		propertyTaxes.clear();
		String pt = xlutil.getCellData("TC_002_HomeLoan", 1, 8);
		propertyTaxes.sendKeys(pt);
	}

	public void setHomeInsurance() throws IOException {
		homeInsurance.clear();
		String hi = xlutil.getCellData("TC_002_HomeLoan", 1, 9);
		homeInsurance.sendKeys(hi);
	}

	public void setMaintenance() throws IOException {
		maintenance.clear();
		String m = xlutil.getCellData("TC_002_HomeLoan", 1, 10);
		maintenance.sendKeys(m);
	}

	public int getNoOfRows() {
		return tableData.size();
	}
}
