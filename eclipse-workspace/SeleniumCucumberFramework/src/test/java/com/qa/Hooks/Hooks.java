package com.qa.Hooks;
import com.qa.base.BaseClass;
import io.cucumber.java.Before;
import io.cucumber.java.After;

public class Hooks {

    @Before
    public void setUp() {
        BaseClass.initDriver();
    }

    @After
    public void tearDown() {
        BaseClass.quitDriver();
    }
}
