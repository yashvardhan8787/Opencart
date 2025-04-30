package pageObjects;

import org.apache.commons.text.RandomStringGenerator;
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
	
	
	
	// ✅ Generate random alphabetic first name (5 to 8 characters)
	public String generateRandomFirstName() {
		RandomStringGenerator generator = new RandomStringGenerator.Builder()
			.withinRange('a', 'z')
			.build();
		return capitalize(generator.generate(5 + (int)(Math.random() * 4)));  // length 5–8
	}

	// ✅ Generate random alphabetic last name (5 to 10 characters)
	public String generateRandomLastName() {
		RandomStringGenerator generator = new RandomStringGenerator.Builder()
			.withinRange('a', 'z')
			.build();
		return capitalize(generator.generate(5 + (int)(Math.random() * 6))); // length 5–10
	}

	// ✅ Generate random email (6-letter prefix + @ + 4-letter domain)
	public String generateRandomEmail() {
		RandomStringGenerator prefixGen = new RandomStringGenerator.Builder()
			.withinRange('a', 'z')
			.build();
		RandomStringGenerator domainGen = new RandomStringGenerator.Builder()
			.withinRange('a', 'z')
			.build();
		String prefix = prefixGen.generate(6).toLowerCase();
		String domain = domainGen.generate(4).toLowerCase();
		return prefix + "@" + domain + ".com";
	}

	// ✅ Generate random 10-digit phone number
	public String generateRandomTelephone() {
		RandomStringGenerator generator = new RandomStringGenerator.Builder()
			.withinRange('0', '9')
			.build();
		return generator.generate(10);
	}

	// ✅ Generate strong password: 6 alphanumerics + 1 symbol + 2 digits
	public String generateRandomPassword() {
		RandomStringGenerator alphaGen = new RandomStringGenerator.Builder()
			.withinRange(33,126)
			.filteredBy(Character::isLetterOrDigit)
			.build();
		RandomStringGenerator digitGen = new RandomStringGenerator.Builder()
			.withinRange('0', '9')
			.build();
		String part1 = alphaGen.generate(6);
		String symbol = "@";
		String part2 = digitGen.generate(2);
		return part1 + symbol + part2;
	}

	// ✅ Capitalize first letter
	private String capitalize(String str) {
		if (str == null || str.isEmpty()) return str;
		return str.substring(0, 1).toUpperCase() + str.substring(1);
	}

    
}
