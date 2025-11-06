package com.qa.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPage {
	
	   // Declare WebDriver
	private WebDriver driver;
          
// Constructor to initialize driver and elements
public ProductPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
	
//Declare elements

@FindBy(xpath= "//select[@data-test='product-sort-container']")
private WebElement filter_dropdown;

@FindBy(xpath = "(//a[@id and contains(@id,'title_link')])[1]")
private WebElement firstProduct;



@FindBy(xpath ="//div[@data-test='inventory-item-name'] ")    //getting product details 
private WebElement productDetailTitle;

@FindBy(id = "add-to-cart")
private WebElement addtocart_btn;

@FindBy(id = "continue-shopping")
private WebElement continueshopping_btn;

@FindBy(xpath = "//a[@data-test='shopping-cart-link']")
private WebElement addtocart_link;

@FindBy(xpath= "//button[text()='OK']")
private WebElement ok_button_locator ;
//Page actions

public void productfilter_click() {
	filter_dropdown.click();
}

public void selectfilter(String dropdown)
{
	Select select = new Select(filter_dropdown);
	select.selectByVisibleText(dropdown);		
}


public void product_click()
{	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Use a reasonable wait time
wait.until(ExpectedConditions.visibilityOf(firstProduct));
	firstProduct.click();
}


public void add_to_cart_click()
{
	addtocart_btn.click();
}



public void alert_click() {
 try {
     // 1. Try to find and click the 'OK' button immediately (short wait)
     // We use a short, explicit wait to see if the element is present.
     WebDriverWait shortWait = new WebDriverWait(driver, Duration.ofSeconds(3)); 
     
     shortWait.until(
         ExpectedConditions.elementToBeClickable(ok_button_locator)
     ).click();
     
     System.out.println("Successfully clicked 'OK' button to dismiss pop-up.");

 } catch (Exception e) {
     // If the 'OK' button is not found within 3 seconds (TimeoutException), 
     // it means the pop-up likely didn't appear or the locator is wrong.
     
     System.out.println("Pop-up 'OK' button not found or clicked. Falling back to ESCAPE key.");
     
     // 2. FALLBACK: Use the ESCAPE key method
     try {
         driver.findElement(By.tagName("body")).sendKeys(Keys.ESCAPE);
         System.out.println("Attempted to dismiss pop-up with ESCAPE key.");
     } catch (Exception ex) {
         // Final fallback: nothing worked, continue test
         System.err.println("Failed to dismiss pop-up via click or ESCAPE: " + ex.getMessage());
     }
 }
}

public void add_to_cart_icon()
{
addtocart_link.click();
} 

public boolean isproductdetaildisplayed()
{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	    wait.until(ExpectedConditions.visibilityOf(productDetailTitle));
	    return productDetailTitle.isDisplayed();	
}
}