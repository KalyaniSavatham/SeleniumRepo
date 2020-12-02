package com.infy;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BrokenLinks {
	WebDriver driver;
	String Url="http://www.zlti.com";

	@BeforeMethod
	public void setUp() throws Exception{
	//		set the key/values of set property according to the browser we are using 
		System.setProperty("webdriver.chrome.driver","C:\\Users\\venkatalakshmikal.s\\Downloads\\chromedriver_win32\\chromedriver.exe");
	//	create the instance
		driver=new ChromeDriver(); 
	//	get the page
		driver.get(Url);
	//	maximize the window
		driver.manage().window().maximize();
	}
  @Test
  public void brokenLinksTest() {
//	  Get all the web elements based on tagname
	  List<WebElement> li1=driver.findElements(By.tagName("a"));
//	  Get the urls in those tags and check for broken links
	  for(int i=0;i<=li1.size()-1;i++) {
		 String  url=li1.get(i).getAttribute("href");
		 System.out.println(url);
		 if(url==null || url.isEmpty()) {
			 System.out.println("link is broken");
		 }
	  }
	  
	  
  }
}
