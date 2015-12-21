package com.walmarttest.webpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage {
	   private WebDriver driver;

	   //Listing Locators and elements
	   
	   //@FindBy(id = "CartRemItemBtn")
	   @FindBy(xpath = "//*[@id='CartRemItemBtn'][contains(text(),'Remove')]")
	   private WebElement webCartRemoveButton;
	   
	   @FindBy(xpath = "//*[@id='CartRemItemBtn'][contains(@class,'btn-delete')]")
	   private WebElement mobileCartRemoveButton;
	   
	   @FindBy(how = How.PARTIAL_LINK_TEXT, using = "My Account")
	   private WebElement myAccountButton;
	   
	   //Constructor
	   public CartPage (WebDriver driver){
	       this.driver=driver;

	       //Initializing elements of this page
	       PageFactory.initElements(driver, this);
	   }
	   
	   //Methods for this page

	   //Method to select a random item from the search result
	   public void removeCartItem(){
		   try {
			   webCartRemoveButton.click();
		   }catch(Exception e){
			   mobileCartRemoveButton.click();
		   }
	   }
	   
	   //Method for signing out from the application
	   public void signout(){
		   Actions action = new Actions(driver);
		   action.moveToElement(myAccountButton).build().perform();;
		   WebElement signOutButton = driver.findElement(By.cssSelector(".js-sign-out"));
		   action.moveToElement(signOutButton).click(signOutButton).build().perform();
	   }
	   
	   //Method to return count of Items in Cart.
	   public String getCountofItemsinCart(){
		   try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   WebDriverWait wait = new WebDriverWait(driver,20);
		   WebElement cartSummaryLabel = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".cart-list-title>span")));
		   System.out.println("Number of items in Cart: "+cartSummaryLabel.getText());
		   return cartSummaryLabel.getText();
	   }
	   
}
