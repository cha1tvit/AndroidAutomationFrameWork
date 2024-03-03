package steps;

import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.When;
import locators.SampleListLocators;

public class SampleListPage extends BasePage{

    public SampleListPage(AndroidDriver driver) {
        super(driver);
    }

    @When("Page 'Simple list' is loaded")
    public void waitForPageLoaded() {
        webDriverHelper.awaitUntilElementBecomeVisible(getDriver(), SampleListLocators.samplesListHeader);
    }
}
