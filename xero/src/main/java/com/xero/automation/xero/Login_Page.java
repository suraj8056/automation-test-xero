package com.xero.automation.xero;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Login_Page {

	WebDriver driver;
	WebDriverWait wait;
	
	private By eleEmail = By.xpath("//input[@id='email']");
	private By elepassword = By.xpath("//input[@id='password']");
	private By buttonLogin = By.xpath("//button[@id='submitButton']");
	private By linkDashboard = By.xpath("//a[@id='Dashboard']");
	
	public Login_Page(WebDriver driver) {
		this.driver = driver;
	}
	
	public void waitforelement(By e) {
		wait = new WebDriverWait(driver,5000);
		wait.until(ExpectedConditions.elementToBeClickable(e));
	}
		
	public void Username(String Username) {
		driver.findElement(eleEmail).sendKeys(Username);
	}
	
	public void Password(String Password) {
		driver.findElement(elepassword).sendKeys(Password);
	}
	
	public void Submit() {
		driver.findElement(buttonLogin).click();
		waitforelement(linkDashboard);
	}
	
}
