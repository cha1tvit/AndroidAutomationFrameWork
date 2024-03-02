package helpers.drivers;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import lombok.extern.log4j.Log4j2;

import java.net.MalformedURLException;
import java.net.URL;

@Log4j2
public class UiAutomator2Helper {

    public AndroidDriver getDriver(String host, UiAutomator2Options options) {
        AndroidDriver driver = null;
        try {
            driver = new AndroidDriver(
                    new URL(host), options);
            log.info(String.format("DRIVER: %S has been initialized", driver.getCapabilities()));
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        return driver;
    }

    public UiAutomator2Options getUiAutomator2Options(String pathToApk)
    {
        UiAutomator2Options options = new UiAutomator2Options()
                .setApp(pathToApk);
        log.info(String.format("OPTIONS FOR DRIVER: %S were initialized", options.asMap()));
        return options;
    }
}
