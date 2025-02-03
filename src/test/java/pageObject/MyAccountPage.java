package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage {
	
public MyAccountPage(WebDriver driver){
		
		super(driver);
	}

@FindBy(xpath="//h2[normalize-space()='My Account']")
WebElement msgHeading;

@FindBy(xpath = "//div[@class='list-group']//a[text()='Logout']")   //added in step6
WebElement lnkLogout;


//msg is displayed or npot
public boolean isMyAccountPageExists() {
	
	try {	
	return(msgHeading.isDisplayed());
	}
	
	catch(Exception e) {
		
		return false;
	}
}


public void clickLogout()
{
	lnkLogout.click();
}
	

}
