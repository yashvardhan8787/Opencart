package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
	
	//enter  xpath for myAccount link
	@FindBy(xpath="//a[@title='My Account']")
	private WebElement linkMyAccount;
	
	// Enter xpath of login link
	@FindBy(xpath = "//a[text()='Login']")
	private WebElement linkLogin;
	
	//Enter xpath of registration link
    @FindBy(xpath = "//a[text()='Register']")
	private WebElement linkRegistration;
	

	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	
	public void clickLoginLink() {
		linkLogin.click();
	}
	
	public void clickRgesitrationLink() {
		linkRegistration.click();
	}
	
	
	public void clickMyAccount() {
		linkMyAccount.click();
	}

}
