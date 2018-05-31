package com.xero.automation.xero;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Home_Page {

	WebDriver driver;
	WebDriverWait wait;
	
	private By buttonLogin = By.xpath("//a[@href='https://login.xero.com/']");
	private By eleEmail = By.xpath("//input[@id='email']");

	public Home_Page(WebDriver driver) {
		this.driver = driver;
	}
	
	public void waitforelement(By e) {
		wait = new WebDriverWait(driver,5000);
		wait.until(ExpectedConditions.elementToBeClickable(e));
	}
	
	public void LoginButton() {
		driver.findElement(buttonLogin).click();
		waitforelement(eleEmail);
	}
}
