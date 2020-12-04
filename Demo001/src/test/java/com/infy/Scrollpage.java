package com.infy;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Scrollpage {
	WebDriver driver;
	String Url="https://www.jquery-az.com/boots/demo.php?ex=63.0_2";
	
	@BeforeMethod
	public void setUp() throws Exception{
//		set the key/values of set property according to the browser we are using 
		System.setProperty("webdriver.chrome.driver","D:\\chromedriver.exe");
//		create the instance
		driver=new ChromeDriver(); 
//		get the page
		driver.get(Url);
//		maximize the window
		driver.manage().window().maximize();

	}
  @Test
  public void scrollWebPage() throws Exception {
//	  finding the elements using xpath locator
	  WebElement s=driver.findElement(By.xpath("/html/body/hr[1]"));
	  Actions action=new Actions(driver);
	  action.moveToElement(s);	  
	  action.perform();
	  Thread.sleep(3000);
	  action.moveToElement(driver.findElement(By.className("topdiv")));
	  action.perform();
  }
}
