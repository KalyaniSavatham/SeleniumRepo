package com.infy;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TextInput {
	WebDriver driver;
	String Url="https://www.google.com";

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
}
  @Test
  public void textInputTest() {
//	  finding the web element by name
	  WebElement send=driver.findElement(By.name("q"));
//	  Using javascriptexceutor to send the keys
	  JavascriptExecutor js=(JavascriptExecutor)driver;
	  js.executeScript("arguments[0].value='video';",send);
	  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
  }
  @AfterMethod
  public void afterMethod() {
	  driver.close();
  }
  
}
