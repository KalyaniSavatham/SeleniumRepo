package com.infy2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SwitchingTabs {
	WebDriver driver;
	String Url="http://demo.automationtesting.in/Windows.html";

	@BeforeMethod
	public void setUp() throws Exception{
	//	set the key/values of set property according to the browser we are using 
		System.setProperty("webdriver.chrome.driver","C:\\Users\\venkatalakshmikal.s\\Downloads\\chromedriver_win32\\chromedriver.exe");
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
	  driver.findElement(By.xpath("//*[@id=\"header\"]/nav/div/div[2]/ul/li[1]/a")).click();
  }
}
