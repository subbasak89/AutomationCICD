package subhrajitbasakacademy.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import subhrajitbasakacademy.AbstractComponents.AbstractComponents;

public class OrderConfirmationPage extends AbstractComponents{
	
	WebDriver driver;

	public OrderConfirmationPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	
	@FindBy (css = ".hero-primary")
	WebElement confirmMessage;
	
	public String getConfirmMessage() {
		
		return confirmMessage.getText();
	}
	
}
