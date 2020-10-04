package com.search.ekart;

import org.openqa.selenium.By; 
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class flipkartSearch {
	WebDriver driver;
	By searchProd=By.name("q");
	By clickSearch=By.xpath("//div[contains(@class,'col-12-12 _2tVp4j')]");
	By getRate= By.xpath("//div[@class='_1uv9Cb']//div[@class='_1vC4OE _2rQ-NK']");


	//Constructor for the class driver
	public flipkartSearch(WebDriver driver) {
		this.driver=driver;
	}

	//Here product is searched
	public void searchProd(String name) {


		Actions action = new Actions(driver);
		action.sendKeys(Keys.ESCAPE).perform();
		driver.findElement(searchProd).click();
		driver.findElement(searchProd).sendKeys(name);
	}

	//Here we click on enter to get the results
	public void clickSearch() {
		driver.findElement(searchProd).sendKeys(Keys.ENTER);

	}
	//Here we get the rate of product from flipkart
	public String flipkartRate() {
		return driver.findElement(getRate).getText();
	}


}
