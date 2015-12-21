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

public class SignInPage {
	   private WebDriver driver;

	   //Listing all Locators and elements
	   
	   @FindBy(id = "COAC0WelAccntEmail")
	   private WebElement emailAddressTextBox;
	   
	   @FindBy(id = "COAC0WelAccntPswd")
	   private WebElement passwordTextBox;

	   @FindBy(id = "COAC0WelAccntSignInBtn")
	   private WebElement signInButton;
	   
	   //Constructor
	   public SignInPage (WebDriver driver){
	       this.driver=driver;

	       //Initializing elements of this page
	       PageFactory.initElements(driver, this);
	   }
	   
	   //Methods for this page

	   //Method to select a random item from the search result
	   public void enterEmailAddress(String emailAddress){
		   emailAddressTextBox.clear();
		   emailAddressTextBox.sendKeys(emailAddress);
	   }
	   
	   public void enterPassword(String password){
		   passwordTextBox.clear();
		   passwordTextBox.sendKeys(password);
	   }
	   
	   public void clickSignInButton(){
		   signInButton.click();
	   }
	   
	   public void login(String emailAddress, String password){
		   enterEmailAddress(emailAddress);
		   enterPassword(password);
		   clickSignInButton();
	   }
	   
}
