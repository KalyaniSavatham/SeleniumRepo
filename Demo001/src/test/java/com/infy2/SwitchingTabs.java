package com.infy2;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SwitchingTabs {
	WebDriver driver;
	String Url="https://rahulshettyacademy.com/AutomationPractice/";

	@BeforeMethod
	public void setUp() throws Exception{
	//	set the key/values of set property according to the browser we are using 
		System.setProperty("webdriver.chrome.driver","D:\\chromedriver.exe");
	//	create the instance
		driver=new ChromeDriver(); 
	//	get the page
		driver.get(Url);
	//	maximize the window
		driver.manage().window().maximize();
	//	implicit wait for 5 seconds
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
  @Test
  public void switchTabs() {
//	  FInd the element to be clicked
	 driver.findElement(By.xpath("//*[@id=\"opentab\"]")).click();
	 driver.findElement(By.tagName("button")).click();
//	 Opening the Jobs in new tab
	 String newTab=Keys.chord(Keys.CONTROL,Keys.RETURN);
	 driver.findElement(By.linkText("Jobs")).sendKeys(newTab);
//	 Getting the window handles that has been opened so far for going to that newly opened tab
	 Set<String> tabs= driver.getWindowHandles();
	 List<String> tabs1=new ArrayList<String>(tabs);
//	 Switching to the new tab
	 driver.switchTo().window(tabs1.get(1));
//	 Selecting the dropdown elements
	 WebElement from=driver.findElement(By.id("select-job-type"));
	 Select selectJob=new Select(from);
	 selectJob.selectByVisibleText("Freelancing work for Automation Projects (Java/Python/JavaScript)");
  }
}
