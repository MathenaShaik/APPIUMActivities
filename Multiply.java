package Appium.Appitumtest;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Multiply {
    AppiumDriver<MobileElement> driver = null;
    
    @BeforeClass
    public void beforeClass() throws MalformedURLException {
        // Set the Desired Capabilities
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceId", "----");
        caps.setCapability("platformName", "android");
 	   	caps.setCapability("appPackage", "com.android.calculator2");
 	   	caps.setCapability("appActivity", "com.android.calculator2.Calculator");
 	   	caps.setCapability("noReset", true);

        // Instantiate Appium Driver
        URL appServer = new URL("http://0.0.0.0:4723/wd/hub");
        driver = new AndroidDriver<MobileElement>(appServer, caps);
    }

    @Test
    public void multiply() {
        driver.findElementById("digit_7").click();
        driver.findElementById("op_mul").click();
        driver.findElementById("digit_4").click();
        driver.findElementById("eq").click();
        
        //Display Result
        String result = driver.findElementById("result").getText();
        System.out.println(result);
        Assert.assertEquals(result, "28");
    }

    @Test
    public void takeScreenshot() throws Exception {
        String timeStamp;
        File screenShotName;

        //Take screenshot
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

        //This specifies the location the screenshot will be saved
        screenShotName = new File("src/test/resources/screenshot.jpg");
        
        //This will copy the screenshot to the file created
        FileUtils.copyFile(scrFile, screenShotName);

        //Set filepath for image
        String filePath = "../"+screenShotName.toString();
        System.out.println(filePath);
    }
    
    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}