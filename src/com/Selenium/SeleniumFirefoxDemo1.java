package com.Selenium;

import org.openqa.selenium.*;

import org.openqa.selenium.firefox.FirefoxDriver;


public class SeleniumFirefoxDemo1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
				
		//the belowing line is for firefox version under 48
	    System.setProperty("webdriver.firefox.marionette", "C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
		
		//the belowing line is for firefox version above 48
		//System.setProperty("webdriver.gecko.driver", "C:\\Users\\hwu\\selenium-java-3.11.0\\geckodriver.exe"); 
		
		WebDriver myFirefoxDriv=new FirefoxDriver();
		myFirefoxDriv.get("http://www.google.com");
	}

}
