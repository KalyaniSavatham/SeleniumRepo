package com.infy2;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class PinVerification {
	WebDriver driver;
	String Url="http://chennaiiq.com/chennai/pincode-by-name.php";

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
  public void pincodeVerifyTest() {
//	  Get the pincode elements from table in the page
	  List<WebElement> w=driver.findElements(By.xpath("/html/body/table/tbody/tr[3]/td[2]/table/tbody/tr/td[3]"));
	  Boolean s=false;
	  for(int i=1;i<w.size()-4;i++) {
		  for(int j=i+1;j<=w.size()-4;j++) {
			 if(w.get(i).getText().contentEquals(w.get(i).getText())){
				 s=true;
			 }
		  }
	  }
//	  Checking if two pincodes are equal using the assertions
	  Assert.assertTrue(s);;
  }
}
