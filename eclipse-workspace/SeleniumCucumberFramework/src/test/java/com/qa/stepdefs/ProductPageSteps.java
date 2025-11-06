package com.qa.stepdefs;

import com.qa.base.BaseClass;
import com.qa.pages.LoginPage;
import com.qa.pages.ProductPage;
import com.qa.utils.TestUtils;

import io.cucumber.java.en.*;
import org.testng.Assert;

public class ProductPageSteps {
    ProductPage productpage;

    @Given("User homepage is displayed")
    public void user_on_productpage() {
    	productpage = new ProductPage(BaseClass.driver); 
    	String currentUrl = BaseClass.driver.getCurrentUrl();  // need to verify whether the page is as expected 
    	Assert.assertTrue(currentUrl.contains("inventory.html"), 
    	"User is not on the Products page! Current URL: " + currentUrl);
    	}   
   
    @When("User clicks product filter dropdown")
    public void user_clicks_filter() {
    productpage.alert_click();
    productpage.productfilter_click();
    }

    @When("User selects filter {string}")
    public void user_selects_filter(String filterOption) {
        productpage.selectfilter(filterOption);
    }

    
    @And("User clicks on first product")
    public void user_clicks_first_product() {
        productpage.product_click();
    }
    
    
    @And("User clicks on add to cart")
    public void user_clicks_addtocart() 
    {
        productpage.add_to_cart_click();
    }
    
    
    @And("User clicks on add to cart icon")
    public void user_clicks_addtocarticon() 
    {
    productpage.add_to_cart_icon();
    } 
    
    
    @Then("Product detail page is displayed")
    public void product_detail_page_displayed() {
        Assert.assertTrue(productpage.isproductdetaildisplayed());
    }

}


