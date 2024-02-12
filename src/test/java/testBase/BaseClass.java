package testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

public class BaseClass {
	static public WebDriver driver;
	public Logger logger;
	public Properties p;
	JavascriptExecutor js;
	
	public SoftAssert sa;
	
	@BeforeClass
	@Parameters({"os","browser"})
	public void setup(String os, String br) throws IOException {
		FileReader file = new FileReader(".//src//test//resources//config.properties");
		p = new Properties();
		p.load(file);
		
		logger = LogManager.getLogger(this.getClass());
		
		if(br.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		}
		else if(br.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}
		else {
			System.out.println("No matching browser");
			return;
		}
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.get(p.getProperty("appURL"));
		driver.manage().window().maximize();
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
	// Method to enter value into input box
    public void enterValue(WebElement inputBox, String v) throws InterruptedException {
    	js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].value=arguments[1]" , inputBox, v );
    }
    
    public void assertInputBox(WebElement inputBox,int expectedValue, String fieldName) {
    	String input = inputBox.getAttribute("value").replace(",","");
	    int inputValue = Integer.parseInt(input);
	    sa = new SoftAssert();
	    sa.assertTrue(inputBox.isDisplayed(), fieldName + " input box is not displayed");
	    sa.assertTrue(inputBox.isEnabled(), fieldName + " input box is not enabled");
	    sa.assertEquals(inputValue, expectedValue, fieldName + " input box value does not match expected value");
	    sa.assertAll();
    }

    // Method to move slider to a specific value within a specified range
    public void moveSlider(WebElement slider, int minValue, int maxValue, int value) {
        int sliderWidth = slider.getSize().getWidth();
        double percentage = (double) (value - minValue) / (maxValue - minValue);
        int xOffset = (int) (percentage * sliderWidth);
        xOffset = xOffset - (sliderWidth/2);
		new Actions(driver).dragAndDropBy(slider, xOffset, 0).perform();
    }
	
    public void assertSlider(WebElement inputBox, WebElement slider, int expectedValue, String fieldName) {
	    String input = inputBox.getAttribute("value").replace(",","");
	    Double myDouble = Double.parseDouble(input); //Needed for EMI slider
	    int inputValue = (int) Math.round(myDouble);
	    
	    sa = new SoftAssert();	
	    sa.assertEquals(inputValue, expectedValue, fieldName + " slider value does not match expected value");
	
	    sa.assertTrue(slider.isDisplayed(), fieldName + " slider is not displayed");
	    sa.assertTrue(slider.isEnabled(), fieldName + " slider is not enabled");
	    sa.assertAll();
    }
    
    public void scroll(WebElement element) {
    	js = (JavascriptExecutor)driver;
    	js.executeScript("arguments[0].scrollIntoView();", element);
    }
    
	public String captureScreen(String tname) throws IOException {

		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
				
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		
		String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\" + tname + "_" + timeStamp + ".png";
		File targetFile=new File(targetFilePath);
		
		sourceFile.renameTo(targetFile);
			
		return targetFilePath;

	}
}
