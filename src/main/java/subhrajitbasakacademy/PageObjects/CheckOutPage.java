package subhrajitbasakacademy.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import subhrajitbasakacademy.AbstractComponents.AbstractComponents;

public class CheckOutPage extends AbstractComponents{
	
	WebDriver driver;

	public CheckOutPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(css = "input[placeholder = 'Select Country']")
	WebElement countryDropDown;
	
	@FindBy(css = ".ta-results button")
	List<WebElement> searchResults;
	
	@FindBy(xpath = "//a[text() = 'Place Order ']")
	WebElement placeOrder;
	
	By countryList = By.cssSelector(".ta-results button");
	
	public void selectCountry(String country) {
		countryDropDown.sendKeys(country);
		waitForElementToAppear(countryList);
		WebElement filteredResults = searchResults.stream()
				.filter(searchResult -> searchResult.getText().equals(country)).findFirst().orElse(null);
		filteredResults.click();
	}
	
	public OrderConfirmationPage submitOrder() {
		placeOrder.click();
		OrderConfirmationPage orderConfirmationPage = new OrderConfirmationPage(driver);
		return orderConfirmationPage;
	}

}
