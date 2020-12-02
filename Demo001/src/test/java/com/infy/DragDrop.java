package com.infy;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DragDrop {
	WebDriver driver;
	String Url="http://demo.guru99.com/test/drag_drop.html";

	@BeforeMethod
	public void setUp() throws Exception{
	//	set the key/values of set property according to the browser we are using 
		System.setProperty("webdriver.chrome.driver","C:\\Users\\venkatalakshmikal.s\\Downloads\\chromedriver_win32\\chromedriver.exe");
	//	create the instance
		driver=new ChromeDriver(); 
	//	get the page
		driver.get(Url);

	
	}
		
	  @Test
	  public void dragDropTest() {
//		  Getting the draggable,droppable elements by using xpath loactor
		  WebElement dragEle=driver.findElement(By.xpath("//*[@id=\"credit1\"]/a"));
		  WebElement dragEle1=driver.findElement(By.xpath("//*[@id=\"fourth\"]/a"));
		  WebElement dropEle=driver.findElement(By.id("loan"));
		  WebElement dropEle1=driver.findElement(By.xpath("//*[@id=\"amt8\"]/li"));
//		  performing the dragg operation using actions
          Actions a=new Actions(driver);
		  a.dragAndDrop(dragEle,dropEle).build().perform();
		  a.dragAndDrop(dragEle1, dropEle1).build().perform();
//		  maximize the window
		  driver.manage().window().maximize();
	  }
	  @AfterMethod
	  public void after() {
		  driver.close();
	  }
}
