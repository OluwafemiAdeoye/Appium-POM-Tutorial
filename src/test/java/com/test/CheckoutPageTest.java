package com.test;

import io.appium.java_client.android.AndroidDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.CheckoutPage;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class CheckoutPageTest extends BaseTest {
    static AndroidDriver driver;

//	private static WebElement scrollToElementUsing_getChildBMobileText(String scrollableList, String uiSelector, String Text) {
//		WebElement element = driver.findElement(MobileBy.AndroidUIAutomator(
//				"new UiScrollable(new UiSelector().resourceId(\"" + scrollableList + "\")).getChildByText("
//				+ "new UiSelector().className(\"" + uiSelector + "\"), \"" + Text + "\")"));
//
//		return element;
//	}

    public static double getAmount(String value) {
        value = value.substring((1));
        double TotalValue = Double.parseDouble(value);
        return TotalValue;

    }

    @Test
    public void checkOut() throws IOException, InterruptedException {

        AndroidDriver driver = capabilities("General-Store");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        CheckoutPage checkoutPage = new CheckoutPage(driver);

        int count = checkoutPage.viewProductPrice().size();
        double sum = 0;
        for (int i = 0; i < count; i++) {
            String amount1 = checkoutPage.viewProductPrice().get(i).getText();
            double amount = getAmount(amount1);
            sum = sum + amount;
        }

        //print out sum of products
        System.out.println(sum + " sum of products");

        //Get total price for selected items
        String Total = String.valueOf(checkoutPage.getTotalAmount());
        //removes $ sign from total
        Total = Total.substring(1);
        //convert total to double data type
        double TotalValue = Double.parseDouble(Total);
        //print out total value
        System.out.println(TotalValue + " total value of selected items");
        //Validate sum of products is equal to total value
        Assert.assertEquals(TotalValue, sum);

    }
}