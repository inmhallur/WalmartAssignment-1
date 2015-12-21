
•	This is a framework created for end to end test cases. This is a Page Object Model framework, built using Java and TestNg.
•	The framework supports running the test on web and mobile browsers. 
•	Following end to end scenario has been implemented completely on the web browser. For mobile, step 4 and step 8 has not been performed. For step 8, didn’t see option to log out in mobile browser and for step 4, I needed some more time. And also because of step 8, the mobile test is failing.
	1. Perform a search on home page from a pool of key words given below
	2. Identify an item from the result set that you can add to cart
	3. Add the item to cart and then login using existing account which is set up with at least one shipping address
	4. Validate that item added is present in the cart and is the only item in the cart
	5. Select Ship to Home as shipping method for your order
	6. Validate that you are on Payment details page
	7. Go back to Cart Page, Remove the item from cart and validate cart is empty
	8. Sign out from your account
•	Script handles Test data handled are tv, socks, dvd. Toys and iPhone needed more scripting which has been ignored for now.
•	Steps for Running:
	o	Import project in any IDE
	o	Update the chromeDriver location TestSetup.java
	o	Right click on pom.xml to run as maven test or right click on TestNG xml to run as TestNG Suite.
•	Configuration:
	o	In TestNG.xml, specify the browser on which you need to run.
			Chrome
			Firefox
			Mobile (Also, specify device supported by Google Chrome)
•	Things that can be improved:
	o	Excel can be used for data driven tests rather than data provider available in TestNg.
	o	Username and Password are hardcoded now, can come from configuration file.
	o	Better segregation of mobile and Web elements and logic.
	o	Have used Thread.sleep at couple of places which on further research can be eliminated.
	o	Configuration file can be made to store location of chromedriver.
	o	Overall, the framework can be better optimized and organized.

