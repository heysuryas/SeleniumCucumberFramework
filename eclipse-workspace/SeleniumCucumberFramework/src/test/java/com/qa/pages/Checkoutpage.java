package com.qa.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Checkoutpage {
	
	   // Declare WebDriver
	private WebDriver driver;
          
          
// Constructor to initialize driver and elements
public Checkoutpage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

//Declare elements

@FindBy(id = "checkout")
private WebElement checkoutbtn;

@FindBy(id="first-name")
private WebElement firstname;


@FindBy(id="last-name")
private WebElement lastname;

@FindBy(id="postal-code")
private WebElement postcode;

@FindBy(id="finish")
private WebElement finishbtn;

@FindBy(xpath="//h2[@data-test='complete-header']")
private WebElement orderconftxt;
	
@FindBy(id="continue")
private WebElement continuebtn;



public void checkout_click()
{
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); 
	wait.until(ExpectedConditions.visibilityOf(checkoutbtn));
	checkoutbtn.click();

}

public void enter_firstname(String Firstname ) {
	
		firstname.clear();
		firstname.sendKeys(Firstname);
}

public void enter_lastname(String Lastname ) {
	
	lastname.clear();
	lastname.sendKeys(Lastname);
}
public void enter_postcode(String Postcode) {
	
	postcode.clear();
	postcode.sendKeys(Postcode);
}

public void continue_click() {
	continuebtn.click();
	
}

public void finishbtn_click() {
	finishbtn.click();
	
}
public boolean ischeckoutmsgDisplayed()
{
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    wait.until(ExpectedConditions.visibilityOf(orderconftxt));
    return orderconftxt.isDisplayed();
}









}

	