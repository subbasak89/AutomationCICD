package subhrajitbasakacademy.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import subhrajitbasakacademy.AbstractComponents.AbstractComponents;

public class LandingPage extends AbstractComponents {
	
	WebDriver driver;

	public LandingPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(id = "userEmail")
	WebElement userEmail;
	
	@FindBy (id = "userPassword")
	WebElement password;
	
	@FindBy (id = "login")
	WebElement submitButton;
	
	@FindBy (css = "[class*='flyInOut']")
	WebElement errorMessage;
	
	By errorSpinner = By.cssSelector("[class*='flyInOut']");
	
	
	public ProductCatalogue loginApplication(String email, String pwd) {
		userEmail.sendKeys(email);
		password.sendKeys(pwd);
		submitButton.click();
		ProductCatalogue productCatalogue = new ProductCatalogue(driver);
		return productCatalogue;
	}
	
	public void goTo() {
		driver.get("https://rahulshettyacademy.com/client");
	}
	
	public String getError() {
		waitForElementToAppear (errorSpinner);
		return errorMessage.getText();
	}
}

