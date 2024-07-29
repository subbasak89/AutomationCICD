package subhrajitbasakacademy.TestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import subhrajitbasakacademy.PageObjects.CartPage;
import subhrajitbasakacademy.PageObjects.ProductCatalogue;
import subhrajitbasakacademy.TestComponents.BaseTest;

public class ErrorValidationTest extends BaseTest {

	@Test (groups = {"ErrorHandling"}, retryAnalyzer = subhrajitbasakacademy.TestComponents.Retry1.class)
	public void loginErrorValidation() throws IOException {
		// TODO Auto-generated method stub

		lp.loginApplication("subhrajitbasak66@gmail.com", "Subsen1989");

		Assert.assertEquals(lp.getError(), "Incorrect email or password");

	}
	
	@Test
	public void productErrorValidation() throws IOException {
		// TODO Auto-generated method stub
		String item = "ADIDAS ORIGINAL";
		ProductCatalogue productCatalogue = lp.loginApplication("subhrajitbasak66@gmail.com", "Subsen#1989");
		productCatalogue.addProductToKart(item);
		CartPage cartPage = productCatalogue.goToCartPage();
		Boolean flag = cartPage.getRequiredCartProduct("ADIDAS");
		Assert.assertFalse(flag);

	}

}
