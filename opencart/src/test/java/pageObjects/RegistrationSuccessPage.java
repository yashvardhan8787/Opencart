package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationSuccessPage extends BasePage{

	public RegistrationSuccessPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath = "//*[@id=\"content\"]/h1")
	WebElement successMessage;
	
	
	public String regSuccessMsg() {
		String msg = successMessage.getText();
		return msg;
	}

}
