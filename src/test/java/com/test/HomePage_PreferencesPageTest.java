package com.test;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.PreferencesPage;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class HomePage_PreferencesPageTest extends BaseTest {

    @Test
    public void anotherApp() throws IOException {
        // TODO Auto-generated method stub

        AndroidDriver driver = capabilities("ApiDemos-debug");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


        //xpath id classname, androidUIautomator are locators in appium
		/* xpath syntax
		  //tagname[attribute='value']
				 */
        HomePage h = new HomePage(driver);
        //driver.findElementByXPath("//android.widget.TextView[@text='Preference']").click();
        //call methods/variables of the class with class object
        h.Preferences.click();

        PreferencesPage p = new PreferencesPage(driver);
        //driver.findElementByXPath("//android.widget.TextView[@text='3. Preference dependencies']").click();
        p.dependencies.click();
        driver.findElement(By.id("android:id/checkbox")).click();

        /*This line of code
         * is used to define
         * which attribute
         * to click when
         * there is no
         * unique
         * index.*/
        driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();
        driver.findElement(By.className("android.widget.EditText")).sendKeys("AppiumWiFi");
        /* Locates
         * element
         * by
         *  index 0
         *  or
         *  1*/
        p.anythinggoes.get(1).click();
        //driver.findElementsByClassName("android.widget.Button").get(1).click();

    }

}
/* the below code is used when you have the app already installed on your device and do not have the .apk file.
 * This help you launch the app from your device without having to install or downloading .apk file.
 * 
 * File f=new File("src");
		
DesiredCapabilities cap=new DesiredCapabilities();
cap.setCapability(MobileCapabilityType.DEVICE_NAME, "NMAE OF YOUR DEVICE");
cap.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "duration of time goes here");
cap.setCapability(MobileCapabilityType.APP_PACKAGE, "Package name goes here");
cap.setCapability(MobileCapabilityType.APP_ACTIVITY, "Activity name goes here");

AndroidDriver<AndroidElement> driver=new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"),cap);
return driver;
 */