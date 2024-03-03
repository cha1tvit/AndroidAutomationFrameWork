package steps;

import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import locators.LoginLocators;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginPage extends BasePage {

    public LoginPage(AndroidDriver driver) {
        super(driver);
    }

    @Given("Set user credentials username - {string}, password -{string}")
    public void setUserCredentials(String userName, String password) {
        setUserName(userName);
        setPassword(password);
    }

    @Given("Click button login")
    public void clickButtonLoginToApp() {
        WebElement el = getDriver().findElement(LoginLocators.logInButton);
        el.click();
        webDriverHelper.awaitUntilElementBecomeHidden(getDriver(), el);
    }

    @Then("Click button 'Submit message'")
    public void clickButtonSubmit() {
        getDriver().findElement(LoginLocators.submitMessageButton).click();
        webDriverHelper.awaitUntilElementBecomeHidden(getDriver(), getDriver().findElement(LoginLocators.submitMessageButton));
    }

    @When("Wait for block 'Message' available")
    public void waitForMessageDialogPresent() {
        webDriverHelper.awaitUntilElementBecomeVisible(getDriver(), LoginLocators.message);
    }

    @When("Verify presence block login form by condition {boolean}")
    public void verifyPresenceLoginForm(boolean isLoginFormAvailable) {
        assertEquals(isLoginFormAvailable, webDriverHelper.isElementVisible(getDriver(), LoginLocators.logInButton),
                "Availability block 'Login Form' is not as expected");
    }

    @When("Click button 'LOG IN'")
    public void clickButtonBack() {
        WebElement el = getDriver().findElement(LoginLocators.backButton);
        el.click();
        webDriverHelper.awaitUntilElementBecomeHidden(getDriver(), el);
    }

    @And("Set user name {string}")
    public void setUserName(String userName) {
        getDriver().findElement(LoginLocators.username).sendKeys(userName);
    }

    @And("Set password {string}")
    public void setPassword(String password) {
        getDriver().findElement(LoginLocators.password).sendKeys(password);
    }

    @Then("Verify presence message {boolean}")
    public void verifyErrorMessagePresence(boolean isAvailable) {
        WebElement notificationPanel = getDriver().findElement(LoginLocators.notificationPanel);
        assertEquals(isAvailable, notificationPanel.isDisplayed(), "Notification message availability condition is not as expected");
    }
}
