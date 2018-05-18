package TestNG;

import org.testng.annotations.Test;
import com.PageObject.*;

import tests.PercentCalculator;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNGClass {
   WebDriver driver;
   static final Logger logger = LogManager.getLogger(PercentCalculator.class.getName());
   
   @BeforeTest
   public void launchapp() {
	  
	  System.setProperty("webdriver.firefox.marionette", "C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
	  driver = new FirefoxDriver();
      // Puts an Implicit wait, Will wait for 10 seconds before throwing exception
      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
      // Launch website
      driver.navigate().to("http://www.calculator.net");
      driver.manage().window().maximize();
   }
   
   @Test
   public void calculatepercent() {
      
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
	      
	      if(result.equals("5")) {
	          System.out.println(" The Result is Pass");
	       } else {
	          System.out.println(" The Result is Fail");
	       }
   }
   
   @AfterTest
   public void terminatetest() {
      driver.close();
   }
}