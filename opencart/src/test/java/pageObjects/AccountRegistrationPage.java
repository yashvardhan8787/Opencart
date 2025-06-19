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
    WebElement radioBtnNewsletterYes;

    @FindBy(xpath = "//label[text()='No']//input[@name='newsletter']")
    WebElement radioBtnNewsletterNo;

    @FindBy(xpath = "//input[@name='agree']")
    WebElement policyCheckBox;

    @FindBy(xpath = "//input[@value='Continue']")
    WebElement continueButton;

    public String getContentHeading() {
        return getTextSafely(txtHeading);
    }

    public void enterFirstName(String firstname) {
        txtFirstName.sendKeys(firstname);
    }

    public void enterLastName(String lastname) {
        txtLastName.sendKeys(lastname);
    }

    public void enterEmail(String email) {
        txtEmail.sendKeys(email);
    }

    public void enterTelephone(String phone) {
        txtTelephone.sendKeys(phone);
    }

    public void enterPassword(String password) {
        txtPassword.sendKeys(password);
    }

    public void enterConfirmPassword(String password) {
        txtConfirmPassword.sendKeys(password);
    }

    public void clickNewsletterYes() {
        radioBtnNewsletterYes.click();
    }

    public void clickNewsletterNo() {
        radioBtnNewsletterNo.click();
    }

    public void checkPrivacyPolicy() {
        policyCheckBox.click();
    }

    public void clickContinue() {
        continueButton.click();
    }

    public String generateRandomFirstName() {
        return generateRandomString(5, 8, true);
    }

    public String generateRandomLastName() {
        return generateRandomString(5, 10, true);
    }

    public String generateRandomEmail() {
        return generateRandomString(6, 6, false) + "@" + generateRandomString(4, 4, false) + ".com";
    }

    public String generateRandomTelephone() {
        return generateRandomString(10, 10, false);
    }

    public String generateRandomPassword() {
        return generateRandomString(6, 6, false) + "@" + generateRandomString(2, 2, false);
    }

    private String generateRandomString(int minLength, int maxLength, boolean capitalize) {
        RandomStringGenerator generator = new RandomStringGenerator.Builder()
                .withinRange('a', 'z')
                .build();
        String result = generator.generate(minLength + (int) (Math.random() * (maxLength - minLength + 1)));
        return capitalize ? capitalizeFirstLetter(result) : result;
    }

    private String getTextSafely(WebElement element) {
        try {
            return element.getText();
        } catch (Exception e) {
            return "";
        }
    }

    private String capitalizeFirstLetter(String str) {
        return str == null || str.isEmpty() ? str : str.substring(0, 1).toUpperCase() + str.substring(1);
    }
}