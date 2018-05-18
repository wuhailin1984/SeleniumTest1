package com.Selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumChromeDemo1 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//WebDriver myChromeDriv=new ChromeDriver();		
		//myChromeDriv.get("http://www.google.com");
		//WebElement searchBoxInput = myChromeDriv.findElement(By.id("lst-ib"));
		//searchBoxInput.sendKeys("java selenium 自动化测试");
		WebDriver driver=new ChromeDriver();	
		
		driver.manage().window().maximize();
		driver.get("https://ncalculators.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.cssSelector("span")).click();
		driver.findElement(By.linkText("Number Conversions")).click();
		driver.findElement(By.linkText("Percentage Calculator")).click();
		driver.findElement(By.id("a")).click();
		driver.findElement(By.id("a")).clear();
		driver.findElement(By.id("a")).sendKeys("10");
		driver.findElement(By.id("b")).clear();
		driver.findElement(By.id("b")).sendKeys("50");
		driver.findElement(By.id("button")).click();
		//assertEquals("5", driver.findElement(By.id("result1")).getAttribute("value"));	
		
	}
	
}
