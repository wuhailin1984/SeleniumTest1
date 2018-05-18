package tests;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

import com.PageObject.*;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class PercentCalculator {
	private static WebDriver driver = null;
	static final Logger logger = LogManager.getLogger(PercentCalculator.class.getName());

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		 //the bellowing line is for firefox version under 48
	     System.setProperty("webdriver.firefox.marionette", "C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
	     
	      DOMConfigurator.configure(".\\src\\log4j.xml");
	      logger.info("# # # # # # # # # # # # # # # # # # # # # # # # # # # ");
	      logger.info("TEST Has Started");
	     
		  driver = new FirefoxDriver();
	      driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	      driver.get("http://www.calculator.net");
	      logger.info("Open Calc Application");
	      
	      //Use page Object library now
	      Page_Objects_Perc_Calc.lnk_math_calc(driver).click();	
	      logger.info("Clicked Math Calculator Link");
	      
	      Page_Objects_Perc_Calc.lnk_percent_calc(driver).click();
	      logger.info("Clicked Percent Calculator Link");
	      
	      Page_Objects_Perc_Calc.txt_num_1(driver).clear();
	      Page_Objects_Perc_Calc.txt_num_1(driver).sendKeys("10");
	      logger.info("Entered Value into First Text Box");
	  	   
	      Page_Objects_Perc_Calc.txt_num_2(driver).clear();
	      Page_Objects_Perc_Calc.txt_num_2(driver).sendKeys("50");
	      logger.info("Entered Value into Second Text Box");
	  	   
	      Page_Objects_Perc_Calc.btn_calc(driver).click();
	      logger.info("Click Calculate Button");
	      
	      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	      
	      String result =  Page_Objects_Perc_Calc.web_result(driver).getText();
	      
	      File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	      try {
			FileUtils.copyFile(screenshot, new File(".\\src\\screenshots.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	      
	      logger.info("Get Text Value");
	      
	      logger.info(" The Result is " + result);
	      
	      
	      if(result.equals("5")) {      
	         System.out.println(" The Result is Pass");
	         logger.info("The Result is Pass");
	      } else {
	         System.out.println(" The Result is Fail");
	         logger.error("TEST FAILED. NEEDS INVESTIGATION");
	      }
	      logger.info("# # # # # # # # # # # # # # # # # # # # # # # # # # # ");
	      
	      driver.close();
	   }

}
