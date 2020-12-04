package com.infy;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ReadProperties {
	  WebDriver driver;
	  @Test
	  public void readPropertiesTest() throws IOException {
//		 set the key/values of set property according to the browser we are using 
	     System.setProperty("webdriver.chrome.driver","D:\\chromedriver.exe");
//		 Get the file using the file path of config.properties
		 FileInputStream fin=new FileInputStream("C:\\Users\\venkatalakshmikal.s\\git\\SeleniumRepo\\Demo001\\Config.properties\\Config.Properties");
//		 creating an instance of the properties class and loading the file to get the key,values in file
		 Properties prop=new Properties();
		 prop.load(fin);
//		 Accessing the key,valus in the config.properties file
		 if(prop.getProperty("browser").contentEquals("chrome")) {
			 driver=new  ChromeDriver();
			 driver.get(prop.getProperty("url"));
			 driver.findElement(By.id("username")).sendKeys(prop.getProperty("username"));
			 driver.findElement(By.id("password")).sendKeys(prop.getProperty("password"));
			 driver.findElement(By.xpath("//*[@id=\"t3-content\"]/div[2]/div[1]/form/fieldset/div[4]/div/button")).click();
		 }
		 else {
			 System.out.println("Driver not available");
		 }
	  }
}
