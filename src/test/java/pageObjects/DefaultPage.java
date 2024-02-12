package pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DefaultPage extends BasePage{
	WebDriver driver;
	JavascriptExecutor js;
	public DefaultPage(WebDriver driver) {
		super(driver);
		js = (JavascriptExecutor)driver;
	}
	

	@FindBy(xpath="//a[@id='menu-item-dropdown-2696']")
	WebElement calculators;
	
	@FindBy(xpath="//a[@title='Home Loan EMI Calculator']")
	WebElement homeLoanEMICalculator;
	
	@FindBy(xpath="//a[@title='Loan Calculator']") 
	WebElement loanCalculator;
	
	@FindBy(xpath="//a[normalize-space()='Car Loan']")
	WebElement carLoan;
	
	@FindBy(xpath="//input[@id='loanamount']")
	WebElement carLoanAmount;
	
	@FindBy(xpath="//input[@id='loaninterest']")
	WebElement interestRate;

	@FindBy(xpath="//input[@id='loanterm']")
	WebElement loanTenure;
	
	@FindBy(xpath="//label[normalize-space()='Yr']") 
	WebElement yr;
	
	@FindBy(xpath="//*[@id=\"emiamount\"]/p/span") 
	WebElement emiAmnt;
	
	@FindBy(xpath="//*[@id='year2024']")
	public WebElement currentYr;
	
	@FindBy(xpath="//*[@id='monthyear2024']//tr[1]/td[3]")
	WebElement interestAmnt;
	
	@FindBy(xpath="//*[@id='monthyear2024']//tr[1]/td[2]")
	WebElement principalAmnt;
	

	public void clickCarLoan() {
		carLoan.click();
	}
	
	public void setCarLoanAmount() {
		carLoanAmount.clear();
		carLoanAmount.sendKeys("1500000");
	}
	
	public void setInterestRate() {
		js.executeScript("arguments[0].value='9.5'", interestRate);
	}
	
	public void setLoanTenure() {
		js.executeScript("arguments[0].value='1'" , loanTenure );
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
