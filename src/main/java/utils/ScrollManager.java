package utils;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;

public class ScrollManager {
    AndroidDriver driver;

    public ScrollManager(AndroidDriver driver) {
        this.driver = driver;
    }

    public void scrollToText(String text) {
        driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0))." +
                "scrollIntoView(new UiSelector().textMatches(\"" + text + "\").instance(0))")).click();
    }
}

//This is used to call the scroll method anywhere in the future when needed.
