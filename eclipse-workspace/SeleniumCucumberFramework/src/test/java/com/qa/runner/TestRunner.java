package com.qa.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
    features = "src/test/resources/features/",  // Path to your .feature files
    glue = {"com.qa.stepdefs", "com.qa.Hooks"},                    // Step definition package
    plugin = {
        "pretty",                                  // Prints steps in readable format
        "html:target/cucumber-reports.html",       // HTML report
        "json:target/cucumber.json"              // JSON report
         // Optional Extent report
    },
    monochrome = true,                             // Better console readability
    dryRun = false                               // To check mapping without running browser
//    tags = "@smoke"                                // Run specific tag (optional)
)
public class TestRunner extends AbstractTestNGCucumberTests {
}
