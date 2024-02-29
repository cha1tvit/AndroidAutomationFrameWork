package helpers.drivers;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.WebElement;

import java.net.MalformedURLException;
import java.net.URL;

public class UiAutomator2Helper {

    public AndroidDriver getDriver() {
        AndroidDriver driver = null;
        try {
            driver = new AndroidDriver(
                    new URL("http://127.0.0.1:4723"), getUiAutomator2Options());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        return driver;
    }

    public UiAutomator2Options getUiAutomator2Options()
    {
        UiAutomator2Options options = new UiAutomator2Options()
                .setApp("C:\\Users\\artur\\IdeaProjects\\AndroidAutomationFrameWork\\src\\main\\resources\\app\\appiumChallenge.apk");
        return options;
    }

    public void init()
    {
        try {
            WebElement el = getDriver().findElement(AppiumBy.xpath( "//Button"));
            el.click();
            getDriver().getPageSource();
        } finally {
            getDriver().quit();
        }
    }
}
