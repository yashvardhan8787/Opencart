package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.MyAccountPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseTest;
import utilities.DataProviders;

public class TC002_AccountLoginTest extends BaseTest {
	
	
	//Test Steps 
	
	//Click MyAccount option act homepage (drop down will open)
	//Click Login option from DropDown (login page would be opened )
	//Enter Email 
	//Enter Password 
	//Click login button  if(valid Credentials MyAccountPage should be opened ) else Error message should be displayed 
	//if MyAccountPage is opened , click on MyAccount option 
	//again drop down will  open 
	//click on Logout (user will be able to log out "
	
	
	@Test(dataProvider="login_data" , dataProviderClass = DataProviders.class)//getting dataProvider class from different class
	public void verifyUserCanLoginSuccessfully(String email , String pwd , String exp) {
		logger.info("**************************TC002 Test Start *******************************");
		

	    try {
	        HomePage homePage = new HomePage(driver);
	        homePage.clickMyAccount();
	        logger.info("Clicked on MyAccount option on Home Page.");

	        homePage.clickLoginLink();
	        logger.info("Clicked on Login Link from MyAccount Dropdown.");

	        LoginPage loginPage = new LoginPage(driver);
	        loginPage.enterLoginUsername(email);
	        loginPage.enterLoginPassword(pwd);
	        loginPage.clickLoginButton();
	        logger.info("Clicked on Login button.");

	        MyAccountPage accountPage = new MyAccountPage(driver);
	        boolean isMyAccountDisplayed = accountPage.myAccountHeadingDisplayed();

	        if (exp.equalsIgnoreCase("valid")) {
	            Assert.assertTrue(isMyAccountDisplayed, "Expected successful login, but login failed.");
	            accountPage.clickOnMyAccountDropDown();
	            accountPage.clickOnLogout();
	        } else if (exp.equalsIgnoreCase("invalid")) {
	            Assert.assertFalse(isMyAccountDisplayed, "Expected login failure, but login succeeded.");
	        } else {
	            Assert.fail("Unexpected test data: exp = " + exp);
	        }

	    } catch (Exception e) {
	        logger.error("Test encountered an error: " + e.getMessage());
	        Assert.fail("Test failed due to exception: " + e.getMessage());
	    } finally {
	        logger.info("********** TC002 - Test Completed **********");
	    }		  
	} 

}
