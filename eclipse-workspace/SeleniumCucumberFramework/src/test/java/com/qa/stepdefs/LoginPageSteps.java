package com.qa.stepdefs;

import com.qa.base.BaseClass;
import com.qa.pages.LoginPage;
import io.cucumber.java.en.*;
import org.testng.Assert;

public class LoginPageSteps {
    LoginPage login;

    @Given("User login page is displayed")
    public void user_on_loginpage() {
        BaseClass.driver.get("https://www.saucedemo.com/");
        login = new LoginPage(BaseClass.driver);
        
    }

    @When("User enters {string} as username")
    public void user_enters_username(String username) {
        login.enterusername(username);
    }

    @And("User enters {string} as password")
    public void user_enters_password(String password) {
        login.enterpassword(password);
    }

    @And("User clicks Login button")
    public void user_clicks_login_button() {
        login.click_loginbtn();
    }

    @Then("User able to view home page")
    public void user_on_homepage() {
        Assert.assertTrue(login.isHomePageDisplayed());
    }
}
