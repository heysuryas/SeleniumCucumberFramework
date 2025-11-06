package com.qa.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	
	   // Declare WebDriver
	private WebDriver driver;
          
          
// Constructor to initialize driver and elements
public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
	
//Declare elements

@FindBy(id = "user-name")
private WebElement username;

@FindBy(id = "password")
private WebElement password;


@FindBy(xpath = "//input[@id='login-button']")
private WebElement loginbtn;

@FindBy(xpath = "//span[@data-test='title']")
private WebElement productlabel;

@FindBy(xpath = "//div//h3[@data-test='error']")
private WebElement errormsg;



//Page actions

public void enterusername(String Username)
{
	username.clear();
	username.sendKeys(Username);	
}

public void enterpassword(String Password)
{
	password.clear();
	password.sendKeys(Password);	
}

public void click_loginbtn()
{
	loginbtn.click();
}


public boolean isHomePageDisplayed()
{
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    wait.until(ExpectedConditions.visibilityOf(productlabel));
    return productlabel.isDisplayed();
}


public String errormsgdisplayed()
{
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    wait.until(ExpectedConditions.visibilityOf(errormsg));
    return errormsg.getText();
   
}



}