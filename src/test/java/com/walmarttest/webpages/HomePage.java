package com.walmarttest.webpages;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	   private WebDriver driver;

	   //Listing all Locators and elements
	   
	   @FindBy(id="search")
	   private WebElement searchTextBox;

	   @FindBy(css=".searchbar-submit")
	   private WebElement searchButton;

	   //Constructor
	   public HomePage (WebDriver driver){
	       this.driver=driver;

	       //Initializing elements of this page
	       PageFactory.initElements(driver, this);
	   }
	   
	   //Methods for this page

	   //Method to enter search text
	   public void setSearchText(String searchText){
		   searchTextBox.clear();
	       searchTextBox.sendKeys(searchText);
	       searchTextBox.sendKeys(Keys.ESCAPE);
	   }
	   
	   //Method to enter search text
	   public void clickSearchButton(){
		   searchButton.click();
	   }
	   
	   public void searchItem(String searchText){
		   setSearchText(searchText);
		   clickSearchButton();
	   }

}
