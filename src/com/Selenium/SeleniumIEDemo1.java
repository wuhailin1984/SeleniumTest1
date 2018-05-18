package com.Selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;


public class SeleniumIEDemo1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
				
	    System.setProperty("webdriver.ie.driver", "C:\\Users\\hwu\\selenium-java-3.11.0\\IEDriverServer.exe");	    
		WebDriver myIEDriv=new InternetExplorerDriver();
		myIEDriv.get("http://www.google.com");
		
		
		
	}
}
