package pageObjects;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class GeneralStorePage {
    @AndroidFindBy(id = "com.androidsample.generalstore:id/spinnerCountry")
    private WebElement countrySelect;
    @AndroidFindBy(id = "com.androidsample.generalstore:id/nameField")
    private WebElement nameField;
    @AndroidFindBy(xpath = "//android.widget.RadioButton[@text='Female']")
    private WebElement selectGender;
    @AndroidFindBy(id = "com.androidsample.generalstore:id/btnLetsShop")
    private WebElement letsShopBttn;

    public GeneralStorePage(AndroidDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public WebElement getName() {
        nameField.sendKeys("Olumide");
//        System.out.println("Passing name into " + nameField.getText());
//        Assert.assertNotNull(nameField.getText(), String.valueOf(true));
        return nameField;
    }

    public WebElement selectGender() {
        selectGender.click();
        System.out.println(selectGender.isSelected() + "gender selected");
        return selectGender;
    }

    public WebElement goShopping() {
        letsShopBttn.click();
        System.out.println("Lets go shopping...");
        return letsShopBttn;
    }

    public WebElement chooseCountry() {
        countrySelect.click();
//        System.out.println("Selecting a country" + chooseCountry().isSelected());
        return countrySelect;
    }
}
