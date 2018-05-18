package com.PageObject;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.*;
import org.apache.commons.io.FileUtils;


public class Page_Objects_Perc_Calc {

	
	 private static WebElement element = null;
	 
	   // Math Calc Link
	   public static WebElement lnk_math_calc(WebDriver driver)  {
	     try {
	    	 element = driver.findElement(By.xpath(".//*[@id='homelistdiv']/table/tbody/tr/td[3]/div[2]"));
	    	 return element;
	     }
		  catch(Exception e) {
			  //Logger.error("Link is not found.");
			  File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		      try {
				FileUtils.copyFile(screenshot, new File(".\\src\\screenshots.jpg"));
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		      throw(e);
		  }     
	   }
		
	   //Percentage Calc Link
	   public static WebElement lnk_percent_calc(WebDriver driver) {
	      element = driver.findElement(By.xpath(".//*[@id='content']/ul[1]/li[3]/a"));
	      return element;
	   }
		
	   //Number 1 Text Box
	   public static WebElement txt_num_1(WebDriver driver) {
	      element = driver.findElement(By.id("cpar1"));
	      return element;
	   }
		
	   //Number 2 Text Box	
	   public static WebElement txt_num_2(WebDriver driver) {
	      element = driver.findElement(By.id("cpar2"));
	      return element;
	   }
		
	   //Calculate Button	
	   public static WebElement btn_calc(WebDriver driver) {
	      element =
	         driver.findElement(By.xpath(".//*[@id='content']/table[1]/tbody/tr[2]/td/input[2]"));
	      return element;
	   }	
		
	   // Result	
	   public static WebElement web_result(WebDriver driver) {
	      element =
	         driver.findElement(By.xpath(".//*[@id='content']/p[2]/font/b"));
	      return element;
	   }	
	
	
}
