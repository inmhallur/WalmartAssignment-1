package com.walmarttest.webpages;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutPage {
	   private WebDriver driver;

	   //Listing all Locators and elements
	   
	   @FindBy(css = ".fulfillment-location-label.valign-top.xxs-margin-top")
	   private WebElement showingOptionsLabel;
	   
	   @FindBys(@FindBy(css = ".checkout-responsive-container .brick-info.pos-item-info .pull-left"))
	   private List<WebElement> cartItemsQty;
	   
	   @FindBys(@FindBy(css = ".checkout-responsive-container .brick-info.pos-item-info .brick-heading>span"))
	   private List<WebElement> cartItemsName;

	   @FindBy(css = ".js-preferred-address-label")
	   private WebElement preferredAddressLabel;
	   
	   @FindBy(css = ".js-address-line-1")
	   private WebElement addressLine1;
	   
	   @FindBy(css = ".credit-card-inner-section-heading.left-column")
	   private WebElement cardInformationLabel;
	   
	   @FindBy(css = ".wmicon.wmicon-cart")
	   private WebElement cartButton;
	   
	   
	   
	   //Constructor
	   public CheckoutPage (WebDriver driver){
	       this.driver=driver;

	       //Initializing elements of this page
	       PageFactory.initElements(driver, this);
	   }
	   
	   //Methods for this page

	   public Map<String, String> getItemsInCart(){
		   Map<String, String> map = new HashMap<String, String>();
		   try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   for(int i=0; i<cartItemsQty.size(); i++){
			   map.put(cartItemsName.get(i).getText(), cartItemsQty.get(i).getText());
		   }
		return map;
	   }
	   
	   
	   public void clickshoppingContinueButton(){
		   WebDriverWait wait = new WebDriverWait(driver,20);
		   WebElement shoppingContinueButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("COAC1ShpOptContBtn")));
		   shoppingContinueButton.click();   
	   }
	   
	   public void clickshippingContinueButton(){
		   WebDriverWait wait = new WebDriverWait(driver,20);
		   WebElement shippingContinueButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("COAC2ShpAddrContBtn")));
		   shippingContinueButton.click();   
	   }
	   
	   public void selectShippingAddress(){
		   try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   WebDriverWait wait = new WebDriverWait(driver,20);
		   WebElement shippingAddress = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".js-preferred-address-label")));
		   shippingAddress.click();  
	   }
	   
	   public boolean isPaymentPage(){
		   WebDriverWait wait = new WebDriverWait(driver,20);
		   WebElement cardInformationLabel = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".credit-card-inner-section-heading.left-column")));
		   return cardInformationLabel.getText().equalsIgnoreCase("Card Information");
	   }
	   
	   public void navigateToCart(){
		   WebDriverWait wait = new WebDriverWait(driver,20);
		   wait.until(ExpectedConditions.elementToBeClickable(cartButton));
		   cartButton.click();
	   }
	   
}
