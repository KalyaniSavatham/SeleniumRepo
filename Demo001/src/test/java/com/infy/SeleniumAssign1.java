package com.infy;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SeleniumAssign1 {
	WebDriver driver;
	String Url="https://www.jquery-az.com/boots/demo.php?ex=63.0_2";
	
	@BeforeMethod
	public void setUp() throws Exception{
//		set the key/values of set property according to the browser we are using 
		System.setProperty("webdriver.chrome.driver","C:\\Users\\venkatalakshmikal.s\\Downloads\\chromedriver_win32\\chromedriver.exe");
//		create the instance
		driver=new ChromeDriver(); 
//		get the page
		driver.get(Url);
//		maximize the window
		driver.manage().window().maximize();
//		implicit wait for 5 seconds
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	 @Test
	 public void test() throws Exception {
//		 finding the element
		  driver.findElement(By.xpath("/html/body/div[3]/table/tbody/tr[2]/td[3]/div/span/div/button")).click();
//		  collecting the elements in the dropdown
		  List<WebElement> webElement = driver.findElements(By.xpath("//ul[contains(@class, 'multiselect-container' )]//li//a//label"));
//		  For the selection of required one
		  for(WebElement w:webElement) {
			 if(w.getText().contentEquals("Java")) {
				 w.click();
			 }
		  }		  
	  }
	 @AfterMethod
	  public void afterMethod() {
//		 closing the page
		  driver.close();
	  }
}
