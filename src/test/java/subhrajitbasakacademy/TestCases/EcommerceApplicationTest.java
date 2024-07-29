package subhrajitbasakacademy.TestCases;

import java.io.IOException;
import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import subhrajitbasakacademy.PageObjects.CartPage;
import subhrajitbasakacademy.PageObjects.CheckOutPage;
import subhrajitbasakacademy.PageObjects.MyOrdersPage;
import subhrajitbasakacademy.PageObjects.OrderConfirmationPage;
import subhrajitbasakacademy.PageObjects.ProductCatalogue;
import subhrajitbasakacademy.TestComponents.BaseTest;

public class EcommerceApplicationTest extends BaseTest {
	
	String item = "ADIDAS ORIGINAL";

	@Test (dataProvider = "getData", groups = "Purchase")
	//public void submitOrder(String email, String password, String item) throws IOException {
	public void submitOrder(HashMap <String,String> input) throws IOException {
		// TODO Auto-generated method stub
		String country = "India";
		String successMessage = "THANKYOU FOR THE ORDER.";
		ProductCatalogue productCatalogue = lp.loginApplication(input.get("email"), input.get("password"));
		productCatalogue.addProductToKart(input.get("product"));
		CartPage cartPage = productCatalogue.goToCartPage();
		Boolean flag = cartPage.getRequiredCartProduct(input.get("product"));
		Assert.assertTrue(flag);
		CheckOutPage checkoutPage = cartPage.goToCheckOutPage();
		checkoutPage.selectCountry(country);
		OrderConfirmationPage orderConfirmationPage = checkoutPage.submitOrder();
		// Actions a = new Actions(driver);
		// a.sendKeys(countryDropdown, country).build().perform();
		String confirmMessage = orderConfirmationPage.getConfirmMessage();
		Assert.assertEquals(confirmMessage, successMessage);

	}
	
	@Test(dependsOnMethods = {"submitOrder"})
	public void orderListValidationTest() throws IOException {
		// TODO Auto-generated method stub
		ProductCatalogue productCatalogue = lp.loginApplication("subhrajitbasak66@gmail.com", "Subsen#1989");
		MyOrdersPage myOrderPage = productCatalogue.goToOrdersList();
		Boolean match = myOrderPage.verifyOrder(item);
		Assert.assertTrue(match);

	}
	
	

	@DataProvider
	public Object[][] getData() {
		
		HashMap <String,String> map = new HashMap <String,String>();
		map.put("email", "subhrajitbasak66@gmail.com");
		map.put("password", "Subsen#1989");
		map.put("product", "ADIDAS ORIGINAL");
		
		HashMap <String,String> map1 = new HashMap <String,String>();
		map1.put("email", "basaksubhrajit89@gmail.com");
		map1.put("password", "Subsen#1989");
		map1.put("product", "ZARA COAT 3");
		
		return new Object[][] {{map},{map1}};
		
		
		
		//return new Object[][]  {{"subhrajitbasak66@gmail.com","Subsen#1989","ADIDAS ORIGINAL"},{"basaksubhrajit89@gmail.com","Subsen#1989","ZARA COAT 3"}};
	}

}
