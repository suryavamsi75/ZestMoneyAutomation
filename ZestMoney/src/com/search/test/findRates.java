package com.search.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.search.ekart.amazonSearch;
import com.search.ekart.flipkartSearch;

public class findRates {

	private WebDriver driver;
	private String inFlipkart;
	private String inAmazon;
	//Here we set the driver location
	@BeforeTest
	public void setUpStepEnv() {
		//Set the path for ChromeDriver
		System.setProperty("webdriver.chrome.driver", driverLocation);
	}
	
	//Here we get the rate from amazon
	@Test (priority=1)
	public void searchAmazon() throws Throwable {
		//Initiate new driver
		driver = new ChromeDriver();
		// Launch Website
		driver.navigate().to("https://www.amazon.in");

		// Maximize the browser
		driver.manage().window().maximize();

		amazonSearch a=new amazonSearch(driver);
		Thread.sleep(5000);
		a.searchProd("iPhone 11 (64GB) - White");
		a.clickSearch();
		inAmazon=a.amazonRate();
		System.out.println(inAmazon);


		driver.close();
	}
	//Here we get the rate from flipkart 
	@Test (priority=2)
	public void searchFlipkart() throws Throwable {
		//Initiate new driver
		driver = new ChromeDriver();
		// Launch Website
		driver.navigate().to("https://www.flipkart.com/");

		// Maximize the browser
		driver.manage().window().maximize();

		flipkartSearch b= new flipkartSearch(driver);

		b.searchProd("iPhone 11 (64GB) - White");
		b.clickSearch();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		inFlipkart=b.flipkartRate();
		System.out.println(inFlipkart);
		driver.close();
		

	}
	
	//Here we compare the values between amazon and flipkart
	@AfterTest
	public void compareResult() {
		String a=inAmazon;
		String c=inFlipkart.replace("₹", "");
		String d=a.replace(",", "");
		String e=c.replace(",", "");
		System.out.println(d + e);
		int i=Integer.parseInt(d);
		int j=Integer.parseInt(e);
		if(i>j) {
			System.out.println("Price in amazon is higher than flipkart");
		}
		else if(i<j) {
			System.out.println("Price in flipkart is higher than amazon");
		}
		else {
			System.out.println("Price in amazon and flipkart are equal");
		}
	}


	//BrowserDriver Location
	private String driverLocation= System.getProperty("user.dir") + "\\" + "browserDriver" + "\\" + "chromedriver.exe";


}
