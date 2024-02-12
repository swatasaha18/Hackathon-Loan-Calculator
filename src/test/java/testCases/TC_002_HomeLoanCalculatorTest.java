package testCases;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import pageObjects.DefaultPage;
import pageObjects.HomeLoanCalculatorPage;
import testBase.BaseClass;
import utilities.ExcelUtility;

public class TC_002_HomeLoanCalculatorTest extends BaseClass{
	@Test
	public void verify_home_loan() throws IOException, InterruptedException {
		DefaultPage dp = new DefaultPage(driver);
		dp.clickCalculators();
		dp.clickHomeLoanEmiCalculator();
		
		HomeLoanCalculatorPage hcp = new HomeLoanCalculatorPage(driver);
		hcp.setHomeValue();
		hcp.setMargin();
		hcp.setLoanInsurance();
		hcp.setLoanAmount();
		hcp.setInterestRate();
		hcp.setLoanTenure();
		hcp.setLoanFeesCharges();
		hcp.setStartMonthYear();
		hcp.setOneTimeExpenses();
		hcp.setPropertyTaxes();
		hcp.setHomeInsurance();
		hcp.setMaintenance();
		
		String path = ".\\testData\\HomeLoan.xlsx";
		ExcelUtility xlutil = new ExcelUtility(path);
		
		for(int i=0; i<hcp.tableHeader.size(); i++) {
			String header = hcp.tableHeader.get(i).getText();
			xlutil.setCellData("Sheet1", 0, i, header);
		}
		Thread.sleep(5000);
		
		for(int i=0; i<hcp.getNoOfRows(); i++) {
			WebElement row = hcp.tableData.get(i);
			List<WebElement> col = row.findElements(By.tagName("td"));
			for(int j=0; j<col.size(); j++) {
				String data = col.get(j).getText();
				xlutil.setCellData("Sheet1", i+1, j, data);
			}
		}
	}
}
