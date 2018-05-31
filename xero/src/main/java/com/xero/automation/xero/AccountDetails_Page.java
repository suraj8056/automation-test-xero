package com.xero.automation.xero;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccountDetails_Page {

	WebDriver driver;
	WebDriverWait wait;
	
	private By eleAccName = By.xpath("//input[@placeholder='e.g Business Account']");
	private By eleAccType = By.xpath("//input[@placeholder='Please select one']");
	private By bttnContinue = By.xpath("//span[@id='common-button-submit-1015-btnInnerEl']");
	private By eleAccNumber = By.xpath("//input[@id='accountnumber-1068-inputEl']");
	private By eleIcon = By.xpath("//div[@id='notify01']");
	private By eleAcc = By.xpath("//div[@class='bank']");
	
	public AccountDetails_Page(WebDriver driver) {
		this.driver = driver;
	}
	
	public void waitforelement(By e) {
		wait = new WebDriverWait(driver,5000);
		wait.until(ExpectedConditions.elementToBeClickable(e));
	}
	
	public void waitforelementvisible(By e) {
		wait = new WebDriverWait(driver,5000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(e));
	}
	
	
	public void SetAccountName(String AccName) {
		waitforelement(eleAccName);
		driver.findElement(eleAccName).sendKeys(AccName);
	}
	
	public void SetAccountType (String AccType) {
		driver.findElement(eleAccType).click();
		WebElement dropdown = driver.findElement(By.xpath("//ul[@data-ref='listEl']"));
		List<WebElement> item = dropdown.findElements(By.tagName("li"));
	    for (WebElement option : item)
	    {
	    	if (option.getText().equals(AccType))
	    	{
	    		option.click(); 		
	    		break;
	    	}
	    }
	}
	
	public void AccountNumber(String AccNumber) throws Throwable {
		waitforelementvisible(eleAccNumber);
		driver.findElement(eleAccNumber).sendKeys(AccNumber);
	}
	
	public void FinaliseDetails() {
		waitforelementvisible(bttnContinue);
		driver.findElement(bttnContinue).click();;
	}

	public void verfiyAccountCreation() {
		waitforelementvisible(eleAcc);
		if (driver.findElement(eleIcon).isDisplayed()){
			System.out.println("Account has been successfully created.");
		}
		else {
			System.out.println("Account creation has encoutered some problem.");
		}
		
	}

}
