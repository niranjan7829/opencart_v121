package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObject.HomePage;
import pageObject.LoginPage;
import pageObject.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC_003_Login_DataVerify extends BaseClass {

	
	@Test(dataProvider = "LoginData",dataProviderClass = DataProviders.class,groups= "Datadriven")
	public void LoginVerify(String username,String password,String exp) throws InterruptedException {
		
	
		logger.info("****** Starting TC_003_LoginTest *****");
		
		try {
		logger.info("launched application");
		HomePage home=new HomePage(driver);
		home.clickMyAccount();
		logger.info("Clicked on my account");
		home.clickLogin();
		logger.info("Clicked on Login");
		
		
		
		logger.info("Page loaded succesfully");
		
		
		LoginPage login=new LoginPage(driver);
		login.setEmail(username);
		login.setPassword(password);
		login.clickLogin();
		logger.info("Logged in succesfully");
		
		
		
		MyAccountPage page=new MyAccountPage(driver);
		boolean targetPage = page.isMyAccountPageExists();//return value and store it
		
		/*Data is valid  - login success - test pass  - logout
			login failed - test fail

Data is invalid - login success - test fail  - logout
			login failed - test pass
*/
		
		//valid data 
		if(exp.equalsIgnoreCase("Valid"))
		{
			if(targetPage==true)
			{			
				page.clickLogout();
				Assert.assertTrue(true);
				
			}
			else
			{
				Assert.assertTrue(false);
			}
		}
		
		if(exp.equalsIgnoreCase("Invalid"))
		{
			if(targetPage==true)
			{
				page.clickLogout();
				Assert.assertTrue(false);
				
			}
			else
			{
				Assert.assertTrue(true);
			}
		}
		
		}catch(Exception e)
		{
			Assert.fail();
		}
		Thread.sleep(3000);
		logger.info("***** Finished TC_003_LoginDDT ******");
		
		
	}}
