package com.search.ekart;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class amazonSearch {
	WebDriver driver;
	By searchProd=By.cssSelector(("#twotabsearchtextbox"));
	By clickSearch=By.cssSelector((".nav-search-submit"));
	By getRate= By.xpath("//span[@class='a-price-whole']");

	//Constructor for amazonSearch
	public amazonSearch(WebDriver driver) {
		this.driver=driver;
	}
	//Here product is searched
	public void searchProd(String name) {
		driver.findElement(searchProd).click();
		driver.findElement(searchProd).sendKeys(name);
	}
	//Here we click on enter to get the results
	public void clickSearch() {
		driver.findElement(clickSearch).click();
	}
	//Here we get the rate of product from amazon
	public String amazonRate() {
		return driver.findElement(getRate).getText();
	}


}
