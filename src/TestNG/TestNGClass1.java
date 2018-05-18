package TestNG;

import org.openqa.selenium.*;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.PageObject.Page_Objects_Perc_Calc;

import java.net.URL;
import java.util.concurrent.TimeUnit;
import java.net.MalformedURLException;

public class TestNGClass1 {
	
	 public WebDriver driver;
	   public String URL, Node;
	   protected ThreadLocal<RemoteWebDriver> threadDriver = null;
	   
	   @Parameters("browser")
	   @BeforeTest
	   public void launchapp(String browser) throws MalformedURLException {
		   
		   
		   //System.setProperty("webdriver.ie.driver", "C:\\Users\\hwu\\selenium-java-3.11.0\\IEDriverServer.exe");
		   //System.setProperty("webdriver.firefox.marionette", "C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");

		   
	      String URL = "http://www.calculator.net";
	      
	      if (browser.equalsIgnoreCase("firefox")) {
	         System.out.println(" Executing on FireFox");
	         String Node = "http://localhost:4444/wd/hub";
	         DesiredCapabilities cap = DesiredCapabilities.firefox();
	         cap.setBrowserName("firefox");
	         
	         driver = new RemoteWebDriver(new URL(Node), cap);
	         // Puts an Implicit wait, Will wait for 10 seconds before throwing exception
	         driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	         
	         // Launch website
	         driver.navigate().to(URL);
	         driver.manage().window().maximize();
	      } else if (browser.equalsIgnoreCase("chrome")) {
	         System.out.println(" Executing on CHROME");
	         DesiredCapabilities cap = DesiredCapabilities.chrome();
	         cap.setBrowserName("chrome");
	         String Node = "http://localhost:4444/wd/hub";
	         driver = new RemoteWebDriver(new URL(Node), cap);
	         driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	         
	         // Launch website
	         driver.navigate().to(URL);
	         driver.manage().window().maximize();
	      } else if (browser.equalsIgnoreCase("internet explorer")) {
	         System.out.println(" Executing on IE");
	         DesiredCapabilities cap = DesiredCapabilities.internetExplorer();
	         cap.setBrowserName("internet explorer");
	         String Node = "http://localhost:4444/wd/hub";
	         driver = new RemoteWebDriver(new URL(Node), cap);
	         driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	         
	         // Launch website
	         driver.navigate().to(URL);
	         driver.manage().window().maximize();
	      } else {
	         throw new IllegalArgumentException("The Browser Type is Undefined");
	      }
	   }
	   
	   @Test
	   public void calculatepercent() {
		   //Use page Object library now
		      Page_Objects_Perc_Calc.lnk_math_calc(driver).click();	
		  
		      
		      Page_Objects_Perc_Calc.lnk_percent_calc(driver).click();
		
		      
		      Page_Objects_Perc_Calc.txt_num_1(driver).clear();
		      Page_Objects_Perc_Calc.txt_num_1(driver).sendKeys("10");
		   
		  	   
		      Page_Objects_Perc_Calc.txt_num_2(driver).clear();
		      Page_Objects_Perc_Calc.txt_num_2(driver).sendKeys("50");
		      
		  	   
		      Page_Objects_Perc_Calc.btn_calc(driver).click();
		      
		      
		      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		      
		      String result =  Page_Objects_Perc_Calc.web_result(driver).getText();
		      
		      if(result.equals("5")) {
		          System.out.println(" The Result is Pass");
		       } else {
		          System.out.println(" The Result is Fail");
		       }
	   }
	   
	   @AfterTest
	   public void closeBrowser() {
	      driver.quit();
	   }
}
