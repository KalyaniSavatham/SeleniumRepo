package com.infy;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BrowserSize {
	WebDriver driver;
	String Url="https://www.jquery-az.com/boots/demo.php?ex=63.0_2";

	@BeforeMethod
	public void setUp() throws Exception{
	//	set the key/values of set property according to the browser we are using 
		System.setProperty("webdriver.chrome.driver","D:\\chromedriver.exe");
	//	create the instance
		driver=new ChromeDriver(); 
	//	get the page
		driver.get(Url);
	}
  @Test
  public void browserSizeTest() throws Exception {
	 driver.manage().window().maximize();
//	  setting the dimensions of browser using the dimensions class
	 Dimension d1=new Dimension(56778,12345);
	 driver.manage().window().setSize(d1);
	 Thread.sleep(200);
	 
  }
}
