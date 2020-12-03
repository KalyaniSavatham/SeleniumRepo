package com.infy1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;






public class ExtentReportGeneration {
	ExtentReports report;
	ExtentTest test1;
	  @BeforeClass
	  public void startTest() {
		  report= new ExtentReports("C:\\Users\\venkatalakshmikal.s\\git\\SeleniumRepo\\Demo001\\ExtentReport\\ExtentReport.html");
		  test1=report.startTest("ExtentReportGeneration");
	  }
	
	
	  @Test
	  public void extentReportTest() {
//		  	set the key/values of set property according to the browser we are using 
			System.setProperty("webdriver.chrome.driver","C:\\Users\\venkatalakshmikal.s\\Downloads\\chromedriver_win32\\chromedriver.exe");
//			create the instance
		  	WebDriver driver=new ChromeDriver();
//			get the page
			driver.get("https://www.google.co.in");
			if(driver.getTitle().contentEquals("Google")) {
				test1.log(LogStatus.PASS, "navigated to the browser");
			}
			else {
				test1.log(LogStatus.FAIL,"test failed");
			}  
	  }
	  @AfterClass
	  public void endTest() {
		  report.endTest(test1);
		  report.flush();
	  }
}
