package locators;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginLocators {
    @AndroidFindBy(xpath="//android.widget.TextView[@text=\"LOG IN\"]")
    public static WebElement actionBar;

    // navigation
    public static By logInButton = AppiumBy.xpath( "//android.widget.TextView[@text=\"LOG IN\"]");
    public static By backButton = AppiumBy.xpath( "//android.widget.TextView[@text=\"Back\"]");
    // login form
    public static By username = AppiumBy.accessibilityId( "username");
    public static By password = AppiumBy.accessibilityId( "password");
    // Notifications && validation
    public static By notificationPanel = AppiumBy.id( "android:id/parentPanel");
    public static By message = AppiumBy.id( "android:id/message");
    public static By submitMessageButton = AppiumBy.className( "android.widget.Button");
}
