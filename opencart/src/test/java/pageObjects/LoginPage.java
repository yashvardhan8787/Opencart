package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
	
	@FindBy(xpath = "//input[@id=\"input-email\"]")
	WebElement txtUsername;
	
	@FindBy(xpath="//input[@id=\"input-password\"]")
    WebElement txtPassword;
	
	
	@FindBy(xpath = "//input[@value=\"Login\"]")
	WebElement loginBtn;
	
		
	public LoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
    
	
	public void enterLoginUsername(String username) {
		txtUsername.sendKeys(username);	
	}
	
	public void enterLoginPassword(String password) {
		txtPassword.sendKeys(password);
	}
	
	public void clickLoginButton() {
		loginBtn.click();
	}
	
}
