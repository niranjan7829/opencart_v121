package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.HomePage;
import pageObject.LoginPage;
import pageObject.MyAccountPage;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass {
	
	@Test(groups= {"Regression","Master"})
	public void LoginVerify() {
		
		try {
		logger.info("****** Startign TC_002_LoginTest *****");
		
		logger.info("launched application");
		HomePage home=new HomePage(driver);
		home.clickMyAccount();
		logger.info("Clicked on my account");
		home.clickLogin();
		logger.info("Clicked on Login");
		
		
		
		logger.info("Page loaded succesfully");
		
		
		LoginPage login=new LoginPage(driver);
		login.setEmail(p.getProperty("un"));
		login.setPassword(p.getProperty("password"));
		login.clickLogin();
		logger.info("Logged in succesfully");
		
		
		
		MyAccountPage page=new MyAccountPage(driver);
		boolean targetPage = page.isMyAccountPageExists();//return value and store it
		Assert.assertEquals(targetPage, true,"Login failed");
			
		
		page.clickLogout();
		logger.info("****** Startign TC_002_LoginTest *****");
	}
		
		
	catch(Exception e) {
		
		Assert.fail("Test failed: ");
	}
	

}}
