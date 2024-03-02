package locators;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

public class SampleListLocators {
    // Navigation
    public static By samplesListHeader = AppiumBy.xpath( "//android.widget.TextView[@text=\"Samples List\"]");
    public static By backButton = AppiumBy.xpath( "//android.widget.TextView[@text=\"Back\"]");

    // Menu
    public static By nativeViewBlock = AppiumBy.xpath("//android.view.View[@content-desc=\"chainedView\"]");
    public static By sliderBlock = AppiumBy.xpath("//android.view.View[@content-desc=\"slider1\"]");
    public static By verticalSwipingBlock = AppiumBy.xpath("//android.view.View[@content-desc=\"verticalSwipe\"]");
    public static By dragAndDropBlock = AppiumBy.xpath("//android.view.View[@content-desc=\"dragAndDrop\"]");
    public static By doubleTapBlock = AppiumBy.xpath("//android.view.View[@content-desc=\"doubleTap\"]");
    public static By longPressBlock = AppiumBy.xpath("//android.view.View[@content-desc=\"longPress\"]");
    public static By photoViewBlock = AppiumBy.xpath("//android.view.View[@content-desc=\"photoView\"]");
    public static By webViewBlock = AppiumBy.xpath("//android.view.View[@content-desc=\"webView\"]");
    public static By carouselBlock = AppiumBy.xpath("//android.view.View[@content-desc=\"carousel\"]");
    public static By wheelPickerBlock = AppiumBy.xpath("//android.view.View[@content-desc=\"wheelPicker\"]");
}
