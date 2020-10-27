package Appium.Appitumtest;

import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import org.testng.annotations.BeforeMethod;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;

public class Calculator {
	
	@Test
	public void calc() throws InterruptedException, IOException {
	   // Set the Desired Capabilities
	   DesiredCapabilities caps = new DesiredCapabilities();
	   caps.setCapability("deviceId", "-----");
	  // caps.setCapability("deviceName", "My Phone");
	   caps.setCapability("platformName", "android");
	   caps.setCapability("appPackage", "com.android.calculator2");
	   caps.setCapability("appActivity", "com.android.calculator2.Calculator");

	  // Instantiate Appium Driver
	   AppiumDriver<MobileElement> driver = null;
	   try {
	          // Initialize driver
	           driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
	           System.out.println("Calculator is open");
	        } catch (MalformedURLException e) {
	            System.out.println(e.getMessage());
	        }
	    }
	

}
