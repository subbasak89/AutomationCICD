package subhrajitbasakacademy.AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import subhrajitbasakacademy.PageObjects.CartPage;
import subhrajitbasakacademy.PageObjects.MyOrdersPage;

public class AbstractComponents {
	WebDriver driver;
	public AbstractComponents(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (xpath = "//button[@routerlink='/dashboard/cart']")
	WebElement cartButton;
	
	@FindBy (css = "[routerlink*='myorders']")
	WebElement myOrders;
	
	public void waitForElementToAppear(By findBy) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	}
	
	public void waitForElementToDisappear(WebElement ele) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.invisibilityOf(ele));
	}
	
	public CartPage goToCartPage() {
		cartButton.click();
		CartPage cartPage = new CartPage(driver);
		return cartPage;
	}
	
	public MyOrdersPage goToOrdersList() {
		myOrders.click();
		MyOrdersPage myOrderPage = new MyOrdersPage(driver);
		return myOrderPage;
	}
	
}
