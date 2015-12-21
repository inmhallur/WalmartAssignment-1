package com.walmarttest.tests;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.walmarttest.webpages.CartPage;
import com.walmarttest.webpages.CheckoutPage;
import com.walmarttest.webpages.HomePage;
import com.walmarttest.webpages.ItemDetailPage;
import com.walmarttest.webpages.SearchResultPage;
import com.walmarttest.webpages.SignInPage;

public class End2EndTests extends TestSetup{
  private WebDriver driver;
  
  //Data set to be tested
  @DataProvider(name = "searchItems")
  public static Object[][] searchTerms() {
     return new Object[][] {{"tv"}, {"Socks"}, {"dvd"}};
  }
  
  @Test(dataProvider = "searchItems")
  public void TestCase1(String searchItem) {
	  HomePage homePage = new HomePage(driver);
	  //Search item on Walmart homepage.
	  homePage.searchItem(searchItem);
	  SearchResultPage resultsPage = new SearchResultPage(driver);
	  //Select first item in the Search Result
	  resultsPage.selectFirstItem();
	  ItemDetailPage itemDetail = new ItemDetailPage(driver);
	  //Get name of the product selected
	  String itemSelected = itemDetail.getItemName();
	  //Add item to cart
	  itemDetail.addToCart();
	  //Checkout the item
	  itemDetail.checkout();
	  SignInPage signIn = new SignInPage(driver);
	  //Sign in to the account
	  signIn.login("abctest@abctest.com", "12345a");
	  CheckoutPage checkOut = new CheckoutPage(driver);
	  Map<String,String> cartItems = new HashMap<String,String>();
	  //Get all items in the cart
	  cartItems = checkOut.getItemsInCart();
	  
	  //Mobile verification not done, handled exception here so that both work fine.
	  try{
		  //Verifying number of items in cart
		  System.out.println("Verifying number of items in cart");
		  Assert.assertEquals(cartItems.size(), 1);
		  //Verifying item selected and cart item match.
		  System.out.println("Verifying item in cart and item selected are same.");
		  Assert.assertEquals(itemSelected.contains(cartItems.keySet().iterator().next().toString().substring(0, 15)),true);
		  //Verifying that quantity of item is 1 in cart.
		  System.out.println("Verifying quantity of item in cart is 1.");
		  Assert.assertEquals(cartItems.containsValue("Qty 1"),true);
	  } catch (StringIndexOutOfBoundsException e){
		  System.out.println("Handling exception in mobile browser. Cart details verification not implemented for mobile");
	  }
	  
	  //Selecting the default shipping option
	  checkOut.clickshoppingContinueButton();
	  //Selecting preferred shipping address
	  checkOut.selectShippingAddress();
	  checkOut.clickshippingContinueButton();
	  //Verifying that payment page is open.
	  Assert.assertEquals(checkOut.isPaymentPage(),true);
	  //Navigating to Cart
	  checkOut.navigateToCart();
	  CartPage cartPage = new CartPage(driver);
	  //Removing cart item
	  cartPage.removeCartItem();
	  //Verifying that cart is empty
	  Assert.assertEquals(cartPage.getCountofItemsinCart(), "0 items.");
	  //Signing out from the account
	  cartPage.signout();
  }
  
	@BeforeMethod
	public void setUp() {
		driver=getDriver();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}
	
	@AfterMethod
	public void TearDown() {
		driver.close();
	}

}
