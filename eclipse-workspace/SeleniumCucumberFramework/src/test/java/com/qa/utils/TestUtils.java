package com.qa.utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class TestUtils {

    public static void captureScreenshot(WebDriver driver, String screenshotName) {
        try {
            String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            
            String destPath = System.getProperty("user.dir") + "/test-output/screenshots/";
            File destDir = new File(destPath);
            if (!destDir.exists()) {
                destDir.mkdirs();
            }

            File destFile = new File(destDir, screenshotName + "_" + timestamp + ".png");
            FileUtils.copyFile(srcFile, destFile);
        } catch (IOException e) {
            System.out.println("❌ Unable to capture screenshot: " + e.getMessage());
        }
    }
}
