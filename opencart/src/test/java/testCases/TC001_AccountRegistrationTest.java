package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import pageObjects.RegistrationSuccessPage;
import testBase.BaseTest;

public class TC001_AccountRegistrationTest extends BaseTest {

    @Test
    public void verifyUserCanRegisterSuccessfully() {
        logger.info("************************** TC001 Test Start *******************************");
        try {

        HomePage hp = new HomePage(driver);

        hp.clickMyAccount();
        logger.info("Clicked on My Account");

        hp.clickRegistrationLink();
        logger.info("Clicked on Registration option");

        AccountRegistrationPage regPage = new AccountRegistrationPage(driver);

        String firstName = regPage.generateRandomFirstName();
        String lastName = regPage.generateRandomLastName();
        String email = regPage.generateRandomEmail();
        String phone = regPage.generateRandomTelephone();
        String password = regPage.generateRandomPassword();

        regPage.enterFirstName(firstName);
        logger.info("Entered First Name: " + firstName);

        regPage.enterLastName(lastName);
        logger.info("Entered Last Name: " + lastName);

        regPage.enterEmail(email);
        logger.info("Entered Email Address: " + email);

        regPage.enterTelephone(phone);
        logger.info("Entered Phone Number: " + phone);

        regPage.enterPassword(password);
        logger.info("Entered Password");

        regPage.enterConfirmPassword(password);
        logger.info("Entered Confirm Password");

        regPage.checkPrivacyPolicy();
        logger.info("Checked the privacy policy option");

        regPage.clickRegistrationContinueBtn();
        logger.info("Clicked on continue button");

        RegistrationSuccessPage successPage = new RegistrationSuccessPage(driver);

     
            Assert.assertEquals(successPage.regSuccessMsg(), "Your Account Has Been Created!", "Registration message mismatch!");
            logger.info("Registration successful!");
        } catch (AssertionError e) {
            logger.error("Assertion failed: " + e.getMessage());
            throw e;
        }

        logger.info("************************** Test Over *******************************");
    }
}
