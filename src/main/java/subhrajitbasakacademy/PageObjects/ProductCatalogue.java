package subhrajitbasakacademy.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import subhrajitbasakacademy.AbstractComponents.AbstractComponents;

public class ProductCatalogue extends AbstractComponents{
	WebDriver driver;

	public ProductCatalogue(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	//List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));
	@FindBy(css = ".mb-3")
	List<WebElement> products;
	
	@FindBy (css = ".ng-animating")
	WebElement waitElement;
	
	By findProductList = By.cssSelector(".mb-3");
	By clickAddToKart = By.cssSelector(".card-body button:last-of-type");
	By toastMessage = By.id("toast-container");
	
	public List<WebElement> productList() {
		waitForElementToAppear(findProductList);
		return products;
	}
	
	public WebElement getProduct(String item) {
		WebElement prod = products.stream()
				.filter(product -> product.findElement(By.cssSelector("b")).getText().equals(item)).findFirst()
				.orElse(null);
		return prod;
	}
	public void addProductToKart(String item) {
		WebElement prod = getProduct(item);
		prod.findElement(clickAddToKart).click();
		waitForElementToAppear(toastMessage);
		waitForElementToDisappear(waitElement);
	}
	
	
}
