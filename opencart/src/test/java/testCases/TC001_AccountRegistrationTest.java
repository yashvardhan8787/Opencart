package testCases;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseTest;
public class TC001_AccountRegistrationTest extends BaseTest {
	
	@Test
	public void  userRegistrationTest() {
		AccountRegistrationPage rp = new AccountRegistrationPage(driver);
		HomePage hp = new  HomePage(driver);
		hp.clickMyAccount();
		hp.clickRgesitrationLink();
		rp.enterFirstName("Yash");
		rp.enterLastName("Singh");
		rp.enterEmail("yashSigh@gmail.com");
		rp.enterTelephone("8787021710");
		rp.enterPassword("yash1234");
		rp.enterConfirmPassword("yash1234");
		rp.clickRegistrationContinueBtn();
	}
   
}
