package com.infy2;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.google.common.io.Files;

public class GoogleAccountCreation {
	WebDriver driver;
	String Url="https://accounts.google.com/signup";

	@BeforeMethod
	public void setUp() throws Exception{
	//		set the key/values of set property according to the browser we are using 
		System.setProperty("webdriver.chrome.driver","D:\\chromedriver.exe");
	//	create the instance
		driver=new ChromeDriver(); 
	//	get the page
		driver.get(Url);
		driver.manage().window().maximize();
	}
  @Test
  public void test() throws IOException {
	  						/******** Screenshot **********/
	  
	  // Taking screenshot of the page
	  File scrFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	  Files.copy(scrFile, new File("C:\\Users\\venkatalakshmikal.s\\git\\SeleniumRepo\\Demo001\\ScreenShotsFolder\\screenshots.png"));
	  
	  					/*******GoogleAccount Creation *************/
	  
	  //   Getting the webelements by tagname and adding them to a list
	  List<WebElement> li=driver.findElements(By.tagName("input"));
	  // Iterate over the list and search for the input text box for creating the google account
	  for(int i=0;i<=li.size()-1;i++) {
		  if(li.get(i).getAttribute("id").contentEquals("firstName")){
			  li.get(i).sendKeys("Sowmya");
		  }
		  if(li.get(i).getAttribute("id").contentEquals("lastName")) {
			  li.get(i).sendKeys("Akandra");

		  }
		  if(li.get(i).getAttribute("id").contentEquals("username")) {
			  li.get(i).sendKeys("SowmyaAkandra");

		  }
		  if(li.get(i).getAttribute("name").contentEquals("Passwd")) {
			  li.get(i).sendKeys("SowmyaAkandra123");

		  }
		  if(li.get(i).getAttribute("name").contentEquals("ConfirmPasswd")) {
			  li.get(i).sendKeys("SowmyaAkandra123");

		  }
	  }
	  driver.findElement(By.xpath("//*[@id=\"accountDetailsNext\"]/div/button/div[2]")).click();
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  if(driver.findElement(By.xpath("//*[@id=\"phoneNumberId\"]")).getAttribute("id").contentEquals("phoneNumberId")) {
		  driver.findElement(By.xpath("//*[@id=\"phoneNumberId\"]")).sendKeys("9488389849");
	  }
	  WebDriverWait wait=new WebDriverWait(driver, 5);
	  try {
	  wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//*[@id=\"view_container\"]/div/div/div[2]/div/div[2]/div/div[1]/div/div/button/div[2]"))));
	  }catch(StaleElementReferenceException e) {
		  e.getMessage();
	  }
	  driver.findElement(By.xpath("//*[@id=\"view_container\"]/div/div/div[2]/div/div[2]/div/div[1]/div/div/button/div[2]")).click();
	  wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//*[@id=\"view_container\"]/div/div/div[2]/div/div[2]/div[2]/div[1]/div/div/button/div[2]"))));
  }
  @AfterMethod
  public void after() {
	  driver.close();
	  
  }
}
