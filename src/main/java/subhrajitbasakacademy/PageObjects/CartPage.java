package subhrajitbasakacademy.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import subhrajitbasakacademy.AbstractComponents.AbstractComponents;

public class CartPage extends AbstractComponents {
	WebDriver driver;

	public CartPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(css = ".cartSection h3")
	List<WebElement> cartProducts;
	
	@FindBy(xpath = "//*[contains(text(), 'Checkout')]")
	WebElement checkoutButton;
	
	By countryDropDown = By.cssSelector("input[placeholder = 'Select Country']");

	public Boolean getRequiredCartProduct(String item) {
		Boolean match = cartProducts.stream().anyMatch(cartProduct -> cartProduct.getText().equalsIgnoreCase(item));
		return match;
	}
	
	public CheckOutPage goToCheckOutPage() {
		checkoutButton.click();
		waitForElementToAppear(countryDropDown);
		CheckOutPage checkoutPage = new CheckOutPage(driver);
		return checkoutPage;
	}
}
