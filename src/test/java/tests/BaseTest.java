package tests;

import helpers.drivers.UiAutomator2Helper;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import lombok.Data;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

import java.io.IOException;

import static helpers.configs.ConfigLoaderHelper.PROJECT_PROPERTIES;

@Data
@Log4j2
public class BaseTest {

    public static AndroidDriver androidDriver;
    private static UiAutomator2Helper uiAutomator2Helper = new UiAutomator2Helper();
    private static UiAutomator2Options options = uiAutomator2Helper.getUiAutomator2Options(PROJECT_PROPERTIES.apkLocalPath());

    @BeforeAll
    public static void initEmulator() {
        initDriver();
    }

    @AfterAll
    public static void shutDownEmulator() {
        closeDriver();
    }

    public static void initDriver()
    {
        log.info("-----> Create instance of device");
        if (null == androidDriver) {
            androidDriver = uiAutomator2Helper.initDriverInstance(PROJECT_PROPERTIES.appiumLocalHost(), options);
        }
    }

    public static void closeDriver()
    {
        log.info("-----> Close instance of device");
        if (null != androidDriver) {
            androidDriver.quit();
        }
    }

    @Before("@ui")
    public void setupForUI() {
        initDriver();
    }

    @After("@ui")
    public void tearDownForUi(Scenario scenario) throws IOException {
        closeDriver();
    }
}
