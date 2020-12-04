package com.infy;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class googleSearch {
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
  public void resizeGoogleTest() {
	  driver.findElement(By.name("q")).click();
	  List<WebElement> sugg=driver.findElements(By.xpath("//ul[contains(@class,'erkvQe')]//li//div[1]//div[1]/span"));
	  System.out.println(sugg.size());
	  for(int i=0;i<=sugg.size()-1;i++) {
		  if(i==3) {
			  sugg.get(i).click();
		  }
	  }
	  
  }
  @AfterMethod
  public void afterMethod() {
	  driver.close();
  }
}
