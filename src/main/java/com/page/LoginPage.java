package com.page;

import java.util.logging.Logger;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.testBase.TestBase;


public class LoginPage extends TestBase{
	

	
	public static final Logger logger=Logger.getLogger(LoginPage.class.getName());
	
	@FindBy(id="txtUsername")
	WebElement adminUserName;
	
	@FindBy(id="txtPassword")
	WebElement adminPass;
	
	@FindBy(id="btnLogin")
	WebElement btnLogin;
	
	@FindBy(id = "menu_dashboard_index")
	WebElement dashAssert;
	

	
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	public AdduserPage loginOperation (String DynamicUserName,String DynamicadminPass) throws InterruptedException {
		Thread.sleep(1500);
		adminUserName.sendKeys(DynamicUserName);
		logger.info("Added User Name is -->"+adminUserName);
		adminPass.sendKeys(DynamicadminPass);
		Thread.sleep(1000);
		logger.info("Added password is -->"+adminPass);
		btnLogin.click();
		Thread.sleep(1500);
		//Assert.assertEquals(actual, expected);
		if(dashAssert.isDisplayed())
		{
			logger.info("login sucess");
		}
		logger.info("Admin login is success...");
		Thread.sleep(5000);
	
		
		return new AdduserPage();
	}
}
