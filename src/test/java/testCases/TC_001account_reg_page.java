package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.AccountRegistrationPage;
import pageObject.HomePage;
import testBase.BaseClass;

public class TC_001account_reg_page extends BaseClass {
	
	

	@Test(groups= {"Sanity","Master"})
public void account_regirstationpage() {
	try{
	logger.info("launched application");
		HomePage home=new HomePage(driver);
		home.clickMyAccount();
		logger.info("Clicked on my account");
		home.clickRegister();
		logger.info("Clicked on Register");
		
		AccountRegistrationPage regpage=new AccountRegistrationPage(driver);
		regpage.setFirstName(randomeString().toUpperCase());
		regpage.setLastName(randomeString().toUpperCase());
		regpage.setEmail(randomeString()+"@gmail.com");// randomly generated the email
		
		
		regpage.setTelephone(randomeNumber());
		
		String password=randomeAlphaNumberic();
		regpage.setPassword(password);
		regpage.setConfirmPassword(password);
		
		regpage.setPrivacyPolicy();
		regpage.clickContinue();
		logger.info("Succesfully entered details");
		String confmsg = regpage.getConfirmationMsg();
		
		if (confmsg.equals("Your Account Has Been Created!")) {
			
			Assert.assertTrue(true);
		}
		else {
			logger.error("Test failed: ");
			logger.debug("Test failed: ");
			Assert.assertTrue(false);
		}
		
		
		logger.info("Account created and messgae is validated");
	}	
	
	catch (Exception e)
	{
		
		Assert.fail("Test failed: " + e.getMessage());
	} 
}
	

}
