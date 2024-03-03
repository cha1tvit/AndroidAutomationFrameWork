package helpers.drivers;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import lombok.extern.log4j.Log4j2;

import java.net.MalformedURLException;
import java.net.URL;

@Log4j2
public class UiAutomator2Helper {

    /**
     * @param host    String - appium host to connect
     * @param options UiAutomator2Options - driver input parameters
     * @return AndroidDriver - instance if initialized driver
     */
    public AndroidDriver initDriverInstance(String host, UiAutomator2Options options) {
        AndroidDriver driver;
        try {
            driver = new AndroidDriver(
                    new URL(host), options);
            log.info(String.format("DRIVER -------> %S has been initialized", driver.getCapabilities()));
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        return driver;
    }

    /**
     * @param pathToApk String - path to .apk file for application to test
     * @return UiAutomator2Options - params model of driver options
     */
    public UiAutomator2Options getUiAutomator2Options(String pathToApk) {
        try {
            UiAutomator2Options options = new UiAutomator2Options()
                    .setApp(pathToApk);
            log.info(String.format("OPTIONS FOR DRIVER -------> %S were initialized", options.asMap()));
            return options;
        } catch (Exception ex) {
            throw new RuntimeException(String.format("Unable to create driver options: %s", ex));
        }
    }
}
