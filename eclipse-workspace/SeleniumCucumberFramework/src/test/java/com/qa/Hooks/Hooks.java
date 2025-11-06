package com.qa.Hooks;

import com.qa.base.BaseClass;
import io.cucumber.java.Before;
import io.cucumber.java.After;

public class Hooks {

    @Before
    public void setUp() {
        BaseClass.initializeDriver();  // ✅ creates ChromeDriver
        System.out.println("Browser launched before scenario");
    }

    @After
    public void tearDown() {
        BaseClass.quitDriver();        // ✅ closes ChromeDriver
        System.out.println("Browser closed after scenario");
    }
}
