package com.test;

import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.Test;
import pageObjects.GeneralStorePage;
import utils.ScrollManager;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class GeneralStorePageTest extends BaseTest {
    static AndroidDriver driver;

//	private static WebElement scrollToElementUsing_getChildBMobileText(String scrollableList, String uiSelector, String Text) {
//		WebElement element = driver.findElement(MobileBy.AndroidUIAutomator(
//				"new UiScrollable(new UiSelector().resourceId(\"" + scrollableList + "\")).getChildByText("
//				+ "new UiSelector().className(\"" + uiSelector + "\"), \"" + Text + "\")"));
//
//		return element;
//	}

    /*public static double getAmount(String value) {
        value = value.substring((1));
        double TotalValue = Double.parseDouble(value);
        return TotalValue;

    }
*/
    @Test
    public void shoppingDay() throws IOException {

        AndroidDriver driver = capabilities("General-Store");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        GeneralStorePage generalStorePage = new GeneralStorePage(driver);
        ScrollManager scrollManager = new ScrollManager(driver);

        generalStorePage.chooseCountry();
        scrollManager.scrollToText("Belarus");

        generalStorePage.getName();

        generalStorePage.selectGender();

        generalStorePage.goShopping();

        //select country
//        driver.findElement(By.id("com.androidsample.generalstore:id/spinnerCountry")).click();
//        driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Albania\"));")).click();

        //Alternative scrollToview
        // driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textMatches(\" Aruba  \").instance(0))").click();

        //provide your name
//        driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Hello");

        //hide keyboard
//        driver.hideKeyboard();

        //select gender
//        driver.findElement(By.xpath("//android.widget.RadioButton[@text='Female']")).click();

        //click let's shop
//        driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();

        //Select items
//	     WebElement element = scrollToElementUsing_getChildBMobileText("com.androidsample.generalstore:id/rvProductList", "android.widget.TextView", "Jordan Lift Off");
        /*driver.findElements(By.xpath("//*[@text='ADD TO CART']")).get(0).click();
        Thread.sleep(3000);
        driver.findElements(By.xpath("//*[@text='ADD TO CART']")).get(0).click();
        Thread.sleep(300);
        //Click cart
        driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
        Thread.sleep(5000);

        int count = driver.findElements(By.id("com.androidsample.generalstore:id/productPrice")).size();
        double sum = 0;
        for (int i = 0; i < count; i++) {
            String amount1 = driver.findElements(By.id("com.androidsample.generalstore:id/productPrice")).get(i).getText();
            double amount = getAmount(amount1);
            sum = sum + amount;
        }

        //print out sum of products
        System.out.println(sum + " sum of products");

        //Get total price for selected items
        String Total = driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();
        //removes $ sign from total
        Total = Total.substring(1);
        //convert total to double data type
        double TotalValue = Double.parseDouble(Total);
        //print out total value
        System.out.println(TotalValue + " total value of selected items");
        //Validate sum of products is equal to total value
        Assert.assertEquals(TotalValue, sum);
*/        //Mobile Gesture
	   /*WebElement checkbox = driver.findElement(By.className("android.widget.CheckBox"));
	   TouchAction t=new TouchAction(driver);
	   t.tap(tapOptions().withElement(element(checkbox))).perform();

	  WebElement tc = driver.findElement(By.xpath("//*[@text='Please read our terms of conditions']"));
	   t.longPress(longPressOptions().withElement(element(tc)).withDuration(ofSeconds(2))).release().perform();
	   driver.findElement(By.id("android:id/button1")).click();
	   driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();*/
    }
}