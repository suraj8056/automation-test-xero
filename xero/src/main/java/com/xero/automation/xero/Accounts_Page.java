package com.xero.automation.xero;

import static org.testng.Assert.assertEquals;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.Assertion;
import org.testng.collections.Lists;

public class Accounts_Page {
	
	WebDriver driver;
	WebDriverWait wait;
	
	private By linkAccounts = By.xpath("//a[@id='Accounts']");
	private By linkBankAccounts = By.xpath("//a[@href='/Bank/BankAccounts.aspx']");
	private By buttonAddAccount = By.xpath("//a[@href='/Banking/Account/#find']");
	private By eleSearchBank = By.xpath("//input[@id='xui-searchfield-1018-inputEl']");
//	private By eleSearchResult = By.xpath("//li[@class = 'ba-banklist--item xui-contentblock--item' and @data-recordindex='0']"); 
	private By elebanklist = By.id("dataview-1025");
	
	
	public Accounts_Page(WebDriver driver) {
		this.driver = driver;
	}
	
	public void waitforelement(By e) {
		wait = new WebDriverWait(driver,5000);
		wait.until(ExpectedConditions.elementToBeClickable(e));
	}
	
	public void waitforelementvisible(By e) {
		wait = new WebDriverWait(driver,5000);
		wait.until(ExpectedConditions.presenceOfElementLocated((e)));
	}
	
	public void Accounts() {
		driver.findElement(linkAccounts).click();
		}
	
	public void BankAccount() {
		driver.findElement(linkBankAccounts).click();
		waitforelement(buttonAddAccount);
	}
	
	public void AddAccount() {
		driver.findElement(buttonAddAccount).click();
		waitforelement(eleSearchBank);
	}
	
	public void SearchBank(String BankName) throws Throwable {
		driver.findElement(eleSearchBank).sendKeys(BankName);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
		
	public void SelectBank(String BankName) {	
		WebElement dropdown = driver.findElement(elebanklist);
		List<WebElement> item = dropdown.findElements(By.tagName("li"));
		for (WebElement option : item)
		{
		    if (option.getText().equals(BankName))
		    {
		    	option.click();
		        break;
		    }
		}

/**		Another option to search specific bank name from dropdown    **/	
/*		WebElement item = driver.findElement(By.xpath("//ul[@id = 'dataview-1025']/descendant::li[text() = '" + BankName + "']"));
		item.click();
*/		
	}
}