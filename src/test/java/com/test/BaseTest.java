package com.test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    public static AndroidDriver capabilities(String appName) throws IOException {

        FileInputStream configProp = new FileInputStream(System.getProperty("user.dir") + "/resources/properties/configuration.properties");
        Properties properties = new Properties();
        properties.load(configProp);

        File appDir = new File((String) properties.get(appName));
//        File appDir = new File("resources/apps/General-Store.apk");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        String device = (String) properties.get("deviceName");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, device);
//        capabilities.setCapability("app", System.getProperty("user.dir")+"/resources/apps/General-Store.apk");
//		capabilities.setCapability(MobileCapabilityType.APP, appDir.getAbsolutePath());
        capabilities.setCapability(MobileCapabilityType.APP, "resources/apps/" + appDir);
//        capabilities.setCapability("chromedriverExecutable", "C:\\Users\\Oluwafemi.Adeoye\\Downloads\\Compressed\\chromedriver_win32_2\\chromedriver.exe");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "60");
        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

        return driver;
    }
}