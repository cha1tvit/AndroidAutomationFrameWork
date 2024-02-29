package helpers.appium_services;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * AppiumDriverLocalService does not support the server management on non-local hosts
 * ONLY for local machine usage - for fast startup and debugging
 */
public class AppiumDriverLocalServiceHelper {

    private static Logger logger = LogManager.getLogger(AppiumDriverLocalServiceHelper.class);
    AppiumDriverLocalService service = AppiumDriverLocalService.buildDefaultService();

    public void startAppiumService() {
        try {
            service.start();
        } catch (RuntimeException ex) {
            logger.error(String.format("Unable to start APPIUM service: %s", ex));
        }

    }

    public void stopAppiumService() {
        try {
            service.stop();
        } catch (RuntimeException ex) {
            logger.error(String.format("Unable to stop APPIUM service: %s", ex));
        }
    }
}
