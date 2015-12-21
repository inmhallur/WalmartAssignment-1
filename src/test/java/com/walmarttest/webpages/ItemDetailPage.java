package com.walmarttest.webpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ItemDetailPage {
	   private WebDriver driver;

	   //Listing all Locators and elements
	   
	   @FindBy(id="WMItemAddToCartBtn")
	   private WebElement addToCartButton;
	   
	   @FindBy(css=".js-product-heading.heading-b.product-name.product-heading.padding-ends>span")
	   private WebElement productName;

	   //Constructor
	   public ItemDetailPage (WebDriver driver){
	       this.driver=driver;
	       //Initializing elements of this page
	       PageFactory.initElements(driver, this);
	   }
	   
	   //Methods for this page

	   public void addToCart(){
		   addToCartButton.click();	   
	   }
	   
	   public String getItemName(){
		   return productName.getText(); 
	   } 
	   
	   public void checkout(){
		   WebDriverWait wait = new WebDriverWait(driver, 20);
		   WebElement checkout = null;
		   //Need a better way to handle mobile and web application
		   try {
			   checkout = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Check Out')]")));
		   } catch (Exception e) {
		   }
		   try {
			   checkout = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("PACCheckoutBtn")));
		   } catch (Exception e) {
		   }
		   checkout.click();   
	   }	   
}
