package tests;

import helpers.drivers.UiAutomator2Helper;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import lombok.Builder;
import lombok.Data;
import lombok.extern.log4j.Log4j2;

import static helpers.configs.ConfigLoaderHelper.PROJECT_PROPERTIES;

@Data
@Log4j2
public class BaseTest {

    AndroidDriver androidDriver;
    UiAutomator2Helper uiAutomator2Helper = new UiAutomator2Helper();
    UiAutomator2Options options = uiAutomator2Helper.getUiAutomator2Options(PROJECT_PROPERTIES.apkLocalPath());

    @BeforeAll
    public void initEmulator()
    {
        if(null != androidDriver)
        {
            androidDriver = uiAutomator2Helper.getDriver(PROJECT_PROPERTIES.appiumLocalHost(), options);
        }
    }
}
