package locators;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginLocators {
    // navigation
    public static By logInButton = AppiumBy.xpath( "//android.widget.TextView[@text=\"LOG IN\"]");
    public static By backButton = AppiumBy.xpath( "//android.widget.TextView[@text=\"Back\"]");
    // login form
    public static By username = AppiumBy.accessibilityId( "username");
    public static By password = AppiumBy.accessibilityId( "password");

    // Notifications && validation
    public static By messageFrame = AppiumBy.xpath( "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]");
    public static By notificationPanel = AppiumBy.id( "android:id/parentPanel");
    public static By message = AppiumBy.id( "android:id/message");
    public static By submitMessageButton = AppiumBy.xpath( "//android.widget.Button[@resource-id=\"android:id/button1\"]");
}
