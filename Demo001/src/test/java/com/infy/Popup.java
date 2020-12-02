package com.infy;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Popup {
	WebDriver driver;
	String Url="http://popuptest.com/goodpopups.html";

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
	public void popUpSwitchTest() {
//		Getting the current url of the page and loading all the popups in the page
		String Url=driver.getCurrentUrl();
		String s=driver.getTitle();
		driver.findElement(By.xpath("/html/body/table[2]/tbody/tr/td/font/b/a[1]")).click();
		driver.findElement(By.xpath("/html/body/table[2]/tbody/tr/td/font/b/a[2]")).click();
		driver.findElement(By.xpath("/html/body/table[2]/tbody/tr/td/font/b/a[3]")).click();
		driver.findElement(By.xpath("/html/body/table[2]/tbody/tr/td/font/b/a[4]")).click();
//		Getting all the windows that have been opened and iterating through the set and managing the popus alongwith their titles
		Set<String> handles=driver.getWindowHandles();
		for(String h:handles) {
			driver.switchTo().window(h);
			if(!driver.getTitle().contentEquals(s)) {
				String t=driver.getTitle();
				System.out.println(t);
				driver.close();
			}
		}

	}
	@AfterMethod
	public void afterMethod() throws Exception{
		driver.quit();
		
	}
}
