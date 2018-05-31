package com.xero.automation.xero;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;


public class AddAccount_Test {

	 WebDriver driver;
	
/**	This method is to open firefox browser with Xero NZ website **/
/*	@Test(priority=0)
	public void openfirefox() {
		System.setProperty("webdriver.gecko.driver", "C:\\drivers\\geckodriver-v0.20.0-win64\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("http://www.xero.com");
		driver.manage().window().maximize();
	}
*/	
	
/** This method is to open chrome browser with Xero NZ website **/
	@Test(priority=0)
	public void openchrome() {
		System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://www.xero.com");
		driver.manage().window().maximize();
	}
	
/**	This method is to navigate to Login page from Home url **/
	@Test(priority=1)
	public void getLoginPage() {
		Home_Page objHome = new Home_Page(driver);
		objHome.LoginButton();
	}
	
/**	This method is to Log-in into Xero website **/	
	@Test(priority=2)
	public void LogInto() {
		Login_Page objLogin = new Login_Page(driver);
		objLogin.Username("suraj8056@gmail.com");
		objLogin.Password("Kiwi2012");
		objLogin.Submit();
	}

/**	This method is to Select ANZ bank Account into Xero account 
 * @throws Throwable 	**/
	@Test(priority=3)
	public void AddAcc() throws Throwable {
		Accounts_Page objAccount = new Accounts_Page(driver);
		objAccount.Accounts();
		objAccount.BankAccount();
		objAccount.AddAccount();
		objAccount.SearchBank("ANZ");
		objAccount.SelectBank("ANZ (NZ)");
	}
	
/**	This method is to enter account details of new account to be added 
 * @throws Throwable **/
	@Test(priority=4)
	public void AccDetails() throws Throwable {
		AccountDetails_Page objAccDetails = new AccountDetails_Page(driver);
		objAccDetails.SetAccountName("Business Account X");
		objAccDetails.SetAccountType("Everyday (day-to-day)");
		objAccDetails.AccountNumber("3333 5555 4444 1111");
		objAccDetails.FinaliseDetails();
		objAccDetails.verfiyAccountCreation();
	}
	
/**	This method is to logout from Xero account and quit the browser **/
	@Test(priority=5)
	public void Logout() {
		Logout_Page objLogout = new Logout_Page(driver);
		objLogout.UserAccount();
		objLogout.Logout();
		objLogout.CloseBrowser();
	}
	
}
