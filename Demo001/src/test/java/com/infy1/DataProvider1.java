package com.infy1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProvider1 {
	  WebDriver driver;
	  String url="http://demo.t3-framework.org/joomla30/index.php/en/joomla-pages/sample-page-2/login-page";
	  @BeforeClass
	  public void setUp() {
//		set the key/values of set property according to the browser we are using 
		System.setProperty("webdriver.chrome.driver","D:\\chromedriver.exe");
//		create the instance
		driver=new ChromeDriver(); 
//		get the page
		driver.get(url);
//		maximize the window
		driver.manage().window().maximize();
	  }
	  
//	  Creating the dataprovider with name login to automate inputs
	  @DataProvider(name="login")
	  public Object[][] dataProvider() {
//		  creation of object which is an 2-dimensional array
		  Object[][] data=new Object[3][2];
		  
		  data[0][0]="kalyanisavatham";
		  data[0][1]="789879887";
		  data[1][0]="kavya223";
		  data[1][1]="784787648";
		  data[2][0]="krishna";
		  data[2][1]="jkhjhjhjh";
		  
		  return data;
	  }
	
	 @Test(dataProvider="login")
	  public void dataTest(String username,String password) {
//		 Finding the text input elements and sending the values which are received from dataprovider method
		 driver.findElement(By.id("username")).sendKeys(username);
		 driver.findElement(By.id("password")).sendKeys(password);
		 driver.findElement(By.xpath("//*[@id=\"t3-content\"]/div[2]/div[1]/form/fieldset/div[4]/div/button")).click();
	  }
	 
	 @AfterClass
	 public void after() {
		 driver.close();
	 }
}
