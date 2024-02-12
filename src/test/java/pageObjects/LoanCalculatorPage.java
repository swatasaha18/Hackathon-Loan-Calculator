package pageObjects;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoanCalculatorPage extends BasePage{
	WebDriver driver;
	JavascriptExecutor js;
	public LoanCalculatorPage(WebDriver driver) {
		super(driver);
		js = (JavascriptExecutor)driver;
	}
	

	@FindBy(xpath="//a[@class='hidden-ts'][normalize-space()='EMI Calculator']")
	public WebElement eMICalculator;
	
	@FindBy(xpath="//a[normalize-space()='Loan Amount Calculator']")
	public WebElement loanAmountCalculator;
	
	@FindBy(xpath="//a[normalize-space()='Loan Tenure Calculator']")
	public WebElement loanTenureCalculator;
	
	@FindBy(xpath="//input[@id='loanamount']")
	public WebElement loanAmount;
	
	@FindBy(xpath="//div[@id='loanamountslider']")
	public WebElement loanamountslider;
	
	@FindBy(xpath="//input[@id='loaninterest']")
	public WebElement interestRate;
	
	@FindBy(xpath="//div[@id='loaninterestslider']")
	public WebElement interestslider;
	
	@FindBy(xpath="//input[@id='loanterm']")
	public WebElement loanTenure;
	
	@FindBy(xpath="//div[@id='loantermslider']")
	public WebElement loantenureslider;
	
	@FindBy(xpath = "//*[@id=\"loantermsteps\"]/span/span")
	List<WebElement> loanTenureSteps;
	
	@FindBy(id = "loanyears")
	WebElement loanTenureYearButton;
	
	@FindBy(id = "loanmonths")
	WebElement loanTenureMonthButton;
	
	@FindBy(xpath="//input[@id='loanfees']")
	public WebElement feesAndCharges;
	
	@FindBy(xpath="//div[@id='loanfeesslider']")
	public WebElement loanfeesslider;
	
	@FindBy(xpath="//input[@id='loanemi']")
	public WebElement eMI;
	
	@FindBy(xpath="//div[@id='loanemislider']")
	public WebElement loanemislider;
	
	public void clickEMICalculator() {
		eMICalculator.click();
	}
	
	public void clickLoanAmountCalculator() {
		loanAmountCalculator.click();
	}
	
	public void clickLoanTenureCalculator() {
		loanTenureCalculator.click();
	}
	
	public boolean changeLoanTenure() {
		Random random = new Random();
		if(loanTenureYearButton.isSelected()) {
			int elementNumber = random.nextInt(loanTenureSteps.size());
			String time = loanTenureSteps.get(elementNumber).getText();
			js.executeScript("arguments[0].click();", loanTenureMonthButton);
			String time2 = loanTenureSteps.get(elementNumber).getText();
			int t2 = Integer.parseInt(time2) / 12;
			String time3 = String.valueOf(t2);
			return (time.equals(time3));
		}
		else if(loanTenureMonthButton.isSelected()) {
			int elementNumber = random.nextInt(loanTenureSteps.size());
			String time = loanTenureSteps.get(elementNumber).getText();
			js.executeScript("arguments[0].click();", loanTenureYearButton);
			String time2 = loanTenureSteps.get(elementNumber).getText();
			int t2 = Integer.parseInt(time2) * 12;
			String time3 = String.valueOf(t2);
			return (time.equals(time3));
		}
		return false;
	}
	
}
