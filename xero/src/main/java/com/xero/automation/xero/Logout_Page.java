package com.xero.automation.xero;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Logout_Page {

	WebDriver driver;
	WebDriverWait wait;
	
	
	private By eleUsernameArrow = By.xpath("//a[@class='username']");
	private By linkLogout = By.xpath("//a[@data-js='logout']");
	
	
	public Logout_Page(WebDriver driver) {
		this.driver = driver;
	}
	
	public void waitforwebelement(By e) {
		wait = new WebDriverWait(driver,5000);
		wait.until(ExpectedConditions.elementToBeClickable(e));
	}
	
	public void UserAccount() {
		driver.findElement(eleUsernameArrow).click();
		}
	
	public void Logout() {
		driver.findElement(linkLogout).click();
	}
	
	public void CloseBrowser() {
		driver.quit();
	}
}
