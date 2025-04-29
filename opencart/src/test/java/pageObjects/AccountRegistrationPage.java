package pageObjects;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
public class AccountRegistrationPage extends BasePage {

	public AccountRegistrationPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//div[@id='content']//h1")
	WebElement txtHeading;
	
	@FindBy(xpath = "//input[@id='input-firstname']")
	WebElement txtFirstName;
	
	@FindBy(xpath = "//input[@id='input-lastname']")
	WebElement txtLastName;
	
	@FindBy(xpath = "//input[@id='input-email']")
	WebElement txtEmail;
	
	@FindBy(xpath = "//input[@id='input-telephone']")
	WebElement txtTelephone;
	
	@FindBy(xpath = "//input[@id='input-password']")
	WebElement txtPassword;
	
	@FindBy(xpath = "//input[@id='input-confirm']")
	WebElement txtConfirmPassword;
	
	@FindBy(xpath = "//label[text()='Yes']//input[@name='newsletter']")
	WebElement radioBtnNewseletterSuscribeYes;
	
	@FindBy(xpath = "//label[text()='No']//input[@name='newsletter']")
	WebElement radioBtnNewseletterSuscribeNo;
	
	@FindBy(xpath = "//input[@name='agree']")
	WebElement policyCheckBox;
	
	@FindBy(xpath = "//input[@value='Continue']")
	WebElement continueButton;
	
	public String getContentHeading() {
		String str;
		try {
		   str= txtHeading.getText();
		}catch(Exception e){
		   str="";
		}
		return str;
	}
	
	
	public void enterFirstName(String firstname) {
		txtFirstName.sendKeys(firstname);
	}
	
	public void enterLastName(String lastname) {
		txtLastName.sendKeys(lastname);
	}
		
	public void enterEmail(String email){
		txtEmail.sendKeys(email);
	}
	
	public void enterTelephone(String phone){
		txtTelephone.sendKeys(phone);
	}
	
	public void enterPassword(String password) {
		txtPassword.sendKeys(password);
	}
	
	public void enterConfirmPassword(String password) {
		txtConfirmPassword.sendKeys(password);
	}
	
	public void clickNewsletterSuscribeYes() {
		radioBtnNewseletterSuscribeYes.click();
	}
	
	public void clickNewsletterSuscribeNo() {
		radioBtnNewseletterSuscribeNo.click();
	}
   
	public void checkPrivacyPolicy() {
		policyCheckBox.click();
	}
	
	
	public void clickRegistrationContinueBtn() {
		continueButton.click();
	}
}
