package com.walmarttest.webpages;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchResultPage {
	   private WebDriver driver;

	   //Listing all Locators and elements
	   
	   @FindBys(@FindBy(css = ".radio-content"))
	   private List<WebElement> pickUpAndDeliveryOptions;
	   
	   @FindBys(@FindBy(xpath = "//div/div/div/div/div/div/a[starts-with(@href,'/ip/')]"))
	   private List<WebElement> results;
	   
	   //Constructor
	   public SearchResultPage (WebDriver driver){
	       this.driver=driver;

	       //Initializing elements of this page
	       PageFactory.initElements(driver, this);
	   }
	   
	   //Methods for this page

	   //Method to select first item from the search result
	   public void selectFirstItem(){
		   int size = results.size();
		   if (size!=0) {
				   WebElement itemToSelect = results.get(0);
				   itemToSelect.click();
		   } else {
			   System.out.println("No results fetched");
		   }
	   }
}
