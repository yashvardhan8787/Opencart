package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage{
	
	@FindBy(xpath = "//*[@id=\"content\"]/h2[1]")
	WebElement msgHeading;
	
	
	@FindBy(xpath ="//*[@id=\"top-links\"]/ul/li[2]/a")
	WebElement MyAccountDropDown;
	
	
	@FindBy(xpath = "//*[@id=\"top-links\"]/ul/li[2]/ul/li[5]")
	WebElement logoutOption;
	
	public MyAccountPage(WebDriver driver) {
		super(driver);
	}
	
	
	public boolean myAccountHeadingDisplayed() {
		boolean res ;
		try {
			res = msgHeading.isDisplayed();
		}catch(Exception e) {
			res =false;
		}
		return res;
	}
	
	
	public void clickOnMyAccountDropDown() {
	     MyAccountDropDown.click();
	}
	
	public void clickOnLogout() {
		logoutOption.click();
	}
	
	
}
