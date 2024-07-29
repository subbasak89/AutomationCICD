package subhrajitbasakacademy.PageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import subhrajitbasakacademy.AbstractComponents.AbstractComponents;

public class MyOrdersPage extends AbstractComponents {
	
	WebDriver driver;
	
	public MyOrdersPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	
	@FindBy (xpath = "//tr/td[2]")
	List <WebElement> nameColumn;
	
	public Boolean verifyOrder(String item) {
		Boolean match = nameColumn.stream().anyMatch(productName->productName.getText().equals(item));
		return match;
	}
}
