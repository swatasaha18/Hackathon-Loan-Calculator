package pageObjects;

import java.util.List;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

public class HomeLoanCalculatorPage extends BasePage{
	WebDriver driver;
	JavascriptExecutor js;
	public HomeLoanCalculatorPage(WebDriver driver) {
		super(driver);
		js = (JavascriptExecutor)driver;
	}
	

	@FindBy(xpath="//input[@id='homeprice']")
	WebElement homeValue;
	
	@FindBy(xpath="//input[@id='downpayment']")
	WebElement marginORDownPayment;
	
	@FindBy(xpath="//input[@id='homeloaninsuranceamount']")
	WebElement loanInsurance;
	
	@FindBy(xpath="//input[@id='homeloanamount']")
	WebElement loanAmount;
	
	@FindBy(xpath="//input[@id='homeloaninterest']")
	WebElement interestRate;
	
	@FindBy(xpath="//input[@id='homeloanterm']")
	WebElement loanTenure;
	
	@FindBy(xpath="//input[@id='loanfees']")
	WebElement loanFeesCharges;
	
	@FindBy(xpath="//input[@id='startmonthyear']") 
	WebElement startMonthYear;

	@FindBy(xpath="//span[@class='month focused active']")
	WebElement currentMonth;
	
	@FindBy(xpath="//input[@id='onetimeexpenses']")
	WebElement onetimeExpenses;
	
	@FindBy(xpath="//input[@id='propertytaxes']")
	WebElement propertyTaxes;
	
	@FindBy(xpath="//input[@id='homeinsurance']")
	WebElement homeInsurance;
	
	@FindBy(xpath="//input[@id='maintenanceexpenses']")
	WebElement maintenance;
	
	@FindBy(tagName ="th")
	public List<WebElement> tableHeader;
	
	@FindAll(@FindBy(xpath="//*[@id='paymentschedule']//tr[@class='row no-margin yearlypaymentdetails']"))
	public List<WebElement> tableData;
	
	public void setHomeValue() {
		homeValue.clear();
		homeValue.sendKeys("9000000");
	}
	
	public void setMargin() {
		marginORDownPayment.clear();
		marginORDownPayment.sendKeys("30");
	}
	
	public void setLoanInsurance() {
		loanInsurance.clear();
		loanInsurance.sendKeys("100");
	}
	
	public void setLoanAmount() {
		loanAmount.clear();
		loanAmount.sendKeys("6300100");
	}
	
	public void setInterestRate() {
		js.executeScript("arguments[0].value='10'", interestRate);
	}
	
	public void setLoanTenure() {
		js.executeScript("arguments[0].value='10'", loanTenure);
	}
	
	public void setLoanFeesCharges() {
		loanFeesCharges.clear();
		loanFeesCharges.sendKeys("0.27");
	}
	
	public void setStartMonthYear() {
		startMonthYear.click();
		currentMonth.click();
	}
	
	public void setOneTimeExpenses() {
		onetimeExpenses.clear();
		onetimeExpenses.sendKeys("15");
	}
	
	public void setPropertyTaxes() {
		propertyTaxes.clear();
		propertyTaxes.sendKeys("0.3");
	}
	
	public void setHomeInsurance() {
		homeInsurance.clear();
		homeInsurance.sendKeys("0.06");
	}
	
	public void setMaintenance() {
		maintenance.clear();
		maintenance.sendKeys("2000");
	}
	
	public int getNoOfRows() {
		return tableData.size();
	}
}
